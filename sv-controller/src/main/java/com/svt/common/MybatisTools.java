package com.svt.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

/**
 * [Project]:
 * [Email]:
 * [Date]:2021/1/22
 * [Description]:
 * 7、为了方便测试，编写一个获取SqlSession的工具类MybatisTools
 * 该类主要是加载mybatis的配置文件（如：mybatis-config.xml等），然后
 *
 * 使用的时候:
 * 1）先 MybatisTools mt = new MybatisTools(resourceXMLFile)  // 这里的resourceXMLFile是mybatis的配置文件，如"mybatis-config.xml"
 * 2) SqlSession sqlSession = mt.openCurrentSqlSession()  // 按照配置文件打开获取 SqlSession
 * 3) TestMapper testMapper = sqlSession.getMapper(TestMapper.class); // 这里的 TestMapper.class 是实体和数据库的交互接口。
 * 4) testMapper.getAll()  // 调用方法
 * 5) mt.closeCurrentSqlSession() // 关闭 SqlSession
 * @author zc
 */
public class MybatisTools {
    private static ExecutorType executorType;
    private static SqlSessionFactory sqlSessionFactory;
    private static final ThreadLocal<SqlSession> sessionThread = new ThreadLocal<>();


    public MybatisTools ( ) {
        initSqlSessionFactory();
    }


    public MybatisTools ( ExecutorType executorType ) {
        initSqlSessionFactory();
        MybatisTools.executorType = executorType;
    }

    private static void initSqlSessionFactory() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession openCurrentSqlSession() {
        SqlSession sqlSession = sessionThread.get();
        if (Objects.isNull(sqlSession)) {
            if(executorType == null) {
                sqlSession = sqlSessionFactory.openSession();
            } else {
                sqlSession = sqlSessionFactory.openSession(executorType);
            }
            sessionThread.set(sqlSession);
        }
        return sqlSession;
    }

    public static void commitCurrentSqlSession() {
        SqlSession sqlSession = sessionThread.get();
        if (Objects.nonNull(sqlSession)) {
            sqlSession.commit();
        }
    }

    public static void closeCurrentSqlSession() {
        SqlSession sqlSession = sessionThread.get();
        if (Objects.nonNull(sqlSession)) {
            sqlSession.close();
        }
        sessionThread.set(null);
    }
}
