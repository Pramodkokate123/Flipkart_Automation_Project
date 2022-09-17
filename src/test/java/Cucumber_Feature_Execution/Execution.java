package Cucumber_Feature_Execution;

import Browser.Browser;
import Pages.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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


    @Given("Open flipkart site in our desired {string}")
    public void open_flipkart_site_in_our_desired(String browser) throws IOException
    {
        Browser.Initialize_Browser(browser);
    }

    @And("Login with valid {string} and {string}")
    public void login_with_valid_and(String UserID, String Password) throws InterruptedException
    {
        page1 = new Page1_Landing_Page(driver);
        page1.Light_Box().click();
        Assert.assertEquals(page1.Logo().getText(),properties.get("Logo"));
        page1.Login_Button().click();
        page1.UserID_Field().sendKeys(UserID);
        page1.Password_Field().sendKeys(Password);
        page1.Login_Field_Button().click();
        Thread.sleep(2000);
    }

    @When("Search {string} in search field and click on search icon")
    public void search_in_search_field_and_click_on_search_icon(String item) throws InterruptedException
    {
        page1.Search_Box().sendKeys(item);
        page1.Search_Button().click();
        Thread.sleep(3000);
    }

    @Then("It will click on first product and collect all related products information")
    public void it_will_click_on_first_product_and_collect_all_related_products_information()
    {
        page2 = new Page2_Results(driver);
        List<WebElement> list = page2.Item_List();
        for (int i=0;i<list.size();i++)
        {
            System.out.println(i+1+"  :  "+list.get(i).getText());
        }
        page2.Select_Product().click();
    }

    @But("It will click on add to cart option")
    public void it_will_click_on_add_to_cart_option()
    {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String w1 = iterator.next();
        String w2 = iterator.next();
        driver.switchTo().window(w2);
        page3 = new Page3_ProductPage(driver);
        page3.KartButton().click();
    }

    @Then("It will proceed further actions")
    public void it_will_proceed_further_actions() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page4_a = new Page4_AddCart(driver);
        page4_a.Place_Order().click();
        Thread.sleep(2000);
        page4_a.Deliver_Here().click();
        page4_a.Continue_Process().click();
    }

}
