package com.dbcon;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import org.springframework.stereotype.Component;
import com.alibaba.druid.pool.DruidDataSource;

@Component
public class ConnectionManager {

	private static DruidDataSource dataSource;

	public static Connection getConnection(String url, String userName, String password, String driver) {
		if (dataSource == null) {
			synchronized (ConnectionManager.class) {
				if (dataSource == null) {
					dataSource = new DruidDataSource();
					dataSource.setUrl(url);
					dataSource.setUsername(userName);
					dataSource.setPassword(password);
					dataSource.setPoolPreparedStatements(true);
					dataSource.setDriverClassName(driver);
					dataSource.setCreateScheduler(Executors.newScheduledThreadPool(10));
				}
			}
		}
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
