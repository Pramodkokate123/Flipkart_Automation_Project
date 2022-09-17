package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page1_Landing_Page
{
    WebDriver driver;

    public Page1_Landing_Page(WebDriver dr)
    {
        this.driver = dr;
        PageFactory.initElements(dr,this);
    }

    @FindBy(xpath = "//a[@class='_21ljIi']")
    private WebElement logo;

    @FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
    private WebElement lightbox;

    @FindBy(xpath = "//a[text()='Login']")
    private WebElement login;

    @FindBy(xpath = "//form[@autocomplete='on']//child::input[@type='text']")
    private WebElement UserID;

    @FindBy(xpath = "//form[@autocomplete='on']//child::input[@type='password']")
    private WebElement PassWord;

    @FindBy(xpath = "//form[@autocomplete='on']//child::button[@type='submit']")
    private WebElement button;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    public WebElement Light_Box()
    {
        return lightbox;
    }
    public WebElement Logo()
    {
        return logo;
    }
    public WebElement Login_Button()
    {
        return login;
    }
    public WebElement UserID_Field()
    {
        return UserID;
    }
    public WebElement Password_Field()
    {
        return PassWord;
    }
    public WebElement Login_Field_Button()
    {
        return button;
    }
    public WebElement Search_Box()
    {
        return searchBox;
    }
    public WebElement Search_Button()
    {
        return searchButton;
    }

}
