import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;
public class BaseTest {
    public static WebDriver driver = null;
    public static ChromeOptions optionC;
    @BeforeSuite
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
@BeforeMethod
       static void browserOptions(){

         optionC = new ChromeOptions();
           optionC.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");}
    @BeforeMethod
    static void setupBrowser(){
        driver = new ChromeDriver(optionC);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public static void tearDownBrowser(){
        driver.quit();
    }
     protected static void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }
    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(20000);
    }

    public static void searchSong(String songTitle) throws InterruptedException {
        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
        searchBar.sendKeys(songTitle);
        Thread.sleep(20000);
    }

    public static void clickViewAll() throws InterruptedException {
        WebElement searchResults = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        searchResults.click();
        Thread.sleep(2000);
    }
    public static void selectSong() throws InterruptedException {
        WebElement chooseSong = driver.findElement(By.cssSelector("section#songResultsWrapper div.item-container tr.song-item td.title"));
        chooseSong.click();
        Thread.sleep(2000);
    }
    public static void clickAddTo() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(2000);
    }

    public static void choosePlaylist() throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        playlist.click();
    }
    }