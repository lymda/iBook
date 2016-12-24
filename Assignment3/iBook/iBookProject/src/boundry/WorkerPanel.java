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


public class WorkerPanel extends JPanel{
	private JTextField tfName;
	private JTextField tfWorkerID;
	private JTextField tfDept;
	private JTextField tfRole;
	private WorkerController wrkrCntr;
	private JButton btnSearch;
	private JButton btnEdit;
	private JPanel pnlEdit;
	private JPanel pnlSave;
//	private boolean isEditMode;
	private String strWorkerName, strDept, strRole;
	
	
	public WorkerPanel() {
		wrkrCntr = new WorkerController();
//		isEditMode = false;
		initialize();
	}
	
	private void initialize() {				
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Search worker");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblTitle.setBounds(0, 21, 336, 20);
		add(lblTitle);
		
		JLabel lblInst = new JLabel("Please insert worker name to search:");
		lblInst.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		lblInst.setBounds(20, 67, 233, 20);
		add(lblInst);
		
		JPanel pnlWatch = new JPanel();
		pnlWatch.setBounds(23, 170, 278, 165);
		pnlWatch.setVisible(false);
		add(pnlWatch);
		pnlWatch.setLayout(null);		
		
		JLabel lblWorkerID = new JLabel("Worker ID:");
		lblWorkerID.setBounds(30, 106, 82, 19);
		add(lblWorkerID);
		lblWorkerID.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		
		tfWorkerID = new JTextField();
		tfWorkerID.setBounds(124, 105, 174, 20);
		add(tfWorkerID);
		tfWorkerID.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String txt = tfWorkerID.getText();
				if(txt.equals("") || !txt.matches("[.0-9]+"))
				{
					JOptionPane.showMessageDialog(null,"Worker ID must be only digits.", "Search Error",JOptionPane.ERROR_MESSAGE);
					pnlWatch.setVisible(false);
				}
				else
				{	// Send query request.
					if(!wrkrCntr.SearchWorkerByID(tfWorkerID.getText())){
						JOptionPane.showMessageDialog(null,"No results were found.", "Search Error",JOptionPane.ERROR_MESSAGE);
						pnlWatch.setVisible(false);
					}
					else
					{
						btnEdit.setText("Edit");
						tfDept.setEditable(false);
						tfRole.setEditable(false);
						
						String workerName = wrkrCntr.worker.GetWorkerName();
						String department = wrkrCntr.worker.GetDepartment();
						String workerRole = wrkrCntr.worker.GetWorkerRole();
						
						tfName.setText(workerName);
						tfDept.setText(department);
						tfRole.setText(workerRole);
						
						pnlWatch.setVisible(true);
						pnlEdit.setVisible(true);
						pnlSave.setVisible(false);
					}// end else (got results).
				}// end else (field not empty).
			}//end else (!isEditMode).
		});
		btnSearch.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		btnSearch.setBounds(161, 136, 84, 23);
		add(btnSearch);
		
		JLabel lnlDept = new JLabel("Department:");
		lnlDept.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lnlDept.setBounds(0, 61, 82, 19);
		pnlWatch.add(lnlDept);
		
		tfDept = new JTextField();
		tfDept.setEditable(false);
		tfDept.setColumns(10);
		tfDept.setBounds(94, 60, 174, 20);
		pnlWatch.add(tfDept);
		
		JLabel lblRole = new JLabel("Worker role:");
		lblRole.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblRole.setBounds(0, 100, 94, 19);
		pnlWatch.add(lblRole);
		
		tfRole = new JTextField();
		tfRole.setEditable(false);
		tfRole.setColumns(10);
		tfRole.setBounds(94, 99, 174, 20);
		pnlWatch.add(tfRole);
		
		pnlEdit = new JPanel();
		pnlEdit.setBounds(94, 130, 174, 26);
		pnlWatch.add(pnlEdit);
		pnlEdit.setLayout(null);
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(44, 0, 85, 23);
		pnlEdit.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditDetails();
			}
		});
		btnEdit.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		
		pnlSave = new JPanel();
		pnlSave.setLayout(null);
		pnlSave.setBounds(94, 130, 174, 26);
		pnlSave.setVisible(false);
		pnlWatch.add(pnlSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelEdit();
			}
		});
		btnCancel.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		btnCancel.setBounds(89, 0, 85, 23);
		pnlSave.add(btnCancel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveEdit();
			}
		});
		btnSave.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		btnSave.setBounds(0, 0, 85, 23);
		pnlSave.add(btnSave);
		
		tfName = new JTextField();
		tfName.setEditable(false);
		tfName.setBounds(94, 20, 175, 20);
		pnlWatch.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblLanguage = new JLabel("Name:");
		lblLanguage.setBounds(0, 23, 72, 14);
		pnlWatch.add(lblLanguage);
		lblLanguage.setFont(new Font("Sitka Text", Font.PLAIN, 14));
	}
	
	
	private void EditDetails(){
		btnSearch.setEnabled(false);
		pnlSave.setVisible(true);
		pnlEdit.setVisible(false);
		
		tfName.setEditable(true);
		tfWorkerID.setEditable(false);
		tfDept.setEditable(true);
		tfRole.setEditable(true);
		
		// Saving current values for case of canceling edit.
		strWorkerName= tfName.getText();
		strDept= tfDept.getText();
		strRole= tfRole.getText();
	}
	
	
	private void SaveEdit(){
		tfWorkerID.setEditable(true);
		btnSearch.setEnabled(true);
		tfName.setEditable(false);
		tfDept.setEditable(false);
		tfRole.setEditable(false);
		pnlEdit.setVisible(true);
		pnlSave.setVisible(false);
		
		wrkrCntr.UpdateWorkerDetails(tfWorkerID.getText(), tfName.getText(), tfDept.getText(), tfRole.getText());
	}
	
	private void CancelEdit(){
		
		// Reload previous values.
		tfName.setText(strWorkerName);
		tfDept.setText(strDept);
		tfRole.setText(strRole);
		
		tfWorkerID.setEditable(true);
		btnSearch.setEnabled(true);
		tfName.setEditable(false);
		tfDept.setEditable(false);
		tfRole.setEditable(false);
		pnlEdit.setVisible(true);
		pnlSave.setVisible(false);
		
	}
}
