
package inacap.webcomponent.proyecto2only.model;

import java.util.ArrayList;


public class MedioPagoModel {
    
    private int idMedioPago;
    private String nombreMedioPago;
    private String detalle;
    
    public static ArrayList<MedioPagoModel> pagos = new ArrayList<>();

    public int getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(int idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public String getNombreMedioPago() {
        return nombreMedioPago;
    }

    public void setNombreMedioPago(String nombreMedioPago) {
        this.nombreMedioPago = nombreMedioPago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public MedioPagoModel() {
    }

    public MedioPagoModel(String nombreMedioPago, String detalle) {
        this.nombreMedioPago = nombreMedioPago;
        this.detalle = detalle;
    }

    private MedioPagoModel(int idMedioPago, String nombreMedioPago, String detalle) {
        this.idMedioPago = idMedioPago;
        this.nombreMedioPago = nombreMedioPago;
        this.detalle = detalle;
    }
    
      public boolean nuevoPago(MedioPagoModel nuevoPago){
        int id = 0;
        if(!pagos.isEmpty()){
            for (MedioPagoModel pago: pagos ){
                if (pago.getIdMedioPago()> id){
                    id = pago.getIdMedioPago();
                }
            }
        }
        id++;
        pagos.add(new MedioPagoModel(id,nuevoPago.getNombreMedioPago(),nuevoPago.getDetalle() ));
        return true;
    }
        public MedioPagoModel buscaPago(int idPagoBuscado){
        MedioPagoModel pagoEncontrado = null;
        if(!pagos.isEmpty()){
            for (MedioPagoModel pago : pagos){
                if(pago.getIdMedioPago()== idPagoBuscado){
                   pagoEncontrado = pago; 
                }
            }
        }
        return pagoEncontrado;
    }
        public MedioPagoModel editarPago(int idPago, MedioPagoModel pagoEditar){
         MedioPagoModel pagoEditado = null;
        if(!pagos.isEmpty()){
            for (MedioPagoModel pago : pagos){
                if(pago.getIdMedioPago()== idPago){
                   pago.setNombreMedioPago(pagoEditar.getNombreMedioPago());
                   pago.setDetalle(pagoEditar.getDetalle());
                   pagoEditado = pago;
                }
            }
        }
        return pagoEditado;
    }
 public boolean eliminarPago(int id){
      MedioPagoModel pagoEliminado = null;
        if(!pagos.isEmpty()){
            for (MedioPagoModel pago : pagos){
                if(pago.getIdMedioPago()== idMedioPago){
                   pagoEliminado = pago;
                }
            }
        }  
        
        pagos.remove(pagoEliminado);
        
        return true;
    }
}
