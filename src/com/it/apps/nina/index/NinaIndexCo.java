package com.it.apps.nina.index;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.apps.nina._share.bo.NinaSystemDto;
import com.it.apps.nina._share.remote.SystemDtoBoImpl;
import com.it.common.component.check.group.ErrListDto;
import com.it.common.component.lang.str.StrUtil;
import com.it.common.component.meta.co.BaseCo;
@Controller
public class NinaIndexCo extends BaseCo{
	
	@Resource
	private NinaIndexBo ninaIndexBo;
	
	@RequestMapping(value="login.do")
	public String login(HttpServletRequest request,HttpServletResponse response){
		
		return "index";
	}
	
	@RequestMapping(value="loginCheck.do")
	public String loginCheck(HttpServletRequest request,HttpServletResponse response){
		String loginnm = StrUtil.trimB(request.getParameter("loginNm"));
		String password = StrUtil.trimB(request.getParameter("password"));
		ErrListDto errListDto = super.getErrList(request);
		boolean noErr = ninaIndexBo.chkUser(loginnm,password);
		NinaSystemDto no = new NinaSystemDto();
		
		if(noErr){
			String md5pass = StrUtil.md5Digest(password);
			IndexUserDto indexUserDto = (IndexUserDto) ninaIndexBo.getIndexUserDto(loginnm);			
			if(indexUserDto!=null && md5pass.equals(indexUserDto.getPassword())){
				no = ninaIndexBo.readSystemDto(loginnm, request.getSession().getId());
				//request.setAttribute(request.getSession().getId(), no);
				SystemDtoBoImpl.addSystemDto(request.getSession().getId(), no);
				return "main";
			}request.setAttribute("errInfor", "用户名和密码错误!");
			
		}
		errListDto.add("99013");
		return "index";
		
	}
	
	@RequestMapping(value="logout.do")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		SystemDtoBoImpl.delSystemDto(request.getSession().getId());
		request.getSession().invalidate();
		//遍历每个app的session，清空它们的systemDto
		//request.getSession().removeAttribute(GlobalName.SYSTEMDTO_NAME);
		return "index";
	}
	
	
}
