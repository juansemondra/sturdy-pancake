package puj.desarrolloweb.proyecto.dto;
import java.util.List;

public class BusDTO {
    private Long id;
    private String placa;
    private String modelo;
    private List<Long> relacionBusRutaConductorIds;  


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Long> getRelacionBusRutaConductorIds() {
        return relacionBusRutaConductorIds;
    }

    public void setRelacionBusRutaConductorIds(List<Long> relacionBusRutaConductorIds) {
        this.relacionBusRutaConductorIds = relacionBusRutaConductorIds;
    }
}