
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleTest {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SampleTest.class);

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }

    @Test
    public void yandex() {
        driver.get("https://yandex.ru");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Яндекс";
        assertEquals(expectedTitle,actualTitle);
        driver.manage().window().maximize();
        logger.info("Открыта страница яндекс");
    }


    @Test
    public void Tele () {
        driver.get("https://msk.tele2.ru/shop/number");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        logger.info("Открыта страница теле2");
        WebElement  searchNumber= driver.findElement(By.cssSelector("#searchNumber"));
        searchNumber.click();
        searchNumber.sendKeys("97");
        new WebDriverWait(driver, 500).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.catalog-numbers.with-overlay.overlay-big")));
        logger.info("Поиск номеров на 97");


    }

    @After
    public void setDown(){
        if (driver !=null) {
            driver.quit();
            logger.info("Драйвер успешно закрыт");
        }}

}
