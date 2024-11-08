package puj.desarrolloweb.proyecto.e2e;

import java.time.Duration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        WebElement  nombreassert =driver.findElement(By.xpath("//html//body//app-root//div//div//app-conductor//div//app-list//table//tbody//tr[101]//td[2]"));
        Assertions.assertThat(nombreassert.getText()).isEqualTo("Harry");
        WebElement  cedulaassert =driver.findElement(By.xpath("//html//body//app-root//div//div//app-conductor//div//app-list//table//tbody//tr[101]//td[3]"));
        Assertions.assertThat(cedulaassert.getText()).isEqualTo("45451");
        WebElement  direccionassert =driver.findElement(By.xpath("//html//body//app-root//div//div//app-conductor//div//app-list//table//tbody//tr[101]//td[4]"));
        Assertions.assertThat(direccionassert.getText()).isEqualTo("Calle 123");


        
        

    }
}
