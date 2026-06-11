import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHandling {

    public static void main(String[] args) {



        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String URL = "https://demoqa.com/alerts";

        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.id("promtButton")).click();

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("TEST INPUT KEYS IN ALERTS");

        alert.accept(); // Clicks on OK Button or Confirms

        System.out.println(driver.findElement(By.id("promptResult")).getText());

//        alert.dismiss(); //Clicks on Cancel/dismiss buttons
//
//        alert.sendKeys("Text"); //input


        driver.quit();















    }
}
