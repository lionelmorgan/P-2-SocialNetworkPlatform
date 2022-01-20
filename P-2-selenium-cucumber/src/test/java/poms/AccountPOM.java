package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPOM {

    WebDriver driver;

    WebDriverWait wait;

    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "firstname")
    WebElement firstnameInput;

    @FindBy(id = "lastname")
    WebElement lastnameInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "fileImg")
    WebElement imgInput;

    @FindBy(id = "type")
    WebElement acceptBtn;

    @FindBy(className = "err")
    WebElement errorMessage;

    @FindBy(className = "okMes")
    WebElement okMessage;

    @FindBy(id = "feedLink")
    WebElement feedLink;

    public AccountPOM(WebDriver driver){
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

    public void enterFirstName(String firstname){
        this.firstnameInput.sendKeys(firstname);
    }

    public void enterLastName(String lastname){
        this.lastnameInput.sendKeys(lastname);
    }

    public void enterEmail(String email){
        this.emailInput.sendKeys(email);
    }

    public void enterImage(){
        this.imgInput.sendKeys("C:\\Users\\china\\Pictures\\Saved Pictures\\bird.jpg");
    }

    public void clickAcceptBtn(){
        this.acceptBtn.click();
    }

    public String getErrorMessage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.errorMessage));
        return this.errorMessage.getText();
    }

    public String getOkMessage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.okMessage));
        return this.okMessage.getText();
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    public void clickFeed(){
        this.feedLink.click();
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/feed"));
    }


}
