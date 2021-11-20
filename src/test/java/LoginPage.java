import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public void openWindowAuthorisation(){
        $(By.xpath("//*[@id=\"top-panel\"]/div[1]/div[1]/a")).click();
    }

    public void inputLogin(String login){
        $(By.xpath("//*[@id=\"eu_enter\"]/input[1]")).setValue(login);
    }

    public void inputPassword(String password){
        $(By.xpath("//*[@id=\"eu_enter\"]/input[2]")).setValue(password);
    }

    public void ToAuthorisation(){
        $(By.xpath("//*[@id=\"eu_enter\"]/input[3]")).click();
    }
}
