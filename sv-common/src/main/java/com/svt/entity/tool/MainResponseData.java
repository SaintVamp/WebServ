package com.svt.entity.tool;

import com.alibaba.fastjson.annotation.JSONField;

public class MainResponseData {
	private String Data;
	private int R;

	public MainResponseData ( int r ) {
		super();
		this.R = r;
	}

	@JSONField(name = "R")
	public int getR ( ) {
		return R;
	}

	@JSONField(name = "Data")
	public String getData ( ) {
		return Data;
	}

	public void setData ( String data ) {
		Data = data;
	}

	public void setR ( int r ) {
		R = r;
	}
}
