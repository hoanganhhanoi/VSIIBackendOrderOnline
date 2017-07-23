package com.vsii.entity.json;

public class CustomResponseType {
	private String status;
	private Object data;
	private String error;
		
	public CustomResponseType() {
		super();
	}

	public CustomResponseType(String status, Object data, String error) {
		super();
		this.status = status;
		this.data = data;
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
