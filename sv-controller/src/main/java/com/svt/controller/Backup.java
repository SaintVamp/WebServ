package com.svt.controller;

public class Backup {

//	@ResponseBody
//	@RequestMapping(value = "/Download", produces = "application/vnd.android.package-archive", method = RequestMethod.GET)
//	public void download ( HttpServletRequest request, HttpServletResponse response )
//			throws Exception {
//		//声明本次下载状态的记录对象
//		//设置响应头和客户端保存文件名
//		response.setCharacterEncoding( "utf-8" );
//		response.setContentType( "multipart/form-data" );
//		response.setHeader( "Content-Disposition", "attachment;fileName=SV.apk" );
//		//用于记录以完成的下载的数据量，单位是byte
//		long downloadedLength = 0l;
//		try {
//			//打开本地文件流
//			InputStream inputStream = new FileInputStream( String.valueOf( this.getClass().getResource( "/SV.apk" ) ).replace( "file:", "" ) );
//			//激活下载操作
//			OutputStream os = response.getOutputStream();
//
//			//循环写入输出流
//			byte[] b = new byte[ 2048 ];
//			int length;
//			while ( ( length = inputStream.read( b ) ) > 0 ) {
//				os.write( b, 0, length );
//				downloadedLength += b.length;
//			}
//
//			// 这里主要关闭。
//			os.close();
//			inputStream.close();
//		} catch ( Exception e ) {
//			throw e;
//		}
//	}

//
//	/**将16进制转换为二进制
//	 * @param hexStr
//	 * @return
//	 */
//	public static byte[] parseHexStr2Byte(String hexStr) {
//		if (hexStr.length() < 1)
//			return null;
//		byte[] result = new byte[hexStr.length()/2];
//		for (int i = 0;i< hexStr.length()/2; i++) {
//			int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
//			int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
//			result[i] = (byte) (high * 16 + low);
//		}
//		return result;
//	}
//	/**将二进制转换成16进制
//	 * @param buf
//	 * @return
//	 */
//	public static String parseByte2HexStr(byte buf[]) {
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < buf.length; i++) {
//			String hex = Integer.toHexString(buf[i] & 0xFF);
//			if (hex.lenwgth() == 1) {
//				hex = '0' + hex;
//			}
//			sb.append(hex.toUpperCase());
//		}
//		return sb.toString();
//	}
//
//	String content = "test";
//	String password = "12345678";
//加密
//System.out.println("加密前：" + content);
//	byte[] encryptResult = encrypt(content, password);
//	String encryptResultStr = parseByte2HexStr(encryptResult);
//System.out.println("加密后：" + encryptResultStr);
//	//解密
//	byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);
//	byte[] decryptResult = decrypt(decryptFrom,password);
//System.out.println("解密后：" + new String(decryptResult));
//	public String EncoderByMd5( String str ) {
////确定计算方法
//		try {
//			MessageDigest md5 = MessageDigest.getInstance( "MD5" );
//			BASE64Encoder base64en = new BASE64Encoder( );
////加密后的字符串
//			String newstr = base64en.encode( md5.digest( str.getBytes( "utf-8" ) ) );
//			return newstr;
//		} catch ( NoSuchAlgorithmException e ) {
//			e.printStackTrace( );
//			return "";
//		} catch ( UnsupportedEncodingException e ) {
//			e.printStackTrace( );
//			return "";
//		}
//	}

//	@ResponseBody
//	@RequestMapping(value = "/Be64", method = RequestMethod.GET)
//	public String Be64( HttpServletRequest request ) {
//		return b64( request.getParameter( "s" ) );
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/Dn64", method = RequestMethod.GET)
//	public String Dn64( HttpServletRequest request ) {
//		return d64( request.getParameter( "s" ) );
//	}
//
//	private String d64( String s ) {
//		return new String( UrlSafeBase64.decode( s ) );
//	}
//
//	private String b64( String s ) {
//		return UrlSafeBase64.encodeToString( s );
//	}


//	@ResponseBody
//	@RequestMapping(value = "/Reg", method = RequestMethod.GET)
//	public String Reg( HttpServletRequest request ) {
//		String a = UrlSafeBase64.encodeToString( request.getParameter( "a" ) + String.valueOf( System.currentTimeMillis( ) / 1000 ) );
//		String s= request.getParameter( "s" ) + getHMS( );
//		String e = request.getParameter( "e" ) + getHMS( );
//
//		writeFile( UrlSafeBase64.encodeToString( s + "," + e + "," + String.valueOf( System.currentTimeMillis( ) / 1000 ) + ",0,0" ), a, filePath );
//		return a;
//	}

//	@ResponseBody
//	@RequestMapping(value = "/SeaReg", method = RequestMethod.GET)
//	public String SeaReg( HttpServletRequest request ) {
//		String k = request.getParameter( "k" );
//		if ( k == null || k.length( ) <= 0 ) {
//			k = "00000000000000000000";
//		}
//		String regText = null;
//		try {
//			regText = readFile( k, filePath );
//		} catch ( FileNotFoundException fnfe ) {
//			fnfe.printStackTrace( );
//		} catch ( IOException ioe ) {
//			ioe.printStackTrace( );
//		}
////		regText = d64( regText ) + "," + d64( k );
//		return regText;
//	}

//	@ResponseBody
//	@RequestMapping(value = "/UnReg", method = RequestMethod.GET)
//	public String UnReg( HttpServletRequest request ) {
//		String k = request.getParameter( "k" );
//		if ( k.length( ) <= 0 ) {
//			k = "00000000000000000000";
//		}
//		if ( deleteFile( k ) ) {
//			return "OK";
//		} else {
//			return "FAIL";
//		}
//	}

//	@ResponseBody
//	@RequestMapping(value = "/RegEdit", method = RequestMethod.GET)
//	public String RegEdit( HttpServletRequest request ) {
//		String k = request.getParameter( "k" );
//		String s = request.getParameter( "s" ) + getHMS( );
//		String e = request.getParameter( "e" ) + getHMS( );
//		String d = request.getParameter( "d" );
//		String ip = request.getParameter( "ip" );
////		writeFile( UrlSafeBase64.encodeToString( s + "," + e + "," + String.valueOf( System.currentTimeMillis( ) / 1000 ) + "," + d + "," + ip ), k, filePath );
//		return k;
//	}

//	@ResponseBody
//	@RequestMapping(value = "/LogInOne", method = RequestMethod.GET)
//	public String LogInOne( HttpServletRequest request ) {
//		String k = request.getParameter( "k" );
//		String d = request.getParameter( "d" );
//		String ip = request.getParameter( "ip" );
//		return auth( k, d, ip );
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/IsLogOutOne", method = RequestMethod.GET)
//	public String IsLogOutOne( HttpServletRequest request ) {
//		String k = request.getParameter( "k" );
//		String d = request.getParameter( "d" );
//		return ILO( k, d );
//	}

//	@ResponseBody
//	@RequestMapping(value = "/LogInFour", method = RequestMethod.GET)
//	public String LogInFour( HttpServletRequest request ) {
//		return "999";
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/IsLogOutFour", method = RequestMethod.GET)
//	public String IsLogOutFour( HttpServletRequest request ) {
//		return "999";
//	}

//	private String auth( String k, String d, String ip ) {
//		if ( k == null || k.length( ) <= 0 ) {
//			k = "00000000000000000000";
//		}
//		if ( d == null || d.length( ) <= 0 ) {
//			d = "0";
//		}
//		if ( ip == null || ip.length( ) <= 0 ) {
//			ip = "0";
//		}
//		String regText = "";
//		try {
//			regText = readFile( k, filePath );
//		} catch ( FileNotFoundException fnfe ) {
//			return "1";
//		} catch ( IOException ioe ) {
//			return "1";
//		}
//		if ( regText.length( ) <= 0 ) {
//			return "1";
//		}
////		regText = d64( regText );
//		String[] text = regText.split( "," );
//		regText = text[ 0 ] + "," + text[ 1 ] + "," + String.valueOf( System.currentTimeMillis( ) / 1000 ) + "," + d + "," + ip;
//		SimpleDateFormat df = new SimpleDateFormat( "yyyyMMddHHmmss" );//设置日期格式
//		try {
//			long nDate, start, end;
//			nDate = new Date( ).getTime( );
//			start = df.parse( text[ 0 ] ).getTime( );
//			end = df.parse( text[ 1 ] ).getTime( );
//			if ( nDate >= start && nDate <= end ) {
////				writeFile( b64( regText ), k, filePath );
//				int day = new Long( ( end - nDate ) / ( 1000 * 60 * 60 * 24 ) ).intValue( );
//				if ( day > 5 ) {
//					return "100";
//				} else {
//					String a = "90";
//					switch ( day ) {
//						case 5:
//							a = "95";
//							break;
//						case 4:
//							a = "94";
//							break;
//						case 3:
//							a = "93";
//							break;
//						case 2:
//							a = "92";
//							break;
//						case 1:
//							a = "91";
//							break;
//					}
//					return a;
//				}
//			} else {
//				return "3";
//			}
//		} catch ( ParseException e ) {
//			e.printStackTrace( );
//			return "998";
//		}
//	}
//
//	private String ILO( String k, String d ) {
//		if ( k == null || k.length( ) <= 0 ) {
//			k = "00000000000000000000";
//		}
//		if ( d == null || d.length( ) <= 0 ) {
//			d = "0";
//		}
//		String regText = null;
//		try {
//			regText = readFile( k, filePath );
//		} catch ( FileNotFoundException fnfe ) {
//			return "1";
//		} catch ( IOException ioe ) {
//			return "1";
//		}
//		if ( regText.length( ) <= 0 ) {
//			return "1";
//		}
////		regText = d64( regText );
//		String[] text = regText.split( "," );
//		if ( text[ 3 ].equals( d ) ) {
//			return "100";
//		} else {
//			return "2";
//		}
//	}

//	/**
//	 * 删除单个文件
//	 *
//	 * @param fileName 被删除文件的文件名
//	 * @return 单个文件删除成功返回true，否则返回false
//	 */
//	public boolean deleteFile( String fileName ) {
//		boolean flag = false;
//		File file = new File( filePath + "/" + fileName );
//		// 路径为文件且不为空则进行删除
//		if ( file.isFile( ) && file.exists( ) ) {
//			file.delete( );
//			flag = true;
//		}
//		return flag;
//	}

	// 生成文件夹
//	private void createDirectory( String filePath ) {
//		File file = null;
//		try {
//			file = new File( filePath );
//			if ( !file.exists( ) ) {
//				file.mkdir( );
//			}
//		} catch ( Exception e ) {
//			e.printStackTrace( );
//		}
//	}

//	// 生成文件
//	private File createFile( String fileName, String filePath ) {
//		createDirectory( filePath );
//		File file = null;
//		try {
//			file = new File( filePath + "/" + fileName );
//			if ( !file.exists( ) ) {
//				file.createNewFile( );
//			}
//		} catch ( Exception e ) {
//			e.printStackTrace( );
//		}
//		return file;
//	}

//	// 将字符串写入到文本文件中
//	private void writeFile( String str, String fileName, String filePath ) {
//		File file = createFile( fileName, filePath );
//		try {
//			InputStream is = new ByteArrayInputStream( str.getBytes( ) );
//			FileOutputStream fos = new FileOutputStream( file );
//			byte[] buffer = new byte[ 2000 ];
//			int count = 0;
//			while ( ( count = is.read( buffer ) ) > 0 ) {
//				fos.write( buffer, 0, count );
//			}
//			fos.flush( );
//			fos.close( );
//			is.close( );
//		} catch ( Exception e ) {
//		}
//	}

//	private String readFile( String fileName, String filePath ) throws FileNotFoundException, IOException {
//		byte[] bys = new byte[ 1024 ];
//		int len = 0;
//		String str = "";
//		BufferedInputStream bis = new BufferedInputStream( new FileInputStream( filePath + "/" + fileName ) );
//		while ( ( len = bis.read( bys ) ) != -1 ) {
//			str = str + new String( bys, 0, len );
//		}
//		// 释放资源
//		bis.close( );
//		return str;
//	}

//	private String getHMS() {
//		Date d = new Date( );
////		System.out.println( d );
//		SimpleDateFormat sdf = new SimpleDateFormat( "HHmmss" );
//		String dateNowStr = sdf.format( d );
////		System.out.println( "格式化后的日期：" + dateNowStr );
//		return dateNowStr;
//	}
}
