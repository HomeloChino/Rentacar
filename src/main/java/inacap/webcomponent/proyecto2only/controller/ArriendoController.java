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
import inacap.webcomponent.proyecto2only.model.ArriendoModel;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.proyecto2only.repository.ArriendoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/arriendo")
public class ArriendoController {
    
    @Autowired
    private ArriendoRepository arriendoRepository;
    
    @GetMapping()
    public Iterable<ArriendoModel> list() {
        return arriendoRepository.findAll();
    }
    
     @GetMapping("/{id}")
    public ResponseEntity<ArriendoModel> get(@PathVariable String id) {
        Optional<ArriendoModel> cOptional = arriendoRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            ArriendoModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
   @PutMapping("/{id}")
    public ResponseEntity<ArriendoModel> put(@PathVariable String id, @RequestBody ArriendoModel arriendoEditar) {
         Optional<ArriendoModel> cOptional = arriendoRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            ArriendoModel cEncontrado = cOptional.get();
            arriendoEditar.setIdArriendo(cEncontrado.getIdArriendo());
            arriendoRepository.save(arriendoEditar);
            return new ResponseEntity<>(arriendoEditar, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
   @PostMapping
    public ResponseEntity<?> post(@RequestBody ArriendoModel nuevoArriendo) {
       
       nuevoArriendo = arriendoRepository.save(nuevoArriendo);
       Optional<ArriendoModel> cOptional = arriendoRepository.findById(nuevoArriendo.getIdArriendo());
        if (cOptional.isPresent()){
            ArriendoModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
       
    }
    
   @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<ArriendoModel> cOptional = arriendoRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            ArriendoModel cEncontrado = cOptional.get();
            
            arriendoRepository.deleteById(cEncontrado.getIdArriendo());
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
}
