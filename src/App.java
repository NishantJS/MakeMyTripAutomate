import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class App {
        public static void main(String[] args) throws InterruptedException {

                System.setProperty("webdriver.chrome.driver", "/home/nishant/code/selenium/chrome/chromedriver");
                ChromeOptions options = new ChromeOptions();
                String path = "/usr/bin/google-chrome-stable";
                options.setBinary(path);
                WebDriver driver = new ChromeDriver();
                String Link = "https://www.makemytrip.com/railways/";
                String Open = "input.react-autosuggest__input.react-autosuggest__input--open";
                String Focused = Open + ".react-autosuggest__input--focused";

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                driver.get(Link);

                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fromCity"))).click();
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Open))).click();
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Focused))).click();

                WebElement FromCity = driver.findElement(By.cssSelector(Focused));
                FromCity.sendKeys("Delhi");
                FromCity.sendKeys(Keys.DOWN, Keys.RETURN);

                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Open))).click();
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Focused))).click();

                WebElement ToCity = driver.findElement(By.cssSelector(Focused));
                ToCity.sendKeys("Lucknow");
                ToCity.sendKeys(Keys.DOWN, Keys.RETURN);

                Thread.sleep(2000);

                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("travelDate"))).click();
                JavascriptExecutor js = (JavascriptExecutor) driver;
                WebElement date = driver.findElement(By.cssSelector("div[aria-label='Sat Aug 20 2022']"));
                js.executeScript("arguments[0].click();", date);
        }

}