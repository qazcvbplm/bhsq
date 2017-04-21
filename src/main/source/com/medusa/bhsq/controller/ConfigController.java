package com.medusa.bhsq.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.medusa.bhsq.dao.ConfigMapper;
import com.medusa.bhsq.entity.Config;
import com.medusa.bhsq.util.FileUp;

@Controller
public class ConfigController {
	
	@Autowired
	private ConfigMapper configMapper;
	

	@RequestMapping("configupdatelbt.do")
	public String updatelbt(HttpServletRequest req,@RequestParam(required=false) MultipartFile[] pic){
		Config c=configMapper.find();
		String s="";
		String q="";
		String simage[]=c.getSimage().split(",");
		String qimage[]=c.getQimage().split(",");
        for(int i=0;i<pic.length;i++)
        {
        	if(!pic[i].isEmpty())
        	{
        		String rs=FileUp.UpFile(pic[i], req, "upload", i+"");
        		if(rs==null)
        		{
        			req.getSession().setAttribute("error", "某张图片上传失败");
        			return "redirect:index.jsp";
        		}else
        		{
        			if(i<=2)
        			{
        				s+=rs+",";
        			}else
        			{
        				q+=rs+",";
        			}
        		}
        	}else
        	{
        		if(i<=2)
    			{
    				s+=simage[i]+",";
    			}else
    			{
    				q+=qimage[i-3]+",";
    			}
        	}
        }
        c.setSimage(s);
        c.setQimage(q);
        configMapper.updateByPrimaryKeySelective(c);
        req.getSession().setAttribute("config", c);
		return "redirect:index.jsp";
	} 
}
