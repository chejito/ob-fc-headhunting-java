package es.sergiomendez.obfcheadhuntingjava.services.countriescities;

import es.sergiomendez.obfcheadhuntingjava.dto.CountriesCitiesResponseDto;
import es.sergiomendez.obfcheadhuntingjava.entities.City;
import es.sergiomendez.obfcheadhuntingjava.entities.Country;
import es.sergiomendez.obfcheadhuntingjava.repositories.CityRepository;
import es.sergiomendez.obfcheadhuntingjava.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CountriesCitiesServiceImpl implements CountriesCitiesService {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    public CountriesCitiesServiceImpl(CountryRepository countryRepository, CityRepository cityRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public CountriesCitiesResponseDto getAllCountriesCities() {

        Map<String, List<String>> countriesCities = new HashMap<>();

        List <Country> countries = countryRepository.findAll();
        countries.forEach(country -> {
            List<String> cityNames = new ArrayList<>();
            List<City> cities = cityRepository.findAllByCountry(country);
            cities.forEach(city -> cityNames.add(city.getName()));
            countriesCities.put(country.getName(), cityNames);
        });

        return new CountriesCitiesResponseDto(countriesCities);
    }
}
