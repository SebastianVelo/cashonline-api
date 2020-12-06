package com.myecommerce.dto;

import com.myecommerce.enumerator.Message;
import com.myecommerce.enumerator.Result;

public class ResponseBody {

	private String request;
	private String msg;
	private Result result;
	private Object data;
	
	public ResponseBody(String request) {
		this.request = request;
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
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
