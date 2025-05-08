/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DaniMaja
 */
@Entity
@Table(name = "paquete_turistico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaqueteTuristico.findAll", query = "SELECT p FROM PaqueteTuristico p")
    , @NamedQuery(name = "PaqueteTuristico.findById", query = "SELECT p FROM PaqueteTuristico p WHERE p.id = :id")
    , @NamedQuery(name = "PaqueteTuristico.findByTitulo", query = "SELECT p FROM PaqueteTuristico p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "PaqueteTuristico.findByDescripcion", query = "SELECT p FROM PaqueteTuristico p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "PaqueteTuristico.findByFechaSalida", query = "SELECT p FROM PaqueteTuristico p WHERE p.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "PaqueteTuristico.findByDuracion", query = "SELECT p FROM PaqueteTuristico p WHERE p.duracion = :duracion")
    , @NamedQuery(name = "PaqueteTuristico.findByPrecio", query = "SELECT p FROM PaqueteTuristico p WHERE p.precio = :precio")
    , @NamedQuery(name = "PaqueteTuristico.findByServiciosIncluidos", query = "SELECT p FROM PaqueteTuristico p WHERE p.serviciosIncluidos = :serviciosIncluidos")})
public class PaqueteTuristico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @Column(name = "duracion")
    private int duracion;
    @Basic(optional = false)
    @Column(name = "precio")
    private float precio;
    @Basic(optional = false)
    @Column(name = "servicios_incluidos")
    private String serviciosIncluidos;
    @OneToMany(mappedBy = "idPaquete")
    private Collection<Promocion> promocionCollection;
    @OneToMany(mappedBy = "idPaquete")
    private Collection<Valoracion> valoracionCollection;
    @OneToMany(mappedBy = "idPaquete")
    private Collection<Reserva> reservaCollection;
    @JoinColumn(name = "id_destino", referencedColumnName = "id")
    @ManyToOne
    private Destino idDestino;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    @ManyToOne
    private ProveedorServicios idProveedor;

    public PaqueteTuristico() {
    }

    public PaqueteTuristico(Integer id) {
        this.id = id;
    }

    public PaqueteTuristico(Integer id, String titulo, String descripcion, Date fechaSalida, int duracion, float precio, String serviciosIncluidos) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaSalida = fechaSalida;
        this.duracion = duracion;
        this.precio = precio;
        this.serviciosIncluidos = serviciosIncluidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getServiciosIncluidos() {
        return serviciosIncluidos;
    }

    public void setServiciosIncluidos(String serviciosIncluidos) {
        this.serviciosIncluidos = serviciosIncluidos;
    }

    @XmlTransient
    public Collection<Promocion> getPromocionCollection() {
        return promocionCollection;
    }

    public void setPromocionCollection(Collection<Promocion> promocionCollection) {
        this.promocionCollection = promocionCollection;
    }

    @XmlTransient
    public Collection<Valoracion> getValoracionCollection() {
        return valoracionCollection;
    }

    public void setValoracionCollection(Collection<Valoracion> valoracionCollection) {
        this.valoracionCollection = valoracionCollection;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    public Destino getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Destino idDestino) {
        this.idDestino = idDestino;
    }

    public ProveedorServicios getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(ProveedorServicios idProveedor) {
        this.idProveedor = idProveedor;
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
        if (!(object instanceof PaqueteTuristico)) {
            return false;
        }
        PaqueteTuristico other = (PaqueteTuristico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PaqueteTuristico[ id=" + id + " ]";
    }
    
}
