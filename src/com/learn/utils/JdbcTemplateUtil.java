package com.learn.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTemplateUtil {

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	private static Connection getConnection() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/learn_db";
		String username = "root";
		String password = "";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 通过泛型封装插入方法
	 * 
	 * @param t
	 * @return
	 */
	public static <T> int insert(T t) {
		// 需要掌握java基础中的反射机制
		Class<?> clazz = t.getClass();
		// 获取实体类的所有属性
		Field[] declaredFields = clazz.getDeclaredFields();

		String sqlBuiderS = "insert into tb_" + clazz.getSimpleName().toLowerCase() + " (";
		String sqlBuiderE = " values (";
		for (int index = 0; index < declaredFields.length; index++) {
			declaredFields[index].setAccessible(true);
			try {
				if (declaredFields[index].get(t) != null) {
					sqlBuiderS += camelToUnderline(declaredFields[index].getName()) + ",";
					sqlBuiderE += "'" + declaredFields[index].get(t) + "',";
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sqlBuiderS = sqlBuiderS.substring(0, sqlBuiderS.length() - 1) + ")";
		sqlBuiderE = sqlBuiderE.substring(0, sqlBuiderE.length() - 1) + ")";
		String sql = sqlBuiderS + sqlBuiderE;
		Connection conn = getConnection();
		int i = 0;
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static final char UNDERLINE = '_';

	/**
	 * 改成驼峰状
	 * 
	 * @param param
	 * @return
	 */
	public static String camelToUnderline(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append(UNDERLINE);
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
