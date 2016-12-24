package boundry;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

public class Main {

	private JFrame frame;
	private JTextField tfIP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 219, 147);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfIP = new JTextField();
		tfIP.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		tfIP.setText("localhost");
		tfIP.setBounds(59, 35, 134, 20);
		frame.getContentPane().add(tfIP);
		tfIP.setColumns(10);
		
		JLabel lblIP = new JLabel("IP:");
		lblIP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIP.setBounds(26, 35, 46, 20);
		frame.getContentPane().add(lblIP);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ip = tfIP.getText();
				if(ip.equals(""))
					JOptionPane.showMessageDialog(null,"Please fill IP", "Connection Error",JOptionPane.ERROR_MESSAGE);
				else
				{
					controller.ConnectToServer.ServerConnection(ip);
					frame.dispose();
				}
			}
		});
		btnConnect.setBounds(46, 66, 106, 23);
		frame.getContentPane().add(btnConnect);
		
		JLabel lblNewLabel = new JLabel("Sign");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 46, 24);
		frame.getContentPane().add(lblNewLabel);
	}
}
