
package inacap.webcomponent.proyecto2only.model;

import java.util.ArrayList;


public class TipoPersonaModel {
    
    private int idPersona;
    private String nombreTipoPersona;
    private String detalle;
    
    public static ArrayList<TipoPersonaModel> tipopersonas = new ArrayList<>();

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombreTipoPersona() {
        return nombreTipoPersona;
    }

    public void setNombreTipoPersona(String nombreTipoPersona) {
        this.nombreTipoPersona = nombreTipoPersona;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TipoPersonaModel() {
    }

    public TipoPersonaModel(String nombreTipoPersona, String detalle) {
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalle = detalle;
    }

    private TipoPersonaModel(int idPersona, String nombreTipoPersona, String detalle) {
        this.idPersona = idPersona;
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalle = detalle;
    }
    public boolean nuevoTipoPersona(TipoPersonaModel nuevoTipoPersona){
        int id = 0;
        if(!tipopersonas.isEmpty()){
            for (TipoPersonaModel tipopersona: tipopersonas ){
                if (tipopersona.getIdPersona()> id){
                    id = tipopersona.getIdPersona();
                }
            }
        }
        id++;
        tipopersonas.add(new TipoPersonaModel(id,nuevoTipoPersona.getNombreTipoPersona(),nuevoTipoPersona.getDetalle() ));
        return true;
    }
    public TipoPersonaModel buscaTipoPersona(int idTipoPersonaBuscado){
        TipoPersonaModel tipoPersonaEncontrado = null;
        if(!tipopersonas.isEmpty()){
            for (TipoPersonaModel tipopersona : tipopersonas){
                if(tipopersona.getIdPersona()== idTipoPersonaBuscado){
                   tipoPersonaEncontrado = tipopersona; 
                }
            }
        }
        return tipoPersonaEncontrado;
    }
    public TipoPersonaModel editarTipoPersona(int idTipoPersona, TipoPersonaModel tipoPersonaEditar){
         TipoPersonaModel tipoPersonEditado = null;
        if(!tipopersonas.isEmpty()){
            for (TipoPersonaModel tipopersona : tipopersonas){
                if(tipopersona.getIdPersona()== idTipoPersona){
                   tipopersona.setNombreTipoPersona(tipoPersonaEditar.getNombreTipoPersona());
                   tipopersona.setDetalle(tipoPersonaEditar.getDetalle());
                   tipoPersonEditado = tipopersona;
                }
            }
        }
        return tipoPersonEditado;
    }
    public boolean eliminarTipoPersona(int id){
      TipoPersonaModel tipoPersonaEliminado = null;
        if(!tipopersonas.isEmpty()){
            for (TipoPersonaModel tipopersona : tipopersonas){
                if(tipopersona.getIdPersona()== idPersona){
                   tipoPersonaEliminado = tipopersona;
                }
            }
        }  
        
        tipopersonas.remove(tipoPersonaEliminado);
        
        return true;
    }
}
