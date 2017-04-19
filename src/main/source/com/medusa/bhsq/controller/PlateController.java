package com.medusa.bhsq.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.medusa.bhsq.dubbo.dao.FileUpDao;
import com.medusa.bhsq.entity.Plate;


@Controller
public class PlateController {

	@Autowired
	private FileUpDao fileUpDao;
	@RequestMapping("plateadd")
	public String plateadd(HttpServletRequest req,Plate p,MultipartFile pic){
		
		return "redirect:platelist.jsp";
	}
}
