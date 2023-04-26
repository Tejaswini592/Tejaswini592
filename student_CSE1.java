import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Search extends Frame implements ActionListener
{
	Label l1;
	TextField t1,t2;
	Button b;
	Search()//constructor
	{
		setSize(500,500);
		setVisible(true);
		setLayout(new FlowLayout());
		l1=new Label("Enter roll number");
		
		t1=new TextField(20);
		t1.setBounds(250,40,400,50);
		t1.setBackground(Color.PINK);	
		t2=new TextField(20);
		t2.setBackground(Color.BLUE);
		b=new Button("Search");
		b.setBackground(Color.YELLOW);
		add(l1);
		add(t1);
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
		PreparedStatement pst=con.prepareStatement("select * from teju where PID=?");
//read input from textfield
		String num=t1.getText();
		pst.setString(1,num);
		ResultSet rs=pst.executeQuery();
		int x=0;
add(t2);
		while(rs.next())
		{
			//Display name(coloumn2) on textFiled2
			t2.setText(rs.getString(2));
			x++;
		}
		if(x==0)
		{
			t2.setText("record not found");
		}
	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
	}
}

class student_CSE1
{
	public static void main(String args[])
	{
		Search s=new Search();
	}
}