package com.svt.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class JsonUtil {
	public String Map2String ( Map map ) {
		JSONObject jsonObject = new JSONObject( map );
		String str = JSONObject.toJSONString( jsonObject );
		str = str.replace( "[", "" );
		str = str.replace( "]", "" );
		return str;
	}

	public <T> String List2String ( List<T> list ) {
		JSONArray jsonArray = new JSONArray( Collections.singletonList( list ) );
		return JSONArray.toJSONString( jsonArray );
	}
}
