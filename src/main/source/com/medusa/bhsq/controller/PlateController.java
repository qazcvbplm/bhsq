package com.medusa.bhsq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.medusa.bhsq.dao.PlateMapper;
import com.medusa.bhsq.dubbo.dao.FileUpDao;
import com.medusa.bhsq.entity.Plate;
import com.medusa.bhsq.util.AjaxUtil;
import com.medusa.bhsq.util.Result;


@Controller
public class PlateController {

	@Autowired
	private FileUpDao fileUpDao;
	@Autowired
	private PlateMapper plateMapper;
	/*
	 * 添加板块
	 */
	@RequestMapping("plateadd")
	public String plateadd(HttpServletRequest req,@Validated Plate p,BindingResult result,MultipartFile pic){
		//数据验证
		if(result.hasErrors())
		{
			List<ObjectError> list=result.getAllErrors();
			for(ObjectError error:list)
			{
				req.getSession().setAttribute("error", error.getDefaultMessage());
				return "redirect:plateadd.jsp";
			}
		}
		//数据验证
		String rs=null;
		try {
			rs = fileUpDao.up(pic.getOriginalFilename(), "upload/", pic.getInputStream());
			if(rs!=null)
			{
				p.setImage(rs);
				plateMapper.insert(p);
			}else
			{
				req.getSession().setAttribute("error", "图片上传失败");
				return "redirect:plateadd.jsp";
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return platelist(req);
	}
	
	
	/*
	 * 后台板块列表
	 */
	@RequestMapping("platelist")
	public String platelist(HttpServletRequest req){
		req.getSession().setAttribute("plist", plateMapper.findall());
		return "redirect:platelist.jsp";
	}
	
	/*
	 * 后台板块列表ajax
	 */
	@RequestMapping("platelistajax")
	public void platelistajax(HttpServletResponse rep){
		AjaxUtil.PrintArrayClass(rep, plateMapper.findall());
	}
	

	/*
	 * 后台板块的修改之前查询
	 */
	@RequestMapping("plateupdatef")
	public String plateupdatef(HttpServletRequest req,int id){
		req.getSession().setAttribute("plate", plateMapper.selectByPrimaryKey(id));
		return "redirect:plateeditor.jsp";
	}
	
	/*
	 * 后台板块的修改
	 */
	@RequestMapping("plateupdate")
	public String plateupdate(HttpServletRequest req,@Validated Plate p,BindingResult result,@RequestParam(required=false) MultipartFile pic){
		//数据验证
		if(result.hasErrors())
		{
			List<ObjectError> list=result.getAllErrors();
			for(ObjectError error:list)
			{
				req.getSession().setAttribute("error", error.getDefaultMessage());
				return "redirect:plateeditor.jsp";
			}
		}
		//数据验证
		//验证图片
		if(pic!=null&&!pic.isEmpty())
		{
			String rs=null;
			try {
				rs = fileUpDao.up(pic.getOriginalFilename(), "upload/", pic.getInputStream());
				if(rs!=null)
				{
					p.setImage(rs);
					
				}else
				{
					req.getSession().setAttribute("error", "图片上传失败");
					return "redirect:plateeditor.jsp";
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//验证图片
		if(plateMapper.updateByPrimaryKeySelective(p)==Result.SUCCESS)
		return platelist(req);
		else
		{
			req.getSession().setAttribute("error", "更新失败");
			return "redirect:plateeditor.jsp";
		}
	}
	
	/*
	 * 后台板删除
	 */
	@RequestMapping("platedelete")
	public void platedelete(HttpServletResponse rep,int id,HttpServletRequest req){
		int rs=Result.SUCCESS;
		try {
			plateMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			rs=Result.ERROR;
			e.printStackTrace();
		}
		if(rs==Result.SUCCESS)
		{
			req.getSession().setAttribute("plist", plateMapper.findall());
			AjaxUtil.Print(rep, "1");
		}
		else
			AjaxUtil.Print(rep, "0");
	}
}
