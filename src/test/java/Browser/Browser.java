package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Browser
{

    public static WebDriver driver;
    public static FileInputStream file;
    public static Properties properties;

    public static void Initialize_Browser(String browser) throws IOException
    {

        file = new FileInputStream("C:\\Users\\DELL\\IdeaProjects\\Flipkart_Automation\\src\\test\\java\\Browser\\Information.properties");
        properties = new Properties();
        properties.load(file);

        if (browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("ie"))
        {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        driver.manage().window().maximize();
        driver.get(properties.getProperty("URL"));

    }
}
