package com.co.sofka.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage {
    public CheckoutInformationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement titlePage;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement buttonContinue;

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form")
    WebElement formCheckout;

    public WebElement getTitlePage() {
        return titlePage;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getPostalCode() {
        return postalCode;
    }

    public WebElement getButtonContinue() {
        return buttonContinue;
    }

    public WebElement getFormCheckout() {
        return formCheckout;
    }
}
