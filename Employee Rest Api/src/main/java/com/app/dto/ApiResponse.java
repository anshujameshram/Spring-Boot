package com.app.dto;

import java.time.LocalDateTime;

import lombok.*;
import lombok.Getter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@EqualsAndHashCode
public class ApiResponse {
	private String message;
	private LocalDateTime localDate;
	
	public ApiResponse(String msg)
	{
		super();
		this.message=msg;
		this.localDate=LocalDateTime.now();
	}
}
