package com.service;

import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.dbcon.ConnectionManager;

@Service
public abstract class DbService {

	@Value("${datasource.url}")
	private String url;

	@Value("${datasource.userName}")
	private String userName;

	@Value("${datasource.password}")
	private String password;

	@Value("${datasource.driver}")
	private String driver;

	public void testConnection() {
		Connection conn = createConnection();
		try {
			System.out.println(conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection createConnection() {
		return ConnectionManager.getConnection(url, userName, password, driver);
	}
}
