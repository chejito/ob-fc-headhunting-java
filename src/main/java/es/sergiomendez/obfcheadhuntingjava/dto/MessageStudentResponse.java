package es.sergiomendez.obfcheadhuntingjava.dto;

public class MessageStudentResponse {

    private String message;
    private StudentDto student;

    public MessageStudentResponse(String message, StudentDto student) {
        this.message = message;
        this.student = student;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }
}
