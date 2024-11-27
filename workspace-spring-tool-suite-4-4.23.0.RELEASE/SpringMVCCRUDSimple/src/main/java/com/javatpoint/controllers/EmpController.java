package com.javatpoint.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.javatpoint.beans.Emp;
import com.javatpoint.dao.EmpDao;

@Controller
public class EmpController {

    @Autowired
    EmpDao dao; // Injecting DAO

    @RequestMapping("/empform")
    public String showForm(Model m) {
        m.addAttribute("command", new Emp());
        return "empform";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("emp") Emp emp) {
        dao.save(emp);
        return "redirect:/viewemp";
    }

    @RequestMapping("/viewemp")
    public String viewEmp(Model m) {
        List<Emp> list = dao.getEmployees();
        m.addAttribute("list", list);
        return "viewemp";
    }

    @RequestMapping(value = "/editemp/{id}")
    public String edit(@PathVariable int id, Model m) {
        Emp emp = dao.getEmpById(id);
        m.addAttribute("command", emp);
        return "empeditform";
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String editSave(@ModelAttribute("emp") Emp emp) {
        dao.update(emp);
        return "redirect:/viewemp";
    }

    @RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/viewemp";
    }
}