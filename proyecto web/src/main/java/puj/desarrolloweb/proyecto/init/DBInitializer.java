package puj.desarrolloweb.proyecto.init;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import puj.desarrolloweb.proyecto.model.Bus;
import puj.desarrolloweb.proyecto.model.Conductor;
import puj.desarrolloweb.proyecto.model.Estacion;
import puj.desarrolloweb.proyecto.model.RelacionBusRutaConductor;
import puj.desarrolloweb.proyecto.model.Ruta;

import puj.desarrolloweb.proyecto.repository.BusRepository;
import puj.desarrolloweb.proyecto.repository.ConductorRepository;
import puj.desarrolloweb.proyecto.repository.EstacionRepository;
import puj.desarrolloweb.proyecto.repository.RelacionBusRutaConductorRepository;
import puj.desarrolloweb.proyecto.repository.RutaRepository;

@Component
public class DBInitializer implements CommandLineRunner {
 
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private ConductorRepository conductorRepository;
    @Autowired
    private EstacionRepository estacionRepository;
    @Autowired
    private RelacionBusRutaConductorRepository relacionBusRutaConductorRepository;
    @Autowired
    private RutaRepository rutaRepository;

    @Override
    public void run(String... args) throws Exception {
        /*List<Bus> buses;
        List<Conductor> conductores;
        List<Estacion> estaciones;
        List<Ruta> rutas;
        List<RelacionBusRutaConductor> relacionBusRutaConductores;


        busRepository.saveAll(buses);
        conductorRepository.saveAll(conductores);
        estacionRepository.saveAll(estaciones);
        rutaRepository.saveAll(rutas);
        relacionBusRutaConductorRepository.saveAll(relacionBusRutaConductores);*/


    }
}
