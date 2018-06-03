package com.edu.mall.web.bean;

public class Response {
	/**
	 * 200表示成功
	 * 500表示失败
	 */
	private String code;
	private String msg;
	private Product data;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Product getData() {
		return data;
	}
	public void setData(Product data) {
		this.data = data;
	}
	
}
