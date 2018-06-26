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
import inacap.webcomponent.proyecto2only.model.TransmisionModel;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.proyecto2only.repository.TransmisionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/transmision")
public class TransmisionController {
    
    @Autowired
    private TransmisionRepository transmisionRepository;
    
    @GetMapping()
    public Iterable<TransmisionModel> list() {
        return transmisionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TransmisionModel> get(@PathVariable String id) {
        Optional<TransmisionModel> cOptional = transmisionRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            TransmisionModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TransmisionModel> put(@PathVariable String id, @RequestBody TransmisionModel transmisionEditar) {
         Optional<TransmisionModel> cOptional = transmisionRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            TransmisionModel cEncontrado = cOptional.get();
            transmisionEditar.setIdTransmision(cEncontrado.getIdTransmision());
            transmisionRepository.save(transmisionEditar);
            return new ResponseEntity<>(transmisionEditar, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
   @PostMapping
    public ResponseEntity<?> post(@RequestBody TransmisionModel nuevaTransmision) {
       
       nuevaTransmision = transmisionRepository.save(nuevaTransmision);
       Optional<TransmisionModel> cOptional = transmisionRepository.findById(nuevaTransmision.getIdTransmision());
        if (cOptional.isPresent()){
            TransmisionModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
       
    }
    
   @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<TransmisionModel> cOptional = transmisionRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            TransmisionModel cEncontrado = cOptional.get();
            
            transmisionRepository.deleteById(cEncontrado.getIdTransmision());
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
}
