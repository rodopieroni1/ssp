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
@Table(name = "perfil-competencia-mbti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilCompetenciaMbti.findAll", query = "SELECT p FROM PerfilCompetenciaMbti p"),
    @NamedQuery(name = "PerfilCompetenciaMbti.findByIdPCM", query = "SELECT p FROM PerfilCompetenciaMbti p WHERE p.idPCM = :idPCM"),
    @NamedQuery(name = "PerfilCompetenciaMbti.findByValor", query = "SELECT p FROM PerfilCompetenciaMbti p WHERE p.valor = :valor")})
public class PerfilCompetenciaMbti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPCM")
    private Integer idPCM;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @JoinColumn(name = "idCompetencia", referencedColumnName = "idCompetencia")
    @ManyToOne(optional = false)
    private Competencias idCompetencia;
    @JoinColumn(name = "idMbti", referencedColumnName = "idMbti")
    @ManyToOne(optional = false)
    private Mbti idMbti;
    @JoinColumn(name = "idPerfil", referencedColumnName = "idPerfil")
    @ManyToOne(optional = false)
    private Perfil idPerfil;

    public PerfilCompetenciaMbti() {
    }

    public PerfilCompetenciaMbti(Integer idPCM) {
        this.idPCM = idPCM;
    }

    public PerfilCompetenciaMbti(Integer idPCM, int valor) {
        this.idPCM = idPCM;
        this.valor = valor;
    }

    public Integer getIdPCM() {
        return idPCM;
    }

    public void setIdPCM(Integer idPCM) {
        this.idPCM = idPCM;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Competencias getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Competencias idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public Mbti getIdMbti() {
        return idMbti;
    }

    public void setIdMbti(Mbti idMbti) {
        this.idMbti = idMbti;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPCM != null ? idPCM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilCompetenciaMbti)) {
            return false;
        }
        PerfilCompetenciaMbti other = (PerfilCompetenciaMbti) object;
        if ((this.idPCM == null && other.idPCM != null) || (this.idPCM != null && !this.idPCM.equals(other.idPCM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.PerfilCompetenciaMbti[ idPCM=" + idPCM + " ]";
    }
    
}
