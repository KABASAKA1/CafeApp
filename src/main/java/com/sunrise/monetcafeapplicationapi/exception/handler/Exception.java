package com.sunrise.monetcafeapplicationapi.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exception<E>{

	private Date createTime;
	
	private String path;
	
	private String hostName;
	
	private E message;
	
	
}
