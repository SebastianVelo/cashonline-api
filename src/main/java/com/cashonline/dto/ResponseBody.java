package com.cashonline.dto;

import com.cashonline.enumerator.Message;
import com.cashonline.enumerator.Result;

public class ResponseBody {

	private DTO data;
	private String request;
	private String msg;
	private Result result;
	
	public ResponseBody(String request) {
		this.request = request;
	}
		
	public DTO getData() {
		return data;
	}
	public void setData(DTO data) {
		this.data = data;
	}
	
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(Message msg) {
		this.msg = msg.getMsg();
	}
	
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}

}
