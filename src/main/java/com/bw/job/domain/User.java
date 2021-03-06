package com.bw.job.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

public class User {

	private Integer id;
	
	@Length(min=1,max=5,message = "长度在1-5之间")
	private String name;
	
	@Past(message = "日期必须是一个过去的日期")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	
	private Date created;

    private String sex;
    
    private String picUrl;
    
    private String avgScore;//平均分
    
    private List<Score> list;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(String avgScore) {
		this.avgScore = avgScore;
	}

	public List<Score> getList() {
		return list;
	}

	public void setList(List<Score> list) {
		this.list = list;
	}

}
