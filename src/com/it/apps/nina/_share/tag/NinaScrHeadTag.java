package com.it.apps.nina._share.tag;

import javax.servlet.http.HttpServletRequest;

import com.it.apps.nina._share.bo.NinaSystemDto;
import com.it.common.component.meta.tag.ScrHeadTag;

public class NinaScrHeadTag extends ScrHeadTag {

	public static final String MENU_ID_NAME ="ninaMenuId";
	
	public static final String SYSTEM_DTO_NAME = "S";
	
	public static final String PRODUCT_DIR = "/nina/";
	
	private static final long serialVersionUID = -3495975496647520068L;

	private String land;
	
	private String menuId;
	
	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	@Override
	protected String getSrc(String webRoot) {
		String src = super.getSrc(webRoot);
		NinaSystemDto so = NinaSystemDto.getInstance((HttpServletRequest)this.pageContext.getRequest());
		String imageUrl = so!=null?so.getImageUrl():webRoot+PRODUCT_DIR+"image/";
		src += "<link href=\""+webRoot+PRODUCT_DIR+"css/surface.css\" rel=\"stylesheet\">"+ 
		       "<link href=\""+webRoot+PRODUCT_DIR+"css/navigator.css\" rel=\"stylesheet\">"+ 
			   "<script src=\""+webRoot+PRODUCT_DIR+"js/surface.js\"></script>"+ 
		       "<link rel=\"shortcut icon\" href=\""+imageUrl+"favicon.ico\">"+ 
			   "<link rel=\"Bookmark\" href=\""+imageUrl+"favicon.ico\">";
		if(land!=null && land.trim().length()>0){
			src += "<link href=\""+webRoot+PRODUCT_DIR+"css/"+land+".css\" rel=\"stylesheet\">";
		}
		this.pageContext.setAttribute(MENU_ID_NAME, menuId);
		this.pageContext.setAttribute("bg_land", land);
		return src;
	}
	
	/*protected String getScript(){
		String script = "<script type=\"text/javascript\"> "
				+ "$(function() {"
					+ "$('.container').eq(1).height(getContentHeight(0, 0)).addClass('scroll-y');"
				+ "});"
			   + "</script>";	
		return script;
	}*/

}
