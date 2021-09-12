package Admin;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.DatabaseConnection;
import MainPages.Home2;



public class Admin extends JFrame{

	JFrame frame;
	ImageIcon top = new ImageIcon("vaccine.png");
	JPanel panel1 , Cardlayoutpanel,SeeRecordpanel,Vaccinetedpanel ,Remainingpanel;
	JButton buttonSeeRecord,buttonVaccineted,buttonRemaining,buttonUpdate,buttonBack;	
	
	JLabel Toptext;
	
	CardLayout card;
	
	JTable table,table2,table3;
	DefaultTableModel defaultTableModel,defaultTableModel2,defaultTableModel3;
	
	int id;
	String name;
	String permanentAddress ;
	String currentAddress ;
	String Gender ;
	String DateOfBirth ;
	String email ;
	String mobileNumber ;
	String VaccineDose ;
	String BloodGroup ;
	String CovidInfected ;
	String vaccineted  ;
	public Admin(){
		 card = new CardLayout();
		 Cardlayoutpanel  = new JPanel();
		 Cardlayoutpanel.setBounds(301,0,1000,800);
		 Cardlayoutpanel.setLayout(card);
		 Cardlayoutpanel.setBackground(Color.black);
		 
		 
		 
		 JPanel SeeRecordpanel = new JPanel();
//			panel4.setBounds(301,0,400,500);
		 SeeRecordpanel.setBackground(new Color(203,203,203));
		 SeeRecordpanel.setLayout(new FlowLayout());
		 
		 defaultTableModel = new DefaultTableModel();
	        table = new JTable(defaultTableModel);
	        table.setPreferredScrollableViewportSize(new Dimension(950, 600));
	        table.setFillsViewportHeight(true);
	        SeeRecordpanel.add(new JScrollPane(table));
	        defaultTableModel.addColumn("id");
	        defaultTableModel.addColumn("Name");
	        defaultTableModel.addColumn("permanentAddress");
	        defaultTableModel.addColumn("currentAddress");
	        defaultTableModel.addColumn("Gender");
	        defaultTableModel.addColumn("DateOfBirth");
	        defaultTableModel.addColumn("email");
	        defaultTableModel.addColumn("mobileNumber");
	        defaultTableModel.addColumn("VaccineDose");
	        defaultTableModel.addColumn("BloodGroup");
	        defaultTableModel.addColumn("CovidInfected");
	        defaultTableModel.addColumn("vaccineted");
	        try
		    {
		    Connection con = DatabaseConnection.getConnection();
			Statement stmt = con.createStatement();
		      String query = "SELECT * FROM form ;";
		     ResultSet rs = stmt.executeQuery(query);
		      
		      // iterate through the java resultset
		      while (rs.next())
		      {
		    	 id = rs.getInt("id");
		         name = rs.getString("name");
		         
		         permanentAddress = rs.getString("permanentAddress");
		         currentAddress = rs.getString("currentAddress");
		         Gender = rs.getString("Gender");
		         DateOfBirth = rs.getString("DateOfBirth");
		         email = rs.getString("email");
		         mobileNumber = rs.getString("mobileNumber");
		         VaccineDose = rs.getString("VaccineDose");
		         BloodGroup = rs.getString("BloodGroup");
		         CovidInfected = rs.getString("CovidInfected");
		         vaccineted = rs.getString("vaccineted");
		       
		         
		         defaultTableModel.addRow(new Object[]{id,name,permanentAddress, currentAddress,Gender,DateOfBirth,email,mobileNumber,VaccineDose,BloodGroup,CovidInfected,vaccineted});
		      }
		      stmt.close();
		    }
		    catch (Exception ex)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(ex.getMessage());
		    }
	 
		 
		 
		 JPanel Vaccinetedpanel = new JPanel();
//			panel4.setBounds(301,0,400,500);
		 Vaccinetedpanel.setBackground(new Color(111,111,111));
		 Vaccinetedpanel.setLayout(new FlowLayout());
		 
		 defaultTableModel2 = new DefaultTableModel();
	        table2 = new JTable(defaultTableModel2);
	        table2.setPreferredScrollableViewportSize(new Dimension(950, 600));
	        table2.setFillsViewportHeight(true);
	        Vaccinetedpanel.add(new JScrollPane(table2));
	        defaultTableModel2.addColumn("id");
	        defaultTableModel2.addColumn("Name");
	        defaultTableModel2.addColumn("permanentAddress");
	        defaultTableModel2.addColumn("currentAddress");
	        defaultTableModel2.addColumn("Gender");
	        defaultTableModel2.addColumn("DateOfBirth");
	        defaultTableModel2.addColumn("email");
	        defaultTableModel2.addColumn("mobileNumber");
	        defaultTableModel2.addColumn("VaccineDose");
	        defaultTableModel2.addColumn("BloodGroup");
	        defaultTableModel2.addColumn("CovidInfected");
	        defaultTableModel2.addColumn("vaccineted");
	        
	        
	        
	        try
		    {
		    Connection con = DatabaseConnection.getConnection();
			Statement stmt = con.createStatement();
		      String query1 = "SELECT * FROM form Where vaccineted='Yes' ;";
		     ResultSet rs1 = stmt.executeQuery(query1);
		      
		      // iterate through the java resultset
		      while (rs1.next())
		      {
		    	 int id1 = rs1.getInt("id");
		         String name1 = rs1.getString("name");
		         
		        String permanentAddress1 = rs1.getString("permanentAddress");
		         String currentAddress1 = rs1.getString("currentAddress");
		         String Gender1 = rs1.getString("Gender");
		         String DateOfBirth1 = rs1.getString("DateOfBirth");
		         String email1 = rs1.getString("email");
		         String mobileNumber1 = rs1.getString("mobileNumber");
		         String VaccineDose1 = rs1.getString("VaccineDose");
		         String BloodGroup1 = rs1.getString("BloodGroup");
		         String CovidInfected1 = rs1.getString("CovidInfected");
		         String vaccineted1 = rs1.getString("vaccineted");
		         
		         
		       
		        	
		         defaultTableModel2.addRow(new Object[]{id1,name1,permanentAddress1, currentAddress1,Gender1,DateOfBirth1,email1,mobileNumber1,VaccineDose1,BloodGroup1,CovidInfected1,vaccineted1});
		         
		         
		         }
		      stmt.close();
		    }
		    catch (Exception ex)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(ex.getMessage());
		    }
		 
		 JPanel Remainingpanel = new JPanel();
//			panel4.setBounds(301,0,400,500);
		 
		 Remainingpanel.setBackground(new Color(111,203,203));
		 
		 
//-------------------------------------------remaining panal----jdbc-table===========link
		 defaultTableModel3 = new DefaultTableModel();
	        table3 = new JTable(defaultTableModel3);
	        table3.setPreferredScrollableViewportSize(new Dimension(950, 600));
	        table3.setFillsViewportHeight(true);
	        Remainingpanel.add(new JScrollPane(table3));
	        defaultTableModel3.addColumn("id");
	        defaultTableModel3.addColumn("Name");
	        defaultTableModel3.addColumn("permanentAddress");
	        defaultTableModel3.addColumn("currentAddress");
	        defaultTableModel3.addColumn("Gender");
	        defaultTableModel3.addColumn("DateOfBirth");
	        defaultTableModel3.addColumn("email");
	        defaultTableModel3.addColumn("mobileNumber");
	        defaultTableModel3.addColumn("VaccineDose");
	        defaultTableModel3.addColumn("BloodGroup");
	        defaultTableModel3.addColumn("CovidInfected");
	        defaultTableModel3.addColumn("vaccineted");
	        
	        
	        
	        try
		    {
		    Connection con = DatabaseConnection.getConnection();
			Statement stmt = con.createStatement();
		      String query2 = "SELECT * FROM form Where vaccineted='no' ;";
		     ResultSet rs2 = stmt.executeQuery(query2);
		      
		      // iterate through the java resultset
		      while (rs2.next())
		      {
		    	 int id2 = rs2.getInt("id");
		         String name2 = rs2.getString("name");
		         
		        String permanentAddress2 = rs2.getString("permanentAddress");
		         String currentAddress2= rs2.getString("currentAddress");
		         String Gender2 = rs2.getString("Gender");
		         String DateOfBirth2 = rs2.getString("DateOfBirth");
		         String email2 = rs2.getString("email");
		         String mobileNumber2 = rs2.getString("mobileNumber");
		         String VaccineDose2= rs2.getString("VaccineDose");
		         String BloodGroup2= rs2.getString("BloodGroup");
		         String CovidInfected2 = rs2.getString("CovidInfected");
		         String vaccineted2 = rs2.getString("vaccineted");
		         System.out.println(vaccineted2);
		         
		       
		        	
		        	 defaultTableModel3.addRow(new Object[]{id2,name2,permanentAddress2, currentAddress2,Gender2,DateOfBirth2,email2,mobileNumber2,VaccineDose2,BloodGroup2,CovidInfected2,vaccineted2});
//		         System.out.print(vaccineted2);
		         
		         }
		      stmt.close();
		    }
		    catch (Exception ex)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(ex.getMessage());
		    }
		 
		 
		 
		 
		 Cardlayoutpanel.add(SeeRecordpanel);
		 
		 Cardlayoutpanel.add(Vaccinetedpanel);
		 Cardlayoutpanel.add(Remainingpanel);
		 
		
		panel1=new JPanel();
		panel1.setBounds(0, 0, 300, 800);
		panel1.setBackground(new Color(132,166,247));
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		
		Toptext = new JLabel("Admin");
		Toptext.setFont(new Font("MV Boli",Font.BOLD,35));
		Toptext.setIcon(top);
		
		buttonSeeRecord=new JButton("See Records");
		buttonSeeRecord.setMaximumSize( new Dimension(  120, 50) );
		
		buttonSeeRecord.addActionListener((ActionListener) new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    selectionButtonPressed();
			  }

			private void selectionButtonPressed() {
				// TODO Auto-generated method stub
				SeeRecordpanel.setVisible(true);
				Vaccinetedpanel.setVisible(false);
				Remainingpanel.setVisible(false);
				
			} 
			} );
		
		buttonVaccineted=new JButton("Vaccineted");
		buttonVaccineted.setMaximumSize( new Dimension(  120, 50) );
		
		buttonVaccineted.addActionListener((ActionListener) new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    selectionButtonPressed();
			  }

			private void selectionButtonPressed() {
				// TODO Auto-generated method stub
				SeeRecordpanel.setVisible(false);
				Vaccinetedpanel.setVisible(true);
				Remainingpanel.setVisible(false);
				
			} 
			} );
		
		buttonRemaining=new JButton("Remaining");
		buttonRemaining.setMaximumSize( new Dimension(  120, 50) );
		
		buttonRemaining.addActionListener((ActionListener) new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    selectionButtonPressed();
			  }

			private void selectionButtonPressed() {
				// TODO Auto-generated method stub
				SeeRecordpanel.setVisible(false);
				Vaccinetedpanel.setVisible(false);
				Remainingpanel.setVisible(true);
				
			} 
			} );
		 
		buttonUpdate=new JButton("Update");
		buttonUpdate.setMaximumSize( new Dimension(  120, 50) );
		
		buttonUpdate.addActionListener((ActionListener) new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    selectionButtonPressed();
			  }

			private void selectionButtonPressed() {
				
				// TODO Auto-generated method stub
				
				Update u = new Update();
				
				
			} 
			} );
		 
		buttonBack=new JButton("Back");
		buttonBack.setMaximumSize( new Dimension(  120, 50) );
		
		buttonBack.addActionListener((ActionListener) new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    selectionButtonPressed();
			  }

			private void selectionButtonPressed() {
				
				// TODO Auto-generated method stub
				
				frame.dispose();
				
				
			} 
			} );
		 
		 panel1.add(Box.createRigidArea(new Dimension(30, 40)));
		
		panel1.add(Toptext);
		
		panel1.add(Box.createRigidArea(new Dimension(30, 50)));
		panel1.add(buttonSeeRecord);
		panel1.add(Box.createRigidArea(new Dimension(30, 70)));
		panel1.add(buttonVaccineted);
		panel1.add(Box.createRigidArea(new Dimension(30, 70)));
		panel1.add(buttonRemaining);
		panel1.add(Box.createRigidArea(new Dimension(30, 70)));
		panel1.add(buttonUpdate);
		panel1.add(Box.createRigidArea(new Dimension(30, 70)));
		panel1.add(buttonBack);
		panel1.add(Box.createRigidArea(new Dimension(30, 70)));
		
		
		frame = new JFrame();
		frame.setSize(1300,800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		frame.add(panel1);
		frame.setLocationRelativeTo(null);
	
	    frame.setResizable(false);
	    frame.setTitle("Admin");
	    frame.add(Cardlayoutpanel);
	   
	}
}
