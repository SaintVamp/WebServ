package com.svt.dao.impl;

import com.svt.common.MysqlUtil;
import com.svt.dao.SvDataDao;
import com.svt.entity.SvData;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Repository
@Lazy()
public class SvDataDaoImpl implements SvDataDao {

    @Override
    public int reg( SvData svData) throws Exception {
        return new MysqlUtil().pub_set("INSERT INTO svData(qqNum,authCode,device,startDt,endDt,localIp,price,updateDt,version,game)VALUES('" + svData.getQqNum() + "','" + svData.getAuthCode() + "','" + svData.getDevice() + "','" + svData.getStartDt() + "','" + svData.getEndDt() + "','" + svData.getLocalIp() + "'," + svData.getPrice() + ",'" + svData.getUpdateDt() + "','" + svData.getVersion() + "','" + svData.getGame() + "')");
    }

    @Override
    public int update( SvData svData) throws Exception {
        return new MysqlUtil().pub_set("UPDATE svData SET device = '" + svData.getDevice() + "',endDt = '" + svData.getEndDt() + "',localIp = '" + svData.getLocalIp() + "',startDt = '" + svData.getStartDt() + "',updateDt = '" + svData.getUpdateDt() + "',price = price + " + svData.getPrice() + " WHERE authCode = '" + svData.getAuthCode() + "'");
    }

    @Override
    public int updateD( SvData svData) throws Exception {
        return new MysqlUtil().pub_set("UPDATE svData SET device = '" + svData.getDevice() + "',updateDt = '" + svData.getUpdateDt() + "',version = " + svData.getVersion() + " WHERE authCode = '" + svData.getAuthCode() + "'");
    }

    @Override
    public List<SvData> searchQQ( String qq) throws Exception {
        Connection conn = new MysqlUtil().open();
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM svData WHERE qqNum = '" + qq + "'";
        ResultSet rs = stmt.executeQuery(sql);
        List<SvData> lsv = new ArrayList<>();
        while (rs.next()) {
            SvData svData = new SvData();
            svData.setQqNum(rs.getString("qqNum"));
            svData.setAuthCode(rs.getString("authCode"));
            svData.setDevice(rs.getString("device"));
            svData.setStartDt(rs.getString("startDt"));
            svData.setEndDt(rs.getString("endDt"));
            svData.setLocalIp(rs.getString("localIp"));
            svData.setPrice(rs.getInt("price"));
            svData.setUpdateDt(rs.getString("updateDt"));
            svData.setVersion(rs.getString("version"));
            svData.setGame(rs.getString("game"));
            lsv.add(svData);
        }
        rs.close();
        stmt.close();
        conn.close();
        return lsv;
    }

    @Override
    public int searchVer(String ver) throws Exception {
        Connection conn = new MysqlUtil().open();
        Statement stmt = conn.createStatement();
        String sql = "SELECT count(*) total FROM svData WHERE version = '" + ver + "'";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        int rowcount = rs.getInt("total");
        rs.close();
        stmt.close();
        conn.close();
        return rowcount;
    }

    @Override
    public SvData searchKey( String k) throws Exception {
        Connection conn = new MysqlUtil().open();
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM svData WHERE authCode = '" + k + "'";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        SvData svData = new SvData();
        svData.setQqNum(rs.getString("qqNum"));
        svData.setAuthCode(rs.getString("authCode"));
        svData.setDevice(rs.getString("device"));
        svData.setStartDt(rs.getString("startDt"));
        svData.setEndDt(rs.getString("endDt"));
        svData.setLocalIp(rs.getString("localIp"));
        svData.setPrice(rs.getInt("price"));
        svData.setUpdateDt(rs.getString("updateDt"));
        svData.setVersion(rs.getString("version"));
        svData.setGame(rs.getString("game"));
        rs.close();
        stmt.close();
        conn.close();
        return svData;

    }

    @Override
    public SvData searchKeyToC( String k) throws Exception {
        Connection conn = new MysqlUtil().open();
        Statement stmt = conn.createStatement();
        String sql = "SELECT startDt,endDt FROM svData WHERE authCode = '" + k + "'";
        ResultSet rs = stmt.executeQuery(sql);
        SvData svData = new SvData();
        svData.setStartDt(rs.getString("startDt"));
        svData.setEndDt(rs.getString("endDt"));
        rs.close();
        stmt.close();
        conn.close();
        return svData;
    }

    @Override
    public List<SvData> countAll() throws Exception {
        Connection conn = new MysqlUtil().open();
        Statement stmt = conn.createStatement();
        String sql = "SELECT price FROM svData";
        ResultSet rs = stmt.executeQuery(sql);
        List<SvData> lsv = new ArrayList<>();
        while (rs.next()) {
            SvData svData = new SvData();
            svData.setPrice(rs.getInt("price"));
            lsv.add(svData);
        }
        rs.close();
        stmt.close();
        conn.close();
        return lsv;
    }

    @Override
    public List<SvData> searchAll() throws Exception {
        Connection conn = new MysqlUtil().open();
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM svData";
        ResultSet rs = stmt.executeQuery(sql);
        List<SvData> lsv = new ArrayList<>();
        while (rs.next()) {
            SvData svData = new SvData();
            svData.setQqNum(rs.getString("qqNum"));
            svData.setAuthCode(rs.getString("authCode"));
            svData.setDevice(rs.getString("device"));
            svData.setStartDt(rs.getString("startDt"));
            svData.setEndDt(rs.getString("endDt"));
            svData.setLocalIp(rs.getString("localIp"));
            svData.setPrice(rs.getInt("price"));
            svData.setUpdateDt(rs.getString("updateDt"));
            svData.setVersion(rs.getString("version"));
            svData.setGame(rs.getString("game"));
            lsv.add(svData);
        }
        rs.close();
        stmt.close();
        conn.close();
        return lsv;
    }

    @Override
    public int delete(String k) throws Exception {
        return new MysqlUtil().pub_set("DELETE FROM svData WHERE authCode = '" + k + "'");
    }

    @Override
    public int authCodeExist( SvData svData) throws Exception {
        String updateDt = new MysqlUtil().pub_get("SELECT updateDt FROM svData WHERE authCode = '" + svData.getAuthCode() + "'", "updateDt");
        if (updateDt.length() > 0) {
            if (svData.getUpdateDt().equals(updateDt)) {
                return 0;//数据未更新不用同步
            } else {
                return 1;//数据更新过要同步
            }
        } else {
            return 2;//无数据要同步
        }
    }

    @Override
    public int addSV( SvData svData) throws Exception {
        return new MysqlUtil().pub_set("INSERT INTO svData (qqNum, authCode, device, startDt, endDt, localIp, price, updateDt, version, game) VALUES ('" + svData.getQqNum() + "','" + svData.getAuthCode() + "','" + svData.getDevice() + "','" + svData.getStartDt() + "','" + svData.getEndDt() + "','" + svData.getLocalIp() + "','" + svData.getPrice() + "','" + svData.getUpdateDt() + "','" + svData.getVersion() + "','" + svData.getGame() + "')");
    }

    @Override
    public int modSV( SvData svData) throws Exception {
        return new MysqlUtil().pub_set("UPDATE svData SET qqNum = '" + svData.getQqNum() + "',device = '" + svData.getDevice() + "',startDt = '" + svData.getStartDt() + "',endDt = '" + svData.getEndDt() + "',localIp = '" + svData.getLocalIp() + "',price = " + svData.getPrice() + ",updateDt = '" + svData.getUpdateDt() + "',version = '" + svData.getVersion() + "',game = '" + svData.getGame() + "' WHERE authCode = '" + svData.getAuthCode() + "'");
    }
}
