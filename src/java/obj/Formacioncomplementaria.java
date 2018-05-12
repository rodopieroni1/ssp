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
@Table(name = "formacioncomplementaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formacioncomplementaria.findAll", query = "SELECT f FROM Formacioncomplementaria f"),
    @NamedQuery(name = "Formacioncomplementaria.findByIdFormComplementaria", query = "SELECT f FROM Formacioncomplementaria f WHERE f.idFormComplementaria = :idFormComplementaria"),
    @NamedQuery(name = "Formacioncomplementaria.findByDescripcion", query = "SELECT f FROM Formacioncomplementaria f WHERE f.descripcion = :descripcion"),
    @NamedQuery(name = "Formacioncomplementaria.findByFecha", query = "SELECT f FROM Formacioncomplementaria f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Formacioncomplementaria.findByLugar", query = "SELECT f FROM Formacioncomplementaria f WHERE f.lugar = :lugar")})
public class Formacioncomplementaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFormComplementaria")
    private Integer idFormComplementaria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "lugar")
    private String lugar;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public Formacioncomplementaria() {
    }

    public Formacioncomplementaria(Integer idFormComplementaria) {
        this.idFormComplementaria = idFormComplementaria;
    }

    public Formacioncomplementaria(Integer idFormComplementaria, String descripcion, Date fecha, String lugar) {
        this.idFormComplementaria = idFormComplementaria;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public Integer getIdFormComplementaria() {
        return idFormComplementaria;
    }

    public void setIdFormComplementaria(Integer idFormComplementaria) {
        this.idFormComplementaria = idFormComplementaria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
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
        hash += (idFormComplementaria != null ? idFormComplementaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formacioncomplementaria)) {
            return false;
        }
        Formacioncomplementaria other = (Formacioncomplementaria) object;
        if ((this.idFormComplementaria == null && other.idFormComplementaria != null) || (this.idFormComplementaria != null && !this.idFormComplementaria.equals(other.idFormComplementaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Formacioncomplementaria[ idFormComplementaria=" + idFormComplementaria + " ]";
    }
    
}
