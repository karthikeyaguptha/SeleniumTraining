package InterviewPrac.dynamicwebtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindingBrowserRow {

    public static WebDriver driver;
    @FindBy
    static String browserLocator;


    @BeforeMethod
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com");
    }

    @AfterMethod
    public void tearDown()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }


    public static void findingAnyBrowserRowPassed(String browser)
    {
        browserLocator = "//table[@id='taskTable']/tbody[@id='rows']/child::tr/td[text()='"+browser+"']";
        //table[@id='taskTable']/tbody[@id='rows']/child::tr/td[text()=Firefox']
        //table[@id='taskTable']/tbody[@id='rows']/child::tr/td[text()=Firefox]
        String actualBrowser = driver.findElement(By.xpath(browserLocator)).getText();

        //Assertion
        Assert.assertEquals(actualBrowser,browser);
    }

    public void browserRowValues(String browser)
    {
        browserLocator = "//table[@id='taskTable']/tbody[@id='rows']/child::tr/td[text()='"+browser+"']/following-sibling::*";
        //table[@id='taskTable']/tbody[@id='rows']/child::tr/td[text()='Chrome']/following-sibling::td[1]

        String[] headers = {"Network (Mbps)","Memory (MB)","CPU (%)","Disk (MB/s)"};
        int count = 0;

        List<WebElement> actualBrowserRowElements = driver.findElements(By.xpath(browserLocator));
        System.out.println("Browser:"+browser);
        for (WebElement elementVal : actualBrowserRowElements)
        {
            System.out.println(headers[count]+":"+elementVal.getText());
            count++;
        }
    }
    public void browserRowValues(String browser,boolean isCPUVal)
    {
        browserLocator = "//table[@id='taskTable']/tbody[@id='rows']/child::tr/td[text()='"+browser+"']/following-sibling::*";
        //table[@id='taskTable']/tbody[@id='rows']/child::tr/td[text()='Chrome']/following-sibling::td[1]

        String[] headers = {"Network (Mbps)","Memory (MB)","CPU (%)","Disk (MB/s)"};
        int count = 2;

        List<WebElement> actualBrowserRowElements = driver.findElements(By.xpath(browserLocator));

        System.out.println("Browser:"+browser);
        for (int i = 0; i <actualBrowserRowElements.size(); i++) {
          if (isCPUVal)
          {
              System.out.println(headers[3]+":"+actualBrowserRowElements.get(3));
          }
        }
    }

    @Test
    public void findingChromeRow()
    {
        String browser = "Chrome";
        findingAnyBrowserRowPassed(browser);
        browserRowValues(browser);
    }

    @Test
    public void findingFireFoxRow()
    {
        String browser = "Firefox";
        findingAnyBrowserRowPassed(browser);
        browserRowValues(browser,true);
    }
















}
