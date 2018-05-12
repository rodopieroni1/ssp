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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Persona.findByApeyNom", query = "SELECT p FROM Persona p WHERE p.apeyNom = :apeyNom"),
    @NamedQuery(name = "Persona.findByDni", query = "SELECT p FROM Persona p WHERE p.dni = :dni"),
    @NamedQuery(name = "Persona.findByCuil", query = "SELECT p FROM Persona p WHERE p.cuil = :cuil"),
    @NamedQuery(name = "Persona.findBySexo", query = "SELECT p FROM Persona p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Persona.findByLugarNacimineto", query = "SELECT p FROM Persona p WHERE p.lugarNacimineto = :lugarNacimineto"),
    @NamedQuery(name = "Persona.findByEstadoCivil", query = "SELECT p FROM Persona p WHERE p.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Persona.findByMail", query = "SELECT p FROM Persona p WHERE p.mail = :mail"),
    @NamedQuery(name = "Persona.findByCarnetConducir", query = "SELECT p FROM Persona p WHERE p.carnetConducir = :carnetConducir"),
    @NamedQuery(name = "Persona.findByDispViajes", query = "SELECT p FROM Persona p WHERE p.dispViajes = :dispViajes")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPersona")
    private Integer idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ApeyNom")
    private String apeyNom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dni")
    private int dni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuil")
    private int cuil;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "lugarNacimineto")
    private String lugarNacimineto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "estadoCivil")
    private String estadoCivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "carnetConducir")
    private String carnetConducir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "dispViajes")
    private String dispViajes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Collection<Formacionacademica> formacionacademicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Collection<Experienciaprofesional> experienciaprofesionalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Collection<Idiomas> idiomasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Collection<Formacioncomplementaria> formacioncomplementariaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Collection<ConvocatoriaPostulante> convocatoriaPostulanteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Collection<Referencia> referenciaCollection;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Integer idPersona, String apeyNom, int dni, int cuil, byte[] foto, String sexo, Date fechaNacimiento, String lugarNacimineto, String estadoCivil, String direccion, String telefono, String mail, String carnetConducir, String dispViajes) {
        this.idPersona = idPersona;
        this.apeyNom = apeyNom;
        this.dni = dni;
        this.cuil = cuil;
        this.foto = foto;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimineto = lugarNacimineto;
        this.estadoCivil = estadoCivil;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.carnetConducir = carnetConducir;
        this.dispViajes = dispViajes;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getApeyNom() {
        return apeyNom;
    }

    public void setApeyNom(String apeyNom) {
        this.apeyNom = apeyNom;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCuil() {
        return cuil;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimineto() {
        return lugarNacimineto;
    }

    public void setLugarNacimineto(String lugarNacimineto) {
        this.lugarNacimineto = lugarNacimineto;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCarnetConducir() {
        return carnetConducir;
    }

    public void setCarnetConducir(String carnetConducir) {
        this.carnetConducir = carnetConducir;
    }

    public String getDispViajes() {
        return dispViajes;
    }

    public void setDispViajes(String dispViajes) {
        this.dispViajes = dispViajes;
    }

    @XmlTransient
    public Collection<Formacionacademica> getFormacionacademicaCollection() {
        return formacionacademicaCollection;
    }

    public void setFormacionacademicaCollection(Collection<Formacionacademica> formacionacademicaCollection) {
        this.formacionacademicaCollection = formacionacademicaCollection;
    }

    @XmlTransient
    public Collection<Experienciaprofesional> getExperienciaprofesionalCollection() {
        return experienciaprofesionalCollection;
    }

    public void setExperienciaprofesionalCollection(Collection<Experienciaprofesional> experienciaprofesionalCollection) {
        this.experienciaprofesionalCollection = experienciaprofesionalCollection;
    }

    @XmlTransient
    public Collection<Idiomas> getIdiomasCollection() {
        return idiomasCollection;
    }

    public void setIdiomasCollection(Collection<Idiomas> idiomasCollection) {
        this.idiomasCollection = idiomasCollection;
    }

    @XmlTransient
    public Collection<Formacioncomplementaria> getFormacioncomplementariaCollection() {
        return formacioncomplementariaCollection;
    }

    public void setFormacioncomplementariaCollection(Collection<Formacioncomplementaria> formacioncomplementariaCollection) {
        this.formacioncomplementariaCollection = formacioncomplementariaCollection;
    }

    @XmlTransient
    public Collection<ConvocatoriaPostulante> getConvocatoriaPostulanteCollection() {
        return convocatoriaPostulanteCollection;
    }

    public void setConvocatoriaPostulanteCollection(Collection<ConvocatoriaPostulante> convocatoriaPostulanteCollection) {
        this.convocatoriaPostulanteCollection = convocatoriaPostulanteCollection;
    }

    @XmlTransient
    public Collection<Referencia> getReferenciaCollection() {
        return referenciaCollection;
    }

    public void setReferenciaCollection(Collection<Referencia> referenciaCollection) {
        this.referenciaCollection = referenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Persona[ idPersona=" + idPersona + " ]";
    }
    
}
