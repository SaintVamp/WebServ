package com.svt.common;

public class ResponseData {

	private String retCode;
	private String retInfo;
	private Object data;

	public ResponseData ( String code, String retInfo ) {
		super( );
		this.retCode = code;
		this.retInfo = retInfo;
	}

	public String getRetCode () {
		return retCode;
	}

	public void setRetCode ( String retCode ) {
		this.retCode = retCode;
	}

	public String getRetInfo() {
		return retInfo;
	}

	public void setRetInfo ( String retInfo ) {
		this.retInfo = retInfo;
	}

	public Object getData() {
		return data;
	}

	public void setData( Object data ) {
		this.data = data;
	}

	public String toString() {
		String res = "retCode: " + retCode;
		res = res + ", retInfo: " + retInfo;
		return res;
	}

}
