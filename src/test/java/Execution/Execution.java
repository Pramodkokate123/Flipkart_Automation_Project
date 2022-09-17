package Execution;

import Browser.Browser;
import Data.MySQL;
import Pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Execution extends Browser
{

    public Page1_Landing_Page page1;
    public Page2_Results page2;
    public Page3_ProductPage page3;
    public Page4_AddCart page4_a;
    public Page4_BuyNow page4_b;

    @Parameters({"browser"})
    @BeforeTest
    public void OpenBrowser(String browser) throws IOException
    {
        Browser.Initialize_Browser(browser);
    }

    @Test(dataProvider = "Info",dataProviderClass = MySQL.class)
    public void p1_Login(String user,String pass) throws InterruptedException
    {
        page1 = new Page1_Landing_Page(driver);
        page1.Light_Box().click();
        Assert.assertEquals(page1.Logo().getText(),properties.get("Logo"));
        page1.Login_Button().click();
        page1.UserID_Field().sendKeys(user);
        page1.Password_Field().sendKeys(pass);
        page1.Login_Field_Button().click();
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
    public void p4_Cart() throws InterruptedException
    {
        page3 = new Page3_ProductPage(driver);
        page3.KartButton().click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page4_a = new Page4_AddCart(driver);
        page4_a.Place_Order().click();
        Thread.sleep(2000);
        page4_a.Deliver_Here().click();
        page4_a.Continue_Process().click();
    }

//    @Test
//    public void p4_Buy() throws InterruptedException
//    {
//        page3 = new Page3_ProductPage(driver);
//        page3.BuyButton().click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        page4_b = new Page4_BuyNow(driver);
//        page4_b.Deliver_Here().click();
//        page4_b.Continue_Process().click();
//    }

}
