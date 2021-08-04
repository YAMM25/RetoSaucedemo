package com.co.sofka.web.controllers;

import com.co.sofka.web.datos.DatosBase;
import com.co.sofka.web.pages.HomePage;
import com.co.sofka.web.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLException;

public class BusinessController {

    public static void startApp(WebDriver driver, String url) {
        driver.get(url);
    }

    public static void loginUser(WebDriver driver, String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getInputUser().sendKeys(username);
        loginPage.getInputPassword().sendKeys(password);
        loginPage.getButtonLogin().click();
    }

    public static String getTitleHome(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        return homePage.getTitleHome().getText();
    }

    public static String getloginUserError(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.getError().getText();
    }

    public static void consultDatabase(WebDriver driver, DatosBase datosBase) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        String consulta = "";
        String nombreTabla = "USUARIO";
        String nombreColumnaId = "ID";
        String nombreColumnaUsuario = "USERNAME";
        String nombreConsultaContra = "PSSWRD";

        consulta = "SELECT * FROM " +nombreTabla+ " WHERE " +nombreColumnaId+ " = " +generateId();

        conexion.establecerConexionBD();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        conexion.ejecutarConsulta(consulta, nombreColumnaUsuario, nombreConsultaContra, datosBase);

    }

    public static int generateId(){
        int idGenerado = (int) (Math.random()*(3-1+1)+1);
        return idGenerado;
    }

    public static void clickButtonAddToCart(HomePage page, int producto) {
        page.addToListButtons();
        page.getListButton().get(producto).click();
    }

    public static String lookingCart(HomePage page) {
        return page.getCart().getText();
    }

    public static void clickOptions(WebDriver driver){
        HomePage homePage = new HomePage(driver);
        homePage.getOptions().click();

    }

    public static void clickLogOut(WebDriver driver){
        HomePage homePage = new HomePage(driver);
        homePage.getLogOut().click();
    }

    public static String getButtonLogin(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.getButtonLogin().getText();
    }

}
