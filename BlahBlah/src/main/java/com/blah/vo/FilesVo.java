package com.blah.vo;

public class FilesVo {			//강의 자료
	private int lessonNo;			
	private String filesDir;	//파일 경로
	
	public FilesVo() {
		super();
	}
	public FilesVo(int lessonNo, String filesType, String filesDir) {
		super();
		this.lessonNo = lessonNo;
		this.filesDir = filesDir;
	}
	public int getLessonNo() {
		return lessonNo;
	}
	public void setLessonNo(int lessonNo) {
		this.lessonNo = lessonNo;
	}

	public String getFilesDir() {
		return filesDir;
	}
	public void setFilesDir(String filesDir) {
		this.filesDir = filesDir;
	}
	@Override
	public String toString() {
		return "FilesVo [lessonNo=" + lessonNo + ", filesDir=" + filesDir + "]";
	}
	
	
}
