package com.co.sofka.web.controllers;

import com.co.sofka.web.pages.HomePage;
import org.junit.Assert;

public class ProductController {

    public static void isVisibleProducts(HomePage page) {
        page.addToListButtons();
        for (int i = 0; i < page.getListNameProducts().size(); i++) {
            Assert.assertTrue(page.getListNameProducts().get(i).isDisplayed());

            System.out.println(page.getListButton().get(i).getText());
        }

    }
}
