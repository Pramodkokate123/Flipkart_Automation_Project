package Cucumber_Runner_Files;


import cucumber.api.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\DELL\\IdeaProjects\\Flipkart_Automation\\src\\test\\java\\Cucumber_Feature\\Without_Login.feature"
        ,glue = "Cucumber_Feature_Execution"
)



public class Without_Login_Runner extends AbstractTestNGCucumberTests
{
  
}
