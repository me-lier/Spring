src/main/resources/templates/employee_form.html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Employee Form</title>
</head>
<body>
<h1>Employee Form</h1>
<form th:action="@{/employees}" th:object="${employee}" method="post">
<input type="hidden" th:field="*{id}" />
<label>Name: </label>
<input type="text" th:field="*{name}" />
<br />
<label>Role: </label>
<input type="text" th:field="*{role}" />
<br />
<button type="submit">Save</button>
</form>
<a th:href="@{/employees}">Back to List</a>
</body></html>
src/main/resources/templates/employees.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Employee List</title>
</head>
<body>
<h1>Employee List</h1>
<a th:href="@{/employees/new}">Add New Employee</a>
<table border="1">
<thead>
<tr>
<th>ID</th>
<th>Name</th>
<th>Role</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<tr th:each="employee : ${employees}">
<td th:text="${employee.id}">ID</td>
<td th:text="${employee.name}">Name</td>
<td th:text="${employee.role}">Role</td>
<td>
<a th:href="@{/employees/edit/{id}(id=${employee.id})}">Edit</a>
<a th:href="@{/employees/delete/{id}(id=${employee.id})}">Delete</a>
</td>
</tr>
</tbody>
</table>
</body>
</html>
Webapp.java
package com.example.webapp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
// Main Spring Boot application class
@SpringBootApplication
public class Application {
public static void main(String[] args) {
SpringApplication.run(Application.class, args);
}
@Bean
public CommandLineRunner dataInitializer(EmployeeRepository employeeRepository) {
return args -> {
employeeRepository.save(new Employee("John Doe", "Developer"));
employeeRepository.save(new Employee("Jane Smith", "Manager"));
employeeRepository.save(new Employee("Samuel Green", "Analyst"));
System.out.println("Data has been initialized");
};
}
}
//Entity class
@Entity
class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String role;
public Employee() {}
public Employee(String name, String role) {
this.name = name;
this.role = role;
}
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getName() { return name; }
public void setName(String name) { this.name = name; }
public String getRole() { return role; }
public void setRole(String role) { this.role = role; }
}
//Repository interface
interface EmployeeRepository extends JpaRepository<Employee, Long> {}
//Service class
@Service
class EmployeeService {
@Autowired
private EmployeeRepository employeeRepository;
public List<Employee> getAllEmployees() {
return employeeRepository.findAll();
}
public void saveEmployee(Employee employee) {
employeeRepository.save(employee);
}
public Optional<Employee> getEmployeeById(Long id) {
return employeeRepository.findById(id);
}
public void deleteEmployeeById(Long id) {
employeeRepository.deleteById(id);
}
}
// Controller class
@Controller
class EmployeeController {
@Autowired
private EmployeeService employeeService;
@GetMapping("/employees")
public String viewEmployees(Model model) {
model.addAttribute("employees", employeeService.getAllEmployees());
return "employees";
}
@GetMapping("/employees/new")
public String showNewEmployeeForm(Model model) {
model.addAttribute("employee", new Employee());
return "employee_form";
}
@PostMapping("/employees")
public String saveEmployee(@ModelAttribute("employee") Employee employee) {
employeeService.saveEmployee(employee);
return "redirect:/employees";
}
@GetMapping("/employees/edit/{id}")
public String showEditForm(@PathVariable Long id, Model model) {
model.addAttribute("employee", employeeService.getEmployeeById(id).orElse(null));
return "employee_form";
}
@GetMapping("/employees/delete/{id}")
public String deleteEmployee(@PathVariable Long id) {
employeeService.deleteEmployeeById(id);
return "redirect:/employees";
}
}