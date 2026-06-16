import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionDoubleClick {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String URL = "https://qa-practice.netlify.app/double-click";

        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Actions action = new Actions(driver);

        WebElement doublclickEle = driver.findElement(By.xpath("//*[@id='double-click-btn']"));

        action.doubleClick(doublclickEle).perform();

        WebElement result = driver.findElement(By.xpath("//*[@id='double-click-result']"));

        System.out.println(result.getText());

        driver.quit();



    }
}
