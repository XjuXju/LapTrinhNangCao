package project.model;

import java.sql.Date;

public class Student {
	private String studentID;
	private String studentName;
	private String birthday;
	private String gender;
	private String phoneNumber;
	private String studentClass;
	private String country;
	private String nationality;
	private static Student student =null;
	public Student(String studentID, String studentName,String gender, String birthday , String phoneNumber,
			String studentClass, String country, String nationality) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.birthday = birthday;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.studentClass = studentClass;
		this.country = country;
		this.nationality = nationality;
	}
	public Student(){
	}
	public boolean checkAdd(Student st){
		Boolean isStudent = true;
		if(studentID.equals("") || studentName.equals("")|| birthday.equals("") || gender.equals("") || phoneNumber.equals("") ||
				studentClass.equals("") || country.equals("") || nationality.equals("")){
				isStudent =false;
		}
		return isStudent;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Student getInstance(){
		if(student ==null){
			new Student("", "", "", "", "", "", "", "");
		}
		return student;
	}
	
	
	
	
	

}
