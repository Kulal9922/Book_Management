import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;


public class menubook extends JFrame implements ActionListener
{ 
	
static JFrame f1=new JFrame();
static JFrame f2=new JFrame();	
static JFrame f3=new JFrame();
static JFrame f4=new JFrame();

//static JMenuBar i;
//static JMenu k;
//static JMenuItem Insert,Delete,Search,Exit;
static JTextArea t1,t2,t3,t4,t5,t6,t7,t8;
static JLabel l1,l2,l3,l4,l5,l6,l7,l8;
static JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;




static void insert(String a1,String a2,String a3, String a4,String a5){
	try
	{
		DAO db=new DAO();
		Connection conn=db.getConnection();

		 String name=a1;
		 String author=a2;
		 int price=Integer.parseInt(a5);
		 int quantity=Integer.parseInt(a4);
		 int pages=Integer.parseInt(a4);
		 
		 String insertQuery="insert into jjbook values(?,?,?,?,?)";
		 PreparedStatement preparedStatement;
		 
		 preparedStatement=conn.prepareStatement(insertQuery);
		 preparedStatement.setString(1,name);
		 preparedStatement.setString(2,author);
		 preparedStatement.setString(3,price+"");
		 preparedStatement.setString(4,quantity+"");
		 preparedStatement.setString(5,pages+"");
		 
		 preparedStatement.executeUpdate();
		 
		 l8.setForeground(Color.green);
		 l8.setText("Data Entered Succesfully ");
		 System.out.println("data insert succesfully");
		 
		 
	}
	catch(Exception e){
		 System.out.println(e);
		// l8.setForeground(Color.red);
		 //l8.setText("Exception Occur_Cant submit the data!!");
		
	}
	}
	static String delete(String p){
		String ret="No Record Found!!";
		try{
			DAO db=new DAO();
			Connection conn=db.getConnection();
	
			String title=p;
			
			String deleteQuery="delete from jjbook where title=?";
			PreparedStatement preparedStatement;
			
			preparedStatement=conn.prepareStatement(deleteQuery);
			preparedStatement.setString(1, title);
			
			int count=preparedStatement.executeUpdate();
			if(count==0){
				System.out.println("No record Found With Name ");
				return ret;
				}
			else
				{
				System.out.println("Total "+count+"Record Deleted!!");
				ret="Data deleted Succesfully ";
				return ret;}
			    
			
			
		}
		catch(Exception e){
			System.out.println(e);	
			ret="Exception Occur_Cant Delete the data!!";
			return ret;
			}
	}
	static String Search(String x){
		try{
			DAO db=new DAO();
			Connection conn=db.getConnection();
		
			String selectQuery="select * from jjbook";
			PreparedStatement preparedStatement;
			
			
			String s1=x;
			preparedStatement=conn.prepareStatement(selectQuery);
			ResultSet result=preparedStatement.executeQuery();
			
			String data="Book Not Found!!";
			while(result.next()){
				if(s1.equalsIgnoreCase(result.getString(1))){
					data="  title "+result.getString(1)+"/n  Author Name "+result.getString(2)+"/n  Number of Books Available "+result.getString(3)+"/n  Number Of Pages "+result.getString(4);
				}
			
			return data;
			}
		}
			catch(Exception e){
				return null;
			}
		return null;
	}



        
menubook()
{   /*---------------------------------Frame 1 Home ------------------*/
	f1.setTitle("Book manage");
	f1.setSize (800, 800);
	f1.setResizable(true);
	f1.setLocationRelativeTo(null); //set icon location at center
	f1.setLayout(null);
	
	b1=new JButton ("Add");
	b1.setBounds(100,100, 100, 50);
	b1.addActionListener(this);
	
	b2=new JButton ("Remove");
	b2.setBounds(250,100, 100, 50);
	b2.addActionListener(this);
	
	b3=new JButton ("Search");
	b3.setBounds(400,100, 100, 50);
	b3.addActionListener(this);
	
	f1.add(b1);
	f1.add(b2);
	f1.add(b3);
	f1.setVisible(true);
	//----------------------------
	f2.setTitle("Book Add");
	f2.setSize (800, 800);
	f2.setResizable(true);
	f2.setLocationRelativeTo(null); //set icon location at center
	f2.setLayout(null);
	
	l1= new JLabel("Title");
	l1.setBounds(100,50,100,50);
	
	l2= new JLabel("Author");
	l2.setBounds(100,150,100,50);
	
	l3= new JLabel("Price");
	l3.setBounds(100,250,100,50);
	
	l4= new JLabel("Qty");
	l4.setBounds(100,350,100,50);
	
	l5= new JLabel("Noof pages");
	l5.setBounds(100,450,100,50);
	
	l8= new JLabel();
	l8.setBounds(300,450,100,50);
	
	t1=new JTextArea();
	t1.setBounds(170, 50,200, 50);
	
	t2=new JTextArea();
	t2.setBounds(170, 150,200, 50);
	
	t3=new JTextArea();
	t3.setBounds(170, 250,200, 50);
	
	t4=new JTextArea();
	t4.setBounds(170, 350,200, 50);
	
	t5=new JTextArea();
	t5.setBounds(170, 450,200, 50);
	
	b4=new JButton ("Submit");
	b4.setBounds(100,600,150, 50);
	b4.addActionListener(this);
	
	b5=new JButton ("Cancel");
	b5.setBounds(300,600,150, 50);
	b5.addActionListener(this);
	
    f2.add(l1);
    f2.add(l2);
    f2.add(l3);
    f2.add(l4);
    f2.add(l5);
    f2.add(l8);
    f2.add(t1);
    f2.add(t2);
    f2.add(t3);
    f2.add(t4);
    f2.add(t5);
    f2.add(b4);
    f2.add(b5);
    
    
    f2.setVisible(false);
    
    f3.setTitle("Book Delete");
	f3.setSize (500, 500);
	f3.setResizable(true);
	f3.setLocationRelativeTo(null); //set icon location at center
	f3.setLayout(null);
	
	l6= new JLabel("Title");
	l6.setBounds(100,50,100,50);
	
	t6=new JTextArea();
	t6.setBounds(170, 50,200, 50);
	
	b6=new JButton ("Delete");
	b6.setBounds(100,200,150, 50);
	b6.addActionListener(this);
	
	b7=new JButton ("Cancel");
	b7.setBounds(300,200,150, 50);
	b7.addActionListener(this);
	
    f3.add(l6);
    f3.add(t6);
    f3.add(b6);
    f3.add(b7);
    f3.setVisible(false);
    
    f4.setTitle("Book Search");
   	f4.setSize (500, 500);
   	f4.setResizable(true);
   	f4.setLocationRelativeTo(null); //set icon location at center
   	f4.setLayout(null);
   	
   	l7= new JLabel("Title");
   	l7.setBounds(100,50,100,50);
   	
   	t7=new JTextArea();
   	t7.setBounds(170, 50,200, 50);
   	
	t8=new JTextArea();
   	t8.setBounds(170, 300,200, 50);
   	
   	b8=new JButton ("Search");
   	b8.setBounds(100,200,150, 50);
   	b8.addActionListener(this);
   	
   	b9=new JButton ("Cancel");
   	b9.setBounds(300,200,150, 50);
   	b9.addActionListener(this);
   	
       f4.add(l7);
       f4.add(t7);
       f4.add(t8);
       f4.add(b8);
       f4.add(b9);
       f4.setVisible(false);
       
}

public static void main(String args[])
{
	menubook obj = new menubook();
	//obj.menubook();
}                      

public void actionPerformed(ActionEvent e) {
	Object z=e.getSource();
	if(z==b1){
		//f1.dispose();
		f2.setVisible(true);
	}
    if(z==b2){
    	//f1.dispose();
		f3.setVisible(true);
	}
    if(z==b3){
    	//f1.dispose();
		f4.setVisible(true);
    }
	



	if(z==b1){
		f2.setVisible(true);	
	}
	if(z==b4){
		//System.out.println(t1.getText());
		/*String s1=t1.getText();
		String s2=t2.getText();
		String s3=t3.getText();*/
		insert(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText());
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		
	}
    if(z==b2){
		f3.setVisible(true);
	}
    if(z==b6){
    	delete(t6.getText());
    }
   
    if(z==b3){
		f4.setVisible(true);
    }
    if(z==b8){
    	t8.setText(Search(t7.getText()));
    }
    if(z==b9){
		f4.dispose();
	}
    if(z==b5){
		f2.dispose();
	}
    if(z==b7){
		f3.dispose();
	}
}






}
