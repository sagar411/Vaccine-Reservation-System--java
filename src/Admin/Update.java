package Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Update extends JFrame {
	
	
	
	JFrame frame;
	JLabel topLabel ;
	JButton updateCovidCases,updateData;
	public Update() {
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.white);
		topLabel = new JLabel();
		topLabel.setText("Update Details");
		topLabel.setFont(new Font(null,Font.BOLD,30));
		
		
		updateCovidCases = new JButton("Covid Details");
		updateCovidCases.setPreferredSize(new Dimension(40, 40));
		updateData = new JButton("Update Data");
		
		frame = new JFrame("Update");
		frame.add(panel);
		//		frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
		
	
		updateCovidCases.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateCovidCases uc = new UpdateCovidCases();
				frame.dispose();
//				Admin admin = new Admin();
//				admin.setVisible(false);s
			}
			
			
		});
		updateData.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateDetails uc = new UpdateDetails();
				frame.dispose();
				
			}
			
			
		});
		
	panel.add(topLabel);
	panel.add(Box.createVerticalStrut(50));
	panel.add(updateCovidCases);
	panel.add(Box.createRigidArea(new Dimension(100,10)));
	panel.add(Box.createVerticalStrut(50));
	panel.add(updateData);
	frame.setVisible(true);
	frame.setSize(300, 400);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.getContentPane().setBackground( Color.white );
	frame.setLocationRelativeTo(null);
//	frame.setLayout(new GridLayout(3,1,10,10));
	}
	

}
