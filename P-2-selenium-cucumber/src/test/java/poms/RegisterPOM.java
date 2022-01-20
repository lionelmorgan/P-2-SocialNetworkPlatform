package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class RegisterPOM {

    WebDriver driver;

    WebDriverWait wait;

    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "firstname")
    WebElement firstNameInput;

    @FindBy(id = "lastname")
    WebElement lastNameInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(name = "fileimg")
    WebElement fileInput;

    @FindBy(className = "err")
    WebElement errorMessage;

    @FindBy(id = "login-btn")
    WebElement registerBtn;

    public RegisterPOM(WebDriver driver){
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

    public void enterFirstName(String firstName){
        this.firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        this.lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email){
        this.emailInput.sendKeys(email);
    }

    public void enterFileImg(){
        this.fileInput.sendKeys("C:\\Users\\lione\\OneDrive\\Pictures\\Earth.jpg");
    }
    //"C:\\Users\\china\\Pictures\\Saved Pictures\\bird"
    public void clickBtn(){
        this.registerBtn.click();
    }

    public void waitForSuccessfulRegister(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/"));
    }

    public String getErrorMessage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.errorMessage));
        return this.errorMessage.getText();
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

}
