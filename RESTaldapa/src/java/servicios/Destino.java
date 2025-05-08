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
@Table(name = "destino")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destino.findAll", query = "SELECT d FROM Destino d")
    , @NamedQuery(name = "Destino.findById", query = "SELECT d FROM Destino d WHERE d.id = :id")
    , @NamedQuery(name = "Destino.findByNombre", query = "SELECT d FROM Destino d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Destino.findByPais", query = "SELECT d FROM Destino d WHERE d.pais = :pais")
    , @NamedQuery(name = "Destino.findByTipo", query = "SELECT d FROM Destino d WHERE d.tipo = :tipo")
    , @NamedQuery(name = "Destino.findByTemporada", query = "SELECT d FROM Destino d WHERE d.temporada = :temporada")
    , @NamedQuery(name = "Destino.findByDescripcion", query = "SELECT d FROM Destino d WHERE d.descripcion = :descripcion")})
public class Destino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "temporada")
    private String temporada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idDestino")
    private Collection<PaqueteTuristico> paqueteTuristicoCollection;

    public Destino() {
    }

    public Destino(Integer id) {
        this.id = id;
    }

    public Destino(Integer id, String nombre, String pais, String tipo, String temporada, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.tipo = tipo;
        this.temporada = temporada;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof Destino)) {
            return false;
        }
        Destino other = (Destino) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servicios.Destino[ id=" + id + " ]";
    }
    
}
