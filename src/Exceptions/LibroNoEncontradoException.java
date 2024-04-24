package Exceptions;

public class LibroNoEncontradoException extends Exception{
    public LibroNoEncontradoException() {
    }

    public LibroNoEncontradoException(String message) {
        super(message);
    }

}
