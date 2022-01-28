package es.sergiomendez.obfcheadhuntingjava.daos;

import es.sergiomendez.obfcheadhuntingjava.dto.StudentDto;
import es.sergiomendez.obfcheadhuntingjava.entities.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class StudentDaoImpl implements StudentDao {

    private Session session;

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
                                       Integer size) {
        String statement = "from Student ";
        if (city != null || remote != null || mobility != null) {
            statement += "where";

            String cityParam = city != null ? " city = :city " : "";
            String remoteParam = remote != null ? " remote = :remote " : "";
            String mobilityParam = mobility != null ? " mobility = :mobility " : "";

            String join1 = (city == null || remote == null) ? "" : "and";
            String join2 = (mobility == null || remote == null) ? "" : "and";

            statement = statement + cityParam + join1 + remoteParam + join2 + mobilityParam;
        }

        System.out.println(statement);

        Query query = session.createQuery(statement);

        if (city != null) {
            query.setParameter("city", city);
        }

        if (remote != null) {
            query.setParameter("remote", remote);
        }

        if (mobility != null) {
            query.setParameter("mobility", mobility);
        }

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
