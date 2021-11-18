import org.asynchttpclient.webdav.WebDavCompletionHandlerBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationMenu {
    @FindBy(xpath = "//*[@id=\"slider\"]/div/h1")
    private WebElement pageName;
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"main-blocks\"]/div[1]/div[6]/a")
    private WebElement progressBtn;

    public NavigationMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getPageName() {
        return pageName.getText();
    }

    public void progressClick(){
        progressBtn.click();
    }
}
