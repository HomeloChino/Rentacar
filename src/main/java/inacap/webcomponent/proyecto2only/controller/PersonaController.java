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
import inacap.webcomponent.proyecto2only.model.PersonaModel;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.proyecto2only.repository.PersonaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    @Autowired
    private PersonaRepository personaRepository;
    
   @GetMapping()
    public Iterable<PersonaModel> list() {
        return personaRepository.findAll();
    }
    
     @GetMapping("/{id}")
    public ResponseEntity<PersonaModel> get(@PathVariable String id) {
        Optional<PersonaModel> cOptional = personaRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            PersonaModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PersonaModel> put(@PathVariable String id, @RequestBody PersonaModel personaEditar) {
         Optional<PersonaModel> cOptional = personaRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            PersonaModel cEncontrado = cOptional.get();
            personaEditar.setIdPersona(cEncontrado.getIdPersona());
            personaRepository.save(personaEditar);
            return new ResponseEntity<>(personaEditar, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody PersonaModel nuevaPersona) {
       
       nuevaPersona = personaRepository.save(nuevaPersona);
       Optional<PersonaModel> cOptional = personaRepository.findById(nuevaPersona.getIdPersona());
        if (cOptional.isPresent()){
            PersonaModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
       
    }
    
     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<PersonaModel> cOptional = personaRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            PersonaModel cEncontrado = cOptional.get();
            
            personaRepository.deleteById(cEncontrado.getIdPersona());
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
}
