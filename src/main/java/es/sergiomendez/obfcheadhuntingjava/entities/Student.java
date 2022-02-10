package es.sergiomendez.obfcheadhuntingjava.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, name = "full_name")
    private String fullname;

    private String country;

    private String city;

    @Column(nullable = false, length = 50, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    private Boolean modality;

    private Boolean mobility;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "resumee_url")
    private String resumeeUrl;

//    Relaciones
    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(name = "students_tags",
            joinColumns = {
                @JoinColumn(name = "student_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "tag_id")})
    private Set<Tag> tags = new HashSet<>();


    public Student() {}

    public Student(String fullname, String country, String city, String phoneNumber, String email,
                   Boolean modality, Boolean mobility, String photoUrl, String resumeeUrl) {
        this.fullname = fullname;
        this.country = country;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.modality = modality;
        this.mobility = mobility;
        this.photoUrl = photoUrl;
        this.resumeeUrl = resumeeUrl;
    }

    public Student(Long id, String fullname, String country, String city, String phoneNumber, String email, Boolean modality, Boolean mobility, String photoUrl, String resumeeUrl) {
        this.id = id;
        this.fullname = fullname;
        this.country = country;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.modality = modality;
        this.mobility = mobility;
        this.photoUrl = photoUrl;
        this.resumeeUrl = resumeeUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", remote='" + modality + '\'' +
                ", mobility=" + mobility +
                ", photoUrl='" + photoUrl + '\'' +
                ", resumeUrl='" + resumeeUrl + '\'' +
                '}';
    }

}
