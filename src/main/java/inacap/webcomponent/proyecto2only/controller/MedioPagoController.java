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

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/pago")
public class MedioPagoController {
    
   @GetMapping()
    public List<MedioPagoModel> list() {
        return MedioPagoModel.pagos;
    }
    
      @GetMapping("/{id}")
    public MedioPagoModel get(@PathVariable String id) {
        MedioPagoModel pago = new MedioPagoModel();
        return pago.buscaPago(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MedioPagoModel> put(@PathVariable String id, @RequestBody MedioPagoModel pagoEditar) {
        MedioPagoModel pago = new MedioPagoModel();
        return new ResponseEntity<>(pago.editarPago(Integer.parseInt(id), pagoEditar), HttpStatus.OK);
    }
    
     @PostMapping
    public ResponseEntity<?> post(@RequestBody MedioPagoModel nuevoPago) {
         MedioPagoModel pago = new MedioPagoModel();
        if (pago.nuevoPago(nuevoPago)){
             return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
             return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
       
    }
    
   @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        MedioPagoModel pago = new MedioPagoModel();
        if (pago.eliminarPago(Integer.parseInt(id))){
        return new ResponseEntity<>(HttpStatus.OK);
    }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        
    }
    
}
