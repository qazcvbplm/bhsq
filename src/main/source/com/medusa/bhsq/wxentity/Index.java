package com.medusa.bhsq.wxentity;

import java.io.Serializable;
import java.util.List;

import com.medusa.bhsq.entity.Article;

public class Index implements Serializable{
	private List<Article> td;
	private List<Article> dj;
	private List<Article> rm;
	public List<Article> getTd() {
		return td;
	}
	public void setTd(List<Article> td) {
		this.td = td;
	}
	public List<Article> getDj() {
		return dj;
	}
	public void setDj(List<Article> dj) {
		this.dj = dj;
	}
	public List<Article> getRm() {
		return rm;
	}
	public void setRm(List<Article> rm) {
		this.rm = rm;
	}
	public Index(List<Article> td, List<Article> dj, List<Article> rm) {
		super();
		this.td = td;
		this.dj = dj;
		this.rm = rm;
	}
	
	
	

}
