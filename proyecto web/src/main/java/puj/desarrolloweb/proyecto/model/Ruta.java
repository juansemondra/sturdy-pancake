package puj.desarrolloweb.proyecto.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_ruta", nullable = false)
    private String nombre_ruta;

    @OneToMany(mappedBy = "rutaRel")
    private List<RelacionBusRutaConductor> relacionBusRutaConductorLista;

    @ManyToMany(mappedBy = "rutas")
    private List<Estacion> estaciones;

    @Column(name = "horario_de_inicio", nullable = false)
    private int horario_de_inicio;

    @Column(name = "horario_de_final", nullable = false)
    private int horario_de_final;

    @Column(name = "dias_disponibles", nullable = false)
    private String dias_disponibles;

    public Ruta() {
        // Constructor vacío necesario para JPA
    }

    public Ruta(String nombre_ruta, String dias) {
        this.nombre_ruta = nombre_ruta;
        this.horario_de_inicio = 430;
        this.horario_de_final = 2300;
        this.dias_disponibles = dias;
        this.relacionBusRutaConductorLista = new ArrayList<>();
        this.estaciones = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_ruta() {
        return nombre_ruta;
    }

    public void setNombre_ruta(String nombre_ruta) {
        this.nombre_ruta = nombre_ruta;
    }

    public List<RelacionBusRutaConductor> getRelacionBusRutaConductorLista() {
        return relacionBusRutaConductorLista;
    }

    public void setRelacionBusRutaConductorLista(List<RelacionBusRutaConductor> relacionBusRutaConductorLista) {
        this.relacionBusRutaConductorLista = relacionBusRutaConductorLista;
    }

    public List<Estacion> getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(List<Estacion> estaciones) {
        this.estaciones = estaciones;
    }

    public int getHorario_de_inicio() {
        return horario_de_inicio;
    }

    public void setHorario_de_inicio(int horario_de_inicio) {
        this.horario_de_inicio = horario_de_inicio;
    }

    public int getHorario_de_final() {
        return horario_de_final;
    }

    public void setHorario_de_final(int horario_de_final) {
        this.horario_de_final = horario_de_final;
    }

    public String getDias_disponibles() {
        return dias_disponibles;
    }

    public void setDias_disponibles(String dias_disponibles) {
        this.dias_disponibles = dias_disponibles;
    }

    public void addEstacion(Estacion estacion) {
        this.estaciones.add(estacion);
    }

    public void addRelBRC(RelacionBusRutaConductor BRC) {
        this.relacionBusRutaConductorLista.add(BRC);
    }
}