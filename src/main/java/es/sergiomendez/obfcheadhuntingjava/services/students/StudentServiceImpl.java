package es.sergiomendez.obfcheadhuntingjava.services.students;

import es.sergiomendez.obfcheadhuntingjava.dto.MessageResponse;
import es.sergiomendez.obfcheadhuntingjava.dto.MessageStudentResponse;
import es.sergiomendez.obfcheadhuntingjava.dto.StudentDto;
import es.sergiomendez.obfcheadhuntingjava.entities.Student;
import es.sergiomendez.obfcheadhuntingjava.entities.Tag;
import es.sergiomendez.obfcheadhuntingjava.entities.User;
import es.sergiomendez.obfcheadhuntingjava.repositories.StudentRepository;
import es.sergiomendez.obfcheadhuntingjava.repositories.TagRepository;
import es.sergiomendez.obfcheadhuntingjava.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;

    public StudentServiceImpl(StudentRepository studentRepository, UserRepository userRepository, TagRepository tagRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();

        students.forEach(student -> {
            studentDtos.add(getDtoFromStudent(student));
        });

        return studentDtos;
    }

    @Override
    public ResponseEntity<?> getStudentByFullName(String fullName) {
        Optional<Student> studentOpt = studentRepository.findByFullname(fullName);

        if (studentOpt.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Student does not exist!"));
        }

        Student student = studentOpt.get();

        StudentDto dto = getDtoFromStudent(student);

        return ResponseEntity
                .ok(new MessageStudentResponse(
                        "Student retrieved: " + dto.getFullname(), dto));
    }

    @Override
    public ResponseEntity<?> createStudent(StudentDto studentDto) {

        Set<String> dtoTags = studentDto.getTags();

        String dtoUser = studentDto.getUsername();


        if (studentRepository.existsByFullname(studentDto.getFullname())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Student already exists!"));
        }

        Optional<User> userOpt = userRepository.findByUsername(dtoUser);
        if (userOpt.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: User is not registered!"));
        }

        User user = userOpt.get();
        Set<Tag> tags = new HashSet<>();

        dtoTags.forEach(dtoTag -> {
            if (!tagRepository.existsByName(dtoTag)) {
                Tag newTag = new Tag(dtoTag);
                tagRepository.save(newTag);
            }
            Tag tag = tagRepository.findByName(dtoTag);
            tags.add(tag);
        });

        Student student = getStudentFromDto(studentDto);
        student.setUser(user);
        student.setTags(tags);

        student = studentRepository.save(student);

        StudentDto dto = getDtoFromStudent(student);

        return ResponseEntity
                .ok(new MessageStudentResponse("Student successfully created: " + student.getFullname(), dto));

    }

    @Override
    public ResponseEntity<?> updateStudent(StudentDto studentDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteStudentByFullName(String fullName) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteAllStudentsFromUser(String username) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteAllStudents() {
        return null;
    }

    public Student getStudentFromDto(StudentDto dto) {
        Student student = new Student();

        student.setFullname(dto.getFullname());
        student.setCountry(dto.getCountry());
        student.setCity(dto.getCity());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setEmail(dto.getEmail());
        student.setModality(dto.getModality());
        student.setMove(dto.getMove());
        student.setPhotoUrl(dto.getPhotoUrl());
        student.setResumeUrl(dto.getResumeUrl());

        return student;
    }

    public StudentDto getDtoFromStudent(Student student) {
        StudentDto dto = new StudentDto();

        dto.setFullname(student.getFullname());
        dto.setCountry(student.getCountry());
        dto.setCity(student.getCity());
        dto.setPhoneNumber(student.getPhoneNumber());
        dto.setEmail(student.getEmail());
        dto.setModality(student.getModality());
        dto.setMove(student.getMove());
        dto.setPhotoUrl(student.getPhotoUrl());
        dto.setResumeUrl(student.getResumeUrl());
        dto.setUsername(student.getUser().getUsername());

        Set<String> dtoTags = new HashSet<>();
        student.getTags().forEach(tag -> dtoTags.add(tag.getName()));
        dto.setTags(dtoTags);

        return dto;
    }
}
