package steps;

import com.co.sofka.web.controllers.BusinessController;
import com.co.sofka.web.controllers.DriverController;
import com.co.sofka.web.controllers.ProductController;
import com.co.sofka.web.pages.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ProductSteps {

    WebDriver driver;


    @Before
    public void setup() {
        driver = DriverController.getDriver();
    }

    @Dado("^que un usuario se encuentre Autenticado con el \"([^\"]*)\" y \"([^\"]*)\"$")
    public void queUnUsuarioSeEncuentreAutenticadoConElY(String username, String password)  {
        BusinessController.startApp(driver, "https://www.saucedemo.com/");
        BusinessController.loginUser(driver,username, password);
    }

    @Cuando("^el usuario ingrese a la pagina Home de Souce demo$")
    public void elUsuarioIngreseALaPaginaHomeDeSouceDemo() {
        Assert.assertEquals(BusinessController.getTitleHome(driver), "PRODUCTS");
    }

    @Entonces("^se visualizan los nombres de los articulos$")
    public void seVisualizanLosNombresDeLosArticulos() {
        HomePage page = new HomePage(driver);
        ProductController.isVisibleProducts(page);
    }

    @Dado("^un usuario en la pagina PRODUCTS de soucedemo$")
    public void unUsuarioEnLaPaginaPRODUCTSDeSoucedemo() {
        BusinessController.startApp(driver, "https://www.saucedemo.com/");
        BusinessController.loginUser(driver,"standard_user", "secret_sauce");
    }

    @Cuando("^el usuario haga clic en el boton ADD TO CART \"([^\"]*)\"$")
    public void elUsuarioHagaClicEnElBotonADDTOCART(int producto)  {
        HomePage page = new HomePage(driver);
        BusinessController.clickButtonAddToCart(page, producto);
    }

    @Entonces("^se visualizara en el carrito$")
    public void seVisualizaraEnElCarrito() {
        HomePage page = new HomePage(driver);
        Assert.assertEquals(BusinessController.lookingCart(page), "1");
    }


    @Dado("^un usuario ingresa un usuario correcto e ingresa al homepage$")
    public void unUsuarioIngresaUnUsuarioCorrectoEIngresaAlHomepage() {
        BusinessController.startApp(driver, "https://www.saucedemo.com/");
        BusinessController.loginUser(driver,"standard_user", "secret_sauce");
    }
    @Cuando("^el usuario desee desloguearse de la aplicacion homepage$")
    public void elUsuarioDeseeDesloguearseDeLaAplicacionHomepage() {
        BusinessController.clickOptions(driver);
        BusinessController.clickLogOut(driver);
    }

    @Entonces("^podra ingresar a las opciones del menu y realizar el Logout$")
    public void podraIngresarALasOpcionesDelMenuYRealizarElLogout() throws IOException {
        Assert.assertEquals(BusinessController.getButtonLogin(driver),"");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/main/resources/screenshots/Logoutcorrecto.png"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
