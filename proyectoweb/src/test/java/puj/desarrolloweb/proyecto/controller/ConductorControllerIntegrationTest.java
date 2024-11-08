package puj.desarrolloweb.proyecto.controller;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import puj.desarrolloweb.proyecto.dto.ConductorDTO;
import puj.desarrolloweb.proyecto.dto.JwtAuthenticationResponse;
import puj.desarrolloweb.proyecto.dto.LoginDTO;
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

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles("integration-testing")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class ConductorControllerIntegrationTest {

    private String SERVER_URL;

    @LocalServerPort
    private int port;

    @Autowired
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

    private String jwtToken;

    @BeforeEach
    @SuppressWarnings("unused")
    void init() {
        SERVER_URL = "http://localhost:" + port;
        webTestClient = WebTestClient.bindToServer().baseUrl(SERVER_URL).build();

        // userRepository.deleteAll();
        // rutaRepository.deleteAll();
        // busRepository.deleteAll();
        // estacionRepository.deleteAll();
        // conductorRepository.deleteAll();
        // rbrcRepository.deleteAll();

        User user1 = new User("Juan", "Sanabria", "jsanabria@javeriana.edu.co", passwordEncoder.encode("sanabria123"),
                Role.COORDINADOR);
        users.add(user1);

        for (User temp : users)
            userRepository.save(temp);

        authenticateUser("jsanabria@javeriana.edu.co", "sanabria123");

        initEntities();
    }

@SuppressWarnings("null")
private void authenticateUser(String email, String password) {
        LoginDTO loginRequest = new LoginDTO(email, password);

        JwtAuthenticationResponse response = webTestClient.post()
                .uri(SERVER_URL + "/auth/login")
                .bodyValue(loginRequest)
                .exchange()
                .expectStatus().isOk()
                .expectBody(JwtAuthenticationResponse.class)
                .returnResult()
                .getResponseBody();

        this.jwtToken = "Bearer " + response.getToken();
    }

@SuppressWarnings("unused")
private void initEntities() {
        // Configuración inicial de datos de prueba
        Ruta ruta_2 = rutaRepository.save(new Ruta("2", "LMXJVSD"));
        Ruta ruta_1 = rutaRepository.save(new Ruta("1", "LMXJVSD"));
        Ruta ruta_3 = rutaRepository.save(new Ruta("3", "LMXJVSD"));
        Ruta ruta_4 = rutaRepository.save(new Ruta("4", "LMXJVSD"));

        Estacion calle63 = estacionRepository.save(new Estacion("Calle 63", "A"));
        Estacion calle57 = estacionRepository.save(new Estacion("Calle 57", "A"));
        Estacion marly = estacionRepository.save(new Estacion("Marly", "A"));
        Estacion calle45 = estacionRepository.save(new Estacion("Calle 45", "A"));
        Estacion calle39 = estacionRepository.save(new Estacion("Calle 39", "A"));
        Estacion calle34 = estacionRepository.save(new Estacion("Calle 34", "A"));

        ruta_1.addEstacion(marly);
        ruta_1.addEstacion(calle57);
        ruta_1.addEstacion(calle63);
        ruta_2.addEstacion(marly);
        ruta_2.addEstacion(calle45);
        ruta_3.addEstacion(calle39);
        ruta_3.addEstacion(calle34);

        Bus bus1 = busRepository.save(new Bus("ABC123", "BRT"));
        Bus bus2 = busRepository.save(new Bus("DEF456", "Volvo 7900"));
        Bus bus3 = busRepository.save(new Bus("GHI789", "Scania K320"));
        Bus bus4 = busRepository.save(new Bus("JKL012", "Mercedes-Benz O500"));

        Conductor conductor1 
                = conductorRepository.save(new Conductor(1023456789L, "Carlos Pérez", 3101234567L, "Calle 100 #15-20"));
        Conductor conductor2 
                = conductorRepository.save(new Conductor(1034567890L, "Luis Rodríguez", 3112345678L, "Carrera 11 #45-67"));
        Conductor conductor3 
                = conductorRepository.save(new Conductor(1045678901L, "Andrés Martínez", 3133456789L, "Avenida Suba #95-10"));
        Conductor conductor4 
                = conductorRepository.save(new Conductor(1056789012L, "Jorge Gómez", 3154567890L, "Carrera 7 #12-34"));


        RelacionBusRutaConductor rbrc1 = rbrcRepository.save(new RelacionBusRutaConductor(bus1, ruta_1, conductor1));
        RelacionBusRutaConductor rbrc4 = rbrcRepository.save(new RelacionBusRutaConductor(bus1, ruta_1, conductor2));
        RelacionBusRutaConductor rbrc2 = rbrcRepository.save(new RelacionBusRutaConductor(bus2, ruta_2, conductor1));
        RelacionBusRutaConductor rbrc3 = rbrcRepository.save(new RelacionBusRutaConductor(bus2, ruta_3, conductor2));
        RelacionBusRutaConductor rbrc5 = rbrcRepository.save(new RelacionBusRutaConductor(bus4, ruta_3, conductor4));
        RelacionBusRutaConductor rbrc6 = rbrcRepository.save(new RelacionBusRutaConductor(bus3, ruta_2, conductor3));

    }

    private WebTestClient.RequestHeadersSpec<?> authenticatedRequest(WebTestClient.RequestHeadersSpec<?> request) {
        return request.header(HttpHeaders.AUTHORIZATION, jwtToken);
    }

    @Test
    void getConductorById() {
        Conductor conductor = conductorRepository.findAll().get(0);

        authenticatedRequest(
                webTestClient.get()
                        .uri(SERVER_URL + "/api/conductores/" + conductor.getId()))
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

        authenticatedRequest(
                webTestClient.post()
                        .uri(SERVER_URL + "/api/conductores")
                        .bodyValue(newConductor))
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

        authenticatedRequest(
                webTestClient.put()
                        .uri(SERVER_URL + "/api/conductores/" + conductor.getId())
                        .bodyValue(conductorDTO))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ConductorDTO.class)
                .value(response -> assertEquals(3221234567L, response.getTelefono()));
    }

    @Test
    void deleteConductor() {
        Conductor conductor = conductorRepository.findAll().get(0);

        authenticatedRequest(
                webTestClient.delete()
                        .uri(SERVER_URL + "/api/conductores/" + conductor.getId()))
                .exchange()
                .expectStatus().isNoContent();

        authenticatedRequest(
                webTestClient.get()
                        .uri(SERVER_URL + "/api/conductores/" + conductor.getId()))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void asignarBusToConductor() {
        Conductor conductor = conductorRepository.findAll().get(0);
        Bus bus = busRepository.findAll().get(0);
        String diasAsignados = "LMXJ";

        authenticatedRequest(
                webTestClient.post()
                        .uri(SERVER_URL + "/api/conductores/" + conductor.getId() + "/asignar-bus?busId=" + bus.getId()
                                + "&diasAsignados=" + diasAsignados))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ConductorDTO.class)
                .value(response -> assertEquals(conductor.getNombre(), response.getNombre()));
    }

    @Test
    void getBusesRutasHorariosByConductor() {
        Conductor conductor = conductorRepository.findAll().get(0);

        authenticatedRequest(
                webTestClient.get()
                        .uri(SERVER_URL + "/api/conductores/" + conductor.getId() + "/buses-rutas-horarios"))
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(RelacionBusRutaConductor.class)
                .value(response -> assertEquals(1, response.size()));
    }

    @Test
    void getConductorNotFound() {
        authenticatedRequest(
                webTestClient.get()
                        .uri(SERVER_URL + "/api/conductores/999"))
                .exchange()
                .expectStatus().isNotFound();
    }
}