package model;

import Exceptions.CatalogoCompletoException;

import java.io.Serializable;
import java.util.ArrayList;

public class Biblioteca {
    String nombre, director;


    public Biblioteca() {
    }

    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // -- Clase anidada Catálogo --

   public static class Catalogo<T extends Libro> implements Serializable {
        private ArrayList<T> catalogo;
        private int capacidad;
        private String nombreBiblioteca;

        public Catalogo(){}
       public Catalogo(String nombreBiblioteca){
           this.nombreBiblioteca = nombreBiblioteca;
       }
        public Catalogo(int capacidad, String nombreBiblioteca) {
            this.catalogo = new ArrayList<>();
            this.capacidad = capacidad;
            this.nombreBiblioteca = nombreBiblioteca;
        }

        // --Setter y Getter --

        public int getCapacidad() {
            return capacidad;
        }

        public void setCapacidad(int capacidad) {
            this.capacidad = capacidad;
        }

        public ArrayList<T> getCatalogo() {
            return catalogo;
        }

       public void setCatalogo(ArrayList<T> catalogo) {
           this.catalogo = new ArrayList<>();
       }

       public String getNombreBiblioteca() {
           return nombreBiblioteca;
       }

       public void setNombreBiblioteca(String nombreBiblioteca) {
           this.nombreBiblioteca = nombreBiblioteca;
       }

       // -- Métodos--

        public void crearCatalogo (int capacidad) {
            this.capacidad = capacidad;
            this.catalogo = new ArrayList<>();
            this.nombreBiblioteca = nombreBiblioteca;
        }

       public void addLibro(T libro) throws CatalogoCompletoException {
           for (T item : this.catalogo) {
               if (item.getIsbn() == libro.getIsbn()) {
                   System.out.println("El libro ya se encuentra en el catálogo. ❌");
                   return;
               }
           }
           if (this.catalogo.size() < this.capacidad) {
               this.catalogo.add(libro);
               System.out.println("El libro ha sido añadido al catálogo de la "  + Catalogo.this.nombreBiblioteca +". ✅");
           } else {
              throw new CatalogoCompletoException("El catálogo ha llegado al límite de su capacidad. El libro no se ha añadido.");
           }
       }

       public void eliminarLibro(int isbn) {
           Libro libroAEliminar = buscarLibro(isbn);
           if (libroAEliminar != null) {
               this.catalogo.remove(libroAEliminar);
               System.out.println("El libro ha sido eliminado de la biblioteca. ✅" );
           } else {
               System.out.println("No existe ningún libro con ese ISBN en ningún catálogo.");

           }
       }

       public T buscarLibro(int isbn) {
           for (T libro : this.catalogo) {
               if (libro.getIsbn() == isbn) {
                   System.out.println("¡Libro encontrado! El libro se encuentra en la " + Catalogo.this.nombreBiblioteca + ".");
                   libro.mostrarDatos();
                   System.out.println("➖➖➖➖➖➖➖➖➖➖");
                   return libro;
               }
           }

           return null; // Libro no encontrado.

       }

   }




    }

