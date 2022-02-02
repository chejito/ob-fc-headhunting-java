package es.sergiomendez.obfcheadhuntingjava.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountriesCitiesResponseDto {

    private Map<String, List<String>> countryCities = new HashMap<>();

    public CountriesCitiesResponseDto() {}

    public CountriesCitiesResponseDto(Map<String, List<String>> countryCities) {
        this.countryCities = countryCities;
    }

    public Map<String, List<String>> getCountryCities() {
        return countryCities;
    }

    public void setCountryCities(Map<String, List<String>> countryCities) {
        this.countryCities = countryCities;
    }
}
