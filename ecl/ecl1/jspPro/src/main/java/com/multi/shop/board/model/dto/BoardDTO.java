package com.multi.shop.board.model.dto;

import java.sql.Date;


public class BoardDTO {
	private int no;
	private String title;
	private int categoryCode;
	private String content;
	private int count;
	private Date createDate;
	private String status;
	private CategoryDTO category;
	private String writer;

	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public BoardDTO(int no, String title, int categoryCode, String content, int count, Date createDate, String status,
			CategoryDTO category, String writer ) {
		super();
		this.no = no;
		this.title = title;
		this.categoryCode = categoryCode;
		this.content = content;
		this.count = count;
		this.createDate = createDate;
		this.status = status;
		this.category = category;
		this.writer = writer;
	}


	public int getCategoryCode() {
		return categoryCode;
	}


	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}


	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public CategoryDTO getCategory() {
		return category;
	}


	public void setCategory(CategoryDTO category) {
		this.category = category;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", title=" + title + ", categoryCode=" + categoryCode + ", content=" + content
				+ ", count=" + count + ", createDate=" + createDate + ", status=" + status + ", category=" + category
				+ ", writer=" + writer + "]";
	}






}
