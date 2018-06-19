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

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/tipo")
public class TipoVehiculoController {
    
   @GetMapping()
    public List<TipoVehiculoModel> list() {
        return TipoVehiculoModel.tipos;
    }
    
   @GetMapping("/{id}")
    public TipoVehiculoModel get(@PathVariable String id) {
        TipoVehiculoModel tipo = new TipoVehiculoModel();
        return tipo.buscaTipo(Integer.parseInt(id));
    }
    
     @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> put(@PathVariable String id, @RequestBody TipoVehiculoModel tipoEditar) {
        TipoVehiculoModel tipo = new TipoVehiculoModel();
        return new ResponseEntity<>(tipo.editarTipo(Integer.parseInt(id), tipoEditar), HttpStatus.OK);
    }
    
     @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoVehiculoModel nuevoTipo) {
        TipoVehiculoModel tipo = new TipoVehiculoModel();
        if (tipo.nuevoTipo(nuevoTipo)){
             return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
             return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
       
    }
    
   @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        TipoVehiculoModel tipo = new TipoVehiculoModel();
        if (tipo.eliminarTipo(Integer.parseInt(id))){
        return new ResponseEntity<>(HttpStatus.OK);
    }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        
    }
    
}
