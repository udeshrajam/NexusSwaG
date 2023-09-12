package assessment.web.ui.pages;

import assessment.web.ui.utility.Constants;
import assessment.web.ui.utility.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LoginPage extends testBase {
    By txt_username = By.id("user-name");

    By txt_password = By.id("password");

    By btn_login = By.id("login-button");

    By btn_menu = By.id("react-burger-menu-btn");

    By btn_logout = By.id("logout_sidebar_link");


    public LoginPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TimeOut));
    }

    public void textUsername(String UserType) throws IOException {
        String username;
        switch (UserType.toLowerCase()) {
            case "problem user" -> {
                username = Config().getProperty("problemUser");
            }
            case "locked user" -> {
                username = Config().getProperty("lockedUser");
            }
            case "standard user" -> {
                username = Config().getProperty("standardUser");
            }
            default ->  username = Config().getProperty("standardUser");
        }
        element = wait.until(ExpectedConditions.elementToBeClickable(txt_username));
        element.sendKeys(username);
    }

    public void textPassword() throws IOException {
        element = wait.until(ExpectedConditions.elementToBeClickable(txt_password));
        element.sendKeys(Config().getProperty("password"));
    }


    public void clickLogin() {
        element = wait.until(ExpectedConditions.elementToBeClickable(btn_login));
        element.click();
    }


    public void logout() throws InterruptedException {
        element = wait.until(ExpectedConditions.elementToBeClickable(btn_menu));
        element.click();
        Thread.sleep(3000);
        element = wait.until(ExpectedConditions.elementToBeClickable(btn_logout));
        element.click();
    }


}

