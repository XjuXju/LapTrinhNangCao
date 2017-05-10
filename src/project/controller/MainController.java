package project.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.lang.model.element.Element;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import project.values.*;
import project.view.*;
import project.model.*;

public class MainController {
	IMainForm mMainForm = null;
	Connection connection;

	ConnectDatabase mDatabase = new ConnectDatabase();
	DialogMessage mMessage = new DialogMessage();

	private DefaultTableModel model1, model2;
	private String _studentID = "";
	private Boolean isEdit = true;
	private Boolean isStudentTb = true;
	private Boolean isSelectedRoom = false;
	private String house, roomName;
	Student student = new Student();
	ArrayList<String> item_ArrayList = new ArrayList<>();
	String[] item;
	
	private int row;

	public MainController(ConnectDatabase mDb) {
		this.mDatabase = mDb;
		student.getInstance();

		mMainForm = new MainForm();
		
		mMainForm.setTable(mMainForm.getTableStudentInfor());
		//mDatabase.ConnectToMySQL();

		loadStudentTable();
		
		loadRoomTable(mDatabase.getRoomOfHouse("1"));
		selectStudentTableRow();

		mMainForm.setActionListenerForAddStudentButtonInMain(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				row = mMainForm.getTableStudentInfor().getSelectedRow();
				student = mMainForm.getStudentInfor();
				// if(student !=null){
				if (student.checkAdd(student)) {
					if (mDatabase.checkExistID(student.getStudentID())) {
						mMessage.dialogAddNewStudent(2);
					} else {
						if (mDatabase.addStudent(student)) {
							mMessage.dialogAddNewStudent(0);
							resetInfor();
						}
					}

				} else {
					mMessage.dialogAddNewStudent(3);
				}

			}
		});
		/**
		 * su kien cho edit button
		 * 
		 */

		mMainForm.setActionListenerForEditStudentButtonInMain(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				row = mMainForm.getTableStudentInfor().getSelectedRow();
				System.out.println("row " + row);
				if (isEdit) {
					if (row < 0) {
						mMessage.dialogErrorTable();
					} else {
						_studentID = (String) mMainForm.getTableStudentInfor().getValueAt(row, 0);
						student = mDatabase.getStudent(_studentID);
						mMainForm.setStudentInfor(student, false);
						mMainForm.setEditButton(false);
						isEdit = false;

					}
				} else {
					student = mMainForm.getStudentInfor();
					if (mDatabase.editStudent(student, _studentID)) {
						mMessage.dialogUpdate(true);
						loadStudentTable();
						
						resetInfor();
						isEdit = true;
						mMainForm.setEditButton(true);
					} else {
						mMessage.dialogUpdate(false);
					}

				}
			}
		});
		mMainForm.setActionListenerForCancelButtonInMain(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("is Cancel button 136: " + mMainForm.isCancelButton());
				if (mMainForm.isCancelButton()) {
					System.out.println("is Cancel button 136: " + mMainForm.isCancelButton());
					mMainForm.setEditAndDeleteButton(false);
					resetInfor();
				} else {

					mMainForm.closeForm();
				}
			}
		});

		mMainForm.setActionListenerForTxtSearchInMain(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mMainForm.setTableStudentModel(mDatabase.loadData(mDatabase.searchStudentInfor(mMainForm.getTxtSearch())));

			}
		});
		mMainForm.setTable(mMainForm.getTableStudentInfor());

		mMainForm.setActionListenerForJTable(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				if (row >= 0) {
					if (SwingUtilities.isRightMouseButton(e)) {
						int isDelete = JOptionPane.showConfirmDialog(null, "Are you sure? ", "Delele",
								JOptionPane.YES_NO_OPTION);
						if (isDelete == JOptionPane.YES_OPTION) {
							deleteStudentSelected();
						}
					}
				}

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				selectStudentTableRow();
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		mMainForm.setActionListenerForRoomTable(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				selectRoomTableRow();

			}
		});
		
		mMainForm.setActionListenerForComboboxInMain(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		item_ArrayList = mDatabase.getItemArrayForComboBox();
		item = new String[item_ArrayList.size()];
		item = item_ArrayList.toArray(item);
		if(item != null){
		mMainForm.setComboBoxIndex(item);
		}
		mMainForm.setActionListenerForComboboxInMain(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadRoomTable(mDatabase.getRoomOfHouse(mMainForm.getItemSelceted()));
				
				
			}
		});
	}

	public void loadStudentTable() {
		

		model1 = mDatabase.loadData(mDatabase.getStudentInfor());
		mMainForm.setTableStudentModel(model1);
	}

	public void loadRoomTable(ResultSet rs_room) {
		model2 = mDatabase.loadData(rs_room);
		mMainForm.setTableRoomModel(model2);

	}

	public void selectStudentTableRow() {
		row = mMainForm.getTableStudentInfor().getSelectedRow();
		int rowRoom = mMainForm.getTableStudentInfor().getSelectedRow();
		System.out.println("gia tri row1 : " + row + " room: " + rowRoom);
		if (row >= 0) {
			mMainForm.setEditAndDeleteButton(true);
		}
	}

	public void selectRoomTableRow() {
		// row = mMainForm.getTableRoomInfor().getSelectedRow();
		int rowRoom = mMainForm.getTableRoomInfor().getSelectedRow();
		System.out.println("gia tri row1 : " + row + " room: " + rowRoom);
		if (rowRoom >= 0) {
			roomName = (String) mMainForm.getTableRoomInfor().getValueAt(rowRoom, 0);
			house = (String) mMainForm.getTableRoomInfor().getValueAt(rowRoom, 1);
			System.out.println("house and name in 234: " + rowRoom + "nameRoom: " + roomName + " " + house);
			isSelectedRoom = true;
			loadStudentTableInRoom(house, roomName);
		}
	}

	public void loadStudentTableInRoom(String _house, String _roomName) {
		ResultSet rs = mDatabase.getStudentIdInforOfRoom(_house, _roomName);
		System.out.println("gia tri result trar veef dong 239: "+rs);
		if (rs != null) {
			model2 = mDatabase.loadData(rs);
			mMainForm.setTableStudentModel(model2);
		} else {
			System.out.println(" chua co sinh vien nao dk!");
		}
	}

	public void resetInfor() {
		mMainForm.setStudentInfor(null, true);
		// mTable.loadStudentTable();
	}

	public void deleteStudentSelected() {
		_studentID = (String) mMainForm.getTableStudentInfor().getValueAt(row, 0);
		System.out.println("student id 70: " + _studentID);
		mDatabase.deleteObject(ConstValues.TABLE_STUDENT, _studentID);
	}


		
		
	
}
