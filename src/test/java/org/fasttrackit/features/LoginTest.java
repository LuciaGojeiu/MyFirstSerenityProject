package org.fasttrackit.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.LoginSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
  public class LoginTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;

@Steps
    private LoginSteps loginSteps;

   private String userEmail="madisonqa16@gmail.com";
   private String userPass="123abc";
   private String userName="Madison Ella Smith";

@Test
 public void validLoginTest(){
    loginSteps.navigateToLoginPage();
    loginSteps.performLogin(userEmail, userPass);
    loginSteps.checkLoggedIn(userName);
   }

}
