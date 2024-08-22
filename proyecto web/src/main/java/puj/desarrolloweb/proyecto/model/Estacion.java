package puj.desarrolloweb.proyecto.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Estacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "zona", nullable = false)
    private String zona;

    @ManyToMany
    @JoinTable(
        name = "Relacion_Estacion_Ruta",
        joinColumns = @JoinColumn(name = "estacion_codigo"),
        inverseJoinColumns = @JoinColumn(name = "ruta_codigo")
    )
    private List<Ruta> rutas;

    public Estacion() {
        // Constructor vacío necesario para JPA
    }

    public Estacion(String nombre, String zona) {
        this.nombre = nombre;
        this.zona = zona;
        this.rutas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public List<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
    }

    public void addRuta(Ruta ruta) {
        this.rutas.add(ruta);
    }
}

