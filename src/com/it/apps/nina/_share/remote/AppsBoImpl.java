package com.it.apps.nina._share.remote;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.it.common.component.log.LogPrint;

@Repository
public class AppsBoImpl implements AppsBo {
	
	@Resource
	private AppsMapper appsMapper;
	
	private ThreadLocal<List<AppDto>> tl = new ThreadLocal<>();

	@Override
	public String getBaseUrl() {
		return getAppUrl(1l);
	}
	
	@Override
	public String getImageUrl(){
		return getAppUrl(-1l);
	}
	
	public String getAppUrl(Long appId) {
		for(AppDto dto : this.getApps()){
			if(appId.equals(dto.getAppId())){
				LogPrint.debug("app_id="+appId+ " app_url="+dto.getAppUrl());
				return dto.getAppUrl();
			}
		}
		LogPrint.error("app_id="+appId+ " app_url is not found.");
		return "";
	}

	@Override
	public List<AppDto> getApps() {
		if(tl.get()==null){
			tl.set(appsMapper.getApps());
		}
		return tl.get();
	}
	
	/*public <T> T getMapper(Class<T> mapperCls){
		SqlSession sqlSession = null;
		try {
			sqlSession = ((DefaultSqlSessionFactory)SpringBeanStore.getBean("sqlSessionFactory")).openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
        try {
        	return sqlSession.getMapper(mapperCls);
        } finally {
            sqlSession.close();
        }
	}*/

}
