package com.svt.controller;


import com.alibaba.fastjson.JSONObject;
import com.svt.common.JsonUtil;
import com.svt.common.ResponseCode;
import com.svt.common.ResponseData;
import com.svt.entity.MegapolisInfo;
import com.svt.entity.SwitchInfo;
import com.svt.entity.tool.*;
import com.svt.service.MegapolisServ;
import com.svt.service.SwitchServ;
import com.svt.service.ToolUpdateServ;
import com.svt.service.UpdateInfoServ;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Saint on 2017/2/9.
 */
@Controller
@RequestMapping("/anjian")
public class AnJian {

    private static final Logger log = LogManager.getLogger("anjian");
    @Resource
    private ToolUpdateServ toolUpdateServ;
    @Resource
    private UpdateInfoServ updateInfoServ;
    @Resource
    private SwitchServ switchServ;
    @Resource
    private MegapolisServ megapolisServ;


    @ResponseBody
    @RequestMapping(value = "/Health", method = RequestMethod.GET)
    public String Health() {
        return "OK";
    }


    /**
     * 以下是3.6.2版本打包使用的接口
     */
    //{"Code":200,"Message":"请求成功！","Data":{"AppDomainName":"http://auth2.mobileanjian.com/","App2DomainName":"http://app.mobileanjian.com","App3DomainName":"http://auth3.mobileanjian.com","RedFingerSwitch":0,"PhoneConfig":[{"Active":1,"DisableMsg":"当前环境暂不支持！","Package":"com.android.inputmethod.pinyin","JudgeMode":1,"CloudPhoneType":6,"ImageUrl":"http://ajres.mobileanjian.com/PaidEditionMacro/Image/d40b0321977c45a4ad4fccdb3f078ee9.jpg","LinkUrl":"http://www.ddyun.com"},{"Active":1,"DisableMsg":"当前环境暂不支持！","Package":"com.ld.cloudserver","JudgeMode":1,"CloudPhoneType":6,"ImageUrl":"http://ajres.mobileanjian.com/PaidEditionMacro/Image/55d90efe6a1744c18e4b048f3ec043e7.jpg","LinkUrl":"http://www.ddyun.com"},{"Active":0,"DisableMsg":"当前环境暂不支持！","Package":"com.lz.appmarket","JudgeMode":1,"CloudPhoneType":11,"ImageUrl":"http://ajres.mobileanjian.com/PaidEditionMacro/Image/ac6491c8860a46b2af89350f8a0bd3c7.jpg","LinkUrl":"http://www.ddyun.com"},{"Active":0,"DisableMsg":"当前环境暂不支持！","Package":"com.abo.vpmarket","JudgeMode":1,"CloudPhoneType":10,"ImageUrl":"http://ajres.mobileanjian.com/PaidEditionMacro/Image/9de946cd87af4725861e32c83793b59d.jpg","LinkUrl":"http://www.ddyun.com"},{"Active":0,"DisableMsg":"当前环境暂不支持！","Package":"com.yuncap.market","JudgeMode":1,"CloudPhoneType":9,"ImageUrl":"http://ajres.mobileanjian.com/PaidEditionMacro/Image/228918f4243e418d84fe3d4bde8c0be2.jpg","LinkUrl":"http://www.ddyun.com"},{"Active":0,"DisableMsg":"当前环境暂不支持！","Package":"com.chinac.launcher","JudgeMode":1,"CloudPhoneType":8,"ImageUrl":"http://ajres.mobileanjian.com/PaidEditionMacro/Image/cf5eafa2651b46688b263d91c802a37d.jpg","LinkUrl":"http://www.ddyun.com"},{"Active":1,"DisableMsg":"当前环境暂不支持！","Package":"com.eternity.appstreamphoneassistant","JudgeMode":1,"CloudPhoneType":7,"ImageUrl":"http://ajres.mobileanjian.com/PaidEditionMacro/Image/c4025eeb391f41c7b94c9adc4a0c5854.jpg","LinkUrl":"http://www.ddyun.com"},{"Active":1,"DisableMsg":"当前环境暂不支持","Package":"com.android.inputmethod.latin,com.cloud.launcher3","JudgeMode":1,"CloudPhoneType":6,"ImageUrl":"http://ajres.mobileanjian.com/PaidEditionMacro/Image/dd5daf07f50244748fa9ab3399e22b3a.jpg","LinkUrl":"http://www.ddyun.com"},{"Active":0,"DisableMsg":"当前环境暂不支持！","Package":"com.longene.outfile","JudgeMode":2,"CloudPhoneType":3,"ImageUrl":"http://ajres.mobileanjian.com/PaidEditionMacro/Image/8614ed1f398f435d8e6383b2a436f291.jpg","LinkUrl":"http://www.ddyun.com/"},{"Active":0,"DisableMsg":"当前环境暂不支持！","Package":"com.redfinger.appstore,com.wsh.market","JudgeMode":2,"CloudPhoneType":5,"ImageUrl":"http://ajres.mobileanjian.com/PaidEditionMacro/Image/62808a7e5e9f4194a08aeaaa9d0c7800.jpg","LinkUrl":"http://www.ddyun.com"},{"Active":0,"DisableMsg":"当前环境暂不支持！","Package":"com.huang.autorunmarket","JudgeMode":2,"CloudPhoneType":2,"ImageUrl":"http://ajres.mobileanjian.com/PaidEditionMacro/Image/789dd542bd004e3babf3d5a0e3328d9c.jpg","LinkUrl":"http://www.ddyun.com"},{"Active":0,"DisableMsg":"当前环境暂不支持！","Package":"com.haimawan.cloudappstore","JudgeMode":2,"CloudPhoneType":4,"ImageUrl":"http://ajres.mobileanjian.com/PaidEditionMacro/Image/576d3605f58b41aaac615110f19bb8aa.jpg","LinkUrl":"http://www.ddyun.com"},{"Active":0,"DisableMsg":"当前环境暂不支持！","Package":"com.gemini.cloud.app.market","JudgeMode":2,"CloudPhoneType":1,"ImageUrl":"http://ajres.mobileanjian.com/PaidEditionMacro/Image/f3207144e0e24a99882c951d7ba91fb7.jpg","LinkUrl":"http://www.ddyun.com"}],"ClientTimestamp":1648911656,"ServerTimestamp":1648911656}}
    @ResponseBody
    @RequestMapping(value = "/AppConfig", method = RequestMethod.POST)
    public String AppConfig(HttpServletRequest request) {
        String Data = request.getParameter("Data");
        AppConfigRequest appConfigRequest = JSONObject.parseObject(Data, AppConfigRequest.class);
        log.info("AppConfig > " + Data);
        MainResponseData mainResult = new MainResponseData(1);
        AnjianResponseData result = new AnjianResponseData(200, "OK");
        result.setData(new AppConfig(appConfigRequest.getClientTimestamp()));
        mainResult.setData(JSONObject.toJSONString(result));
        return JSONObject.toJSONString(mainResult);
    }

    @ResponseBody
    @RequestMapping(value = "/VersionUpdate", method = RequestMethod.POST)
    public String VersionUpdate(HttpServletRequest request) {
        String Data = request.getParameter("Data");
        log.info("VersionUpdate > " + Data);
        MainResponseData mainResult = new MainResponseData(1);
        AnjianResponseData result = new AnjianResponseData(200, "OK");
        try {
            VersionUpdateRequest versionUpdateRequest = JSONObject.parseObject(Data, VersionUpdateRequest.class);
            if (toolUpdateServ.isNeedUpdate(versionUpdateRequest.getAppInfo(), versionUpdateRequest.getScriptVersion())) {
                ToolUpdate toolUpdate = toolUpdateServ.getUpdateInfo(versionUpdateRequest.getScriptId());
                toolUpdate.setClientTimestamp(versionUpdateRequest.getClientTimestamp());
                result.setData(toolUpdate);
            } else {
                result.setData(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("VersionUpdate has error:" + e.getMessage());
        }
        mainResult.setData(JSONObject.toJSONString(result));
        return JSONObject.toJSONString(mainResult);
    }

    @ResponseBody
    @RequestMapping(value = "/PreStart", method = RequestMethod.POST)
    public String PreStart(HttpServletRequest request) {
        String Data = request.getParameter("Data");
        StartRequest startRequest = JSONObject.parseObject(Data, StartRequest.class);
        log.info("PreStart > " + Data);
        MainResponseData mainResult = new MainResponseData(1);
        AnjianResponseData result = new AnjianResponseData(200, "OK");
        result.setData(new Start(startRequest.getClientTimestamp()));
        mainResult.setData(JSONObject.toJSONString(result));
        return JSONObject.toJSONString(mainResult);
    }

    @ResponseBody
    @RequestMapping(value = "/Start", method = RequestMethod.POST)
    public String Start(HttpServletRequest request) {
        String Data = request.getParameter("Data");
        StartRequest startRequest = JSONObject.parseObject(Data, StartRequest.class);
        log.info("Start > " + Data);
        MainResponseData mainResult = new MainResponseData(1);
        AnjianResponseData result = new AnjianResponseData(200, "OK");
        result.setData(new Start(startRequest.getClientTimestamp()));
        mainResult.setData(JSONObject.toJSONString(result));
        return JSONObject.toJSONString(mainResult);
    }

    @ResponseBody
    @RequestMapping(value = "/Stop", method = RequestMethod.POST)
    public String Stop(HttpServletRequest request) {
        String Data = request.getParameter("Data");
        StartRequest startRequest = JSONObject.parseObject(Data, StartRequest.class);
        log.info("Stop > " + Data);
        MainResponseData mainResult = new MainResponseData(1);
        AnjianResponseData result = new AnjianResponseData(200, "OK");
        result.setData(new ResponseTime(startRequest.getClientTimestamp()));
        mainResult.setData(JSONObject.toJSONString(result));
        return JSONObject.toJSONString(mainResult);
    }

/**以下是3.3.1版本打包使用的接口*/
    /**
     * 辅助更新接口
     * [{
     * "UpdateNotice": "★更新后一定检查设置，详细说明加群 682823886 看最新宝典★\r\n全面支持任何屏幕宽度为720或1080的手机\r\n20190730\r\n1、增加了离线前换离线宠",
     * "UpdateType": "1",
     * "DownLoadPath": "http://res1.mobileanjian.com/app_update/elf/a574ebfe-ace2-42d4-bdcd-9da7b55a5437.apk",
     * "FileSize": "15.3"
     * }]
     */
    @ResponseBody
    @RequestMapping(value = {"/api/UpdateSV", "/api/Update", "/UpdateSV", "/Update"})
    public String Update(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");

        try {
            UpdateInfo updateInfo = new UpdateInfo(request.getParameter("PackageName"), "", "", "", "", "", request.getParameter("Version"));
            UpdateInfo n_updateInfo = updateInfoServ.getUpdateInfo(updateInfo);
            log.info("Update > " + updateInfo.getToolName() + " > old ver:" + updateInfo.getVersion() + " > now ver:" + n_updateInfo.getVersion());
            if (Long.parseLong(updateInfo.getVersion()) >= Long.parseLong(n_updateInfo.getVersion())) {
                return "null";
            } else {
                return "[" + JSONObject.toJSONString(n_updateInfo) + "]";
            }
        } catch (Exception e) {
            log.error("Update has error:" + e.getMessage());
            return "Error";
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/api/GetElfBlackList", "/GetElfBlackList"})
    public String GetElfBlackList() {
        try {
            return switchServ.getSwitch(new SwitchInfo("GetElfBlackList", "", null));
        } catch (Exception e) {
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/api/GetApkAdvertisement", "/GetApkAdvertisement"})
    public String GetApkAdvertisement() {
        try {
            return switchServ.getSwitch(new SwitchInfo("GetApkAdvertisement", "", null));
        } catch (Exception e) {
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/api/GetAdvertisementSwitch", "/GetAdvertisementSwitch"})
    public String GetAdvertisementSwitch() {
        try {
            return switchServ.getSwitch(new SwitchInfo("GetAdvertisementSwitch", "", null));
        } catch (Exception e) {
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/api/GetMessageSV", "/GetMessageSV", "/GetMessage"})
    public String GetMessageSV() {
        return "";
    }

    @ResponseBody
    @RequestMapping(value = {"/api/SetOperationLog", "/SetOperationLog"})
    public String SetOperationLog(HttpServletRequest request) {
        try {
            String v_str = request.getParameter("Data");
            log.info("SetOperationLog > " + v_str);
            JSONObject jsonObject = JSONObject.parseObject(v_str);
            if (jsonObject.getString("LogType").equals("3")) {
                String ID = String.valueOf(jsonObject.getJSONObject("Data").getLong("DeviceId") - 865166023000000L);
                String version = jsonObject.getJSONObject("Data").getString("AppVersion");
                megapolisServ.setMegapolis(new MegapolisInfo(ID, null, version, null, null, null, null, null, null, null, null, null, null, null, null, null));
            }
            return "";
        } catch (Exception e) {
            log.error("SetOperationLog has error:" + e.getMessage());
            return "Error";
        }
    }

    /**
     * 以下是服务使用接口
     */
    @ResponseBody
    @RequestMapping(value = "/setUpdateInfo", method = RequestMethod.POST)
    public ResponseData setUpdateInfo(HttpServletRequest request) {
        ResponseData result = new ResponseData(ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC);
        try {
            UpdateInfo updateInfo = JSONObject.parseObject(new JsonUtil().Map2String(request.getParameterMap()), UpdateInfo.class);
            log.info("setUpdateInfo > " + updateInfo);
            result.setData(updateInfoServ.setUpdateInfo(updateInfo));
        } catch (Exception e) {
            log.error("setUpdateInfo has error:" + e.getMessage());
        }
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/getUpdateInfo", method = RequestMethod.POST)
    public ResponseData getUpdateInfo(HttpServletRequest request) {
        ResponseData result = new ResponseData(ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC);
        try {
            //        String toolName = jsonObject.getString("toolName");
            UpdateInfo updateInfo = JSONObject.parseObject(new JsonUtil().Map2String(request.getParameterMap()), UpdateInfo.class);
            log.info("getUpdateInfo > " + updateInfo);
            result.setData(updateInfoServ.getUpdateInfo(updateInfo));
        } catch (Exception e) {
            log.error("getUpdateInfo has error:" + e.getMessage());
        }
        return result;
    }


}
