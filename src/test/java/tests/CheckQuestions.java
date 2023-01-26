package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class CheckQuestions {
    WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    public void howMuchClickCheck() {

        MainPage mainPage = new MainPage(driver);
        mainPage.howMuchClick();

        assertEquals("Ответ не совпадает", mainPage.howMuchExpectedAnswer, mainPage.howMuchClick());
    }

    @Test
    public void fewScooterClickCheck() {

        MainPage mainPage = new MainPage(driver);
        mainPage.fewScooterClick();

        assertEquals("Ответ не совпадает", mainPage.fewScooterExpectedAnswer, mainPage.fewScooterClick());
    }

    @Test
    public void rentTimeClickCheck() {

        MainPage mainPage = new MainPage(driver);
        mainPage.rentTimeClick();

        assertEquals("Ответ не совпадает", mainPage.rentTimeExpectedAnswer, mainPage.rentTimeClick());
    }

    @Test
    public void orderTodayClickCheck() {

        MainPage mainPage = new MainPage(driver);
        mainPage.orderTodayClick();

        assertEquals("Ответ не совпадает", mainPage.orderTodayExpectedAnswer, mainPage.orderTodayClick());
    }

    @Test
    public void extendOrderClickCheck() {

        MainPage mainPage = new MainPage(driver);
        mainPage.howMuchClick();

        assertEquals("Ответ не совпадает", mainPage.extendOrderExpectedAnswer, mainPage.extendOrderClick());
    }

    @Test
    public void takeChargerClickCheck() {

        MainPage mainPage = new MainPage(driver);
        mainPage.takeChargerClick();

        assertEquals("Ответ не совпадает", mainPage.takeChargerExpectedAnswer, mainPage.takeChargerClick());
    }

    @Test
    public void cancelOrderClickCheck() {

        MainPage mainPage = new MainPage(driver);
        mainPage.cancelOrderClick();

        assertEquals("Ответ не совпадает", mainPage.cancelOrderExpectedAnswer, mainPage.cancelOrderClick());
    }

    @Test
    public void liveMkadClickCheck() {

        MainPage mainPage = new MainPage(driver);
        mainPage.liveMkadClick();

        assertEquals("Ответ не совпадает", mainPage.liveMkadExpectedAnswer, mainPage.liveMkadClick());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
