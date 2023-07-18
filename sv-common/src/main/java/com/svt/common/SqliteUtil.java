package com.svt.common;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.svt.entity.SvData;
import org.bson.Document;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqliteUtil {

    public Connection openZuk() {
        return open("count.db");
    }

    public Connection openSv() {
        return open("SVData.db");
    }

    public Connection open(String DBName) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite::resource:" + DBName);
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:/opt/data/" + DBName);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String pub_get(String sql,  String... columns) throws Exception {
        Statement stmt = openZuk().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        StringBuilder r_str = new StringBuilder();
        while (rs.next()) {
            for (String column : columns) {
                r_str.append(rs.getString(column)).append(",");
            }
        }
        rs.close();
        stmt.close();
        if (r_str.length() > 0) {
            return r_str.deleteCharAt(r_str.lastIndexOf(",")).toString();
        } else {
            return "";
        }
    }

    public String pub_get_Sv(String sql, String... columns) throws Exception {
        Statement stmt = openSv().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        StringBuilder r_str = new StringBuilder();
        while (rs.next()) {
            for (String column : columns) {
                r_str.append(rs.getString(column)).append(",");
            }
        }
        rs.close();
        stmt.close();
        if (r_str.length() > 0) {
            return r_str.deleteCharAt(r_str.lastIndexOf(",")).toString();
        } else {
            return "";
        }
    }

    public int pub_set(String sql) throws Exception {
        Statement stmt = openZuk().createStatement();
        int rowcount = stmt.executeUpdate(sql);
        stmt.close();
        return rowcount;
    }

    public int pub_set_Sv(String sql) throws Exception {
        Statement stmt = openSv().createStatement();
        int rowcount = stmt.executeUpdate(sql);
        stmt.close();
        return rowcount;
    }

    public List<SvData> mongoDb() {
        try {
            /*
             * MongoClient               ���ӷ�����
             * MongoDatabase             �������ݿ�
             * MongoCollection           ���ӱ�
             * FindIterable<Document>    ��¼�͵�����
             * MongoCursor               ��¼�α�
             * Ӧ��˳�� ������-->���ݿ�-->��-->��¼������-->��¼�α�
             */
            List<SvData> svDataList = new ArrayList<>();
            MongoClientURI uri = new MongoClientURI("mongodb://svtool:12086F465CEB74B3BD676C39DA07900C@39.100.245.149:30000/SV");
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("SV");
            MongoCollection<Document> collection = mongoDatabase.getCollection("svData");
            FindIterable<Document> findIterable = collection.find();
            /*
             * �α����-->��ȡ��¼-->��ȡ�ֶ�ֵ
             */
            for (Document svDataDoc : findIterable) {
                SvData svData = new SvData();
                svData.setVersion(svDataDoc.getString("version"));
                svData.setAuthCode(svDataDoc.getString("authCode"));
                svData.setDevice(svDataDoc.getString("device"));
                svData.setEndDt(svDataDoc.getString("endDt"));
                svData.setUpdateDt(svDataDoc.getString("updateDt"));
                svData.setPrice(svDataDoc.getInteger("price"));
                svData.setGame(svDataDoc.getString("game"));
                svData.setStartDt(svDataDoc.getString("startDt"));
                svData.setLocalIp(svDataDoc.getString("localIp"));
                svData.setQqNum(svDataDoc.getString("qqNum"));
                svDataList.add(svData);
            }
            mongoClient.close();
            return svDataList;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
