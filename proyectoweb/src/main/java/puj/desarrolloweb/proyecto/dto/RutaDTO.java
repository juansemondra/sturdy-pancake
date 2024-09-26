package puj.desarrolloweb.proyecto.dto;

import java.time.LocalTime;
import java.util.List;

public class RutaDTO {
    private Long id;
    private String nombreRuta;
    private LocalTime horarioDeInicio;
    private LocalTime horarioDeFinal;
    private String diasDisponibles;
    private List<Long> estacionIds; 
    private List<Long> relacionBusRutaConductorIds; 

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public LocalTime getHorarioDeInicio() {
        return horarioDeInicio;
    }

    public void setHorarioDeInicio(LocalTime horarioDeInicio) {
        this.horarioDeInicio = horarioDeInicio;
    }

    public LocalTime getHorarioDeFinal() {
        return horarioDeFinal;
    }

    public void setHorarioDeFinal(LocalTime horarioDeFinal) {
        this.horarioDeFinal = horarioDeFinal;
    }

    public String getDiasDisponibles() {
        return diasDisponibles;
    }

    public void setDiasDisponibles(String diasDisponibles) {
        this.diasDisponibles = diasDisponibles;
    }

    public List<Long> getEstacionIds() {
        return estacionIds;
    }

    public void setEstacionIds(List<Long> estacionIds) {
        this.estacionIds = estacionIds;
    }

    public List<Long> getRelacionBusRutaConductorIds() {
        return relacionBusRutaConductorIds;
    }

    public void setRelacionBusRutaConductorIds(List<Long> relacionBusRutaConductorIds) {
        this.relacionBusRutaConductorIds = relacionBusRutaConductorIds;
    }
}