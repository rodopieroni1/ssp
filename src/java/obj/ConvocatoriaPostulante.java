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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "convocatoria-postulante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConvocatoriaPostulante.findAll", query = "SELECT c FROM ConvocatoriaPostulante c"),
    @NamedQuery(name = "ConvocatoriaPostulante.findByIdConvocPost", query = "SELECT c FROM ConvocatoriaPostulante c WHERE c.idConvocPost = :idConvocPost"),
    @NamedQuery(name = "ConvocatoriaPostulante.findByPuntajeTotalObtenido", query = "SELECT c FROM ConvocatoriaPostulante c WHERE c.puntajeTotalObtenido = :puntajeTotalObtenido"),
    @NamedQuery(name = "ConvocatoriaPostulante.findByFueSeleccionado", query = "SELECT c FROM ConvocatoriaPostulante c WHERE c.fueSeleccionado = :fueSeleccionado"),
    @NamedQuery(name = "ConvocatoriaPostulante.findByPresentoDocumentacion", query = "SELECT c FROM ConvocatoriaPostulante c WHERE c.presentoDocumentacion = :presentoDocumentacion")})
public class ConvocatoriaPostulante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConvocPost")
    private Integer idConvocPost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntajeTotalObtenido")
    private int puntajeTotalObtenido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fueSeleccionado")
    private String fueSeleccionado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "presentoDocumentacion")
    private String presentoDocumentacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConvocPost")
    private Collection<TestmbtiPostulante> testmbtiPostulanteCollection;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @JoinColumn(name = "idConvocatoria", referencedColumnName = "idConvocatoria")
    @ManyToOne(optional = false)
    private Convocatoria idConvocatoria;

    public ConvocatoriaPostulante() {
    }

    public ConvocatoriaPostulante(Integer idConvocPost) {
        this.idConvocPost = idConvocPost;
    }

    public ConvocatoriaPostulante(Integer idConvocPost, int puntajeTotalObtenido, String fueSeleccionado, String presentoDocumentacion) {
        this.idConvocPost = idConvocPost;
        this.puntajeTotalObtenido = puntajeTotalObtenido;
        this.fueSeleccionado = fueSeleccionado;
        this.presentoDocumentacion = presentoDocumentacion;
    }

    public Integer getIdConvocPost() {
        return idConvocPost;
    }

    public void setIdConvocPost(Integer idConvocPost) {
        this.idConvocPost = idConvocPost;
    }

    public int getPuntajeTotalObtenido() {
        return puntajeTotalObtenido;
    }

    public void setPuntajeTotalObtenido(int puntajeTotalObtenido) {
        this.puntajeTotalObtenido = puntajeTotalObtenido;
    }

    public String getFueSeleccionado() {
        return fueSeleccionado;
    }

    public void setFueSeleccionado(String fueSeleccionado) {
        this.fueSeleccionado = fueSeleccionado;
    }

    public String getPresentoDocumentacion() {
        return presentoDocumentacion;
    }

    public void setPresentoDocumentacion(String presentoDocumentacion) {
        this.presentoDocumentacion = presentoDocumentacion;
    }

    @XmlTransient
    public Collection<TestmbtiPostulante> getTestmbtiPostulanteCollection() {
        return testmbtiPostulanteCollection;
    }

    public void setTestmbtiPostulanteCollection(Collection<TestmbtiPostulante> testmbtiPostulanteCollection) {
        this.testmbtiPostulanteCollection = testmbtiPostulanteCollection;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Convocatoria getIdConvocatoria() {
        return idConvocatoria;
    }

    public void setIdConvocatoria(Convocatoria idConvocatoria) {
        this.idConvocatoria = idConvocatoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConvocPost != null ? idConvocPost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConvocatoriaPostulante)) {
            return false;
        }
        ConvocatoriaPostulante other = (ConvocatoriaPostulante) object;
        if ((this.idConvocPost == null && other.idConvocPost != null) || (this.idConvocPost != null && !this.idConvocPost.equals(other.idConvocPost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.ConvocatoriaPostulante[ idConvocPost=" + idConvocPost + " ]";
    }
    
}
