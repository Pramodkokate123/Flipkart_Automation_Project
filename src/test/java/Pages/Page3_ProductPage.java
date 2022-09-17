package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page3_ProductPage
{

    WebDriver driver;

    public Page3_ProductPage(WebDriver dr)
    {
        this.driver = dr;
        PageFactory.initElements(dr,this);
    }

    @FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
    private WebElement kartButton;

    @FindBy(xpath = "//button[@type='button']")
    private WebElement buyButton;


    public WebElement KartButton()
    {
        return kartButton;
    }
    public WebElement BuyButton()
    {
        return buyButton;
    }


}
