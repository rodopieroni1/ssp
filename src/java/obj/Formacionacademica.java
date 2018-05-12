/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luism
 */
@Entity
@Table(name = "formacionacademica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formacionacademica.findAll", query = "SELECT f FROM Formacionacademica f"),
    @NamedQuery(name = "Formacionacademica.findByIdForm", query = "SELECT f FROM Formacionacademica f WHERE f.idForm = :idForm"),
    @NamedQuery(name = "Formacionacademica.findByInstitucion", query = "SELECT f FROM Formacionacademica f WHERE f.institucion = :institucion"),
    @NamedQuery(name = "Formacionacademica.findByLugar", query = "SELECT f FROM Formacionacademica f WHERE f.lugar = :lugar"),
    @NamedQuery(name = "Formacionacademica.findByFechaInicio", query = "SELECT f FROM Formacionacademica f WHERE f.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Formacionacademica.findByFechaFin", query = "SELECT f FROM Formacionacademica f WHERE f.fechaFin = :fechaFin"),
    @NamedQuery(name = "Formacionacademica.findByEstadoFormacion", query = "SELECT f FROM Formacionacademica f WHERE f.estadoFormacion = :estadoFormacion")})
public class Formacionacademica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idForm")
    private Integer idForm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "institucion")
    private String institucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "lugar")
    private String lugar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estadoFormacion")
    private String estadoFormacion;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public Formacionacademica() {
    }

    public Formacionacademica(Integer idForm) {
        this.idForm = idForm;
    }

    public Formacionacademica(Integer idForm, String institucion, String lugar, Date fechaInicio, Date fechaFin, String estadoFormacion) {
        this.idForm = idForm;
        this.institucion = institucion;
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoFormacion = estadoFormacion;
    }

    public Integer getIdForm() {
        return idForm;
    }

    public void setIdForm(Integer idForm) {
        this.idForm = idForm;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstadoFormacion() {
        return estadoFormacion;
    }

    public void setEstadoFormacion(String estadoFormacion) {
        this.estadoFormacion = estadoFormacion;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idForm != null ? idForm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formacionacademica)) {
            return false;
        }
        Formacionacademica other = (Formacionacademica) object;
        if ((this.idForm == null && other.idForm != null) || (this.idForm != null && !this.idForm.equals(other.idForm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Formacionacademica[ idForm=" + idForm + " ]";
    }
    
}
