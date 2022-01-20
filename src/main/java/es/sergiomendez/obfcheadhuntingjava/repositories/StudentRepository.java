package es.sergiomendez.obfcheadhuntingjava.repositories;

import es.sergiomendez.obfcheadhuntingjava.entities.Student;
import es.sergiomendez.obfcheadhuntingjava.entities.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    boolean existsByFullname(String fullname);
    boolean existsByEmail(String email);
    Optional<Student> findByFullname(String fullname);
    Optional<Student> findByEmail(String email);
    Page<Student> findAll(Pageable pageable);
//    Page<Student> findAll(String city, Boolean remote, Boolean mobility, Tag[] tags, Pageable pageable);
}
