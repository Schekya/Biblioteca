package model;

public final class LibroComedia extends Libro{
    String tipoHumor;

    public LibroComedia(){};

    public LibroComedia(String autor, int numeroPaginas, int isbn, String tipoHumor) {
        super(autor, numeroPaginas, isbn);
        this.tipoHumor = tipoHumor;
        this.genero = "Comedia";
    }

    public String getTipoHumor() {
        return tipoHumor;
    }

    public void setTipoHumor(String tipoHumor) {
        this.tipoHumor = tipoHumor;
    }


    @Override
    public void  mostrarDatos() {
        System.out.println("➖➖➖➖➖➖➖➖➖➖");
        System.out.println("Género: " + genero + "\nISBN: " + isbn + "\nAutor: " + autor + "\nNúmero de páginas: " + numeroPaginas + "\nTipo de humor: " + tipoHumor);

    }
    }

