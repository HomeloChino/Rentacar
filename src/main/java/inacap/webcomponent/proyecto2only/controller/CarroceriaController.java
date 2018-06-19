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
import inacap.webcomponent.proyecto2only.model.CarroceriaModel;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/carroceria")
public class CarroceriaController {
    
  @GetMapping()
    public List<CarroceriaModel> list() {
        return CarroceriaModel.carrocerias;
    }
    
    @GetMapping("/{id}")
    public CarroceriaModel get(@PathVariable String id) {
        CarroceriaModel carroceria = new CarroceriaModel();
        return carroceria.buscaCarroceria(Integer.parseInt(id));
    }
    
   @PutMapping("/{id}")
    public ResponseEntity<CarroceriaModel> put(@PathVariable String id, @RequestBody CarroceriaModel carroceriaEditar) {
        CarroceriaModel carroceria = new CarroceriaModel();
        return new ResponseEntity<>(carroceria.editarCarroceria(Integer.parseInt(id), carroceriaEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody CarroceriaModel nuevaCarroceria) {
        CarroceriaModel carroceria = new CarroceriaModel();
        if (carroceria.nuevaCarroceria(nuevaCarroceria)){
             return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
             return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
       
    }
    
     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        CarroceriaModel carroceria = new CarroceriaModel();
        if (carroceria.eliminarCarroceria(Integer.parseInt(id))){
        return new ResponseEntity<>(HttpStatus.OK);
    }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        
    }
    
}
