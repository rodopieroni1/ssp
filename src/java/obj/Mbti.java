/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
@Table(name = "mbti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mbti.findAll", query = "SELECT m FROM Mbti m"),
    @NamedQuery(name = "Mbti.findByIdMbti", query = "SELECT m FROM Mbti m WHERE m.idMbti = :idMbti"),
    @NamedQuery(name = "Mbti.findByDescripcion", query = "SELECT m FROM Mbti m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Mbti.findByCombinacion", query = "SELECT m FROM Mbti m WHERE m.combinacion = :combinacion")})
public class Mbti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMbti")
    private Integer idMbti;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "combinacion")
    private String combinacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMbti")
    private Collection<FortalezasDebilidades> fortalezasDebilidadesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMbti")
    private Collection<PerfilCompetenciaMbti> perfilCompetenciaMbtiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMbti")
    private Collection<TestmbtiPostulante> testmbtiPostulanteCollection;

    public Mbti() {
    }

    public Mbti(Integer idMbti) {
        this.idMbti = idMbti;
    }

    public Mbti(Integer idMbti, String descripcion, String combinacion) {
        this.idMbti = idMbti;
        this.descripcion = descripcion;
        this.combinacion = combinacion;
    }

    public Integer getIdMbti() {
        return idMbti;
    }

    public void setIdMbti(Integer idMbti) {
        this.idMbti = idMbti;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCombinacion() {
        return combinacion;
    }

    public void setCombinacion(String combinacion) {
        this.combinacion = combinacion;
    }

    @XmlTransient
    public Collection<FortalezasDebilidades> getFortalezasDebilidadesCollection() {
        return fortalezasDebilidadesCollection;
    }

    public void setFortalezasDebilidadesCollection(Collection<FortalezasDebilidades> fortalezasDebilidadesCollection) {
        this.fortalezasDebilidadesCollection = fortalezasDebilidadesCollection;
    }

    @XmlTransient
    public Collection<PerfilCompetenciaMbti> getPerfilCompetenciaMbtiCollection() {
        return perfilCompetenciaMbtiCollection;
    }

    public void setPerfilCompetenciaMbtiCollection(Collection<PerfilCompetenciaMbti> perfilCompetenciaMbtiCollection) {
        this.perfilCompetenciaMbtiCollection = perfilCompetenciaMbtiCollection;
    }

    @XmlTransient
    public Collection<TestmbtiPostulante> getTestmbtiPostulanteCollection() {
        return testmbtiPostulanteCollection;
    }

    public void setTestmbtiPostulanteCollection(Collection<TestmbtiPostulante> testmbtiPostulanteCollection) {
        this.testmbtiPostulanteCollection = testmbtiPostulanteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMbti != null ? idMbti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mbti)) {
            return false;
        }
        Mbti other = (Mbti) object;
        if ((this.idMbti == null && other.idMbti != null) || (this.idMbti != null && !this.idMbti.equals(other.idMbti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Mbti[ idMbti=" + idMbti + " ]";
    }
    
}
