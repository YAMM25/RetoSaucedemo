package com.co.sofka.web.controllers;

import com.co.sofka.web.pages.*;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.security.SecureRandom;
import java.util.Locale;

public class PurchaseProductController {

    private WebDriver dirver;

    public static boolean isVisibleButtons(HomePage page) {
        int countButton = 0;
        page.addToListButtons();
        for (int i = 0; i < page.getListButton().size(); i++) {
            if (page.getListButton().get(i).isDisplayed()) {
                Assert.assertTrue(page.getListButton().get(i).isDisplayed());
                countButton++;
            }
            System.out.println(page.getListButton().get(i).getText());
        }
        if (countButton == 6) {
            return true;
        } else {
            return false;
        }
    }

    public static void clickButtonAddToCart(HomePage page, String producto) {
        page.addToListButtons();
        page.getListButton().get(Integer.parseInt(producto)).click();
    }

    public static void clickIntoCart(YourCartPage cartPage){
        cartPage.getCartShopping().click();
    }

    public static String getTitleYourCartPage(YourCartPage cartPage){
        return cartPage.getTitlePage().getText();
    }

    public static boolean isVisibleProduct(YourCartPage cartPage){
        return cartPage.getSelectedProduct().isDisplayed();
    }

    public static String getTextButtonCheckout(YourCartPage cartPage){
        return cartPage.getButtonCheckout().getText();
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
