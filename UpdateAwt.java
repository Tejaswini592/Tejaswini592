import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Update extends Frame implements ActionListener
{
	Label l1,l2;
	TextField t1,t2;
	Button b;
	Update() //constructor
	{
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		l1=new Label("Enter Roll Number ");
		t1=new TextField(20);
		l2=new Label("Name to be updated ");
		t2=new TextField(20);
		b=new Button("Update");
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(b);
		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			PreparedStatement pst=con.prepareStatement("update iron set EID=? where ENAME=?");
			//read input from textfield
			String num=t1.getText();
			pst.setString(1,num);
			String name=t2.getText();
			pst.setString(2,name);
			ResultSet rs=pst.executeQuery();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
class UpdateAwt
{
	public static void main(String args[])
	{
		Update s=new Update();	
	}
}



