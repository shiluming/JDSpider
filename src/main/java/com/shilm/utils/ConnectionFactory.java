package com.shilm.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionFactory {
	
	private static Logger log = Logger.getLogger(ConnectionFactory.class);
	
	public static Connection getConnection(int type) {
		
		Connection con = null;
		switch(type)
		{
			case 1:
				MysqlUtils mysql = new MysqlUtils();
				try {
					con = mysql.getConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			
			case 2:
				log.info(" orcal Not yet implemented");
				break;
				
			case 3:
				log.info(" sqlserver Not yet implemented");
				break;
			
			default:
				return null;
		}
		
		return con;
	}
	
	public static void main(String[] args) {
		Connection con = ConnectionFactory.getConnection(ApplicationContext.MYSQL);
		System.out.println(con);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
