package cms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
	public static Connection getConn() { // 取得数据库链接
		try {
			// 注册驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost/cmsold";
		Connection conn = null;
		try {
			// 获得数据库链接
			conn = DriverManager.getConnection(url, "root", "mysql");
			// 表示关闭事务不自动提交
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; // 返回连接

	}

	public static void close(ResultSet rs) {
		try {
			rs.close(); // 关闭结果集
			rs = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close(); // 关闭发送环境
			pstmt = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn) {
		try {
			conn.close(); // 关闭链接
			conn = null; // 会立刻被回收掉
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection conn) {
		if (conn != null) {
			try {
				conn.commit();// 手动提交事务
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void rollback(Connection conn) {

		if (conn != null) {
			try {
				conn.rollback();// 回滚事务
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
