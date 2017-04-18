package com.medusa.bhsq.dubbo.dao;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface FileUpDao {
    public String up(String filename,String dir,InputStream inputStream);
}
