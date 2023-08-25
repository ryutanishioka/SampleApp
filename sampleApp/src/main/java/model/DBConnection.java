package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // データベースのURL
        final String URL = "jdbc:mysql://localhost/tweetDB";
        // mysqlのユーザー名
        final String USER = "root";
        // パスワードは設定していないので不要
        final String PASSWORD = "";
        
        final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
        
        Connection con = null;
        
        //Class.forNameは現在は使わなくても自動でやってくれるらしい
        try {
			Class.forName(DRIVER_NAME);       //JDBCドライバをロード＆接続先として指定
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        // データベースへ接続する
        try {
        	con = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
        	e.printStackTrace();
        }
        	
        return con;
    }

}
