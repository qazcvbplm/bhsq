package com.medusa.bhsq.wxentity;

import java.util.List;

import com.medusa.bhsq.entity.Article;

public class ArticleDetail {
   private Article a;
   private List<Article> replace;
	public Article getA() {
		return a;
	}
	public void setA(Article a) {
		this.a = a;
	}
	public List<Article> getReplace() {
		return replace;
	}
	public void setReplace(List<Article> replace) {
		this.replace = replace;
	}
	public ArticleDetail(Article a, List<Article> replace) {
		super();
		this.a = a;
		this.replace = replace;
	}
   
   
}
