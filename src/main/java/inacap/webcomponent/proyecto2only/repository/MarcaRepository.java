/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.proyecto2only.repository;

import org.springframework.data.repository.CrudRepository;
import inacap.webcomponent.proyecto2only.model.MarcaModel;

/**
 *
 * @author Chinasti
 */
public interface MarcaRepository extends CrudRepository<MarcaModel, Integer> {
    
}
