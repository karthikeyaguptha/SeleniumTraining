package InterviewPrac.dynamicwebtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindingChrome {

    public static WebDriver driver;
    String URL = "https://testautomationpractice.blogspot.com";
    @FindBy
    WebElement chromeLocator;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebElement waitUtil_ElementClickable(WebElement webElement)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    @Test
    public void findingChromeRow()
    {
        chromeLocator = driver.findElement(By.xpath("//table[@id='taskTable']/tbody[@id='rows']/child::tr/td[text()='Chrome']"));
//        String chromeText = driver.findElement(By.xpath(chromeLocator)).getText();
        String chromeText = waitUtil_ElementClickable(chromeLocator).getText();


        //Assertion
        Assert.assertEquals(chromeText,"Chrome");

    }


}
