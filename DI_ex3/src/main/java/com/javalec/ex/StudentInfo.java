package com.javalec.ex;

public class StudentInfo {

	private Student student;

	public StudentInfo(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void getStudentInfo() {
		if(student != null) {
			System.out.println(student.toString());
			System.out.println("====================");
		}
	}
	
	@Override
	public String toString() {
		return "StudentInfo [student=" + student + "]";
	}
	
	
}
