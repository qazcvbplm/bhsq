package com.medusa.bhsq.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.medusa.bhsq.dao.ShipMapper;
import com.medusa.bhsq.entity.Article;
import com.medusa.bhsq.util.AjaxUtil;
import com.medusa.bhsq.util.FileUp;
import com.medusa.bhsq.util.Result;
import com.medusa.bhsq.util.Util;
import com.medusa.bhsq.wxentity.ArticleDetail;
import com.medusa.bhsq.wxentity.Index;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private ShipMapper shipMapper;	
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
    
    
    /*
     * 小程序首页方法
     */
    @RequestMapping("wx/index")
    public void wxindex(HttpServletResponse rep){
    	//今日头条
    	String st=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    	String et=Util.getSpecifiedDayAfter(st);
    	Map<String,Object> map=new HashMap<String,Object>();
    	map.put("st", st);
    	map.put("et", et);
    	List<Article> daytop=articleMapper.daytop(map);
    	//热门推荐
    	Map<String,Object> map2=new HashMap<String,Object>();
    	map2.put("begin", 0);
    	map2.put("end", 3);
    	map2.put("ob", "visitor");
    	map2.put("type", Result.ARTICLE+"");
    	List<Article> rmtj=articleMapper.top(map2);
    	//大家都在聊
    	Map<String,Object> map3=new HashMap<String,Object>();
    	map3.put("begin", 0);
    	map3.put("end", 6);
    	map3.put("ob", "rep");
    	map3.put("type", Result.ARTICLE+"");
    	List<Article> dj=articleMapper.top(map3);
    	settime(daytop);
    	settime(rmtj);
    	settime(dj);
    	Index index=new Index(daytop,dj,rmtj);
    	AjaxUtil.PrintArrayClass(rep, index);
    	
    }
    
    /*
     * 文章详情方法
     */
    @RequestMapping("wx/articledetail")
    public void articledetail(HttpServletResponse rep,int id,int userid){
              Article a=articleMapper.findbyid(id);
              Article temp=new Article();
              temp.setVisitor(a.getVisitor()+1);
              temp.setId(id);
              //增加访问量
              articleMapper.updateByPrimaryKeySelective(temp);
              boolean scb=true;
              boolean gzb=true;
              boolean zanb=true;
              Map<String,Object> map=new HashMap<String, Object>();
	          map.put("type", Result.ZAN);
	    	  map.put("articleid", id);
	    	  map.put("userid", userid);
	    	  //查询文章我是否赞过
    		  int zan=shipMapper.findshipcount(map);
    		  if(zan==0)
    		  zanb=false;
    		  //查询所有回复
    		  List<Article> replace=new ArrayList<Article>();
              List<Article> re=articleMapper.findreplace(id);
              dj(re,userid,replace);
              Collections.sort(replace, new Comparator<Article>() {
				public int compare(Article o1, Article o2) {
					return o1.getTime().compareTo(o2.getTime());
				}
              });
              //查询我是否收藏
              Map<String,Object> map2=new HashMap<String, Object>();
              map2.put("type", Result.SC);
              map2.put("articleid", a.getId());
              map2.put("userid", userid);
              int sc=shipMapper.findshipcount(map2);
              if(sc==0)
              scb=false; 
              //查询我是否关注
              Map<String,Object> map3=new HashMap<String, Object>();
              map3.put("type", Result.GZ);
              map3.put("articleid", a.getUserid());
              map3.put("userid", userid);
              int gz=shipMapper.findshipcount(map3);
              if(gz==0)
              gzb=false;
              List<Article> aa=new ArrayList<Article>();
              aa.add(a);
              settime(aa);
              settime(replace);
              ArticleDetail rs=new ArticleDetail(a, replace,zanb,scb,gzb);
              AjaxUtil.PrintArrayClass(rep, rs);
    }
    
    private void dj(List<Article> re,int userid,List<Article> replace) {
    	Map<String,Object> temp2=new HashMap<String, Object>();
        for(int i=0;i<re.size();i++)
        {
      	  temp2.clear();
      	  temp2.put("type", Result.ZAN);
      	  temp2.put("articleid", re.get(i).getId());
      	  temp2.put("userid",userid);
      	  if(shipMapper.findshipcount(temp2)>0)
      		  re.get(i).setFzan(true);
      	  replace.add(re.get(i));
      	  List<Article> d=articleMapper.findreplace(re.get(i).getId());
      	  if(d.size()>0)
      	  dj(d,userid,replace);
        }
		
	}


	//小程序回复文章或者回复回复的方法
    @RequestMapping("wx/replace")
    public void wxreplace(HttpServletResponse rep,int aid,int uid,String title,int typ){
    	   Article a=new Article();
    	   a.setParent(aid);
    	   a.setUserid(uid);
    	   a.setTitle(title);
    	   a.setType(typ);
    	   a.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    	   if(typ==Result.REPLACE)
    		   a.setText("楼主");
    	   if(typ==Result.REPLACE_REPLACE)
    	   {
    		   a.setText(articleMapper.findbyid(aid).getTitle());
    	   }
    	   int rs=Result.SUCCESS;
    	   try {
			articleMapper.insert(a);
		} catch (Exception e) {
			rs=Result.ERROR;
			e.printStackTrace();
		}
    	AjaxUtil.Print(rep, rs+"");
    }
    //将时间转换的方法
    public void settime(List<Article> list){
    	SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	for(int i=0;i<list.size();i++)
    	{
    		try {
    			long now=new Date().getTime();
				long fb=sf.parse(list.get(i).getTime()).getTime();
				long cha=now-fb;
				int c=(int) (cha/1000/60/60);
				
				if(c<24&&c>1)
				{
					list.get(i).setTime(c+"小时前");
				}else if(c>=24)
				{
					int day=c/24;
					list.get(i).setTime(++day+"天前");
				}else if(c<1&&c>0){
					int m=c*60;
					list.get(i).setTime(++m+"分钟前");				
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	}
    	
    }
}
