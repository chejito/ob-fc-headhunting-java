package es.sergiomendez.obfcheadhuntingjava.repositories;

import es.sergiomendez.obfcheadhuntingjava.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    boolean existsByFullname(String fullname);
    Optional<Student> findByFullname(String fullname);
}
