package com.medusa.bhsq.wxentity;

import java.util.List;

import com.medusa.bhsq.entity.Article;

public class ArticleDetail {
   private Article a;
   private List<Article> replace;
   private boolean zan;
   private boolean sc;
   private boolean gz;
   
   
   

	
	public ArticleDetail(Article a, List<Article> replace, boolean zan, boolean sc, boolean gz) {
	super();
	this.a = a;
	this.replace = replace;
	this.zan = zan;
	this.sc = sc;
	this.gz = gz;
}
	public boolean isZan() {
	return zan;
}
public void setZan(boolean zan) {
	this.zan = zan;
}
	public boolean isSc() {
		return sc;
	}
	public void setSc(boolean sc) {
		this.sc = sc;
	}
	public boolean isGz() {
		return gz;
	}
	public void setGz(boolean gz) {
		this.gz = gz;
	}
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
