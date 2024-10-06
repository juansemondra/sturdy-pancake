package puj.desarrolloweb.proyecto.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "conductorRel", cascade = CascadeType.ALL)
    private List<RelacionBusRutaConductor> relacionBusRutaConductorLista;

    @Column(name = "cedula", nullable = false, unique = true)
    private Long cedula;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "telefono", nullable = false)
    private Long telefono;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "buses_asignados", nullable = false)
    private int buses_asignados;

    public Conductor() {
        this.relacionBusRutaConductorLista = new ArrayList<>();
        this.buses_asignados = 0;
    }

    public Conductor(Long cedula, String nombre, Long telefono, String direccion) {
        this();
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RelacionBusRutaConductor> getRelacionBusRutaConductorLista() {
        return relacionBusRutaConductorLista;
    }

    public void setRelacionBusRutaConductorLista(List<RelacionBusRutaConductor> relacionBusRutaConductorLista) {
        this.relacionBusRutaConductorLista = relacionBusRutaConductorLista;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getBuses_asignados() {
        return buses_asignados;
    }

    public void setBuses_asignados(int buses_asignados) {
        this.buses_asignados = buses_asignados;
    }

    public void addBRC(RelacionBusRutaConductor relacion) {
        this.relacionBusRutaConductorLista.add(relacion);
        this.buses_asignados = this.relacionBusRutaConductorLista.size(); // Increment buses_asignados when adding a relationship
    }
}