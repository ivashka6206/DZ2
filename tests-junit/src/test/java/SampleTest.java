import config.ServerConfig;
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
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);



@Before
public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    logger.info("Драйвер поднят");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

        @Test
        public void yandex() {
            driver.get("https://yandex.ru");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            String actualTitle = driver.getTitle();
            String expectedTitle = "Яндекс";
            assertEquals(expectedTitle,actualTitle);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            logger.info("Открыта страница яндекс");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }


        @Test
        public void Tele () {
            driver.get("https://msk.tele2.ru/shop/number");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            logger.info("Открыта страница теле2");
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.name("searchNumber")));
                WebElement  searchNumber= driver.findElement(By.cssSelector("#searchNumber"));
        //    WebElement  searchNumber= driver.findElement(By.cssSelector("[name=searchNumber]"));
            searchNumber.click();
            searchNumber.sendKeys("97");
            logger.info("Поиск номеров на 97");

        }

        /*
     @Test
     public void openPage() {
            driver.get(cfg.url());
            logger.info("Открыта страница отус");
     }

        @Test
        public void Cookie(){
            driver.get("https://otus.ru/");
            driver.manage().addCookie(new Cookie("Otus1","Value1"));
            driver.manage().addCookie(new Cookie("Otus2","Value2"));
            Cookie cookie= new Cookie ("Otus3","Value3");
            driver.manage().addCookie(cookie);
            driver.manage().addCookie(new Cookie("Otus4","Value4"));

            logger.info(driver.manage().getCookies());
            logger.info(driver.manage().getCookieNamed("Otus1"));
            driver.manage().deleteCookieNamed("Otus2");
            driver.manage().deleteCookie(cookie);
            driver.manage().deleteAllCookies();
            logger.info(driver.manage().getCookies().size());
        }


        @Test
        public void G_A() {
            driver.get("https://otus.ru/");
            driver.manage().window().maximize();
        }

        @Test
        public void G_B() {
            driver.manage().window().setSize(new Dimension(800,600));
            driver.get("https://otus.ru/");
            logger.info(driver.manage().window().getPosition());
        }

        @Test
        public void G_C() {
            driver.manage().window().setSize(new Dimension(800,600));
            driver.get("https://otus.ru/");
            logger.info(driver.manage().window().getPosition());
            Point point =driver.manage().window().getPosition();
            point.x= point.x +200;
            point.y= point.y;
            driver.manage().window().setPosition(point);
            point.x= point.x;
            point.y= point.y+200;
            driver.manage().window().setPosition(point);
            point.x= point.x -200;
            point.y= point.y;
            driver.manage().window().setPosition(point);
            point.x= point.x ;
            point.y= point.y-200;
            driver.manage().window().setPosition(point);

        }
*/
@After
public void setDown(){
    if (driver !=null) {
        driver.quit();
    logger.info("Драйвер успешно закрыт");
    }}


}

