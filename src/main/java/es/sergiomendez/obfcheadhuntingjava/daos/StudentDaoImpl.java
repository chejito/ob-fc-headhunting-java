package es.sergiomendez.obfcheadhuntingjava.daos;

import es.sergiomendez.obfcheadhuntingjava.dto.StudentDto;
import es.sergiomendez.obfcheadhuntingjava.entities.Student;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final Session session;

    @PersistenceContext
    private EntityManager entityManager;

    public StudentDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public Map<String, Object> findAll(String city,
                                           Boolean remote,
                                           Boolean mobility,
                                           Integer page,
                                           Integer size,
                                           String[] tags) {

        // ** Modelo de query nativa SQL **
        // SELECT * FROM students WHERE
        // city = 'Valencia'
        // AND remote = true
        // AND mobility = false
        // AND id IN (SELECT student_id FROM students_tags WHERE tag_id = (SELECT id FROM tags WHERE name='javascript'))
        // AND id IN (SELECT student_id FROM students_tags WHERE tag_id = (SELECT id FROM tags WHERE name='python'));

        StringBuilder statement = new StringBuilder("SELECT * FROM students");

        if (city != null || remote != null || mobility != null || tags != null) {
            statement.append(" WHERE");
        }

        if (city != null) {
            statement
                    .append(" city = '")
                    .append(city)
                    .append("'");
        }

        if (city != null && remote != null) {
            statement
                    .append(" AND");
        }

        if (remote != null) {
            statement
                    .append(" remote = '")
                    .append(remote)
                    .append("'");
        }

        if ((city != null || remote != null) && mobility != null) {
            statement
                    .append(" AND");
        }

        if (mobility != null) {
            statement
                    .append(" mobility = '")
                    .append(mobility)
                    .append("'");
        }
        if (tags != null) {
            for (int i = 0; i < tags.length; i++) {
                if (i == 0 && city == null && remote == null && mobility == null) {
                    statement
                            .append(" id IN (SELECT student_id FROM students_tags WHERE tag_id = (SELECT id FROM tags WHERE name='")
                            .append(tags[i])
                            .append("'))");
                } else {
                    statement
                            .append(" AND id IN (SELECT student_id FROM students_tags WHERE tag_id = (SELECT id FROM tags WHERE name='")
                            .append(tags[i])
                            .append("'))");
                }
            }
        }

        NativeQuery<Student> query = session.createNativeQuery(statement.toString(), Student.class);

        Long totalResults = (long) query.list().size();
        int lastPageNumber = (int) Math.ceil(totalResults / size);

        query.setFirstResult(Math.max((page -1) * size, 0));
        query.setMaxResults(size);

        List<Student> students =  query.list();

        Map<String, Object> response = new HashMap<>();
        List<StudentDto> studentDtos = new ArrayList<>();
        students.forEach(student -> studentDtos.add(getDtoFromStudent(student)));

        response.put("students", studentDtos);
        response.put("currentPage", page);
        response.put("studentsPerPage", size);
        response.put("totalItems", totalResults);
        response.put("totalPages", lastPageNumber + 1);

        return response;
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
