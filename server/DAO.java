package server;

import client.UserInfo;
import util.Data;

import java.sql.*;

public class DAO {
	private static final String jdbcUrl = "jdbc:mysql://localhost:3306/tinc?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC"; // DB
																																		// 주소
	private static final String userId = "root"; // 사용자계정
	private static final String userPass = "12345"; // 사용자 패스워드

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public DAO() {
	}

	private static DAO obj;

	static DAO getInstance() {
		if (obj == null)
			obj = new DAO();

		return obj;
	}

	private boolean connect() {
		boolean result = false;
		try {
			conn = DriverManager.getConnection(jdbcUrl, userId, userPass);
			stmt = conn.createStatement();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Data login(UserInfo userInfo) {
		Data result = new Data("EMPTY", "EMPTY");
		String sql = "select * from users where id='" + userInfo.getId() + "'";

		if (connect()) {
			try {
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String password = rs.getString("pw");
					if (password.equals(userInfo.getPassword())) {
						result = new Data("LOGIN", "SUCCESS", userInfo);
					} else {
						result = new Data("LOGIN", "NOPW");
					}
				} else {
					result = new Data("LOGIN", "NOID");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			close();
		}

		return result;
	}

	Data join(UserInfo userInfo) {
		Data result = new Data("EMPTY", "EMPTY");
		String sql = "insert into users values('" + userInfo.getId() + "', '" + userInfo.getPassword() + "')";

		if (connect()) {
			try {
				stmt.executeUpdate(sql);
				result = new Data("JOIN", "COMPLETE");
			} catch (SQLException e) {
				result = new Data("JOIN", "FAIL");
				e.printStackTrace();
			}

			close();
		}

		return result;
	}

	public String[] getWord() {
		String[] words = new String[3];
		String[] sql = new String[3];

		sql[0] = "select word from (select * from words where level=1)random1 order by rand() limit 1";
		sql[1] = "select word from (select * from words where level=2)random2 order by rand() limit 1";
		sql[2] = "select word from (select * from words where level=3)random3 order by rand() limit 1";

		for (int i = 0; i < 3; i++) {

			if (connect()) {
				try {
					stmt = conn.createStatement(); // 쿼리 수행을 위한 statement 객체 생성
					rs = stmt.executeQuery(sql[i]);

					while (rs.next()) {
						words[i] = rs.getString(1);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				close();
			}
		}
		return words;
	}

	String getInitial() {
		String initial = null;
		
		String sql = "select initial from words where word='"+ GameManager.getWord() + "'";

		if (connect()) {
			try {
				rs=stmt.executeQuery(sql);
				while(rs.next()) {
					initial=rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close();
		}
		
		return initial;
	}
}
