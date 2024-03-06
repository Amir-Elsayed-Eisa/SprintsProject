package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class Helper {


    /*
        @Func: function is used to generate a screenshot into a generated directory.
        @param: <driver> "object from the WebDriver library", <screenshotName> "string type parameter contains the method name that causes generating the screenshot".
        @Return_value: no value will be returned by the function.
     */
    public static void captureScreenshot (WebDriver driver, String screenshotName){
        Path folderDir = Paths.get("./Screenshots", screenshotName+".png");
        try {
            Files.createDirectories(folderDir.getParent());
            FileOutputStream output = new FileOutputStream(folderDir.toString());
            output.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            output.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e)   {
            System.out.println("Exception while generating the screenshot"+ e.getMessage());

        }
    }


}
