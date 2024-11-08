package puj.desarrolloweb.proyecto.e2e;

import java.time.Duration;

import org.openqa.selenium.support.ui.Select;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext
@ActiveProfiles("default")
public class CasoUso {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String BASE_URL = "http://localhost:4200";

    @BeforeEach
    public void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications--");
        chromeOptions.addArguments("--disable-extensions--");
        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @AfterEach
    public void tearDown(){
        //driver.quit();
    }


    @Test
    public void test() {
        //Entra a login
        driver.get(BASE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEmail")));
        WebElement correoLabel = driver.findElement(By.id("txtEmail"));
        correoLabel.sendKeys("jsanabria@javeriana.edu.co");	
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtPassword")));
        WebElement passwordLabel = driver.findElement(By.id("txtPassword"));
        passwordLabel.sendKeys("sanabria123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnLogin")));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        btnLogin.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//app-root//div//app-navbar//nav//div[4]")));//no existe en html
        WebElement btnDriverManagement = driver.findElement(By.xpath("//html//body//app-root//div//app-navbar//nav//div[4]"));//no existe en html
        btnDriverManagement.click();
     
         
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnCreatebus")));
        WebElement btnCreate = driver.findElement(By.id("btnCreatebus"));
        btnCreate.click();
        
        //Va al driver management
        driver.get("http://localhost:4200/conductores");

        
        //Crea conductor
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnCreateConductor")));
        WebElement btnCreateConductor = driver.findElement(By.id("btnCreateConductor"));
        btnCreateConductor.click();


        //Agraga los datos del nuevo conductor
        WebElement nombre = driver.findElement(By.id("nombre"));
        nombre.sendKeys("Harry");
        WebElement cedula = driver.findElement(By.id("cedula"));
        cedula.sendKeys("45451");
        WebElement telefono = driver.findElement(By.id("telefono"));
        telefono.sendKeys("11515");
        WebElement direccion = driver.findElement(By.id("direccion"));
        direccion.sendKeys("Calle 123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnGuardar")));
        WebElement btnGuardar = driver.findElement(By.id("btnGuardar"));
        btnGuardar.click();

        //Va a la ultima columna, para ver si se creo el conductor con los datos y crea los assertion si esta bien
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//app-root//div//div//app-conductor//div//app-list//table//tbody//tr[101]//td[2]")));
        WebElement  nombreassert =driver.findElement(By.xpath("//html//body//app-root//div//div//app-conductor//div//app-list//table//tbody//tr[101]//td[2]"));
        Assertions.assertThat(nombreassert.getText()).isEqualTo("Harry");
        WebElement  cedulaassert =driver.findElement(By.xpath("//html//body//app-root//div//div//app-conductor//div//app-list//table//tbody//tr[101]//td[3]"));
        Assertions.assertThat(cedulaassert.getText()).isEqualTo("11515");
        WebElement  direccionassert =driver.findElement(By.xpath("//html//body//app-root//div//div//app-conductor//div//app-list//table//tbody//tr[101]//td[4]"));
        Assertions.assertThat(direccionassert.getText()).isEqualTo("Calle 123");

        //Va al boton de asignar bus
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//app-root//div//div//app-conductor//div//app-list//table//tbody//tr[101]/td[5]//button")));
        WebElement btnAsignar = driver.findElement(By.xpath("//html//body//app-root//div//div//app-conductor//div//app-list//table//tbody//tr[101]/td[5]//button"));
        btnAsignar.click();
        
        //Selecciona el bus 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bus-select")));
        WebElement busSelectElement = driver.findElement(By.id("bus-select"));
        Select busSelect = new Select(busSelectElement);
        busSelect.selectByVisibleText("ABC123 (BRT)");

        //Presiona el boton del asingar el bus
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSumit")));
        WebElement btnSumit = driver.findElement(By.id("btnSumit"));
        btnSumit.click();
        
        //para darle ok en la pantalla emergente
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assert alertText.equals("Bus assigned successfully!");
        alert.accept();
        
        //Selecciona los dias 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//app-root//div//div//app-asignar-bus//div//div//div//div//form//div//button[3]")));
        WebElement btnMartes = driver.findElement(By.xpath("//html//body//app-root//div//div//app-asignar-bus//div//div//div//div//form//div//button[3]"));
        btnMartes.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//app-root//div//div//app-asignar-bus//div//div//div//div//form//div//button[4]")));
        WebElement btnMiercoles = driver.findElement(By.xpath("//html//body//app-root//div//div//app-asignar-bus//div//div//div//div//form//div//button[4]"));
        btnMiercoles.click();


        //Guarda los dias
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSaveDays")));
        WebElement btnSaveDays = driver.findElement(By.id("btnSaveDays"));
        btnSaveDays.click();
        
        //Le da ok a la pantalla emergente, lo que significa que si se ectualizaron los dias 
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert2 = driver.switchTo().alert();
        String alertText2 = alert2.getText();
        assert alertText2.equals("Days updated successfully!");
        alert2.accept();


        // Va al driver management
        driver.get("http://localhost:4200/conductores");

        // Va a la última fila, donde se creó el registro
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//app-root//div//div//app-conductor//div//app-list//table//tbody//tr[last()]")));
        WebElement lastRow = driver.findElement(By.xpath("//html//body//app-root//div//div//app-conductor//div//app-list//table//tbody//tr[last()]"));

        // Lo borra
         //Va al boton de asignar bus
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//app-root//div//div//app-conductor//div//app-list//table//tbody//tr[101]/td[6]//button")));
         WebElement btnborrar = driver.findElement(By.xpath("//html//body//app-root//div//div//app-conductor//div//app-list//table//tbody//tr[101]/td[6]//button[2]"));
         btnborrar.click();
       

        // Envía asserts de que lo borró correctamente
        wait.until(ExpectedConditions.invisibilityOf(lastRow));
        Assertions.assertThat(driver.findElements(By.xpath("//html//body//app-root//div//div//app-conductor//div//app-list//table//tbody//tr[101]")).isEmpty()).isTrue();
                
  

    }
}
