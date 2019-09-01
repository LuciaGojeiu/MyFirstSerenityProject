package org.fasttrackit.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.CartSteps;
import org.fasttrackit.steps.SearchSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CartTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private SearchSteps searchSteps;

    @Steps
    private CartSteps cartSteps;
    private String keyword1 = "shirt";
    private String keyword2 = "necklace";
    private String keyword3 = "skirt";

    @Before
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @Test
    public void cartTest() {
        searchSteps.navigateToHomePage();
        searchSteps.searchForKeyword1(keyword1);
        searchSteps.viewDetailsProduct();
        cartSteps.addToCartProduct1();
        searchSteps.searchForKeyword2(keyword2);
        searchSteps.viewDetailsProduct();
        cartSteps.addToCartProduct2();
        searchSteps.searchForKeyword3(keyword3);
        searchSteps.viewDetailsProduct();
        cartSteps.addToCartProduct3();
        cartSteps.verifyProductsPricesTotal();
    }
}

