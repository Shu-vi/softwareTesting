import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//*[@id=\"eu_enter\"]/input[1]")
    private WebElement login;
    @FindBy(xpath = "//*[@id=\"eu_enter\"]/input[2]")
    private WebElement password;
    @FindBy(xpath = "//*[@id=\"top-panel\"]/div[1]/div[1]/a")
    private WebElement loginPasswordFormBtn;
    @FindBy(xpath = "//*[@id=\"eu_enter\"]/input[3]")
    private WebElement toAuthorisationBtn;
    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void openWindowAuthorisation(){
        this.loginPasswordFormBtn.click();
    }

    public void inputLogin(String login){
        this.login.sendKeys(login);
    }

    public void inputPassword(String password){
        this.password.sendKeys(password);
    }

    public void ToAuthorisation(){
        toAuthorisationBtn.click();
    }
}
