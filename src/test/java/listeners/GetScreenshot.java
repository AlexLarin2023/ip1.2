package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class GetScreenshot {
    public static void capture(WebDriver driver, String filename){ //надо вот эту функцию вызвать
        try{
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver; //нам надо еще одну библиотеку скачать
            File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file,new File("./screenshot/"+filename+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}