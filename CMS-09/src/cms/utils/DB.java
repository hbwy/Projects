package cms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
	public static Connection getConn() { // ȡ�����ݿ�����
		try {
			// ע������
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost/cmsold";
		Connection conn = null;
		try {
			// ������ݿ�����
			conn = DriverManager.getConnection(url, "root", "mysql");
			// ��ʾ�ر������Զ��ύ
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; // ��������

	}

	public static void close(ResultSet rs) {
		try {
			rs.close(); // �رս����
			rs = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close(); // �رշ��ͻ���
			pstmt = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn) {
		try {
			conn.close(); // �ر�����
			conn = null; // �����̱����յ�
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection conn) {
		if (conn != null) {
			try {
				conn.commit();// �ֶ��ύ����
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void rollback(Connection conn) {

		if (conn != null) {
			try {
				conn.rollback();// �ع�����
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
