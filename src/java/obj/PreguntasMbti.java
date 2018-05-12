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
@Table(name = "preguntas-mbti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntasMbti.findAll", query = "SELECT p FROM PreguntasMbti p"),
    @NamedQuery(name = "PreguntasMbti.findByIdPM", query = "SELECT p FROM PreguntasMbti p WHERE p.idPM = :idPM"),
    @NamedQuery(name = "PreguntasMbti.findByDescripcion", query = "SELECT p FROM PreguntasMbti p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PreguntasMbti.findByReaccionEsperada", query = "SELECT p FROM PreguntasMbti p WHERE p.reaccionEsperada = :reaccionEsperada"),
    @NamedQuery(name = "PreguntasMbti.findByIdCompetencia", query = "SELECT p FROM PreguntasMbti p WHERE p.idCompetencia = :idCompetencia")})
public class PreguntasMbti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idP-M")
    private Integer idPM;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "reaccionEsperada")
    private String reaccionEsperada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCompetencia")
    private int idCompetencia;

    public PreguntasMbti() {
    }

    public PreguntasMbti(Integer idPM) {
        this.idPM = idPM;
    }

    public PreguntasMbti(Integer idPM, String descripcion, String reaccionEsperada, int idCompetencia) {
        this.idPM = idPM;
        this.descripcion = descripcion;
        this.reaccionEsperada = reaccionEsperada;
        this.idCompetencia = idCompetencia;
    }

    public Integer getIdPM() {
        return idPM;
    }

    public void setIdPM(Integer idPM) {
        this.idPM = idPM;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReaccionEsperada() {
        return reaccionEsperada;
    }

    public void setReaccionEsperada(String reaccionEsperada) {
        this.reaccionEsperada = reaccionEsperada;
    }

    public int getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(int idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPM != null ? idPM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntasMbti)) {
            return false;
        }
        PreguntasMbti other = (PreguntasMbti) object;
        if ((this.idPM == null && other.idPM != null) || (this.idPM != null && !this.idPM.equals(other.idPM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.PreguntasMbti[ idPM=" + idPM + " ]";
    }
    
}
