package student.service;

import java.util.List;

import student.entity.Student;

public interface StudentInterface {

	public void addStudent(Student std);

	public Student updateStudent(int rn);

	public List<Student> showAllStudent();

	public void deleteStudent(int rn);
	
}
