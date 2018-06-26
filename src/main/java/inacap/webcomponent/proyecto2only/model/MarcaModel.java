
package inacap.webcomponent.proyecto2only.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marca")
public class MarcaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMarca;
    private String nombreMarca;
    private String detalle;

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public MarcaModel() {
    }

    public MarcaModel(String nombreMarca, String detalle) {
        this.nombreMarca = nombreMarca;
        this.detalle = detalle;
    }

    private MarcaModel(int idMarca, String nombreMarca, String detalle) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.detalle = detalle;
    }
}
