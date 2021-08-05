package com.co.sofka.web.controllers;

import com.co.sofka.web.pages.*;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.security.SecureRandom;
import java.util.Locale;

public class PurchaseProductController {

    private WebDriver dirver;



    public static void clickButtonAddToCart(HomePage page, int producto) {
        page.addToListButtons();
        page.getListButton().get(producto).click();
    }

    public static void clickIntoCart(YourCartPage cartPage){
        cartPage.getCartShopping().click();
    }

    public static String getTitleYourCartPage(YourCartPage cartPage){
        return cartPage.getTitlePage().getText();
    }

    public static void clickIntoButtonCheckout(YourCartPage cartPage){
        cartPage.getButtonCheckout().click();
    }

    public static void generateFormCheckout(CheckoutInformationPage checkoutInformationPage){
        Faker faker = Faker.instance(new Locale("es", "CO"), new SecureRandom());
        checkoutInformationPage.getFirstName().sendKeys(faker.name().firstName());
        checkoutInformationPage.getLastName().sendKeys(faker.name().lastName());
        checkoutInformationPage.getPostalCode().sendKeys(faker.address().zipCode());
        checkoutInformationPage.getButtonContinue().click();
    }
    public static String getTitlePageCheckout(WebDriver driver){
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        return checkoutInformationPage.getTitlePage().getText();
    }

    public static boolean isVisibleFormCheckout(CheckoutInformationPage checkoutInformationPage){
        return checkoutInformationPage.getFormCheckout().isDisplayed();
    }

    public static String getTitlePageCheckoutOverview(WebDriver driver){
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        return checkoutOverviewPage.getTitlePage().getText();
    }

    public static void clicButtonFinish(CheckoutOverviewPage checkoutOverviewPage){
        checkoutOverviewPage.getButtonFinish().click();
    }

    public static String getTitlePageCheckoutComplete(CheckoutCompletePage completePage){
        return completePage.getTitlePage().getText();
    }

    public static String getMessageFinal(CheckoutCompletePage completePage){
        return completePage.getMessage().getText();
    }


}
