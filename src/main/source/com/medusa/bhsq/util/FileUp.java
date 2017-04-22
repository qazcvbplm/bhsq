package com.medusa.bhsq.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

public class FileUp {
	
	public static String UpFile(MultipartFile file,HttpServletRequest request,String dirname)
	{
		   int index=file.getOriginalFilename().lastIndexOf(".");
		   String postfix=file.getOriginalFilename().substring(index);
		   if(!postfix.equals(".jpg")&&!postfix.equals(".jpeg")&&!postfix.equals(".png")&&!postfix.equals(".bmp"))
		   {
			   request.getSession().setAttribute("error", "图片格式不正确");
			   return null;
		   }
		   String newname="u"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+postfix;
		   String newname2=newname.replace("u", "a");
		   String path=request.getSession().getServletContext().getRealPath("/");
		  // path="C:\\Users\\Administrator.hi\\Desktop\\Desktop\\hslp\\WebContent\\controller";//"C:\\Users\\Administrator\\Desktop\\wschool\\WebContent\\controller";
	       path+="/"+dirname;
		   File temp=new File(path);
		   File temp2=new File(path+"/"+newname);
		   File temp3=new File(path+"/"+newname2);
		   if(!temp.exists())
		   {
			   temp.mkdir();
		   }
		   try {
			file.transferTo(temp2);
			Thumbnails.of(temp2).scale(0.1).toFile(temp3);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dirname+"/"+newname;
	}
	
	public static String UpFile(MultipartFile file,HttpServletRequest request,String dirname,String s)
	{
		   if(file==null||file.isEmpty())
		   {
			   request.getSession().setAttribute("error", "图片不正确");
			   return null;
		   }
		   int index=file.getOriginalFilename().lastIndexOf(".");
		   String postfix=file.getOriginalFilename().substring(index);
		   if(!postfix.equals(".jpg")&&!postfix.equals(".jpeg")&!postfix.equals(".png")&&!postfix.equals(".bmp"))
		   {
			   request.getSession().setAttribute("error", "图片格式不正确");
			   return null;
		   }
		   String newname="u"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"-"+s+postfix;
		   String newname2=newname.replace("u", "a");
		   String path=request.getSession().getServletContext().getRealPath("/");
		  // path="C:\\Users\\Administrator.hi\\Desktop\\Desktop\\hslp\\WebContent\\controller";//"C:\\Users\\Administrator\\Desktop\\wschool\\WebContent\\controller";
	       path+="/"+dirname;
		   File temp=new File(path);
		   File temp2=new File(path+"/"+newname);
		   File temp3=new File(path+"/"+newname2);
		   if(!temp.exists())
		   {
			   temp.mkdir();
		   }
		   try {
			file.transferTo(temp2);
			Thumbnails.of(temp2).scale(0.1).toFile(temp3);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dirname+"/"+newname;
	}
	
	public static void Delete(HttpServletRequest request,String upload,String[] name){
		   String path=request.getSession().getServletContext().getRealPath("/");
		   path+=upload+"/";
		   for(int i=0;i<name.length;i++)
		   {
			   String file=path+name[i];
			   File f=new File(file);
			   if(f.exists()&&f.isFile())
			   {
				   f.delete();
			   }
		   }
	}

}
