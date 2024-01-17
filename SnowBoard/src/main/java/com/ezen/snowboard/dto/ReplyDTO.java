package com.ezen.snowboard.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyDTO {

	private Integer reply_id; // PK
	private Integer board_id; // FK
	private String reply_writer;
	private String reply_content;
	private String reply_password;
	private Date reply_date;
}
