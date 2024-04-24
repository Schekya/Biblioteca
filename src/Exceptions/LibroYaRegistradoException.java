package Exceptions;

public class LibroYaRegistradoException extends Exception {

    public LibroYaRegistradoException() {
    }

    public LibroYaRegistradoException(String mensaje){
        super(mensaje);
    }
}
