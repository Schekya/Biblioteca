package model;

public final class LibroTerror extends Libro{
    int calification;

    public LibroTerror(){};


    public LibroTerror(String autor, int numeroPaginas, int isbn, int calification) {
        super(autor, numeroPaginas, isbn);
        this.calification = calification;
        this.genero = "Terror";
    }

    public int getCalification() {
        return calification;
    }

    public void setCalification(int calification) {
        this.calification = calification;
    }

    @Override
    public void  mostrarDatos() {
        System.out.println("➖➖➖➖➖➖➖➖➖➖");
        System.out.println("Género: " + genero +"\nISBN: " + isbn + "\nAutor: " + autor + "\nNúmero de páginas: " + numeroPaginas + "\nCalificación: " + calification);

    }

}
