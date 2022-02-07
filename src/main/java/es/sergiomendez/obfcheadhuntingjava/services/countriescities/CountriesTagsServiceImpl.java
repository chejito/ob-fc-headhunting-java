package es.sergiomendez.obfcheadhuntingjava.services.countriescities;

import es.sergiomendez.obfcheadhuntingjava.dto.CountriesTagsResponseDto;
import es.sergiomendez.obfcheadhuntingjava.entities.City;
import es.sergiomendez.obfcheadhuntingjava.entities.Country;
import es.sergiomendez.obfcheadhuntingjava.repositories.CityRepository;
import es.sergiomendez.obfcheadhuntingjava.repositories.CountryRepository;
import es.sergiomendez.obfcheadhuntingjava.services.tags.TagServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CountriesTagsServiceImpl implements CountriesTagsService {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final TagServiceImpl tagServiceImpl;

    public CountriesTagsServiceImpl(CountryRepository countryRepository, CityRepository cityRepository, TagServiceImpl tagServiceImpl) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
        this.tagServiceImpl = tagServiceImpl;
    }

    @Override
    public CountriesTagsResponseDto getAllCountriesCities() {

        Map<String, List<String>> countriesCities = new HashMap<>();

        List <Country> countries = countryRepository.findAll();
        countries.forEach(country -> {
            List<String> cityNames = new ArrayList<>();
            List<City> cities = cityRepository.findAllByCountry(country);
            cities.forEach(city -> cityNames.add(city.getName()));
            countriesCities.put(country.getName(), cityNames);
        });

        List <String> tags = tagServiceImpl.getTagList();

        return new CountriesTagsResponseDto(countriesCities, tags);
    }
}
