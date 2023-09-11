package lk.icet.lehan.controller;

import lk.icet.lehan.dto.StudentDto;
import lk.icet.lehan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public void saveStudent(@RequestBody StudentDto student) {
        System.out.println("Request Came");
        studentService.saveStudent(student);
        System.out.println("Request Done");
    }

    @GetMapping
    public StudentDto getStudent(@RequestParam Long id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/{name}")
    public List<StudentDto> getByName(@PathVariable String name) {
        return studentService.findByFirstName(name);
    }
}

