package es.sergiomendez.obfcheadhuntingjava.services.students;

import es.sergiomendez.obfcheadhuntingjava.dto.StudentDto;
import es.sergiomendez.obfcheadhuntingjava.entities.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    ResponseEntity<?> getStudentByFullName(String fullName);

    ResponseEntity<?> createStudent(StudentDto studentDto);

    ResponseEntity<?> updateStudent(StudentDto studentDto);

    ResponseEntity<?> deleteStudentByFullName(String fullName);

    ResponseEntity<?> deleteAllStudentsFromUser(String username);

    ResponseEntity<?> deleteAllStudents();
}
