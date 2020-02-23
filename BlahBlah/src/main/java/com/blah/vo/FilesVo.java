package com.blah.vo;

import org.springframework.web.multipart.MultipartFile;

public class FilesVo {			//강의 자료
	private int lessonNo;			
	private String filesType;
	private MultipartFile filesDir;	//파일 경로
	private String filesName;	//파일 이름 추가
	
	
	public FilesVo() {
		super();
	}


	public FilesVo(int lessonNo, String filesType, MultipartFile filesDir, String filesName) {
		super();
		this.lessonNo = lessonNo;
		this.filesType = filesType;
		this.filesDir = filesDir;
		this.filesName = filesName;
	}


	public int getLessonNo() {
		return lessonNo;
	}


	public void setLessonNo(int lessonNo) {
		this.lessonNo = lessonNo;
	}


	public String getFilesType() {
		return filesType;
	}


	public void setFilesType(String filesType) {
		this.filesType = filesType;
	}


	public MultipartFile getFilesDir() {
		return filesDir;
	}


	public void setFilesDir(MultipartFile filesDir) {
		this.filesDir = filesDir;
	}


	public String getFilesName() {
		return filesName;
	}


	public void setFilesName(String filesName) {
		this.filesName = filesName;
	}


	@Override
	public String toString() {
		return "FilesVo [lessonNo=" + lessonNo + ", filesType=" + filesType + ", filesDir=" + filesDir + ", filesName="
				+ filesName + "]";
	}
	
	
	
}
