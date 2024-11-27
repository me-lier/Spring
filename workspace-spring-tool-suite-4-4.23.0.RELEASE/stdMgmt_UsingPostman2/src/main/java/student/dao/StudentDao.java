package student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import student.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
}