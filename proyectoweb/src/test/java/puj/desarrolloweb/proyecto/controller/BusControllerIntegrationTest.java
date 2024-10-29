package puj.desarrolloweb.proyecto.controller;

//import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import puj.desarrolloweb.proyecto.repository.BusRepository;;;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("integration-testing")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class BusControllerIntegrationTest {
    
    @SuppressWarnings("unused")
    private final String SERVER_URL;

    @SuppressWarnings("unused")
    @Autowired
    private WebTestClient webTestClient;

    @SuppressWarnings("unused")
    @Autowired
    private BusRepository busRepository;

    public BusControllerIntegrationTest(@Value("${server.port}") int serverPort) {
        SERVER_URL = "http://localhost:" + serverPort;
    }

    @BeforeEach
    @SuppressWarnings("unused")
    void init(){
        
    }

}
