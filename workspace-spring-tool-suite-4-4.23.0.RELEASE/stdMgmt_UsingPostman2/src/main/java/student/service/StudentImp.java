package student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.dao.StudentDao;
import student.entity.Student;

@Service
public class StudentImp implements StudentInterface {

	@Autowired
	StudentDao dao;

	@Override
	public void addStudent(Student std) {
		dao.save(std);
	}

	@Override
	public Student updateStudent(int rn) {
		// Implementation here
		Optional<Student> std = dao.findById(rn);
		Student ss = null;
		if (std.isPresent()) {
			ss = std.get();
			return ss;
		}
		return null;
	}

	@Override
	public List<Student> showAllStudent() {
		List<Student> lst = dao.findAll();

		return lst;

	}

	@Override
	public void deleteStudent(int rn) {
		Optional<Student> std = dao.findById(rn);
		Student ss = null;
		if(std.isPresent()) {
			ss= std.get();
			dao.delete(ss);
			return;
		} // Example implementation

	}

}
