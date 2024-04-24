package Exceptions;

public class CatalogoCompletoException extends Exception{

    public CatalogoCompletoException() {
    }

    public CatalogoCompletoException (String mensaje) {
        super(mensaje);
    }
}
