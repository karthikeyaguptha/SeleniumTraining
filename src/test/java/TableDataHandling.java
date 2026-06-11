import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TableDataHandling {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String URL = "file:///D:/Claude_code/index.html";

        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement table = driver.findElement(By.xpath("//table[@id='StudentData']"));


//        for (int i = 2; i <= 5; i++) {
//
//            WebElement row = driver.findElement(By.xpath("//table[@id='StudentData']/tbody/tr["+i+"]"));
//
//            for (int j = 1; j <= 2; j++) {
//
//              String cellData =   row.findElement(By.xpath(". /td[" + j + "]" )).getText();
//
//                System.out.println(cellData);
//
//            }
//
//        }


        for (int i = 2; i <= 5; i++) {

            for (int j = 1; j <= 2; j++) {

                String cellData =  driver.findElement(By.xpath("//table[@id='StudentData']/tbody/tr["+i+"]/td[" +j+ "]")).getText();

                System.out.print(cellData);

            }
            System.out.println(" ");

        }

        driver.quit();


    }
}
