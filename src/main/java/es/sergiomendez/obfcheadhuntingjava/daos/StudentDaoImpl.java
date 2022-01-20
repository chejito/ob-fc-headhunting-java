package es.sergiomendez.obfcheadhuntingjava.daos;

import es.sergiomendez.obfcheadhuntingjava.dto.StudentDto;
import es.sergiomendez.obfcheadhuntingjava.entities.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentDaoImpl implements StudentDao {

    private Session session;

    @PersistenceContext
    private EntityManager entityManager;

    public StudentDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public List<Student> findAll(String city, Boolean remote, Boolean mobility) {
        String statement = "from Student ";
        if (city != null || remote != null || mobility != null) {
            statement += "where";
            String cityParam = city != null ? " city = :city " : "";
            String remoteParam = remote != null ? " remote = :remote " : "";
            String mobilityParam = mobility != null ? " mobility = :mobility " : "";

            String join1 = (city == null || remote == null) ? "" :"and";
            String join2 = (remote == null || mobility == null) ? "" : "and";

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

        return (List<Student>) query.list();
    }
}
