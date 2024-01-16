package com.ezen.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	
	private int board_id;
	private String board_title;
	private String board_content;
	private String board_password;
	private String board_writer;
	private int view_count;
	private Date write_date;
	
}
