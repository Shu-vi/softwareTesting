import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException;
import static com.codeborne.selenide.Selenide.$;

public class AboutMe {


    public String getFullName() {
        return $(By.xpath("//*[@id=\"info\"]/div/div[1]/div[2]/div[2]/span[2]")).getText();
    }

    public void uploadImage(File file){
        if (isElementPresented("//*[@id=\"info\"]/div/div[1]/div[1]/div[1]/form/div[1]/input"))
            $(By.xpath("//*[@id=\"info\"]/div/div[1]/div[1]/div[1]/form/div[1]/input")).shouldBe(Condition.exist).uploadFile(file);
    }

    public void saveImage(){
        if (isElementPresented("//*[@id=\"info\"]/div/div[1]/div[1]/div[1]/form/div[2]/input"))
            $(By.xpath("//*[@id=\"info\"]/div/div[1]/div[1]/div[1]/form/div[2]/input")).shouldBe(Condition.exist).click();
        else
            deleteImage();

    }

    public File downloadSample(){
        if (isElementPresented("//*[@id=\"under-slider-menu\"]/div/a[9]"))
            try {
                return $(By.xpath("//*[@id=\"under-slider-menu\"]/div/a[9]")).download();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        return null;
    }

    public void checkFile(File file){

    }

    private Boolean isElementPresented(String xpath){
        boolean elementCondition = false;
        try{
            elementCondition = $(By.xpath(xpath)).isDisplayed();
        }
        catch (NoSuchElementException e){
            return  elementCondition;
        }
        return elementCondition;
    }
    private void deleteImage(){
        $(By.xpath("//*[@id=\"info\"]/div/div[1]/div[1]/div[2]/div[2]")).click();
        $(By.xpath("//*[@id=\"answer\"]/a[1]")).click();
    }
}
