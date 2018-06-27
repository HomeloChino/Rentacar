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
import inacap.webcomponent.proyecto2only.model.TipoPersonaModel;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.proyecto2only.repository.TipoPersonaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/tipopersona")
public class TipoPersonaController {
    
    @Autowired
    private TipoPersonaRepository tipopersonaRepository;
    
    @GetMapping()
    public Iterable<TipoPersonaModel> list() {
        return tipopersonaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> get(@PathVariable String id) {
        Optional<TipoPersonaModel> cOptional = tipopersonaRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            TipoPersonaModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> put(@PathVariable String id, @RequestBody TipoPersonaModel tipopersonaEditar) {
         Optional<TipoPersonaModel> cOptional = tipopersonaRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            TipoPersonaModel cEncontrado = cOptional.get();
            tipopersonaEditar.setIdTipoPersona(cEncontrado.getIdTipoPersona());
            tipopersonaRepository.save(tipopersonaEditar);
            return new ResponseEntity<>(tipopersonaEditar, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoPersonaModel nuevoTipoPersona) {
       
       nuevoTipoPersona = tipopersonaRepository.save(nuevoTipoPersona);
       Optional<TipoPersonaModel> cOptional = tipopersonaRepository.findById(nuevoTipoPersona.getIdTipoPersona());
        if (cOptional.isPresent()){
            TipoPersonaModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
       
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<TipoPersonaModel> cOptional = tipopersonaRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            TipoPersonaModel cEncontrado = cOptional.get();
            
            tipopersonaRepository.deleteById(cEncontrado.getIdTipoPersona());
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
}
