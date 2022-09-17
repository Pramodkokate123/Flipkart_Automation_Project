package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Page2_Results
{
    WebDriver driver;

    public Page2_Results(WebDriver dr)
    {
        this.driver = dr;
        PageFactory.initElements(dr,this);
    }

    @FindBy(xpath = "//div[@data-tkid]//child::div[@class='_2WkVRV'] | //div[@data-tkid]//child::div[@class='_4rR01T'] | //div[@data-tkid]//child::a[@class='s1Q9rs' and @title]")
    private List<WebElement> itemList;

    @FindBy(xpath = "(//div[@class='_13oc-S']//div[@data-id])[3] | (//div[@class='_13oc-S _1t9ceu']//div[@data-id])[1]")
    private WebElement select;

    public List<WebElement> Item_List()
    {
        return itemList;
    }
    public WebElement Select_Product()
    {
        return select;
    }
}