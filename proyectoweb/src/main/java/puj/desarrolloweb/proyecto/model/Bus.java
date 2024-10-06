package puj.desarrolloweb.proyecto.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "busRel", cascade = CascadeType.ALL)
    private List<RelacionBusRutaConductor> relacionBusRutaConductorLista;

    @Column(name = "placa", nullable = false, unique = true)
    private String placa;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    public Bus() {
        this.relacionBusRutaConductorLista = new ArrayList<>();
    }

    public Bus(String placa, String modelo) {
        this();
        this.placa = placa;
        this.modelo = modelo;
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