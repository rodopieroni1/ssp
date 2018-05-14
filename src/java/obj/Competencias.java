/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor chivop.
 */
package obj;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luism
 */
@Entity
@Table(name = "competencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competencias.findAll", query = "SELECT c FROM Competencias c"),
    @NamedQuery(name = "Competencias.findByIdCompetencia", query = "SELECT c FROM Competencias c WHERE c.idCompetencia = :idCompetencia"),
    @NamedQuery(name = "Competencias.findByNombre", query = "SELECT c FROM Competencias c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Competencias.findByDescripcion", query = "SELECT c FROM Competencias c WHERE c.descripcion = :descripcion")})
public class Competencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompetencia")
    private Integer idCompetencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompetencia")
    private Collection<PerfilCompetenciaMbti> perfilCompetenciaMbtiCollection;

    public Competencias() {
    }

    public Competencias(Integer idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public Competencias(Integer idCompetencia, String nombre, String descripcion) {
        this.idCompetencia = idCompetencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Integer idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<PerfilCompetenciaMbti> getPerfilCompetenciaMbtiCollection() {
        return perfilCompetenciaMbtiCollection;
    }

    public void setPerfilCompetenciaMbtiCollection(Collection<PerfilCompetenciaMbti> perfilCompetenciaMbtiCollection) {
        this.perfilCompetenciaMbtiCollection = perfilCompetenciaMbtiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompetencia != null ? idCompetencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competencias)) {
            return false;
        }
        Competencias other = (Competencias) object;
        if ((this.idCompetencia == null && other.idCompetencia != null) || (this.idCompetencia != null && !this.idCompetencia.equals(other.idCompetencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Competencias[ idCompetencia=" + idCompetencia + " ]";
    }
    
}
