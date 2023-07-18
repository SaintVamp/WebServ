package com.svt.controller;


import com.alibaba.fastjson.JSONObject;
import com.svt.common.JsonUtil;
import com.svt.common.ResponseCode;
import com.svt.common.ResponseData;
import com.svt.entity.Contract;
import com.svt.entity.ToolAlive;
import com.svt.service.ZukServ;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.svt.common.SVUtil.ts2time;

@Controller
@RequestMapping("/zuk")
public class Zuk {
	@Resource
	ZukServ zukServ;

	private static final Logger log = LogManager.getLogger( "zuk" );

	@ResponseBody
	@RequestMapping(value = "/Health")
	public String Health ( ) {
		return "OK";
	}


	@ResponseBody
	@RequestMapping(value = "/setToolHeart", method = RequestMethod.POST)
	public ResponseData setToolHeart ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			ToolAlive toolAlive = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), ToolAlive.class );
			log.info( "setToolHeart param is > " + toolAlive );
			result.setData( zukServ.setToolHeart( toolAlive ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "setToolHeart has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/getToolHeart", method = RequestMethod.POST)
	public ResponseData getToolHeart ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			ToolAlive toolAlive = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), ToolAlive.class );
			log.info( "getToolHeart param is > " + toolAlive );
			toolAlive.setTimestamp( "" );
			result.setData( zukServ.getToolHeart( toolAlive ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getToolHeart has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/setContractOperation", method = RequestMethod.POST)
	public ResponseData setContractOperation ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			Contract contract = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Contract.class );
			result.setData( zukServ.setContractOperation( contract ) );
			log.info( "setContractOperation param is > " + contract );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "setContractOperation has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/getContractOperation", method = RequestMethod.POST)
	public ResponseData getContractOperation ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			Contract contract = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Contract.class );
			result.setData( zukServ.getContractOperation( contract ).getOperation() );
			log.info( "getContractOperation param is > " + contract );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getContractOperation has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}


	@ResponseBody
	@RequestMapping(value = { "/getContractTimeAll" }, method = RequestMethod.GET)
	public ResponseData getContractTimeAll ( ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			log.info( "getContractTimeAll param is null" );
			result.setData( zukServ.getContractTimeAll() );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getContractTimeAll has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/getAreaNum", method = RequestMethod.POST)
	public ResponseData getAreaNum ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			Contract contract = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Contract.class );
			log.info( "getAreaNum param is > " + contract );
			result.setData( zukServ.getAreaNum( contract ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getAreaNum has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}


	@ResponseBody
	@RequestMapping(value = "/getContractTime", method = RequestMethod.POST)
	public ResponseData getContractTime ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			Contract contract = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Contract.class );
			log.info( "getContractTime param is > " + contract );
			result.setData( zukServ.getContractTime( contract ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getContractTime has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "getContractTime has error" );
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/setContractTime", method = RequestMethod.POST)
	public ResponseData setContractTime ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			Contract contract = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Contract.class );
			contract.setTime( ts2time( String.valueOf( contract.getTimestamp() ) ) );
			log.info( "setContractTime param is > " + contract );
			result.setData( zukServ.setContractTime( contract ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "setContractTime has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "setContractTime has error" );
		}
		return result;
	}

}
