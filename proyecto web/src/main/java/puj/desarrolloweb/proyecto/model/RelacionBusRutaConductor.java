package puj.desarrolloweb.proyecto.model;

import jakarta.persistence.*;

@Entity
public class RelacionBusRutaConductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ruta_id")
    private Ruta rutaRel;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bus_id")
    private Bus busRel;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "conductor_id")
    private Conductor conductorRel;

    @Column(name = "fecha_disponible", nullable = false)
    private String fecha_disponible;

    public RelacionBusRutaConductor() {
        // Constructor vacío necesario para JPA
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ruta getRutaRel() {
        return rutaRel;
    }

    public void setRutaRel(Ruta rutaRel) {
        this.rutaRel = rutaRel;
    }

    public Bus getBusRel() {
        return busRel;
    }

    public void setBusRel(Bus busRel) {
        this.busRel = busRel;
    }

    public Conductor getConductorRel() {
        return conductorRel;
    }

    public void setConductorRel(Conductor conductorRel) {
        this.conductorRel = conductorRel;
    }

    public String getFecha_disponible() {
        return fecha_disponible;
    }

    public void setFecha_disponible(String fecha_disponible) {
        this.fecha_disponible = fecha_disponible;
    }
}
