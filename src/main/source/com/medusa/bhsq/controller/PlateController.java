package com.medusa.bhsq.controller;

import java.io.IOException;

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
		String rs;
		try {
			rs = fileUpDao.up(pic.getOriginalFilename(), "upload/", pic.getInputStream());
			if(rs!=null)
			{
				p.setImage(rs);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:platelist.jsp";
	}
}
