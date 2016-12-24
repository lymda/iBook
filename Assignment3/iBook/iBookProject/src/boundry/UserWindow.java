package boundry;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import controller.AccountController;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class UserWindow {

	private JFrame frmUserWindow;
	private JPanel pnlSrchBook;
	private JPanel pnlSrchReviews;
	private AccountController accCntrl;
	
	/**
	 * Create the application.
	 */	
	public UserWindow(AccountController accCntrl) {
		this.accCntrl = accCntrl;
		System.out.println("userID = "+this.accCntrl.usr.getUserID());
		System.out.println("pass = "+this.accCntrl.usr.getPassword());
		System.out.println("conn = "+this.accCntrl.usr.isConnected());
		System.out.println("priv = "+this.accCntrl.usr.getPrivillage());
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUserWindow = new JFrame();
		frmUserWindow.setTitle("iBook - User Window");
		frmUserWindow.getContentPane().setBackground(Color.WHITE);
		frmUserWindow.setBounds(100, 100, 677, 513);
		frmUserWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUserWindow.getContentPane().setLayout(null);

		JLabel lblSignPic = new JLabel("");
		lblSignPic.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/logo2.jpg")).getImage();
		lblSignPic.setIcon(new ImageIcon(img));
		lblSignPic.setForeground(Color.WHITE);
		lblSignPic.setBackground(Color.WHITE);
		lblSignPic.setBounds(10, 11, 210, 204);
		frmUserWindow.getContentPane().add(lblSignPic);
		
		pnlSrchBook = new SearchBookPanel();
		pnlSrchBook.setBounds(230, 22, 352, 430);
		pnlSrchBook.setVisible(false);
		frmUserWindow.getContentPane().add(pnlSrchBook);
				
		pnlSrchReviews = new SearchReviewsPanel();
		pnlSrchReviews.setBounds(230, 22, 352, 430);
		pnlSrchReviews.setVisible(false);
		frmUserWindow.getContentPane().add(pnlSrchReviews);
		
		JPanel pnlStart = new WelcomePanel(accCntrl.usr.getUserID());
		pnlStart.setBounds(230, 22, 352, 430);
		pnlStart.setVisible(true);
		frmUserWindow.add(pnlStart);
		
		JButton btnSrchWorker = new JButton("Search Book");
		btnSrchWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlSrchBook.setVisible(true);
				pnlSrchReviews.setVisible(false);
			}
		});
		btnSrchWorker.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnSrchWorker.setBounds(20, 243, 179, 23);
		frmUserWindow.getContentPane().add(btnSrchWorker);
		
		JButton btnSearchReviews = new JButton("Search Reviews");
		btnSearchReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlSrchBook.setVisible(false);
				pnlSrchReviews.setVisible(true);
			}
		});
		btnSearchReviews.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnSearchReviews.setBounds(20, 277, 179, 23);
		pnlSrchReviews.setVisible(false);
		frmUserWindow.getContentPane().add(btnSearchReviews);
		
		JButton btnInsertPayment = new JButton("Insert payment");
		btnInsertPayment.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnInsertPayment.setBounds(20, 313, 179, 23);
		frmUserWindow.getContentPane().add(btnInsertPayment);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogingOut();
				
				new Login();
				frmUserWindow.dispose();
			}
		});
		btnLogout.setBounds(20, 429, 74, 23);
		frmUserWindow.getContentPane().add(btnLogout);
	//	pnlStart.setBackground(Color.YELLOW);
			
		frmUserWindow.setVisible(true);
	
		frmUserWindow.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(frmUserWindow, 
		            "Are you sure to close this window?", "Really Closing?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			    		LogingOut();
			            System.exit(0); 
		        	}
		        else // NO_OPTION
		        	frmUserWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		    }
		});
	}
	
	private void LogingOut(){
		// update connected = false
		accCntrl.usr.setConnected(false);
		accCntrl.UpdateConnected(accCntrl.usr.getUserID(), false);
	}
}
