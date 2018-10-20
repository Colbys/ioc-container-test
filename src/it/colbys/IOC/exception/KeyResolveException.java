package it.colbys.IOC.exception;

public class KeyResolveException extends Exception {

    public KeyResolveException(String message) {
        super(message);
    }

    public KeyResolveException(String message, Throwable cause) {
        super(message, cause);
    }
}
