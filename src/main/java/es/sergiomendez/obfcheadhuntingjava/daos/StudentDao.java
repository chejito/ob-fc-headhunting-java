package es.sergiomendez.obfcheadhuntingjava.daos;

import es.sergiomendez.obfcheadhuntingjava.entities.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll(String city, Boolean remote, Boolean mobility);


}
