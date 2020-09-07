package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.StudentGroup;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class StudentController {

    private final StudentService studentService;
    private List<Student> students =null;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> list (){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/students/groups")
    public ResponseEntity<List<StudentGroup>> group(){
        return ResponseEntity.ok(studentService.divide());
    }
}
