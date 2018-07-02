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
import inacap.webcomponent.proyecto2only.model.VersionModel;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.proyecto2only.repository.VersionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chinasti
 */
@RestController
@RequestMapping("/version")
public class VersionController {
    
    @Autowired
    private VersionRepository versionRepository;
    
    @GetMapping()
    public Iterable<VersionModel> list() {
        return versionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<VersionModel> get(@PathVariable String id) {
        Optional<VersionModel> cOptional = versionRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            VersionModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
     @PutMapping("/{id}")
    public ResponseEntity<VersionModel> put(@PathVariable String id, @RequestBody VersionModel versionEditar) {
         Optional<VersionModel> cOptional = versionRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            VersionModel cEncontrado = cOptional.get();
            versionEditar.setIdVersion(cEncontrado.getIdVersion());
            versionRepository.save(versionEditar);
            return new ResponseEntity<>(versionEditar, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
     @PostMapping
    public ResponseEntity<?> post(@RequestBody VersionModel nuevaVersion) {
       
       nuevaVersion = versionRepository.save(nuevaVersion);
       Optional<VersionModel> cOptional = versionRepository.findById(nuevaVersion.getIdVersion());
        if (cOptional.isPresent()){
            VersionModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
       
    }
    
     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<VersionModel> cOptional = versionRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            VersionModel cEncontrado = cOptional.get();
            
            versionRepository.deleteById(cEncontrado.getIdVersion());
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
}
