package es.sergiomendez.obfcheadhuntingjava.controllers;

import es.sergiomendez.obfcheadhuntingjava.dto.TagDto;
import es.sergiomendez.obfcheadhuntingjava.entities.Tag;
import es.sergiomendez.obfcheadhuntingjava.services.tags.TagServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController {

    private final TagServiceImpl tagService;

    private final Logger log = LoggerFactory.getLogger(TagController.class);

    public TagController(TagServiceImpl tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/api/tags")
    public List<Tag> findAllTags() {
        return tagService.getAllTags();
    }

    @PostMapping("api/tags")
    public ResponseEntity<?> createTag(@RequestBody TagDto tagDto) {
        return tagService.createTag(tagDto);
    }

}
