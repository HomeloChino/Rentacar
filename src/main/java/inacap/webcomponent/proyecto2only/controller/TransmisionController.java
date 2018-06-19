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

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/transmision")
public class TransmisionController {
    
     @GetMapping()
    public List<TransmisionModel> list() {
        return TransmisionModel.transmisiones;
    }
    
     @GetMapping("/{id}")
    public TransmisionModel get(@PathVariable String id) {
        TransmisionModel transmision = new TransmisionModel();
        return transmision.buscaTransmision(Integer.parseInt(id));
    }
    
     @PutMapping("/{id}")
    public ResponseEntity<TransmisionModel> put(@PathVariable String id, @RequestBody TransmisionModel transmisionEditar) {
        TransmisionModel transmision = new TransmisionModel();
        return new ResponseEntity<>(transmision.editarTransmision(Integer.parseInt(id), transmisionEditar), HttpStatus.OK);
    }
    
   @PostMapping
    public ResponseEntity<?> post(@RequestBody TransmisionModel nuevaTransmision) {
        TransmisionModel transmision = new TransmisionModel();
        if (transmision.nuevaTransmision(nuevaTransmision)){
             return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
             return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
       
    }
    
     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        TransmisionModel transmision = new TransmisionModel();
        if (transmision.eliminarTransmision(Integer.parseInt(id))){
        return new ResponseEntity<>(HttpStatus.OK);
    }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        
    }
    
}
