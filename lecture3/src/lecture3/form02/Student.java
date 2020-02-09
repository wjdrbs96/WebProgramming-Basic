package lecture3.form02;

public class Student {
	String id;
	String studentNumber;
	String name;
	int departmentId;
	int year;
	
	public Student(String id, String studentNumber, String name, int departmentId, int year) {
		this.id = id;
		this.studentNumber = studentNumber;
		this.name = name;
		this.departmentId = departmentId;
		this.year = year;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartmentID(int departmentId) {
		this.departmentId = departmentId;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
