package com.medusa.bhsq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medusa.bhsq.dao.UserMapper;
import com.medusa.bhsq.entity.User;
import com.medusa.bhsq.util.AjaxUtil;

@Controller
public class UserController {
	
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
}
