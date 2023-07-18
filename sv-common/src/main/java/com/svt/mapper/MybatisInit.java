package com.svt.mapper;

import com.svt.common.MybatisTools;
import org.apache.ibatis.session.SqlSession;

public class MybatisInit {
	public MybatisTools mybatisTools;

	public <T> Object init ( String className ) {
		try {
			mybatisTools = new MybatisTools();
			SqlSession sqlSession = mybatisTools.openCurrentSqlSession();
			//得到 TestMapper 接口的实现类对象，TestMapper 接口的实现类对象由 sqlSession.getMapper(TestMapper.class)动态构建出来
			return sqlSession.getMapper( Class.forName( className ) );
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
			return null;
		}
	}
}
