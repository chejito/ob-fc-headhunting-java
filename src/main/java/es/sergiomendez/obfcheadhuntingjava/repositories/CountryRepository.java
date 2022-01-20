package es.sergiomendez.obfcheadhuntingjava.repositories;

import es.sergiomendez.obfcheadhuntingjava.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
