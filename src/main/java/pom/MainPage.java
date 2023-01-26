package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {

    public final String howMuchExpectedAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public final String fewScooterExpectedAnswer = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

    // Переменные для вопросов
    public final String rentTimeExpectedAnswer = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public final String orderTodayExpectedAnswer = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public final String extendOrderExpectedAnswer = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public final String takeChargerExpectedAnswer = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public final String cancelOrderExpectedAnswer = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public final String liveMkadExpectedAnswer = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By questionsBlock = By.className("accordion");

    // Переменные для актуальных ответов:
    private final By howMuch = By.xpath("//div[contains (text(),'Сколько это стоит? И как оплатить?')]");
    private final By fewScooter = By.xpath("//div[contains (text(),'Хочу сразу несколько самокатов! Так можно?')]");
    private final By rentTime = By.xpath("//div[contains (text(),'Как рассчитывается время аренды?')]");
    private final By orderToday = By.xpath("//div[contains (text(),'Можно ли заказать самокат прямо на сегодня?')]");
    private final By extendOrder = By.xpath("//div[contains (text(),'Можно ли продлить заказ или вернуть самокат раньше?')]");
    private final By takeCharger = By.xpath("//div[contains (text(),'Вы привозите зарядку вместе с самокатом?')]");
    private final By cancelOrder = By.xpath("//div[contains (text(),'Можно ли отменить заказ?')]");
    private final By liveMkad = By.xpath("//div[contains (text(),'Я жизу за МКАДом, привезёте?')]");

    // Переменные для ожидаемых ответов
    private final By howMuchAnswer = By.xpath(".//div[@id='accordion__panel-0']/p");
    private final By fewScooterAnswer = By.xpath(".//div[@id='accordion__panel-1']");
    private final By rentTimeAnswer = By.xpath(".//div[@id='accordion__panel-2']");
    private final By orderTodayAnswer = By.xpath(".//div[@id='accordion__panel-3']");
    private final By extendOrderAnswer = By.xpath(".//div[@id='accordion__panel-4']");
    private final By takeChargerAnswer = By.xpath(".//div[@id='accordion__panel-5']");
    private final By cancelOrderAnswer = By.xpath(".//div[@id='accordion__panel-6']");
    private final By liveMkadAnswer = By.xpath(".//div[@id='accordion__panel-7']");
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод открытия страницы и прокрутки до блока с вопросами
    public MainPage open() {
        driver.get(url);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionsBlock));
        return this;
    }

    //Методы клика на вопрос и получения текста ответа
    public String howMuchClick() {
        driver.findElement(howMuch).click();
        String howMuchClickActual = driver.findElement(howMuchAnswer).getText();
        return howMuchClickActual;
    }

    public String fewScooterClick() {
        driver.findElement(fewScooter).click();
        String fewScooterActual = driver.findElement(fewScooterAnswer).getText();
        return fewScooterActual;
    }

    public String rentTimeClick() {
        driver.findElement(rentTime).click();
        String rentTimeActual = driver.findElement(rentTimeAnswer).getText();
        return rentTimeActual;
    }

    public String orderTodayClick() {
        driver.findElement(orderToday).click();
        String orderTodayActual = driver.findElement(orderTodayAnswer).getText();
        return orderTodayActual;
    }

    public String extendOrderClick() {
        driver.findElement(extendOrder).click();
        String extendOrderActual = driver.findElement(extendOrderAnswer).getText();
        return extendOrderActual;
    }

    public String takeChargerClick() {
        driver.findElement(takeCharger).click();
        String takeChargerActual = driver.findElement(takeChargerAnswer).getText();
        return takeChargerActual;
    }

    public String cancelOrderClick() {
        driver.findElement(cancelOrder).click();
        String cancelOrderActual = driver.findElement(cancelOrderAnswer).getText();
        return cancelOrderActual;
    }

    public String liveMkadClick() {
        driver.findElement(liveMkad).click();
        String liveMkadActual = driver.findElement(liveMkadAnswer).getText();
        return liveMkadActual;
    }

}
