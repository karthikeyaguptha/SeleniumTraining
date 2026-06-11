import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class TabSwitch {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String URL = "https://rahulshettyacademy.com/AutomationPractice/";

        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String originalTab = driver.getWindowHandle();

        driver.findElement(By.xpath("//*[@id='opentab']")).click();

        Set<String> allTabs = driver.getWindowHandles();

        for (String allTab : allTabs) {

            if (!originalTab.equals(allTab)) {

                driver.switchTo().window(allTab);

                System.out.println(driver.getCurrentUrl());
                break;
            }

        }

        driver.quit();


    }
}
