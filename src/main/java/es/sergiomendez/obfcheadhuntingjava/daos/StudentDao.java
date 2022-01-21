package es.sergiomendez.obfcheadhuntingjava.daos;

import java.util.Map;

public interface StudentDao {
    Map<String, Object> findAll(String city,
                                Boolean remote,
                                Boolean mobility,
                                Integer page,
                                Integer size);
}
