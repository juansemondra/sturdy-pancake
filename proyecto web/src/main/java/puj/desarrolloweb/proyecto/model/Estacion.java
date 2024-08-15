package puj.desarrolloweb.proyecto.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Estacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    //@NotBlank(message = "no puede estar en blanco")
    private String nombre;

    @Column(name = "direccion", nullable = false)
    //@NotBlank(message = "no puede estar en blanco")
    private String direccion;

    // _  
    @ManyToMany
    @JoinTable(name = "Relacion_Estacion_Ruta",
    joinColumns = @JoinColumn(name = "ruta_codigo"),
    inverseJoinColumns = @JoinColumn(name = "estacion_codigo"))
    private List<Ruta> rutas;

}
