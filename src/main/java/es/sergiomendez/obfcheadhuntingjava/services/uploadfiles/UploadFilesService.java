package es.sergiomendez.obfcheadhuntingjava.services.uploadfiles;

import es.sergiomendez.obfcheadhuntingjava.dto.FileRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * Interfaz que define el método para subir una imagen
 * a un servicio de alojamiento en la nube
 */
public interface UploadFilesService {
    ResponseEntity<?> uploadFile(MultipartFile file) throws Exception;
    ResponseEntity<?> uploadPhoto(FileRequestDto dto);
    ResponseEntity<?> uploadResumee(FileRequestDto dto);
}
