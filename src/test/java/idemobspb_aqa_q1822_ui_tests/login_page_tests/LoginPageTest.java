package idemobspb_aqa_q1822_ui_tests.login_page_tests;

import idemobspb_aqa_q1822_ui_tests.base.BaseUITestsClass;
import idemobspb_aqa_q1822_ui_tests.service.LoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageTest extends BaseUITestsClass {


    private LoginService loginService;

    @BeforeEach
    public void openLoginPage() throws InterruptedException {

        driver.manage().window().maximize();

        driver.get("https://idemo.bspb.ru/");
    }

    @Test
    public void verifyLoginInputVisibility() {
        //Given
        loginService = new LoginService(driver);

        //Then
        Assertions.assertEquals(false, loginService.getLoginPage().getLoginBlock().loginField.isDisplayed());

    }

    @Test
    public void verifyLoginInputValidParameters() {
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
    public void verifyLoginInputInvalidParameters() {
        //Given
        String initialWrongLoginString = "incorrect";
        String initialPassword = "1234";
        String expectedErrormessage = "Неверные данные пользователя (осталось 2 попытки)";

        loginService = new LoginService(driver);
        loginService.getLoginPage().getLoginBlock().loginField.clear();
        loginService.getLoginPage().getLoginBlock().passwordField.clear();
        loginService.getLoginPage().getLoginBlock().loginField.sendKeys(initialWrongLoginString);
        loginService.getLoginPage().getLoginBlock().passwordField.sendKeys(initialPassword);

        //When
        loginService.getLoginPage().getLoginBlock().loginButton.click();

        //Then
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(4000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginService.getLoginPage().getLoginBlock().errorMessageBy));

        String actualErrorMessageText = loginService.getLoginPage().getLoginBlock().errorMessage.getText();
        Assertions.assertEquals(expectedErrormessage, actualErrorMessageText);
    }

    @Test
    public void checkExitFromPage() {

        verifyLoginInputValidParameters();

        WebElement exitButton = driver.findElement(By.xpath("//span[@class='icon-close']"));

        exitButton.click();

    }

    @Test
    public void verifyRecoveryButton() {

        WebElement recoveryButton = driver.findElement(By.xpath("//a[@class='chevron']"));
        recoveryButton.click();

    }

    @Test
    public void verifyButtonShowPassword() {

        WebElement buttonShowPassword = driver.findElement(By.xpath("//div[@class='eye-icon-wrapper-web on']"));
        buttonShowPassword.click();

        WebElement buttonShowPasswordOff = driver.findElement(By.xpath("//div[@class='eye-icon-wrapper-web off']"));
        buttonShowPasswordOff.click();

    }

    @Test
    public void verifyButtonInEnglish() {

        WebElement buttonInEnglish = driver.findElement(By.xpath("//a[@class='chevron locale inline-block']"));
        buttonInEnglish.click();

    }

    @Test
    public void verifyButtonAboutUs() {

        WebElement buttonInEnglish = driver.findElement(By.xpath("//a[@class='chevron inline-block']"));
        buttonInEnglish.click();

    }

    @Test
    public void checkOpenPageForChangePassword() {

        verifyLoginInputValidParameters();

        WebElement buttonSettings = driver.findElement(By.xpath("//span[@class='icon-cog']"));
        buttonSettings.click();

//        WebElement buttonChangePassword = driver.findElement(By.xpath("//i[text()='Изменить пароль']"));
//        buttonChangePassword.click();

    }


}
