package es.sergiomendez.obfcheadhuntingjava.controllers;

import es.sergiomendez.obfcheadhuntingjava.dto.FileRequestDto;
import es.sergiomendez.obfcheadhuntingjava.services.uploadfiles.UploadFilesCloudinaryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fileupload")
public class FileController {

    private final UploadFilesCloudinaryServiceImpl service;

    public FileController(UploadFilesCloudinaryServiceImpl service) {
        this.service = service;
    }

    /**
     * Método que añade un fichero de imagen a un usuario y devuelve su dirección URL.
     *
     * @param dto DTO que incluye el fichero de imagen.
     * @return Respuesta del userService.
     */
    @RequestMapping(value = "/photo", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<?> uploadPhoto(FileRequestDto dto){
        System.out.println(dto.getFile().getOriginalFilename());

        return service.uploadPhoto(dto);
    }

    @RequestMapping(value = "/resumee", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<?> uploadResumee(FileRequestDto dto){
        System.out.println(dto.getFile().getOriginalFilename());

        return service.uploadResumee(dto);
    }

}
