package es.sergiomendez.obfcheadhuntingjava.controllers;

import es.sergiomendez.obfcheadhuntingjava.dto.StudentDto;
import es.sergiomendez.obfcheadhuntingjava.entities.Tag;
import es.sergiomendez.obfcheadhuntingjava.services.students.StudentServiceImpl;
import es.sergiomendez.obfcheadhuntingjava.services.tags.TagServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class StudentController {

    private final StudentServiceImpl studentService;
    private final TagServiceImpl tagService;

    private final Logger log = LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentServiceImpl studentService, TagServiceImpl tagService) {
        this.studentService = studentService;
        this.tagService = tagService;
    }

    /*@GetMapping("api/students")
    public ResponseEntity<?> findAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
        ) {

        return studentService.getAllStudents(page, size);
    }*/

    @GetMapping("api/students")
    public ResponseEntity<?> findAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Boolean remote,
            @RequestParam(required = false) Boolean mobility,
            @RequestParam(required = false) String[] tags
    ) {

        return studentService.getAllStudents(page, size, city, remote, mobility, tags);
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
        return studentService.deleteStudent(fullName);
    }

    @DeleteMapping("/api/students")
    public ResponseEntity<?> deleteAllStudents() {
        return studentService.deleteAllStudents();
    }
}
