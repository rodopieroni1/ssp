/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luism
 */
@Entity
@Table(name = "fortalezas-debilidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FortalezasDebilidades.findAll", query = "SELECT f FROM FortalezasDebilidades f"),
    @NamedQuery(name = "FortalezasDebilidades.findByIdFD", query = "SELECT f FROM FortalezasDebilidades f WHERE f.idFD = :idFD"),
    @NamedQuery(name = "FortalezasDebilidades.findByTiutlo", query = "SELECT f FROM FortalezasDebilidades f WHERE f.tiutlo = :tiutlo"),
    @NamedQuery(name = "FortalezasDebilidades.findByDescripcion", query = "SELECT f FROM FortalezasDebilidades f WHERE f.descripcion = :descripcion"),
    @NamedQuery(name = "FortalezasDebilidades.findByEsFortaleza", query = "SELECT f FROM FortalezasDebilidades f WHERE f.esFortaleza = :esFortaleza")})
public class FortalezasDebilidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idF-D")
    private Integer idFD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tiutlo")
    private String tiutlo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "esFortaleza")
    private String esFortaleza;
    @JoinColumn(name = "idMbti", referencedColumnName = "idMbti")
    @ManyToOne(optional = false)
    private Mbti idMbti;

    public FortalezasDebilidades() {
    }

    public FortalezasDebilidades(Integer idFD) {
        this.idFD = idFD;
    }

    public FortalezasDebilidades(Integer idFD, String tiutlo, String descripcion, String esFortaleza) {
        this.idFD = idFD;
        this.tiutlo = tiutlo;
        this.descripcion = descripcion;
        this.esFortaleza = esFortaleza;
    }

    public Integer getIdFD() {
        return idFD;
    }

    public void setIdFD(Integer idFD) {
        this.idFD = idFD;
    }

    public String getTiutlo() {
        return tiutlo;
    }

    public void setTiutlo(String tiutlo) {
        this.tiutlo = tiutlo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEsFortaleza() {
        return esFortaleza;
    }

    public void setEsFortaleza(String esFortaleza) {
        this.esFortaleza = esFortaleza;
    }

    public Mbti getIdMbti() {
        return idMbti;
    }

    public void setIdMbti(Mbti idMbti) {
        this.idMbti = idMbti;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFD != null ? idFD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FortalezasDebilidades)) {
            return false;
        }
        FortalezasDebilidades other = (FortalezasDebilidades) object;
        if ((this.idFD == null && other.idFD != null) || (this.idFD != null && !this.idFD.equals(other.idFD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.FortalezasDebilidades[ idFD=" + idFD + " ]";
    }
    
}
