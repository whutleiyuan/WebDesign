package com.ly.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	/**
	 * 设置Cookie
	 * @author leiyuan
	 * @param response
	 * @param name cookie名字
	 * @param value cookie值
	 * @param maxAge cookie生命周期
	 */
	public static void addCookie(HttpServletResponse response,String name,String value,int maxAge){
		Cookie cookie=new Cookie(name,value);
		if(maxAge>0){
			cookie.setMaxAge(maxAge);
		}
		response.addCookie(cookie);
	}
	
	/**
	 * 将cookie封装到Map里
	 * @author leiyuan
	 * @param request
	 * @return
	 */
	public static Map<String,Cookie> putCookieMap(HttpServletRequest request){
		Map<String,Cookie> cookieMap=new HashMap<String,Cookie>();
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie c:cookies){
				cookieMap.put(c.getName(),c);
			}
		}
		
		return cookieMap;
		
	}
	
	/**
	* 根据名字获取cookie（接口方法）
	* @param request
	* @param name cookie名字
	* @return
	*/
	public static Cookie getCookieByName(HttpServletRequest request,String name){
	Map<String,Cookie> cookieMap = putCookieMap(request);
	if(cookieMap.containsKey(name)){
	  Cookie cookie = (Cookie)cookieMap.get(name);
	  return cookie;
	}else{
	  return null;
	} 
	}

}
