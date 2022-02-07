package es.sergiomendez.obfcheadhuntingjava.services.tags;

import es.sergiomendez.obfcheadhuntingjava.dto.TagDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface TagService {
    ResponseEntity<?> createTag(TagDto tagDto);
    Map<String, List<String>> getAllTags();
}
