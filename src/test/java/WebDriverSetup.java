import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverSetup {


    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); //maximise

        String URL = "https://www.selenium.dev/";

         driver.get(URL); //Loaded URL

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String title = driver.getTitle();  // Get Title
        System.out.println("Title: " +title); // Printed Title

        String CurrentURlLoaded = driver.getCurrentUrl(); //Getting URL
        System.out.println("URL LOADED: "+ CurrentURlLoaded);

        if (URL.equals(CurrentURlLoaded))
        {
            System.out.println("Driver has been loaded correct URL User has been passed");
        }
        else {
            System.out.println("URL has been changed.");
        }
//        driver.close();
        driver.quit();







    }


}
