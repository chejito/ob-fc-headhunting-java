package es.sergiomendez.obfcheadhuntingjava.exceptions;

/**
 * Excepción para el caso en que el archivo recibido esté vacío.
 */
public class EmptyImageException extends Exception {
    public EmptyImageException(String message) {
        super(message);
    }
}
