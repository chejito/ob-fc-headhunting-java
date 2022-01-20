package es.sergiomendez.obfcheadhuntingjava.controllers;

import es.sergiomendez.obfcheadhuntingjava.dto.CountriesCitiesResponseDto;
import es.sergiomendez.obfcheadhuntingjava.services.countriescities.CountriesCitiesServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountriesCitiesController {

    private final CountriesCitiesServiceImpl service;

    public CountriesCitiesController(CountriesCitiesServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/api/countriescities")
    public CountriesCitiesResponseDto getAllCountriesCities() {
        return service.getAllCountriesCities();
    }
}
