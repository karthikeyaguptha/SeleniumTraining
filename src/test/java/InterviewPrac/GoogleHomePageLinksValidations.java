package InterviewPrac;

import org.apache.groovy.json.internal.Chr;
import org.apache.http.HttpConnection;
import org.apache.http.HttpServerConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class GoogleHomePageLinksValidations {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUp() {
        String URL = "https://google.com";
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void collectAllLinksGHomePage() {
        List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));
        System.out.println("Total Links: " + links.size());
        for (WebElement link : links) {
            String linkText = link.getText();
            if (!linkText.isEmpty()) {
                System.out.println(linkText + " : " + link.getAttribute("href"));
            } else System.out.println("Not able to get the Text of this link:" + link.getAttribute("href"));

        }
    }

    @Test
    public void validateAllLinkGHomePage() {
        List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));
        System.out.println("Total Links: " + links.size());
        for (WebElement link : links) {
            try {
                // 3. Establish a fast connection to test status
                URL url = new URL(link.getAttribute("href"));
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                // Optimization: Use "HEAD" request instead of "GET" to fetch metadata without downloading full body content
                connection.setRequestMethod("HEAD");
                connection.setConnectTimeout(3000);
                connection.connect();

                int responseCode = connection.getResponseCode();
                // 4. Classify based on the HTTP status code
                if (responseCode >= 400) {
                    System.err.println("Broken Link : " + url + " [Status Code:" + responseCode + "]");
                } else {
                    System.out.println("VALID LINK: " + url + " [Status Code: " + responseCode + "]");
                }

                connection.disconnect();

            } catch (Exception e) {
                System.err.println("INVALID/UNREACHABLE URL: " + link.getText() + " -> " + e.getMessage());
            }

        }
    }


}
