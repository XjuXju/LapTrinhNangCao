package project.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.management.remote.JMXAuthenticator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import project.model.Student;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainForm implements IMainForm {

	private JFrame frame;
	private JTextField txtSearch;
	private JTable tableStudent = new JTable();;
	private JTextField txtNameStudent;
	private JTextField txtMssv;
	private JTable table_room = new JTable();;
	private JTextField txtGender;
	private JTextField txtBirthday;
	private JTextField txtNumber;
	private JTextField txtClass;
	private JTextField txtCountry;
	private JTextField txtNationality;
	private JButton btnAdd, btnEdit, btnCancel;
	private JComboBox<String> cbbHouse;
	private JPanel panelHouse;
	private IMainForm mMainForm = null;
	JScrollPane scrollPaneST;

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1007, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(432, 11, 526, 102);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSearch.setBounds(209, 43, 169, 26);
		panel_1.add(txtSearch);
		txtSearch.setColumns(10);

		JLabel lblNhpThngTin = new JLabel("Nhập thông tin cần tìm:");
		lblNhpThngTin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNhpThngTin.setBounds(39, 44, 160, 20);
		panel_1.add(lblNhpThngTin);

		scrollPaneST = new JScrollPane(tableStudent);
		scrollPaneST.setBounds(432, 124, 526, 400);
		frame.getContentPane().add(scrollPaneST);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 79, 401, 445);
		frame.getContentPane().add(tabbedPane);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Thông tin sinh viên", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thông tin sinh viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(112, 11, 161, 30);
		panel_2.add(lblNewLabel);

		JLabel lblHTn = new JLabel("Họ tên:");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHTn.setBounds(31, 52, 59, 19);
		panel_2.add(lblHTn);

		txtNameStudent = new JTextField();
		txtNameStudent.setBounds(136, 52, 200, 22);
		panel_2.add(txtNameStudent);
		txtNameStudent.setColumns(10);

		JLabel lblMssv = new JLabel("MSSV: ");
		lblMssv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMssv.setBounds(31, 82, 59, 19);
		panel_2.add(lblMssv);

		txtMssv = new JTextField();
		txtMssv.setColumns(10);
		txtMssv.setBounds(136, 85, 200, 22);
		panel_2.add(txtMssv);

		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiiTnh.setBounds(31, 117, 59, 19);
		panel_2.add(lblGiiTnh);

		JLabel lblNgySinh = new JLabel("Ngày sinh: ");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgySinh.setBounds(31, 147, 79, 19);
		panel_2.add(lblNgySinh);

		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinThoi.setBounds(31, 177, 89, 19);
		panel_2.add(lblSinThoi);

		JLabel lblLp = new JLabel("Lớp:");
		lblLp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLp.setBounds(31, 207, 59, 19);
		panel_2.add(lblLp);

		JLabel lblQuQun = new JLabel("Quê quán:");
		lblQuQun.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuQun.setBounds(31, 237, 79, 19);
		panel_2.add(lblQuQun);

		JLabel lblQucTch = new JLabel("Quốc tịch:");
		lblQucTch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQucTch.setBounds(31, 267, 79, 19);
		panel_2.add(lblQucTch);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 301, 376, 59);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		btnEdit = new JButton("Sửa ");
		btnEdit.setVisible(false);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBounds(138, 11, 99, 26);
		panel_4.add(btnEdit);

		btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(138, 11, 99, 26);
		panel_4.add(btnAdd);

		btnCancel = new JButton("Hủy bỏ");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(247, 11, 99, 26);
		panel_4.add(btnCancel);

		txtGender = new JTextField();
		txtGender.setColumns(10);
		txtGender.setBounds(136, 118, 200, 22);
		panel_2.add(txtGender);

		txtBirthday = new JTextField();
		txtBirthday.setColumns(10);
		txtBirthday.setBounds(136, 148, 200, 22);
		panel_2.add(txtBirthday);

		txtNumber = new JTextField();
		txtNumber.setColumns(10);
		txtNumber.setBounds(136, 178, 200, 22);
		panel_2.add(txtNumber);

		txtClass = new JTextField();
		txtClass.setColumns(10);
		txtClass.setBounds(136, 208, 200, 22);
		panel_2.add(txtClass);

		txtCountry = new JTextField();
		txtCountry.setColumns(10);
		txtCountry.setBounds(136, 238, 200, 22);
		panel_2.add(txtCountry);

		txtNationality = new JTextField();
		txtNationality.setColumns(10);
		txtNationality.setBounds(136, 268, 200, 22);
		panel_2.add(txtNationality);

		panelHouse = new JPanel();
		tabbedPane.addTab("Thông tin nhà", null, panelHouse, null);
		panelHouse.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 24, 357, 45);
		panelHouse.add(panel);
		panel.setLayout(null);

		JLabel lblLaChnNh = new JLabel("Chọn dãy nhà:");
		lblLaChnNh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLaChnNh.setBounds(22, 11, 97, 23);
		panel.add(lblLaChnNh);

		cbbHouse = new JComboBox();
		cbbHouse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbbHouse.setBounds(141, 10, 156, 25);
		panel.add(cbbHouse);

		JScrollPane scrollPane_1 = new JScrollPane(table_room);
		scrollPane_1.setBounds(10, 90, 357, 290);
		panelHouse.add(scrollPane_1);

		JLabel lblNewLabel_1 = new JLabel("Quản lí thông tin sinh viên kí túc xá");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(34, 22, 334, 46);
		frame.getContentPane().add(lblNewLabel_1);
	}

	@Override
	public void setActionListenerForAddStudentButtonInMain(ActionListener listener) {
		btnAdd.addActionListener(listener);

	}

	@Override
	public void setActionListenerForEditStudentButtonInMain(ActionListener listener) {
		// btnAdd.setText("Lưu");
		btnEdit.addActionListener(listener);

	}

	@Override
	public void setActionListenerForDeleteStudentButtonInMain(ActionListener listener) {
		btnAdd.addActionListener(listener);

	}

	public void setActionListenerForCancelButtonInMain(ActionListener listener) {
		btnCancel.addActionListener(listener);
	}

	@Override
	public void setActionListenerForComboboxInMain(ActionListener listener) {
		cbbHouse.addActionListener(listener);

	}

	@Override
	public void setActionListenerForTxtSearchInMain(ActionListener listener) {
		txtSearch.addActionListener(listener);

	}

	@Override
	public void setStudentInfor(Student student, Boolean isReset) {
		if (isReset) {
			txtMssv.setText("");
			txtNameStudent.setText("");
			txtGender.setText("");
			txtBirthday.setText("");
			txtNumber.setText("");
			txtClass.setText("");
			txtCountry.setText("");
			txtNationality.setText("");
		} else {
			txtMssv.setText(student.getStudentID().toString());
			txtNameStudent.setText(student.getStudentName());
			txtGender.setText(student.getGender());
			txtBirthday.setText(student.getBirthday());
			txtNumber.setText(student.getPhoneNumber());
			txtClass.setText(student.getStudentClass());
			txtCountry.setText(student.getCountry());
			txtNationality.setText(student.getNationality());
		}

	}

	@Override
	public Student getStudentInfor() {
		Student student = new Student(txtMssv.getText().toString().trim(), txtNameStudent.getText().toString().trim(),
				txtGender.getText().toString().trim(), txtBirthday.getText().toString().trim(),
				txtNumber.getText().toString().trim(), txtClass.getText().toString().trim(),
				txtCountry.getText().toString().trim(), txtNationality.getText().toString().trim());

		return student;
	}

	public void setTable(JTable mJTable) {
		tableStudent = mJTable;
	}

	@Override
	public void setTableStudentModel(DefaultTableModel model) {

		tableStudent.setModel(model);
	}

	@Override
	public JTable getTableStudentInfor() {

		return tableStudent;
	}

	@Override
	public void closeForm() {

		frame.dispose();
	}

	@Override
	public JTable getTableRoomInfor() {

		return table_room;
	}

	public void setEditAndDeleteButton(Boolean isRowSelected) {
		if (isRowSelected) {
			btnEdit.setVisible(true);
			btnAdd.setVisible(false);
			btnCancel.setText("Quay lại");
		} else {
			btnEdit.setVisible(false);
			btnAdd.setVisible(true);
			btnAdd.setText("Thêm");
			btnCancel.setText("Hủy bỏ");
		}
	}

	public Boolean isCancelButton() {
		Boolean isCancelButton = false;
		System.out.println("isCancel : " + btnCancel.getText().toString().trim());
		System.out.println("gia tri 353: " + btnCancel.getText().toString().trim().compareTo("Quay lại"));
		if (btnCancel.getText().toString().trim().compareTo("Quay lại") == 0) {
			System.out.println("isCancel : " + btnCancel.getText().toString().trim());
			isCancelButton = true;
			System.out.println("isCancel 356:" + isCancelButton);
		}
		System.out.println("isCancel 358:" + isCancelButton);
		return isCancelButton;
	}

	@Override
	public void setActionListenerForJTable( MouseListener listener) {
	
			tableStudent.addMouseListener(listener);
		
	}
	public void setActionListenerForRoomTable( MouseListener listener) {
	
			table_room.addMouseListener(listener);

	}

	@Override
	public void setTableRoomModel(DefaultTableModel model) {
		table_room.setModel(model);

	}

	@Override
	public void setEditButton(Boolean isEdit) {
		if (isEdit) {
			btnEdit.setText("Sửa");
		} else {
			btnEdit.setText("OK");
		}

	}
	public void setComboBoxIndex(String[] item){
		for (int i = 0; i < item.length; i++) {
			cbbHouse.addItem((item[i]));
		}
	}
	public int getComboBox(){
		return this.cbbHouse.getSelectedIndex();
	}
	public String getItemSelceted(){
		return String.valueOf(this.cbbHouse.getItemAt(getComboBox()).toString());
		
	}

	@Override
	public String getTxtSearch() {
		// TODO Auto-generated method stub
		return txtSearch.getText().toString().trim();
	}

}
