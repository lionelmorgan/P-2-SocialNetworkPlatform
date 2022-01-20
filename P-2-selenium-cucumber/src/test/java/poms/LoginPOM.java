package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPOM {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "username")
    WebElement usernameInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(className = "login")
    WebElement loginBtn;

    @FindBy(className = "register")
    WebElement registerBtn;

    @FindBy(id = "message")
    WebElement messageElem;

    @FindBy(className = "forgot")
    WebElement forgotPasswordLink;

    public LoginPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }

    public void enterUsername(String username){
        this.usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        this.passwordInput.sendKeys(password);
    }

    public void clickLogin(){
        this.loginBtn.click();
    }
    public void clickForgotPassword(){
        this.forgotPasswordLink.click();
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/forget-password"));
    }

    public void waitForSuccessfulLogin(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/account"));
    }

    public String getMessage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.messageElem));
        return this.messageElem.getText();
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    public void clickRegister(){
        this.registerBtn.click();
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/register"));
    }

}
