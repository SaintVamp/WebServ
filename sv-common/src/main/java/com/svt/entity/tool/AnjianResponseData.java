package com.svt.entity.tool;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;

@ToString
public class AnjianResponseData {
	private int Code;
	private String Message;
	private Object Data;

	public AnjianResponseData ( int code, String message ) {
		super();
		this.Code = code;
		this.Message = message;
	}

	@JSONField(name = "Code")
	public int getCode ( ) {
		return Code;
	}

	@JSONField(name = "Message")
	public String getMessage ( ) {
		return Message;
	}

	@JSONField(name = "Data")
	public Object getData ( ) {
		return Data;
	}

	public void setCode ( int code ) {
		Code = code;
	}

	public void setMessage ( String message ) {
		Message = message;
	}

	public void setData ( Object data ) {
		this.Data = data;
	}


}
