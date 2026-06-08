import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectDropdown {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String URL = "https://rahulshettyacademy.com/AutomationPractice/";

        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

      WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
//      dropdown.click();

      Select sel =  new Select(dropdown);

//      sel.selectByVisibleText("Option2");
//      sel.selectByIndex(2);
      sel.selectByValue("option3");

        wait.wait(5000);

        driver.quit();
    }
}
