package InterviewPrac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class WindowsHandling {

    public static WebDriver driver;
    String URL ="https://testautomationpractice.blogspot.com/";

    @BeforeMethod
    public void setUp()
    {
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get(URL);

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void windowHandling() {
        String parentWindow = driver.getWindowHandle();
        //Click on PopupWindows
        driver.findElement(By.xpath("//*[@id='PopUp']")).click();

        Set<String> windows = driver.getWindowHandles();

        for (String currentWindow : windows) {
            driver.switchTo().window(currentWindow);
            System.out.println("Title:" + driver.getTitle() + "\n" + "URL:" + driver.getCurrentUrl());
            System.out.println("---------------------------------------------------");
//            if (!parentWindow.equalsIgnoreCase(currentWindow))
//            {
//                driver.switchTo().window(currentWindow);
//                System.out.println(driver.getCurrentUrl());
//            }
        }


    }






}
