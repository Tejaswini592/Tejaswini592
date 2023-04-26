import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Delete extends Frame implements ActionListener
{
	Label l1;
	TextField t1;
	Button b;
	Delete() //constructor
	{
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		setBackground(Color.PINK);
		l1=new Label("Enter Roll Number ");
		t1=new TextField(20);
		t1.setBounds(250,40,400,50);
		t1.setBackground(Color.LIGHT_GRAY);
		b=new Button("Delete");
		b.setBackground(Color.BLUE);
		add(l1);
		add(t1);
		add(b);
		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			PreparedStatement pst=con.prepareStatement("delete from iron where EID=?");
			//read input from textfield
			String num=t1.getText();
			pst.setString(1,num);
			ResultSet rs=pst.executeQuery();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
class DeleteAwt
{
	public static void main(String args[])
	{
		Delete s=new Delete();	
	}
}



