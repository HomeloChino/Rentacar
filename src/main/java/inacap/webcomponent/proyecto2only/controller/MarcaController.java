/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.proyecto2only.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import inacap.webcomponent.proyecto2only.model.MarcaModel;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.proyecto2only.repository.MarcaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/marca")
public class MarcaController {
    
    @Autowired
    private MarcaRepository marcaRepository;
    
    @GetMapping()
    public Iterable<MarcaModel> list() {
        return marcaRepository.findAll();
    }
    
     @GetMapping("/{id}")
    public ResponseEntity<MarcaModel> get(@PathVariable String id) {
        Optional<MarcaModel> cOptional = marcaRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            MarcaModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
   @PutMapping("/{id}")
    public ResponseEntity<MarcaModel> put(@PathVariable String id, @RequestBody MarcaModel marcaEditar) {
         Optional<MarcaModel> cOptional = marcaRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            MarcaModel cEncontrado = cOptional.get();
            marcaEditar.setIdMarca(cEncontrado.getIdMarca());
            marcaRepository.save(marcaEditar);
            return new ResponseEntity<>(marcaEditar, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
     @PostMapping
    public ResponseEntity<?> post(@RequestBody MarcaModel nuevaMarca) {
       
       nuevaMarca = marcaRepository.save(nuevaMarca);
       Optional<MarcaModel> cOptional = marcaRepository.findById(nuevaMarca.getIdMarca());
        if (cOptional.isPresent()){
            MarcaModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
       
    }
    
   @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<MarcaModel> cOptional = marcaRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            MarcaModel cEncontrado = cOptional.get();
            
            marcaRepository.deleteById(cEncontrado.getIdMarca());
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
}
