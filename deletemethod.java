import java.sql.*;
class deletemethod
{
public static void main(String args[])
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
System.out.println("registered succesfully");

Connection c=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
System.out.println("connection established succesfully");

Statement s=c.createStatement();
String query1="delete from  finaldestination2 where pid=1";
int rows=s.executeUpdate(query1);
System.out.println("update sucesfull");
}
catch(Exception e)
{
System.out.println(e);
}
}
}
