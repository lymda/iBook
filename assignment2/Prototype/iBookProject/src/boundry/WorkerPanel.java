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
	private String strWorkerID, strDept, strRole;
	
	
	public WorkerPanel() {
		wrkrCntr = new WorkerController();
//		isEditMode = false;
		initialize();
	}
	
	private void initialize() {				
		setLayout(null);
		
		JLabel lblLanguage = new JLabel("Name:");
		lblLanguage.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblLanguage.setBounds(30, 108, 72, 14);
		add(lblLanguage);
		
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
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfName.getText().equals(""))
					JOptionPane.showMessageDialog(null,"Please fill the worker name.", "Search Error",JOptionPane.ERROR_MESSAGE);
				else
				{	// Send query request.
					if(!wrkrCntr.SearchWorkerByName(tfName.getText())){
						JOptionPane.showMessageDialog(null,"Any results were found.", "Search Error",JOptionPane.ERROR_MESSAGE);
						pnlWatch.setVisible(false);
					}
					else
					{
						btnEdit.setText("Edit");
						tfDept.setEditable(false);
						tfRole.setEditable(false);
						
						String workerID = Integer.toString(wrkrCntr.worker.GetWorkerID());
						String department = wrkrCntr.worker.GetDepartment();
						String workerRole = wrkrCntr.worker.GetWorkerRole();
						
						tfWorkerID.setText(workerID);
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
				
		JLabel lblWorkerID = new JLabel("Worker ID:");
		lblWorkerID.setBounds(0, 21, 82, 19);
		lblWorkerID.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		pnlWatch.add(lblWorkerID);
		
		tfWorkerID = new JTextField();
		tfWorkerID.setEditable(false);
		tfWorkerID.setColumns(10);
		tfWorkerID.setBounds(94, 20, 174, 20);
		pnlWatch.add(tfWorkerID);
		
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
		tfName.setBounds(117, 105, 175, 20);
		add(tfName);
		tfName.setColumns(10);
		
	}
	
	
	private void EditDetails(){
	//	isEditMode = true;
		
		tfName.setEditable(false);
		btnSearch.setEnabled(false);
		tfDept.setEditable(true);
		tfRole.setEditable(true);
		pnlSave.setVisible(true);
		pnlEdit.setVisible(false);
		
		// Saving current values for case of canceling edit.
		strWorkerID= tfWorkerID.getText();
		strDept= tfDept.getText();
		strRole= tfRole.getText();
	}
	
	
	private void SaveEdit(){
	//	isEditMode = false;

		tfName.setEditable(true);
		btnSearch.setEnabled(true);
		tfDept.setEditable(false);
		tfRole.setEditable(false);
		pnlEdit.setVisible(true);
		pnlSave.setVisible(false);
		
		wrkrCntr.UpdateWorkerDetails(tfWorkerID.getText(), tfDept.getText(), tfRole.getText());
	}
	
	private void CancelEdit(){
	//	isEditMode = false;

		// Reload previous values.
		tfWorkerID.setText(strWorkerID);
		tfDept.setText(strDept);
		tfRole.setText(strRole);
		
		tfName.setEditable(true);
		btnSearch.setEnabled(true);
		tfDept.setEditable(false);
		tfRole.setEditable(false);
		pnlEdit.setVisible(true);
		pnlSave.setVisible(false);
		
	}
}
