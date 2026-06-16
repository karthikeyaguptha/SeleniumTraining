import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class dragandDrop {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String URL = "https://www.qa-practice.com/elements/dragndrop/boxes";

        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Actions action = new Actions(driver);

        WebElement dragMe = driver.findElement(By.xpath("//*[@id='rect-draggable']"));

        WebElement dropMe = driver.findElement(By.xpath("//*[@id='rect-droppable']"));

        action.dragAndDrop(dragMe, dropMe).perform();

        System.out.println(driver.findElement(By.xpath("//*[@id='text-droppable']")).getText());


        driver.quit();


    }
}
