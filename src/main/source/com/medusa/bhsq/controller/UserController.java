package com.medusa.bhsq.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medusa.bhsq.entity.User;
import com.medusa.bhsq.util.AjaxUtil;

@Controller
public class UserController {

	@RequestMapping("test")
	public void login(HttpServletResponse rep){
		AjaxUtil.PrintArrayClass(rep, new User());
	}
}
