package boundry;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomePanel extends JPanel {
	
	public JLabel lblName;
	private String userID;
	
	public WelcomePanel(String userID) {
		this.userID = userID;
		initialize();
	}
	
	private void initialize() {
		setLayout(null);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(0, 66, 355, 22);
		lblWelcome.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		add(lblWelcome);
		
		lblName = new JLabel(userID);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblName.setBounds(0, 99, 355, 22);
		add(lblName);
		
		JLabel lblInst = new JLabel("What would you like to do?");
		lblInst.setHorizontalAlignment(SwingConstants.CENTER);
		lblInst.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		lblInst.setBounds(0, 151, 355, 20);
		add(lblInst);
	}
}
