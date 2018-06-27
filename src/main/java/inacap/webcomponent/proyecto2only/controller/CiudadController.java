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
import inacap.webcomponent.proyecto2only.model.CiudadModel;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.proyecto2only.repository.CiudadRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/ciudad")
public class CiudadController {
    
    @Autowired
    private CiudadRepository ciudadRepository;
    
    @GetMapping()
    public Iterable<CiudadModel> list() {
        return ciudadRepository.findAll();
    }
    
   @GetMapping("/{id}")
    public ResponseEntity<CiudadModel> get(@PathVariable String id) {
        Optional<CiudadModel> cOptional = ciudadRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            CiudadModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CiudadModel> put(@PathVariable String id, @RequestBody CiudadModel ciudadEditar) {
         Optional<CiudadModel> cOptional = ciudadRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            CiudadModel cEncontrado = cOptional.get();
            ciudadEditar.setIdCiudad(cEncontrado.getIdCiudad());
            ciudadRepository.save(ciudadEditar);
            return new ResponseEntity<>(ciudadEditar, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody CiudadModel nuevaCiudad) {
       
       nuevaCiudad = ciudadRepository.save(nuevaCiudad);
       Optional<CiudadModel> cOptional = ciudadRepository.findById(nuevaCiudad.getIdCiudad());
        if (cOptional.isPresent()){
            CiudadModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
       
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<CiudadModel> cOptional = ciudadRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            CiudadModel cEncontrado = cOptional.get();
            
            ciudadRepository.deleteById(cEncontrado.getIdCiudad());
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
}
