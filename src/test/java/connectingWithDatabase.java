import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connectingWithDatabase {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/college";
	String username ="root";
		String pwd="Dajgar@123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String query = "select * from employeedetails";
			con=DriverManager.getConnection(url,username,pwd);
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int empid = rs.getInt("empid");
				String empname = rs.getString("empname");
				int salary = rs.getInt("salary");
				String department = rs.getString("department");
				System.out.println(" Id "+ empid + "  Employee Name  " + empname  + " Salary " +  salary  +" Department " +  department);
			}
			

		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
	}

}
