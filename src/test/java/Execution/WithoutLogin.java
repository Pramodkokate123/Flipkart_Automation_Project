package Execution;

import Browser.Browser;
import Data.MySQL;
import Pages.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WithoutLogin extends Browser
{

    public Page1_Landing_Page page1;
    public Page2_Results page2;
    public Page3_ProductPage page3;
    public Page4_AddCart page4_a;

    @Parameters({"browser"})
    @BeforeTest
    public void OpenBrowser(String browser) throws IOException
    {
        Browser.Initialize_Browser(browser);
    }

    @Test
    public void p1_Without_Login() throws InterruptedException
    {
        page1 = new Page1_Landing_Page(driver);
        page1.Light_Box().click();
        Assert.assertEquals(page1.Logo().getText(),properties.get("Logo"));
        Thread.sleep(2000);
    }

    @Parameters({"item"})
    @Test
    public void p2_Search_Item(String s) throws InterruptedException
    {
        page1.Search_Box().sendKeys(s);
        page1.Search_Button().click();
        Thread.sleep(3000);
        page2 = new Page2_Results(driver);
        List<WebElement> list = page2.Item_List();
        for (int i=0;i<list.size();i++)
        {
            System.out.println(i+1+"  :  "+list.get(i).getText());
        }
        page2.Select_Product().click();
    }

    @Test
    public void p3_Product_Process()
    {
        Set<String> windows = driver.getWindowHandles();
        Iterator <String> iterator = windows.iterator();
        String w1 = iterator.next();
        String w2 = iterator.next();
        driver.switchTo().window(w2);
    }

    @Test
    public void p4_WithoutLogin() throws IOException
    {
        page3 = new Page3_ProductPage(driver);
        page3.KartButton().click();
        page4_a = new Page4_AddCart(driver);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        page4_a.Place_Order().click();
    }


}