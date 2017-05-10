package project.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import project.model.Student;

public interface IMainForm {
public  String S ="";
	public void setActionListenerForAddStudentButtonInMain(ActionListener listener);

	public void setActionListenerForEditStudentButtonInMain(ActionListener listener);

	public void setActionListenerForDeleteStudentButtonInMain(ActionListener listener);

	public void setActionListenerForCancelButtonInMain(ActionListener listener);

	public void setActionListenerForComboboxInMain(ActionListener listener);

	public void setActionListenerForTxtSearchInMain(ActionListener listener);

	public void setStudentInfor(Student student, Boolean isReset);

	public Student getStudentInfor();

	// public JTable getTableStudentInfor();

	public JTable getTableRoomInfor();

	// public void setTableStudentModel(DefaultTableModel model);

	public void setTableRoomModel(DefaultTableModel model);

	public void setEditAndDeleteButton(Boolean isRowSelected);


	public void setEditButton(Boolean isEdit);

	public Boolean isCancelButton();

	public void closeForm();

	public void setTable(JTable mJTable);

	public void setActionListenerForJTable( MouseListener listener);
	public void setActionListenerForRoomTable( MouseListener listener);

	void setTableStudentModel(DefaultTableModel model);

	public JTable getTableStudentInfor();

	public void setComboBoxIndex(String[] item);
	public int getComboBox();
	public String getItemSelceted();
	// public void getInstance();
	public String getTxtSearch();

}
