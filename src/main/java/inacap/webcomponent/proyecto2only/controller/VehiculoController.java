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
import inacap.webcomponent.proyecto2only.model.VehiculoModel;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.proyecto2only.repository.VehiculoRepositoy;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    
    @Autowired
    private VehiculoRepositoy vehiculoRepository;
    
    @GetMapping()
    public Iterable<VehiculoModel> list() {
        return vehiculoRepository.findAll();
    }
    
     @GetMapping("/{id}")
    public ResponseEntity<VehiculoModel> get(@PathVariable String id) {
        Optional<VehiculoModel> cOptional = vehiculoRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            VehiculoModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
  @PutMapping("/{id}")
    public ResponseEntity<VehiculoModel> put(@PathVariable String id, @RequestBody VehiculoModel vehiculoEditar) {
         Optional<VehiculoModel> cOptional = vehiculoRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            VehiculoModel cEncontrado = cOptional.get();
            vehiculoEditar.setIdVehiculo(cEncontrado.getIdVehiculo());
            vehiculoRepository.save(vehiculoEditar);
            return new ResponseEntity<>(vehiculoEditar, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
     @PostMapping
    public ResponseEntity<?> post(@RequestBody VehiculoModel nuevoVehiculo) {
       
       nuevoVehiculo = vehiculoRepository.save(nuevoVehiculo);
       Optional<VehiculoModel> cOptional = vehiculoRepository.findById(nuevoVehiculo.getIdVehiculo());
        if (cOptional.isPresent()){
            VehiculoModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
       
    }
    
     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<VehiculoModel> cOptional = vehiculoRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            VehiculoModel cEncontrado = cOptional.get();
            
            vehiculoRepository.deleteById(cEncontrado.getIdVehiculo());
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
}
