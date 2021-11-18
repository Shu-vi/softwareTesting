import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressPage {
    @FindBy(xpath = "//*[@id=\"under-slider-menu\"]/div/a[2]/i")
    private WebElement aboutMe;
    private WebDriver driver;

    public ProgressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void toAboutMe(){
        aboutMe.click();
    }
}
