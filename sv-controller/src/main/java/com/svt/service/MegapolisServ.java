package com.svt.service;

import com.svt.entity.MegapolisInfo;

public interface MegapolisServ {

	MegapolisInfo getMegapolis ( MegapolisInfo megapolisInfo ) throws Exception;

	int setMegapolis ( MegapolisInfo megapolisInfo ) throws Exception;

	int count ( ) throws Exception;


	String getUnsentDay ( ) throws Exception;
}
