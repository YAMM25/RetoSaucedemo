package steps;

import com.co.sofka.web.controllers.BusinessController;
import com.co.sofka.web.controllers.DriverController;
import com.co.sofka.web.datos.DatosBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

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
    public void seAutenticaEnElSitioCorrectamente() {
        Assert.assertEquals(BusinessController.getTitleHome(driver), "PRODUCTS");
    }

    @Cuando("^el usuario ingresa un \"([^\"]*)\" y \"([^\"]*)\" correcto$")
    public void elUsuarioIngresaUnYCorrecto(String username, String password)  {
        BusinessController.loginUser(driver, username, password);
    }

    @Entonces("^se presenta un mensaje de error por usuario bloqueados$")
    public void sePresentaUnMensajeDeErrorPorUsuarioBloqueados() {
        Assert.assertEquals(BusinessController.getloginUserError(driver), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Cuando("^el usuario ingresa un \"([^\"]*)\" y/o \"([^\"]*)\" correcto$")
    public void elUsuarioIngresaUnYOCorrecto(String username, String password) {
        BusinessController.loginUser(driver, username, password);
    }

    @Entonces("^se presenta un mensaje de error por usuario incorrecto$")
    public void sePresentaUnMensajeDeErrorPorUsuarioIncorrecto() {
        Assert.assertEquals(BusinessController.getloginUserError(driver),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
