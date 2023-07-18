package com.svt.common;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

public class SVUtil {

	public static <T> Object JSONToObj ( String jsonStr, Class<T> obj ) {
		T t = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			t = objectMapper.readValue( jsonStr, obj );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return t;
	}


	public static @NotNull String StrDecode ( String @NotNull [] strings, int num, String flag ) {
		StringBuilder allStr = new StringBuilder();
		int i = 0;
		for ( String s : strings ) {
			if ( !s.equals( "" ) ) {
				int a = dec( i + 1, Integer.parseInt( s ), num );
				char c = (char) a;
				allStr.append( c );
				i++;
			}
		}
		if ( flag.equals( "json" ) ) {
			if ( !allStr.substring( 0, 1 ).equals( "{" ) ) {
				allStr = new StringBuilder( "{" + allStr + "}" );
				allStr = new StringBuilder( allStr.toString().replace( " ", "," ) );
			}
		}
		return allStr.toString();
	}


	public static String StrEncode ( @NotNull String str, int num ) {
		ArrayList<String> allArr = new ArrayList<>();
		int i = 0;
		for ( char c : str.toCharArray() ) {
			allArr.add( String.valueOf( enc( i + 1, c, num ) ) );
			i++;
		}
		return array2string( allArr );
	}


	public static String array2string ( @NotNull ArrayList<String> array ) {
		StringBuilder str = new StringBuilder();
		for ( String value : array ) {
			str.append( value ).append( "," );
		}
		String s;
		if ( str.length() != 0 ) {
			s = str.substring( 0, str.length() - 1 );
		} else {
			s = str.toString();
		}
		return s;
	}

	public static int enc ( int i, int instr, int num ) {
		int m = i % 6;
		int temp = 0;
		if ( m == 0 ) {
			temp = num - ( instr + 22 - m ) * 6;
		} else if ( m == 1 ) {
			temp = num - instr - 22 * m + 6;
		} else if ( m == 2 ) {
			temp = num - instr + 22 / m * 6;
		} else if ( m == 3 ) {
			temp = num - instr * 22 - m * 6;
		} else if ( m == 4 ) {
			temp = num - instr * 22 + m - 6;
		} else if ( m == 5 ) {
			temp = num - ( instr - 22 ) * m + 6;
		}
		return temp;
	}

	public static int dec ( int i, int instr, int num ) {
		int m = i % 6;
		int temp = 0;
		if ( m == 0 ) {
			temp = ( num - instr ) / 6 - 22 + m;
		} else if ( m == 1 ) {
			temp = num - instr - 22 * m + 6;
		} else if ( m == 2 ) {
			temp = num - instr + 22 * 6 / m;
		} else if ( m == 3 ) {
			temp = ( num - instr - m * 6 ) / 22;
		} else if ( m == 4 ) {
			temp = ( num - instr + m - 6 ) / 22;
		} else if ( m == 5 ) {
			temp = ( num - instr + 6 ) / m + 22;
		}
		return temp;
	}

	public static String StrEncB64 ( @NotNull String str ) {
		byte[] bytes = str.getBytes();
//Base64 加密
		return Base64.getEncoder().encodeToString( bytes );
	}

	public static @NotNull String StrDecB64 ( String str ) {
//Base64 解密
		byte[] decoded = Base64.getDecoder().decode( str );
		return new String( decoded );
	}

	public static @NotNull String ts2time ( String ts ) {
		String tsStr;
		DateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		if ( ts.length() == 0 ) {
			ts = "0";
		}
		tsStr = sdf.format( new Date( Long.parseLong( ts ) * 1000 ) );
		return tsStr;
	}

	public static String time2ts2 ( String times ) {
		Timestamp ts;
		ts = Timestamp.valueOf( times );
		return String.valueOf( ts );
	}

	public static String time2ts ( String times ) {
		Date d = new Date();
		long ts;
		try {
			SimpleDateFormat st = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
			d = st.parse( times );
		} catch ( ParseException e ) {
			e.printStackTrace();
		}
		ts = d.getTime() / 1000;
		return String.valueOf( ts );
	}

	public static JSONObject parseJson (int seed, @NotNull JSONObject jsonObject ) {
		String data = jsonObject.getString( "data" );
		String a = StrDecB64( data );
		String[] b = a.split( "," );
		String c = StrDecode( b, seed, "json" );
		return JSONObject.parseObject( c );
	}

	public static String tabletOnLan ( String mac ) {
		if ( mac.length() != 12 ) {
			return "mac len error :" + mac.length();
		}
		String ip = "255.255.255.255";//广播IP地址
		int port = 9;//端口号
		//魔术包数据
		String sBuffer = "FFFFFFFFFFFF" +
				mac.repeat( 16 );
		byte[] command = hexToBinary( sBuffer );
		try {
			InetAddress address = InetAddress.getByName( ip );
			//MulticastSocket socket = new MulticastSocket(port);
			DatagramSocket socket = new DatagramSocket( port );
			DatagramPacket packet = new DatagramPacket( command, command.length, address, port );
			socket.send( packet );
			socket.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return "命令已发送";
	}

	/**
	 * 将16进制字符串转换为用byte数组表示的二进制形式
	 *
	 * @param hexString：16进制字符串
	 * @return byte[] 用byte数组表示的十六进制数
	 */
	private static byte[] hexToBinary ( String hexString ) {
		hexString = hexString.toUpperCase().replace( "0X", "" );
		byte[] result = new byte[ hexString.length() / 2 ];
		for ( int i = 0; i < hexString.length() / 2; i++ ) {
			result[ i ] = (byte) ( ( hexToDec( hexString.charAt( i + i ) ) << 4 ) | ( hexToDec( hexString.charAt( i + i + 1 ) ) ) );
		}
		return result;
	}

	private static byte hexToDec ( char c ) {
		c = Character.toUpperCase( c );
		return (byte) ( c < 'A' ? ( c - '0' ) : ( c - 'A' + 10 ) );
	}
}
