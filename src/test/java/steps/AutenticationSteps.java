package steps;

import com.co.sofka.web.controllers.BusinessController;
import com.co.sofka.web.controllers.DriverController;
import com.co.sofka.web.datos.DatosBase;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


public class AutenticationSteps {

    WebDriver driver;


    @Before
    public void setup() {
        driver = DriverController.getDriver();
    }

    @Dado("^un usuario en la pagina inicial de souce demo$")
    public void unUsuarioEnLaPaginaInicialDeSouceDemo() {
        BusinessController.startApp(driver, "https://www.saucedemo.com/");
    }

    @Cuando("^el usuario ingresa un \"([^\"]*)\" y \"([^\"]*)\" correctos$")
    public void elUsuarioIngresaUnYCorrectos(String username, String password) throws SQLException {
        DatosBase datosBase = new DatosBase();
        BusinessController.consultDatabase(driver, datosBase);
        BusinessController.loginUser(driver, datosBase.getUsuario(), datosBase.getContrasena());
        //BusinessController.loginUser(driver, username, password);
    }

    @Entonces("^se autentica en el sitio correctamente$")
    public void seAutenticaEnElSitioCorrectamente() throws IOException {
        Assert.assertEquals(BusinessController.getTitleHome(driver), "PRODUCTS");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/main/resources/screenshots/PageHome.png"));
    }

    @Cuando("^el usuario ingresa un \"([^\"]*)\" y \"([^\"]*)\" correcto$")
    public void elUsuarioIngresaUnYCorrecto(String username, String password)  {
        BusinessController.loginUser(driver, username, password);
    }

    @Entonces("^se presenta un mensaje de error por usuario bloqueados$")
    public void sePresentaUnMensajeDeErrorPorUsuarioBloqueados() throws IOException {
        Assert.assertEquals(BusinessController.getloginUserError(driver), "Epic sadface: Sorry, this user has been locked out.");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/main/resources/screenshots/LogoutBloqueado.png"));
    }

    @Cuando("^el usuario ingresa un \"([^\"]*)\" y \"([^\"]*)\" incorrecto$")
    public void elUsuarioIngresaUnYIncorrecto(String username, String password)  {
        BusinessController.loginUser(driver, username, password);
    }

    @Entonces("^se presenta un mensaje de error por usuario incorrecto$")
    public void sePresentaUnMensajeDeErrorPorUsuarioIncorrecto() throws IOException {
        Assert.assertEquals(BusinessController.getloginUserError(driver),
                "Epic sadface: Username and password do not match any user in this service");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/main/resources/screenshots/LoginIncorrecto.png"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }



}
