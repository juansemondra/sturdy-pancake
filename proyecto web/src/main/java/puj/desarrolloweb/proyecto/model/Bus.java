package puj.desarrolloweb.proyecto.model;

import java.util.List;

import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;

@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany (mappedBy = "busRel")
    private List<RelacionBusRutaConductor> relacionBusRutaConductorLista;


    @Column(name = "placa", nullable = false,  unique = true)
    //@NotBlank(message = "no puede estar en blanco")
    private String placa;

    @Column(name = "modelo", nullable = false)
    //@NotBlank(message = "no puede estar en blanco")
    private String modelo;

}
