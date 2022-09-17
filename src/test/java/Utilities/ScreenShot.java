package Utilities;

import Browser.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenShot extends Browser
{
    public static void Screen_Shot(String FileName) throws IOException
    {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"\\pk_Screenshot\\"+FileName+".png";
        FileUtils.copyFile(file,new File(path));
    }
}
