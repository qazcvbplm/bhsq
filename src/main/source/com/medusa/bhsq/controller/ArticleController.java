package com.medusa.bhsq.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.medusa.bhsq.dao.ArticleMapper;
import com.medusa.bhsq.dao.PlateMapper;
import com.medusa.bhsq.entity.Article;
import com.medusa.bhsq.util.AjaxUtil;
import com.medusa.bhsq.util.FileUp;
import com.medusa.bhsq.util.Result;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private PlateMapper plateMapper;
	
	
	/*
	 * 后台管理增加文章
	 */
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
					String rs=FileUp.UpFile(pic[i], req, "upload", i+"");
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
		a.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		articleMapper.insert(a);
		return articlelist(req);
	}
	
	
	/*
	 * 后台管理更新文章
	 */
	@RequestMapping("articleupdate")
	public String articleupdate(HttpServletRequest req,@Validated Article a,BindingResult result,@RequestParam(required=false)MultipartFile[] pic){
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
				String ylimage[]=a.getImage().split(",");
			for(int i=0;i<pic.length;i++)
			{
				if(!pic[i].isEmpty())
				{
					String rs=FileUp.UpFile(pic[i], req, "upload", i+"");
					if(rs==null)
					{
						return "redirect:addarticle.jsp";
					}else
					{
						image+=rs+",";
					}
				}else
				{
					//判断原来是否有图片
					if(ylimage.length>i)
					{
						image+=ylimage[i]+",";
					}
				}
			}
		a.setImage(image);
		articleMapper.updateByPrimaryKeySelective(a);
		return articlelist(req);
	}
	
	
	/*
	 * 后台文章列表
	 */
    @RequestMapping("articlelist")
    public String articlelist(HttpServletRequest req){
    	List<Article> list=articleMapper.findbytype(Result.ARTICLE);
    	for(int i=0;i<list.size();i++)
    	{
    		Article temp=list.get(i);
    		temp.setPlate(plateMapper.findbyid(temp.getParent()));
    		String[] images=temp.getImage().split(",");
    		for(int j=0;j<images.length;j++)
    		{
    			
    			if(images[j].length()>5)
    			{
    				temp.getImagelist().add(images[j]);
    			}
    		}
    	}
    	req.getSession().setAttribute("alist", list);
    	return "redirect:articlelist.jsp";
    }
    
    
    /*
     * 后台删除文章/回复
     */
    @RequestMapping("articledelete")
    public void articledelete(HttpServletResponse rep,int id,HttpServletRequest req){
    	int rs=Result.SUCCESS;
    	Article a=articleMapper.findbyid(id);
		try {
			articleMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			rs=Result.ERROR;
			e.printStackTrace();
		}
		if(rs==Result.SUCCESS)
		{
			req.getSession().setAttribute("alist", articleMapper.findbytype(a.getType()));
			AjaxUtil.Print(rep, "1");
		}
		else
			AjaxUtil.Print(rep, "0");
    }
    
    
    /*
     * 查找文章
     */
    @RequestMapping("findbyid")
    public String findbyid(HttpServletRequest req,int id,int type){
    	Article rs=articleMapper.findbyid(id);
    	switch (type) {
		case Result.ARTICLE:
			rs.setPlate(plateMapper.findbyid(rs.getParent()));
			String[] images=rs.getImage().split(",");
    		for(int j=0;j<images.length;j++)
    		{
    			if(images[j]!=null)
    			{
    				rs.getImagelist().add(images[j]);
    			}
    		}
    		while(rs.getImagelist().size()<3){
    			  rs.getImagelist().add("1");
    		}
			break;
		case Result.REPLACE:
			rs.setArticle(articleMapper.findbyid(rs.getParent()));
			break;
		case Result.REPLACE_REPLACE:
			rs.setArticle(articleMapper.findbyid(rs.getParent()));
			break;
		}
    	req.getSession().setAttribute("article", rs);
    	return "redirect:editorarticle.jsp";
    }
}
