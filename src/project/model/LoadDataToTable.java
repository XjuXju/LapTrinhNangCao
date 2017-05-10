package project.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import project.view.IMainForm;
import project.view.MainForm;

public class LoadDataToTable extends Thread{
		ConnectDatabase db = new ConnectDatabase();
		IMainForm mainForm = new MainForm();
	public LoadDataToTable(IMainForm m){
		mainForm =m;
	}
	@Override
	public void run() {
	super.run();
	mainForm.setTableStudentModel(getModel());
	
	}
	public DefaultTableModel getModel(){
		ResultSet rs = db.getStudentInfor();
		DefaultTableModel model = new DefaultTableModel();
		
		try {
			ResultSetMetaData rsm = rs.getMetaData();
			int column = rsm.getColumnCount();
			String[] arr = new String[column];
			for (int i = 0; i < column; i++) {
				arr[i] = rsm.getColumnName(i + 1);
			}
			System.out.println("gia tri: default table " + column);
			model.setColumnIdentifiers(arr);

			if (rs.first()) {
				do {
					for (int i = 0; i < column; i++) {
						arr[i] = rs.getString(i + 1);
					}
					model.addRow(arr);
				} while (rs.next());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;
	}
	}


