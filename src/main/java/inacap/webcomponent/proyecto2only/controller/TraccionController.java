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
import inacap.webcomponent.proyecto2only.model.TraccionModel;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.proyecto2only.repository.TraccionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/traccion")
public class TraccionController {
    
    @Autowired
    private TraccionRepository traccionRepository;
    
   @GetMapping()
    public Iterable<TraccionModel> list() {
        return traccionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TraccionModel> get(@PathVariable String id) {
        Optional<TraccionModel> cOptional = traccionRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            TraccionModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TraccionModel> put(@PathVariable String id, @RequestBody TraccionModel traccionEditar) {
         Optional<TraccionModel> cOptional = traccionRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            TraccionModel cEncontrado = cOptional.get();
            traccionEditar.setIdTraccion(cEncontrado.getIdTraccion());
            traccionRepository.save(traccionEditar);
            return new ResponseEntity<>(traccionEditar, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
   @PostMapping
    public ResponseEntity<?> post(@RequestBody TraccionModel nuevaTraccion) {
       
       nuevaTraccion = traccionRepository.save(nuevaTraccion);
       Optional<TraccionModel> cOptional = traccionRepository.findById(nuevaTraccion.getIdTraccion());
        if (cOptional.isPresent()){
            TraccionModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
       
    }
    
     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<TraccionModel> cOptional = traccionRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            TraccionModel cEncontrado = cOptional.get();
            
            traccionRepository.deleteById(cEncontrado.getIdTraccion());
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
}
