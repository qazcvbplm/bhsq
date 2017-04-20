package com.medusa.bhsq.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.Length;

public class Article implements Serializable{
    private Integer id;

    @Length(min=10,message="标题长度应不能太短")
    private String title;
    
    private String image;

    private Integer visitor=0;

    private Integer userid;

    private Integer type;

    private String time;

    private String sort;

    private Integer parent;
    @Length(min=40,message="文章内容长度太短")
    private String text;
    
    private Plate plate;
    
    private Article article;
    
    
    public Plate getPlate() {
		return plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	private List<String> imagelist=new ArrayList<String>();
    
    

    public List<String> getImagelist() {
		return imagelist;
	}

	public void setImagelist(List<String> imagelist) {
		this.imagelist = imagelist;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getVisitor() {
        return visitor;
    }

    public void setVisitor(Integer visitor) {
        this.visitor = visitor;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    
    public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }
}