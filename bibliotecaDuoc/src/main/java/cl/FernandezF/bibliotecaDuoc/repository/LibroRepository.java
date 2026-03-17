package cl.FernandezF.bibliotecaDuoc.repository;

import cl.FernandezF.bibliotecaDuoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {

    // Arreglo que guardara todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

    // Metodo que retorna todos los libros

    public List<Libro> obteneLibros() {

        return listaLibros;
    }

    // Buscar libro por su ID
    public Libro buscarPorId(int id) {

        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {

                return libro;
            }
        }
        return null;
    }

    // Buscar libro por su isbn
    public Libro buscarPorIsbn(int id) {

        for (Libro libro : listaLibros) {
            if (libro.getIsbn() == id) {

                return libro;
            }
        }
        return null;
    }

    // Guardar Libro
    public Libro guardar(Libro lib){
        listaLibros.add(lib);
        return lib;
    }

    // Actualizar información de libro
    public Libro actualizar(Libro lib){

        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++) {
            if(listaLibros.get(i).getId() == lib.getId()){
                id = lib.getId();
                idPosicion = i;
            }
        }
        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion,libro1);
        return libro1;
    }

    // Elimina libro mediante su id
    public void eliminar(int id){
        // Alternativa 1
        Libro libro = buscarPorId(id);
        if (libro != null){
            listaLibros.remove(libro);
        }

        // Alternativa 2
        int idPosition = 0;
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == i) {
                idPosition = i;
                break;
            }
        }
        if (idPosition > 0) {
            listaLibros.remove(idPosition);
        }

        // Alternativa 3
        listaLibros.removeIf(x -> x.getId() == id);

    }

}
