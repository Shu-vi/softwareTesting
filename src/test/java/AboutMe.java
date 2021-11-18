import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutMe {
    @FindBy(xpath = "//*[@id=\"info\"]/div/div[1]/div[2]/div[2]/span[2]")
    private WebElement fullName;
    private WebDriver driver;

    public AboutMe(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getFullName() {
        return fullName.getText();
    }
}
