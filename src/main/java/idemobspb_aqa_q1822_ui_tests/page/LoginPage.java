package idemobspb_aqa_q1822_ui_tests.page;

import idemobspb_aqa_q1822_ui_tests.block.LoginBlock;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private LoginBlock loginBlock = new LoginBlock(driver);

    public LoginPage (WebDriver driver) {

        super(driver);
    }

    public LoginBlock getLoginBlock() {

        return loginBlock;
    }
}
