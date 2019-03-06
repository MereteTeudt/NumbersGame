
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Connector {

	public static void main(String[] args) {
		LinkedList<User> users = new LinkedList<User>();
		String querySelect = "SELECT * from users";
		String queryInsert = "insert into users (username) values (?)";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root", "dolphinbank");
			PreparedStatement prepStmt;
			ResultSet rs;
			
			prepStmt = con.prepareStatement(queryInsert);
			prepStmt.setString(1, "peenz");
			prepStmt.execute();
			
			prepStmt = con.prepareStatement(querySelect);
			rs = prepStmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.id = (rs.getInt("Id"));
				user.username = (rs.getString("username"));
				user.password = (rs.getString("password"));
				users.add(user);
				System.out.println(user.username);
			}

			con.close();
		}
		catch(Exception e) {System.out.println(e);}

	}

}
