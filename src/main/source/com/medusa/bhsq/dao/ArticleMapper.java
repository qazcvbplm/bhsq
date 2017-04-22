package com.medusa.bhsq.dao;

import java.util.List;
import java.util.Map;

import com.medusa.bhsq.entity.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article findbyid(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    
    List<Article> findbytype(int type);
    
    List<Article> daytop(Map<String,Object> map);
    
    List<Article> top(Map<String,Object> map);
    
    List<Article> findreplace(int id);
    List<Article> findbyuser(int id);
}