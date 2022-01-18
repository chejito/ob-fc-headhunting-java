package es.sergiomendez.obfcheadhuntingjava.services.tags;

import es.sergiomendez.obfcheadhuntingjava.dto.TagDto;
import es.sergiomendez.obfcheadhuntingjava.entities.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TagService {
    ResponseEntity<?> createTag(TagDto tagDto);
    List<Tag> getAllTags();
}
