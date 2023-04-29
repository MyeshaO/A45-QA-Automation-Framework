import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static ChromeOptions optionC;
    static WebDriverWait wait;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    static void setupBrowser(String baseURL) {
        optionC = new ChromeOptions();
        optionC.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
        driver = new ChromeDriver(optionC);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().minimize();
        driver.get(baseURL);
    }

    @AfterMethod
    public static void tearDownBrowser() {
        driver.quit();
    }

    public void logIn(String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
    }

    public void choosePlaylist() {
        WebElement playlistToDelete = driver.findElement(By.cssSelector("[href = '#!/playlist/54189']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href = '#!/playlist/54189']"))).click();
        //playlistToDelete.click();
    }

    public void deleteButton() {
        WebElement deletePlaylist = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.del.btn-delete-playlist"))).click();
        // deletePlaylist.click();
    }

  //  public String confirmDelete() {
      //  WebElement deleteConfirmation = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
     //   return deleteConfirmation.getText();
   // }
}
