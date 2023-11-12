package mk.ukim.finki.labs.dizajn.dizajn_i_arhitektura_na_softver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

@Component
public class scrapingProba {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the website
            driver.get("https://www.openstreetmap.org/search?query=museums%20macedonia#map=19/42.00402/21.43290");

            // Simulate clicking the "Load More" button
            while (true) {
                try {
                    WebElement loadMoreButton = driver.findElement(By.cssSelector(".btn-primary"));
                    loadMoreButton.click();
                    // Add a delay to allow the new content to load (adjust as needed)
                    Thread.sleep(2000);
                } catch (Exception e) {
                    // Break the loop if the button is not found (no more content to load)
                    break;
                }
            }

            // Now, you can use Jsoup or Selenium to parse the entire page content

            // Example with Jsoup
            String pageSource = driver.getPageSource();
            Document document = Jsoup.parse(pageSource);

            // Continue with your scraping logic using Jsoup
            System.out.println("blabla"+document);

        } catch (Exception e) {
            System.out.println("ne uspea");
            e.printStackTrace();
        } finally {
            // Close the browser window
            driver.quit();
        }
    }
}

