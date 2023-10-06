package com.example.demo.Exception.Pojo;

import java.util.Date;

public class ExceptionConfiguration {
	
	
	Date timestamp;
	int status;
	String error;
	String description;
	
	

	public ExceptionConfiguration(Date timestamp, int status, String error, String description) {
		super();
		this.error = error;
		this.status = status;
		this.description = description;
		this.timestamp = timestamp;
	}

	
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	



}
