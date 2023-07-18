package com.svt.entity.tool;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ResponseTime {
	private long ClientTimestamp;
	private long ServerTimestamp;

	public ResponseTime ( long timestamp ) {
		super();
		this.ClientTimestamp = timestamp;
		this.ServerTimestamp = timestamp;
	}

	@JSONField(name = "ServerTimestamp")
	public long getServerTimestamp ( ) {
		return ServerTimestamp;
	}

	@JSONField(name = "ClientTimestamp")
	public long getClientTimestamp ( ) {
		return ClientTimestamp;
	}

	public void setClientTimestamp ( long clientTimestamp ) {
		ClientTimestamp = clientTimestamp;
	}

	public void setServerTimestamp ( long serverTimestamp ) {
		ServerTimestamp = serverTimestamp;
	}
}
