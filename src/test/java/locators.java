import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class locators {


    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String URL = "https://www.selenium.dev/";

        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String xpathText = driver.findElement(By.xpath("//h4[@class='h3 mb-3 selenium-webdriver']")).getText();
        System.out.println(xpathText);

        //h3 mb-3 selenium-webdriver
//        String classText = driver.findElement(By.className("mx-auto text-center p-4")).getText();
//        System.out.println(classText);

//        driver.findElement(By.linkText("Visit Conference Website for more information!!!!!!!!")).click();

        driver.findElement(By.partialLinkText("Visit Conference Website")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.quit();

    }
}
