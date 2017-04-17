package com.medusa.bhsq.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class AjaxUtil {
	    private static PrintWriter out;
	
	
 
        
        public static void Print(HttpServletResponse response,String result)
        {
        	try {
				out=response.getWriter();
				out.print(result);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				out.close();
			}
        }
        
  
        
        public static void PrintArrayClass(HttpServletResponse response,Object obj)
        {
        	  response.setContentType("text/xml;charset=utf-8");   
        	try {
				PrintWriter out=response.getWriter();
				Gson gson=new Gson();
				String array=gson.toJson(obj);
				out.print(array);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        
        public static void PrintJson(HttpServletResponse response,JsonObject result)
        {
        	try {
				out=response.getWriter();
				out.print(result);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				out.close();
			}
        }
        
        
}
