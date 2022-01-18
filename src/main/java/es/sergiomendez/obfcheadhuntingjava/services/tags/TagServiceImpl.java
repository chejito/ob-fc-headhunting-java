package es.sergiomendez.obfcheadhuntingjava.services.tags;

import es.sergiomendez.obfcheadhuntingjava.dto.TagDto;
import es.sergiomendez.obfcheadhuntingjava.entities.Tag;
import es.sergiomendez.obfcheadhuntingjava.repositories.TagRepository;
import es.sergiomendez.obfcheadhuntingjava.dto.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

        Tag tag = tagDto.getTagFromDto();
        tag = repository.save(tag);


        return ResponseEntity.ok(new MessageResponse("Tag successfully created: " + tag.getName()));
    }

    @Override
    public List<Tag> getAllTags() {
        return repository.findAll();
    }


}
