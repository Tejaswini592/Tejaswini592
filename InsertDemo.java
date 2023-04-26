import java.sql.*;
class InsertDemo
{
	public static void main(String args[]) 
	{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Drive Register");
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
		System.out.println("connection established successfully");
		Statement s=c.createStatement();
		String sql="insert into teju values(101,'anitha')";
		s.addBatch(sql);
		String sql1="insert into teju values(105,'suman')";
		s.addBatch(sql1);
		String sql2="insert into teju values(106,'aaaa')";
		s.addBatch(sql2);
		s.executeBatch();
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}