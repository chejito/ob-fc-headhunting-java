package es.sergiomendez.obfcheadhuntingjava.dto;

import es.sergiomendez.obfcheadhuntingjava.entities.Tag;

public class TagDto {
    private String name;

    public TagDto() {
    }

    public TagDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tag getTagFromDto() {
        Tag tag = new Tag();
        tag.setName(name);

        return tag;
    }
}
