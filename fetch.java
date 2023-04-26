import java.sql.*;
class fetch
{
	public static void main(String args[])
	{
		try
		{

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Drive Register");
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
		System.out.println("Established");
		Statement s5=c.createStatement();
		String sql="select *from teju";
		ResultSet rs=s5.executeQuery(sql);
		rs.next();
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString("PNAME"));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}