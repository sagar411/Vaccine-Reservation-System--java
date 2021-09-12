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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Connection.DatabaseConnection;
import LogIn.Form;

public class UpdateDetails extends JFrame {
	
	JFrame frame;
	JPanel topPanel,mainPanel;
	JLabel topLabel,idLabel,nameLabel,permanentAddressLabel,currentAddressLabel,genderLabel,dateOFBirthLabel,emailLabel,mobileNumberLabel,vaccineDoseLabel,bloodGroupLabel,covidInfectedLabel,vaccinetedLabel;
	
	JTextField idField,nameField,permanentAddressField,currentAddressField,genderField,dateOfBirthField,emailField,mobileNumberField,vaccineDoseField,bloodGroupField,covidInfectedField;
	JComboBox vaccinetedField;
	
	JButton buttonSubmit,buttonSearch;
	
	private int idUser;
	 int id;
	 String name;
	private String permanentAddress ;
	private String currentAddress ;
	private String Gender ;
	private String DateOfBirth ;
	private String email ;
	private String mobileNumber ;
	private String VaccineDose ;
	private String BloodGroup ;
	private String CovidInfected ;
	private String vaccineted  ;
	public UpdateDetails() {
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(100,85));
		topPanel.setBackground(new Color(132,166,247));
		topLabel = new JLabel("Update Details");
		topLabel.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,45));
		topPanel.add(topLabel);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.white);
		mainPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(6,6,20,6);
		
		
		idLabel= new JLabel("ID");
		
		idField = new JTextField(15);
		
		
		
		nameLabel = new JLabel("Name");
		
		nameField= new JTextField(15);
		permanentAddressLabel= new JLabel("Permanent Address");
		
		permanentAddressField= new JTextField(15);
		
		currentAddressLabel= new JLabel("Current Address");
		
		currentAddressField= new JTextField(15);
		
		genderLabel= new JLabel("Gender");
		genderField= new JTextField(15);
		
		dateOFBirthLabel= new JLabel("Date of Birth");
		dateOfBirthField= new JTextField(15);
		
		emailLabel = new JLabel("Email");
		emailField= new JTextField(15);
		
		mobileNumberLabel = new JLabel("Mobile Number");
		mobileNumberField= new JTextField(15);
		
		vaccineDoseLabel= new JLabel("Vaccine Dose");
		
		vaccineDoseField= new JTextField(15);
		
		bloodGroupLabel= new JLabel("Blood Group");
		bloodGroupField= new JTextField(15);
		
		covidInfectedLabel =new JLabel("Covid Infected");
		covidInfectedField= new JTextField(15);
		
		vaccinetedLabel = new JLabel("Vaccineted ");
		
		String []Option= {"Yes","no"};
		vaccinetedField= new JComboBox(Option);
		
		buttonSearch = new JButton("Search");
		
		buttonSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 
				idUser =Integer.parseInt(idField.getText());
				try
			    {
			    Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();
			      String query = "SELECT * FROM form WHERE id='"+idUser+"';";
			     ResultSet rs = stmt.executeQuery(query);
			      
			      // iterate through the java resultset
			      while (rs.next())
			      {
			    	  	id = rs.getInt("id");
			    	  	nameField.setText(rs.getString("name")); 
				         
			    	  	permanentAddressField.setText( rs.getString("permanentAddress"));
			    	  	currentAddressField.setText(rs.getString("currentAddress"));
			    	  	genderField.setText(rs.getString("Gender"));
			    	  	dateOfBirthField.setText (rs.getString("DateOfBirth"));
			    	  	emailField.setText(rs.getString("email")); 
			    	  	mobileNumberField.setText(rs.getString("mobileNumber"));
			    	  	
			    	  	
			    	  	//===================
			    	  	vaccineDoseField.setText( rs.getString("VaccineDose"));
			    	  	
			    	  	bloodGroupField.setText(rs.getString("BloodGroup"));
			    	  	
			    	  	covidInfectedField.setText(rs.getString("CovidInfected"));
			    	  	
//			    	  	vaccinetedField.setText(rs.getString("vaccineted"));
//			    	  	String vac =(rs.getString("vaccineted"));
			    	  	vaccinetedField.setSelectedItem((rs.getString("vaccineted")));
//			    	  	vaccinetedField.getEditor().setItem(rs.getString("vaccineted"));
			      }
			      stmt.close();
			    }
			    catch (Exception ex)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(ex.getMessage());
			    }
				
			}
			
		});
		
		
		buttonSubmit =new JButton("Submit");
		buttonSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
//				 id;
//				 name=nameField.getText();
//				 permanentAddress= permanentAddressField.getText();
//				 currentAddress =currentAddressField.getText();
//				 Gender =genderField.getText();
//				 DateOfBirth=dateOfBirthField.getText() ;
//				 email=emailField.getText() ;
//				 mobileNumber =mobileNumberField.getText();
//				VaccineDose=vaccineDoseField.getText() ;
//				BloodGroup=bloodGroupField.getText() ;
//				 CovidInfected=covidInfectedField.getText();
				
				vaccineted =(String) vaccinetedField.getSelectedItem() ;
				
				
				try {
					
					Connection con = DatabaseConnection.getConnection();
					Statement stmt = con.createStatement();
					
					stmt.executeUpdate("UPDATE form SET vaccineted  ='"+vaccineted+"' where id ='"+idUser+"'");
					JOptionPane.showMessageDialog(null, "Succesfull Updated");
					
//					frame.setVisible(false);
					frame.dispose();
					
//					new Form();
				}catch(Exception ex ) {
					
					JOptionPane.showMessageDialog(null, ex);
				}
				
				
				
			}
			
			
		});
		
		
		gbc.gridx =0;
		gbc.gridy=0;
		mainPanel.add(idLabel,gbc);
		
		gbc.gridx =1;
		gbc.gridy=0;
		mainPanel.add(idField,gbc);
		
		gbc.gridx=2;
		gbc.gridy=0;
		mainPanel.add(buttonSearch,gbc);
		

		gbc.gridx =0;
		gbc.gridy=1;
		mainPanel.add(nameLabel,gbc);
		
		gbc.gridx =1;
		gbc.gridy=1;
		mainPanel.add(nameField,gbc);
		
		gbc.gridx =0;
		gbc.gridy=2;
		mainPanel.add(permanentAddressLabel,gbc);
		gbc.gridx =1;
		gbc.gridy=2;
		mainPanel.add(permanentAddressField,gbc);
		gbc.gridx =0;
		gbc.gridy=3;
		mainPanel.add(currentAddressLabel,gbc);
		gbc.gridx =1;
		gbc.gridy=3;
		mainPanel.add(currentAddressField,gbc);
		gbc.gridx=0;
		gbc.gridy =4;
		mainPanel.add(genderLabel,gbc);
		gbc.gridx=1;
		gbc.gridy =4;
		mainPanel.add(genderField,gbc);
		gbc.gridx=0;
		gbc.gridy =5;
		mainPanel.add(dateOFBirthLabel,gbc);
		gbc.gridx=1;
		gbc.gridy =5;
		mainPanel.add(dateOfBirthField,gbc);
		gbc.gridx=0;
		gbc.gridy =6;	
		mainPanel.add(emailLabel,gbc);
		gbc.gridx=1;
		gbc.gridy =6;	
		mainPanel.add(emailField,gbc);
		gbc.gridx=0;
		gbc.gridy =7;
		mainPanel.add(mobileNumberLabel,gbc);
		gbc.gridx=1;
		gbc.gridy =7;
		mainPanel.add(mobileNumberField,gbc);
		gbc.gridx=0;
		gbc.gridy =8;
		mainPanel.add(vaccineDoseLabel,gbc);
		gbc.gridx=1;
		gbc.gridy =8;
		mainPanel.add(vaccineDoseField,gbc);
		gbc.gridx=0;
		gbc.gridy =9;
		mainPanel.add(bloodGroupLabel,gbc);
		gbc.gridx=1;
		gbc.gridy =9;
		mainPanel.add(bloodGroupField,gbc);
		gbc.gridx=0;
		gbc.gridy =10;
		mainPanel.add(covidInfectedLabel,gbc);
		gbc.gridx=1;
		gbc.gridy =10;
		mainPanel.add(covidInfectedField,gbc);
		gbc.gridx=0;
		gbc.gridy =11;
		mainPanel.add(vaccinetedLabel,gbc);
		gbc.gridx=1;
		gbc.gridy =11;
		mainPanel.add(vaccinetedField,gbc);
		gbc.gridx=0;
		gbc.gridy=12;
		mainPanel.add(buttonSubmit,gbc);
		
		frame = new JFrame();
		
		frame.add(topPanel,BorderLayout.NORTH);
		frame.add(mainPanel);
		frame.setSize(600,750);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new  BorderLayout(10,10));
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getVaccineDose() {
		return VaccineDose;
	}
	public void setVaccineDose(String vaccineDose) {
		VaccineDose = vaccineDose;
	}
	public String getBloodGroup() {
		return BloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
	}
	public String getCovidInfected() {
		return CovidInfected;
	}
	public void setCovidInfected(String covidInfected) {
		CovidInfected = covidInfected;
	}

}
