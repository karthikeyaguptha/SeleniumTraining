package InterviewPrac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LinkValidations {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //WebDriver initialisation and Maximise
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Getting the URL
        driver.get("https://www.dialpad.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }

    @Test
    public void driverCode()
    {
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//a[@href]"));
        System.out.println("Total Links existing in page:" + listOfLinks.size());
        for (WebElement link : listOfLinks) {

//            System.out.println("Link Name:"+link.getAttribute("href")+"\n"+"Link Text:"+link.getText());
            System.out.println(link.getText() + "::" + link.getAttribute("href"));
//            System.out.println("Link Text:"+link.getText());
        }
    }

    @AfterMethod
    public void tearDown() {
        //TearDown code
        driver.quit();
    }

}
