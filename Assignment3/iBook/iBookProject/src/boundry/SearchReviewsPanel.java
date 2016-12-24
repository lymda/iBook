package boundry;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import controller.WorkerController;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;


public class SearchReviewsPanel extends JPanel{
	private JTextField tfName;
	private JButton btnSearch;
	private String strWorkerName, strDept, strRole;
	
	
	public SearchReviewsPanel() {
		initialize();
	}
	
	private void initialize() {				
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Search reviews");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblTitle.setBounds(0, 21, 336, 20);
		add(lblTitle);
		
		JLabel lblInst = new JLabel("Please insert worker key to search:");
		lblInst.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		lblInst.setBounds(20, 67, 233, 20);
		add(lblInst);
		
		JLabel lblSearchKey = new JLabel("Search key:");
		lblSearchKey.setBounds(30, 106, 82, 19);
		add(lblSearchKey);
		lblSearchKey.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSearch.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		btnSearch.setBounds(138, 181, 84, 23);
		add(btnSearch);
		
		JComboBox cbSrchKey = new JComboBox();
		cbSrchKey.setBounds(137, 105, 153, 20);
		add(cbSrchKey);
		
		JLabel lblLanguage = new JLabel("Search value:");
		lblLanguage.setBounds(33, 144, 95, 14);
		add(lblLanguage);
		lblLanguage.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		
		tfName = new JTextField();
		tfName.setBounds(138, 141, 153, 20);
		add(tfName);
		tfName.setColumns(10);
	}
}
