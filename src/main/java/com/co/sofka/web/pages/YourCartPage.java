package com.co.sofka.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {

    public YourCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement titlePage;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]")
    WebElement selectedProduct;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartShopping;

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    WebElement buttonCheckout;

    public WebElement getTitlePage() {
        return titlePage;
    }

    public WebElement getSelectedProduct() {
        return selectedProduct;
    }

    public WebElement getCartShopping() {
        return cartShopping;
    }

    public WebElement getButtonCheckout() {
        return buttonCheckout;
    }
}
