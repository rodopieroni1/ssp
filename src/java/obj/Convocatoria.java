/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luism
 */
@Entity
@Table(name = "convocatoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convocatoria.findAll", query = "SELECT c FROM Convocatoria c"),
    @NamedQuery(name = "Convocatoria.findByIdConvocatoria", query = "SELECT c FROM Convocatoria c WHERE c.idConvocatoria = :idConvocatoria"),
    @NamedQuery(name = "Convocatoria.findByDescripcionPuesto", query = "SELECT c FROM Convocatoria c WHERE c.descripcionPuesto = :descripcionPuesto"),
    @NamedQuery(name = "Convocatoria.findByFechaCreacion", query = "SELECT c FROM Convocatoria c WHERE c.fechaCreacion = :fechaCreacion")})
public class Convocatoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConvocatoria")
    private Integer idConvocatoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "descripcionPuesto")
    private String descripcionPuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinColumn(name = "idPerfil", referencedColumnName = "idPerfil")
    @ManyToOne(optional = false)
    private Perfil idPerfil;
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConvocatoria")
    private Collection<ConvocatoriaPostulante> convocatoriaPostulanteCollection;

    public Convocatoria() {
    }

    public Convocatoria(Integer idConvocatoria) {
        this.idConvocatoria = idConvocatoria;
    }

    public Convocatoria(Integer idConvocatoria, String descripcionPuesto, Date fechaCreacion) {
        this.idConvocatoria = idConvocatoria;
        this.descripcionPuesto = descripcionPuesto;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdConvocatoria() {
        return idConvocatoria;
    }

    public void setIdConvocatoria(Integer idConvocatoria) {
        this.idConvocatoria = idConvocatoria;
    }

    public String getDescripcionPuesto() {
        return descripcionPuesto;
    }

    public void setDescripcionPuesto(String descripcionPuesto) {
        this.descripcionPuesto = descripcionPuesto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<ConvocatoriaPostulante> getConvocatoriaPostulanteCollection() {
        return convocatoriaPostulanteCollection;
    }

    public void setConvocatoriaPostulanteCollection(Collection<ConvocatoriaPostulante> convocatoriaPostulanteCollection) {
        this.convocatoriaPostulanteCollection = convocatoriaPostulanteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConvocatoria != null ? idConvocatoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convocatoria)) {
            return false;
        }
        Convocatoria other = (Convocatoria) object;
        if ((this.idConvocatoria == null && other.idConvocatoria != null) || (this.idConvocatoria != null && !this.idConvocatoria.equals(other.idConvocatoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Convocatoria[ idConvocatoria=" + idConvocatoria + " ]";
    }
    
}
