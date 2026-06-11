import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class iframeHandling {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String URL = "https://rahulshettyacademy.com/AutomationPractice/";

        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='courses-iframe']")); //rel

        driver.switchTo().frame(iframe);

        String Text = driver.findElement(By.xpath("/html/body/div/section/div/div/div[1]/h2")).getText(); //abs

        System.out.println("Inside iFrame:" + Text);

        driver.switchTo().defaultContent();

        System.out.println("Outside iFrame: " + driver.findElement(By.xpath("/html/body/h1")).getText());


        driver.quit();


    }
}
