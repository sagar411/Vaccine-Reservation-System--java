package LogIn;

import Connection.DatabaseConnection;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Admin.Admin;


public class Login  {

	
	
	public Login(){
		
		JLabel labelUserName = new JLabel("UserName");
	
		JTextField username = new JTextField();
		
		JLabel labelPassword = new JLabel("UserName");
		
		JTextField password = new JTextField();
		
		JButton Login = new JButton("Login");
		JButton Reset = new JButton("Reset");
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3,2));
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.add(labelUserName);
		frame.add(username);
		frame.add(labelPassword);
		frame.add(password);
		frame.add(Login);
		frame.add(Reset);
		frame.setLocationRelativeTo(null);
		
		Login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Login action here
				
				String uname = username.getText();
				String pword = password.getText();
				
				// check for database correction			
				
			
				 Connection con = DatabaseConnection.getConnection();
				 
//				 String query = "SELECT * FROM users";
				 
				 PreparedStatement stmt;
				try {
					stmt = con.prepareStatement("SELECT * FROM users WHERE name=? and password=?");
					 stmt.setString(1,uname);
					 stmt.setString(2,pword);
					 
					  if (con != null) {
					         System.out.println("Connection successful !!!");	
					         ResultSet result = stmt.executeQuery(); 			     		
					 
					        	 
					        if(result.next())
					        {
					        		Admin ad =new Admin();
					        		frame.setVisible(false);
//					        		Home2.setVisible(false);
					        	
					        	
					        }else {
					        	JOptionPane.showMessageDialog(frame, "please check Yor id or password", "Error!!", JOptionPane.ERROR_MESSAGE);
					        	
					        }
					  }
					 
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			
		});
		
		Reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				username.setText("");
				password.setText("");
			}
			
		});
	}




}
