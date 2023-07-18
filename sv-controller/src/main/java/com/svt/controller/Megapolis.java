package com.svt.controller;

import com.alibaba.fastjson.JSONObject;
import com.svt.common.JsonUtil;
import com.svt.common.ResponseCode;
import com.svt.common.ResponseData;
import com.svt.entity.Gift;
import com.svt.entity.MegapolisInfo;
import com.svt.entity.Quest;
import com.svt.entity.SwitchInfo;
import com.svt.service.GiftServ;
import com.svt.service.MegapolisServ;
import com.svt.service.QuestServ;
import com.svt.service.SwitchServ;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/megapolis")
public class Megapolis {
	@Resource
	private MegapolisServ megapolisServ;
	@Resource
	private GiftServ giftServ;
	@Resource
	private SwitchServ switchServ;
	@Resource
	private QuestServ questServ;


	private static final Logger log = LogManager.getLogger( "megapolis" );

	@ResponseBody
	@RequestMapping(value = "/Health")
	public String Health ( ) {
		log.info( "Health" );
		return "OK";
	}

	/**
	 * 用的Megapolis表
	 */
	@ResponseBody
	@RequestMapping(value = "/getMegapolis/{flag}", method = RequestMethod.POST)
	public String getMegapolis ( HttpServletRequest request, @PathVariable String flag ) {
		try {
			MegapolisInfo megapolisInfo = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), MegapolisInfo.class );
			log.info( "getMegapolis > " + megapolisInfo );
			return JSONObject.parseObject( JSONObject.toJSONString( megapolisServ.getMegapolis( megapolisInfo ) ) ).getString( flag );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getMegapolis has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Megapolis表
	 */
	@ResponseBody
	@RequestMapping(value = "/setMegapolis", method = RequestMethod.POST)
	public String setGameVer ( HttpServletRequest request ) {
		try {
			MegapolisInfo megapolisInfo = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), MegapolisInfo.class );
			log.info( "setMegapolis > " + megapolisInfo );
			return String.valueOf( megapolisServ.setMegapolis( megapolisInfo ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "setMegapolis has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Megapolis表
	 */
	@ResponseBody
	@RequestMapping(value = "/count", method = RequestMethod.POST)
	public String count ( ) {
		try {
			log.info( "count" );
			return String.valueOf( megapolisServ.count() );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "count has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Gift表
	 */
	@ResponseBody
	@RequestMapping(value = "/getRunning", method = RequestMethod.POST)
	public String getRunning ( ) {
		try {
			log.info( "getRunning" );
			return giftServ.getRunning();
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getRunning has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Gift表
	 */
	@ResponseBody
	@RequestMapping(value = "/setRunning", method = RequestMethod.POST)
	public String setRunning ( HttpServletRequest request ) {
		try {
			Gift gift = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Gift.class );
			log.info( "setRunning > " + gift );
			return String.valueOf( giftServ.setRunning( gift ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "setRunning has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Gift表
	 */
	@ResponseBody
	@RequestMapping(value = "/delRunningAll", method = RequestMethod.POST)
	public String delRunningAll ( ) {
		try {
			log.info( "delRunningAll" );
			return String.valueOf( giftServ.delRunningAll() );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "delRunningAll has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Gift表
	 */
	@ResponseBody
	@RequestMapping(value = "/delRunning", method = RequestMethod.POST)
	public String delRunning ( HttpServletRequest request ) {
		try {
			Gift gift = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Gift.class );
			log.info( "delRunning > " + gift );
			return String.valueOf( giftServ.setRunning( gift ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "delRunning has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Quest表
	 */
	@ResponseBody
	@RequestMapping(value = "/getQuest", method = RequestMethod.POST)
	public String getQuest ( HttpServletRequest request ) {
		try {
			Quest quest = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Quest.class );
			log.info( "getQuest > " + quest );
			return questServ.getQuest( quest );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getQuest has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Quest表
	 */
	@ResponseBody
	@RequestMapping(value = "/setQuest", method = RequestMethod.POST)
	public String setQuest ( HttpServletRequest request ) {
		try {
			Quest quest = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Quest.class );
			log.info( "setQuest > " + quest );
			return String.valueOf( questServ.setQuest( quest ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "setQuest has error:" + e.getMessage() );
			return "Error";
		}
	}



	/**
	 * 用的Switch表
	 */
	@ResponseBody
	@RequestMapping(value = "/getSwitchAll", method = RequestMethod.POST)
	public ResponseData getSwitchAll ( ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			log.info( "getSwitchAll" );
			result.setData( switchServ.getSwitchAll() );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getSwitchAll has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "getSwitchAll has error" );
		}
		return result;
	}

	/**
	 * 用的Switch表
	 */
	@ResponseBody
	@RequestMapping(value = "/getSwitch", method = RequestMethod.POST)
	public ResponseData getSwitch ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			SwitchInfo switchInfo = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), SwitchInfo.class );
			log.info( "getSwitch > " + switchInfo );
			result.setData( switchServ.getSwitch( switchInfo ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getSwitch has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "getSwitch has error" );
		}
		return result;
	}

	/**
	 * 用的Switch表
	 */
	@ResponseBody
	@RequestMapping(value = "/setSwitch", method = RequestMethod.POST)
	public ResponseData setSwitch ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			SwitchInfo switchInfo = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), SwitchInfo.class );
			log.info( "setSwitch > " + switchInfo );
			result.setData( switchServ.setSwitch( switchInfo ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "setSwitch has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "setSwitch has error" );
		}
		return result;
	}

	/**
	 * 用的Switch表
	 */
	@ResponseBody
	@RequestMapping(value = "/addSwitch", method = RequestMethod.POST)
	public ResponseData addSwitch ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			SwitchInfo switchInfo = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), SwitchInfo.class );
			log.info( "addSwitch > " + switchInfo );
			result.setData( switchServ.addSwitch( switchInfo ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "addSwitch has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "addSwitch has error" );
		}
		return result;
	}
}
