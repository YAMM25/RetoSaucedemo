package com.co.sofka.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {
    public CheckoutCompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement titlePage;

    @FindBy(className = "complete-text")
    WebElement message;

    public WebElement getTitlePage() {
        return titlePage;
    }

    public WebElement getMessage() {
        return message;
    }
}
