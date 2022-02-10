package es.sergiomendez.obfcheadhuntingjava.services.students;

import es.sergiomendez.obfcheadhuntingjava.daos.StudentDaoImpl;
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

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentDaoImpl studentDao;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;

    public StudentServiceImpl(StudentRepository studentRepository,
                              StudentDaoImpl studentDao,
                              UserRepository userRepository,
                              TagRepository tagRepository) {
        this.studentRepository = studentRepository;
        this.studentDao = studentDao;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public ResponseEntity<?> getAllStudents(String city, Boolean remote, Boolean mobility, Integer page, Integer size, String[] tags) {
        try {
            Map<String, Object> response = studentDao.findAll(city, remote, mobility, page, size, tags);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: "+ e.getMessage()));
        }

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
        Set<String> dtoTags = studentDto.getTags();

        String dtoUser = studentDto.getUsername();

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

        Optional<Student> studentOpt = studentRepository.findByFullname(studentDto.getFullname());
        if (studentOpt.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Student is not registered!"));
        }

        Student student = studentOpt.get();

        student.setFullname(studentDto.getFullname());
        student.setEmail(studentDto.getEmail());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setCity(studentDto.getCity());
        student.setCountry(studentDto.getCountry());
        student.setMobility(studentDto.getMobility());
        student.setModality(studentDto.getModality());
        student.setResumeeUrl(studentDto.getResumeeUrl());
        student.setPhotoUrl(studentDto.getPhotoUrl());
        student.setUser(user);
        student.setTags(tags);

        student = studentRepository.save(student);

        StudentDto dto = getDtoFromStudent(student);

        return ResponseEntity
                .ok(new MessageStudentResponse("Student successfully updated: " + student.getFullname(), dto));
    }

    @Override
    public ResponseEntity<?> deleteStudent(String fullName) {

        Optional<Student> studentOpt = studentRepository.findByFullname(fullName);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            studentRepository.delete(student);
            return ResponseEntity
                    .ok("Student successfully deleted: '" + student.getFullname() + "'");
        }

        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Error: Student does not exist!"));
    }

    public Student getStudentFromDto(StudentDto dto) {
        Student student = new Student();

        student.setFullname(dto.getFullname());
        student.setCountry(dto.getCountry());
        student.setCity(dto.getCity());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setEmail(dto.getEmail());
        student.setModality(dto.getModality());
        student.setMobility(dto.getMobility());
        student.setPhotoUrl(dto.getPhotoUrl());
        student.setResumeeUrl(dto.getResumeeUrl());

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
        dto.setMobility(student.getMobility());
        dto.setPhotoUrl(student.getPhotoUrl());
        dto.setResumeeUrl(student.getResumeeUrl());
        dto.setUsername(student.getUser().getUsername());

        Set<String> dtoTags = new HashSet<>();
        student.getTags().forEach(tag -> dtoTags.add(tag.getName()));
        dto.setTags(dtoTags);

        return dto;
    }
}
