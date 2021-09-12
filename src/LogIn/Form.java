package LogIn;
import MainPages.Home2;
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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mysql.cj.x.protobuf.MysqlxNotice.FrameOrBuilder;

import Connection.DatabaseConnection;
import MainPages.Home2;
//import java.awt.*;  
//import javax.swing.*;    


public class Form {    
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel panelTop = new JPanel();
	JPanel panelWest = new JPanel();
	
	ImageIcon backImage = new ImageIcon("Images/backicon.png");
	
	JLabel TopLabel = new JLabel();
	JLabel Back = new JLabel();
	
	JLabel FirstnameLabel = new JLabel("First Name :");
	JTextField firstNameField = new JTextField(15);
	
	JLabel MiddlenameLabel = new JLabel("Middle Name :");
	JTextField MiddleNameField = new JTextField(15);
	
	JLabel LastnameLabel = new JLabel("Last Name :");
	JTextField LastNameField = new JTextField(15);
	
	JLabel AddressnameLabel = new JLabel("Permanent Address :");
	JTextField AddressField = new JTextField(15);
	
	JLabel CurrentAddressnameLabel = new JLabel("Current Address :");
	JTextField CurrentAddressField = new JTextField(15);
	
//	JLabel idLabel = new JLabel("ID :");
//	JTextField idField = new JTextField(10);
	
	
	JLabel SexLabel = new JLabel("Gender :");
	
	JRadioButton male = new JRadioButton("Male");
	JRadioButton female = new JRadioButton("Female");
	JRadioButton  others = new JRadioButton("Others");
	
	
	
	JLabel YearLabel = new JLabel("Year(DOB) :");
	
	JTextField DateYear= new JTextField(); 
	
	JLabel monthslabel = new JLabel("Months");
	
	String []monthsdate = {"January", "February","March "," April" ," May " ," June", " July"," August"," September ","October"," November", "December"};
	JComboBox months = new JComboBox(monthsdate);
	
	JLabel dayslabel = new JLabel("days :");
	
	String[] daydate = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
	JComboBox days = new JComboBox(daydate);
	
	JLabel emallabel = new JLabel("Email :");
	
	JTextField emailfield = new JTextField();
	
	
	JLabel numberlabel = new JLabel("Mobile Number :");
	
	JTextField numberfield = new JTextField();
	
	JLabel doselabel =new JLabel("Dose :");
	
	String[] dosesvalue = {"1","2"};
	JComboBox ComboDose = new JComboBox(dosesvalue);
	
	JLabel bloodlabel =new JLabel("Blood Group :");
	
    String [] bloodgroup = {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
    JComboBox ComboBlood = new JComboBox(bloodgroup);
    
    
    JLabel PreviousConditionLabel =new JLabel("have you diagnosis with covid before ?");
    JRadioButton RadioButtonyes = new JRadioButton("Yes");
	JRadioButton RadioButtonno = new JRadioButton("No");
	
	
	JButton SubmitButton = new JButton("Submit");
	JButton ResetButton = new JButton("Reset");
	
	
	public String Gender="";
	public String CovidInfected ="";
	int id1,id=1;
	String vaccineted  ="no";
	
public Form(){ 
//	months.setPreferredSize(new Dimension(10,10));
//	
//	days.setPreferredSize(new Dimension(10,10));
	

	
	days.setEditable(true);
	
	Back.setBounds(0,0,50,50);
	Back.setIcon(backImage);
	Back.addMouseListener(new java.awt.event.MouseAdapter() {
	      public void mouseClicked(java.awt.event.MouseEvent nn) {
	    	  frame.setVisible(false);
	    	  Home2 h = new Home2();	      }
	    });
	
	TopLabel.setText("Fill up the Form");
	TopLabel.setBounds(300,20,600,50);
//	TopLabel.setBounds(40,90,150,75);
	TopLabel.setFont(new Font(null,Font.BOLD + Font.ITALIC,50));
	
	panelTop.add(Back);
	panelTop.setLayout(null);
	panelTop.add(TopLabel);
	panelTop.setBackground(new Color(132,166,247));
	panelTop.setPreferredSize(new Dimension(80,100));
	
	
//	panelWest.setBackground(Color.blue);
//	panelWest.setPreferredSize(new Dimension(80,80));
	
	panel.setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.fill=GridBagConstraints.HORIZONTAL;
	gbc.insets = new Insets(6,6,20,6);
	//-------------------name-------------------//
	gbc.gridx =0;
	gbc.gridy =0;
	panel.add(FirstnameLabel,gbc);
	
	gbc.gridx =1;
	gbc.gridy =0;
	panel.add(firstNameField,gbc);
	
	gbc.gridx=2;
	gbc.gridy=0;
	panel.add(MiddlenameLabel,gbc); 
	
	gbc.gridx=3;
	gbc.gridy=0;
	panel.add(MiddleNameField,gbc);
	
	gbc.gridx=4;
	gbc.gridy=0;
	panel.add(LastnameLabel,gbc);
	
	gbc.gridx=5;
	gbc.gridy=0;
	panel.add(LastNameField,gbc);
	/////////////==================address=========================/
	gbc.gridx=0;
	gbc.gridy=1;
	panel.add(AddressnameLabel,gbc);
	
	gbc.gridx=1;
	gbc.gridy=1;
	panel.add(AddressField,gbc);
	
	gbc.gridx=2;
	gbc.gridy=1;
	panel.add(CurrentAddressnameLabel,gbc);
	
	gbc.gridx=3;
	gbc.gridy=1;
	panel.add(CurrentAddressField,gbc);

	
	
	 
	/////////////================gender-------------//
	gbc.gridx=0;
	gbc.gridy=2;
	panel.add(SexLabel,gbc);
	
	ButtonGroup group = new ButtonGroup();
	group.add(male);
	group.add(female);
	group.add(others);

	gbc.gridx=1;
	gbc.gridy=2;
	panel.add(male,gbc);
	
	gbc.gridx=2;
	gbc.gridy=2;
	panel.add(female,gbc);
	
	gbc.gridx=3;
	gbc.gridy=2;
	panel.add(others,gbc);
//	==================================///
	gbc.gridx=0;
	gbc.gridy=3;
	panel.add(YearLabel,gbc);
	
	gbc.gridx=1;
	gbc.gridy=3;
	panel.add(DateYear,gbc);
	
	gbc.gridx=2;
	gbc.gridy=3;
	panel.add(monthslabel,gbc);
	
	
	gbc.gridx=3;
	gbc.gridy=3;
	panel.add(months,gbc);
	
	gbc.gridx=4;
	gbc.gridy=3;
	panel.add(dayslabel,gbc);
	
	gbc.gridx=5;
	gbc.gridy=3;
	panel.add(days,gbc);
	
	gbc.gridx=0;
	gbc.gridy=4;
	panel.add(emallabel,gbc);
	
	gbc.gridx=1;
	gbc.gridy=4;
	panel.add(emailfield,gbc);
	
	gbc.gridx=2;
	gbc.gridy=4;
	panel.add(numberlabel,gbc);
	
	gbc.gridx=3;
	gbc.gridy=4;
	panel.add(numberfield,gbc);
	
	gbc.gridx=0;
	gbc.gridy=5;
	panel.add(doselabel,gbc);
	
	gbc.gridx=1;
	gbc.gridy=5;
	panel.add(ComboDose,gbc);
	
	gbc.gridx=2;
	gbc.gridy=5;
	panel.add(bloodlabel,gbc);
	
	gbc.gridx=3;
	gbc.gridy=5;
	panel.add(ComboBlood,gbc);
	
	gbc.gridx=0;
	gbc.gridy=6;
	panel.add(PreviousConditionLabel,gbc);
	
	ButtonGroup groupinf = new ButtonGroup();
	groupinf.add(RadioButtonyes);
	groupinf.add(RadioButtonno);

	
	gbc.gridx=1;
	gbc.gridy=6;
	panel.add(RadioButtonyes,gbc);
	
	gbc.gridx=2;
	gbc.gridy=6;
	panel.add(RadioButtonno,gbc);
	
	
	gbc.gridx=0;
	gbc.gridy=8;
	panel.add(SubmitButton,gbc);
	
	gbc.gridx=3;
	gbc.gridy=8;
	panel.add(ResetButton,gbc);
	
	
	frame.setLayout(new BorderLayout());
	frame.add(panelTop,BorderLayout.NORTH);
//	frame.add(panelWest,BorderLayout.WEST);
	frame.add(panel);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
	frame.setSize(1000,700);
	frame.setVisible(true);
	frame.setLocationRelativeTo(null);
	
	ResetButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			firstNameField.setText("");
			MiddleNameField.setText("");
			LastNameField.setText("");
			AddressField.setText("");
			CurrentAddressField.setText("");
			DateYear.setText("");
			emailfield.setText("");
			numberfield.setText("");
//			idField.setText("");
		}
		
	});
	
	
	String VaccineChoose =toString();
	
	System.out.println("vaccine :"+VaccineChoose);
	SubmitButton.addActionListener(new ActionListener() {
 
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			// TODO Auto-generated method stub
//			
//			int id =Integer.parseInt( idField.getText());
//			System.out.println(id);
			
			try
		    {
		    Connection con = DatabaseConnection.getConnection();
			Statement stmt = con.createStatement();
		      String query = "SELECT * FROM form WHERE id=(SELECT max(id) FROM form);";
		     ResultSet rs = stmt.executeQuery(query);
		      
		      // iterate through the java resultset
		      while (rs.next())
		      {
		         id1 = rs.getInt("id");
		        System.out.print (id1);
		      }
		      stmt.close();
		    }
		    catch (Exception ex)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(ex.getMessage());
		    }
			
			id =id1+1;
			
			String name = firstNameField.getText() +" " +MiddleNameField.getText()+ " "+ LastNameField.getText();
			System.out.println(name);
			
			String permanentAddress = AddressField.getText();
			System.out.println(permanentAddress);
			
			String currentAddress = CurrentAddressField.getText();
			System.out.println(currentAddress);
			
			if(male.isSelected()) {
				
				Gender ="male";
			}else if(female.isSelected()) {
				Gender ="female";
			}else if(others.isSelected()) {
				
				Gender ="others";
			}
			System.out.println(Gender);
			
			String DateOfBirth =DateYear.getText()+ "/"+months.getSelectedItem()+ "/"+ days.getSelectedItem();
			System.out.println(DateOfBirth);
			
			
			String email = emailfield.getText();
			System.out.println(email);
			
			String mobileNumber = numberfield.getText();
			System.out.println(mobileNumber);
			
			String VaccineDose =(String)ComboDose.getSelectedItem();
			System.out.println(VaccineDose);
			
			String BloodGroup =(String)ComboBlood.getSelectedItem();
			System.out.println(BloodGroup);
			
			
			if(RadioButtonyes.isSelected()) {
				
				CovidInfected  ="yes";
			}else if(RadioButtonno.isSelected()) {
				CovidInfected  ="no";
			}
			
			System.out.print(vaccineted);
			
//			String 
			
//			System.out.println(CovidInfected );
			
			if(name =="" || permanentAddress==""||currentAddress==""|| Gender==""||email==""||DateOfBirth=="" ||mobileNumber==""||VaccineDose=="") {
				
				JOptionPane.showConfirmDialog(null, "pease ! Enter all the data","Compelete form",JOptionPane.DEFAULT_OPTION);
			}else {
		
			 
			try {
				
				Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();
				
				stmt.executeUpdate("insert into Form values ('"+id +"','"+ name+"','"+ permanentAddress +"','"+ currentAddress +"','"+ Gender +"','"+DateOfBirth +"','"+email +"','"+mobileNumber +"','"+VaccineDose +"','"+BloodGroup +"','"+CovidInfected  +"','"+vaccineted  +"' )");
				JOptionPane.showMessageDialog(null, "Succesfull Updated");
				
				frame.setVisible(false);
				new Form();
			}catch(Exception ex ) {
				
				JOptionPane.showMessageDialog(null, ex);
			}
			
			
		}
		}
		});
}


}    