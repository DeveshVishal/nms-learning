package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Filee {
	
	@Id
	@Column 
	private int fid;
	@Column 
	private String pid;
	@Column 
	private int type;
	@Column 
	private String name;
	@Column 
	private int parentid;
	@Column 
	private String desc;
	
	@Override
	public String toString() {
		return "Filee [fid=" + fid + ", pid=" + pid + ", type=" + type + ", name=" + name + ", parentid=" + parentid
				+ ", desc=" + desc + "]";
	}
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
