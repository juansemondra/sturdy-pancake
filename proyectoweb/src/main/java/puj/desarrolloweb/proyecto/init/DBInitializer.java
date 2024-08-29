package puj.desarrolloweb.proyecto.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import puj.desarrolloweb.proyecto.model.*;
import puj.desarrolloweb.proyecto.repository.*;

@Component
public class DBInitializer implements CommandLineRunner {

    @Autowired
    private RutaRepository rutaRepository;
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private ConductorRepository conductorRepository;
    @Autowired
    private EstacionRepository estacionRepository;
    @Autowired
    private RelacionBusRutaConductorRepository relacionBusRutaConductorRepository;

    @Override
    public void run(String... args) throws Exception {
        // Define and save Ruta entities
        Ruta ruta1 = new Ruta("Ruta 1", "Lunes, Miércoles, Viernes");
        Ruta ruta2 = new Ruta("Ruta 2", "Martes, Jueves, Sábado");
        Ruta ruta3 = new Ruta("Ruta 3", "Lunes a Viernes");
        rutaRepository.saveAll(Arrays.asList(ruta1, ruta2, ruta3));

        // Define and save Bus entities
        Bus bus1 = new Bus("ABC123", "Modelo 1");
        Bus bus2 = new Bus("DEF456", "Modelo 2");
        Bus bus3 = new Bus("GHI789", "Modelo 3");
        busRepository.saveAll(Arrays.asList(bus1, bus2, bus3));

        // Define and save Conductor entities
        Conductor conductor1 = new Conductor(12345678L, "Juan Pérez", 3001234567L, "Calle 1");
        Conductor conductor2 = new Conductor(87654321L, "María Gómez", 3007654321L, "Calle 2");
        Conductor conductor3 = new Conductor(11223344L, "Pedro López", 3001122334L, "Calle 3");
        conductorRepository.saveAll(Arrays.asList(conductor1, conductor2, conductor3));

        // Define and save Estacion entities
        Estacion estacion1 = new Estacion("Estacion 1", "Zona 1");
        Estacion estacion2 = new Estacion("Estacion 2", "Zona 2");
        Estacion estacion3 = new Estacion("Estacion 3", "Zona 3");
        estacionRepository.saveAll(Arrays.asList(estacion1, estacion2, estacion3));

        // Establish many-to-many relationship between Estacion and Ruta
        estacion1.addRuta(ruta1);
        estacion2.addRuta(ruta2);
        estacion3.addRuta(ruta3);
        estacionRepository.saveAll(Arrays.asList(estacion1, estacion2, estacion3));

        // Define and save RelacionBusRutaConductor entities
        RelacionBusRutaConductor relacion1 = new RelacionBusRutaConductor(bus1, ruta1, conductor1);
        RelacionBusRutaConductor relacion2 = new RelacionBusRutaConductor(bus2, ruta2, conductor2);
        RelacionBusRutaConductor relacion3 = new RelacionBusRutaConductor(bus3, ruta3, conductor3);
        relacionBusRutaConductorRepository.saveAll(Arrays.asList(relacion1, relacion2, relacion3));

        //print finished
        System.out.println("Finished initializing database");
    }
}