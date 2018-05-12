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
@Table(name = "experienciaprofesional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experienciaprofesional.findAll", query = "SELECT e FROM Experienciaprofesional e"),
    @NamedQuery(name = "Experienciaprofesional.findByIdExpProf", query = "SELECT e FROM Experienciaprofesional e WHERE e.idExpProf = :idExpProf"),
    @NamedQuery(name = "Experienciaprofesional.findByLugar", query = "SELECT e FROM Experienciaprofesional e WHERE e.lugar = :lugar"),
    @NamedQuery(name = "Experienciaprofesional.findByDescripcionPuesto", query = "SELECT e FROM Experienciaprofesional e WHERE e.descripcionPuesto = :descripcionPuesto"),
    @NamedQuery(name = "Experienciaprofesional.findByDescripcionFunciones", query = "SELECT e FROM Experienciaprofesional e WHERE e.descripcionFunciones = :descripcionFunciones"),
    @NamedQuery(name = "Experienciaprofesional.findByFechaInicio", query = "SELECT e FROM Experienciaprofesional e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Experienciaprofesional.findByFechaFin", query = "SELECT e FROM Experienciaprofesional e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "Experienciaprofesional.findByTrabajaAhi", query = "SELECT e FROM Experienciaprofesional e WHERE e.trabajaAhi = :trabajaAhi")})
public class Experienciaprofesional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idExpProf")
    private Integer idExpProf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lugar")
    private int lugar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion-Puesto")
    private String descripcionPuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion-funciones")
    private String descripcionFunciones;
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
    @Size(min = 1, max = 5)
    @Column(name = "trabajaAhi")
    private String trabajaAhi;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public Experienciaprofesional() {
    }

    public Experienciaprofesional(Integer idExpProf) {
        this.idExpProf = idExpProf;
    }

    public Experienciaprofesional(Integer idExpProf, int lugar, String descripcionPuesto, String descripcionFunciones, Date fechaInicio, Date fechaFin, String trabajaAhi) {
        this.idExpProf = idExpProf;
        this.lugar = lugar;
        this.descripcionPuesto = descripcionPuesto;
        this.descripcionFunciones = descripcionFunciones;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.trabajaAhi = trabajaAhi;
    }

    public Integer getIdExpProf() {
        return idExpProf;
    }

    public void setIdExpProf(Integer idExpProf) {
        this.idExpProf = idExpProf;
    }

    public int getLugar() {
        return lugar;
    }

    public void setLugar(int lugar) {
        this.lugar = lugar;
    }

    public String getDescripcionPuesto() {
        return descripcionPuesto;
    }

    public void setDescripcionPuesto(String descripcionPuesto) {
        this.descripcionPuesto = descripcionPuesto;
    }

    public String getDescripcionFunciones() {
        return descripcionFunciones;
    }

    public void setDescripcionFunciones(String descripcionFunciones) {
        this.descripcionFunciones = descripcionFunciones;
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

    public String getTrabajaAhi() {
        return trabajaAhi;
    }

    public void setTrabajaAhi(String trabajaAhi) {
        this.trabajaAhi = trabajaAhi;
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
        hash += (idExpProf != null ? idExpProf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experienciaprofesional)) {
            return false;
        }
        Experienciaprofesional other = (Experienciaprofesional) object;
        if ((this.idExpProf == null && other.idExpProf != null) || (this.idExpProf != null && !this.idExpProf.equals(other.idExpProf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Experienciaprofesional[ idExpProf=" + idExpProf + " ]";
    }
    
}
