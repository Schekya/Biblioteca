package model;

import java.util.ArrayList;
import java.util.Objects;

public class LibroPoliciaca extends Libro{
    String trama;
    ArrayList<String> personajes = new ArrayList<>();

    public LibroPoliciaca() {
    }

    public LibroPoliciaca(String autor, int numeroPaginas, int isbn, String trama, ArrayList<String> personajes) {
        super(autor, numeroPaginas, isbn);
        this.trama = trama;
        this.personajes = personajes;
        this.genero = "Policiaca";
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public ArrayList<String> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<String> personajes) {
        this.personajes = personajes;
    }


    @Override
    public void  mostrarDatos() {
        System.out.println("➖➖➖➖➖➖➖➖➖➖");
        System.out.println("Género: " + genero + "\nISBN: " + isbn + "\nAutor: " + autor + "\nNúmero de páginas: " + numeroPaginas + "\nTrama: " + trama + "\nPersonajes: " + personajes);


    }
}
