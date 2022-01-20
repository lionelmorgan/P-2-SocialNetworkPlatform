package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreatePostPOM {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "newPostBtn")
    WebElement newPostBtn;

    @FindBy(id = "description")
    WebElement descriptionInput;

    @FindBy(name = "fileimg")
    WebElement fileInput;

    @FindBy(id = "confirmBtn")
    WebElement confirmBtn;

    public CreatePostPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }

    public void enterDescription(String description) {
        this.descriptionInput.sendKeys(description);
    }

    public void enterImg() {
        this.fileInput.sendKeys("C:\\Pictures\\Earth.jpg");
    }

    public void clickNewPost() {
        this.newPostBtn.click();
    }

    public void clickConfirm() {
        this.confirmBtn.click();
    }
    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }
}
