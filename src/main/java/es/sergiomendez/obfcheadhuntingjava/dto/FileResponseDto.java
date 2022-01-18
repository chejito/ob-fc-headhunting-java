package es.sergiomendez.obfcheadhuntingjava.dto;

/**
 * Clase DTO para el devolver la dirección url del archivo en la respuesta, junto con un mensaje de texto.
 */
public class FileResponseDto {

    private String message;
    private String title;
    private String urlFile;

    public FileResponseDto() {}

    public FileResponseDto(String message, String title, String urlFile) {
        this.message = message;
        this.title = title;
        this.urlFile = urlFile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

}
