package info.inetsolv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sequence {

	public static void main(String[] args) throws SQLException {
	Scanner s=	new Scanner(System.in);
	System.out.print("enter name:");
String name = s.next();
System.out.print("enter salary:");
String salary = s.next();
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sus",
		"prasane");
String query="insert into EMP_TBL3 values((select nvl(max(Eno)+1,1)from EMP_TBL3),?,?)";
PreparedStatement pst = connection.prepareStatement(query);
pst.setString(1,name);
pst.setString(2, salary);
pst.executeUpdate();
connection.close();


	}

} 
