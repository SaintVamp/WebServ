package com.svt.controller;


import com.alibaba.fastjson.JSONObject;
import com.svt.entity.SvData;
import com.svt.service.SvDataServ;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Saint on 2017/2/9.
 */
@Controller
@RequestMapping("/ctrl")
public class Control {

    private static final Logger log = LogManager.getLogger("control");
    @Resource
    private SvDataServ svDataServ;

    @ResponseBody
    @RequestMapping(value = "/Health", method = RequestMethod.GET)
    public String Health() {
        return "OK";
    }


//	/**
//	 * 插入数据接口
//	 *
//	 * @param request
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping(value = "/Insert", method = RequestMethod.GET)
//	public String Insert ( HttpServletRequest request ) {
//		String pw = request.getParameter( "pw" ).replace( " ", "" );
//		;
//		if ( pw.equals( "Wp2Sy1314@87881217" ) ) {
//			SvData svData = new SvData();
//			svData.setAuthCode( request.getParameter( "authCode" ).toUpperCase() );
//			svData.setDevice( request.getParameter( "device" ) );
//			svData.setStartDt( request.getParameter( "startDt" ) );
//			svData.setEndDt( request.getParameter( "endDt" ) );
//			svData.setLocalIp( request.getParameter( "localIp" ) );
//			svData.setPrice( Integer.valueOf( request.getParameter( "price" ) ) );
//			svData.setUpdateDt( request.getParameter( "updateDt" ) );
//			svData.setQqNum( request.getParameter( "qqNum" ) );
//			svData.setVersion( request.getParameter( "version" ) );
//			switch ( Integer.valueOf( request.getParameter( "game" ) ) ) {
//				case 1:
//					svData.setGame( "EF" );
//					break;
//				case 2:
//					svData.setGame( "MSI" );
//					break;
//				default:
//					svData.setGame( "no" );
//					break;
//			}
//			svDataServ.reg( svData );
//			return "0";
//		} else {
//			return "OY";
//		}
//	}

//	/**
//	 * 查询全量数据
//	 *
//	 * @param request
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping(value = "/SeaAll", method = RequestMethod.GET)
//	public List<SvData> SeaAll ( HttpServletRequest request ) {
//		String pw = request.getParameter( "pw" ).replace( " ", "" );
//		;
//		if ( pw.equals( "Wp2Sy1314@87881217" ) ) {
//			List<SvData> lsv = svDataServ.searchAll();
//			return lsv;
//		} else {
//			return null;
//		}
//	}

    /**
     * 注册接口
     */
    @ResponseBody
    @RequestMapping(value = "/Reg", method = RequestMethod.GET)
    public JSONObject Reg( HttpServletRequest request) {
        String pw = request.getParameter("pw").replace(" ", "");
        JSONObject result = new JSONObject();
        result.put("retCode", "11111");
        result.put("retInfo", "OY.");
        try {
            if (pw.equals("Wp2Sy1314@87881217")) {
                SvData svData = new SvData();
                MessageDigest md = MessageDigest.getInstance("MD5");// 生成一个MD5加密计算摘要
                md.update((request.getParameter("a") + System.currentTimeMillis() / 1000).getBytes());// 计算md5函数
                /*
                  digest()最后确定返回md5 hash值，返回值为8位字符串。
                  因为md5 hash值是16位的hex值，实际上就是8位的字符
                  BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
                  一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
                 */
                String authCode = new BigInteger(1, md.digest()).toString(16);
                authCode = authCode.replace("+", "").replace("-", "").replace("/", "").replace("_", "").replace("=", "").replace("*", "");
                authCode = authCode.toUpperCase();
                svData.setAuthCode(authCode);
                svData.setDevice("0");
                svData.setStartDt(request.getParameter("s") + "000000");
                svData.setEndDt(request.getParameter("e") + "235959");
                svData.setLocalIp("0");
                svData.setQqNum(request.getParameter("a"));
                svData.setPrice(Integer.valueOf(request.getParameter("p")));
                svData.setUpdateDt("0000000000");
                svData.setVersion("");
                int a = Integer.parseInt(request.getParameter("g"));
                switch (a) {
                    case 1 -> svData.setGame("EF");
                    case 2 -> svData.setGame("MSI");
                    default -> svData.setGame("no");
                }
                log.info("Reg data is:" + svData);
                svDataServ.reg(svData);
                result.put("retCode", "00000");
                result.put("retInfo", "SUCCESS");
                result.put("data", authCode);
            } else {
                result.put("retCode", "11111");
                result.put("retInfo", "Wrong AuthKey.");
                log.info("Reg has wrong AuthKey");
            }
        } catch (Exception e) {
            result.put("retCode", "11111");
            result.put("retInfo", "Wrong.");
            e.printStackTrace();
            log.error("Reg has error > " + e.getMessage());
        }
        return result;
    }

    /**
     * 修改接口
     */
    @ResponseBody
    @RequestMapping(value = "/RegEdit", method = RequestMethod.GET)
    public JSONObject RegEdit(HttpServletRequest request) {
        String pw = request.getParameter("pw").replace(" ", "");
        JSONObject result = new JSONObject();
        try {
            if (pw.equals("Wp2Sy1314@87881217")) {
                SvData svData = new SvData();
                svData.setAuthCode(request.getParameter("k"));
                svData.setDevice(request.getParameter("d"));
                svData.setStartDt(request.getParameter("s") + "000000");
                svData.setEndDt(request.getParameter("e") + "235959");
                svData.setLocalIp(request.getParameter("ip"));
                svData.setQqNum("");
                svData.setVersion("");
                svData.setGame("");
                svData.setPrice(Integer.valueOf(request.getParameter("p")));
                svData.setUpdateDt(String.valueOf(new Date().getTime() / 1000));
                log.info("RegEdit data is:" + svData);
                if (svDataServ.update(svData) > 0) {
                    result.put("retCode", "00000");
                    result.put("retInfo", "SUCCESS");
                    result.put("data", "OK");
                    log.info("RegEdit has SUCCESS");
                } else {
                    result.put("retCode", "11111");
                    result.put("retInfo", "FAIL");
                    log.info("RegEdit has FAIL" );
                }
            } else {
                result.put("retCode", "11111");
                result.put("retInfo", "Wrong AuthKey.");
                log.info("RegEdit has wrong AuthKey");
            }
        } catch (Exception e) {
            result.put("retCode", "11111");
            result.put("retInfo", "OY.");
            e.printStackTrace();
            log.error("RegEdit has error > " + e.getMessage());
        }
        return result;
    }

    /**
     * 通过KEY查询信息
     */
    @ResponseBody
    @RequestMapping(value = "/SeaRegK", method = RequestMethod.GET)
    public JSONObject SeaRegK(HttpServletRequest request) {
        String pw = request.getParameter("pw").replace(" ", "");
        JSONObject result = new JSONObject();
        try {
            if (pw.equals("Wp2Sy1314@87881217")) {
                String k = request.getParameter("k");
                if (k == null || k.length() <= 0) {
                    result.put("retCode", "11111");
                    result.put("retInfo", "Wrong Key.");
                    return result;
                }
                k = k.replace(" ", "");
                k = k.replace("\\r", "");
                k = k.replace("\\n", "");
                k = k.replace("\\t", "");
                SvData svData = svDataServ.searchKey(k);
                if (svData == null) {
                    result.put("retCode", "11111");
                    result.put("retInfo", "No Result.");
                    return result;
                } else {
                    result.put("retCode", "00000");
                    result.put("retInfo", "SUCCESS");
                    result.put("data", svData);
                }
            } else {
                result.put("retCode", "11111");
                result.put("retInfo", "Wrong AuthKey.");
            }
        } catch (Exception e) {
            result.put("retCode", "11111");
            result.put("retInfo", "Wrong");
            e.printStackTrace();
        }
        return result;
    }

//	/**
//	 * 通过KEY查询信息
//	 *
//	 * @param request
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping(value = "/SeaRegKtoC", method = RequestMethod.GET)
//	public JSONObject SeaRegKtoC ( HttpServletRequest request ) {
//		JSONObject result = new JSONObject();
//		String k = request.getParameter( "k" );
//		if ( k == null || k.length() <= 0 ) {
//			result.put( "retCode", "11111" );
//			result.put( "retInfo", "Wrong Key." );
//			return result;
//		}
//		SvData svData = svDataServ.searchKeyToC( k );
//		if ( svData == null ) {
//			result.put( "retCode", "11111" );
//			result.put( "retInfo", "No Result." );
//			return result;
//		} else {
//			result.put( "retCode", "00000" );
//			result.put( "retInfo", "SUCCESS" );
//			result.put( "data", svData );
//			return result;
//		}
//	}

//	/**
//	 * 通过版本号查询数量
//	 *
//	 * @param request
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping(value = "/SeaRegV", method = RequestMethod.GET)
//	public JSONObject SeaRegV ( HttpServletRequest request ) {
//		String pw = request.getParameter( "pw" ).replace( " ", "" );
//
//		JSONObject result = new JSONObject();
//		if ( pw.equals( "Wp2Sy1314@87881217" ) ) {
//			String ver = request.getParameter( "ver" );
//			if ( ver == null || ver.length() <= 0 ) {
//				result.put( "retCode", "11111" );
//				result.put( "retInfo", "Wrong Ver." );
//				return result;
//			}
//			int i = svDataServ.searchVer( ver );
//			if ( i == 0 ) {
//				result.put( "retCode", "11111" );
//				result.put( "retInfo", "No Result." );
//				return result;
//			} else {
//				result.put( "retCode", "00000" );
//				result.put( "retInfo", "SUCCESS" );
//				result.put( "data", i );
//				return result;
//			}
//		} else {
//			result.put( "retCode", "11111" );
//			result.put( "retInfo", "Wrong AuthKey." );
//			return result;
//		}
//	}

    /**
     * 通过QQ查询信息
     */
    @ResponseBody
    @RequestMapping(value = "/SeaRegQ", method = RequestMethod.GET)
    public JSONObject SeaRegQ(HttpServletRequest request) {
        String pw = request.getParameter("pw").replace(" ", "");
        JSONObject result = new JSONObject();
        try {
            if (pw.equals("Wp2Sy1314@87881217")) {
                String qq = request.getParameter("qq");
                if (qq == null || qq.length() <= 0) {
                    result.put("retCode", "11111");
                    result.put("retInfo", "Wrong QQ.");
                    return result;
                }
                List<SvData> LsvData = svDataServ.searchQQ(qq);
                if (LsvData == null) {
                    result.put("retCode", "11111");
                    result.put("retInfo", "No Result.");
                } else {
                    result.put("retCode", "00000");
                    result.put("retInfo", "SUCCESS");
                    result.put("data", LsvData);
                }
            } else {
                result.put("retCode", "11111");
                result.put("retInfo", "Wrong AuthKey.");
            }
        } catch (Exception e) {
            result.put("retCode", "11111");
            result.put("retInfo", "Wrong AuthKey.");
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 删除注册信息
     */
    //20171224091841,20181220091841,1518585081,355060010302300,0:0,5694462221514090044
    @ResponseBody
    @RequestMapping(value = "/UnReg", method = RequestMethod.GET)
    public JSONObject UnReg(HttpServletRequest request) {
        String pw = request.getParameter("pw").replace(" ", "");
        JSONObject result = new JSONObject();
        try {
            if (pw.equals("Wp2Sy1314@87881217")) {
                String k = request.getParameter("k");
                if (k.length() <= 0) {
                    k = "00000000000000000000";
                } else {
                    k = k.replace(" ", "");
                    k = k.replace("\\r", "");
                    k = k.replace("\\n", "");
                    k = k.replace("\\t", "");
                }
                if (svDataServ.delete(k) > 0) {
                    result.put("retCode", "00000");
                    result.put("retInfo", "SUCCESS");
                    result.put("data", "OK.");
                } else {
                    result.put("retCode", "11111");
                    result.put("retInfo", "FAIL.");
                }
            } else {
                result.put("retCode", "11111");
                result.put("retInfo", "Wrong AuthKey.");
            }
        } catch (Exception e) {
            result.put("retCode", "11111");
            result.put("retInfo", "Wrong.");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 统计总收入
     */
    @ResponseBody
    @RequestMapping(value = "/CouA", method = RequestMethod.GET)
    public JSONObject CouA(HttpServletRequest request) {
        String pw = request.getParameter("pw").replace(" ", "");
        JSONObject result = new JSONObject();
        try {
            if (pw.equals("Wp2Sy1314@87881217")) {
                List<SvData> LsvData = svDataServ.countAll();
                if (LsvData == null) {
                    result.put("retCode", "11111");
                    result.put("retInfo", "No Result.");
                } else {
                    long totalPrice = 0;
                    for (SvData svData : LsvData) {
                        totalPrice = totalPrice + svData.getPrice();
                    }
                    result.put("retCode", "00000");
                    result.put("retInfo", "SUCCESS");
                    result.put("data", totalPrice);
                }
            } else {
                result.put("retCode", "11111");
                result.put("retInfo", "Wrong AuthKey.");
            }
        } catch (Exception e) {
            result.put("retCode", "11111");
            result.put("retInfo", "Wrong.");
            e.printStackTrace();
        }
        return result;
    }

//	/**
//	 * 辅助登录接口
//	 *
//	 * @param request
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping(value = "/LogInOne", method = RequestMethod.GET)
//	public String LogInOne ( HttpServletRequest request ) {
//		return auth( request.getParameter( "k" ), request.getParameter( "d" ), request.getParameter( "ip" ), request.getParameter( "ver" ), request.getParameter( "g" ) );
//	}
//
//	private String auth ( String k, String d, String ip, String ver, String game ) {
//		if ( k == null || k.length() <= 0 ) {
//			k = "00000000000000000000";
//		} else {
//			k = k.replace( " ", "" );
//			k = k.replace( "\\r", "" );
//			k = k.replace( "\\n", "" );
//			k = k.replace( "\\t", "" );
//			k = k.toUpperCase();
//		}
//		if ( d == null || d.length() <= 0 ) {
//			d = "0";
//		}
//		if ( ip == null || ip.length() <= 0 ) {
//			ip = "0";
//		}
//		if ( ver == null || ver.length() <= 0 ) {
//			ver = "0";
//		}
//		if ( game == null || game.length() <= 0 ) {
//			game = "EF";
//		} else {
//			int a = Integer.valueOf( game );
//			switch ( a ) {
//				case 1:
//					game = "EF";
//					break;
//				case 2:
//					game = "MSI";
//					break;
//				default:
//					game = "no";
//					break;
//			}
//		}
//
//		SvData svData = svDataServ.searchKey( k );
//		if ( svData == null ) {
//			return "997";
//		} else {
//			svData.setDevice( d );
//			svData.setLocalIp( ip );
//			svData.setVersion( ver );
//			svData.setUpdateDt( String.valueOf( new Date().getTime() / 1000 ) );
//			if ( !svData.getGame().equals( game ) ) {
//				return "996";
//			}
//			SimpleDateFormat df = new SimpleDateFormat( "yyyyMMddHHmmss" );//设置日期格式
//			try {
//				long nDate, start, end;
//				nDate = new Date().getTime() / 1000;
//				start = df.parse( svData.getStartDt() ).getTime() / 1000;
//				end = df.parse( svData.getEndDt() ).getTime() / 1000;
//				if ( nDate >= start && nDate <= end ) {
//					svDataServ.updateD( svData );
//					int day = new Long( ( end - nDate ) / ( 60 * 60 * 24 ) ).intValue();
//					if ( day > 5 ) {
//						return "100";
//					} else {
//						String a = "90";
//						switch ( day ) {
//							case 5:
//								a = "95";
//								break;
//							case 4:
//								a = "94";
//								break;
//							case 3:
//								a = "93";
//								break;
//							case 2:
//								a = "92";
//								break;
//							case 1:
//								a = "91";
//								break;
//						}
//						return a;
//					}
//				} else {
//					return "3";
//				}
//			} catch ( ParseException e ) {
//				e.printStackTrace();
//				return "998";
//			}
//		}
//
//
//	}

    /**
     * 辅助登录接口
     */
    @ResponseBody
    @RequestMapping(value = "/LogInTwo", method = RequestMethod.GET)
    public String LogInTwo(HttpServletRequest request) {
        return auth1(request.getParameter("k"), request.getParameter("d"), request.getParameter("ip"), request.getParameter("ver"), request.getParameter("g"));
    }

    private String auth1(String k, String d, String ip, String ver, String game) {
        try {
            if (k == null || k.length() <= 0) {
                k = "00000000000000000000";
            } else {
                k = k.replace(" ", "");
                k = k.replace("\\r", "");
                k = k.replace("\\n", "");
                k = k.replace("\\t", "");
                k = k.toUpperCase();
            }
            if (d == null || d.length() <= 0) {
                d = "0";
            }
            if (ip == null || ip.length() <= 0) {
                ip = "0";
            }
            if (ver == null || ver.length() <= 0) {
                ver = "0";
            }
            if (game == null || game.length() <= 0) {
                game = "EF";
            } else {
                int a = Integer.parseInt(game);
                switch (a) {
                    case 1 -> game = "EF";
                    case 2 -> game = "MSI";
                    default -> game = "no";
                }
            }
            SvData svData = svDataServ.searchKey(k);
            if (svData == null) {
                return "997-0";
            } else {
                svData.setDevice(d);
                svData.setLocalIp(ip);
                svData.setVersion(ver);
                svData.setUpdateDt(String.valueOf(new Date().getTime() / 1000));
                if (!svData.getGame().equals(game)) {
                    return "996-0";
                }
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式

                long nDate, start, end;
                nDate = new Date().getTime() / 1000;
                start = df.parse(svData.getStartDt()).getTime() / 1000;
                end = df.parse(svData.getEndDt()).getTime() / 1000;
                if (nDate >= start && nDate <= end) {
                    svDataServ.updateD(svData);//更新数据的时间
                    int day = Long.valueOf((end - nDate) / (60 * 60 * 24)).intValue();
                    return "100-" + day;
                } else {
                    return "101-0";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "998-0";
        }
    }

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
    @RequestMapping(value = "/api/Update", method = RequestMethod.GET)
    public String Update(HttpServletRequest request) {
        String[] pn = request.getParameter("PackageName").split("\\.");
        String t;
        if (pn[2].equals("efdm")) {
            t = pn[2] + pn[3];
        } else {
            t = pn[2];
        }
        int v_o = Integer.parseInt(request.getParameter("Version"));
        try {
            InputStream is = this.getClass().getResourceAsStream("/version_" + t + ".json");
            int v_n = JSONObject.parseObject(IOUtils.toString(is, StandardCharsets.UTF_8)).getIntValue("Version");
            if (v_n > v_o) {
                InputStream is1 = this.getClass().getResourceAsStream("/update_" + t + ".json");
                try {
                    return IOUtils.toString(is1, StandardCharsets.UTF_8);
                } catch (IOException e) {
                    e.printStackTrace();
                    return "";
                }
            } else {
                return "null";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "null";
        }
    }


    /**
     * 辅助登出接口
     */
    @ResponseBody
    @RequestMapping(value = "/IsLogOutTwo", method = RequestMethod.GET)
    public String IsLogOutTwo(HttpServletRequest request) {
        String k = request.getParameter("k");
        String d = request.getParameter("d");
        return ILO1(k, d);
    }

    private String ILO1(String k, String d) {
        if (k == null || k.length() <= 0) {
            k = "00000000000000000000";
        } else {
            k = k.toUpperCase();
        }
        if (d == null || d.length() <= 0) {
            d = "0";
        }
        try {
            SvData svData = svDataServ.searchKey(k);
            if (svData.getDevice().equals(d)) {
                return "100";
            } else {
                return "101";
            }
        } catch (Exception e) {
            return "101";
        }
    }
}
