package es.sergiomendez.obfcheadhuntingjava.controllers;

import es.sergiomendez.obfcheadhuntingjava.dto.StudentDto;
import es.sergiomendez.obfcheadhuntingjava.services.students.StudentServiceImpl;
import es.sergiomendez.obfcheadhuntingjava.services.tags.TagServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentServiceImpl studentService;
    private final TagServiceImpl tagService;

    private final Logger log = LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentServiceImpl studentService, TagServiceImpl tagService) {
        this.studentService = studentService;
        this.tagService = tagService;
    }

    @GetMapping("api/students")
    public List<StudentDto> findAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("api/students/{fullName}")
    public ResponseEntity<?> findStudent(@PathVariable String fullName) {
        return studentService.getStudentByFullName(fullName);
    }

    @PostMapping("api/students")
    public ResponseEntity<?> createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    @PutMapping("api/students")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studentDto);
    }

    @DeleteMapping("/api/students/{fullName}")
    public ResponseEntity<?> deleteStudent(@PathVariable String fullName) {
        return studentService.deleteStudentByFullName(fullName);
    }

    @DeleteMapping("/api/students/{username}")
    public ResponseEntity<?> deleteAllStudentsFromUser(@PathVariable String username) {
        return studentService.deleteAllStudentsFromUser(username);
    }

    @DeleteMapping("/api/students")
    public ResponseEntity<?> deleteAllStudents() {
        return studentService.deleteAllStudents();
    }
}
