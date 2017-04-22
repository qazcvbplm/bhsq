package com.medusa.bhsq.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medusa.bhsq.dao.ShipMapper;
import com.medusa.bhsq.entity.Ship;
import com.medusa.bhsq.util.AjaxUtil;
import com.medusa.bhsq.util.Result;

@Controller
public class ShipController {

	@Autowired
	private ShipMapper shipMapper;
	
	
	@RequestMapping("wx/zan")
	private void zan(HttpServletResponse rep,int userid ,int aid){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("type", Result.ZAN);
		map.put("articleid", aid);
		map.put("userid", userid);
		int count=shipMapper.findshipcount(map);
		if(count==0)
		{
			//开始增加赞的记录
			Ship ship=new Ship();
			ship.setArticleid(aid);
			ship.setUserid(userid);
			ship.setType(Result.ZAN);
			shipMapper.insert(ship);
			AjaxUtil.Print(rep, Result.SUCCESS+"");
		}else
		{
			AjaxUtil.Print(rep, Result.ERROR+"");
		}
		
        		
	}
	
	
	@RequestMapping("wx/sc")
	private void sc(HttpServletResponse rep,int userid ,int aid){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("type", Result.SC);
		map.put("articleid", aid);
		map.put("userid", userid);
		int count=shipMapper.findshipcount(map);
		if(count==0)
		{
			//开始增加收藏的记录
			Ship ship=new Ship();
			ship.setArticleid(aid);
			ship.setUserid(userid);
			ship.setType(Result.SC);
			shipMapper.insert(ship);
			AjaxUtil.Print(rep, Result.SUCCESS+"");
		}else
		{
			AjaxUtil.Print(rep, Result.ERROR+"");
		}
		
        		
	}
	
	@RequestMapping("wx/gz")
	private void gz(HttpServletResponse rep,int userid ,int aid){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("type", Result.GZ);
		map.put("articleid", aid);
		map.put("userid", userid);
		int count=shipMapper.findshipcount(map);
		if(count==0)
		{
			//开始增加收藏的记录
			Ship ship=new Ship();
			ship.setArticleid(aid);
			ship.setUserid(userid);
			ship.setType(Result.GZ);
			shipMapper.insert(ship);
			AjaxUtil.Print(rep, Result.SUCCESS+"");
		}else
		{
			AjaxUtil.Print(rep, Result.ERROR+"");
		}
		
        		
	}
}
