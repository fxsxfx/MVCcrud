package mx.com.cursodia.java21.semana3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
	private static DBConnection instance;
	private Connection con;
	
	private DBConnection()
	{
		try {
			this.con = DriverManager.getConnection(DB_Config.SERVER, DB_Config.USER, DB_Config.PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Error al conectar con la DB", e);
		}
	}
	
	public static DBConnection getInstance()
	{
		if(instance == null)
		{
			synchronized (DBConnection.class) 
			{
				if (instance == null) 
				{
					instance = new DBConnection();
				}
			}
		}
		
		return instance;
	}
	
	public Connection getCon()
	{
		try {
			if(this.con == null || this.con.isClosed())
			{
				this.con = DriverManager.getConnection(DB_Config.SERVER, DB_Config.USER, DB_Config.PASSWORD);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Error al verifica/conectar con la DB", e);
		}
		return this.con;
	}
	
	public void closeCon()
	{
		try {
			if(this.con != null && !this.con.isClosed())
			{
				this.con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
