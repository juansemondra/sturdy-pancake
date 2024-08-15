package puj.desarrolloweb.proyecto.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany (mappedBy = "conductorRel")
    private List<RelacionBusRutaConductor> relacionBusRutaConductorLista;

    @Column(name = "cedula", nullable = false, unique = true)
    private Long cedula;

    @Column(name = "nombre", nullable = false)
    //@NotBlank(message = "no puede estar en blanco")
    private String nombre;

    @Column(name = "telefono", nullable = false)
    //@NotBlank(message = "no puede estar en blanco")
    private Long telefono;

    @Column(name = "direccion", nullable = false)
    //@NotBlank(message = "no puede estar en blanco")
    private String direccion;

    @Column(name = "buses_asignados", nullable = false)
    //@NotBlank(message = "no puede estar en blanco")
    private int buses_asignados;
}
