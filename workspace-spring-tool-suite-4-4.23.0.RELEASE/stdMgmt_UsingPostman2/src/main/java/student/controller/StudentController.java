package student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import student.entity.Student;
import student.service.StudentInterface;

@RestController
public class StudentController {
	
	@Autowired
	StudentInterface si;

	@GetMapping("/ssf") // ssf :- show student form
	public String addStudent(Model md) {
		Student std = new Student();
		md.addAttribute("std", std);
		return "createNewStudent";
	}

	@ResponseBody
	@PostMapping("/savestudent")
	public String savestudent(@RequestBody Student std) {
		si.addStudent(std);
		return "Student Successfully added.....";
	}
	
	@ResponseBody
	@GetMapping("/showall")
	public List<Student> showAllStudent() {
		
		List<Student> allstd = si.showAllStudent();
//		md.addAttribute("allstd", allstd);
		return allstd;
	}
	
	@DeleteMapping("/delete")
	public String deleteStudent(@RequestBody Student std) {
		si.deleteStudent(std.getRollno());
		return "Student Deleted Susscessfully.....";
	}
	
	@PutMapping("/edit")
	public String editStudent(@RequestBody Student std) {
		si.addStudent(std);
		return "Student Data Updated...";
	}
	
}