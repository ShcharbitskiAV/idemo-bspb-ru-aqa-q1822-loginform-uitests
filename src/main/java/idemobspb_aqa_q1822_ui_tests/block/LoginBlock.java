package idemobspb_aqa_q1822_ui_tests.block;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginBlock extends BaseBlock {

    public LoginBlock (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;

    public By errorMessageBy = By.xpath("//div[@class='alert alert-error']");

    @FindBy (xpath = "//*[@id='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@id='otp-code']")
    public WebElement smsField;

    @FindBy (xpath = "//button[@id='login-otp-button']")
    public WebElement smsButton;
}
