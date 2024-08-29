package puj.desarrolloweb.proyecto.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_ruta", nullable = false)
    private String nombre_ruta;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rutaRel", cascade = CascadeType.ALL)
    private List<RelacionBusRutaConductor> relacionBusRutaConductorLista;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        name = "Relacion_Estacion_Ruta",
        joinColumns = @JoinColumn(name = "ruta_codigo"),
        inverseJoinColumns = @JoinColumn(name = "estacion_codigo")
    )
    private List<Estacion> estaciones;

    @Column(name = "horario_de_inicio", nullable = false)
    private LocalTime horario_de_inicio;

    @Column(name = "horario_de_final", nullable = false)
    private LocalTime horario_de_final;

    @Column(name = "dias_disponibles", nullable = false)
    private String dias_disponibles;

    public Ruta() {
        this.relacionBusRutaConductorLista = new ArrayList<>();
        this.estaciones = new ArrayList<>();
    }

    public Ruta(String nombre_ruta, String dias) {
        this();
        this.nombre_ruta = nombre_ruta;
        this.horario_de_inicio = LocalTime.of(4, 30);
        this.horario_de_final = LocalTime.of(23, 0);
        this.dias_disponibles = dias;
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

    public LocalTime getHorario_de_inicio() {
        return horario_de_inicio;
    }

    public void setHorario_de_inicio(LocalTime horario_de_inicio) {
        this.horario_de_inicio = horario_de_inicio;
    }

    public LocalTime getHorario_de_final() {
        return horario_de_final;
    }

    public void setHorario_de_final(LocalTime horario_de_final) {
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
        estacion.addRuta(this);
    }

    public void addBRC(RelacionBusRutaConductor BRC) {
        this.relacionBusRutaConductorLista.add(BRC);
    }
}