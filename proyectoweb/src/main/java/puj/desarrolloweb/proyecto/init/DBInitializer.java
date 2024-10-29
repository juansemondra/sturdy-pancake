package puj.desarrolloweb.proyecto.init;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
 
    @SuppressWarnings("unused")
    @Autowired
    private SessionFactory sessionFactory;

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

    public List<Bus> buses = new ArrayList<>();
    public List<Conductor> conductores = new ArrayList<>();
    public List<Estacion> estaciones = new ArrayList<>();
    public List<Ruta> rutas = new ArrayList<>();
    public List<RelacionBusRutaConductor> relaciones = new ArrayList<>();

    @Override
    @Transactional
    @SuppressWarnings("CallToPrintStackTrace")
    public void run(String... args) throws Exception {


        //Init Rutas
        Ruta ruta_1 = new Ruta("1", "LMXJVSD");
        Ruta ruta_2 = new Ruta("2", "LMXJVSD");
        Ruta ruta_3 = new Ruta("3", "LMXJVSD");
        Ruta ruta_4 = new Ruta("4", "LMXJVSD");
        Ruta ruta_5 = new Ruta("5", "LMXJVSD");
        Ruta ruta_6 = new Ruta("6", "LMXJVSD");
        Ruta ruta_7 = new Ruta("7", "LMXJVSD");
        Ruta ruta_8 = new Ruta("8", "LMXJVSD");
        Ruta ruta_A52 = new Ruta("A52", "LMXJVSD");
        Ruta ruta_A60 = new Ruta("A60", "LMXJVSD");
        Ruta ruta_A61 = new Ruta("A61", "LMXJVSD");
        Ruta ruta_B10 = new Ruta("B10", "LMXJVSD");
        Ruta ruta_B11 = new Ruta("B11", "LMXJVSD");
        Ruta ruta_B12 = new Ruta("B12", "LMXJVSD");
        Ruta ruta_B13 = new Ruta("B13", "LMXJVSD");
        Ruta ruta_B16 = new Ruta("B16", "LMXJVSD");
        Ruta ruta_B18 = new Ruta("B18", "LMXJVSD");
        Ruta ruta_B23 = new Ruta("B23", "LMXJVSD");
        Ruta ruta_B26 = new Ruta("B26", "LMXJVSD");
        Ruta ruta_B27 = new Ruta("B27", "LMXJVSD");
        Ruta ruta_B28 = new Ruta("B28", "LMXJVSD");
        Ruta ruta_B46 = new Ruta("B46", "LMXJVSD");
        Ruta ruta_B50 = new Ruta("B50", "LMXJVSD");
        Ruta ruta_B55 = new Ruta("B55", "LMXJVSD");
        Ruta ruta_B72 = new Ruta("B72", "LMXJVSD");
        Ruta ruta_B74 = new Ruta("B74", "LMXJVSD");
        Ruta ruta_B75 = new Ruta("B75", "LMXJVSD");
        Ruta ruta_C15 = new Ruta("C15", "LMXJVSD");
        Ruta ruta_C17 = new Ruta("C17", "LMXJVSD");
        Ruta ruta_C19 = new Ruta("C19", "LMXJVSD");
        Ruta ruta_C25 = new Ruta("C25", "LMXJVSD");
        Ruta ruta_C30 = new Ruta("C30", "LMXJVSD");
        Ruta ruta_C50 = new Ruta("C50", "LMXJVSD");
        Ruta ruta_C73 = new Ruta("C73", "LMXJVSD");
        Ruta ruta_C84 = new Ruta("C84", "LMXJVSD");
        Ruta ruta_D10 = new Ruta("D10", "LMXJVSD");
        Ruta ruta_D21 = new Ruta("D21", "LMXJVSD");
        Ruta ruta_D22 = new Ruta("D22", "LMXJVSD");
        Ruta ruta_D24 = new Ruta("D24", "LMXJVSD");
        Ruta ruta_D55 = new Ruta("D55", "LMXJVSD");
        Ruta ruta_D81 = new Ruta("D81", "LMXJVSD");
        Ruta ruta_E32 = new Ruta("E32", "LMXJVSD");
        Ruta ruta_E42 = new Ruta("E42", "LMXJVSD");
        Ruta ruta_F19 = new Ruta("F19", "LMXJVSD");
        Ruta ruta_F23 = new Ruta("F23", "LMXJVSD");
        Ruta ruta_F26 = new Ruta("F26", "LMXJVSD");
        Ruta ruta_F28 = new Ruta("F28", "LMXJVSD");
        Ruta ruta_F32 = new Ruta("F32", "LMXJVSD");
        Ruta ruta_F51 = new Ruta("F51", "LMXJVSD");
        Ruta ruta_F60 = new Ruta("F60", "LMXJVSD");
        Ruta ruta_F61 = new Ruta("F61", "LMXJVSD");
        Ruta ruta_G11 = new Ruta("G11", "LMXJVSD");
        Ruta ruta_G12 = new Ruta("G12", "LMXJVSD");
        Ruta ruta_G15 = new Ruta("G15", "LMXJVSD");
        Ruta ruta_G22 = new Ruta("G22", "LMXJVSD");
        Ruta ruta_G30 = new Ruta("G30", "LMXJVSD");
        Ruta ruta_G41 = new Ruta("G41", "LMXJVSD");
        Ruta ruta_G42 = new Ruta("G42", "LMXJVSD");
        Ruta ruta_G43 = new Ruta("G43", "LMXJVSD");
        Ruta ruta_G45 = new Ruta("G45", "LMXJVSD");
        Ruta ruta_G46 = new Ruta("G46", "LMXJVSD");
        Ruta ruta_G47 = new Ruta("G47", "LMXJVSD");
        Ruta ruta_G52 = new Ruta("G52", "LMXJVSD");
        Ruta ruta_H13 = new Ruta("H13", "LMXJVSD");
        Ruta ruta_H15 = new Ruta("H15", "LMXJVSD");
        Ruta ruta_H17 = new Ruta("H17", "LMXJVSD");
        Ruta ruta_H20 = new Ruta("H20", "LMXJVSD");
        Ruta ruta_H21 = new Ruta("H21", "LMXJVSD");
        Ruta ruta_H27 = new Ruta("H27", "LMXJVSD");
        Ruta ruta_H54 = new Ruta("H54", "LMXJVSD");
        Ruta ruta_H72 = new Ruta("H72", "LMXJVSD");
        Ruta ruta_H73 = new Ruta("H73", "LMXJVSD");
        Ruta ruta_H75 = new Ruta("H75", "LMXJVSD");
        Ruta ruta_H76 = new Ruta("H76", "LMXJVSD");
        Ruta ruta_H83 = new Ruta("H83", "LMXJVSD");
        Ruta ruta_J23 = new Ruta("J23", "LMXJVSD");
        Ruta ruta_J24 = new Ruta("J24", "LMXJVSD");
        Ruta ruta_J70 = new Ruta("J70", "LMXJVSD");
        Ruta ruta_J73 = new Ruta("J73", "LMXJVSD");
        Ruta ruta_J74 = new Ruta("J74", "LMXJVSD");
        Ruta ruta_J76 = new Ruta("J76", "LMXJVSD");
        Ruta ruta_K10 = new Ruta("K10", "LMXJVSD");
        Ruta ruta_K16 = new Ruta("K16", "LMXJVSD");
        Ruta ruta_K23 = new Ruta("K23", "LMXJVSD");
        Ruta ruta_K43 = new Ruta("K43", "LMXJVSD");
        Ruta ruta_K54 = new Ruta("K54", "LMXJVSD");
        Ruta ruta_K86 = new Ruta("K86", "LMXJVSD");
        Ruta ruta_L10 = new Ruta("L10", "LMXJVSD");
        Ruta ruta_L18 = new Ruta("L18", "LMXJVSD");
        Ruta ruta_L25 = new Ruta("L25", "LMXJVSD");
        Ruta ruta_L41 = new Ruta("L41", "LMXJVSD");
        Ruta ruta_L81 = new Ruta("L81", "LMXJVSD");
        Ruta ruta_L82 = new Ruta("L82", "LMXJVSD");
        Ruta ruta_M47 = new Ruta("M47", "LMXJVSD");
        Ruta ruta_M51 = new Ruta("M51", "LMXJVSD");
        Ruta ruta_M82 = new Ruta("M82", "LMXJVSD");
        Ruta ruta_M83 = new Ruta("M83", "LMXJVSD");

        System.out.println("=================== Cargamos rutas");

        //Init Estaciones

            //Zona A
            Estacion calle76 = new Estacion("Calle 76", "A");
            Estacion calle72 = new Estacion("Calle 72", "A");
            Estacion floresAreandina = new Estacion("Flores Areandina", "A");
            Estacion calle63 = new Estacion("Calle 63", "A");
            Estacion calle57 = new Estacion("Calle 57", "A");
            Estacion marly = new Estacion("Marly", "A");
            Estacion calle45 = new Estacion("Calle 45", "A");
            Estacion calle39 = new Estacion("Calle 39", "A");
            Estacion calle34 = new Estacion("Calle 34", "A");
            Estacion calle26 = new Estacion("Calle 26", "A");
            Estacion calle22 = new Estacion("Calle 22", "A");
            Estacion calle19 = new Estacion("Calle 19", "A");
            Estacion tercerMilenio = new Estacion("Tercer Milenio", "A");

            //Zona B
            Estacion terminalNorte = new Estacion("Terminal Norte", "B");
            Estacion calle187 = new Estacion("Calle 187", "B");
            Estacion portalNorte = new Estacion("Portal Norte", "B");
            Estacion toberin = new Estacion("Toberín", "B");
            Estacion calle161 = new Estacion("Calle 161", "B");
            Estacion mazuren = new Estacion("Mazurén", "B");
            Estacion calle146 = new Estacion("Calle 146", "B");
            Estacion calle142 = new Estacion("Calle 142", "B");
            Estacion alcala = new Estacion("Alcalá", "B");
            Estacion prado = new Estacion("Prado", "B");
            Estacion calle127 = new Estacion("Calle 127", "B");
            Estacion pepeSierra = new Estacion("Pepe Sierra", "B");
            Estacion calle106 = new Estacion("Calle 106", "B");
            Estacion calle100 = new Estacion("Calle 100", "B");
            Estacion virrey = new Estacion("Virrey", "B");
            Estacion calle85 = new Estacion("Calle 85", "B");
            Estacion heroes = new Estacion("Héroes", "B");

            //Zona C
            Estacion portalSuba = new Estacion("Portal Suba", "C");
            Estacion laCampina = new Estacion("La Campiña", "C");
            Estacion subaTV91 = new Estacion("Suba TV 91", "C");
            Estacion angeles21 = new Estacion("21 Ángeles", "C");
            Estacion gratamira = new Estacion("Gratamira", "C");
            Estacion subaAVBoyaca = new Estacion("Suba Av. Boyaca", "C");
            Estacion nizaCl127 = new Estacion("Niza Calle 127", "C");
            Estacion humedalCordoba = new Estacion("Humedal Córdoba", "C");
            Estacion subaCl116 = new Estacion("Av Suba Calle 116", "C");
            Estacion puenteLargo = new Estacion("Puentelargo", "C");
            Estacion subaCl100 = new Estacion("Suba Calle 100", "C");
            Estacion subaCl95 = new Estacion("Suba Calle 95", "C");
            Estacion rionegro = new Estacion("Rionegro", "C");
            Estacion sanMartin = new Estacion("San Martin", "C");

            //Zona D
            Estacion portal80 = new Estacion("Portal de la 80", "D");
            Estacion quirigua = new Estacion("Quirigua", "D");
            Estacion carrera90 = new Estacion("Carrera 90", "D");
            Estacion avenidaCali = new Estacion("Avenida Cali", "D");
            Estacion granjaCra77 = new Estacion("Granja Carrera 77", "D");
            Estacion minutoDeDios = new Estacion("Minuto de Dios", "D");
            Estacion boyaca = new Estacion("Boyacá", "D");
            Estacion ferias = new Estacion("Ferias", "D");
            Estacion avenida68 = new Estacion("Avenida 68", "D");
            Estacion carrera53 = new Estacion("Carrera 53", "D");
            Estacion carrera47 = new Estacion("Carrera 47", "D");
            Estacion escuelaMilitar = new Estacion("Escuela Militar", "D");
            Estacion polo = new Estacion("Polo", "D");

            //Zona E
            Estacion laCastellana = new Estacion("La Castellana", "E");
            Estacion nqsCalle75 = new Estacion("Calle 75 - Zona M", "E");
            Estacion avChile = new Estacion("Avenida Chile", "E");
            Estacion sieteDeAgosto = new Estacion("7 de Agosto", "E");
            Estacion movistarArena = new Estacion("Movistar Arena", "E");
            Estacion campinUAN = new Estacion("Campín U. Antionio Nariño", "E");
            Estacion uNacional = new Estacion("Universidad Nacional", "E");
            Estacion avElDorado = new Estacion("Avenida El Dorado", "E");
            Estacion cad = new Estacion("CAD", "E");
            Estacion paloquemao = new Estacion("Paloquemao", "E");
            Estacion ricaurte_E = new Estacion("Ricaurte", "E");
            Estacion guatoque_veraguas = new Estacion("Guatoque - Veraguas", "E");
            Estacion tygua_san_jose = new Estacion("Tygua - San José", "E");


            //Zona F
            Estacion portalAmericas = new Estacion("Portal de las Ámericas", "F");
            Estacion patioBonito = new Estacion("Patio Bonito", "F");
            Estacion bibliotecaTintal = new Estacion("Biblioteca Tintal", "F");
            Estacion transversal86 = new Estacion("Transversal 86", "F");
            Estacion banderas = new Estacion("Banderas", "F");
            Estacion mandalay = new Estacion("Mandalay", "F");
            Estacion avAmericasBoyaca = new Estacion("AV Américas AV Boyacá", "F");
            Estacion marsella = new Estacion("Marsella", "F");
            Estacion pradera = new Estacion("Pradera", "F");
            Estacion distritoGrafiti = new Estacion("Distrito Grafiti", "F");
            Estacion puenteAranda = new Estacion("Puente Aranda", "F");
            Estacion americasCalle43 = new Estacion("Américas - Calle 43A", "F");
            Estacion zonaIndustrial = new Estacion("Zona Industrial", "F");
            Estacion cdsCarrera32 = new Estacion("CDS Carrera 32", "F");
            Estacion ricaurte_F = new Estacion("Ricaurte", "F");
            Estacion sanFaconKR22 = new Estacion("San Facon - KR 22", "F");
            Estacion deLaSabana = new Estacion("De la Sabana", "F");
            Estacion avJimenez_F = new Estacion("Avenida Jiménez", "F");

            //Zona G
            Estacion bosa = new Estacion("Bosa", "G");
            Estacion laDespensa = new Estacion("La Despensa", "G");
            Estacion leonXIII = new Estacion("León XIII", "G");
            Estacion terrerosHospitalCV = new Estacion("Terreros - Hospital C.V.", "G");
            Estacion sanMateoCCUnisur = new Estacion("San Mateo - C.C. Unisur", "G");
            Estacion portalSur = new Estacion("Portal del Sur", "G");
            Estacion perdomo = new Estacion("Perdomo", "G");
            Estacion cCPaseoVillaDelRio = new Estacion("C.C. Paseo Villa del Río - Madelana", "G");
            Estacion sevillana = new Estacion("Sevillana", "G");
            Estacion venecia = new Estacion("Venecia", "G");
            Estacion alqueria = new Estacion("Alquería", "G");
            Estacion generalSantander = new Estacion("General Santander", "G");
            Estacion nqsCL38ASur = new Estacion("NQS - CL 38A Sur", "G");
            Estacion nqsCL30Sur = new Estacion("NQS - CL 30 Sur", "G");
            Estacion sena = new Estacion("SENA", "G");
            Estacion santaIsabel = new Estacion("Santa Isabel", "G");
            Estacion comuneros = new Estacion("Comuneros", "G");

            //Zona H
            Estacion portalUsme = new Estacion("Portal de Usme", "H");
            Estacion molinos = new Estacion("Molinos", "H");
            Estacion consuelo = new Estacion("Consuelo", "H");
            Estacion socorro = new Estacion("Socorro", "H");
            Estacion santaLucia = new Estacion("Santa Lucía", "H");
            Estacion calle40Sur = new Estacion("Calle 40 Sur", "H");
            Estacion quiroga = new Estacion("Quiroga", "H");
            Estacion olaya = new Estacion("Olaya", "H");
            Estacion restrepo = new Estacion("Restrepo", "H");
            Estacion fucha = new Estacion("Fucha", "H");
            Estacion nariño = new Estacion("Nariño", "H");
            Estacion hortua = new Estacion("Hortúa", "H");     
            Estacion hospital = new Estacion("Hospital", "H"); 
            Estacion biblioteca = new Estacion("Biblioteca", "H"); 
            Estacion parque = new Estacion("Parque", "H"); 
            Estacion portalTunal = new Estacion("Portal el Tunal", "H");
            Estacion tunal = new Estacion("Tunal", "H");
            Estacion juanPabloII = new Estacion("Juan Pablo II", "H");
            Estacion manitas = new Estacion("Manitas", "H");
            Estacion miradorParaiso = new Estacion("Mirador del Paraíso", "H");

            //Zona J
            Estacion universidades_J = new Estacion("Universidades", "J");
            Estacion aguas = new Estacion("Las Aguas", "J");
            Estacion museoDelOro = new Estacion("Museo del Oro", "J");

            //Zona K
            Estacion portalEldorado = new Estacion("Portal ElDorado", "K");
            Estacion modelia = new Estacion("Modelia", "K");
            Estacion normandia = new Estacion("Normandía", "K");
            Estacion avenidaRojas = new Estacion("Avenida Rojas", "K");
            Estacion elTiempoCamaraComercio = new Estacion("El Tiempo - Cámara de Comercio de Bogotá", "K");
            Estacion salitreElGreco = new Estacion("Salitre - El Greco", "K");
            Estacion can = new Estacion("CAN", "K");
            Estacion gobernacion = new Estacion("Gobernación", "K");
            Estacion quintaParedes = new Estacion("Quinta Paredes", "K");
            Estacion corferias = new Estacion("Corferias", "K");
            Estacion ciudadUniversitaria = new Estacion("Ciudad Universitaria", "K");
            Estacion concejoDeBogota = new Estacion("Consejo de Bogotá", "K");
            Estacion centroDeMemoria = new Estacion("Centro de Memoria", "K");
            Estacion universidades_K = new Estacion("Universidades", "K");


            //Zona L
            Estacion portal20Julio = new Estacion("Portal 20 de Julio", "L");
            Estacion countrySur = new Estacion("Country Sur", "L");
            Estacion avenidaPrimeroMayo = new Estacion("AV. 1º Mayo", "L");
            Estacion ciudadJardinUAN = new Estacion("Ciudad Jardín - UAN", "L");
            Estacion policarpa = new Estacion("Policarpa", "L");
            Estacion sanBernardo = new Estacion("San Bernardo", "L");
            Estacion bicentenario = new Estacion("Bicentenario", "L");
            Estacion sanVictorino = new Estacion("San Victornino", "L");
            Estacion lasNieves = new Estacion("Las Nieves", "L");
            Estacion sanDiego = new Estacion("San Diego", "L");

            //Zona M
            Estacion museoNacional = new Estacion("Museo Nacional", "M");

            System.out.println("=================== Cargamos estaciones");

        //Init Buses
        Bus bus1 = new Bus("ABC123", "BRT");
        Bus bus2 = new Bus("DEF456", "Volvo 7900");
        Bus bus3 = new Bus("GHI789", "Scania K320");
        Bus bus4 = new Bus("JKL012", "Mercedes-Benz O500");
        Bus bus5 = new Bus("MNO345", "BRT");
        Bus bus6 = new Bus("PQR678", "Volvo 7900");
        Bus bus7 = new Bus("STU901", "Scania K320");
        Bus bus8 = new Bus("VWX234", "Mercedes-Benz O500");
        Bus bus9 = new Bus("YZA567", "BRT");
        Bus bus10 = new Bus("BCD890", "Volvo 7900");
        Bus bus11 = new Bus("EFG123", "Scania K320");
        Bus bus12 = new Bus("HIJ456", "Mercedes-Benz O500");
        Bus bus13 = new Bus("KLM789", "BRT");
        Bus bus14 = new Bus("NOP012", "Volvo 7900");
        Bus bus15 = new Bus("QRS345", "Scania K320");
        Bus bus16 = new Bus("TUV678", "Mercedes-Benz O500");
        Bus bus17 = new Bus("WXY901", "BRT");
        Bus bus18 = new Bus("ZAB234", "Volvo 7900");
        Bus bus19 = new Bus("CDE567", "Scania K320");
        Bus bus20 = new Bus("FGH890", "Mercedes-Benz O500");
        Bus bus21 = new Bus("IJK123", "BRT");
        Bus bus22 = new Bus("LMN456", "Volvo 7900");
        Bus bus23 = new Bus("OPQ789", "Scania K320");
        Bus bus24 = new Bus("RST012", "Mercedes-Benz O500");
        Bus bus25 = new Bus("UVW345", "BRT");
        Bus bus26 = new Bus("XYZ678", "Volvo 7900");
        Bus bus27 = new Bus("ABD901", "Scania K320");
        Bus bus28 = new Bus("CDE234", "Mercedes-Benz O500");
        Bus bus29 = new Bus("FGH567", "BRT");
        Bus bus30 = new Bus("IJK890", "Volvo 7900");
        Bus bus31 = new Bus("LMN123", "Scania K320");
        Bus bus32 = new Bus("OPQ456", "Mercedes-Benz O500");
        Bus bus33 = new Bus("RST789", "BRT");
        Bus bus34 = new Bus("UVW012", "Volvo 7900");
        Bus bus35 = new Bus("XYZ345", "Scania K320");
        Bus bus36 = new Bus("ABD678", "Mercedes-Benz O500");
        Bus bus37 = new Bus("CDE901", "BRT");
        Bus bus38 = new Bus("FGH234", "Volvo 7900");
        Bus bus39 = new Bus("IJK567", "Scania K320");
        Bus bus40 = new Bus("LMN890", "Mercedes-Benz O500");
        Bus bus41 = new Bus("OPQ123", "BRT");
        Bus bus42 = new Bus("RST456", "Volvo 7900");
        Bus bus43 = new Bus("UVW789", "Scania K320");
        Bus bus44 = new Bus("XYZ012", "Mercedes-Benz O500");
        Bus bus45 = new Bus("ABD345", "BRT");
        Bus bus46 = new Bus("CDE678", "Volvo 7900");
        Bus bus47 = new Bus("FGH901", "Scania K320");
        Bus bus48 = new Bus("IJK234", "Mercedes-Benz O500");
        Bus bus49 = new Bus("LMN567", "BRT");
        Bus bus50 = new Bus("OPQ890", "Volvo 7900");
        Bus bus51 = new Bus("RST123", "Scania K320");
        Bus bus52 = new Bus("UVW456", "Mercedes-Benz O500");
        Bus bus53 = new Bus("XYZ789", "BRT");
        Bus bus54 = new Bus("ABD012", "Volvo 7900");
        Bus bus55 = new Bus("CDE345", "Scania K320");
        Bus bus56 = new Bus("FGH678", "Mercedes-Benz O500");
        Bus bus57 = new Bus("IJK901", "BRT");
        Bus bus58 = new Bus("LMN234", "Volvo 7900");
        Bus bus59 = new Bus("OPQ567", "Scania K320");
        Bus bus60 = new Bus("RST890", "Mercedes-Benz O500");
        Bus bus61 = new Bus("UVW123", "BRT");
        Bus bus62 = new Bus("XYZ456", "Volvo 7900");
        Bus bus63 = new Bus("ABD789", "Scania K320");
        Bus bus64 = new Bus("CDE012", "Mercedes-Benz O500");
        Bus bus65 = new Bus("FGH345", "BRT");
        Bus bus66 = new Bus("IJK678", "Volvo 7900");
        Bus bus67 = new Bus("LMN901", "Scania K320");
        Bus bus68 = new Bus("OPQ234", "Mercedes-Benz O500");
        Bus bus69 = new Bus("RST567", "BRT");
        Bus bus70 = new Bus("UVW890", "Volvo 7900");
        Bus bus71 = new Bus("XYZ123", "Scania K320");
        Bus bus72 = new Bus("ABD456", "Mercedes-Benz O500");
        Bus bus73 = new Bus("CDE789", "BRT");
        Bus bus74 = new Bus("FGH012", "Volvo 7900");
        Bus bus75 = new Bus("IJK345", "Scania K320");
        Bus bus76 = new Bus("LMN678", "Mercedes-Benz O500");
        Bus bus77 = new Bus("OPQ901", "BRT");
        Bus bus78 = new Bus("RST234", "Volvo 7900");
        Bus bus79 = new Bus("UVW567", "Scania K320");
        Bus bus80 = new Bus("XYZ890", "Mercedes-Benz O500");
        Bus bus81 = new Bus("ABD123", "BRT");
        Bus bus82 = new Bus("CDE456", "Volvo 7900");
        Bus bus83 = new Bus("FGH789", "Scania K320");
        Bus bus84 = new Bus("IJK012", "Mercedes-Benz O500");
        Bus bus85 = new Bus("LMN345", "BRT");
        Bus bus86 = new Bus("OPQ678", "Volvo 7900");
        Bus bus87 = new Bus("RST901", "Scania K320");
        Bus bus88 = new Bus("UVW234", "Mercedes-Benz O500");
        Bus bus89 = new Bus("XYZ567", "BRT");
        Bus bus90 = new Bus("ABD890", "Volvo 7900");
        Bus bus91 = new Bus("CDE123", "Scania K320");
        Bus bus92 = new Bus("FGH456", "Mercedes-Benz O500");
        Bus bus93 = new Bus("IJK789", "BRT");
        Bus bus94 = new Bus("LMN012", "Volvo 7900");
        Bus bus95 = new Bus("OPQ345", "Scania K320");
        Bus bus96 = new Bus("RST678", "Mercedes-Benz O500");
        Bus bus97 = new Bus("UVW901", "BRT");
        Bus bus98 = new Bus("XYZ234", "Volvo 7900");
        Bus bus99 = new Bus("ABD567", "Scania K320");
        Bus bus100 = new Bus("CDE890", "Mercedes-Benz O500");

        System.out.println(" =================== Cargamos buses");

        //Init Conductores

        Conductor conductor1 = new Conductor(1023456789L, "Carlos Pérez", 3101234567L, "Calle 100 #15-20");
        Conductor conductor2 = new Conductor(1034567890L, "Luis Rodríguez", 3112345678L, "Carrera 11 #45-67");
        Conductor conductor3 = new Conductor(1045678901L, "Andrés Martínez", 3133456789L, "Avenida Suba #95-10");
        Conductor conductor4 = new Conductor(1056789012L, "Jorge Gómez", 3154567890L, "Carrera 7 #12-34");
        Conductor conductor5 = new Conductor(1067890123L, "Sergio Ramírez", 3205678901L, "Calle 80 #50-20");
        Conductor conductor6 = new Conductor(1078901234L, "Daniela López", 3106789012L, "Transversal 19 #63-45");
        Conductor conductor7 = new Conductor(1089012345L, "María García", 3117890123L, "Diagonal 53 #30-20");
        Conductor conductor8 = new Conductor(1090123456L, "Fernando Torres", 3138901234L, "Carrera 30 #85-15");
        Conductor conductor9 = new Conductor(1101234567L, "Ana Morales", 3159012345L, "Calle 127 #20-50");
        Conductor conductor10 = new Conductor(1112345678L, "Oscar Sánchez", 3200123456L, "Carrera 68 #35-10");
        Conductor conductor11 = new Conductor(1123456789L, "Laura Castillo", 3102345678L, "Carrera 50 #14-30");
        Conductor conductor12 = new Conductor(1134567890L, "Ricardo Herrera", 3113456789L, "Calle 26 #79-45");
        Conductor conductor13 = new Conductor(1145678901L, "Alejandro Medina", 3134567890L, "Avenida Boyacá #31-18");
        Conductor conductor14 = new Conductor(1156789012L, "Lucía Vargas", 3155678901L, "Calle 45 #20-30");
        Conductor conductor15 = new Conductor(1167890123L, "Javier Ortiz", 3206789012L, "Carrera 24 #70-14");
        Conductor conductor16 = new Conductor(1178901234L, "Marta Peña", 3107890123L, "Avenida Caracas #10-50");
        Conductor conductor17 = new Conductor(1189012345L, "Felipe Gómez", 3118901234L, "Carrera 15 #88-25");
        Conductor conductor18 = new Conductor(1190123456L, "Natalia León", 3139012345L, "Calle 134 #58-30");
        Conductor conductor19 = new Conductor(1201234567L, "Gustavo Ruiz", 3150123456L, "Carrera 9 #42-18");
        Conductor conductor20 = new Conductor(1212345678L, "Adriana Díaz", 3201234567L, "Avenida 68 #60-30");
        Conductor conductor21 = new Conductor(1223456789L, "Camilo Prieto", 3103456789L, "Calle 170 #45-20");
        Conductor conductor22 = new Conductor(1234567890L, "Diego Rojas", 3114567890L, "Carrera 7 #76-40");
        Conductor conductor23 = new Conductor(1245678901L, "Paula Cárdenas", 3135678901L, "Calle 22 #4-50");
        Conductor conductor24 = new Conductor(1256789012L, "Eduardo Ramírez", 3156789012L, "Avenida Suba #100-10");
        Conductor conductor25 = new Conductor(1267890123L, "Carolina Vargas", 3207890123L, "Calle 93 #15-20");
        Conductor conductor26 = new Conductor(1278901234L, "Esteban Pérez", 3108901234L, "Carrera 50 #63-45");
        Conductor conductor27 = new Conductor(1289012345L, "Sofía Gutiérrez", 3119012345L, "Calle 85 #20-30");
        Conductor conductor28 = new Conductor(1290123456L, "Julián Muñoz", 3130123456L, "Carrera 15 #100-50");
        Conductor conductor29 = new Conductor(1301234567L, "Diana Jiménez", 3151234567L, "Calle 140 #30-10");
        Conductor conductor30 = new Conductor(1312345678L, "Miguel Castillo", 3202345678L, "Avenida 19 #78-15");
        Conductor conductor31 = new Conductor(1323456789L, "Cristina López", 3103456789L, "Calle 53 #25-45");
        Conductor conductor32 = new Conductor(1334567890L, "Raúl Morales", 3114567890L, "Carrera 9 #100-30");
        Conductor conductor33 = new Conductor(1345678901L, "Liliana Paredes", 3135678901L, "Calle 80 #24-15");
        Conductor conductor34 = new Conductor(1356789012L, "Mauricio Silva", 3156789012L, "Carrera 7 #90-40");
        Conductor conductor35 = new Conductor(1367890123L, "Lorena Fuentes", 3207890123L, "Avenida Boyacá #45-25");
        Conductor conductor36 = new Conductor(1378901234L, "Jairo Martínez", 3108901234L, "Calle 63 #35-20");
        Conductor conductor37 = new Conductor(1389012345L, "Ángela Díaz", 3119012345L, "Carrera 30 #80-15");
        Conductor conductor38 = new Conductor(1390123456L, "César Hernández", 3130123456L, "Calle 72 #10-50");
        Conductor conductor39 = new Conductor(1401234567L, "Valentina Ortiz", 3151234567L, "Carrera 50 #60-10");
        Conductor conductor40 = new Conductor(1412345678L, "Jaime Gutiérrez", 3202345678L, "Calle 134 #40-50");
        Conductor conductor41 = new Conductor(1423456789L, "Beatriz Castro", 3103456789L, "Calle 85 #20-20");
        Conductor conductor42 = new Conductor(1434567890L, "Alberto Gómez", 3114567890L, "Carrera 10 #64-25");
        Conductor conductor43 = new Conductor(1445678901L, "Patricia Acosta", 3135678901L, "Avenida Suba #120-15");
        Conductor conductor44 = new Conductor(1456789012L, "Rodrigo Ruiz", 3156789012L, "Calle 170 #50-10");
        Conductor conductor45 = new Conductor(1467890123L, "Andrea Ramírez", 3207890123L, "Carrera 15 #68-20");
        Conductor conductor46 = new Conductor(1478901234L, "Sebastián Sánchez", 3108901234L, "Calle 72 #25-30");
        Conductor conductor47 = new Conductor(1489012345L, "Verónica Moreno", 3119012345L, "Carrera 7 #108-50");
        Conductor conductor48 = new Conductor(1490123456L, "Guillermo Reyes", 3130123456L, "Calle 80 #19-20");
        Conductor conductor49 = new Conductor(1501234567L, "Catalina Vargas", 3151234567L, "Carrera 50 #45-15");
        Conductor conductor50 = new Conductor(1512345678L, "Iván Suárez", 3202345678L, "Calle 100 #9-40");
        Conductor conductor51 = new Conductor(1523456789L, "Sara Ramírez", 3103456789L, "Calle 147 #45-20");
        Conductor conductor52 = new Conductor(1534567890L, "Marcela Herrera", 3114567890L, "Carrera 15 #140-30");
        Conductor conductor53 = new Conductor(1545678901L, "Roberto Gutiérrez", 3135678901L, "Calle 170 #35-15");
        Conductor conductor54 = new Conductor(1556789012L, "Roberto Gutiérrez", 3156789012L, "Carrera 7 #147-60");
        Conductor conductor55 = new Conductor(1567890123L, "Gloria Torres", 3207890123L, "Calle 134 #45-20");
        Conductor conductor56 = new Conductor(1578901234L, "Javier Castillo", 3108901234L, "Carrera 13 #78-30");
        Conductor conductor57 = new Conductor(1589012345L, "Elena Pineda", 3119012345L, "Calle 170 #50-10");
        Conductor conductor58 = new Conductor(1590123456L, "Juan Montoya", 3130123456L, "Carrera 50 #15-25");
        Conductor conductor59 = new Conductor(1601234567L, "Carmen Ruiz", 3151234567L, "Calle 100 #7-15");
        Conductor conductor60 = new Conductor(1612345678L, "Pedro Ríos", 3202345678L, "Avenida Suba #92-40");
        Conductor conductor61 = new Conductor(1623456789L, "Lucía Valdez", 3103456789L, "Carrera 10 #80-50");
        Conductor conductor62 = new Conductor(1634567890L, "Luis Mejía", 3114567890L, "Calle 63 #27-30");
        Conductor conductor63 = new Conductor(1645678901L, "Claudia Sánchez", 3135678901L, "Avenida Boyacá #120-45");
        Conductor conductor64 = new Conductor(1656789012L, "Rafael Calderón", 3156789012L, "Calle 45 #10-30");
        Conductor conductor65 = new Conductor(1667890123L, "Sofía Medina", 3207890123L, "Carrera 68 #90-20");
        Conductor conductor66 = new Conductor(1678901234L, "Andrés Lozano", 3108901234L, "Calle 72 #14-40");
        Conductor conductor67 = new Conductor(1689012345L, "Verónica Vargas", 3119012345L, "Carrera 15 #134-25");
        Conductor conductor68 = new Conductor(1690123456L, "Jorge Pardo", 3130123456L, "Calle 85 #15-35");
        Conductor conductor69 = new Conductor(1701234567L, "Paola Ruiz", 3151234567L, "Carrera 7 #56-20");
        Conductor conductor70 = new Conductor(1712345678L, "Gabriel Pérez", 3202345678L, "Avenida 68 #100-30");
        Conductor conductor71 = new Conductor(1723456789L, "Adriana Gil", 3103456789L, "Calle 93 #13-20");
        Conductor conductor72 = new Conductor(1734567890L, "Mario Gómez", 3114567890L, "Carrera 10 #85-15");
        Conductor conductor73 = new Conductor(1745678901L, "Gloria Moreno", 3135678901L, "Calle 170 #20-50");
        Conductor conductor74 = new Conductor(1756789012L, "Felipe Ramírez", 3156789012L, "Carrera 50 #70-30");
        Conductor conductor75 = new Conductor(1767890123L, "Carolina Álvarez", 3207890123L, "Calle 72 #55-15");
        Conductor conductor76 = new Conductor(1778901234L, "Daniel Herrera", 3108901234L, "Carrera 7 #112-20");
        Conductor conductor77 = new Conductor(1789012345L, "Ángela Prieto", 3119012345L, "Calle 100 #30-40");
        Conductor conductor78 = new Conductor(1790123456L, "Santiago Martínez", 3130123456L, "Carrera 30 #45-25");
        Conductor conductor79 = new Conductor(1801234567L, "Camila Reyes", 3151234567L, "Avenida Suba #90-10");
        Conductor conductor80 = new Conductor(1812345678L, "Rosa Jiménez", 3202345678L, "Carrera 13 #78-15");
        Conductor conductor81 = new Conductor(1823456789L, "Luis Ramírez", 3103456789L, "Calle 53 #25-10");
        Conductor conductor82 = new Conductor(1834567890L, "Diego Gutiérrez", 3114567890L, "Carrera 68 #45-30");
        Conductor conductor83 = new Conductor(1845678901L, "Ana Ríos", 3135678901L, "Avenida Caracas #80-20");
        Conductor conductor84 = new Conductor(1856789012L, "Ricardo Torres", 3156789012L, "Calle 80 #12-45");
        Conductor conductor85 = new Conductor(1867890123L, "Patricia López", 3207890123L, "Carrera 7 #96-15");
        Conductor conductor86 = new Conductor(1878901234L, "Alejandro Vargas", 3108901234L, "Calle 170 #60-25");
        Conductor conductor87 = new Conductor(1889012345L, "Diana Medina", 3119012345L, "Carrera 15 #45-50");
        Conductor conductor88 = new Conductor(1890123456L, "Eduardo Gómez", 3130123456L, "Calle 72 #20-35");
        Conductor conductor89 = new Conductor(1901234567L, "Margarita Peña", 3151234567L, "Avenida Suba #110-10");
        Conductor conductor90 = new Conductor(1912345678L, "Cristian Gil", 3202345678L, "Calle 85 #10-50");
        Conductor conductor91 = new Conductor(1923456789L, "Lorena Morales", 3103456789L, "Carrera 68 #55-15");
        Conductor conductor92 = new Conductor(1934567890L, "Miguel Rojas", 3114567890L, "Calle 45 #30-20");
        Conductor conductor93 = new Conductor(1945678901L, "Rosa Delgado", 3135678901L, "Avenida 68 #70-40");
        Conductor conductor94 = new Conductor(1956789012L, "Rodrigo Pérez", 3156789012L, "Calle 140 #20-30");
        Conductor conductor95 = new Conductor(1967890123L, "Elena Santos", 3207890123L, "Carrera 9 #68-50");
        Conductor conductor96 = new Conductor(1978901234L, "Juan Castro", 3108901234L, "Calle 116 #32-40");
        Conductor conductor97 = new Conductor(1989012345L, "Mónica Vargas", 3119012345L, "Carrera 30 #40-30");
        Conductor conductor98 = new Conductor(1990123456L, "Ricardo Mejía", 3130123456L, "Avenida Boyacá #75-25");
        Conductor conductor99 = new Conductor(2001234567L, "Gabriela Reyes", 3151234567L, "Calle 26 #20-45");
        Conductor conductor100 = new Conductor(2012345678L, "Sergio López", 3202345678L, "Carrera 15 #120-30");

        System.out.println("=================== Conductores");

        //Rel Ruta - Estación

        ruta_1.addEstacion(portalEldorado);
        ruta_1.addEstacion(modelia);
        ruta_1.addEstacion(normandia);
        ruta_1.addEstacion(avenidaRojas);
        ruta_1.addEstacion(elTiempoCamaraComercio);
        ruta_1.addEstacion(salitreElGreco);
        ruta_1.addEstacion(can);
        ruta_1.addEstacion(gobernacion);
        ruta_1.addEstacion(quintaParedes);
        ruta_1.addEstacion(corferias);
        ruta_1.addEstacion(ciudadUniversitaria);
        ruta_1.addEstacion(concejoDeBogota);
        ruta_1.addEstacion(centroDeMemoria);
        ruta_1.addEstacion(universidades_J);

ruta_2.addEstacion(portalNorte);
ruta_2.addEstacion(terminalNorte);
ruta_2.addEstacion(calle187);
ruta_2.addEstacion(toberin);
ruta_2.addEstacion(calle161);
ruta_2.addEstacion(mazuren);
ruta_2.addEstacion(calle146);
ruta_2.addEstacion(calle142);
ruta_2.addEstacion(alcala);
ruta_2.addEstacion(prado);
ruta_2.addEstacion(calle127);
ruta_2.addEstacion(pepeSierra);
ruta_2.addEstacion(calle106);
ruta_2.addEstacion(calle100);
ruta_2.addEstacion(virrey);
ruta_2.addEstacion(calle85);
ruta_2.addEstacion(heroes);

ruta_3.addEstacion(portalSuba);
ruta_3.addEstacion(laCampina);
ruta_3.addEstacion(subaTV91);
ruta_3.addEstacion(angeles21);
ruta_3.addEstacion(gratamira);
ruta_3.addEstacion(subaAVBoyaca);
ruta_3.addEstacion(nizaCl127);
ruta_3.addEstacion(humedalCordoba);
ruta_3.addEstacion(subaCl116);
ruta_3.addEstacion(puenteLargo);
ruta_3.addEstacion(subaCl100);
ruta_3.addEstacion(subaCl95);
ruta_3.addEstacion(rionegro);
ruta_3.addEstacion(sanMartin);

ruta_4.addEstacion(portal80);
ruta_4.addEstacion(quirigua);
ruta_4.addEstacion(carrera90);
ruta_4.addEstacion(avenidaCali);
ruta_4.addEstacion(granjaCra77);
ruta_4.addEstacion(minutoDeDios);
ruta_4.addEstacion(boyaca);
ruta_4.addEstacion(ferias);
ruta_4.addEstacion(avenida68);
ruta_4.addEstacion(carrera53);
ruta_4.addEstacion(carrera47);
ruta_4.addEstacion(escuelaMilitar);
ruta_4.addEstacion(polo);

ruta_5.addEstacion(laCastellana);
ruta_5.addEstacion(nqsCalle75);
ruta_5.addEstacion(avChile);
ruta_5.addEstacion(sieteDeAgosto);
ruta_5.addEstacion(movistarArena);
ruta_5.addEstacion(campinUAN);
ruta_5.addEstacion(uNacional);
ruta_5.addEstacion(avElDorado);
ruta_5.addEstacion(cad);
ruta_5.addEstacion(paloquemao);
ruta_5.addEstacion(ricaurte_E);
ruta_5.addEstacion(guatoque_veraguas);
ruta_5.addEstacion(tygua_san_jose);

ruta_6.addEstacion(portalAmericas);
ruta_6.addEstacion(patioBonito);
ruta_6.addEstacion(bibliotecaTintal);
ruta_6.addEstacion(transversal86);
ruta_6.addEstacion(banderas);
ruta_6.addEstacion(mandalay);
ruta_6.addEstacion(avAmericasBoyaca);
ruta_6.addEstacion(marsella);
ruta_6.addEstacion(pradera);
ruta_6.addEstacion(distritoGrafiti);
ruta_6.addEstacion(puenteAranda);
ruta_6.addEstacion(americasCalle43);
ruta_6.addEstacion(zonaIndustrial);
ruta_6.addEstacion(cdsCarrera32);
ruta_6.addEstacion(ricaurte_F);
ruta_6.addEstacion(sanFaconKR22);
ruta_6.addEstacion(deLaSabana);
ruta_6.addEstacion(avJimenez_F);

ruta_7.addEstacion(sanMateoCCUnisur);
ruta_7.addEstacion(terrerosHospitalCV);
ruta_7.addEstacion(leonXIII);
ruta_7.addEstacion(laDespensa);
ruta_7.addEstacion(bosa);
ruta_7.addEstacion(portalSur);
ruta_7.addEstacion(perdomo);
ruta_7.addEstacion(cCPaseoVillaDelRio);
ruta_7.addEstacion(sevillana);
ruta_7.addEstacion(venecia);
ruta_7.addEstacion(alqueria);
ruta_7.addEstacion(generalSantander);
ruta_7.addEstacion(nqsCL38ASur);
ruta_7.addEstacion(nqsCL30Sur);
ruta_7.addEstacion(sena);
ruta_7.addEstacion(santaIsabel);
ruta_7.addEstacion(comuneros);

ruta_8.addEstacion(portalUsme);
ruta_8.addEstacion(molinos);
ruta_8.addEstacion(consuelo);
ruta_8.addEstacion(socorro);
ruta_8.addEstacion(santaLucia);
ruta_8.addEstacion(calle40Sur);
ruta_8.addEstacion(quiroga);
ruta_8.addEstacion(olaya);
ruta_8.addEstacion(restrepo);
ruta_8.addEstacion(fucha);
ruta_8.addEstacion(nariño);
ruta_8.addEstacion(hortua);
ruta_8.addEstacion(hospital);

ruta_A52.addEstacion(calle76);
ruta_A52.addEstacion(calle72);
ruta_A52.addEstacion(floresAreandina);
ruta_A52.addEstacion(calle63);
ruta_A52.addEstacion(calle57);
ruta_A52.addEstacion(marly);
ruta_A52.addEstacion(calle45);
ruta_A52.addEstacion(calle39);
ruta_A52.addEstacion(calle34);
ruta_A52.addEstacion(calle26);
ruta_A52.addEstacion(calle22);
ruta_A52.addEstacion(tercerMilenio);

ruta_A60.addEstacion(terminalNorte);
ruta_A60.addEstacion(calle187);
ruta_A60.addEstacion(portalNorte);
ruta_A60.addEstacion(toberin);
ruta_A60.addEstacion(calle161);
ruta_A60.addEstacion(mazuren);
ruta_A60.addEstacion(calle146);
ruta_A60.addEstacion(calle142);
ruta_A60.addEstacion(alcala);
ruta_A60.addEstacion(prado);
ruta_A60.addEstacion(calle127);
ruta_A60.addEstacion(pepeSierra);
ruta_A60.addEstacion(calle106);
ruta_A60.addEstacion(calle100);
ruta_A60.addEstacion(virrey);
ruta_A60.addEstacion(calle85);
ruta_A60.addEstacion(heroes);

ruta_A61.addEstacion(portalSuba);
ruta_A61.addEstacion(laCampina);
ruta_A61.addEstacion(subaTV91);
ruta_A61.addEstacion(angeles21);
ruta_A61.addEstacion(gratamira);
ruta_A61.addEstacion(subaAVBoyaca);
ruta_A61.addEstacion(nizaCl127);
ruta_A61.addEstacion(humedalCordoba);
ruta_A61.addEstacion(subaCl116);
ruta_A61.addEstacion(puenteLargo);
ruta_A61.addEstacion(subaCl100);
ruta_A61.addEstacion(subaCl95);
ruta_A61.addEstacion(rionegro);
ruta_A61.addEstacion(sanMartin);

ruta_B10.addEstacion(portal80);
ruta_B10.addEstacion(carrera90);
ruta_B10.addEstacion(avenidaCali);
ruta_B10.addEstacion(granjaCra77);
ruta_B10.addEstacion(carrera53);
ruta_B10.addEstacion(carrera47);
ruta_B10.addEstacion(calle85);
ruta_B10.addEstacion(virrey);
ruta_B10.addEstacion(calle100);
ruta_B10.addEstacion(calle106);
ruta_B10.addEstacion(pepeSierra);
ruta_B10.addEstacion(alcala);
ruta_B10.addEstacion(calle146);
ruta_B10.addEstacion(mazuren);
ruta_B10.addEstacion(toberin);
ruta_B10.addEstacion(portalNorte);

ruta_B11.addEstacion(portalSur);
ruta_B11.addEstacion(venecia);
ruta_B11.addEstacion(alqueria);
ruta_B11.addEstacion(sena);
ruta_B11.addEstacion(ricaurte_E);
ruta_B11.addEstacion(paloquemao);
ruta_B11.addEstacion(cad);
ruta_B11.addEstacion(uNacional);
ruta_B11.addEstacion(campinUAN);
ruta_B11.addEstacion(escuelaMilitar);
ruta_B11.addEstacion(heroes);
ruta_B11.addEstacion(calle85);
ruta_B11.addEstacion(virrey);
ruta_B11.addEstacion(calle106);
ruta_B11.addEstacion(pepeSierra);
ruta_B11.addEstacion(calle146);
ruta_B11.addEstacion(mazuren);
ruta_B11.addEstacion(toberin);

ruta_B12.addEstacion(portalSur);
ruta_B12.addEstacion(calle187);
ruta_B12.addEstacion(alcala);
ruta_B12.addEstacion(pepeSierra);
ruta_B12.addEstacion(calle146);
ruta_B12.addEstacion(mazuren);
ruta_B12.addEstacion(toberin);
ruta_B12.addEstacion(portalNorte);

ruta_B13.addEstacion(portalSur);
ruta_B13.addEstacion(calle187);
ruta_B13.addEstacion(alcala);
ruta_B13.addEstacion(pepeSierra);
ruta_B13.addEstacion(calle146);
ruta_B13.addEstacion(mazuren);
ruta_B13.addEstacion(toberin);
ruta_B13.addEstacion(portalNorte);

ruta_B16.addEstacion(portalEldorado);
ruta_B16.addEstacion(avenidaRojas);
ruta_B16.addEstacion(calle26);
ruta_B16.addEstacion(centroDeMemoria);
ruta_B16.addEstacion(ciudadUniversitaria);
ruta_B16.addEstacion(corferias);
ruta_B16.addEstacion(calle26);
ruta_B16.addEstacion(calle34);
ruta_B16.addEstacion(calle39);
ruta_B16.addEstacion(calle45);
ruta_B16.addEstacion(marly);
ruta_B16.addEstacion(calle57);
ruta_B16.addEstacion(calle63);
ruta_B16.addEstacion(floresAreandina);
ruta_B16.addEstacion(calle72);
ruta_B16.addEstacion(calle76);

ruta_B18.addEstacion(portal20Julio);
ruta_B18.addEstacion(avenidaPrimeroMayo);
ruta_B18.addEstacion(ciudadJardinUAN);
ruta_B18.addEstacion(policarpa);
ruta_B18.addEstacion(sanBernardo);
ruta_B18.addEstacion(bicentenario);
ruta_B18.addEstacion(sanVictorino);
ruta_B18.addEstacion(lasNieves);
ruta_B18.addEstacion(sanDiego);
ruta_B18.addEstacion(museoNacional);

ruta_B23.addEstacion(portalSuba);
ruta_B23.addEstacion(laCampina);
ruta_B23.addEstacion(subaTV91);
ruta_B23.addEstacion(gratamira);
ruta_B23.addEstacion(subaAVBoyaca);
ruta_B23.addEstacion(nizaCl127);
ruta_B23.addEstacion(humedalCordoba);
ruta_B23.addEstacion(subaCl116);
ruta_B23.addEstacion(puenteLargo);
ruta_B23.addEstacion(subaCl100);

ruta_B26.addEstacion(portalEldorado);
ruta_B26.addEstacion(modelia);
ruta_B26.addEstacion(normandia);
ruta_B26.addEstacion(avenidaRojas);
ruta_B26.addEstacion(elTiempoCamaraComercio);
ruta_B26.addEstacion(salitreElGreco);
ruta_B26.addEstacion(can);
ruta_B26.addEstacion(gobernacion);
ruta_B26.addEstacion(quintaParedes);

ruta_B27.addEstacion(portalTunal);
ruta_B27.addEstacion(calle40Sur);
ruta_B27.addEstacion(avJimenez_F);
ruta_B27.addEstacion(calle34);
ruta_B27.addEstacion(calle72);
ruta_B27.addEstacion(calle76);
ruta_B27.addEstacion(heroes);
ruta_B27.addEstacion(calle85);
ruta_B27.addEstacion(virrey);
ruta_B27.addEstacion(calle100);
ruta_B27.addEstacion(toberin);
ruta_B27.addEstacion(portalNorte);

ruta_B28.addEstacion(portalAmericas);
ruta_B28.addEstacion(bibliotecaTintal);
ruta_B28.addEstacion(banderas);
ruta_B28.addEstacion(marsella);
ruta_B28.addEstacion(zonaIndustrial);
ruta_B28.addEstacion(cdsCarrera32);
ruta_B28.addEstacion(laCastellana);
ruta_B28.addEstacion(calle106);
ruta_B28.addEstacion(pepeSierra);
ruta_B28.addEstacion(prado);
ruta_B28.addEstacion(calle146);
ruta_B28.addEstacion(calle161);
ruta_B28.addEstacion(portalNorte);

ruta_B46.addEstacion(portalAmericas);
ruta_B46.addEstacion(banderas);
ruta_B46.addEstacion(calle85);
ruta_B46.addEstacion(virrey);
ruta_B46.addEstacion(pepeSierra);
ruta_B46.addEstacion(prado);
ruta_B46.addEstacion(calle146);
ruta_B46.addEstacion(calle161);
ruta_B46.addEstacion(portalNorte);

ruta_B50.addEstacion(portalSuba);
ruta_B50.addEstacion(nizaCl127);
ruta_B50.addEstacion(humedalCordoba);
ruta_B50.addEstacion(subaCl116);
ruta_B50.addEstacion(puenteLargo);
ruta_B50.addEstacion(subaCl100);
ruta_B50.addEstacion(virrey);
ruta_B50.addEstacion(calle106);
ruta_B50.addEstacion(pepeSierra);
ruta_B50.addEstacion(prado);
ruta_B50.addEstacion(calle146);
ruta_B50.addEstacion(calle161);

ruta_B55.addEstacion(portal80);
ruta_B55.addEstacion(granjaCra77);
ruta_B55.addEstacion(avenidaCali);
ruta_B55.addEstacion(calle85);
ruta_B55.addEstacion(virrey);
ruta_B55.addEstacion(calle100);
ruta_B55.addEstacion(pepeSierra);
ruta_B55.addEstacion(prado);
ruta_B55.addEstacion(calle146);
ruta_B55.addEstacion(calle161);
ruta_B55.addEstacion(portalNorte);

ruta_B72.addEstacion(portalTunal);
ruta_B72.addEstacion(avJimenez_F);
ruta_B72.addEstacion(calle26);
ruta_B72.addEstacion(calle34);
ruta_B72.addEstacion(calle76);
ruta_B72.addEstacion(heroes);
ruta_B72.addEstacion(calle85);
ruta_B72.addEstacion(virrey);
ruta_B72.addEstacion(calle106);
ruta_B72.addEstacion(pepeSierra);
ruta_B72.addEstacion(calle146);
ruta_B72.addEstacion(calle161);
ruta_B72.addEstacion(portalNorte);

ruta_B74.addEstacion(portal80);
ruta_B74.addEstacion(granjaCra77);
ruta_B74.addEstacion(calle85);
ruta_B74.addEstacion(virrey);
ruta_B74.addEstacion(pepeSierra);
ruta_B74.addEstacion(prado);
ruta_B74.addEstacion(calle146);
ruta_B74.addEstacion(calle161);
ruta_B74.addEstacion(portalNorte);

ruta_B75.addEstacion(portal80);
ruta_B75.addEstacion(granjaCra77);
ruta_B75.addEstacion(avenidaCali);
ruta_B75.addEstacion(calle85);
ruta_B75.addEstacion(virrey);
ruta_B75.addEstacion(calle100);
ruta_B75.addEstacion(pepeSierra);
ruta_B75.addEstacion(prado);
ruta_B75.addEstacion(calle146);
ruta_B75.addEstacion(calle161);
ruta_B75.addEstacion(portalNorte);

ruta_C15.addEstacion(portalTunal);
ruta_C15.addEstacion(parque);
ruta_C15.addEstacion(calle40Sur);
ruta_C15.addEstacion(nariño);
ruta_C15.addEstacion(tercerMilenio);
ruta_C15.addEstacion(avJimenez_F);
ruta_C15.addEstacion(calle19);
ruta_C15.addEstacion(calle22);
ruta_C15.addEstacion(calle45);
ruta_C15.addEstacion(calle57);
ruta_C15.addEstacion(calle76);
ruta_C15.addEstacion(rionegro);
ruta_C15.addEstacion(subaCl116);
ruta_C15.addEstacion(humedalCordoba);
ruta_C15.addEstacion(nizaCl127);
ruta_C15.addEstacion(gratamira);
ruta_C15.addEstacion(subaTV91);
ruta_C15.addEstacion(portalSuba);

ruta_C17.addEstacion(portalUsme);
ruta_C17.addEstacion(consuelo);
ruta_C17.addEstacion(santaLucia);
ruta_C17.addEstacion(quiroga);
ruta_C17.addEstacion(restrepo);
ruta_C17.addEstacion(hortua);
ruta_C17.addEstacion(calle72);
ruta_C17.addEstacion(calle85);
ruta_C17.addEstacion(virrey);
ruta_C17.addEstacion(calle100);
ruta_C17.addEstacion(heroes);
ruta_C17.addEstacion(puenteLargo);
ruta_C17.addEstacion(portalSuba);

ruta_C19.addEstacion(banderas);
ruta_C19.addEstacion(mandalay);
ruta_C19.addEstacion(marsella);
ruta_C19.addEstacion(distritoGrafiti);
ruta_C19.addEstacion(zonaIndustrial);
ruta_C19.addEstacion(ricaurte_E);
ruta_C19.addEstacion(deLaSabana);
ruta_C19.addEstacion(calle19);
ruta_C19.addEstacion(calle34);
ruta_C19.addEstacion(calle72);
ruta_C19.addEstacion(calle85);
ruta_C19.addEstacion(virrey);
ruta_C19.addEstacion(puenteLargo);
ruta_C19.addEstacion(portalSuba);

ruta_C25.addEstacion(portal20Julio);
ruta_C25.addEstacion(countrySur);
ruta_C25.addEstacion(avenidaPrimeroMayo);
ruta_C25.addEstacion(sanBernardo);
ruta_C25.addEstacion(bicentenario);
ruta_C25.addEstacion(tygua_san_jose);
ruta_C25.addEstacion(guatoque_veraguas);
ruta_C25.addEstacion(ricaurte_E);
ruta_C25.addEstacion(campinUAN);
ruta_C25.addEstacion(movistarArena);
ruta_C25.addEstacion(avChile);
ruta_C25.addEstacion(nqsCalle75);
ruta_C25.addEstacion(sanMartin);
ruta_C25.addEstacion(subaCl95);
ruta_C25.addEstacion(nizaCl127);
ruta_C25.addEstacion(subaAVBoyaca);
ruta_C25.addEstacion(angeles21);
ruta_C25.addEstacion(subaTV91);
ruta_C25.addEstacion(portalSuba);

ruta_C30.addEstacion(portalSur);
ruta_C30.addEstacion(perdomo);
ruta_C30.addEstacion(cCPaseoVillaDelRio);
ruta_C30.addEstacion(sevillana);
ruta_C30.addEstacion(venecia);
ruta_C30.addEstacion(alqueria);
ruta_C30.addEstacion(ricaurte_E);
ruta_C30.addEstacion(calle26);
ruta_C30.addEstacion(calle34);
ruta_C30.addEstacion(virrey);
ruta_C30.addEstacion(calle85);
ruta_C30.addEstacion(calle100);
ruta_C30.addEstacion(puenteLargo);
ruta_C30.addEstacion(portalSuba);

ruta_C50.addEstacion(calle161);
ruta_C50.addEstacion(calle142);
ruta_C50.addEstacion(virrey);
ruta_C50.addEstacion(calle85);
ruta_C50.addEstacion(heroes);
ruta_C50.addEstacion(escuelaMilitar);
ruta_C50.addEstacion(rionegro);
ruta_C50.addEstacion(puenteLargo);
ruta_C50.addEstacion(subaCl116);
ruta_C50.addEstacion(angeles21);
ruta_C50.addEstacion(subaTV91);
ruta_C50.addEstacion(laCampina);
ruta_C50.addEstacion(portalSuba);

ruta_C73.addEstacion(portal20Julio);
ruta_C73.addEstacion(countrySur);
ruta_C73.addEstacion(avenidaPrimeroMayo);
ruta_C73.addEstacion(sanBernardo);
ruta_C73.addEstacion(bicentenario);
ruta_C73.addEstacion(tygua_san_jose);
ruta_C73.addEstacion(guatoque_veraguas);
ruta_C73.addEstacion(ricaurte_E);
ruta_C73.addEstacion(calle26);
ruta_C73.addEstacion(calle34);
ruta_C73.addEstacion(virrey);
ruta_C73.addEstacion(calle85);
ruta_C73.addEstacion(puenteLargo);
ruta_C73.addEstacion(portalSuba);

ruta_C84.addEstacion(portalEldorado);
ruta_C84.addEstacion(avenidaRojas);
ruta_C84.addEstacion(calle26);
ruta_C84.addEstacion(ciudadUniversitaria);
ruta_C84.addEstacion(calle34);
ruta_C84.addEstacion(calle57);
ruta_C84.addEstacion(heroes);
ruta_C84.addEstacion(calle85);
ruta_C84.addEstacion(virrey);
ruta_C84.addEstacion(calle100);
ruta_C84.addEstacion(alcala);
ruta_C84.addEstacion(calle146);
ruta_C84.addEstacion(portalNorte);

ruta_D10.addEstacion(portalNorte);
ruta_D10.addEstacion(calle187);
ruta_D10.addEstacion(toberin);
ruta_D10.addEstacion(mazuren);
ruta_D10.addEstacion(alcala);
ruta_D10.addEstacion(pepeSierra);
ruta_D10.addEstacion(virrey);
ruta_D10.addEstacion(calle85);
ruta_D10.addEstacion(heroes);
ruta_D10.addEstacion(avenidaCali);
ruta_D10.addEstacion(carrera90);
ruta_D10.addEstacion(portal80);

ruta_D21.addEstacion(portalTunal);
ruta_D21.addEstacion(olaya);
ruta_D21.addEstacion(quiroga);
ruta_D21.addEstacion(calle40Sur);
ruta_D21.addEstacion(santaLucia);
ruta_D21.addEstacion(marly);
ruta_D21.addEstacion(calle57);
ruta_D21.addEstacion(heroes);
ruta_D21.addEstacion(virrey);
ruta_D21.addEstacion(calle100);
ruta_D21.addEstacion(avenidaCali);
ruta_D21.addEstacion(carrera90);
ruta_D21.addEstacion(portal80);

ruta_D22.addEstacion(portalSur);
ruta_D22.addEstacion(venecia);
ruta_D22.addEstacion(sevillana);
ruta_D22.addEstacion(ricaurte_E);
ruta_D22.addEstacion(calle26);
ruta_D22.addEstacion(heroes);
ruta_D22.addEstacion(virrey);
ruta_D22.addEstacion(pepeSierra);
ruta_D22.addEstacion(calle146);
ruta_D22.addEstacion(calle161);
ruta_D22.addEstacion(portalNorte);

ruta_D24.addEstacion(universidades_J);
ruta_D24.addEstacion(calle76);
ruta_D24.addEstacion(escuelaMilitar);
ruta_D24.addEstacion(minutoDeDios);
ruta_D24.addEstacion(avenidaCali);
ruta_D24.addEstacion(carrera90);
ruta_D24.addEstacion(portal80);

ruta_D55.addEstacion(toberin);
ruta_D55.addEstacion(mazuren);
ruta_D55.addEstacion(alcala);
ruta_D55.addEstacion(pepeSierra);
ruta_D55.addEstacion(virrey);
ruta_D55.addEstacion(calle85);
ruta_D55.addEstacion(avenidaCali);
ruta_D55.addEstacion(carrera90);
ruta_D55.addEstacion(portal80);

ruta_D81.addEstacion(portal80);
ruta_D81.addEstacion(carrera90);
ruta_D81.addEstacion(avenidaCali);
ruta_D81.addEstacion(granjaCra77);
ruta_D81.addEstacion(minutoDeDios);
ruta_D81.addEstacion(ferias);
ruta_D81.addEstacion(carrera53);
ruta_D81.addEstacion(escuelaMilitar);
ruta_D81.addEstacion(polo);
ruta_D81.addEstacion(heroes);

ruta_E32.addEstacion(portalAmericas);
ruta_E32.addEstacion(transversal86);
ruta_E32.addEstacion(banderas);
ruta_E32.addEstacion(avAmericasBoyaca);
ruta_E32.addEstacion(puenteAranda);
ruta_E32.addEstacion(zonaIndustrial);
ruta_E32.addEstacion(cad);
ruta_E32.addEstacion(avElDorado);
ruta_E32.addEstacion(uNacional);
ruta_E32.addEstacion(avChile);
ruta_E32.addEstacion(sieteDeAgosto);
ruta_E32.addEstacion(nqsCalle75);

ruta_E42.addEstacion(portalUsme);
ruta_E42.addEstacion(socorro);
ruta_E42.addEstacion(santaLucia);
ruta_E42.addEstacion(calle40Sur);
ruta_E42.addEstacion(olaya);
ruta_E42.addEstacion(fucha);
ruta_E42.addEstacion(restrepo);
ruta_E42.addEstacion(hospital);
ruta_E42.addEstacion(sanDiego);
ruta_E42.addEstacion(calle26);
ruta_E42.addEstacion(centroDeMemoria);

ruta_F19.addEstacion(portalSuba);
ruta_F19.addEstacion(nizaCl127);
ruta_F19.addEstacion(humedalCordoba);
ruta_F19.addEstacion(subaCl116);
ruta_F19.addEstacion(puenteLargo);
ruta_F19.addEstacion(calle100);
ruta_F19.addEstacion(virrey);
ruta_F19.addEstacion(calle85);
ruta_F19.addEstacion(calle76);
ruta_F19.addEstacion(calle63);
ruta_F19.addEstacion(calle45);
ruta_F19.addEstacion(calle39);
ruta_F19.addEstacion(calle26);
ruta_F19.addEstacion(ciudadUniversitaria);
ruta_F19.addEstacion(ricaurte_F);
ruta_F19.addEstacion(banderas);

ruta_F23.addEstacion(aguas);
ruta_F23.addEstacion(museoDelOro);
ruta_F23.addEstacion(avJimenez_F);
ruta_F23.addEstacion(sanFaconKR22);
ruta_F23.addEstacion(ricaurte_F);
ruta_F23.addEstacion(banderas);
ruta_F23.addEstacion(patioBonito);
ruta_F23.addEstacion(portalAmericas);

ruta_F26.addEstacion(alcala);
ruta_F26.addEstacion(pepeSierra);
ruta_F26.addEstacion(calle106);
ruta_F26.addEstacion(virrey);
ruta_F26.addEstacion(calle85);
ruta_F26.addEstacion(calle76);
ruta_F26.addEstacion(calle63);
ruta_F26.addEstacion(marly);
ruta_F26.addEstacion(calle45);
ruta_F26.addEstacion(calle26);
ruta_F26.addEstacion(bibliotecaTintal);
ruta_F26.addEstacion(portalAmericas);

ruta_F28.addEstacion(portalSuba);
ruta_F28.addEstacion(nizaCl127);
ruta_F28.addEstacion(humedalCordoba);
ruta_F28.addEstacion(subaCl116);
ruta_F28.addEstacion(puenteLargo);
ruta_F28.addEstacion(calle100);
ruta_F28.addEstacion(virrey);
ruta_F28.addEstacion(calle85);
ruta_F28.addEstacion(calle63);
ruta_F28.addEstacion(calle57);
ruta_F28.addEstacion(heroes);

ruta_F32.addEstacion(nqsCalle75);
ruta_F32.addEstacion(calle57);
ruta_F32.addEstacion(museoNacional);
ruta_F32.addEstacion(avJimenez_F);
ruta_F32.addEstacion(avElDorado);
ruta_F32.addEstacion(puenteAranda);
ruta_F32.addEstacion(distritoGrafiti);
ruta_F32.addEstacion(pradera);
ruta_F32.addEstacion(banderas);
ruta_F32.addEstacion(transversal86);
ruta_F32.addEstacion(patioBonito);
ruta_F32.addEstacion(portalAmericas);

ruta_F51.addEstacion(museoNacional);
ruta_F51.addEstacion(sanDiego);
ruta_F51.addEstacion(lasNieves);
ruta_F51.addEstacion(ricaurte_F);
ruta_F51.addEstacion(distritoGrafiti);
ruta_F51.addEstacion(pradera);
ruta_F51.addEstacion(marsella);
ruta_F51.addEstacion(avAmericasBoyaca);
ruta_F51.addEstacion(mandalay);
ruta_F51.addEstacion(banderas);
ruta_F51.addEstacion(bibliotecaTintal);
ruta_F51.addEstacion(portalAmericas);

ruta_F60.addEstacion(calle76);
ruta_F60.addEstacion(calle72);
ruta_F60.addEstacion(floresAreandina);
ruta_F60.addEstacion(calle63);
ruta_F60.addEstacion(marly);
ruta_F60.addEstacion(calle45);
ruta_F60.addEstacion(calle26);
ruta_F60.addEstacion(bibliotecaTintal);
ruta_F60.addEstacion(transversal86);
ruta_F60.addEstacion(portalAmericas);

ruta_F61.addEstacion(polo);
ruta_F61.addEstacion(calle57);
ruta_F61.addEstacion(museoNacional);
ruta_F61.addEstacion(avJimenez_F);
ruta_F61.addEstacion(sanFaconKR22);
ruta_F61.addEstacion(ricaurte_F);
ruta_F61.addEstacion(distritoGrafiti);
ruta_F61.addEstacion(pradera);
ruta_F61.addEstacion(transversal86);
ruta_F61.addEstacion(portalAmericas);

ruta_G11.addEstacion(terminalNorte);
ruta_G11.addEstacion(calle187);
ruta_G11.addEstacion(toberin);
ruta_G11.addEstacion(mazuren);
ruta_G11.addEstacion(calle146);
ruta_G11.addEstacion(pepeSierra);
ruta_G11.addEstacion(virrey);
ruta_G11.addEstacion(calle85);
ruta_G11.addEstacion(heroes);
ruta_G11.addEstacion(escuelaMilitar);
ruta_G11.addEstacion(avChile);
ruta_G11.addEstacion(avElDorado);
ruta_G11.addEstacion(cad);
ruta_G11.addEstacion(ricaurte_F);
ruta_G11.addEstacion(alqueria);
ruta_G11.addEstacion(venecia);
ruta_G11.addEstacion(portalSur);

ruta_G12.addEstacion(portalSur);
ruta_G12.addEstacion(alqueria);
ruta_G12.addEstacion(venecia);
ruta_G12.addEstacion(generalSantander);
ruta_G12.addEstacion(ricaurte_F);
ruta_G12.addEstacion(avElDorado);
ruta_G12.addEstacion(uNacional);
ruta_G12.addEstacion(campinUAN);
ruta_G12.addEstacion(escuelaMilitar);
ruta_G12.addEstacion(heroes);
ruta_G12.addEstacion(calle85);
ruta_G12.addEstacion(portalNorte);

ruta_G22.addEstacion(portalSur);
ruta_G22.addEstacion(perdomo);
ruta_G22.addEstacion(cCPaseoVillaDelRio);
ruta_G22.addEstacion(sevillana);
ruta_G22.addEstacion(venecia);
ruta_G22.addEstacion(alqueria);
ruta_G22.addEstacion(generalSantander);
ruta_G22.addEstacion(ricaurte_F);
ruta_G22.addEstacion(santaIsabel);
ruta_G22.addEstacion(comuneros);
ruta_G22.addEstacion(calle19);

ruta_G30.addEstacion(portalSuba);
ruta_G30.addEstacion(laCampina);
ruta_G30.addEstacion(subaTV91);
ruta_G30.addEstacion(subaCl116);
ruta_G30.addEstacion(puenteLargo);
ruta_G30.addEstacion(subaCl95);
ruta_G30.addEstacion(nqsCalle75);
ruta_G30.addEstacion(movistarArena);
ruta_G30.addEstacion(uNacional);
ruta_G30.addEstacion(ricaurte_F);
ruta_G30.addEstacion(santaIsabel);
ruta_G30.addEstacion(generalSantander);
ruta_G30.addEstacion(portalSur);

ruta_G41.addEstacion(bicentenario);
ruta_G41.addEstacion(tygua_san_jose);
ruta_G41.addEstacion(guatoque_veraguas);
ruta_G41.addEstacion(ricaurte_F);
ruta_G41.addEstacion(santaIsabel);
ruta_G41.addEstacion(generalSantander);
ruta_G41.addEstacion(nqsCL30Sur);
ruta_G41.addEstacion(alqueria);
ruta_G41.addEstacion(bosa);
ruta_G41.addEstacion(terrerosHospitalCV);
ruta_G41.addEstacion(sanMateoCCUnisur);

ruta_G42.addEstacion(sieteDeAgosto);
ruta_G42.addEstacion(movistarArena);
ruta_G42.addEstacion(cad);
ruta_G42.addEstacion(avElDorado);
ruta_G42.addEstacion(centroDeMemoria);
ruta_G42.addEstacion(ciudadUniversitaria);
ruta_G42.addEstacion(guatoque_veraguas);
ruta_G42.addEstacion(ricaurte_F);
ruta_G42.addEstacion(santaIsabel);
ruta_G42.addEstacion(generalSantander);
ruta_G42.addEstacion(portalSur);

ruta_G43.addEstacion(portalSur);
ruta_G43.addEstacion(bosa);
ruta_G43.addEstacion(laDespensa);
ruta_G43.addEstacion(leonXIII);
ruta_G43.addEstacion(terrerosHospitalCV);
ruta_G43.addEstacion(sanMateoCCUnisur);

ruta_G45.addEstacion(portalSur);
ruta_G45.addEstacion(perdomo);
ruta_G45.addEstacion(sevillana);
ruta_G45.addEstacion(venecia);
ruta_G45.addEstacion(alqueria);
ruta_G45.addEstacion(generalSantander);
ruta_G45.addEstacion(ricaurte_F);
ruta_G45.addEstacion(calle19);
ruta_G45.addEstacion(ciudadUniversitaria);
ruta_G45.addEstacion(cad);

ruta_G46.addEstacion(portalSur);
ruta_G46.addEstacion(bosa);
ruta_G46.addEstacion(laDespensa);
ruta_G46.addEstacion(leonXIII);
ruta_G46.addEstacion(terrerosHospitalCV);
ruta_G46.addEstacion(sanMateoCCUnisur);

ruta_G45.addEstacion(portalSur);
ruta_G45.addEstacion(bosa);
ruta_G45.addEstacion(laDespensa);
ruta_G45.addEstacion(leonXIII);
ruta_G45.addEstacion(terrerosHospitalCV);
ruta_G45.addEstacion(sanMateoCCUnisur);

ruta_G47.addEstacion(portalSur);
ruta_G47.addEstacion(bosa);
ruta_G47.addEstacion(laDespensa);
ruta_G47.addEstacion(leonXIII);
ruta_G47.addEstacion(terrerosHospitalCV);

ruta_G52.addEstacion(portalSur);
ruta_G52.addEstacion(bosa);
ruta_G52.addEstacion(laDespensa);
ruta_G52.addEstacion(leonXIII);
ruta_G52.addEstacion(terrerosHospitalCV);

ruta_H13.addEstacion(portalNorte);
ruta_H13.addEstacion(mazuren);
ruta_H13.addEstacion(calle142);
ruta_H13.addEstacion(calle106);
ruta_H13.addEstacion(calle100);
ruta_H13.addEstacion(calle85);
ruta_H13.addEstacion(floresAreandina);
ruta_H13.addEstacion(calle63);
ruta_H13.addEstacion(avJimenez_F);
ruta_H13.addEstacion(restrepo);
ruta_H13.addEstacion(quiroga);
ruta_H13.addEstacion(calle40Sur);
ruta_H13.addEstacion(portalTunal);

ruta_G15.addEstacion(portalSur);
ruta_G15.addEstacion(alqueria);
ruta_G15.addEstacion(venecia);
ruta_G15.addEstacion(generalSantander);
ruta_G15.addEstacion(ricaurte_F);
ruta_G15.addEstacion(santaIsabel);

ruta_H15.addEstacion(portalSur);
ruta_H15.addEstacion(alqueria);
ruta_H15.addEstacion(venecia);
ruta_H15.addEstacion(generalSantander);
ruta_H15.addEstacion(ricaurte_F);
ruta_H15.addEstacion(santaIsabel);

ruta_H17.addEstacion(portalUsme);
ruta_H17.addEstacion(socorro);
ruta_H17.addEstacion(santaLucia);
ruta_H17.addEstacion(calle40Sur);
ruta_H17.addEstacion(quiroga);
ruta_H17.addEstacion(restrepo);
ruta_H17.addEstacion(hortua);
ruta_H17.addEstacion(hospital);
ruta_H17.addEstacion(museoNacional);
ruta_H17.addEstacion(calle72);

ruta_H20.addEstacion(portal80);
ruta_H20.addEstacion(ferias);
ruta_H20.addEstacion(boyaca);
ruta_H20.addEstacion(minutoDeDios);
ruta_H20.addEstacion(carrera90);
ruta_H20.addEstacion(avenidaCali);

ruta_H21.addEstacion(portal80);
ruta_H21.addEstacion(calle72);
ruta_H21.addEstacion(heroes);
ruta_H21.addEstacion(escuelaMilitar);
ruta_H21.addEstacion(polo);
ruta_H21.addEstacion(hospital);
ruta_H21.addEstacion(restrepo);
ruta_H21.addEstacion(santaLucia);
ruta_H21.addEstacion(socorro);
ruta_H21.addEstacion(portalTunal);

ruta_H27.addEstacion(portalTunal);
ruta_H27.addEstacion(socorro);
ruta_H27.addEstacion(santaLucia);
ruta_H27.addEstacion(calle40Sur);
ruta_H27.addEstacion(olaya);
ruta_H27.addEstacion(fucha);
ruta_H27.addEstacion(hospital);
ruta_H27.addEstacion(escuelaMilitar);
ruta_H27.addEstacion(polo);
ruta_H27.addEstacion(calle72);

ruta_H54.addEstacion(portalEldorado);
ruta_H54.addEstacion(modelia);
ruta_H54.addEstacion(avenidaRojas);
ruta_H54.addEstacion(elTiempoCamaraComercio);
ruta_H54.addEstacion(salitreElGreco);
ruta_H54.addEstacion(can);
ruta_H54.addEstacion(quintaParedes);
ruta_H54.addEstacion(corferias);
ruta_H54.addEstacion(ciudadUniversitaria);
ruta_H54.addEstacion(hortua);
ruta_H54.addEstacion(restrepo);
ruta_H54.addEstacion(calle40Sur);
ruta_H54.addEstacion(molinos);
ruta_H54.addEstacion(portalUsme);

ruta_H72.addEstacion(toberin);
ruta_H72.addEstacion(mazuren);
ruta_H72.addEstacion(calle142);
ruta_H72.addEstacion(pepeSierra);
ruta_H72.addEstacion(virrey);
ruta_H72.addEstacion(heroes);
ruta_H72.addEstacion(museoNacional);
ruta_H72.addEstacion(hospital);
ruta_H72.addEstacion(olaya);
ruta_H72.addEstacion(molinos);
ruta_H72.addEstacion(portalUsme);

ruta_H73.addEstacion(toberin);
ruta_H73.addEstacion(mazuren);
ruta_H73.addEstacion(calle142);
ruta_H73.addEstacion(pepeSierra);
ruta_H73.addEstacion(virrey);
ruta_H73.addEstacion(heroes);
ruta_H73.addEstacion(museoNacional);
ruta_H73.addEstacion(hospital);
ruta_H73.addEstacion(olaya);
ruta_H73.addEstacion(portalTunal);

ruta_H75.addEstacion(portalUsme);
ruta_H75.addEstacion(molinos);
ruta_H75.addEstacion(restrepo);
ruta_H75.addEstacion(hospital);
ruta_H75.addEstacion(museoNacional);
ruta_H75.addEstacion(virrey);
ruta_H75.addEstacion(calle85);
ruta_H75.addEstacion(heroes);

ruta_H76.addEstacion(portal80);
ruta_H76.addEstacion(granjaCra77);
ruta_H76.addEstacion(avenidaCali);
ruta_H76.addEstacion(minutoDeDios);
ruta_H76.addEstacion(escuelaMilitar);
ruta_H76.addEstacion(heroes);

ruta_H83.addEstacion(portal80);
ruta_H83.addEstacion(granjaCra77);
ruta_H83.addEstacion(avenidaCali);
ruta_H83.addEstacion(minutoDeDios);
ruta_H83.addEstacion(escuelaMilitar);
ruta_H83.addEstacion(heroes);

ruta_J23.addEstacion(portalAmericas);
ruta_J23.addEstacion(banderas);
ruta_J23.addEstacion(marsella);
ruta_J23.addEstacion(pradera);
ruta_J23.addEstacion(calle19);
ruta_J23.addEstacion(calle26);
ruta_J23.addEstacion(ciudadUniversitaria);

ruta_J24.addEstacion(portal80);
ruta_J24.addEstacion(carrera90);
ruta_J24.addEstacion(avenidaCali);
ruta_J24.addEstacion(granjaCra77);
ruta_J24.addEstacion(minutoDeDios);
ruta_J24.addEstacion(carrera47);
ruta_J24.addEstacion(escuelaMilitar);
ruta_J24.addEstacion(polo);
ruta_J24.addEstacion(calle76);
ruta_J24.addEstacion(calle72);
ruta_J24.addEstacion(calle57);
ruta_J24.addEstacion(marly);
ruta_J24.addEstacion(universidades_J);

ruta_J70.addEstacion(portalNorte);
ruta_J70.addEstacion(calle187);
ruta_J70.addEstacion(calle161);
ruta_J70.addEstacion(mazuren);
ruta_J70.addEstacion(calle146);
ruta_J70.addEstacion(pepeSierra);
ruta_J70.addEstacion(calle100);
ruta_J70.addEstacion(virrey);
ruta_J70.addEstacion(calle85);
ruta_J70.addEstacion(heroes);
ruta_J70.addEstacion(museoDelOro);
ruta_J70.addEstacion(aguas);

ruta_J73.addEstacion(portalSuba);
ruta_J73.addEstacion(laCampina);
ruta_J73.addEstacion(subaTV91);
ruta_J73.addEstacion(angeles21);
ruta_J73.addEstacion(gratamira);
ruta_J73.addEstacion(subaAVBoyaca);
ruta_J73.addEstacion(ciudadUniversitaria);
ruta_J73.addEstacion(universidades_J);

ruta_J74.addEstacion(portalNorte);
ruta_J74.addEstacion(calle187);
ruta_J74.addEstacion(calle161);
ruta_J74.addEstacion(mazuren);
ruta_J74.addEstacion(calle146);
ruta_J74.addEstacion(pepeSierra);
ruta_J74.addEstacion(calle100);
ruta_J74.addEstacion(virrey);
ruta_J74.addEstacion(calle85);
ruta_J74.addEstacion(heroes);
ruta_J74.addEstacion(calle19);

ruta_J76.addEstacion(portalNorte);
ruta_J76.addEstacion(calle187);
ruta_J76.addEstacion(calle161);
ruta_J76.addEstacion(mazuren);
ruta_J76.addEstacion(calle146);
ruta_J76.addEstacion(pepeSierra);
ruta_J76.addEstacion(calle100);
ruta_J76.addEstacion(virrey);
ruta_J76.addEstacion(calle85);
ruta_J76.addEstacion(heroes);
ruta_J76.addEstacion(calle26);
ruta_J76.addEstacion(ciudadUniversitaria);
ruta_J76.addEstacion(universidades_J);

ruta_K10.addEstacion(portalEldorado);
ruta_K10.addEstacion(modelia);
ruta_K10.addEstacion(normandia);
ruta_K10.addEstacion(avenidaRojas);
ruta_K10.addEstacion(elTiempoCamaraComercio);
ruta_K10.addEstacion(salitreElGreco);
ruta_K10.addEstacion(can);
ruta_K10.addEstacion(gobernacion);
ruta_K10.addEstacion(quintaParedes);
ruta_K10.addEstacion(corferias);
ruta_K10.addEstacion(ciudadUniversitaria);
ruta_K10.addEstacion(concejoDeBogota);
ruta_K10.addEstacion(calle26);

ruta_K16.addEstacion(terminalNorte);
ruta_K16.addEstacion(calle187);
ruta_K16.addEstacion(mazuren);
ruta_K16.addEstacion(calle146);
ruta_K16.addEstacion(pepeSierra);
ruta_K16.addEstacion(calle100);
ruta_K16.addEstacion(virrey);
ruta_K16.addEstacion(calle85);
ruta_K16.addEstacion(heroes);
ruta_K16.addEstacion(escuelaMilitar);
ruta_K16.addEstacion(salitreElGreco);
ruta_K16.addEstacion(can);
ruta_K16.addEstacion(quintaParedes);
ruta_K16.addEstacion(portalEldorado);

ruta_K23.addEstacion(alcala);
ruta_K23.addEstacion(prado);
ruta_K23.addEstacion(calle85);
ruta_K23.addEstacion(heroes);
ruta_K23.addEstacion(calle76);
ruta_K23.addEstacion(salitreElGreco);
ruta_K23.addEstacion(quintaParedes);
ruta_K23.addEstacion(portalEldorado);

ruta_K43.addEstacion(portalAmericas);
ruta_K43.addEstacion(patioBonito);
ruta_K43.addEstacion(transversal86);
ruta_K43.addEstacion(banderas);
ruta_K43.addEstacion(marsella);
ruta_K43.addEstacion(pradera);
ruta_K43.addEstacion(salitreElGreco);
ruta_K43.addEstacion(quintaParedes);
ruta_K43.addEstacion(can);
ruta_K43.addEstacion(portalEldorado);

ruta_K54.addEstacion(portalUsme);
ruta_K54.addEstacion(molinos);
ruta_K54.addEstacion(hortua);
ruta_K54.addEstacion(restrepo);
ruta_K54.addEstacion(avenidaRojas);
ruta_K54.addEstacion(modelia);
ruta_K54.addEstacion(portalEldorado);

ruta_K86.addEstacion(calle85);
ruta_K86.addEstacion(museoNacional);
ruta_K86.addEstacion(quintaParedes);
ruta_K86.addEstacion(can);
ruta_K86.addEstacion(portalEldorado);

ruta_L10.addEstacion(portal20Julio);
ruta_L10.addEstacion(sanBernardo);
ruta_L10.addEstacion(bicentenario);
ruta_L10.addEstacion(sanVictorino);
ruta_L10.addEstacion(museoNacional);

ruta_L18.addEstacion(portal20Julio);
ruta_L18.addEstacion(policarpa);
ruta_L18.addEstacion(sanBernardo);
ruta_L18.addEstacion(museoNacional);

ruta_L25.addEstacion(portalSuba);
ruta_L25.addEstacion(subaTV91);
ruta_L25.addEstacion(subaAVBoyaca);
ruta_L25.addEstacion(nizaCl127);
ruta_L25.addEstacion(subaCl95);
ruta_L25.addEstacion(avChile);
ruta_L25.addEstacion(movistarArena);
ruta_L25.addEstacion(campinUAN);
ruta_L25.addEstacion(guatoque_veraguas);
ruta_L25.addEstacion(tygua_san_jose);
ruta_L25.addEstacion(bicentenario);
ruta_L25.addEstacion(avenidaPrimeroMayo);
ruta_L25.addEstacion(countrySur);
ruta_L25.addEstacion(portal20Julio);

ruta_L41.addEstacion(sanMateoCCUnisur);
ruta_L41.addEstacion(socorro);
ruta_L41.addEstacion(santaLucia);
ruta_L41.addEstacion(olaya);
ruta_L41.addEstacion(fucha);
ruta_L41.addEstacion(restrepo);
ruta_L41.addEstacion(hospital);
ruta_L41.addEstacion(bicentenario);


ruta_L81.addEstacion(ferias);
ruta_L81.addEstacion(boyaca);
ruta_L81.addEstacion(minutoDeDios);
ruta_L81.addEstacion(escuelaMilitar);
ruta_L81.addEstacion(museoNacional);
ruta_L81.addEstacion(sanVictorino);
ruta_L81.addEstacion(bicentenario);
ruta_L81.addEstacion(avenidaPrimeroMayo);
ruta_L81.addEstacion(countrySur);
ruta_L81.addEstacion(portal20Julio);

ruta_L82.addEstacion(portal20Julio);
ruta_L82.addEstacion(countrySur);
ruta_L82.addEstacion(avenidaPrimeroMayo);
ruta_L82.addEstacion(bicentenario);
ruta_L82.addEstacion(sanDiego);

ruta_M47.addEstacion(portalSur);
ruta_M47.addEstacion(perdomo);
ruta_M47.addEstacion(sevillana);
ruta_M47.addEstacion(venecia);
ruta_M47.addEstacion(alqueria);
ruta_M47.addEstacion(nqsCL38ASur);
ruta_M47.addEstacion(nqsCL30Sur);
ruta_M47.addEstacion(guatoque_veraguas);
ruta_M47.addEstacion(tygua_san_jose);
ruta_M47.addEstacion(sanVictorino);
ruta_M47.addEstacion(lasNieves);
ruta_M47.addEstacion(sanDiego);
ruta_M47.addEstacion(museoNacional);

ruta_M51.addEstacion(portalEldorado);
ruta_M51.addEstacion(avenidaRojas);
ruta_M51.addEstacion(elTiempoCamaraComercio);
ruta_M51.addEstacion(salitreElGreco);
ruta_M51.addEstacion(can);
ruta_M51.addEstacion(gobernacion);
ruta_M51.addEstacion(quintaParedes);
ruta_M51.addEstacion(corferias);
ruta_M51.addEstacion(ciudadUniversitaria);
ruta_M51.addEstacion(concejoDeBogota);

ruta_M82.addEstacion(portal20Julio);
ruta_M82.addEstacion(countrySur);
ruta_M82.addEstacion(avenidaPrimeroMayo);
ruta_M82.addEstacion(bicentenario);
ruta_M82.addEstacion(sanDiego);

ruta_M83.addEstacion(portal20Julio);
ruta_M83.addEstacion(avenidaPrimeroMayo);
ruta_M83.addEstacion(bicentenario);
ruta_M83.addEstacion(sanDiego);

System.out.println("=================== Anadimos estaciones a rutas");

RelacionBusRutaConductor rbrc1 = new RelacionBusRutaConductor(bus1, ruta_1, conductor1);
RelacionBusRutaConductor rbrc2 = new RelacionBusRutaConductor(bus2, ruta_2, conductor2);
RelacionBusRutaConductor rbrc3 = new RelacionBusRutaConductor(bus3, ruta_3, conductor3);
RelacionBusRutaConductor rbrc4 = new RelacionBusRutaConductor(bus4, ruta_4, conductor4);
RelacionBusRutaConductor rbrc5 = new RelacionBusRutaConductor(bus5, ruta_5, conductor5);

RelacionBusRutaConductor rbrc6 = new RelacionBusRutaConductor(bus6, ruta_6, conductor6);
RelacionBusRutaConductor rbrc7 = new RelacionBusRutaConductor(bus7, ruta_7, conductor7);
RelacionBusRutaConductor rbrc8 = new RelacionBusRutaConductor(bus8, ruta_8, conductor8);
RelacionBusRutaConductor rbrc9 = new RelacionBusRutaConductor(bus9, ruta_A52, conductor9);
RelacionBusRutaConductor rbrc10 = new RelacionBusRutaConductor(bus10, ruta_A60, conductor10);

RelacionBusRutaConductor rbrc11 = new RelacionBusRutaConductor(bus11, ruta_A61, conductor11);
RelacionBusRutaConductor rbrc12 = new RelacionBusRutaConductor(bus12, ruta_B10, conductor12);
RelacionBusRutaConductor rbrc13 = new RelacionBusRutaConductor(bus13, ruta_B11, conductor13);
RelacionBusRutaConductor rbrc14 = new RelacionBusRutaConductor(bus14, ruta_B12, conductor14);
RelacionBusRutaConductor rbrc15 = new RelacionBusRutaConductor(bus15, ruta_B13, conductor15);

RelacionBusRutaConductor rbrc16 = new RelacionBusRutaConductor(bus16, ruta_B16, conductor16);
RelacionBusRutaConductor rbrc17 = new RelacionBusRutaConductor(bus17, ruta_B18, conductor17);
RelacionBusRutaConductor rbrc18 = new RelacionBusRutaConductor(bus18, ruta_B23, conductor18);
RelacionBusRutaConductor rbrc19 = new RelacionBusRutaConductor(bus19, ruta_B26, conductor19);
RelacionBusRutaConductor rbrc20 = new RelacionBusRutaConductor(bus20, ruta_B27, conductor20);

RelacionBusRutaConductor rbrc21 = new RelacionBusRutaConductor(bus21, ruta_B28, conductor21);
RelacionBusRutaConductor rbrc22 = new RelacionBusRutaConductor(bus22, ruta_B46, conductor22);
RelacionBusRutaConductor rbrc23 = new RelacionBusRutaConductor(bus23, ruta_B50, conductor23);
RelacionBusRutaConductor rbrc24 = new RelacionBusRutaConductor(bus24, ruta_B55, conductor24);
RelacionBusRutaConductor rbrc25 = new RelacionBusRutaConductor(bus25, ruta_B72, conductor25);

RelacionBusRutaConductor rbrc26 = new RelacionBusRutaConductor(bus26, ruta_B74, conductor26);
RelacionBusRutaConductor rbrc27 = new RelacionBusRutaConductor(bus27, ruta_B75, conductor27);
RelacionBusRutaConductor rbrc28 = new RelacionBusRutaConductor(bus28, ruta_C15, conductor28);
RelacionBusRutaConductor rbrc29 = new RelacionBusRutaConductor(bus29, ruta_C17, conductor29);
RelacionBusRutaConductor rbrc30 = new RelacionBusRutaConductor(bus30, ruta_C19, conductor30);

RelacionBusRutaConductor rbrc31 = new RelacionBusRutaConductor(bus31, ruta_C25, conductor31);
RelacionBusRutaConductor rbrc32 = new RelacionBusRutaConductor(bus32, ruta_C30, conductor32);
RelacionBusRutaConductor rbrc33 = new RelacionBusRutaConductor(bus33, ruta_C50, conductor33);
RelacionBusRutaConductor rbrc34 = new RelacionBusRutaConductor(bus34, ruta_C73, conductor34);
RelacionBusRutaConductor rbrc35 = new RelacionBusRutaConductor(bus35, ruta_C84, conductor35);

RelacionBusRutaConductor rbrc36 = new RelacionBusRutaConductor(bus36, ruta_D10, conductor36);
RelacionBusRutaConductor rbrc37 = new RelacionBusRutaConductor(bus37, ruta_D21, conductor37);
RelacionBusRutaConductor rbrc38 = new RelacionBusRutaConductor(bus38, ruta_D22, conductor38);
RelacionBusRutaConductor rbrc39 = new RelacionBusRutaConductor(bus39, ruta_D24, conductor39);
RelacionBusRutaConductor rbrc40 = new RelacionBusRutaConductor(bus40, ruta_D55, conductor40);

RelacionBusRutaConductor rbrc41 = new RelacionBusRutaConductor(bus41, ruta_D81, conductor41);
RelacionBusRutaConductor rbrc42 = new RelacionBusRutaConductor(bus42, ruta_E32, conductor42);
RelacionBusRutaConductor rbrc43 = new RelacionBusRutaConductor(bus43, ruta_E42, conductor43);
RelacionBusRutaConductor rbrc44 = new RelacionBusRutaConductor(bus44, ruta_F19, conductor44);
RelacionBusRutaConductor rbrc45 = new RelacionBusRutaConductor(bus45, ruta_F23, conductor45);

RelacionBusRutaConductor rbrc46 = new RelacionBusRutaConductor(bus46, ruta_F26, conductor46);
RelacionBusRutaConductor rbrc47 = new RelacionBusRutaConductor(bus47, ruta_F28, conductor47);
RelacionBusRutaConductor rbrc48 = new RelacionBusRutaConductor(bus48, ruta_F32, conductor48);
RelacionBusRutaConductor rbrc49 = new RelacionBusRutaConductor(bus49, ruta_F51, conductor49);
RelacionBusRutaConductor rbrc50 = new RelacionBusRutaConductor(bus50, ruta_F60, conductor50);

RelacionBusRutaConductor rbrc51 = new RelacionBusRutaConductor(bus51, ruta_F61, conductor51);
RelacionBusRutaConductor rbrc52 = new RelacionBusRutaConductor(bus52, ruta_G11, conductor52);
RelacionBusRutaConductor rbrc53 = new RelacionBusRutaConductor(bus53, ruta_G12, conductor53);
RelacionBusRutaConductor rbrc54 = new RelacionBusRutaConductor(bus54, ruta_G15, conductor54);
RelacionBusRutaConductor rbrc55 = new RelacionBusRutaConductor(bus55, ruta_G22, conductor55);

RelacionBusRutaConductor rbrc56 = new RelacionBusRutaConductor(bus56, ruta_G30, conductor56);
RelacionBusRutaConductor rbrc57 = new RelacionBusRutaConductor(bus57, ruta_G41, conductor57);
RelacionBusRutaConductor rbrc58 = new RelacionBusRutaConductor(bus58, ruta_G42, conductor58);
RelacionBusRutaConductor rbrc59 = new RelacionBusRutaConductor(bus59, ruta_G43, conductor59);
RelacionBusRutaConductor rbrc60 = new RelacionBusRutaConductor(bus60, ruta_G45, conductor60);

RelacionBusRutaConductor rbrc61 = new RelacionBusRutaConductor(bus61, ruta_G46, conductor61);
RelacionBusRutaConductor rbrc62 = new RelacionBusRutaConductor(bus62, ruta_G47, conductor62);
RelacionBusRutaConductor rbrc63 = new RelacionBusRutaConductor(bus63, ruta_G52, conductor63);
RelacionBusRutaConductor rbrc64 = new RelacionBusRutaConductor(bus64, ruta_H13, conductor64);
RelacionBusRutaConductor rbrc65 = new RelacionBusRutaConductor(bus65, ruta_H15, conductor65);

RelacionBusRutaConductor rbrc66 = new RelacionBusRutaConductor(bus66, ruta_H17, conductor66);
RelacionBusRutaConductor rbrc67 = new RelacionBusRutaConductor(bus67, ruta_H20, conductor67);
RelacionBusRutaConductor rbrc68 = new RelacionBusRutaConductor(bus68, ruta_H21, conductor68);
RelacionBusRutaConductor rbrc69 = new RelacionBusRutaConductor(bus69, ruta_H27, conductor69);
RelacionBusRutaConductor rbrc70 = new RelacionBusRutaConductor(bus70, ruta_H54, conductor70);

RelacionBusRutaConductor rbrc71 = new RelacionBusRutaConductor(bus71, ruta_H72, conductor71);
RelacionBusRutaConductor rbrc72 = new RelacionBusRutaConductor(bus72, ruta_H73, conductor72);
RelacionBusRutaConductor rbrc73 = new RelacionBusRutaConductor(bus73, ruta_H75, conductor73);
RelacionBusRutaConductor rbrc74 = new RelacionBusRutaConductor(bus74, ruta_H76, conductor74);
RelacionBusRutaConductor rbrc75 = new RelacionBusRutaConductor(bus75, ruta_H83, conductor75);

RelacionBusRutaConductor rbrc76 = new RelacionBusRutaConductor(bus76, ruta_J23, conductor76);
RelacionBusRutaConductor rbrc77 = new RelacionBusRutaConductor(bus77, ruta_J24, conductor77);
RelacionBusRutaConductor rbrc78 = new RelacionBusRutaConductor(bus78, ruta_J70, conductor78);
RelacionBusRutaConductor rbrc79 = new RelacionBusRutaConductor(bus79, ruta_J73, conductor79);
RelacionBusRutaConductor rbrc80 = new RelacionBusRutaConductor(bus80, ruta_J74, conductor80);

RelacionBusRutaConductor rbrc81 = new RelacionBusRutaConductor(bus81, ruta_J76, conductor81);
RelacionBusRutaConductor rbrc82 = new RelacionBusRutaConductor(bus82, ruta_K10, conductor82);
RelacionBusRutaConductor rbrc83 = new RelacionBusRutaConductor(bus83, ruta_K16, conductor83);
RelacionBusRutaConductor rbrc84 = new RelacionBusRutaConductor(bus84, ruta_K23, conductor84);
RelacionBusRutaConductor rbrc85 = new RelacionBusRutaConductor(bus85, ruta_K43, conductor85);

RelacionBusRutaConductor rbrc86 = new RelacionBusRutaConductor(bus86, ruta_K54, conductor86);
RelacionBusRutaConductor rbrc87 = new RelacionBusRutaConductor(bus87, ruta_K86, conductor87);
RelacionBusRutaConductor rbrc88 = new RelacionBusRutaConductor(bus88, ruta_L10, conductor88);
RelacionBusRutaConductor rbrc89 = new RelacionBusRutaConductor(bus89, ruta_L18, conductor89);
RelacionBusRutaConductor rbrc90 = new RelacionBusRutaConductor(bus90, ruta_L25, conductor90);

RelacionBusRutaConductor rbrc91 = new RelacionBusRutaConductor(bus91, ruta_L41, conductor91);
RelacionBusRutaConductor rbrc92 = new RelacionBusRutaConductor(bus92, ruta_L81, conductor92);
RelacionBusRutaConductor rbrc93 = new RelacionBusRutaConductor(bus93, ruta_L82, conductor93);
RelacionBusRutaConductor rbrc94 = new RelacionBusRutaConductor(bus94, ruta_M47, conductor94);
RelacionBusRutaConductor rbrc95 = new RelacionBusRutaConductor(bus95, ruta_M51, conductor95);

RelacionBusRutaConductor rbrc96 = new RelacionBusRutaConductor(bus96, ruta_M82, conductor96);
RelacionBusRutaConductor rbrc97 = new RelacionBusRutaConductor(bus97, ruta_M83, conductor97);
RelacionBusRutaConductor rbrc98 = new RelacionBusRutaConductor(bus98, ruta_A52, conductor98);
RelacionBusRutaConductor rbrc99 = new RelacionBusRutaConductor(bus99, ruta_A60, conductor99);
RelacionBusRutaConductor rbrc100 = new RelacionBusRutaConductor(bus100, ruta_A61, conductor100);

        //Init Rel

        

buses.add(bus1);
buses.add(bus2);
buses.add(bus3);
buses.add(bus4);
buses.add(bus5);
buses.add(bus6);
buses.add(bus7);
buses.add(bus8);
buses.add(bus9);
buses.add(bus10);
buses.add(bus11);
buses.add(bus12);
buses.add(bus13);
buses.add(bus14);
buses.add(bus15);
buses.add(bus16);
buses.add(bus17);
buses.add(bus18);
buses.add(bus19);
buses.add(bus20);
buses.add(bus21);
buses.add(bus22);
buses.add(bus23);
buses.add(bus24);
buses.add(bus25);
buses.add(bus26);
buses.add(bus27);
buses.add(bus28);
buses.add(bus29);
buses.add(bus30);
buses.add(bus31);
buses.add(bus32);
buses.add(bus33);
buses.add(bus34);
buses.add(bus35);
buses.add(bus36);
buses.add(bus37);
buses.add(bus38);
buses.add(bus39);
buses.add(bus40);
buses.add(bus41);
buses.add(bus42);
buses.add(bus43);
buses.add(bus44);
buses.add(bus45);
buses.add(bus46);
buses.add(bus47);
buses.add(bus48);
buses.add(bus49);
buses.add(bus50);
buses.add(bus51);
buses.add(bus52);
buses.add(bus53);
buses.add(bus54);
buses.add(bus55);
buses.add(bus56);
buses.add(bus57);
buses.add(bus58);
buses.add(bus59);
buses.add(bus60);
buses.add(bus61);
buses.add(bus62);
buses.add(bus63);
buses.add(bus64);
buses.add(bus65);
buses.add(bus66);
buses.add(bus67);
buses.add(bus68);
buses.add(bus69);
buses.add(bus70);
buses.add(bus71);
buses.add(bus72);
buses.add(bus73);
buses.add(bus74);
buses.add(bus75);
buses.add(bus76);
buses.add(bus77);
buses.add(bus78);
buses.add(bus79);
buses.add(bus80);
buses.add(bus81);
buses.add(bus82);
buses.add(bus83);
buses.add(bus84);
buses.add(bus85);
buses.add(bus86);
buses.add(bus87);
buses.add(bus88);
buses.add(bus89);
buses.add(bus90);
buses.add(bus91);
buses.add(bus92);
buses.add(bus93);
buses.add(bus94);
buses.add(bus95);
buses.add(bus96);
buses.add(bus97);
buses.add(bus98);
buses.add(bus99);
buses.add(bus100);

conductores.add(conductor1);
conductores.add(conductor2);
conductores.add(conductor3);
conductores.add(conductor4);
conductores.add(conductor5);
conductores.add(conductor6);
conductores.add(conductor7);
conductores.add(conductor8);
conductores.add(conductor9);
conductores.add(conductor10);
conductores.add(conductor11);
conductores.add(conductor12);
conductores.add(conductor13);
conductores.add(conductor14);
conductores.add(conductor15);
conductores.add(conductor16);
conductores.add(conductor17);
conductores.add(conductor18);
conductores.add(conductor19);
conductores.add(conductor20);
conductores.add(conductor21);
conductores.add(conductor22);
conductores.add(conductor23);
conductores.add(conductor24);
conductores.add(conductor25);
conductores.add(conductor26);
conductores.add(conductor27);
conductores.add(conductor28);
conductores.add(conductor29);
conductores.add(conductor30);
conductores.add(conductor31);
conductores.add(conductor32);
conductores.add(conductor33);
conductores.add(conductor34);
conductores.add(conductor35);
conductores.add(conductor36);
conductores.add(conductor37);
conductores.add(conductor38);
conductores.add(conductor39);
conductores.add(conductor40);
conductores.add(conductor41);
conductores.add(conductor42);
conductores.add(conductor43);
conductores.add(conductor44);
conductores.add(conductor45);
conductores.add(conductor46);
conductores.add(conductor47);
conductores.add(conductor48);
conductores.add(conductor49);
conductores.add(conductor50);
conductores.add(conductor51);
conductores.add(conductor52);
conductores.add(conductor53);
conductores.add(conductor54);
conductores.add(conductor55);
conductores.add(conductor56);
conductores.add(conductor57);
conductores.add(conductor58);
conductores.add(conductor59);
conductores.add(conductor60);
conductores.add(conductor61);
conductores.add(conductor62);
conductores.add(conductor63);
conductores.add(conductor64);
conductores.add(conductor65);
conductores.add(conductor66);
conductores.add(conductor67);
conductores.add(conductor68);
conductores.add(conductor69);
conductores.add(conductor70);
conductores.add(conductor71);
conductores.add(conductor72);
conductores.add(conductor73);
conductores.add(conductor74);
conductores.add(conductor75);
conductores.add(conductor76);
conductores.add(conductor77);
conductores.add(conductor78);
conductores.add(conductor79);
conductores.add(conductor80);
conductores.add(conductor81);
conductores.add(conductor82);
conductores.add(conductor83);
conductores.add(conductor84);
conductores.add(conductor85);
conductores.add(conductor86);
conductores.add(conductor87);
conductores.add(conductor88);
conductores.add(conductor89);
conductores.add(conductor90);
conductores.add(conductor91);
conductores.add(conductor92);
conductores.add(conductor93);
conductores.add(conductor94);
conductores.add(conductor95);
conductores.add(conductor96);
conductores.add(conductor97);
conductores.add(conductor98);
conductores.add(conductor99);
conductores.add(conductor100);

// Añadir estaciones de la Zona A
estaciones.add(calle76);
estaciones.add(calle72);
estaciones.add(floresAreandina);
estaciones.add(calle63);
estaciones.add(calle57);
estaciones.add(marly);
estaciones.add(calle45);
estaciones.add(calle39);
estaciones.add(calle34);
estaciones.add(calle26);
estaciones.add(calle22);
estaciones.add(calle19);
estaciones.add(tercerMilenio);

// Añadir estaciones de la Zona B
estaciones.add(terminalNorte);
estaciones.add(calle187);
estaciones.add(portalNorte);
estaciones.add(toberin);
estaciones.add(calle161);
estaciones.add(mazuren);
estaciones.add(calle146);
estaciones.add(calle142);
estaciones.add(alcala);
estaciones.add(prado);
estaciones.add(calle127);
estaciones.add(pepeSierra);
estaciones.add(calle106);
estaciones.add(calle100);
estaciones.add(virrey);
estaciones.add(calle85);
estaciones.add(heroes);

// Añadir estaciones de la Zona C
estaciones.add(portalSuba);
estaciones.add(laCampina);
estaciones.add(subaTV91);
estaciones.add(angeles21);
estaciones.add(gratamira);
estaciones.add(subaAVBoyaca);
estaciones.add(nizaCl127);
estaciones.add(humedalCordoba);
estaciones.add(subaCl116);
estaciones.add(puenteLargo);
estaciones.add(subaCl100);
estaciones.add(subaCl95);
estaciones.add(rionegro);
estaciones.add(sanMartin);

// Añadir estaciones de la Zona D
estaciones.add(portal80);
estaciones.add(quirigua);
estaciones.add(carrera90);
estaciones.add(avenidaCali);
estaciones.add(granjaCra77);
estaciones.add(minutoDeDios);
estaciones.add(boyaca);
estaciones.add(ferias);
estaciones.add(avenida68);
estaciones.add(carrera53);
estaciones.add(carrera47);
estaciones.add(escuelaMilitar);
estaciones.add(polo);

// Añadir estaciones de la Zona E
estaciones.add(laCastellana);
estaciones.add(nqsCalle75);
estaciones.add(avChile);
estaciones.add(sieteDeAgosto);
estaciones.add(movistarArena);
estaciones.add(campinUAN);
estaciones.add(uNacional);
estaciones.add(avElDorado);
estaciones.add(cad);
estaciones.add(paloquemao);
estaciones.add(ricaurte_E);
estaciones.add(guatoque_veraguas);
estaciones.add(tygua_san_jose);

// Añadir estaciones de la Zona F
estaciones.add(portalAmericas);
estaciones.add(patioBonito);
estaciones.add(bibliotecaTintal);
estaciones.add(transversal86);
estaciones.add(banderas);
estaciones.add(mandalay);
estaciones.add(avAmericasBoyaca);
estaciones.add(marsella);
estaciones.add(pradera);
estaciones.add(distritoGrafiti);
estaciones.add(puenteAranda);
estaciones.add(americasCalle43);
estaciones.add(zonaIndustrial);
estaciones.add(cdsCarrera32);
estaciones.add(ricaurte_F);
estaciones.add(sanFaconKR22);
estaciones.add(deLaSabana);
estaciones.add(avJimenez_F);

// Añadir estaciones de la Zona G
estaciones.add(bosa);
estaciones.add(laDespensa);
estaciones.add(leonXIII);
estaciones.add(terrerosHospitalCV);
estaciones.add(sanMateoCCUnisur);
estaciones.add(portalSur);
estaciones.add(perdomo);
estaciones.add(cCPaseoVillaDelRio);
estaciones.add(sevillana);
estaciones.add(venecia);
estaciones.add(alqueria);
estaciones.add(generalSantander);
estaciones.add(nqsCL38ASur);
estaciones.add(nqsCL30Sur);
estaciones.add(sena);
estaciones.add(santaIsabel);
estaciones.add(comuneros);

// Añadir estaciones de la Zona H
estaciones.add(portalUsme);
estaciones.add(molinos);
estaciones.add(consuelo);
estaciones.add(socorro);
estaciones.add(santaLucia);
estaciones.add(calle40Sur);
estaciones.add(quiroga);
estaciones.add(olaya);
estaciones.add(restrepo);
estaciones.add(fucha);
estaciones.add(nariño);
estaciones.add(hortua);
estaciones.add(hospital);
estaciones.add(biblioteca);
estaciones.add(parque);
estaciones.add(portalTunal);
estaciones.add(tunal);
estaciones.add(juanPabloII);
estaciones.add(manitas);
estaciones.add(miradorParaiso);

// Añadir estaciones de la Zona J
estaciones.add(universidades_J);
estaciones.add(aguas);
estaciones.add(museoDelOro);

// Añadir estaciones de la Zona K
estaciones.add(portalEldorado);
estaciones.add(modelia);
estaciones.add(normandia);
estaciones.add(avenidaRojas);
estaciones.add(elTiempoCamaraComercio);
estaciones.add(salitreElGreco);
estaciones.add(can);
estaciones.add(gobernacion);
estaciones.add(quintaParedes);
estaciones.add(corferias);
estaciones.add(ciudadUniversitaria);
estaciones.add(concejoDeBogota);
estaciones.add(centroDeMemoria);
estaciones.add(universidades_K);

// Añadir estaciones de la Zona L
estaciones.add(portal20Julio);
estaciones.add(countrySur);
estaciones.add(avenidaPrimeroMayo);
estaciones.add(ciudadJardinUAN);
estaciones.add(policarpa);
estaciones.add(sanBernardo);
estaciones.add(bicentenario);
estaciones.add(sanVictorino);
estaciones.add(lasNieves);
estaciones.add(sanDiego);

// Añadir estaciones de la Zona M
estaciones.add(museoNacional);

// Añadir todas las rutas a la lista
rutas.add(ruta_1);
rutas.add(ruta_2);
rutas.add(ruta_3);
rutas.add(ruta_4);
rutas.add(ruta_5);
rutas.add(ruta_6);
rutas.add(ruta_7);
rutas.add(ruta_8);
rutas.add(ruta_A52);
rutas.add(ruta_A60);
rutas.add(ruta_A61);
rutas.add(ruta_B10);
rutas.add(ruta_B11);
rutas.add(ruta_B12);
rutas.add(ruta_B13);
rutas.add(ruta_B16);
rutas.add(ruta_B18);
rutas.add(ruta_B23);
rutas.add(ruta_B26);
rutas.add(ruta_B27);
rutas.add(ruta_B28);
rutas.add(ruta_B46);
rutas.add(ruta_B50);
rutas.add(ruta_B55);
rutas.add(ruta_B72);
rutas.add(ruta_B74);
rutas.add(ruta_B75);
rutas.add(ruta_C15);
rutas.add(ruta_C17);
rutas.add(ruta_C19);
rutas.add(ruta_C25);
rutas.add(ruta_C30);
rutas.add(ruta_C50);
rutas.add(ruta_C73);
rutas.add(ruta_C84);
rutas.add(ruta_D10);
rutas.add(ruta_D21);
rutas.add(ruta_D22);
rutas.add(ruta_D24);
rutas.add(ruta_D55);
rutas.add(ruta_D81);
rutas.add(ruta_E32);
rutas.add(ruta_E42);
rutas.add(ruta_F19);
rutas.add(ruta_F23);
rutas.add(ruta_F26);
rutas.add(ruta_F28);
rutas.add(ruta_F32);
rutas.add(ruta_F51);
rutas.add(ruta_F60);
rutas.add(ruta_F61);
rutas.add(ruta_G11);
rutas.add(ruta_G12);
rutas.add(ruta_G15);
rutas.add(ruta_G22);
rutas.add(ruta_G30);
rutas.add(ruta_G41);
rutas.add(ruta_G42);
rutas.add(ruta_G43);
rutas.add(ruta_G45);
rutas.add(ruta_G46);
rutas.add(ruta_G47);
rutas.add(ruta_G52);
rutas.add(ruta_H13);
rutas.add(ruta_H15);
rutas.add(ruta_H17);
rutas.add(ruta_H20);
rutas.add(ruta_H21);
rutas.add(ruta_H27);
rutas.add(ruta_H54);
rutas.add(ruta_H72);
rutas.add(ruta_H73);
rutas.add(ruta_H75);
rutas.add(ruta_H76);
rutas.add(ruta_H83);
rutas.add(ruta_J23);
rutas.add(ruta_J24);
rutas.add(ruta_J70);
rutas.add(ruta_J73);
rutas.add(ruta_J74);
rutas.add(ruta_J76);
rutas.add(ruta_K10);
rutas.add(ruta_K16);
rutas.add(ruta_K23);
rutas.add(ruta_K43);
rutas.add(ruta_K54);
rutas.add(ruta_K86);
rutas.add(ruta_L10);
rutas.add(ruta_L18);
rutas.add(ruta_L25);
rutas.add(ruta_L41);
rutas.add(ruta_L81);
rutas.add(ruta_L82);
rutas.add(ruta_M47);
rutas.add(ruta_M51);
rutas.add(ruta_M82);
rutas.add(ruta_M83);

relaciones.add(rbrc1);
relaciones.add(rbrc2);
relaciones.add(rbrc3);
relaciones.add(rbrc4);
relaciones.add(rbrc5);
relaciones.add(rbrc6);
relaciones.add(rbrc7);
relaciones.add(rbrc8);
relaciones.add(rbrc9);
relaciones.add(rbrc10);
relaciones.add(rbrc11);
relaciones.add(rbrc12);
relaciones.add(rbrc13);
relaciones.add(rbrc14);
relaciones.add(rbrc15);
relaciones.add(rbrc16);
relaciones.add(rbrc17);
relaciones.add(rbrc18);
relaciones.add(rbrc19);
relaciones.add(rbrc20);
relaciones.add(rbrc21);
relaciones.add(rbrc22);
relaciones.add(rbrc23);
relaciones.add(rbrc24);
relaciones.add(rbrc25);
relaciones.add(rbrc26);
relaciones.add(rbrc27);
relaciones.add(rbrc28);
relaciones.add(rbrc29);
relaciones.add(rbrc30);
relaciones.add(rbrc31);
relaciones.add(rbrc32);
relaciones.add(rbrc33);
relaciones.add(rbrc34);
relaciones.add(rbrc35);
relaciones.add(rbrc36);
relaciones.add(rbrc37);
relaciones.add(rbrc38);
relaciones.add(rbrc39);
relaciones.add(rbrc40);
relaciones.add(rbrc41);
relaciones.add(rbrc42);
relaciones.add(rbrc43);
relaciones.add(rbrc44);
relaciones.add(rbrc45);
relaciones.add(rbrc46);
relaciones.add(rbrc47);
relaciones.add(rbrc48);
relaciones.add(rbrc49);
relaciones.add(rbrc50);
relaciones.add(rbrc51);
relaciones.add(rbrc52);
relaciones.add(rbrc53);
relaciones.add(rbrc54);
relaciones.add(rbrc55);
relaciones.add(rbrc56);
relaciones.add(rbrc57);
relaciones.add(rbrc58);
relaciones.add(rbrc59);
relaciones.add(rbrc60);
relaciones.add(rbrc61);
relaciones.add(rbrc62);
relaciones.add(rbrc63);
relaciones.add(rbrc64);
relaciones.add(rbrc65);
relaciones.add(rbrc66);
relaciones.add(rbrc67);
relaciones.add(rbrc68);
relaciones.add(rbrc69);
relaciones.add(rbrc70);
relaciones.add(rbrc71);
relaciones.add(rbrc72);
relaciones.add(rbrc73);
relaciones.add(rbrc74);
relaciones.add(rbrc75);
relaciones.add(rbrc76);
relaciones.add(rbrc77);
relaciones.add(rbrc78);
relaciones.add(rbrc79);
relaciones.add(rbrc80);
relaciones.add(rbrc81);
relaciones.add(rbrc82);
relaciones.add(rbrc83);
relaciones.add(rbrc84);
relaciones.add(rbrc85);
relaciones.add(rbrc86);
relaciones.add(rbrc87);
relaciones.add(rbrc88);
relaciones.add(rbrc89);
relaciones.add(rbrc90);
relaciones.add(rbrc91);
relaciones.add(rbrc92);
relaciones.add(rbrc93);
relaciones.add(rbrc94);
relaciones.add(rbrc95);
relaciones.add(rbrc96);
relaciones.add(rbrc97);
relaciones.add(rbrc98);
relaciones.add(rbrc99);
relaciones.add(rbrc100);


System.out.println("TRANSACCION");

for (Estacion estTemp : estaciones){
    estacionRepository.save(estTemp);
    System.out.println("Estacion salvada " + estTemp.getNombre());
    //contador que dice en que index va y cuantas faltan
    System.out.println("Index: " + estaciones.indexOf(estTemp) + " Faltan: " + (estaciones.size() - estaciones.indexOf(estTemp)));
}
for (Bus busTemp : buses) {
    busRepository.save(busTemp);
    System.out.println("Bus salvado " + busTemp.getPlaca());
    //contador que dice en que index va y cuantas faltan
    System.out.println("Index: " + buses.indexOf(busTemp) + " Faltan: " + (buses.size() - buses.indexOf(busTemp)));

}
for (Conductor conTemp : conductores){
    conductorRepository.save(conTemp);
    System.out.println("Conductor salvado " + conTemp.getNombre());
    //contador que dice en que index va y cuantas faltan
    System.out.println("Index: " + conductores.indexOf(conTemp) + " Faltan: " + (conductores.size() - conductores.indexOf(conTemp)));
}
System.out.println("ultimo for");
//esperar 3 segundos
try {
    Thread.sleep(3000);
} catch (InterruptedException e) {
    e.printStackTrace();
}
for (RelacionBusRutaConductor rbTemp : relaciones){
    relacionBusRutaConductorRepository.save(rbTemp);
    System.out.println("Datos " + rbTemp.getBusRel().getPlaca() + " " + rbTemp.getRutaRel().getNombre_ruta() + " " + rbTemp.getConductorRel().getNombre());
    //contador que dice en que index va y cuantas faltan
    System.out.println("Index: " + relaciones.indexOf(rbTemp) + " Faltan: " + (relaciones.size() - relaciones.indexOf(rbTemp)));
}

System.out.println("Agora sim?");
// saveAllEntities();

}

@Transactional
public void saveAllEntities() {
    try {
        
     relacionBusRutaConductorRepository.saveAll(relaciones);

        System.out.println("Relaciones guardadas");
    } catch (Exception e) {
        throw new RuntimeException("Failed to save entities", e);
    }
}

@Transactional
    @SuppressWarnings("CallToPrintStackTrace")
public void saveAllEntitiesInBatch() {
    //print
    System.out.println("Saving entities in batch");
    //wait 30 seconds
    try {
        Thread.sleep(30000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    estacionRepository.saveAll(estaciones);
    System.out.println("Estaciones saved");
     //wait 30 seconds
     try {
        Thread.sleep(30000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    rutaRepository.saveAll(rutas);
    System.out.println("Rutas saved");
    //wait 30 seconds
    try {
        Thread.sleep(30000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    busRepository.saveAll(buses);
    System.out.println("Buses saved");
     //wait 30 seconds
     try {
        Thread.sleep(30000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    conductorRepository.saveAll(conductores);
    System.out.println("Conductores saved");
    relacionBusRutaConductorRepository.saveAll(relaciones);

    //print
    System.out.println("Entities saved in batch");
}


}