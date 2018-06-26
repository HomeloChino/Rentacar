/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.proyecto2only.repository;

import org.springframework.data.repository.CrudRepository;
import inacap.webcomponent.proyecto2only.model.RegionModel;

/**
 *
 * @author Chinasti
 */
public interface RegionRepository extends CrudRepository<RegionModel, Integer> {
    
}
