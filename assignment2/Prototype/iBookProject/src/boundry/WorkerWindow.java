package boundry;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WorkerWindow {

	private JFrame frmWorkerWindow;
	private JPanel pnlSrchWorker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkerWindow window = new WorkerWindow();
					window.frmWorkerWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public WorkerWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWorkerWindow = new JFrame();
		frmWorkerWindow.setTitle("Worker Window");
		frmWorkerWindow.getContentPane().setBackground(Color.WHITE);
		frmWorkerWindow.setBounds(100, 100, 677, 513);
		frmWorkerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWorkerWindow.getContentPane().setLayout(null);
		
		JLabel lblSignPic = new JLabel("");
		lblSignPic.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/Sign.jpg")).getImage();
		lblSignPic.setIcon(new ImageIcon(img));
		lblSignPic.setForeground(Color.WHITE);
		lblSignPic.setBackground(Color.WHITE);
		lblSignPic.setBounds(0, 0, 210, 204);
		frmWorkerWindow.getContentPane().add(lblSignPic);
		
		pnlSrchWorker = new WorkerPanel();
		pnlSrchWorker.setBounds(230, 22, 352, 430);
		pnlSrchWorker.setVisible(false);
		frmWorkerWindow.getContentPane().add(pnlSrchWorker);
		
		JButton btnSrchWorker = new JButton("Search worker");
		btnSrchWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlSrchWorker.setVisible(true);
			}
		});
		btnSrchWorker.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnSrchWorker.setBounds(20, 243, 179, 23);
		frmWorkerWindow.getContentPane().add(btnSrchWorker);
		
		JButton btnUpdateDetails = new JButton("Update details");
		btnUpdateDetails.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnUpdateDetails.setBounds(20, 277, 179, 23);
		frmWorkerWindow.getContentPane().add(btnUpdateDetails);
		
		
		
		
		
		
		
		
		
		
		
		
		frmWorkerWindow.setVisible(true);
	}
}
