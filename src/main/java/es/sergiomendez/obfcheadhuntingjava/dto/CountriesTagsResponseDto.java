package es.sergiomendez.obfcheadhuntingjava.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountriesTagsResponseDto {

    private Map<String, List<String>> countries = new HashMap<>();
    private List<String> tags = new ArrayList<>();

    public CountriesTagsResponseDto() {}

    public CountriesTagsResponseDto(Map<String, List<String>> countries, List<String> tags) {
        this.countries = countries;
        this.tags = tags;
    }

    public Map<String, List<String>> getCountries() {
        return countries;
    }

    public void setCountries(Map<String, List<String>> countries) {
        this.countries = countries;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
