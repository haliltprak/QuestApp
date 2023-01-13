package com.project.questapp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/quest-app?useSSL=false&serverTimezone=UTC";
		String userName="root";
		String passw="haliL123++";
		
		try {
			Connection myConnection = DriverManager.getConnection(url, userName, passw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Connention is successful!!!");

	}

}
