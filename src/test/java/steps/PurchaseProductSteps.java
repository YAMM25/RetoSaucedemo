package steps;

import com.co.sofka.web.controllers.BusinessController;
import com.co.sofka.web.controllers.DriverController;
import com.co.sofka.web.controllers.PurchaseProductController;
import com.co.sofka.web.pages.*;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PurchaseProductSteps {

    WebDriver driver;


    @Before
    public void setup() {
        driver = DriverController.getDriver();
    }

    @Dado("^que el cliente se encuentra logueado$")
    public void queElClienteSeEncuentraLogueado() {
        BusinessController.startApp(driver, "https://www.saucedemo.com/");
        BusinessController.loginUser(driver,"standard_user", "secret_sauce");
    }

    @Y("^el cliente esta en la Home Page$")
    public void elClienteEstaEnLaHomePage() {
        Assert.assertEquals(BusinessController.getTitleHome(driver), "PRODUCTS");
    }

    @Cuando("^el cliente agrega un producto al carrito$")
    public void elClienteAgregaUnProductoAlCarrito(int producto) {
        HomePage page = new HomePage(driver);
        BusinessController.clickButtonAddToCart(page, producto);
    }

    @Y("^el cliente se dirija al carrito$")
    public void elClienteSeDirijaAlCarrito() {
        YourCartPage cartPage = new YourCartPage(driver);
        PurchaseProductController.clickIntoCart(cartPage);
        Assert.assertEquals(PurchaseProductController.getTitleYourCartPage(cartPage), "YOUR CART");
    }

    @Y("^el cliente da click en el boton CHECKOUT$")
    public void elClienteDaClickEnElBotonCHECKOUT() {
        YourCartPage cartPage = new YourCartPage(driver);
        PurchaseProductController.clickIntoButtonCheckout(cartPage);
    }

    @Y("^el cliente esta en la pagina CHECKOUT: YOUR INFORMATION$")
    public void elClienteEstaEnLaPaginaCHECKOUTYOURINFORMATION() {
        Assert.assertEquals(PurchaseProductController.getTitlePageCheckout(driver), "CHECKOUT: YOUR INFORMATION");
    }

    @Y("^el cliente visualiza el formulario exitosamente, ingresa todos los datos y da click al boton CONTINUE$")
    public void elClienteVisualizaElFormularioExitosamenteIngresaTodosLosDatosYDaClickAlBotonCONTINUE() {
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        Assert.assertTrue(PurchaseProductController.isVisibleFormCheckout(checkoutInformationPage));
        PurchaseProductController.generateFormCheckout(checkoutInformationPage);
    }

    @Y("^el cliente esta en la pagina CHECKOUT: OVERVIEW y le da click al boton Finish$")
    public void elClienteEstaEnLaPaginaCHECKOUTOVERVIEWYLeDaClickAlBotonFinish() {
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(PurchaseProductController.getTitlePageCheckoutOverview(driver), "CHECKOUT: OVERVIEW");
        PurchaseProductController.clicButtonFinish(checkoutOverviewPage);
    }

    @Y("^el cliente esta en la pagina CHECKOUT: COMPLETE!$")
    public void elClienteEstaEnLaPaginaCHECKOUTCOMPLETE() {
        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        Assert.assertEquals(PurchaseProductController.getTitlePageCheckoutComplete(completePage), "CHECKOUT: COMPLETE!");
    }

    @Entonces("^el cliente visualiza el mensaje \"([^\"]*)\"$")
    public void elClienteVisualizaElMensaje(String mensaje)  {
        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        Assert.assertEquals(PurchaseProductController.getMessageFinal(completePage), mensaje);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
