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
import inacap.webcomponent.proyecto2only.model.MedioPagoModel;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.proyecto2only.repository.MedioPagoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/pago")
public class MedioPagoController {
    
   @Autowired
    private MedioPagoRepository mediopagoRepository;
   
   @GetMapping()
    public Iterable<MedioPagoModel> list() {
        return mediopagoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MedioPagoModel> get(@PathVariable String id) {
        Optional<MedioPagoModel> cOptional = mediopagoRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            MedioPagoModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
     @PutMapping("/{id}")
    public ResponseEntity<MedioPagoModel> put(@PathVariable String id, @RequestBody MedioPagoModel mediopagoEditar) {
         Optional<MedioPagoModel> cOptional = mediopagoRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            MedioPagoModel cEncontrado = cOptional.get();
            mediopagoEditar.setIdMedioPago(cEncontrado.getIdMedioPago());
            mediopagoRepository.save(mediopagoEditar);
            return new ResponseEntity<>(mediopagoEditar, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
     @PostMapping
    public ResponseEntity<?> post(@RequestBody MedioPagoModel nuevoMedioPago) {
       
       nuevoMedioPago = mediopagoRepository.save(nuevoMedioPago);
       Optional<MedioPagoModel> cOptional = mediopagoRepository.findById(nuevoMedioPago.getIdMedioPago());
        if (cOptional.isPresent()){
            MedioPagoModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
       
    }
    
   @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<MedioPagoModel> cOptional = mediopagoRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            MedioPagoModel cEncontrado = cOptional.get();
            
            mediopagoRepository.deleteById(cEncontrado.getIdMedioPago());
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
}
