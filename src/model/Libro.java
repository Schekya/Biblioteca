package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Libro implements Serializable {

    String autor, genero;
    int numeroPaginas, isbn;


   public Libro(){};

    public Libro(String autor, int numeroPaginas, int isbn) {
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.genero = "Ensayo";
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void mostrarDatos() {
        System.out.println("➖➖➖➖➖➖➖➖➖➖");
        System.out.println("Género: " + genero + "\nISBN: " + isbn + "\nAutor: " + autor + "\nNúmero de páginas: " + numeroPaginas);

    }
}


