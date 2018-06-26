
package inacap.webcomponent.proyecto2only.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipopersonas")
public class TipoPersonaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;
    private String nombreTipoPersona;
    private String detalle;
    

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
}
