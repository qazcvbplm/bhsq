package com.medusa.bhsq.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.medusa.bhsq.dao.UserMapper;
import com.medusa.bhsq.entity.User;
import com.medusa.bhsq.util.AjaxUtil;
import com.medusa.bhsq.util.HTTPParam;
import com.medusa.bhsq.util.HTTPSend;
import com.medusa.bhsq.util.Result;

@Controller
public class UserController {
	private  final String appid="wxa75115dccbe8ecec";//wx750e248ada94beee,wxa75115dccbe8ecec
	private  final String secert="193c497589ddb70f1953f685cc1199c9";//20c81253f1895ef460edea93e864e50c,193c497589ddb70f1953f685cc1199c9
	private  String js_code="";
	private  String url="https://api.weixin.qq.com/sns/jscode2session?appid=";
	public   static String session_key="";
	public   static Map<String,Map<String,Object>> map=new HashMap<String,Map<String,Object>>();
	private  final static String locationurl="http://api.map.baidu.com/geocoder/v2/?ak=btsVVWf0TM1zUBEbzFz6QqWF";
	
	
	@Autowired
	private UserMapper userMapper;
	/*
	 * 后台查询用户
	 */
	@RequestMapping("userlist")
	public String userlist(HttpServletRequest req){
		req.getSession().setAttribute("ulist", userMapper.findall());
		return "redirect:userlist.jsp";
	}
	
	
	@RequestMapping("wx/login")
	public void wxlogin(String code,HttpServletResponse rep,String name,String head)
	{
		this.js_code=code;
		Gson gson=new Gson();
		String nurl=url+appid+"&secret="+secert+"&js_code="+js_code+"&grant_type=authorization_code";
		HTTPSend send=new HTTPSend();
		try {
			String rs=send.sendGet(nurl, new ArrayList<HTTPParam>());
			JsonObject json=gson.fromJson(rs, JsonObject.class);
			if(json.get("openid")==null)
			{
				//
			}
			else
			{
				String openids=json.get("openid").toString();
				session_key=json.get("session_key").toString();
				openids=openids.replace("\"", "");
				List<User> list=userMapper.findbyopenid(openids);
				User u;
				if(list.size()==0)
				{
					//第一次登陆
					u=new User();
					u.setOpenid(openids);
					u.setHead(head);
					u.setName(name);
					userMapper.insert(u);
				}else
				{
					//
					u=list.get(0);
				}
					AjaxUtil.PrintArrayClass(rep, u);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
