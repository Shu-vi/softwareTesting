import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.File;
import static com.codeborne.selenide.Selenide.open;


public class TestAuthorisationKPFU {
    private static LoginPage loginPage;
    private static NavigationMenu navigationMenu;
    private static ProgressPage progressPage;
    private static AboutMe aboutMe;
    private static File file;

    @BeforeClass
    public static void startBrowser(){
        navigationMenu = new NavigationMenu();
        progressPage = new ProgressPage();
        loginPage = new LoginPage();
        aboutMe = new AboutMe();
        file = new File("im2.jpg");
        open("https://kpfu.ru/");
    }

    @Step
    public static void titleIsExist(String title){
        Assert.assertTrue(!title.equals(""));
    }

    @Test
    public void openAndAuthorizationOnSite() {
        titleIsExist(Selenide.title());
        loginPage.openWindowAuthorisation();
        loginPage.inputLogin("VVGeneralov");
        loginPage.inputPassword("b7sr21r8");
        loginPage.ToAuthorisation();
        Assert.assertEquals("Электронный университет", navigationMenu.getPageName());
    }

    @Test
    public void toProgress(){
        //titleIsExist(Selenide.title());
        navigationMenu.progressClick();
        Assert.assertEquals("Аналитика успеваемости", progressPage.getTitle());
    }

    @Test
    public void toAboutMe(){
        titleIsExist(Selenide.title());
        progressPage.toAboutMe();
        Assert.assertEquals("Генералов Вадим Викторович", aboutMe.getFullName());
    }

    @Test
    public void uploadImAndDownloadDoc(){
        aboutMe.uploadImage(file);
        aboutMe.saveImage();
        file = aboutMe.downloadSample();
        aboutMe.checkFile(file);
    }
}
