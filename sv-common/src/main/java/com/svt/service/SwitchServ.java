package com.svt.service;

import com.svt.entity.SwitchInfo;

public interface SwitchServ {
	boolean getWakeUpTablet ( ) throws Exception;

	boolean getCheckRunning ( ) throws Exception;

	boolean getCheckZuk ( ) throws Exception;

	boolean checkGiftSending ( ) throws Exception;

	Boolean checkRemainSim ( String ids );

	String getSwitch ( SwitchInfo switchInfo ) throws Exception;

	int setSwitch ( SwitchInfo switchInfo ) throws Exception;

	int addSwitch ( SwitchInfo switchInfo ) throws Exception;

	String getSwitchAll ( ) throws Exception;


}
