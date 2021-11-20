import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ProgressPage {

    public String getTitle(){
        return Selenide.title();
    }

    public void toAboutMe(){
        $(By.xpath("//*[@id=\"under-slider-menu\"]/div/a[2]/i")).click();
    }
}
