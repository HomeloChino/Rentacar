
package inacap.webcomponent.proyecto2only.model;

import java.util.ArrayList;


public class TipoVehiculoModel {
    
    private int idTipoVehiculo;
    private String nombreTipoVehiculo;
    private String detalle;
    
    public static ArrayList<TipoVehiculoModel> tipos = new ArrayList<>();

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getNombreTipoVehiculo() {
        return nombreTipoVehiculo;
    }

    public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TipoVehiculoModel() {
    }

    public TipoVehiculoModel(String nombreTipoVehiculo, String detalle) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalle = detalle;
    }

    private TipoVehiculoModel(int idTipoVehiculo, String nombreTipoVehiculo, String detalle) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalle = detalle;
    }
    public boolean nuevoTipo(TipoVehiculoModel nuevoTipo){
        int id = 0;
        if(!tipos.isEmpty()){
            for (TipoVehiculoModel tipo: tipos ){
                if (tipo.getIdTipoVehiculo()> id){
                    id = tipo.getIdTipoVehiculo();
                }
            }
        }
        id++;
        tipos.add(new TipoVehiculoModel(id,nuevoTipo.getNombreTipoVehiculo(),nuevoTipo.getDetalle() ));
        return true;
    }
    public TipoVehiculoModel buscaTipo(int idTipoBuscado){
        TipoVehiculoModel tipoEncontrado = null;
        if(!tipos.isEmpty()){
            for (TipoVehiculoModel tipo : tipos){
                if(tipo.getIdTipoVehiculo()== idTipoBuscado){
                   tipoEncontrado = tipo; 
                }
            }
        }
        return tipoEncontrado;
    }
     public TipoVehiculoModel editarTipo(int idTipo, TipoVehiculoModel tipoEditar){
         TipoVehiculoModel tipoEditado = null;
        if(!tipos.isEmpty()){
            for (TipoVehiculoModel tipo : tipos){
                if(tipo.getIdTipoVehiculo()== idTipo){
                   tipo.setNombreTipoVehiculo(tipoEditar.getNombreTipoVehiculo());
                   tipo.setDetalle(tipoEditar.getDetalle());
                   tipoEditado = tipo;
                }
            }
        }
        return tipoEditado;
    }
      public boolean eliminarTipo(int id){
      TipoVehiculoModel tipoEliminado = null;
        if(!tipos.isEmpty()){
            for (TipoVehiculoModel tipo : tipos){
                if(tipo.getIdTipoVehiculo()== idTipoVehiculo){
                   tipoEliminado = tipo;
                }
            }
        }  
        
        tipos.remove(tipoEliminado);
        
        return true;
    }
}
