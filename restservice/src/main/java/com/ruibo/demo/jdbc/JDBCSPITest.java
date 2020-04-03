package com.ruibo.demo.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCSPITest {


	public static void main(String[] args) {

	}


	public void testJDBC() {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			// 注意：在JDBC 4.0规范中，这里可以不用再像以前那样编写显式加载数据库的代码了
			// Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库连接，注意【这里将会加载mysql的驱动包】
			/***************【主线，切入点】****************/
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			// 创建Statement语句
			statement = connection.createStatement();
			// 执行查询语句
			rs = statement.executeQuery("select * from user");
			// 遍历查询结果集
			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ...省略释放资源的代码
		}
	}
}
