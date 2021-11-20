import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class NavigationMenu {

    public String getPageName() {
        return $(By.xpath("//*[@id=\"slider\"]/div/h1")).getText();
    }

    public void progressClick(){
        $(By.xpath("//*[@id=\"main-blocks\"]/div[1]/div[6]/a")).click();
    }
}
