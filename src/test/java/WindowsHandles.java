import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WindowsHandles {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String URL = "https://testautomationpractice.blogspot.com/";

        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String parentWindow = driver.getWindowHandle();

//        System.out.println("Parent Window Value: " +parentWindow);
//

        driver.findElement(By.xpath("//*[@id='PopUp']")).click();

        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String currentWindow : allWindowHandles) {

//            System.out.println("Current Window Value: " +currentWindow);

            if (!parentWindow.equals(currentWindow)) {

                driver.switchTo().window(currentWindow);

                System.out.println(driver.getTitle());

                if ("Selenium".equals(driver.getTitle())) {
                    System.out.println(driver.getCurrentUrl());
                }

//                break;
            }

        }

        driver.quit();

//        String Title = driver.getTitle();
//        String Text = driver.findElement(By.xpath("//h1[@class='_title_yr8cq_26']")).getText();
//
//        System.out.println(Title + Text);


//

    }
}
