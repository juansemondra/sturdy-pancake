package puj.desarrolloweb.proyecto.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import puj.desarrolloweb.proyecto.dto.ConductorDTO;
import puj.desarrolloweb.proyecto.model.Bus;
import puj.desarrolloweb.proyecto.model.Conductor;
import puj.desarrolloweb.proyecto.model.Estacion;
import puj.desarrolloweb.proyecto.model.RelacionBusRutaConductor;
import puj.desarrolloweb.proyecto.model.Role;
import puj.desarrolloweb.proyecto.model.Ruta;
import puj.desarrolloweb.proyecto.model.User;
import puj.desarrolloweb.proyecto.repository.BusRepository;
import puj.desarrolloweb.proyecto.repository.ConductorRepository;
import puj.desarrolloweb.proyecto.repository.EstacionRepository;
import puj.desarrolloweb.proyecto.repository.RelacionBusRutaConductorRepository;
import puj.desarrolloweb.proyecto.repository.RutaRepository;
import puj.desarrolloweb.proyecto.repository.UserRepository;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles("integration-testing")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class ConductorControllerIntegrationTest {

    private String SERVER_URL;

    @LocalServerPort
    private int port;

    private WebTestClient webTestClient;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private ConductorRepository conductorRepository;

    @Autowired
    private EstacionRepository estacionRepository;

    @Autowired
    private RelacionBusRutaConductorRepository rbrcRepository;

    @Autowired 
    private RutaRepository rutaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> users = new ArrayList<>();
    public List<Bus> buses = new ArrayList<>();
    public List<Conductor> conductores = new ArrayList<>();
    public List<Estacion> estaciones = new ArrayList<>();
    public List<Ruta> rutas = new ArrayList<>();
    public List<RelacionBusRutaConductor> relaciones = new ArrayList<>();

    public ConductorControllerIntegrationTest(@Value("${server.port:8081}") int serverPort) {
        port = serverPort;
        this.SERVER_URL = "http://localhost:" + port;
    }

    @BeforeEach
    void init() {

        /*userRepository.deleteAll();
        rutaRepository.deleteAll();
        busRepository.deleteAll();
        estacionRepository.deleteAll();
        conductorRepository.deleteAll();
        rbrcRepository.deleteAll();*/

        // Configuración inicial de datos (sin modificaciones)
        User user1 = new User("Juan", "Sanabria", "jsanabria@javeriana.edu.co", passwordEncoder.encode("sanabria123"), Role.COORDINADOR);
        User user2 = new User("Maria", "Rodriguez", "mrodriguez@javeriana.edu.co", passwordEncoder.encode("mrodriguez123"), Role.ADMIN_RUTAS);
        User user3 = new User("Carlos", "Gomez", "cgomez@javeriana.edu.co", passwordEncoder.encode("carlosgomez123"), Role.PASAJERO);

        Ruta ruta_1 = new Ruta("1", "LMXJVSD");
        Ruta ruta_2 = new Ruta("2", "LMXJVSD");
        Ruta ruta_3 = new Ruta("3", "LMXJVSD");
        Ruta ruta_4 = new Ruta("4", "LMXJVSD");

        Bus bus1 = new Bus("ABC123", "BRT");
        Bus bus2 = new Bus("DEF456", "Volvo 7900");
        Bus bus3 = new Bus("GHI789", "Scania K320");
        Bus bus4 = new Bus("JKL012", "Mercedes-Benz O500");

        Conductor conductor1 = new Conductor(1023456789L, "Carlos Pérez", 3101234567L, "Calle 100 #15-20");
        Conductor conductor2 = new Conductor(1034567890L, "Luis Rodríguez", 3112345678L, "Carrera 11 #45-67");
        Conductor conductor3 = new Conductor(1045678901L, "Andrés Martínez", 3133456789L, "Avenida Suba #95-10");
        Conductor conductor4 = new Conductor(1056789012L, "Jorge Gómez", 3154567890L, "Carrera 7 #12-34");

        Estacion calle63 = new Estacion("Calle 63", "A");
        Estacion calle57 = new Estacion("Calle 57", "A");
        Estacion marly = new Estacion("Marly", "A");
        Estacion calle45 = new Estacion("Calle 45", "A");
        Estacion calle39 = new Estacion("Calle 39", "A");
        Estacion calle34 = new Estacion("Calle 34", "A");

        ruta_1.addEstacion(marly);
        ruta_1.addEstacion(calle57);
        ruta_1.addEstacion(calle63);
        ruta_2.addEstacion(marly);
        ruta_2.addEstacion(calle45);
        ruta_3.addEstacion(calle39);
        ruta_3.addEstacion(calle34);

        RelacionBusRutaConductor rbrc1 = new RelacionBusRutaConductor(bus1, ruta_1, conductor1);
        RelacionBusRutaConductor rbrc4 = new RelacionBusRutaConductor(bus1, ruta_1, conductor2);
        RelacionBusRutaConductor rbrc2 = new RelacionBusRutaConductor(bus2, ruta_2, conductor1);
        RelacionBusRutaConductor rbrc3 = new RelacionBusRutaConductor(bus2, ruta_3, conductor2);
        RelacionBusRutaConductor rbrc5 = new RelacionBusRutaConductor(bus4, ruta_3, conductor4);
        RelacionBusRutaConductor rbrc6 = new RelacionBusRutaConductor(bus3, ruta_2, conductor3);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        rutas.add(ruta_1);
        rutas.add(ruta_2);
        rutas.add(ruta_3);
        rutas.add(ruta_4);
        buses.add(bus1);
        buses.add(bus2);
        buses.add(bus3);
        buses.add(bus4);
        conductores.add(conductor1);
        conductores.add(conductor2);
        conductores.add(conductor3);
        conductores.add(conductor4);
        estaciones.add(calle63);
        estaciones.add(calle57);
        estaciones.add(marly);
        estaciones.add(calle45);
        estaciones.add(calle39);
        estaciones.add(calle34);
        relaciones.add(rbrc6);
        relaciones.add(rbrc5);
        relaciones.add(rbrc4);
        relaciones.add(rbrc3);
        relaciones.add(rbrc2);
        relaciones.add(rbrc1);

        for (User temp: users) userRepository.save(temp);
        for (Ruta temp: rutas) rutaRepository.save(temp);
        for (Bus temp: buses) busRepository.save(temp);
        for (Estacion temp: estaciones) estacionRepository.save(temp);
        for (Conductor temp: conductores) conductorRepository.save(temp);
        for (RelacionBusRutaConductor temp: relaciones) rbrcRepository.save(temp);

    }

    @AfterEach
    void del(){
        userRepository.deleteAll();
        rutaRepository.deleteAll();
        busRepository.deleteAll();
        estacionRepository.deleteAll();
        conductorRepository.deleteAll();
        rbrcRepository.deleteAll();
    }

    @Test
    void getAllConductores() {
        webTestClient.get()
                .uri(SERVER_URL + "/api/conductores")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ConductorDTO.class)
                .value(conductores -> assertEquals(4, conductores.size()));
    }


    @Test
    void getConductorById() {
        Conductor conductor = conductorRepository.findAll().get(0);

        webTestClient.get()
                .uri(SERVER_URL + "/api/conductores/" + conductor.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(ConductorDTO.class)
                .value(response -> assertEquals(conductor.getNombre(), response.getNombre()));
    }

    @Test
    void createConductor() {
        ConductorDTO newConductor = new ConductorDTO();
        newConductor.setCedula(123456789L);
        newConductor.setNombre("Ana Torres");
        newConductor.setTelefono(3171234567L);
        newConductor.setDireccion("Calle 50 #10-30");

        webTestClient.post()
                .uri(SERVER_URL + "/api/conductores")
                .bodyValue(newConductor)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.OK)
                .expectBody(ConductorDTO.class)
                .value(conductor -> assertEquals("Ana Torres", conductor.getNombre()));
    }

    @Test
    void updateConductor() {
        Conductor conductor = conductorRepository.findAll().get(0);
        conductor.setTelefono(3221234567L);

        ConductorDTO conductorDTO = new ConductorDTO();
        conductorDTO.setTelefono(3221234567L);

        webTestClient.put()
                .uri(SERVER_URL + "/api/conductores/" + conductor.getId())
                .bodyValue(conductorDTO)
                .exchange()
                .expectStatus().isOk()
                .expectBody(ConductorDTO.class)
                .value(response -> assertEquals(3221234567L, response.getTelefono()));
    }

    @Test
    void deleteConductor() {
        Conductor conductor = conductorRepository.findAll().get(0);

        webTestClient.delete()
                .uri(SERVER_URL + "/api/conductores/" + conductor.getId())
                .exchange()
                .expectStatus().isNoContent();

        webTestClient.get()
                .uri(SERVER_URL + "/api/conductores/" + conductor.getId())
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void asignarBusToConductor() {
        Conductor conductor = conductorRepository.findAll().get(0);
        Bus bus = busRepository.findAll().get(0);
        String diasAsignados = "LMXJ";

        webTestClient.post()
                .uri(SERVER_URL + "/api/conductores/" + conductor.getId() + "/asignar-bus?busId=" + bus.getId() + "&diasAsignados=" + diasAsignados)
                .exchange()
                .expectStatus().isOk()
                .expectBody(ConductorDTO.class)
                .value(response -> assertEquals(conductor.getNombre(), response.getNombre()));
    }

    @Test
    void getBusesRutasHorariosByConductor() {
        Conductor conductor = conductorRepository.findAll().get(0);

        webTestClient.get()
                .uri(SERVER_URL + "/api/conductores/" + conductor.getId() + "/buses-rutas-horarios")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(RelacionBusRutaConductor.class)
                .value(response -> assertEquals(1, response.size()));
    }

    @Test
    void getConductorNotFound() {
        webTestClient.get()
                .uri(SERVER_URL + "/api/conductores/999")
                .exchange()
                .expectStatus().isNotFound();
    }
}