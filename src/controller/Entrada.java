package controller;

import Exceptions.CatalogoCompletoException;
import Exceptions.LibroNoEncontradoException;
import Exceptions.LibroYaRegistradoException;
import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

//Trabajo realizado por Noelia Cegarra Castillo - DAW 2023/2024


public class Entrada {

    public static void main(String[] args) {

        // -- Biblioteca y Catálogos --
        Biblioteca biblioteca = new Biblioteca("Biblioteca General", "Juan Marín");
        Biblioteca.Catalogo<Libro> catalogoGeneral = new Biblioteca.Catalogo<>("Biblioteca General");
        Biblioteca.Catalogo<LibroComedia> catalogoComedia = new Biblioteca.Catalogo<>("Biblioteca de Comedia");
        Biblioteca.Catalogo<LibroTerror> catalogoTerror = new Biblioteca.Catalogo<>("Biblioteca de Terror");
        Biblioteca.Catalogo<LibroPoliciaca> catalogoPoliciaca = new Biblioteca.Catalogo<>("Biblioteca Policiaca");


        // -- Creamos un depósito para guardar los libros que tenemos (aquellos que se registran, pero no tienen ninguna biblioteca asignada) --
        ArrayList<Libro> depositoLibros = new ArrayList<>();


        ArrayList<Biblioteca.Catalogo<?>> listaCatalogos = new ArrayList<>();
        listaCatalogos.add(catalogoGeneral);
        listaCatalogos.add(catalogoComedia);
        listaCatalogos.add(catalogoPoliciaca);
        listaCatalogos.add(catalogoTerror);

        // Creamos y añadimos unos libros estándar al depósito de libros para tener material previo con el que trabajar en el código y hacer pruebas de funcionamiento.
        Libro nuevoLibro;
        // Crear y añadir los libros al depositoLibros en el orden deseado
        depositoLibros.add(new Libro("Maria Ponce", 156, 1234));
        depositoLibros.add(new Libro("Sabrina Vallecas", 107, 7215));
        depositoLibros.add(new Libro("Sabrina Vallecas", 456, 9955));
        depositoLibros.add(new Libro("Javier Amapola", 392, 1003));
        depositoLibros.add(new Libro("Carlos Alba", 186, 1052));
        depositoLibros.add(new LibroComedia("Carla Garcia", 56, 8973, "Infantil"));
        depositoLibros.add(new LibroComedia("Nicolás Quimera", 201, 6273, "Irónico"));
        depositoLibros.add(new LibroComedia("Carla Garcia", 86, 1893, "Infantil"));
        depositoLibros.add(new LibroComedia("Nicolás Quimera", 299, 3005, "Satírico"));
        depositoLibros.add(new LibroTerror("Guillermo Martin", 244, 5234, 8));
        depositoLibros.add(new LibroTerror("Santiago Montecristo", 248, 3880, 6));
        depositoLibros.add(new LibroTerror("Andrés Destello", 178, 5001, 9));
        depositoLibros.add(new LibroTerror("Guillermo Martin", 204, 4125, 7));
        depositoLibros.add(new LibroPoliciaca("Arthur Doyle", 398, 5604, "Misterio", new ArrayList<>(Arrays.asList("Sherlock Holmes", "Antonieta", "Gustavo", "María Dolores"))));
        depositoLibros.add(new LibroPoliciaca("Francisco Rodriguez", 345, 3604, "Intriga", new ArrayList<>(Arrays.asList("Señor Alonso", "La Gallega", "Gúzman", "Carmen"))));
        depositoLibros.add(new LibroPoliciaca("Federico Solaz", 398, 5604, "Misterio", new ArrayList<>(Arrays.asList("Ana Carolina", "Luis", "Alfonso", "Don Manolo"))));
        depositoLibros.add(new LibroPoliciaca("Gabriel Tormenta", 508, 5024, "Intriga", new ArrayList<>(Arrays.asList("Julia", "Doctor Miguel", "Olivia", "Señora Liliana"))));

        // -- Variables para el switch --
        int option;
        int option2;
        Scanner input = new Scanner(System.in);


        System.out.println("📚 Bienvenido a la Biblioteca Virtual 📚");
      try {
          // -- Menu--
          do {

              System.out.println("〰🔹 Menú 🔹〰");
              System.out.println("1. Registrar un libro.");
              System.out.println("2. Consultar una biblioteca.");
              System.out.println("3. Crear un catálogo.");
              System.out.println("4. Buscar un libro.");
              System.out.println("5. Eliminar un libro.");
              System.out.println("6. Consultar depósito de libros.");
              System.out.println("7. Exportar libros");
              System.out.println("8. Salir.");
              System.out.print("➖> ");
              option = input.nextInt();
              int isbn;

              switch (option) {

                  case 1:

                      System.out.println(" 〰🔹 Registrar un libro 🔹〰 ");
                      System.out.println("1. Ensayo.");
                      System.out.println("2. Policiaca.");
                      System.out.println("3. Comedia.");
                      System.out.println("4. Terror.");
                      System.out.println("5. Volver al menú.");
                      System.out.print("➖> ");
                      option2 = input.nextInt();

                      switch (option2) {

                          case 1:
                              try {
                                  depositoLibros.add(nuevoLibro = registrarLibro("Ensayo", listaCatalogos, depositoLibros));
                                  if (nuevoLibro != null) {

                                      addToBibliotecaEnsayo(catalogoGeneral, nuevoLibro);
                                  }
                              } catch (LibroYaRegistradoException ignored) {
                              }
                              break;

                          case 2:
                              try {
                                  depositoLibros.add(nuevoLibro = registrarLibro("Policiaca", listaCatalogos, depositoLibros));
                                  if (nuevoLibro != null) {
                                      addToBiblioteca(catalogoPoliciaca, catalogoGeneral, nuevoLibro);
                                  }
                              } catch (LibroYaRegistradoException ignored) {
                              }
                              break;

                          case 3:
                              try {
                                  depositoLibros.add(nuevoLibro = registrarLibro("Comedia", listaCatalogos, depositoLibros));
                                  if (nuevoLibro != null) {
                                      addToBiblioteca(catalogoComedia, catalogoGeneral, nuevoLibro);
                                  }
                              } catch (LibroYaRegistradoException ignored) {
                              }
                              break;

                          case 4:
                              try {
                                  depositoLibros.add(nuevoLibro = registrarLibro("Terror", listaCatalogos, depositoLibros));
                                  if (nuevoLibro != null) {
                                      addToBiblioteca(catalogoTerror, catalogoGeneral, nuevoLibro);
                                  }
                              } catch (LibroYaRegistradoException ignored) {
                              }
                              break;
                          default:
                              break;
                      }
                      break;

                  case 2:
                      System.out.println("〰🔹 Consultando bibliotecas 🔹〰");
                      bibliotecas();
                      System.out.println("5. Volver al menú.");
                      System.out.print("➖> ");
                      option2 = input.nextInt();
                      switch (option2) {
                          case 1:
                              mostrarBiblioteca(catalogoGeneral);
                              break;
                          case 2:
                              mostrarBiblioteca(catalogoPoliciaca);
                              break;
                          case 3:
                              mostrarBiblioteca(catalogoComedia);
                              break;
                          case 4:
                              mostrarBiblioteca(catalogoTerror);
                              break;
                          default:
                              break;
                      }
                      break;

                  case 3:
                      System.out.println("〰🔹 Crear un Catálogo 🔹〰");
                      System.out.println("Escoja el número de la biblioteca en la que desea crear un catálogo:");
                      bibliotecas();
                      System.out.println("5. Volver al menú.");
                      System.out.print("➖> ");
                      option2 = input.nextInt();
                      switch (option2) {
                          case 1:
                              crearCatalogo(catalogoGeneral);
                              break;
                          case 2:
                              crearCatalogo(catalogoPoliciaca);
                              break;
                          case 3:
                              crearCatalogo(catalogoComedia);
                              break;
                          case 4:
                              crearCatalogo(catalogoTerror);
                              break;

                      }
                      break;
                  case 4:
                      System.out.println("〰🔹 Buscar un libro 🔹〰");
                      System.out.println("Introduzca el ISBN del libro que desea buscar:");
                      isbn = input.nextInt();
                      buscarLibro(isbn, listaCatalogos, depositoLibros);
                      break;
                  case 5:
                      System.out.println("〰🔹 Eliminar un libro 🔹〰");
                      System.out.println("Introduzca el ISBN del libro que desea eliminar:");
                      isbn = input.nextInt();
                      try {
                          eliminarLibro(isbn, listaCatalogos, depositoLibros);
                      } catch (LibroNoEncontradoException ignored) {
                      }
                      break;
                  case 6:
                      System.out.println("〰🔹 Consultando el depósito de libros | Número de libros: " + depositoLibros.size() + "🔹〰");
                      for (Libro item : depositoLibros) {
                          item.mostrarDatos();
                      }
                      break;
                  case 7:
                      System.out.println("〰🔹 Exportar libros 🔹〰");
                      File f = new File("libros");
                      try {
                          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                          for (Biblioteca.Catalogo<?> catalogo : listaCatalogos) {
                              oos.writeObject(catalogo);

                          }
                          oos.close();
                          System.out.println("¡Libros exportados! Ruta del archivo:" + f.getAbsolutePath());
                      } catch (IOException e) {
                          e.printStackTrace();
                      }

                      break;
              }
          } while (option != 8);

          System.out.println("Cerrando el programa. ¡Hasta pronto!");
          input.close();
      } catch (InputMismatchException e) {
          System.out.println("El dato introducido no es válido.");
      }
    }

        // -- Métodos --
        public static Libro registrarLibro (String tipo, ArrayList < Biblioteca.Catalogo < ?>>
        listaCatalogos, ArrayList < Libro > depositoLibros) throws LibroYaRegistradoException {
            Scanner input = new Scanner(System.in);
            System.out.println("〰🔹 Introduzca los datos del libro 🔹〰");
            System.out.print("ISBN: ");
            int isbn = input.nextInt();

            Libro libroDuplicado = buscarEnDeposito(depositoLibros, isbn);
            if (libroDuplicado != null) {

                for (Biblioteca.Catalogo<?> catalogo : listaCatalogos) {
                    try {
                        Libro libroEnCatalogo = catalogo.buscarLibro(isbn);
                        if (libroEnCatalogo == null) {
                            System.out.println("⛔ Libro duplicado. ⛔");
                            return libroDuplicado;
                        } else {
                            throw new LibroYaRegistradoException();
                        }
                    } catch (java.lang.NullPointerException ignored) {
                    }
                }
                if (libroDuplicado != null) {
                    System.out.println("⛔ Libro duplicado en el depósito de libros. ⛔");
                    libroDuplicado.mostrarDatos();
                    return libroDuplicado;

                }

            } else {

                input.nextLine(); // Atrapa el salto entre el anterior input y el siguiente
                System.out.print("Autor: ");
                String autor = input.nextLine();
                System.out.print("Número de páginas: ");
                int numeroPaginas = input.nextInt();


                switch (tipo) {
                    case "Terror":
                        System.out.print("Calificación: ");
                        int calification = input.nextInt();
                        return new LibroTerror(autor, numeroPaginas, isbn, calification);

                    case "Comedia":
                        System.out.print("Tipo de humor: ");
                        String tipoHumor = input.next();
                        return new LibroComedia(autor, numeroPaginas, isbn, tipoHumor);

                    case "Policiaca":
                        System.out.print("Trama (Intriga/Misterio): ");
                        String trama = input.next();
                        if (!(trama.equalsIgnoreCase("Intriga") || trama.equalsIgnoreCase("Misterio"))) {
                            do {
                                System.out.println("La trama debe ser de tipo intriga o misterio:");
                                trama = input.next();
                            } while (!(trama.equalsIgnoreCase("Intriga") || trama.equalsIgnoreCase("Misterio")));
                        }
                        System.out.println("Ingrese los nombres de los personajes principales. Separe cada nombre pulsando \"Enter\". Escriba \"fin\" para terminar.");
                        ArrayList<String> personajes = new ArrayList<>();
                        String nombrePersonaje;
                        while (true) {
                            nombrePersonaje = input.nextLine();
                            if (nombrePersonaje.equalsIgnoreCase("fin")) {
                                break;
                            }
                            personajes.add(nombrePersonaje);
                        }
                        personajes.removeIf(String::isEmpty);
                        return new LibroPoliciaca(autor, numeroPaginas, isbn, trama, personajes);


                    default:
                        return new Libro(autor, numeroPaginas, isbn);
                }
            }

            return null;
        }


        public static <T extends Libro > void mostrarBiblioteca (Biblioteca.Catalogo < T > catalogo) {
            if (catalogo.getCatalogo() == null) {
                System.out.println("Esta biblioteca no cuenta con un catálogo aun.");

            } else if ((catalogo.getCatalogo().isEmpty())) {
                System.out.println("El catálogo de esta categoría se encuentra vacío.");

            } else {
                System.out.println("〰🔹 Mostrando el catálogo de la " + catalogo.getNombreBiblioteca() + " | Número de Libros: " + catalogo.getCatalogo().size() + "/" + catalogo.getCapacidad() + " 🔹〰");
                for (Libro libro : catalogo.getCatalogo()) {
                    libro.mostrarDatos();

                }
                System.out.println("➖➖➖➖➖➖➖➖➖➖");
            }
        }

        // -- Método para registrar libros de tipo Ensayo --
        public static void addToBibliotecaEnsayo (Biblioteca.Catalogo < Libro > catalogo, Libro nuevoLibro){
            Scanner input = new Scanner(System.in);
            System.out.println("➖➖➖➖➖➖➖➖➖➖");
            System.out.println("El libro ha sido registrado en el depósito de libros. ¿Desea añadir el libro a la " + catalogo.getNombreBiblioteca() + "? [SI/NO]:");
            String opcion = input.next();
            try {
                if (opcion.equalsIgnoreCase("SI") && catalogo.getCatalogo() != null) {
                    catalogo.addLibro(nuevoLibro);
                } else if (opcion.equalsIgnoreCase("SI") && catalogo.getCatalogo() == null) {
                    System.out.println("No se ha encontrado un catálogo en la " + catalogo.getNombreBiblioteca() + ". ¿Desea crear uno ahora? [SI/NO]:");
                    opcion = input.next();
                    if (opcion.equalsIgnoreCase("SI")) {
                        crearCatalogo(catalogo);
                        catalogo.addLibro(nuevoLibro);
                    } else if (opcion.equalsIgnoreCase("NO")) {
                        System.out.println("El catálogo no ha sido creado. El libro no se ha añadido a la biblioteca.");
                    } else {
                        System.out.println("Opción no válida. No se ha creado ningún catálogo y el libro no se ha añadido a la biblioteca.");
                    }
                } else if (opcion.equalsIgnoreCase("NO")) {
                    System.out.println("El libro no se ha añadido a la biblioteca.");
                } else {
                    System.out.println("Opción no válida. El libro no se ha añadido a la biblioteca.");
                }

            } catch (CatalogoCompletoException e) {
                System.out.println("⛔ El catálogo está completo. El libro no se ha añadido al catálogo. ⛔");
            }

        }

        // -- Método para registrar todos los libros que no sean de tipo Ensayo (ofrece la posibilidad de guardar el libro en una biblioteca específica o general)--
        public static <T extends Libro > void addToBiblioteca
        (Biblioteca.Catalogo < T > catalogo, Biblioteca.Catalogo < Libro > catalogoGeneral, Libro nuevoLibro){
            try {
                if (nuevoLibro != null) {
                    Scanner input = new Scanner(System.in);
                    System.out.println("El libro ha sido registrado en el depósito de libros. ¿Desea añadir el libro a la biblioteca? [SI/NO]:");
                    String opcion = input.next();

                    if (opcion.equalsIgnoreCase("SI")) {

                        System.out.println("¿Deseas añadir el libro a la " + catalogo.getNombreBiblioteca() + "? [SI/NO]: (en caso contrario, se añadirá a la " + catalogoGeneral.getNombreBiblioteca() + ").");
                        opcion = input.next();

                        if (opcion.equalsIgnoreCase("SI") && catalogo.getCatalogo() != null) {

                            catalogo.addLibro((T) nuevoLibro);
                        } else if (opcion.equalsIgnoreCase("SI") && catalogo.getCatalogo() == null) {
                            System.out.println("No se ha encontrado un catálogo en la " + catalogo.getNombreBiblioteca() + ". ¿Desea crear uno ahora? [SI/NO]:");
                            opcion = input.next();
                            if (opcion.equalsIgnoreCase("SI")) {

                                crearCatalogo(catalogo);
                                catalogo.addLibro((T) nuevoLibro);

                            } else if (opcion.equalsIgnoreCase("NO")) {
                                System.out.println("El catálogo no ha sido creado. El libro no se ha añadido a ninguna biblioteca.");
                                return;
                            } else {
                                System.out.println("Opción no válida. El libro no se ha añadido a ninguna biblioteca.");
                            }

                        }
                        // -- Añade el libro a la biblioteca general --
                        if (opcion.equalsIgnoreCase("NO") && catalogoGeneral.getCatalogo() != null) {

                            catalogoGeneral.addLibro(nuevoLibro);

                        } else if (opcion.equalsIgnoreCase("NO") && catalogoGeneral.getCatalogo() == null) {
                            System.out.println("No se ha encontrado un catálogo en la " + catalogoGeneral.getNombreBiblioteca() + ". ¿Desea crear uno ahora? [SI/NO]:");
                            opcion = input.next();
                            if (opcion.equalsIgnoreCase("SI")) {

                                crearCatalogo(catalogoGeneral);
                                catalogoGeneral.addLibro(nuevoLibro);

                            } else {
                                System.out.println("El libro no se ha añadido a ninguna biblioteca.");
                            }
                        }
                    } else {
                        System.out.println("El libro no se ha añadido a ninguna biblioteca.");
                    }

                }
            } catch (CatalogoCompletoException e) {
                System.out.println("⛔ El catálogo está completo. El libro no se ha añadido al catálogo. ⛔");
            }

        }


        public static void bibliotecas () {
            System.out.println("1. Biblioteca General");
            System.out.println("2. Biblioteca Policiaca");
            System.out.println("3. Biblioteca de Comedia");
            System.out.println("4. Biblioteca de Terror");
        }

        public static <T extends Libro > void crearCatalogo (Biblioteca.Catalogo < T > catalogo) {
            Scanner input = new Scanner(System.in);
            if (catalogo.getCatalogo() == null) {
                System.out.println("Indique la capacidad deseada para el catálogo:");

                int capacidad = input.nextInt();
                if (capacidad < 1) {
                    System.out.println("El tamaño mínimo del catálogo es de 1.");
                    return;
                }
                catalogo.crearCatalogo(capacidad);
                System.out.println("El catálogo ha sido creado. ✅");
            } else {
                System.out.println("Ya existe un catálogo para esta categoría.");
            }

        }

        public static boolean buscarLibro ( int isbn, ArrayList<Biblioteca.Catalogo<?>>
        listaCatalogos, ArrayList < Libro > depositoLibros){

            for (Biblioteca.Catalogo<?> catalogo : listaCatalogos) {
                try {
                    Libro libroEncontrado = catalogo.buscarLibro(isbn);
                    if (libroEncontrado != null) {
                        return true; // Detiene el método si encuentra el libro en algún catálogo, ya que en ese caso sabemos que sí o sí está en el depósito y no es necesario buscarlo.
                    }
                } catch (
                        java.lang.NullPointerException ignore) {
                } // Atrapa la excepción Runtime que ocurre al intentar ejecutar el método sobre un catálogo que no existe aún.
            }
            Libro libroEnDeposito = buscarEnDeposito(depositoLibros, isbn);
            if (libroEnDeposito != null) {
                System.out.println("¡Libro encontrado! El libro se encuentra en el depósito de libros.");
                libroEnDeposito.mostrarDatos();
                System.out.println("➖➖➖➖➖➖➖➖➖➖");

                return true;
            }
            System.out.println("El libro no ha sido encontrado.");
            return false;
        }

        public static void eliminarLibro ( int isbn, ArrayList<Biblioteca.Catalogo<?>>
        listaCatalogos, ArrayList < Libro > depositoLibros) throws LibroNoEncontradoException {
            Scanner input = new Scanner(System.in);
            boolean encontrado = false;
            for (Biblioteca.Catalogo<?> catalogo : listaCatalogos) {
                try {
                    catalogo.eliminarLibro(isbn);
                    encontrado = true;
                } catch (
                        java.lang.NullPointerException ignore) {
                }
                Libro libroEnDeposito = buscarEnDeposito(depositoLibros, isbn);


                if (libroEnDeposito != null) {
                    if (!encontrado) {
                        libroEnDeposito.mostrarDatos();
                    }

                    System.out.println("El libro se encuentra en el depósito. ¿Quieres eliminarlo de forma permanente? [SI/NO]: ");
                    String option = input.next();
                    if (option.equalsIgnoreCase("SI")) {
                        depositoLibros.remove(libroEnDeposito);
                        System.out.println("El libro ha sido eliminado del depósito de libros. ✅");
                    } else if (option.equalsIgnoreCase("NO")) {
                        System.out.println("El libro no ha sido eliminado del depósito de libros.");
                    } else {
                        System.out.println("La opción no es válida. El libro no ha sido eliminado.");
                    }
                }
                if (!encontrado && libroEnDeposito == null) {
                    throw new LibroNoEncontradoException();
                }

            }

        }

        public static Libro buscarEnDeposito (ArrayList < Libro > depositoLibros,int isbn){
            for (Libro item : depositoLibros) { // Si el libro no está dentro de ningún catálogo, puede ser que sus datos estén registrados en el depósito de libros.
                if (item.getIsbn() == isbn) {
                    return item;
                }
            }
            return null;
        }
    }























