package boundry;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchBookPanel extends JPanel{
	private JTextField tfTitle;
	private JTextField tfAuthor;
	private JComboBox cbLanguage;
	private JComboBox cbCategory;
	private JComboBox cbSubject;
	
	public SearchBookPanel() {
		initialize();
	}
	
	private void initialize() {				
		setLayout(null);
		
		JLabel lblSearchTitle = new JLabel("Search for book");
		lblSearchTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchTitle.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblSearchTitle.setBounds(0, 21, 336, 20);
		add(lblSearchTitle);
		
		JLabel lblInst = new JLabel("Please insert book details to search:");
		lblInst.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		lblInst.setBounds(20, 67, 233, 20);
		add(lblInst);
		
		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(98, 123, 104, 20);
		add(tfTitle);
		
		tfAuthor = new JTextField();
		tfAuthor.setText("");
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(98, 148, 104, 20);
		add(tfAuthor);
		
		cbLanguage = new JComboBox();
		cbLanguage.setBounds(98, 173, 104, 20);
		add(cbLanguage);
		
		cbCategory = new JComboBox();
		cbCategory.setBounds(98, 198, 104, 20);
		add(cbCategory);
		
		cbSubject = new JComboBox();
		cbSubject.setEnabled(false);
		cbSubject.setBounds(98, 223, 104, 20);
		add(cbSubject);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblSubject.setEnabled(false);
		lblSubject.setBounds(20, 226, 68, 14);
		add(lblSubject);
		
		JRadioButton rdbtnOr = new JRadioButton("OR");
		rdbtnOr.setEnabled(false);
		rdbtnOr.setBounds(158, 248, 58, 23);
		add(rdbtnOr);
		
		JRadioButton rdbtnAnd = new JRadioButton("AND");
		rdbtnAnd.setSelected(true);
		rdbtnAnd.setEnabled(false);
		rdbtnAnd.setBounds(98, 248, 58, 23);
		add(rdbtnAnd);
		
		JLabel lblSearchBy = new JLabel("Search by:");
		lblSearchBy.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblSearchBy.setEnabled(false);
		lblSearchBy.setBounds(20, 252, 72, 14);
		add(lblSearchBy);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblCategory.setBounds(20, 201, 68, 14);
		add(lblCategory);
		
		JLabel lblLanguage = new JLabel("Language:");
		lblLanguage.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblLanguage.setBounds(20, 176, 68, 14);
		add(lblLanguage);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblAuthor.setBounds(20, 151, 68, 14);
		add(lblAuthor);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblTitle.setBounds(20, 126, 68, 14);
		add(lblTitle);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchBook();
			}
		});
		btnSearch.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		btnSearch.setBounds(97, 278, 89, 23);
		add(btnSearch);
	}
	
	
	private void SearchBook(){
		// Check if all fields are empty - a search not performed.
		if(tfTitle.getText().equals("") &&
				tfAuthor.getText().equals("") &&
				cbLanguage.getItemCount() == 0 &&
				cbCategory.getItemCount() == 0 &&
				cbSubject.getItemCount() == 0)
			JOptionPane.showMessageDialog(null,"Please insert any value for search.", "Search Error",JOptionPane.ERROR_MESSAGE);
		
	}
	
}
