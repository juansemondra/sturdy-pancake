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
    private Byte fecha_disponible;
}
