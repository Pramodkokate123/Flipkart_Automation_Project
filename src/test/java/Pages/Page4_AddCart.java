package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page4_AddCart
{
    WebDriver driver;

    public Page4_AddCart(WebDriver dr)
    {
        this.driver = dr;
        PageFactory.initElements(dr,this);
    }

    @FindBy(xpath = "//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
    private WebElement button;

    @FindBy(xpath = "//button[text()='Deliver Here']")
    private WebElement deliver;

    @FindBy(xpath = "//button[text()='CONTINUE']")
    private WebElement conti;

    public WebElement Place_Order()
    {
        return button;
    }
    public WebElement Deliver_Here()
    {
        return deliver;
    }
    public WebElement Continue_Process()
    {
        return conti;
    }
}
