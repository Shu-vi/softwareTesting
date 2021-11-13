import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestAuthorizationKPFU {
    static WebDriver driver;

    @BeforeClass
    public static void startBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kpfu.ru/");
    }

    @Test
    public void openAndAuthorizationOnSite() {
        driver.findElement(By.xpath("//*[@id=\"top-panel\"]/div[1]/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"eu_enter\"]/input[1]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"eu_enter\"]/input[2]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"eu_enter\"]/input[3]")).click();//Авторизация в лк
        driver.findElement(By.xpath("//*[@id=\"main-blocks\"]/div[1]/div[6]/a")).click();//Переход в успеваемость
        Assert.assertEquals("Аналитика успеваемости",driver.getTitle());
    }

    @Test
    public void checkCorrectLogin(){
        driver.findElement(By.xpath("//*[@id=\"under-slider-menu\"]/div/a[2]/i")).click();//Переход в партофило
        String name = driver.findElement(By.xpath("//*[@id=\"info\"]/div/div[1]/div[2]/div[2]/span[2]")).getText();//Получить ФИО
        Assert.assertEquals("Генералов Вадим Викторович", name);
    }
}
