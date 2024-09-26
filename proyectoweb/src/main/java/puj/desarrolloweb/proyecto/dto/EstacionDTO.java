package puj.desarrolloweb.proyecto.dto;

import java.util.List;

public class EstacionDTO {
    private Long id;
    private String nombre;
    private String zona;
    private List<Long> rutaIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public List<Long> getRutaIds() {
        return rutaIds;
    }

    public void setRutaIds(List<Long> rutaIds) {
        this.rutaIds = rutaIds;
    }
}