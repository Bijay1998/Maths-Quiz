
/**
 * Importing slq*/
import java.sql.Connection;
import java.sql.DriverManager;


/**
 * @author bijay
 * This is the jdbc class that connects the application with database.
 *
 */
public class JDBC{
	
	Connection con = null;
	java.sql.PreparedStatement pst;
	/**The dbconnect method to connect with the database
	 * @return returns connection if succesfull and null if not
	 */
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