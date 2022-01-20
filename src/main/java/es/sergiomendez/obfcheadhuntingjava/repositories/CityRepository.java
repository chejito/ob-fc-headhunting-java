package es.sergiomendez.obfcheadhuntingjava.repositories;

import es.sergiomendez.obfcheadhuntingjava.entities.City;
import es.sergiomendez.obfcheadhuntingjava.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByCountry(Country country);
}
