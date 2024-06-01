package com.multi.shop.product.model.dto;

import java.sql.Date;

public class CompanyDTO {
	// db table의 컬럼명과 동일하게 저장할 공간 만들어주세요.
	private String id;
	private String name;
	private String addr;
	private int tel;
	
	
	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public int getTel() {
		return tel;
	}


	public void setTel(int tel) {
		this.tel = tel;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "CompanyDTO [id=" + id + ", name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
	}


}
