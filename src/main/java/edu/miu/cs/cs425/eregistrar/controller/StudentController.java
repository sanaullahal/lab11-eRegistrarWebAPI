package edu.miu.cs.cs425.eregistrar.controller;

import edu.miu.cs.cs425.eregistrar.Service.StudentService;
import edu.miu.cs.cs425.eregistrar.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class StudentController {
     private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
      @GetMapping(value = {"/list","/eregistrar/list"})
    public ModelAndView listStudents(){
        var modelandview= new ModelAndView();
        var students= (List<Student>)studentService.findAll();
        modelandview.addObject("students",students);
        modelandview.setViewName("Secured/list");
        return modelandview;

    }
    @GetMapping(value = {"/eregistrar/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student",new Student(null,null," ",null,null
                ,0.0, null,null));
        return "Secured/new";
    }

    @PostMapping(value = {"/eregistrar/new"})
    public String registerNewStudent(@Valid @ModelAttribute("student") Student student,
                                     BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            System.out.println("am running");
            return "Secured/new";
        }
        studentService.addStudent(student);
//        model.addAttribute("student", studentService.findAll());
        return "redirect:/eregistrar/list";
    }
    @GetMapping(value = {"eregistrar/edit/{studentId}"})
    public String editStudent(@PathVariable Integer studentId, Model model) {
        var student = studentService.getStudentById(studentId);
        if(student != null) {
            model.addAttribute("student", student);
            return "Secured/edit";
        }
        return "redirect:/eregistrar/list";
    }

    @PostMapping(value = {"eregistrar/update"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                  BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "Secured/edit";
        }
        studentService.addStudent(student);
        return "redirect:/eregistrar/list";
    }

    @GetMapping(value = {"/eregistrar/delete/{studentId}"})
    public String deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/list";
    }

}
