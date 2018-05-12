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
@Table(name = "idiomas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Idiomas.findAll", query = "SELECT i FROM Idiomas i"),
    @NamedQuery(name = "Idiomas.findByIdIdiomas", query = "SELECT i FROM Idiomas i WHERE i.idIdiomas = :idIdiomas"),
    @NamedQuery(name = "Idiomas.findByIdioma", query = "SELECT i FROM Idiomas i WHERE i.idioma = :idioma"),
    @NamedQuery(name = "Idiomas.findByNivelEscritura", query = "SELECT i FROM Idiomas i WHERE i.nivelEscritura = :nivelEscritura"),
    @NamedQuery(name = "Idiomas.findByNivelLectura", query = "SELECT i FROM Idiomas i WHERE i.nivelLectura = :nivelLectura")})
public class Idiomas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idIdiomas")
    private Integer idIdiomas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idioma")
    private String idioma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nivelEscritura")
    private String nivelEscritura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nivelLectura")
    private String nivelLectura;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public Idiomas() {
    }

    public Idiomas(Integer idIdiomas) {
        this.idIdiomas = idIdiomas;
    }

    public Idiomas(Integer idIdiomas, String idioma, String nivelEscritura, String nivelLectura) {
        this.idIdiomas = idIdiomas;
        this.idioma = idioma;
        this.nivelEscritura = nivelEscritura;
        this.nivelLectura = nivelLectura;
    }

    public Integer getIdIdiomas() {
        return idIdiomas;
    }

    public void setIdIdiomas(Integer idIdiomas) {
        this.idIdiomas = idIdiomas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getNivelEscritura() {
        return nivelEscritura;
    }

    public void setNivelEscritura(String nivelEscritura) {
        this.nivelEscritura = nivelEscritura;
    }

    public String getNivelLectura() {
        return nivelLectura;
    }

    public void setNivelLectura(String nivelLectura) {
        this.nivelLectura = nivelLectura;
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
        hash += (idIdiomas != null ? idIdiomas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idiomas)) {
            return false;
        }
        Idiomas other = (Idiomas) object;
        if ((this.idIdiomas == null && other.idIdiomas != null) || (this.idIdiomas != null && !this.idIdiomas.equals(other.idIdiomas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Idiomas[ idIdiomas=" + idIdiomas + " ]";
    }
    
}
