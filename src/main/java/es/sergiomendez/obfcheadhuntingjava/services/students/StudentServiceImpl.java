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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentDaoImpl studentDao;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentDaoImpl studentDao, UserRepository userRepository, TagRepository tagRepository) {
        this.studentRepository = studentRepository;
        this.studentDao = studentDao;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public ResponseEntity<?> getAllStudents(Integer page, Integer size, String city, Boolean remote, Boolean mobility, String[] tags) {
        try {
            List<StudentDto> studentDtos = new ArrayList<>();
            /*Pageable paging = PageRequest.of(page, size);

            Page<Student> pageStudents = studentRepository
                    .findAll(paging);

            List<Student> students = pageStudents.getContent();
*/          List<Student> students = studentDao.findAll(city, remote, mobility);
            students.forEach(student -> {
                studentDtos.add(getDtoFromStudent(student));
            });

            Map<String, Object> response = new HashMap<>();
            response.put("students", studentDtos);
            /*response.put("currentPage", pageStudents.getNumber());
            response.put("totalItems", pageStudents.getTotalElements());
            response.put("totalPages", pageStudents.getTotalPages());*/

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: "+ e.getMessage()));
        }

    }

    /*@Override
    public ResponseEntity<?> getAllStudentsWithFilters(Integer page, Integer size, String city, Boolean remote, Boolean mobility, String[] tags) {
        System.out.println("Page: " + page + " size: "+ size + " city: " +  city + " remote: " + remote + " mobility: " + mobility + " tags: " + Arrays.toString(tags));
        try {
            List<StudentDto> studentDtos = new ArrayList<>();
            List<Tag> tagList = new ArrayList<>();
            Arrays.stream(tags).forEach(tag -> {
                Tag newTag = tagRepository.findByName(tag);
                tagList.add(newTag);
            });

            Tag[] tagArray = new Tag[tagList.size()];
            tagArray = tagList.toArray(tagArray);

            Pageable paging = PageRequest.of(page, size);

            Page<Student> pageStudents = studentRepository.findByCityAndModalityAndMoveAndTags(city, remote, mobility, tagArray, paging);

            List<Student> students = pageStudents.getContent();

            students.forEach(student -> {
                studentDtos.add(getDtoFromStudent(student));
            });

            Map<String, Object> response = new HashMap<>();
            response.put("students", studentDtos);
            response.put("currentPage", pageStudents.getNumber());
            response.put("totalItems", pageStudents.getTotalElements());
            response.put("totalPages", pageStudents.getTotalPages());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: "+ e.getMessage()));
        }
    }*/

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
    public ResponseEntity<?> deleteStudent(String fullName) {
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
        student.setRemote(dto.getRemote());
        student.setMobility(dto.getMobility());
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
        dto.setRemote(student.getRemote());
        dto.setMobility(student.getMobility());
        dto.setPhotoUrl(student.getPhotoUrl());
        dto.setResumeUrl(student.getResumeUrl());
        dto.setUsername(student.getUser().getUsername());

        Set<String> dtoTags = new HashSet<>();
        student.getTags().forEach(tag -> dtoTags.add(tag.getName()));
        dto.setTags(dtoTags);

        return dto;
    }
}
