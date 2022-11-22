package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUP(){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){

        //find username field and Enter tomsmith
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        //find Password field and enter SuperSecretPassword!
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //find LOGIN button and click on it
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        //Verify Error message "“Secure Area"

        String expectedMessage = "Secure Area";
        WebElement actualTextMessage = driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
        //Stored webelement into String
        String actualMessage = actualTextMessage.getText();
        //Compared actual and expected result
        Assert.assertEquals("not logged in successfully",expectedMessage,actualMessage);
    }

    @After
    public void teardown(){
        closeBrowser();
    }
}
