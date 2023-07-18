package com.svt.service;

import com.svt.entity.Gift;

public interface GiftServ {
	String getRunning ( ) throws Exception;

	int setRunning ( Gift gift ) throws Exception;

	int delRunningAll ( ) throws Exception;

	int delRunning ( Gift gift ) throws Exception;
}
