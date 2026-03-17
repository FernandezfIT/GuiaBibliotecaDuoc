package cl.FernandezF.bibliotecaDuoc.controller;

import cl.FernandezF.bibliotecaDuoc.model.Libro;
import cl.FernandezF.bibliotecaDuoc.services.LibroService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros(){
        return libroService.getLibros();
    }

    @PostMapping("path")
    public Libro agregarLibro(@RequestBody Libro libro){
        return libroService.guardaLibro(libro);
    }

    
    
    
    
}
