package idemobspb_aqa_q1822_ui_tests.login_page_tests;

import idemobspb_aqa_q1822_ui_tests.base.BaseUITestsClass;
import idemobspb_aqa_q1822_ui_tests.service.LoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageTest extends BaseUITestsClass {

    private LoginService loginService;

    @BeforeEach
    public void openLoginPage () throws InterruptedException {
        driver.get("https://idemo.bspb.ru/");
    }

    @Test
    public void verifyLoginInputVisibility () {
        //Given
        loginService = new LoginService(driver);

        //Then
        Assertions.assertEquals(false, loginService.getLoginPage().getLoginBlock().loginField.isDisplayed());

    }

    @Test
    public void verifyLoginInputValidParameters () {
        //Given
        String initialWrongLoginString = "demo";
        String initialPassword = "demo";
        String initialSmsCode = "0000";

        loginService = new LoginService(driver);
        loginService.getLoginPage().getLoginBlock().loginField.clear();
        loginService.getLoginPage().getLoginBlock().passwordField.clear();
        loginService.getLoginPage().getLoginBlock().loginField.sendKeys(initialWrongLoginString);
        loginService.getLoginPage().getLoginBlock().passwordField.sendKeys(initialPassword);

        //When
        loginService.getLoginPage().getLoginBlock().loginButton.click();
        loginService.getLoginPage().getLoginBlock().smsField.clear();
        loginService.getLoginPage().getLoginBlock().smsField.sendKeys(initialSmsCode);
        loginService.getLoginPage().getLoginBlock().smsButton.click();

        //Then
        //Assertions.assertEquals(expectedErrormessage, actualErrorMessageText);
    }

    @Test
    public void verifyLoginInputInvalidParameters () {
        //Given
        String initialWrongLoginString = "qwerty";
        String initialPassword = "12345";
        String expectedErrormessage = "Пожалуйста, повторите попытку.";
        loginService = new LoginService(driver);
        loginService.getLoginPage().getLoginBlock().loginField.sendKeys(initialWrongLoginString);
        loginService.getLoginPage().getLoginBlock().passwordField.sendKeys(initialPassword);

        //When
        loginService.getLoginPage().getLoginBlock().loginButton.click();

        //Then
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(4000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginService.getLoginPage().getLoginBlock().errorMessageBy));

        String actualErrorMessageText = loginService.getLoginPage().getLoginBlock().errorMessage.getText();
        //Assertions.assertEquals(expectedErrormessage, actualErrorMessageText);
    }


}
