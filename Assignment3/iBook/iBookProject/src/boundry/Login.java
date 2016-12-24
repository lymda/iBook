package boundry;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import controller.AccountController;

import java.awt.SystemColor;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import jdbc.mysqlConnection;

public class Login {


	private JFrame frmLogin;
	private JTextField tfUserID;
	private JTextField tfPassword;
	private AccountController accCntrl;

	public Login() {
		accCntrl = new AccountController();
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("iBook - Login");
		frmLogin.getContentPane().setForeground(Color.WHITE);
		frmLogin.getContentPane().setBackground(SystemColor.text);
		frmLogin.setBounds(100, 100, 757, 375);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblSignPic = new JLabel("");
		lblSignPic.setForeground(SystemColor.text);
		Image img = new ImageIcon(this.getClass().getResource("/logo3.jpg")).getImage();
		lblSignPic.setIcon(new ImageIcon(img));
		lblSignPic.setBackground(SystemColor.text);
		lblSignPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignPic.setBounds(23, 36, 274, 268);
		frmLogin.getContentPane().add(lblSignPic);
		
		JLabel lblWelcom = new JLabel("Welcome to iBook");
		lblWelcom.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcom.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblWelcom.setBounds(296, 22, 445, 28);
		frmLogin.getContentPane().add(lblWelcom);
		
		JLabel lblPleaseEnterYour = new JLabel("Please insert your login details:");
		lblPleaseEnterYour.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		lblPleaseEnterYour.setBounds(400, 111, 224, 28);
		frmLogin.getContentPane().add(lblPleaseEnterYour);
		
		JLabel lblUserID = new JLabel("Username:");
		lblUserID.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblUserID.setBounds(358, 159, 93, 24);
		frmLogin.getContentPane().add(lblUserID);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblPassword.setBounds(358, 194, 93, 24);
		frmLogin.getContentPane().add(lblPassword);
		
		tfUserID = new JTextField();
		tfUserID.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		tfUserID.setBounds(454, 164, 184, 20);
		frmLogin.getContentPane().add(tfUserID);
		tfUserID.setColumns(10);
		
		tfPassword = new JPasswordField();
		tfPassword.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		tfPassword.setBounds(454, 197, 184, 20);
		frmLogin.getContentPane().add(tfPassword);
		tfPassword.setColumns(10);
		Image img1 = new ImageIcon(this.getClass().getResource("/logo3.jpg")).getImage();
		
		JButton btnLog = new JButton("Login");
		btnLog.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfUserID.getText().equals("") || tfPassword.getText().equals(""))
					JOptionPane.showMessageDialog(null,"Username or Password fields are empty", "Login Error",JOptionPane.ERROR_MESSAGE);
				else
				{
					if(!accCntrl.Login(tfUserID.getText(), tfPassword.getText())) // empty list
						JOptionPane.showMessageDialog(null,"wrong UserID", "Login Error",JOptionPane.ERROR_MESSAGE);
					else if(!accCntrl.usr.getPassword().equals(tfPassword.getText()))
						JOptionPane.showMessageDialog(null,"wrong password", "Login Error",JOptionPane.ERROR_MESSAGE);
					else if(accCntrl.usr.isConnected())
						JOptionPane.showMessageDialog(null,"This user already in system, cannot login.", "Login Error",JOptionPane.ERROR_MESSAGE);
					else
					{
						// update connected = true
						accCntrl.usr.setConnected(true);
						accCntrl.UpdateConnected(accCntrl.usr.getUserID(), true);
						
						
						switch(accCntrl.usr.getPrivillage()){
						case 0: // open window and shut curr frame.
							new UserWindow(accCntrl);
							frmLogin.dispose();
							break;
						case 1:  // open window and shut curr frame.
							break;
						case 2:  // open window and shut curr frame.
							break;
						case 3:  // open window and shut curr frame.
							break;
							default: JOptionPane.showMessageDialog(null,"No such privillage, cannot login.", "Login Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		btnLog.setBounds(475, 228, 93, 28);
		frmLogin.getContentPane().add(btnLog);
		
		JLabel lblRegist = new JLabel("Don't have an account yet?");
		lblRegist.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblRegist.setBounds(307, 290, 197, 14);
		frmLogin.getContentPane().add(lblRegist);
		
		JButton btnRegistration = new JButton("registration");
		btnRegistration.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		btnRegistration.setBounds(496, 286, 118, 23);
		frmLogin.getContentPane().add(btnRegistration);
		
		JLabel label = new JLabel("Your electronic library");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		label.setBounds(296, 48, 445, 28);
		frmLogin.getContentPane().add(label);
		frmLogin.setVisible(true);
	}
	
	
	private boolean CheckLoginDetails()
	{
		/** check input validity */
		if(tfUserID.getText().equals("") || tfPassword.getText().equals(""))
			JOptionPane.showMessageDialog(null,"Username or Password fields are empty", "Login Error",JOptionPane.ERROR_MESSAGE);
		else
		{
		/*	String query = "SELECT worker_num, password FROM medical_worker WHERE worker_num="+tfUsername.getText()+";";
			jdbc.mysqlConnection.ConnectToDB("GET", 2, query);
			String res = jdbc.mysqlConnection.GetQueryResult();
			jdbc.mysqlConnection.ResetQueryResult();	*/
			
		/*	//String query = "SELECT worker_num, password FROM medical_worker WHERE worker_num="+tfUsername.getText()+";";
			String query = "GET:2:SELECT worker_num, password FROM medical_worker WHERE worker_num="+tfUsername.getText()+";";
			controllers.ConnectToServer.client.handleMessageFromClientUI(query);
		*///	System.out.println("Login-query res: " + controllers.ConnectToServer.queryResult);
		/*
			SendQuery();
			String res = client.ChatClient.GetQueryResult();
			System.out.println("Login-res: " + res); // del			
			
			if(res.equals("")) // If don't got results, username exist.
				JOptionPane.showMessageDialog(null,"Wrong username", "Login Error",JOptionPane.ERROR_MESSAGE);
			else  
			{ // Username exist.
				String[] arr = res.split("-");
				arr = arr[0].split(","); // Search by key, exactly 1 result.
				
				if(tfPassword.getText().equals(arr[1])) // arr[1] = password in DB
					return true; // Login Succeed.
				else
					JOptionPane.showMessageDialog(null,"Wrong password", "Login Error",JOptionPane.ERROR_MESSAGE);
			}*/
			System.out.println("Login-temp");
		}
		return false;
	}// End CheckLoginDetails.
	
	public void SendQuery(){
	//	String query = "GET:2:SELECT worker_num, password FROM medical_worker WHERE worker_num="+tfUsername.getText()+";";
	//	controllers.ConnectToServer.client.handleMessageFromClientUI(query);
		
		System.out.println("Login-sleeping");
		try {
			Thread.sleep(9999);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Login-Woke up");
		
	//	String res = client.ChatClient.GetQueryResult();
	//	System.out.println("Login-res: " + res); // del
	
	}
}
