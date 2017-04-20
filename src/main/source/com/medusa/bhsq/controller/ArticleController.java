package com.medusa.bhsq.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.rpc.Result;
import com.medusa.bhsq.dao.ArticleMapper;
import com.medusa.bhsq.entity.Article;
import com.medusa.bhsq.util.FileUp;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleMapper articleMapper;
	
	@RequestMapping("articleadd")
	public String articleadd(HttpServletRequest req,@Validated Article a,BindingResult result,@RequestParam(required=false)MultipartFile[] pic){
		//数据验证
				if(result.hasErrors())
				{
					List<ObjectError> list=result.getAllErrors();
					for(ObjectError error:list)
					{
						req.getSession().setAttribute("error", error.getDefaultMessage());
						return "redirect:addarticle.jsp";
					}
				}
		//数据验证
				String image="";
			for(int i=0;i<pic.length;i++)
			{
				if(!pic[i].isEmpty())
				{
					String rs=FileUp.UpFile(pic[i], req, "upoad", i+"");
					if(rs==null)
					{
						return "redirect:addarticle.jsp";
					}else
					{
						image+=rs+",";
					}
				}else
				{
					if(i==0)
					{
						req.getSession().setAttribute("error", "封面图片必须至少一张");
						return "redirect:addarticle.jsp";
					}
				}
			}
		a.setUserid(0);
		a.setImage(image);
		a.setType(com.medusa.bhsq.util.Result.ARTICLE);
		articleMapper.insert(a);
		return "";
	}

}
