package es.sergiomendez.obfcheadhuntingjava.dto;

import java.util.HashSet;
import java.util.Set;

public class StudentDto {

    private String fullname;
    private String country;
    private String city;
    private String phoneNumber;
    private String email;
    private Boolean remote;
    private Boolean mobility;
    private String photoUrl;
    private String resumeUrl;

    //    Relaciones
    private String username;
    private Set<String> tags = new HashSet<>();

    public StudentDto() {}

    public StudentDto(String fullname,
                      String country,
                      String city,
                      String phoneNumber,
                      String email,
                      Boolean remote,
                      Boolean mobility,
                      String photoUrl,
                      String resumeUrl,
                      String username,
                      Set<String> tags) {
        this.fullname = fullname;
        this.country = country;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.remote = remote;
        this.mobility = mobility;
        this.photoUrl = photoUrl;
        this.resumeUrl = resumeUrl;
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

    public Boolean getRemote() {
        return remote;
    }

    public void setRemote(Boolean remote) {
        this.remote = remote;
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

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
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
