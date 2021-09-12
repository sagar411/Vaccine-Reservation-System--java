package MainPages;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Connection.DatabaseConnection;
import LogIn.Form;
import LogIn.Login;


public class Home2 implements ActionListener {
//	private long totalInfected;
//	private long totalRecovered;
	JButton ButtonVaccine1;
	JButton ButtonVaccine2;
	JButton ButtonVaccine3;
	JButton ButtonVaccine4;
	JButton ButtonVaccine5;
	JFrame frame = new JFrame();
	String Vaccine="";
	
	 String  CovidCase="";
	 String Recovered ="";
	 String Death="";
	public Home2() {
		
		
		// TODO Auto-generated method stub
	
		//image icon
		ImageIcon vaccineA = new ImageIcon("Images/Hello1[128].PNG");
		ImageIcon vaccineB = new ImageIcon("Images/Hello2[130].PNG");
		ImageIcon vaccineC = new ImageIcon("Images/Hello3[129].PNG");
		ImageIcon vaccineD = new ImageIcon("Images/Hello4[132].PNG");
		ImageIcon vaccineE = new ImageIcon("Images/Hello5[137].PNG");

		ImageIcon login = new ImageIcon("Login-icon.png");
	ImageIcon icon = new ImageIcon("Home-icon.png");
	ImageIcon imageHome = new ImageIcon("Home-icon[135].png");
	ImageIcon vaccine = new ImageIcon("vaccine.png");
	ImageIcon info = new ImageIcon("information.png");
	 ImageIcon image = new ImageIcon("vaccine-top.jpg");
	 
//	 ****************************** Vccine Picutres********************//
	 
	 JLabel TitelVaccine = new JLabel(); 
	 TitelVaccine.setText("Type of Vaccine Avialable" );
	 TitelVaccine.setFont(new Font(null,Font.BOLD,45));
	 TitelVaccine.setBounds(150,0,1000,50);
	 
	 JLabel Vaccine1 = new JLabel();
		Vaccine1.setIcon(vaccineA);
		Vaccine1.setBounds(65,80,200,200);
		
		
		 ButtonVaccine1 = new JButton();
		ButtonVaccine1.setText("Book");
		ButtonVaccine1.setBounds(115,300,70,30);
		ButtonVaccine1.addActionListener(this);
		
		 JLabel Vaccine2 = new JLabel();
			Vaccine2.setIcon(vaccineB);
			Vaccine2.setBounds(350,80,200,200);
			
			 ButtonVaccine2 = new JButton();
			ButtonVaccine2.setText("Book");
			ButtonVaccine2.setBounds(400,300,70,30);
			ButtonVaccine2.addActionListener(this);
			
			JLabel Vaccine3 = new JLabel();
			Vaccine3.setIcon(vaccineC);
			Vaccine3.setBounds(650,80,200,200);
			
			ButtonVaccine3 = new JButton();
			ButtonVaccine3.setText("Book");
			ButtonVaccine3.setBounds(700,300,70,30);
			ButtonVaccine3.addActionListener(this);
			
			JLabel Vaccine4 = new JLabel();
			Vaccine4.setIcon(vaccineD);
			Vaccine4.setBounds(200,400,200,200);
			
			 ButtonVaccine4 = new JButton();
			ButtonVaccine4.setText("Book");
			ButtonVaccine4.setBounds(250,600,70,30);
			ButtonVaccine4.addActionListener(this);
			
			JLabel Vaccine5 = new JLabel();
			Vaccine5.setIcon(vaccineE);
			Vaccine5.setBounds(500,400,200,200);
			
			 ButtonVaccine5 = new JButton();
			ButtonVaccine5.setText("Book");
			ButtonVaccine5.setBounds(550,600,70,30);
			ButtonVaccine5.addActionListener(this);
			
//	=================================================================
	
	//Cardlayout for panels
	CardLayout card = new CardLayout();
	
	
	JPanel Cardlayout  = new JPanel();
	Cardlayout.setBounds(301,0,1000,800);
	Cardlayout.setLayout(card);
	/**********Home-panel****************/
	
	JPanel panelHome = new JPanel();
	panelHome.setLayout(new GridBagLayout());
	
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.fill=GridBagConstraints.HORIZONTAL;
	gbc.insets = new Insets(5,5,5,5);

	panelHome.setBackground(Color.WHITE);
	
	JLabel DetailCases = new JLabel("Covid Cases in Nepal");
	DetailCases.setFont(new Font("roboto condensed,sans-serif",Font.BOLD,80));
	
	JLabel CoronavirusCasesLabel = new JLabel("Corona Virus Cases  :");
	CoronavirusCasesLabel.setFont(new Font("roboto condensed,sans-serif",Font.BOLD,40));
	
	JLabel CoronavirusCasesValue = new JLabel(); 
	CoronavirusCasesValue.setFont(new Font("roboto condensed,sans-serif",Font.BOLD,35));
	
	
	JLabel CoronavirusCaseRecovered = new JLabel("Corona Virus Recovered Cases :");
	CoronavirusCaseRecovered.setFont(new Font("roboto condensed,sans-serif",Font.BOLD,40));
	
	JLabel CoronavirusCaseRecoveredValue = new JLabel(); 
	CoronavirusCaseRecoveredValue.setFont(new Font("roboto condensed,sans-serif",Font.BOLD,35));
	
	JLabel CoronavirusCaseDeath= new JLabel("Corona Virus Death Cases :");
	CoronavirusCaseDeath.setFont(new Font("roboto condensed,sans-serif",Font.BOLD,40));
	
	JLabel CoronavirusCaseDeathValue = new JLabel(); 
	CoronavirusCaseDeathValue.setFont(new Font("roboto condensed,sans-serif",Font.BOLD,35));
	
	try
    {
    Connection con = DatabaseConnection.getConnection();
	Statement stmt = con.createStatement();
      String query = "SELECT * FROM Details WHERE id=(SELECT max(id) FROM Details);";
     ResultSet rs = stmt.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        CovidCase = rs.getString("totalInfected");
       System.out.println(CovidCase);
       Recovered = rs.getString("recovered");
        System.out.println(Recovered);
        Death = rs.getString("Death");
        System.out.println(Death);
      }
      stmt.close();
    }
    catch (Exception ex)
    {
      System.err.println("Got an exception! ");
      System.err.println(ex.getMessage());
    }
	CoronavirusCasesValue.setText(CovidCase);
	CoronavirusCaseRecoveredValue.setText(Recovered);
	CoronavirusCaseDeathValue.setText(Death);

	gbc.gridx =0;
	gbc.gridy =0;
	panelHome.add(DetailCases,gbc);
	
	gbc.gridx =0;
	gbc.gridy =1;
	panelHome.add(CoronavirusCasesLabel,gbc);
	
	gbc.gridx =1;
	gbc.gridy =1;
	panelHome.add(CoronavirusCasesValue,gbc);
	
	
	gbc.gridx =0;
	gbc.gridy =2;
	panelHome.add(CoronavirusCaseRecovered,gbc);
	gbc.gridx =1;
	gbc.gridy =2;
	panelHome.add(CoronavirusCaseRecoveredValue,gbc);
	
	gbc.gridx =0;
	gbc.gridy =3;
	panelHome.add(CoronavirusCaseDeath,gbc);
	gbc.gridx =1;
	gbc.gridy =3;
	panelHome.add(CoronavirusCaseDeathValue,gbc);
	
	
	/**********Vaccine-panel****************/
	
	JPanel panelVaccine = new JPanel();
//	panel3.setBounds(301,0,400,500);
	panelVaccine.setBackground(Color.WHITE);
	panelVaccine.add(TitelVaccine);
	panelVaccine.add(Vaccine1);
	panelVaccine.add(Vaccine2);
	panelVaccine.add(Vaccine3);
	panelVaccine.add(Vaccine4);
	panelVaccine.add(Vaccine5);
	
	panelVaccine.add(ButtonVaccine1);
	panelVaccine.add(ButtonVaccine2);
	panelVaccine.add(ButtonVaccine3);
	panelVaccine.add(ButtonVaccine4);
	panelVaccine.add(ButtonVaccine5);
	panelVaccine.setLayout(null);
	
	

	
	
	Cardlayout.add(panelHome);
//	Cardlayout.add(panelInfo);
	Cardlayout.add(panelVaccine);
	//label=="My Vaccine"
	
	
	JLabel label0 = new JLabel();
	label0.setText("My Vaccine");
	label0.setHorizontalAlignment(JLabel.CENTER);
//	label0.setVerticalAlignment(JLabel.BOTTOM);
	label0.setBounds(30,-60,200,200);
	label0.setFont(new Font("MV Boli",Font.BOLD,35));
	
	/**********Home- label****************/
		JLabel label = new JLabel();
		label.setText("home");
		label.setIcon(imageHome);
		
		label.setBounds(40,90,150,75);
		label.setFont(new Font(null,Font.BOLD,30));
		
		label.addMouseListener(new java.awt.event.MouseAdapter() {
		      public void mouseClicked(java.awt.event.MouseEvent nn) {
//		    	New ne = new New();
//		    	  panelInfo.setVisible(false);
		    	  panelVaccine.setVisible(false);
		    	  panelHome.setVisible(true);
		      } });
		
		/**********Vaccine-label****************/
		JLabel label2 = new JLabel();
		label2.setText("vaccine");
		label2.setIcon(vaccine);
//		label2.setVerticalAlignment(JLabel.BOTTOM);
		label2.setBounds(40,210,180,150);
		label2.setFont(new Font(null,Font.BOLD,30));
		
		label2.addMouseListener(new java.awt.event.MouseAdapter() {
		      public void mouseClicked(java.awt.event.MouseEvent nn) {
//		    Vaccine v = new Vaccine();
		    	  panelHome.setVisible(false);
//		    	  panelInfo.setVisible(false);
		    	  panelVaccine.setVisible(true);
		      }
		    });
		

		
//		=======================================login -labrel
		JLabel label4 = new JLabel();
		label4.setText("Login");
		label4.setIcon(login);
//		label3.setVerticalAlignment(JLabel.BOTTOM);
		label4.setBounds(40,400,260,150);
		label4.setFont(new Font(null,Font.BOLD,30));
		
		label4.addMouseListener(new java.awt.event.MouseAdapter() {
		      public void mouseClicked(java.awt.event.MouseEvent nn) {
		    
		    	  new Login();
		    	  
		      }
		    });
		
		
		/********************main-panel***********/
		JPanel panel1=new JPanel();
		panel1.setBounds(0, 0, 300, 800);
		panel1.setBackground(new Color(132,166,247));
		panel1.setLayout(null);
		
		
		frame.setSize(1300,800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.add(panel1);
		frame.add(Cardlayout);	
	    frame.setResizable(false);
	    frame.setTitle("My Vaccine");
	    frame.setIconImage(image.getImage());
	    frame.setLocationRelativeTo(null);
		panel1.add(label0);
		panel1.add(label);
		panel1.add(label2);
//		panel1.add(label3);
		panel1.add(label4);
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ButtonVaccine1 || e.getSource()==ButtonVaccine2 ||e.getSource()==ButtonVaccine3||e.getSource()==ButtonVaccine4 ||e.getSource()==ButtonVaccine5 ) {
			Form f = new Form();	
			frame.setVisible(false);
		}
		
		if(e.getSource()==ButtonVaccine1) {
			Vaccine ="Covishield";
			System.out.println(Vaccine);
			
		}else if(e.getSource()==ButtonVaccine2) {
			Vaccine ="Sputnik V";
		}
		else if(e.getSource()==ButtonVaccine3) {
			
			Vaccine ="Covaxin";
		}else if(e.getSource()==ButtonVaccine4) {
			Vaccine ="Sinopharm";
		}else if (e.getSource()==ButtonVaccine5){
			Vaccine ="coronaVac";
		}
	}
	@Override
	public String toString() {
		return this.Vaccine;
		
	}

}
