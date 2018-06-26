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
import inacap.webcomponent.proyecto2only.model.TipoVehiculoModel;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.proyecto2only.repository.TipoVehiculoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/tipo")
public class TipoVehiculoController {
    
    @Autowired
    private TipoVehiculoRepository tipovehiculoRepository;
    
  @GetMapping()
    public Iterable<TipoVehiculoModel> list() {
        return tipovehiculoRepository.findAll();
    }
    
   @GetMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> get(@PathVariable String id) {
        Optional<TipoVehiculoModel> cOptional = tipovehiculoRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            TipoVehiculoModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
     @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> put(@PathVariable String id, @RequestBody TipoVehiculoModel tipovehiculoEditar) {
         Optional<TipoVehiculoModel> cOptional = tipovehiculoRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            TipoVehiculoModel cEncontrado = cOptional.get();
            tipovehiculoEditar.setIdTipoVehiculo(cEncontrado.getIdTipoVehiculo());
            tipovehiculoRepository.save(tipovehiculoEditar);
            return new ResponseEntity<>(tipovehiculoEditar, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoVehiculoModel nuevoTipoVehiculo) {
       
       nuevoTipoVehiculo = tipovehiculoRepository.save(nuevoTipoVehiculo);
       Optional<TipoVehiculoModel> cOptional = tipovehiculoRepository.findById(nuevoTipoVehiculo.getIdTipoVehiculo());
        if (cOptional.isPresent()){
            TipoVehiculoModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
       
    }
    
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<TipoVehiculoModel> cOptional = tipovehiculoRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            TipoVehiculoModel cEncontrado = cOptional.get();
            
            tipovehiculoRepository.deleteById(cEncontrado.getIdTipoVehiculo());
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
}
    

