package com.tounga.predictice.response;

public class GenericResponse<T> {

	private T data;
	private String messge;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessge() {
		return messge;
	}
	public void setMessge(String messge) {
		this.messge = messge;
	}	
	
}
