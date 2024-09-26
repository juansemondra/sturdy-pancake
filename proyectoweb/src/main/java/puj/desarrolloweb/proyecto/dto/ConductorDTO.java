package puj.desarrolloweb.proyecto.dto;

import java.util.List;

public class ConductorDTO {
    private Long id;
    private Long cedula;
    private String nombre;
    private Long telefono;
    private String direccion;
    private int busesAsignados;
    private List<Long> relacionBusRutaConductorIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getBusesAsignados() {
        return busesAsignados;
    }

    public void setBusesAsignados(int busesAsignados) {
        this.busesAsignados = busesAsignados;
    }

    public List<Long> getRelacionBusRutaConductorIds() {
        return relacionBusRutaConductorIds;
    }

    public void setRelacionBusRutaConductorIds(List<Long> relacionBusRutaConductorIds) {
        this.relacionBusRutaConductorIds = relacionBusRutaConductorIds;
    }
}
