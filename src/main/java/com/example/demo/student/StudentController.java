package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {


private final StudentService StudentService;



    @Autowired
    public StudentController(StudentService studentService) {
        this.StudentService =  studentService;

    }

    @GetMapping
    public List<Student> getStudents() {

return StudentService.getStudents();

    }
@PostMapping
    public void RegisterNewStudent(@RequestBody Student  student) {
        StudentService.addNewStudent(student);
    }

@DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable ("studentId")Long StudentId) {
       StudentService.deleteStudent(StudentId);
}


@PutMapping(path = "{studentId}")
public void updateStudent(
        @PathVariable("studentId")Long studentId,
        @RequestParam(required = false)String name,
        @RequestParam(required = false)String email){
        StudentService.updateStudent(studentId , name , email );


}




}


