package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ForgotPasswordPOM {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "forgot")
    WebElement forgotPasswordLink;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(className = "send")
    WebElement sendBtn;

    @FindBy(className = "success")
    WebElement successMessage;

    public ForgotPasswordPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }

    public void clickForgotPassword(){
        this.forgotPasswordLink.click();
    }

    public void waitForSuccessfulRedirect(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/forget-password"));
    }

    public String getSuccessMessage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.successMessage));
        return this.successMessage.getText();
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    public void enterEmail(String email){
        this.emailInput.sendKeys(email);
    }

    public void clickSend(){ this.sendBtn.click();}

}