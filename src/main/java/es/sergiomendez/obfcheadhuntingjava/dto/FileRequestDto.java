package es.sergiomendez.obfcheadhuntingjava.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * Clase DTO para modificar un usuario de la base de datos, añadiendo
 * dos direcciones url de dos imágenes alojadas en la nube.
 */
public class FileRequestDto {

    private MultipartFile file;

    public FileRequestDto() {}

    public FileRequestDto(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
