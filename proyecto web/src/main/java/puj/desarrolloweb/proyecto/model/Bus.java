package puj.desarrolloweb.proyecto.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;

@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "busRel")
    private List<RelacionBusRutaConductor> relacionBusRutaConductorLista;

    @Column(name = "placa", nullable = false, unique = true)
    private String placa;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    public Bus() {
        // Constructor vacío necesario para JPA
    }

    public Bus(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.relacionBusRutaConductorLista = new ArrayList<>();
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void addBRC(RelacionBusRutaConductor BRC) {
        this.relacionBusRutaConductorLista.add(BRC);
    }
}
