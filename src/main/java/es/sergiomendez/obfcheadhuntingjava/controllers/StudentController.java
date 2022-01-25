package es.sergiomendez.obfcheadhuntingjava.controllers;

import es.sergiomendez.obfcheadhuntingjava.dto.StudentDto;
import es.sergiomendez.obfcheadhuntingjava.services.students.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentServiceImpl studentService;

    private final Logger log = LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("api/students")
    public ResponseEntity<?> findAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Boolean remote,
            @RequestParam(required = false) Boolean mobility
    ) {

        return studentService.getAllStudents(city, remote, mobility, page, size);
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


}
