package idemobspb_aqa_q1822_ui_tests.service;

import idemobspb_aqa_q1822_ui_tests.page.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginService extends BaseService {

    private LoginPage loginPage = new LoginPage(driver);

    public LoginService(WebDriver driver) {

        super(driver);
    }

    public LoginPage getLoginPage() {

        return loginPage;
    }
}
