package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection {

	public Connection getConnection() {
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "root");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public boolean validateUser(String user, String password) {
		boolean isUserExist=false;
		ResultSet rs = null;
		try {
			String query = "select * from user where user = '"+user+"' and password='"+password+"'";
			
			Statement st = this.getConnection().createStatement();
			rs = st.executeQuery(query);
			
			if(rs.next())
				isUserExist=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return isUserExist;
	}
}
