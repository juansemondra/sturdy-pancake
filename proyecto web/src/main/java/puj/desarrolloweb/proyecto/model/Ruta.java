package puj.desarrolloweb.proyecto.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany (mappedBy = "rutaRel")
    private List<RelacionBusRutaConductor> relacionBusRutaConductorLista;;

    @ManyToMany (mappedBy = "rutas")
    private List<Estacion> estaciones;

    @Column(name = "horario_de_inicio", nullable = false)
    //@NotBlank(message = "no puede estar en blanco")
    private int horario_de_inicio;

    @Column(name = "horario_de_final", nullable = false)
    //@NotBlank(message = "no puede estar en blanco")
    private int horario_de_final;
}
