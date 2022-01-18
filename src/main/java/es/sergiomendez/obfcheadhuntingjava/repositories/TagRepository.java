package es.sergiomendez.obfcheadhuntingjava.repositories;

import es.sergiomendez.obfcheadhuntingjava.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    boolean existsByName(String name);
    Tag findByName(String name);
}
