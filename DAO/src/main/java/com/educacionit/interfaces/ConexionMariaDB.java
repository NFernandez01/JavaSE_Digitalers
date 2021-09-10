package com.educacionit.interfaces;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public interface ConexionMariaDB {
	default Connection getConexion() {
		Connection conexion = null;
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("src/recursos/database.properties"));
			String url = propiedades.getProperty("db.url");
			String user = propiedades.getProperty("db.user");
			String pass = propiedades.getProperty("db.pass","1234");
			
			
			conexion = DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return conexion;
	}
}