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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luism
 */
@Entity
@Table(name = "testmbti-postulante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestmbtiPostulante.findAll", query = "SELECT t FROM TestmbtiPostulante t"),
    @NamedQuery(name = "TestmbtiPostulante.findByIdTP", query = "SELECT t FROM TestmbtiPostulante t WHERE t.idTP = :idTP"),
    @NamedQuery(name = "TestmbtiPostulante.findByPuntajeObtenido", query = "SELECT t FROM TestmbtiPostulante t WHERE t.puntajeObtenido = :puntajeObtenido")})
public class TestmbtiPostulante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idT-P")
    private Integer idTP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntajeObtenido")
    private int puntajeObtenido;
    @JoinColumn(name = "idConvocPost", referencedColumnName = "idConvocPost")
    @ManyToOne(optional = false)
    private ConvocatoriaPostulante idConvocPost;
    @JoinColumn(name = "idMbti", referencedColumnName = "idMbti")
    @ManyToOne(optional = false)
    private Mbti idMbti;

    public TestmbtiPostulante() {
    }

    public TestmbtiPostulante(Integer idTP) {
        this.idTP = idTP;
    }

    public TestmbtiPostulante(Integer idTP, int puntajeObtenido) {
        this.idTP = idTP;
        this.puntajeObtenido = puntajeObtenido;
    }

    public Integer getIdTP() {
        return idTP;
    }

    public void setIdTP(Integer idTP) {
        this.idTP = idTP;
    }

    public int getPuntajeObtenido() {
        return puntajeObtenido;
    }

    public void setPuntajeObtenido(int puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }

    public ConvocatoriaPostulante getIdConvocPost() {
        return idConvocPost;
    }

    public void setIdConvocPost(ConvocatoriaPostulante idConvocPost) {
        this.idConvocPost = idConvocPost;
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
        hash += (idTP != null ? idTP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestmbtiPostulante)) {
            return false;
        }
        TestmbtiPostulante other = (TestmbtiPostulante) object;
        if ((this.idTP == null && other.idTP != null) || (this.idTP != null && !this.idTP.equals(other.idTP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.TestmbtiPostulante[ idTP=" + idTP + " ]";
    }
    
}
