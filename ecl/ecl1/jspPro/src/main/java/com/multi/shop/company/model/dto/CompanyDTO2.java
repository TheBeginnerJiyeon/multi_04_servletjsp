package com.multi.shop.company.model.dto;

public class CompanyDTO2 {
	
	
	private String id;
	
	private String name;
	
	private String addr;

	private int tel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "CompanyDTO [id=" + id + ", name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
	}
	
	
	
	
	
	

}
