package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FeedPOM {

    WebDriver driver;

    WebDriverWait wait;

    @FindBy(id = "post1")
    WebElement userPost;

    public FeedPOM(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);

    }

    public void clickPost(){
        this.userPost.click();
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/account"));
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }
}
