package com.multi.shop.product.model.dto;

import java.util.Date;
import java.util.List;

import com.multi.shop.product.model.dto.CompanyDTO;


public class ProductDTO {
	
	/*
	 * private int id; private String name; private String content; private int
	 * price; private CompanyDTO company; private String img; private String status;
	 * private Date createDate; private String createPerson; private Date
	 * modifyDate; private String modifyPerson; private List<AttachmentDTO>
	 * attachments;
	 */
	
	
	private int id;
	private String name;
	private String content;
	private int price;
	private String img;
	private Date createdDate;
	private String createdPerson;
	private Date modifiedDate;
	private String modifiedPerson;
	private String status;
	
	private List<AttachmentDTO> attachments;
	
	
	private CompanyDTO company;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}




	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public String getCreatedPerson() {
		return createdPerson;
	}


	public void setCreatedPerson(String createdPerson) {
		this.createdPerson = createdPerson;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public String getModifiedPerson() {
		return modifiedPerson;
	}


	public void setModifiedPerson(String modifiedPerson) {
		this.modifiedPerson = modifiedPerson;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<AttachmentDTO> getAttachments() {
		return attachments;
	}


	public void setAttachments(List<AttachmentDTO> attachments) {
		this.attachments = attachments;
	}


	public CompanyDTO getCompany() {
		return company;
	}


	public void setCompany(CompanyDTO company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", content=" + content + ", price=" + price + ", companyId="
				+ ", img=" + img + ", createdDate=" + createdDate + ", createdPerson=" + createdPerson
				+ ", modifiedDate=" + modifiedDate + ", modifiedPerson=" + modifiedPerson + ", status=" + status
				+ ", attachments=" + attachments + ", company=" + company + "]";
	}


	
	
	
	





}
