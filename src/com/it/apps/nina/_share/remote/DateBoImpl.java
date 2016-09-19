package com.it.apps.nina._share.remote;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.it.common.component.check.group.ErrListDto;
import com.it.common.component.lang.date.DBTime;
import com.it.common.component.lang.date.DateUtil;
import com.it.common.component.lang.date.Lunar;
import com.it.common.component.lang.str.StrUtil;
import com.it.common.component.log.LogPrint;
import com.it.common.share.GlobalName;

@Repository
public class DateBoImpl implements DateBo{
	
	@Resource
	private DateMapper dateMapper;
	
	static String startYear = GlobalName.appResources.getString("startYear");
	
	/**
	 * 获得给用户的有效日期
	 * */
	public List<Integer> getYears(){
		int endYear = Integer.parseInt(DBTime.getInstance().getYYYY())+1;
		int stYear = 2015;
		try {
			stYear = Integer.parseInt(startYear.trim());
		} catch (Exception e) {
			e.printStackTrace();
			LogPrint.error(e.getMessage());
		}
		List<Integer> years = new ArrayList<Integer>();
		while(endYear>=stYear){
			years.add(endYear);
			endYear = endYear -1;
		}
		return years;
	}
	
	/**
	 * 获得输入日期dayNum之前的日期，考虑双休日和节假日
	 * */
	public String getAheadDay(String destineDay, String dayNum){
		String warningDay = "";
		if(StrUtil.isNotEmpty(dayNum) && StrUtil.isNotEmpty(destineDay)){
			try {
				List<HolidayDto> dbHs = dateMapper.getHolidays();
				int dm = Integer.parseInt(dayNum.trim());
				int pre = 0;
				while(isHoliday(destineDay, dbHs)>0){
					destineDay = DateUtil.changeDay(destineDay, -1);
					pre = 1;
				}
				dm = dm-pre>=0?dm-pre:0;
				String eDay = DateUtil.changeDay(destineDay, -dm);
				int numOfH = getHoliday(destineDay, -dm, dbHs);
				while(numOfH>0){
					String sDay = DateUtil.changeDay(eDay, -numOfH);
					numOfH = getHoliday(eDay, -numOfH, dbHs);
					eDay = sDay;
				}
				warningDay = eDay;
			} catch (Exception e) {
				e.printStackTrace();
				LogPrint.error(e.getMessage());
			}
		}
		return warningDay;
	}
	
	/**
	 * 获得输入日期dayNum之后的日期，考虑双休日和节假日
	 * */
	public String getDelayDay(String inputDay, int dayNum){
		String delayDay = "";
		if(StrUtil.isNotEmpty(dayNum) && StrUtil.isNotEmpty(inputDay)){
			try {
				List<HolidayDto> dbHs = dateMapper.getHolidays();
				int pre = 0;
				while(isHoliday(inputDay, dbHs)>0){
					inputDay = DateUtil.changeDay(inputDay, 1);
					pre = 1;
				}
				dayNum = dayNum-pre>=0?dayNum-pre:0;
				String eDay = DateUtil.changeDay(inputDay, dayNum);
				int numOfH = getHolidayAft(inputDay, dayNum, dbHs);
				while(numOfH>0){
					String sDay = DateUtil.changeDay(eDay, numOfH);
					numOfH = getHolidayAft(eDay, numOfH, dbHs);
					eDay = sDay;
				}
				delayDay = eDay;
			} catch (Exception e) {
				e.printStackTrace();
				LogPrint.error(e.getMessage());
			}
		}
		return delayDay;
	}
	
	private static int getHoliday(String day, int dayNum, List<HolidayDto> dbHs){
		int numOfH = 0;
		for(int i=0; i>dayNum; i--){
			numOfH += isHoliday(DateUtil.changeDay(day, i-1), dbHs);
		}
		return numOfH;
	}
	
	private static int getHolidayAft(String day, int dayNum, List<HolidayDto> dbHs){
		int numOfH = 0;
		for(int i=0; i<dayNum; i++){
			numOfH += isHoliday(DateUtil.changeDay(day, i+1), dbHs);
		}
		return numOfH;
	}
	
	private static int isHoliday(String day, List<HolidayDto> dbHs){
		int rtn = 0;
		boolean addUp = true;
		if(dbHs!=null){
			String lunarDay = new Lunar(day).getYyyyMMdd();
			for(HolidayDto h : dbHs){
				if("1".equals(h.getLunarType()) && lunarDay.substring(4).equals(h.getMonthDay())){
					rtn++;
					if("2".equals(h.getAddUp())) addUp=false;
				}else if(day.substring(4).equals(h.getMonthDay())){
					if("2".equals(h.getAddUp())) addUp=false;
					rtn++;
				}
			}
		}
		Calendar date = DateUtil.getDate(day, "yyyyMMdd");
		int dayOfWeek = date.get(Calendar.DAY_OF_WEEK); 
		if(dayOfWeek==Calendar.SATURDAY||dayOfWeek==Calendar.SUNDAY){
			if(addUp) rtn++;
		}
		return rtn;
	}
	
	public boolean allowAdd(String inoutDay, int delayNum, ErrListDto err){
		boolean rtn = true;
			if(StrUtil.isNotEmpty(inoutDay)){
				if(DBTime.getInstance().getDay().compareTo(this.getDelayDay(inoutDay, delayNum))>0){
					rtn = false;
					err.add("99050");
				}
			}
		
		return rtn;
	}
	
	public boolean isLegalHoliday(String day){
		if(StrUtil.isNotEmpty(day)){
			List<HolidayDto> dbHs = dateMapper.getHolidays();
			for(HolidayDto h : dbHs){
				if("1".equals(h.getLegalType())){
					if("1".equals(h.getLunarType())){
						String lunarDay = new Lunar(day).getYyyyMMdd();
						if(lunarDay.substring(4).equals(h.getMonthDay())) return true;
					}else if(day.substring(4).equals(h.getMonthDay())) return true;
				}
			}
		}
		return false;
	}
	

}
