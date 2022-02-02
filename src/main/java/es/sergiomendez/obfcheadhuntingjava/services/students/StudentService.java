package es.sergiomendez.obfcheadhuntingjava.services.students;

import es.sergiomendez.obfcheadhuntingjava.dto.StudentDto;
import org.springframework.http.ResponseEntity;

public interface StudentService {

    ResponseEntity<?> getAllStudents(String city, Boolean remote, Boolean mobility, Integer page, Integer size, String[] tags);
    ResponseEntity<?> getStudentByFullName(String fullName);
    ResponseEntity<?> createStudent(StudentDto studentDto);
    ResponseEntity<?> updateStudent(StudentDto studentDto);
    ResponseEntity<?> deleteStudent(String fullName);
}
