package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class OtherService extends DbService {

	public String updateEmployeeNameById(String id, String name) {
		StringBuilder SQL = new StringBuilder();
		try (Connection con = super.createConnection()) {
			SQL.append("Update").append(" ").append("manager_info").append(" SET username = ? WHERE id = ?");
			System.out.println(SQL.toString());
			try (PreparedStatement pstmt = con.prepareStatement(SQL.toString())) {
				pstmt.setString(1, name);
				pstmt.setString(2, id);
				return pstmt.executeUpdate() == 1 ? "SUCCESS !" : "Failed !";
			} catch (SQLException e) {
				e.printStackTrace();
				return "SQL Error : " + e.getMessage() + e.getCause();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "SQL Error : " + e.getMessage() + e.getCause();
		}
	}
}
