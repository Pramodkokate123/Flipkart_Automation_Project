package Cucumber_Feature_Execution;

import Browser.Browser;
import Pages.Page1_Landing_Page;
import Pages.Page2_Results;
import Pages.Page3_ProductPage;
import Pages.Page4_AddCart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Without_Login extends Browser
{

    public Page1_Landing_Page page1;
    public Page2_Results page2;
    public Page3_ProductPage page3;
    public Page4_AddCart page4_a;

    @Given("Open flipkart in our desired {string}")
    public void open_flipkart_in_our_desired(String browser) throws IOException
    {
        Browser.Initialize_Browser(browser);
    }

    @When("Add to cart product without login")
    public void add_to_cart_product_without_login() throws InterruptedException
    {
        page1 = new Page1_Landing_Page(driver);
        page1.Light_Box().click();
        Assert.assertEquals(page1.Logo().getText(),properties.get("Logo"));
        Thread.sleep(2000);
    }

    @When("Search {string} in search box and then click on search icon")
    public void search_in_search_box_and_then_click_on_search_icon(String item)
    {
        page1.Search_Box().sendKeys(item);
        page1.Search_Button().click();
    }

    @Then("It will click on first product and print all the products")
    public void it_will_click_on_first_product_and_print_all_the_products() throws InterruptedException
    {
        Thread.sleep(3000);
        page2 = new Page2_Results(driver);
        List<WebElement> list = page2.Item_List();
        for (int i=0;i<list.size();i++)
        {
            System.out.println(i+1+"  :  "+list.get(i).getText());
        }
        page2.Select_Product().click();
    }

    @Then("It will proceed further process of product")
    public void it_will_proceed_further_process_of_product()
    {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String w1 = iterator.next();
        String w2 = iterator.next();
        driver.switchTo().window(w2);
    }

    @Then("It will proceed just up to payment option")
    public void it_will_proceed_just_up_to_payment_option()
    {
        page3 = new Page3_ProductPage(driver);
        page3.KartButton().click();
        page4_a = new Page4_AddCart(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page4_a.Place_Order().click();
    }
}
