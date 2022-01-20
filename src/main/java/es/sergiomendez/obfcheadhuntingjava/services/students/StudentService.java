package es.sergiomendez.obfcheadhuntingjava.services.students;

import es.sergiomendez.obfcheadhuntingjava.dto.StudentDto;
import org.springframework.http.ResponseEntity;

public interface StudentService {

    ResponseEntity<?> getAllStudents(Integer page, Integer size, String city, Boolean remote, Boolean mobility, String[] tags);

//    ResponseEntity<?> getAllStudentsWithFilters(Integer page, Integer size, String city, Boolean remote, Boolean mobility, String[] tags);

    ResponseEntity<?> getStudentByFullName(String fullName);

    ResponseEntity<?> createStudent(StudentDto studentDto);

    ResponseEntity<?> updateStudent(StudentDto studentDto);

    ResponseEntity<?> deleteStudent(String fullName);

    ResponseEntity<?> deleteAllStudents();
}
