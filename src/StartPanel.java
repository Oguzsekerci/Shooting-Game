import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class StartPanel extends JFrame implements ActionListener
{

	 
	 public static JPanel jpStartScreen=new JPanel();
	 public JPanel jpNestedBtnPanel = new JPanel();
	 public JPanel jpNestedScorePanel = new JPanel();
	 
	 public GridLayout gl;
	 public GridLayout glnestedBtn;
	 public GridLayout glnestedScore;
	 
	 public JLabel lblName;
	 public JLabel lblSurname;
	 public JLabel lblHighscore;
	 public JTextField txtName;
	 public JTextField txtSurname;
	 public JCheckBox cbxCheck;
	 public JButton btnSaveAndStart;
	 public JButton btnLoad;
	 
	 public int highScore;
	 static String NameSurname;
	 
	 
	 static StartPanel stp = new StartPanel();	 
	public static void run(){
		stp.setSize(800,600);	
		stp.setResizable(false);
		stp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stp.setVisible(true);
		stp.setBackground(Color.black);
	}
		
	public StartPanel()
	{	
		gl = new GridLayout(3,2);
		glnestedBtn = new GridLayout(2,1);
		glnestedScore = new GridLayout(2,1);

		jpStartScreen.setLayout(gl);
		
		
		lblName = new JLabel("Name");
		lblSurname = new JLabel("Surname");
		lblHighscore = new JLabel("High Score: ");
		
		txtName = new JTextField("");
		txtSurname = new JTextField("");
		
		cbxCheck = new JCheckBox("Did you check your name ? Is it True ?");			
		btnSaveAndStart = new JButton("Save And Start the Game!");
		btnLoad  = new JButton("Load High Score");
		
		jpStartScreen.add(lblName);
		jpStartScreen.add(txtName);
		jpStartScreen.add(lblSurname);
		jpStartScreen.add(txtSurname);
		jpStartScreen.add(jpNestedScorePanel);	
		jpStartScreen.add(jpNestedBtnPanel);
		
		jpNestedBtnPanel.setLayout(glnestedBtn);
		jpNestedBtnPanel.add(btnSaveAndStart);
		jpNestedBtnPanel.add(btnLoad);
		
		jpNestedScorePanel.setLayout(glnestedScore);
		jpNestedScorePanel.add(cbxCheck);
		jpNestedScorePanel.add(lblHighscore);
		
		
		add(jpStartScreen);
		
		btnSaveAndStart.addActionListener(this);
		btnLoad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedReader reader=new BufferedReader(new FileReader("output.txt"));
					
						String curText=reader.readLine();
						String[] nameandSurname=curText.split(" ");
						txtName.setText(nameandSurname[0]);
						txtSurname.setText(nameandSurname[1]);						
						lblHighscore.setText(nameandSurname[2]);
						
						
						}
						
						
				 catch (IOException e1) 
				 {
					e1.printStackTrace();
				 }
				
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(cbxCheck.isSelected())
		{
			if(e.getSource() == btnSaveAndStart)
			{
				realDealMain.counter++;
				jpStartScreen.setVisible(false);
				
				NameSurname = txtName.getText()+" "+ txtSurname.getText();	
				String strhighScore = ""+ highScore;
						
				
			}
		}
		else
		{
			JOptionPane.showMessageDialog(jpStartScreen,"If you sure your Name and Surname are CORRECT You MUST Click the Checkbox!");
		}
	}
	
	

}

	 



