package es.sergiomendez.obfcheadhuntingjava.services.tags;

import es.sergiomendez.obfcheadhuntingjava.dto.TagDto;
import es.sergiomendez.obfcheadhuntingjava.entities.Tag;
import es.sergiomendez.obfcheadhuntingjava.repositories.TagRepository;
import es.sergiomendez.obfcheadhuntingjava.dto.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository repository;

    public TagServiceImpl(TagRepository repository) {
        this.repository = repository;
    }


    @Override
    public ResponseEntity<?> createTag(TagDto tagDto) {
        if (repository.existsByName(tagDto.getName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Tag already exists!"));
        }

        Tag tag = new Tag(tagDto.getName());
        tag = repository.save(tag);


        return ResponseEntity.ok(new MessageResponse("Tag successfully created: " + tag.getName()));
    }

    @Override
    public Map<String, List<String>> getAllTags() {
        List<Tag> tags = repository.findAll();
        List<String> tagList = new ArrayList<>();
        tags.forEach(x -> tagList.add(x.getName()));
        Map<String, List<String>> tagMap = new HashMap<>();
        tagMap.put("tags", tagList);

        return tagMap;
     }

    @Override
    public List<String> getTagList() {
        List<Tag> tags = repository.findAll();
        List<String> tagList = new ArrayList<>();
        tags.forEach(x -> tagList.add(x.getName()));

        return tagList;
    }


}
