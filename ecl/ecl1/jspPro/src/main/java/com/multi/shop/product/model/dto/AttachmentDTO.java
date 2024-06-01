package com.multi.shop.product.model.dto;

import java.sql.Date;

public class AttachmentDTO implements java.io.Serializable {
	
	private int no;
    private int refProductNo;
    private String originalName;
    private String savedName;
    private String savePath;
    private String thumbnailPath;
    private String status;
    private Date createDate;
    private String createPerson;
    private Date modifyDate;
    private String modifyPerson;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyPerson() {
		return modifyPerson;
	}

	public void setModifyPerson(String modifyPerson) {
		this.modifyPerson = modifyPerson;
	}

	public AttachmentDTO() {}

	public AttachmentDTO(int no, int refProductNo, String originalName, String savedName, String savePath,
			String fileType, String thumbnailPath, String status) {
		super();
		this.no = no;
		this.refProductNo = refProductNo;
		this.originalName = originalName;
		this.savedName = savedName;
		this.savePath = savePath;
		this.thumbnailPath = thumbnailPath;
		this.status = status;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getRefProductNo() {
		return refProductNo;
	}

	public void setRefProductNo(int refProductNo) {
		this.refProductNo = refProductNo;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getSavedName() {
		return savedName;
	}

	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AttachmentDTO [no=" + no + ", refProductNo=" + refProductNo + ", originalName=" + originalName
				+ ", savedName=" + savedName + ", savePath=" + savePath  + ", thumbnailPath="
				+ thumbnailPath + ", status=" + status + "]";
	}
	
}
