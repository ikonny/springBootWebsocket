package cn.hkfdt.xiaot.web.xiaot.service.md;


import cn.hkfdt.xiaot.web.xiaot.util.YSUtils;
import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class XiaoTJdbcDriver {

	static List<String>  urlList = new ArrayList<String>();
	static{
		seturlList("jdbc:mysql://192.168.4.152:3306/LTS_China","tqt001","tqt001");
	}
	private static Connection connection;
	private static int test=0,online=1;
//	String url = "jdbc:mysql://localhost:3306/javademo?"
//            + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
	private static void seturlList(String url, String user, String pass) {
		String tar = url+"?user="+user+"&password="+pass+
				"&connectTimeout=4000&socketTimeout=60000&useUnicode=true&characterEncoding=UTF8";
		urlList.add(tar);
	}
	//这里得同步！
	private static Connection getConnection() {
		if(connection==null){
			initConnection();
		}
		return connection;
	}
	/**
	 * 尝试关闭连接
	 * author:xumin 
	 * 2016-12-20 下午7:53:40
	 */
	public static void closeCon() {
		if(connection!=null){
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//从数据库中拿取行情数据库的配置信息
	@SuppressWarnings("unchecked")
	private static void initConnection() {
		Map<String, Object> map = XiaoTMDDBHelper.getPerSistentInfo(XiaoTMDDBHelper.mdDbKey);
		if(map==null || map.isEmpty()){
			System.err.println("数据库配置出错，行情数据库等出错");
			return;
		}
		String valuejson = map.get("valuejson").toString();
		map = JSON.parseObject(valuejson);//(Map<String, Object>) JsonUtil.JsonToOb(valuejson, map.getClass());
		
		String url = map.get("url").toString();
		String user = map.get("user").toString();
		String pass = map.get("pass").toString();
		urlList.clear();
		seturlList(url, user, pass);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(urlList.get(test));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("数据库配置出错，获取不到行情数据库连接");
		}// 动态加载mysql驱动
	}
	//============================================
	
	
	
	public static void main(String[] args){
		noSW();//不开事务
//		hasSW();//开启事务，注意失败一个sql就回回滚全部
	}
	private static void hasSW() {
		try{
			Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
			connection = DriverManager.getConnection(urlList.get(test));
			connection.setAutoCommit(false);
			//=========里面是自由代码,增删改查===================
			select1();
			//============================================
			connection.commit();
		}catch (Exception  e) {
			try {
				if(connection!=null)
					connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void noSW() {
		try{
			Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
			connection = DriverManager.getConnection(urlList.get(test));
			//=========里面是自由代码,增删改查===================
			testXiaoTSJ();
			//============================================
		}catch (Exception  e) {
		}finally{
			try {
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void testXiaoTSJ() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM xiaot_questions  WHERE questionId = 14";
		Map<String, Object> item = queryForList(sql).get(0);
		byte[] bytes = (byte[]) item.get("jsonData");
		try {
			byte[] tar = YSUtils.uncompress(bytes);
			System.err.println(new String(tar));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//===================================================================
	private static void select1() throws SQLException {
		String sql = "SELECT 1";
		List<Map<String, Object>>  list = queryForList(sql);
		System.err.println(list.toString());
	}
	/**
	 * 执行update，del，或者add的sql时候调用
	 * xumin  2015-6-19 下午4:25:59
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public static int uDorAddorDel(String sql){
		PreparedStatement ps;
		int res = 0;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 查询语句调用
	 * xumin  2015-6-19 下午4:26:32
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public static List<Map<String, Object>> queryForList(String sql) {
		connection = getConnection();
		PreparedStatement ps;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rs==null)
			return null;
		List<Map<String, Object>>  list = getListMapFromRS(rs);
		return list;
	}

	private static List<Map<String, Object>> getListMapFromRS(ResultSet rs) {
		try {
			ResultSetMetaData md;
			md = rs.getMetaData();
			md.getColumnCount();
			int num = md.getColumnCount();
			rs.last();
			int rows = rs.getRow();//获取一共行数
			List<Map<String, Object>> listOfRows = new ArrayList<Map<String, Object>>(rows); //
			
			rs.beforeFirst();//游标返回
			while (rs.next()) {
				Map<String, Object> mapOfColValues = new HashMap<String, Object>(num);  
				for (int i = 1; i <= num; i++) {
					String name = md.getColumnName(i);
					Object ob = rs.getObject(i);
					mapOfColValues.put(name, ob);  
				}
				listOfRows.add(mapOfColValues);  
			} 
			return listOfRows;  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;  
	}
	
	
}
