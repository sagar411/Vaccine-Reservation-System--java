package Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Connection.DatabaseConnection;
import LogIn.Form;

public class UpdateCovidCases extends JFrame  {
	
	JFrame frame;
	JPanel Toppanel;
	JLabel TopLabel,CovidCaseLabel,CovidRecovered,CovidDeath;
	
	JTextField CovidCaseTextField,CovidRecoveredTextField,CovidDeadField;
	
	JButton SubmitButton;
	
	String CovidCase,Recovered,Death;
	int id1,id;
	public UpdateCovidCases() {
		Toppanel = new JPanel();
		Toppanel.setPreferredSize(new Dimension(100,100));
		Toppanel.setBackground(new Color(132,166,247));
		
		TopLabel = new JLabel(" Update Covid Cases Details");
		TopLabel.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,45));
		Toppanel.add(TopLabel);
		
		JPanel panel2 = new JPanel();
//		panel2.setPreferredSize(new Dimension(100,100));
		panel2.setBackground(Color.WHITE);
		panel2.setLayout(new GridBagLayout());
		
		CovidCaseLabel = new JLabel("Covid Cases:");
		CovidCaseLabel.setFont(new Font(null,Font.BOLD ,25));
		
		CovidRecovered = new JLabel("Covid Recoverd:");
		CovidRecovered.setFont(new Font(null,Font.BOLD ,25));
		
		CovidDeath = new JLabel("Covid Death:");
		CovidDeath.setFont(new Font(null,Font.BOLD ,25));
		
		
		CovidCaseTextField = new JTextField(20);
		CovidRecoveredTextField = new JTextField(20);
		CovidDeadField= new JTextField(20);
		
		SubmitButton= new JButton("Submit");
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(6,6,20,6);
		
		gbc.gridx=0;
		gbc.gridy=0;
		
		panel2.add(CovidCaseLabel,gbc);
		
		gbc.gridx=1;
		gbc.gridy=0;
		
		panel2.add(CovidCaseTextField,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		
		panel2.add(CovidRecovered,gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		panel2.add(CovidRecoveredTextField,gbc);
		

		gbc.gridx=0;
		gbc.gridy=2;
		panel2.add(CovidDeath,gbc);
		

		gbc.gridx=1;
		gbc.gridy=2;
		panel2.add(CovidDeadField,gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		panel2.add(SubmitButton,gbc);
		
		
		SubmitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 CovidCase=CovidCaseTextField.getText();
				 
				
				 Recovered=CovidRecoveredTextField.getText();
				 
				 Death=CovidDeadField.getText();
				 
				 try
				    {
				    Connection con = DatabaseConnection.getConnection();
					Statement stmt = con.createStatement();
				      String query = "SELECT * FROM Details WHERE id=(SELECT max(id) FROM Details);";
				     ResultSet rs = stmt.executeQuery(query);
				      
				      // iterate through the java resultset
				      while (rs.next())
				      {
				         id1 = rs.getInt("id");
				       
				      }
				      stmt.close();
				    }
				    catch (Exception ex)
				    {
				      System.err.println("Got an exception! ");
				      System.err.println(ex.getMessage());
				    }
					
					id =id1+1;
//				 System.out.println("this is test id==="+ id);
					try {
						
						Connection con = DatabaseConnection.getConnection();
						Statement stmt = con.createStatement();
						
						stmt.executeUpdate("insert into Details values ('"+id+"','"+CovidCase +"','"+ Recovered+"','"+ Death +"')");
						JOptionPane.showMessageDialog(null, "Succesfull Updated");
						
						frame.setVisible(false);
						new UpdateCovidCases();
					}catch(Exception ex ) {
						
						JOptionPane.showMessageDialog(null, ex);
					}
			}
			
			
		});
		
		frame = new JFrame();
		frame.add(panel2);
		frame.add(Toppanel,BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(550,650);
		frame.setVisible(true);
		frame.setLayout(new  BorderLayout(10,10));
		frame.setLocationRelativeTo(null);

	}

	
}
