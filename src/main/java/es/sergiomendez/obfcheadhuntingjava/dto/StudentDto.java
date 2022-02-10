package es.sergiomendez.obfcheadhuntingjava.dto;

import java.util.HashSet;
import java.util.Set;

public class StudentDto {

    private String fullname;
    private String country;
    private String city;
    private String phoneNumber;
    private String email;
    private Boolean modality;
    private Boolean mobility;
    private String photoUrl;
    private String resumeeUrl;

    //    Relaciones
    private String username;
    private Set<String> tags = new HashSet<>();

    public StudentDto() {}

    public StudentDto(String fullname,
                      String country,
                      String city,
                      String phoneNumber,
                      String email,
                      Boolean modality,
                      Boolean mobility,
                      String photoUrl,
                      String resumeeUrl,
                      String username,
                      Set<String> tags) {
        this.fullname = fullname;
        this.country = country;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.modality = modality;
        this.mobility = mobility;
        this.photoUrl = photoUrl;
        this.resumeeUrl = resumeeUrl;
        this.username = username;
        this.tags = tags;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getModality() {
        return modality;
    }

    public void setModality(Boolean modality) {
        this.modality = modality;
    }

    public Boolean getMobility() {
        return mobility;
    }

    public void setMobility(Boolean mobility) {
        this.mobility = mobility;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getResumeeUrl() {
        return resumeeUrl;
    }

    public void setResumeeUrl(String resumeeUrl) {
        this.resumeeUrl = resumeeUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

}
