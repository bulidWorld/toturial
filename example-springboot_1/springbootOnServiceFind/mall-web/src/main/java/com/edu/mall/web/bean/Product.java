package com.edu.mall.web.bean;

public class Product {

	private Integer pid;
	private String pname;
	private String type;
	private Double price;
	private String createTime;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", type=" + type + ", price=" + price + ", createTime="
				+ createTime + "]";
	}
}
