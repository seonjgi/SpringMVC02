package com.board.model;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private String mode;
	//글쓰기: write, 답변글쓰기: rewrite, 글수정: edit
	
	private int num;
	private String name;
	private String passwd;
	private String subject;
	private String content;
	
	private Date wdate;
	private int readnum;
	private String filename;//물리적 파일명
	private String originFilename;//원본 파일명
	private long filesize;//첨부파일 크기
	
	private int refer;//글그룹 번호
	private int lev;//답변 레벨
	private int sunbun;//같은 그 그룹내의 순서
	
	private String old_filename;// 예전에 첨부햇던 파일(물리적파일명)
}
