
package inacap.webcomponent.proyecto2only.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "combustible")
public class CombustibleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idCombustible;
    private String tipoCombustible;
    private String detalle;
    
    
            
    public int getIdCombustible() {
        return idCombustible;
    }

    public void setIdCombustible(int idCombustible) {
        this.idCombustible = idCombustible;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public CombustibleModel() {
    }

    public CombustibleModel(String tipoCombustible, String detalle) {
        this.tipoCombustible = tipoCombustible;
        this.detalle = detalle;
    }

    private CombustibleModel(int idCombustible, String tipoCombustible, String detalle) {
        this.idCombustible = idCombustible;
        this.tipoCombustible = tipoCombustible;
        this.detalle = detalle;
    }
    
    public boolean nuevoCombustible(CombustibleModel nuevoCombustible){
        int id = 0;
        if(!combustibles.isEmpty()){
            for (CombustibleModel combustible: combustibles ){
                if (combustible.getIdCombustible() > id){
                    id = combustible.getIdCombustible();
                }
            }
        }
        id++;
        combustibles.add(new CombustibleModel(id,nuevoCombustible.getTipoCombustible() ,nuevoCombustible.getDetalle() ));
        return true;
    }
    
    public CombustibleModel buscaCombustible(int idCombustibleBuscado){
        CombustibleModel combustibleEncontrado = null;
        if(!combustibles.isEmpty()){
            for (CombustibleModel combustible : combustibles){
                if(combustible.getIdCombustible() == idCombustibleBuscado){
                   combustibleEncontrado = combustible; 
                }
            }
        }
        return combustibleEncontrado;
    }
    
    public CombustibleModel editarCombustible(int idCombustible, CombustibleModel combustibleEditar){
         CombustibleModel combustibleEditado = null;
        if(!combustibles.isEmpty()){
            for (CombustibleModel combustible : combustibles){
                if(combustible.getIdCombustible() == idCombustible){
                   combustible.setTipoCombustible(combustibleEditar.getTipoCombustible());
                   combustible.setDetalle(combustibleEditar.getDetalle());
                   combustibleEditado = combustible;
                }
            }
        }
        return combustibleEditado;
    }
    
    public boolean eliminarCombustible(int id){
      CombustibleModel combustibleEliminado = null;
        if(!combustibles.isEmpty()){
            for (CombustibleModel combustible : combustibles){
                if(combustible.getIdCombustible() == idCombustible){
                   combustibleEliminado = combustible;
                }
            }
        }  
        
        combustibles.remove(combustibleEliminado);
        
        return true;
    }
}
