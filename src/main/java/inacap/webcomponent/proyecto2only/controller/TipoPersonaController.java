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

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/tipopersona")
public class TipoPersonaController {
    
    @GetMapping()
    public List<TipoPersonaModel> list() {
        return TipoPersonaModel.tipopersonas;
    }
    
    @GetMapping("/{id}")
    public TipoPersonaModel get(@PathVariable String id) {
        TipoPersonaModel tipopersona = new TipoPersonaModel();
        return tipopersona.buscaTipoPersona(Integer.parseInt(id));
    }
    
     @PutMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> put(@PathVariable String id, @RequestBody TipoPersonaModel tipoPersonaEditar) {
        TipoPersonaModel tipopersona = new TipoPersonaModel();
        return new ResponseEntity<>(tipopersona.editarTipoPersona(Integer.parseInt(id), tipoPersonaEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoPersonaModel nuevoTipoPersona) {
        TipoPersonaModel tipopersona = new TipoPersonaModel();
        if (tipopersona.nuevoTipoPersona(nuevoTipoPersona)){
             return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
             return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
       
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        TipoPersonaModel tipopersona = new TipoPersonaModel();
        if (tipopersona.eliminarTipoPersona(Integer.parseInt(id))){
        return new ResponseEntity<>(HttpStatus.OK);
    }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        
    }
    
}
