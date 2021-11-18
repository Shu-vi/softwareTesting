import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestAuthorisationKPFU {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static NavigationMenu navigationMenu;
    private static ProgressPage progressPage;
    private static AboutMe aboutMe;

    @BeforeClass
    public static void startBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        navigationMenu = new NavigationMenu(driver);
        progressPage = new ProgressPage(driver);
        aboutMe = new AboutMe(driver);
        driver.get("https://kpfu.ru/");
    }

    @Test
    public void openAndAuthorizationOnSite() {
        loginPage.openWindowAuthorisation();
        loginPage.inputLogin("");
        loginPage.inputPassword("");
        loginPage.ToAuthorisation();
        Assert.assertEquals("Электронный университет", navigationMenu.getPageName());
    }

    @Test
    public void toProgress(){
        navigationMenu.progressClick();
        Assert.assertEquals("Аналитика успеваемости", progressPage.getTitle());
    }

    @Test
    public void toAboutMe(){
        progressPage.toAboutMe();
        Assert.assertEquals("Генералов Вадим Викторович", aboutMe.getFullName());
    }
}
