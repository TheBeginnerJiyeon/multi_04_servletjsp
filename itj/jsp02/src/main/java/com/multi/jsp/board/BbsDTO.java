package com.multi.jsp.board;

public class BbsDTO {
	private int no;
	private String title;



	private int category;
	private String content;
	private String writer;

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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "BbsDTO{" +
				"no=" + no +
				", title='" + title + '\'' +
				", category=" + category +
				", content='" + content + '\'' +
				", writer='" + writer + '\'' +
				'}';
	}
//set변수명()/get변수명() ==> setter/getter
	
}
