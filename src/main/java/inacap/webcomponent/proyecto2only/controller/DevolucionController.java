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
import inacap.webcomponent.proyecto2only.model.DevolucionModel;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.proyecto2only.repository.DevolucionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/devolucion")
public class DevolucionController {
    
    @Autowired
    private DevolucionRepository devolucionRepository;
    
   @GetMapping()
    public Iterable<DevolucionModel> list() {
        return devolucionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DevolucionModel> get(@PathVariable String id) {
        Optional<DevolucionModel> cOptional = devolucionRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            DevolucionModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DevolucionModel> put(@PathVariable String id, @RequestBody DevolucionModel devolucionEditar) {
         Optional<DevolucionModel> cOptional = devolucionRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            DevolucionModel cEncontrado = cOptional.get();
            devolucionEditar.setIdDevolucion(cEncontrado.getIdDevolucion());
            devolucionRepository.save(devolucionEditar);
            return new ResponseEntity<>(devolucionEditar, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody DevolucionModel nuevaDevolucion) {
       
       nuevaDevolucion = devolucionRepository.save(nuevaDevolucion);
       Optional<DevolucionModel> cOptional = devolucionRepository.findById(nuevaDevolucion.getIdDevolucion());
        if (cOptional.isPresent()){
            DevolucionModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
       
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<DevolucionModel> cOptional = devolucionRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            DevolucionModel cEncontrado = cOptional.get();
            
            devolucionRepository.deleteById(cEncontrado.getIdDevolucion());
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
}
