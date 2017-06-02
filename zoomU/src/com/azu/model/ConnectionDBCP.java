package com.azu.model;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionDBCP {
	// 싱글톤 패턴
	private ConnectionDBCP(){}
	private static ConnectionDBCP instance=new ConnectionDBCP();
	public static ConnectionDBCP getInstance(){
		return instance;
	}
	
	public Connection getConnection() throws Exception{
		Context ctx = new InitialContext();
		DataSource ds=(DataSource)ctx.lookup("java:/comp/env/jdbc:DogDB");
		
		System.out.println("DBCP Connection Pool");
		
		return ds.getConnection();
	}
}
