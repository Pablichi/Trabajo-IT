/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author DaniMaja
 */
@Entity
@Table(name = "proveedor_servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProveedorServicios.findAll", query = "SELECT p FROM ProveedorServicios p")
    , @NamedQuery(name = "ProveedorServicios.findById", query = "SELECT p FROM ProveedorServicios p WHERE p.id = :id")
    , @NamedQuery(name = "ProveedorServicios.findByNombreEmpresa", query = "SELECT p FROM ProveedorServicios p WHERE p.nombreEmpresa = :nombreEmpresa")
    , @NamedQuery(name = "ProveedorServicios.findByTipoServicios", query = "SELECT p FROM ProveedorServicios p WHERE p.tipoServicios = :tipoServicios")
    , @NamedQuery(name = "ProveedorServicios.findByContacto", query = "SELECT p FROM ProveedorServicios p WHERE p.contacto = :contacto")
    , @NamedQuery(name = "ProveedorServicios.findByPais", query = "SELECT p FROM ProveedorServicios p WHERE p.pais = :pais")
    , @NamedQuery(name = "ProveedorServicios.findByComentariosReputacion", query = "SELECT p FROM ProveedorServicios p WHERE p.comentariosReputacion = :comentariosReputacion")})
public class ProveedorServicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_servicios")
    private String tipoServicios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contacto")
    private String contacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "comentarios_reputacion")
    private String comentariosReputacion;
    @OneToMany(mappedBy = "idProveedor")
    private Collection<PaqueteTuristico> paqueteTuristicoCollection;

    public ProveedorServicios() {
    }

    public ProveedorServicios(Integer id) {
        this.id = id;
    }

    public ProveedorServicios(Integer id, String nombreEmpresa, String tipoServicios, String contacto, String pais, String comentariosReputacion) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.tipoServicios = tipoServicios;
        this.contacto = contacto;
        this.pais = pais;
        this.comentariosReputacion = comentariosReputacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTipoServicios() {
        return tipoServicios;
    }

    public void setTipoServicios(String tipoServicios) {
        this.tipoServicios = tipoServicios;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getComentariosReputacion() {
        return comentariosReputacion;
    }

    public void setComentariosReputacion(String comentariosReputacion) {
        this.comentariosReputacion = comentariosReputacion;
    }

    @XmlTransient
    public Collection<PaqueteTuristico> getPaqueteTuristicoCollection() {
        return paqueteTuristicoCollection;
    }

    public void setPaqueteTuristicoCollection(Collection<PaqueteTuristico> paqueteTuristicoCollection) {
        this.paqueteTuristicoCollection = paqueteTuristicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveedorServicios)) {
            return false;
        }
        ProveedorServicios other = (ProveedorServicios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servicios.ProveedorServicios[ id=" + id + " ]";
    }
    
}
