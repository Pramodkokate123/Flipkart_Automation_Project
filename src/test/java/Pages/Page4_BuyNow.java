package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page4_BuyNow
{
    WebDriver driver;

    public Page4_BuyNow(WebDriver dr)
    {
        this.driver = dr;
        PageFactory.initElements(dr,this);
    }

    @FindBy(xpath = "//button[text()='Deliver Here']")
    private WebElement Deliver;

    @FindBy(xpath = "//button[text()='CONTINUE']")
    private WebElement Continue;

    public WebElement Deliver_Here()
    {
        return Deliver;
    }
    public WebElement Continue_Process()
    {
        return Continue;
    }
}
