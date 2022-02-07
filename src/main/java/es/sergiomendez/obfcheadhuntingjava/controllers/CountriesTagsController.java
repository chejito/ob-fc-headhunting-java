package es.sergiomendez.obfcheadhuntingjava.controllers;

import es.sergiomendez.obfcheadhuntingjava.dto.CountriesTagsResponseDto;
import es.sergiomendez.obfcheadhuntingjava.services.countriescities.CountriesTagsServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountriesTagsController {

    private final CountriesTagsServiceImpl service;

    public CountriesTagsController(CountriesTagsServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/api/countriestags")
    public CountriesTagsResponseDto getAllCountriesCities() {
        return service.getAllCountriesCities();
    }
}
