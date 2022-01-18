package es.sergiomendez.obfcheadhuntingjava.services.uploadfiles;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import es.sergiomendez.obfcheadhuntingjava.dto.FileResponseDto;
import es.sergiomendez.obfcheadhuntingjava.dto.MessageResponse;
import es.sergiomendez.obfcheadhuntingjava.dto.FileRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * Clase que implementa la subida de un archivo al
 * servicio de alojamiento en la nube Cloudinary
 */
@Service
public class UploadFilesCloudinaryServiceImpl implements UploadFilesService {

    private final String cloudName = System.getenv("CLOUDINARY_CLOUD_NAME");
    private final String apiKey = System.getenv("CLOUDINARY_API_KEY");
    private final String apiSecret = System.getenv("CLOUDINARY_API_SECRET");
    private final Map params = ObjectUtils.asMap(
            "cloud_name", cloudName,
            "api_key", apiKey,
            "api_secret", apiSecret
    );

    Logger log = LoggerFactory.getLogger(UploadFilesCloudinaryServiceImpl.class);


    Cloudinary cloudinary = new Cloudinary(params);

    /**
     * Método que efectúa la subida del archivo
     *
     * @param file Imagen que se recibe
     * @return String con la url de la imagen alojada
     */
    @Override
    public ResponseEntity<?> uploadFile(MultipartFile file) {
        String message;
        if (file.isEmpty()) {
            message = "Error: El archivo está vacío";
            log.error(message);
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(message));
        }

        try {
            Map response = cloudinary.uploader().upload((file.getBytes()),
                    ObjectUtils.emptyMap());
            String title = file.getOriginalFilename();
            String url = response.get("secure_url").toString();

            return ResponseEntity
                    .ok(new FileResponseDto("Archivo subido correctamente!", title, url));
        } catch (IOException e) {
            message = "Error: no se ha podido subir el archivo";
            log.error(message);
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(message));
        }

    }

    @Override
    public ResponseEntity<?> uploadPhoto(FileRequestDto dto) {
        MultipartFile photo = dto.getFile();
        String message;

        if (photo.getSize() > 2097152) {
            message = "Error: El tamaño del archivo es demasiado grande. Tamaño máximo admitido: 2Mb (2097152 bytes)";
            log.error(message);
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(message));
        }

        if (!Objects.requireNonNull(photo.getContentType()).equalsIgnoreCase("image/png") &&
                !photo.getContentType().equalsIgnoreCase("image/jpeg")) {
            message = "Error: El formato del archivo es incorrecto. Formatos admitidos '.png', '.jpg'  y '.jpeg'";
            log.error(message);
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(message));
        }

        return uploadFile(photo);
    }

    @Override
    public ResponseEntity<?> uploadResumee(FileRequestDto dto) {
        MultipartFile resumee = dto.getFile();
        log.warn(String.valueOf(resumee.getSize()));
        String message;

        if (resumee.getSize() > 20971520) {
            message = "Error: El tamaño del archivo es demasiado grande. Tamaño máximo admitido: 20Mb (20971520 bytes)";
            log.error(message);
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(message));
        }
        if (!Objects.requireNonNull(resumee.getContentType()).equalsIgnoreCase("application/pdf")) {
            message = "Error: El formato del archivo es incorrecto. Formato admitido '.pdf'";
            log.error(message);
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(message));
        }

        return uploadFile(resumee);
    }
}
