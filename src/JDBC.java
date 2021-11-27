import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC{
	Connection con = null;
	java.sql.PreparedStatement pst;
	public static Connection dbconnect(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/quiz", "root", "");
			return conn;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
}