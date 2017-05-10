package project.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import project.model.House;
import project.model.Room;
import project.model.Student;
import project.values.ConstValues;

public class ConnectDatabase {

	private String sql = "";
	private Connection connection;
	public ConnectDatabase(){
		ConnectToMySQL();
	}
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ConnectToMySQL() {
		connect();
		String host = "jdbc:mysql://localhost/laptrinhnangcao?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String pass = "";
		try {
			connection = DriverManager.getConnection(host, user, pass);
			System.out.println("Connect success...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet getData(String table) {
		ResultSet rs = null;
		sql = "Select * from " + table;
		rs = getResult(sql);
		return rs;
	}

	public ResultSet getStudentInfor() {
		ResultSet rs = null;
		sql = "SELECT  studentID, studentName, gender, birthday FROM  " + ConstValues.TABLE_STUDENT;
		rs = getResult(sql);
		return rs;
	}

	public ResultSet searchStudentInfor(String txtSearch) {
		ResultSet rs = null;
		sql = "SELECT  studentID, studentName, gender, birthday FROM  " + ConstValues.TABLE_STUDENT
				+ " where studentID LIKE '%" + txtSearch + "%'" + " OR studentName LIKE '%" + txtSearch
				+ "%' OR gender LIKE '%" + txtSearch + "%' OR birthday LIKE '%" + txtSearch + "%'";
		rs = getResult(sql);
		return rs;
	}

	public ResultSet getRoomOfHouse(String house) {
		ResultSet rs = null;
		sql = "Select roomName, gender, registed, maximum from tbl_room Where houseName = '" + house + "'";
		rs = getResult(sql);
		return rs;
	}

	public ResultSet getResult(String sql) {
		ResultSet rs = null;
		Statement st = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Select err : " + e.toString());
		}
		return rs;
	}

	public Student getStudent(String studentID) {
		Student st = null;
		sql = "SELECT * FROM " + ConstValues.TABLE_STUDENT + " WHERE studentID = '" + studentID + "'";
		ResultSet rs = null;
		try {
			rs = connection.createStatement().executeQuery(sql);
			if (rs.first()) {
				st = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

	public ResultSet getStudentIdInforOfRoom(String house, String room) {
		ResultSet rs = null;
		sql = "SELECT  tbl_student.studentID, tbl_student.studentName, tbl_student.gender, tbl_student.birthday"
				+ " FROM tbl_student INNER JOIN residentialinfor on residentialinfor.StudentID= tbl_student.studentID "
				+ "WHERE residentialinfor.roomName = '" + room + "' AND residentialinfor.houseName = '" + house + "'";
		rs = getResult(sql);
		return rs;
	}

	public DefaultTableModel loadData(ResultSet rs) {

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

	public boolean isAdmin(String userName, String pass) {
		sql = "SELECT username, password FROM tbl_admin WHERE username = '" + userName + "' AND password = '" + pass
				+ "'";
		ResultSet rs = null;
		try {
			rs = connection.createStatement().executeQuery(sql);
			if (rs.first()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public Boolean addStudent(Student student) {
		sql = "INSERT INTO " + ConstValues.TABLE_STUDENT + " VALUES( ?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, student.getStudentID());
			ps.setString(2, student.getStudentName());
			ps.setString(3, student.getGender());
			ps.setString(4, student.getBirthday());
			ps.setString(5, student.getPhoneNumber());
			ps.setString(6, student.getStudentClass());
			ps.setString(7, student.getCountry());
			ps.setString(8, student.getNationality());

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Boolean editStudent(Student student, String studentID) {
		sql = "UPDATE " + ConstValues.TABLE_STUDENT + " SET studentName =? , gender =?, birthday =?, "
				+ "phoneNumber =?, studentClass =?, country =?, nationality =? WHERE studentID ='" + studentID + "'";
		PreparedStatement prs = null;
		try {
			prs = connection.prepareStatement(sql);

			prs.setString(1, student.getStudentName());
			prs.setString(2, student.getGender());
			prs.setString(3, student.getBirthday());
			prs.setString(4, student.getPhoneNumber());
			prs.setString(5, student.getStudentClass());
			prs.setString(6, student.getCountry());
			prs.setString(7, student.getNationality());
			if (prs.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public Boolean deleteObject(String table, String objectID) {
		sql = "DELETE FROM " + table + " WHERE studentID = '" + objectID + "'";
		PreparedStatement prs = null;
		try {
			prs = connection.prepareStatement(sql);
			if (prs.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public Boolean checkExistID(String existID) {
		sql = "SELECT *FROM " + ConstValues.TABLE_STUDENT + " WHERE studentID = '" + existID + "'";
		ResultSet rs = null;
		try {
			rs = connection.createStatement().executeQuery(sql);
			if (rs.first()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// House
	public Boolean addHouse(House house) {
		sql = "INSERT INTO" + ConstValues.TABLE_HOUSE + " VALUES(?,?,?,?)";
		PreparedStatement prs = null;
		try {
			prs = connection.prepareStatement(sql);
			prs.setString(1, house.getHouseName());
			prs.setString(2, house.getMaleRoom());
			prs.setString(3, house.getFemaleRoom());
			prs.setString(4, house.getQuantity());

			if (prs.executeLargeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public Boolean editHouse(House house, String houseName) {
		sql = "UPDATE " + ConstValues.TABLE_HOUSE + " SET maleRoom =?, female=?, quantity =? WHERE houseName = '"
				+ houseName + "'";
		PreparedStatement prs = null;
		try {
			prs = connection.prepareStatement(sql);
			prs.setString(1, house.getMaleRoom());
			prs.setString(2, house.getFemaleRoom());
			prs.setString(3, house.getQuantity());

			if (prs.executeLargeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	// Room

	public Boolean addRoom(Room room) {
		sql = "INSERT INTO" + ConstValues.TABLE_ROOM + " VALUES(?,?,?,?,?)";
		PreparedStatement prs = null;
		try {
			prs = connection.prepareStatement(sql);
			prs.setString(1, room.getRoomName());
			prs.setString(2, room.getHouseName());
			prs.setString(3, room.getGender());
			prs.setString(4, room.getQuantity());
			prs.setString(5, room.getStatus());

			if (prs.executeLargeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public Boolean editRoom(Room room, String roomName) {
		sql = "UPDATE " + ConstValues.TABLE_ROOM
				+ " SET houseName =?, gender =?, quantity =?, status =? WHERE roomName =" + roomName + "'";
		PreparedStatement prs = null;
		try {
			prs = connection.prepareStatement(sql);
			prs.setString(1, room.getHouseName());
			prs.setString(2, room.getGender());
			prs.setString(3, room.getQuantity());
			prs.setString(4, room.getStatus());

			if (prs.executeLargeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public void showDate(ResultSet rs) {

		try {
			if (rs.first())
				do {
					System.out.println("thong tin sinh vien showData: " + rs.getString(1) + "  " + rs.getString(2));
				} while (rs.next());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<String> getItemArrayForComboBox() {
		ResultSet rs = null;

		ArrayList<String> array = new ArrayList<>();

		sql = "SELECT houseName FROM " + ConstValues.TABLE_HOUSE;
		Statement st = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			if (rs.first()) {
				do {
					array.add(rs.getString(1));

				} while (rs.next());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return array;
	}

	/*
	 * String[] x =cn.getItemArrayForComboBox(); for (int i = 0; i < x.length;
	 * i++) { System.out.println("tham so: "+x[i]); }
	 */
}
/*
 * st = cn.getStudentIdInforOfRoom("B10", "101"); String _st =st[0]; for (int i
 * = 1; i < st.length; i++) { _st = _st+","+st[i]; } String string =
 * _st.toString(); cn.showDate(cn.getStudentInforOfRoom(string)); }
 */
/*
 * String[] id = {"20121","20122"}; for (int i = 0; i < id.length; i++) {
 * cn.showDate(cn.getStudentInforOfRoom(id[i])); }
 */

/*
 * Student student = new Student(); student = cn.getStudent("20121");
 * System.out.println(" thong tin sv: " + student.getGender());
 */
// Student student = new Student("20122", "Trần Đức Anh","20-5-1994" ,
// "nam", "01689678543", "dtvt01", "Cẩm Xuyên -Hà Tĩnh", "Việt Nam");
// Boolean bl = cn.deleteStudent("2012");
// System.out.println("ket qua: " + bl);

// }
