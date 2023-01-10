package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.MainOrder;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SamokatOrder {

    WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainOrder mainOrder = new MainOrder(driver);
        mainOrder.open();
        mainOrder.clickCookie();
    }
    //Тест при старте с верхней кнопки "Заказать"
    @Test
    public void orderScooterCheckUp() {
        MainOrder mainOrder = new MainOrder(driver);
        mainOrder.firstStepOrderUp("Оля", "Стогова", "Омск, Мира 80","89334440909");
        mainOrder.secondStepOrderUp("Коммент для курьера");
        mainOrder.approveOrder();
        Assert.assertTrue("Нет подтверждения о заказе",driver.findElement(mainOrder.orderPopUp).isDisplayed());
    }

    //Тест при старте с нижней кнопки "Заказать"
    @Test
    public void orderScooterCheckDown() {
        MainOrder mainOrder = new MainOrder(driver);
        mainOrder.firstStepOrderDown("Иван", "Иванов", "Санкт-Петербург","+79334440900");
        mainOrder.secondStepOrderDown("Длинный комментарий для курьера, чтобы можно было почитать");
        mainOrder.approveOrder();
        Assert.assertTrue("Нет подтверждения о заказе",driver.findElement(mainOrder.orderPopUp).isDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
