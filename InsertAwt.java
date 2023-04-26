import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Insert extends Frame implements ActionListener
{
	Label l1,l2;
	TextField t1,t2;
	Button b;
	Insert() //constructor
	{
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		setBackground(Color.LIGHT_GRAY);
		l1=new Label("Enter Roll Number ");
		t1=new TextField(20);
		t1.setBounds(250,40,400,50);
		t1.setBackground(Color.PINK);	
		l2=new Label("Enter Name");
		t2=new TextField(20);
		t2.setBounds(250,40,400,50);
		t2.setBackground(Color.BLUE);	
		b=new Button("Insert");
		b.setBackground(Color.MAGENTA);	
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
			PreparedStatement pst=con.prepareStatement("insert into teju values(?,?)");
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
class InsertAwt
{
	public static void main(String args[])
	{
		Insert s=new Insert();	
	}
}



