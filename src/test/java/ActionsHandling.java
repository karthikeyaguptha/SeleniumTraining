import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsHandling {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String URL = "https://qa-practice.razvanvancea.ro/mouse-hover.html";

        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Actions action = new Actions(driver);

        WebElement mouseDrop = driver.findElement(By.xpath("//*[@id='button-hover-over']"));

        action.moveToElement(mouseDrop).perform();


        driver.quit();


    }
}
