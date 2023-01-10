package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainOrder {



    private final WebDriver driver;
    public MainOrder(WebDriver driver) {
        this.driver = driver;
    }

    //Переменная для url страницы

    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //Переменная для подтверждения куки

    public final By cookieApprove = By.xpath("//button[@class='App_CookieButton__3cvqF']");

    // Переменная для клика по кнопке заказать .//form[@name='edit-avatar']/button ВАЖНО! Сделать скролл к нижней кнопке в методе
    public final By orderScooterUp = By.xpath("//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    public final By orderScooterDown = By.className("Button_Middle__1CSJM");

    // Переменные полей на 1 шаге "Для кого самокат"

    public final By orderName = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Имя']");
    public final By orderFamily = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Фамилия']");
    public final By orderAddress = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Адрес: куда привезти заказ']");
    public final By orderStation = By.xpath("//div[@class='select-search__value']/input[@placeholder='* Станция метро']");
    public final By orderPhone = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Телефон: на него позвонит курьер']");

    // Переменные для станций метро на шаге "Для кого самокат"

    public final By stationRokossovskogo = By.xpath("//button[@class='Order_SelectOption__82bhS select-search__option' and @value = '1']");
    public final By stationCherkizovskaya = By.xpath("//button[@class='Order_SelectOption__82bhS select-search__option' and @value = '2']");

    // Переменная для копки Далее на 1 шаге "Для кого самокат"

    public final By nextButton = By.xpath("//div[@class='Order_NextButton__1_rCA']/button[text() = 'Далее']");

    // Переменные полей на 2 шаге "Про аренду"
    // Переменная поля "Когда привезти самокат" до нажатия

    public final By whenBringScooterField = By.xpath("//div[@class='react-datepicker__input-container']/input[@placeholder='* Когда привезти самокат']");

    // Переменные поля "Когда привезти самокат" с датой

    public final By whenBringScooterDate3001 = By.xpath("//div[@class='react-datepicker__week']/div[@aria-label='Choose понедельник, 30-е января 2023 г.']");
    public final By whenBringScooterDate3101 = By.xpath("//div[@class='react-datepicker__week']/div[@aria-label='Choose вторник, 31-е января 2023 г.']");

    // Переменная поля "Срок аренды" до нажатия

    public final By rentalPeriodField = By.xpath("//div[@class='Dropdown-root']");

    // Переменные поля "Срок аренды" с выбором срока

    public final By rentalPeriodOneDay = By.xpath("//div[@class='Dropdown-menu']/div[text() = 'сутки']");
    public final By rentalPeriodTwoDay = By.xpath("//div[@class='Dropdown-menu']/div[text() = 'двое суток']");

    // Переменные поля "Цвет самоката"

    public final By blackScooterColor = By.xpath("//label[@for='black']/input[@id='black']");
    public final By greyScooterColor = By.xpath("//label[@for='grey']/input[@id='grey']");


    // Переменные поля "Комментарий для курьера"

    public final By commentForCourier = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@placeholder='Комментарий для курьера']");

    // Переменная для кнопки Заказать на шаге "Про аренду"

    public final By finalOrderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Переменная для кнопки подтверждения заказа

    public final By orderConfirmationButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text() = 'Да']");

    // Переменная для поп-апа с информацией о создании заказа

    public final By orderPopUp = By.xpath("//div[@class='Order_Modal__YZ-d3']/");

    //Метод открытия страницы
    public void open() {
        driver.get(url);
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionsBlock));
    }

    //Метод для клика на куки

    public void clickCookie() {
        driver.findElement(cookieApprove).click();
    }

    //Метод для клика на кнопку заказать вверху

    public void clickOderScooterUp() {
        driver.findElement(orderScooterUp).click();
    }

    //Метод для клика на кнопку заказать снизу

    public void clickOderScooterDown() {
        driver.findElement(orderScooterDown).click();
    }

    //Метод для ввода имени

    public void setName(String name) {
        driver.findElement(orderName).sendKeys(name);
    }

    //Метод для ввода фамилии

    public void setFamily(String family) {
        driver.findElement(orderFamily).sendKeys(family);

    }

    //Метод для ввода адреса
    public void setAddress(String address) {
        driver.findElement(orderAddress).sendKeys(address);

    }

    //Метод для выбора станции Черкизовская
    public void setCherkizovskayaUp() {
        driver.findElement(orderStation).click();
        driver.findElement(stationCherkizovskaya).click();

    }

    //Метод для выбора станции Рокосовского
    public void setRokossovskogoDown() {
        driver.findElement(orderStation).click();
        driver.findElement(stationRokossovskogo).click();

    }

    //Метод для ввода телефона
    public void setPhone(String phone) {
        driver.findElement(orderPhone).sendKeys(phone);
    }

    //Метод для клика на кнопку Далее после первого шага
    public void clickNextFirstStep() {
        driver.findElement(nextButton).click();
    }

    //Конструктор 1 шага создания заказа для кнопки сверху
    public void firstStepOrderUp(String name, String family, String address,String phone){
        clickOderScooterUp();
        setName(name);
        setFamily(family);
        setAddress(address);
        setCherkizovskayaUp();
        setPhone(phone);
        clickNextFirstStep();
        }

    //Конструктор 1 шага создания заказа для кнопки снизу
    public void firstStepOrderDown(String name, String family, String address,String phone){
        clickOderScooterDown();
        setName(name);
        setFamily(family);
        setAddress(address);
        setRokossovskogoDown();
        setPhone(phone);
        clickNextFirstStep();
    }

    //Метод для выбора даты доставки самоката, кнопка заказать вверху
    public void setDateDeliveryUp() {
        driver.findElement(whenBringScooterField).click();
        driver.findElement(whenBringScooterDate3001).click();

    }

    //Метод для выбора даты доставки самоката, кнопка заказать внизу
    public void setDateDeliveryDown() {
        driver.findElement(whenBringScooterField).click();
        driver.findElement(whenBringScooterDate3101).click();

    }

    //Метод для выбора срока аренды, кнопка заказать вверху
    public void setRentalPeriodUp() {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(rentalPeriodOneDay).click();
    }

    //Метод для выбора срока аренды, кнопка заказать внизу
    public void setRentalPeriodDown() {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(rentalPeriodTwoDay).click();
    }

    //Метод для выбора цвета самоката, кнопка заказать вверху
    public void chooseColourUp() {
        driver.findElement(blackScooterColor).click();
    }

    //Метод для выбора цвета самоката, кнопка заказать снизу
    public void chooseColourDown() {
        driver.findElement(greyScooterColor).click();
    }

    //Метод для добавления коментария курьеру

    public void setComment(String comment) {
        driver.findElement(commentForCourier).sendKeys(comment);
    }

    //Метод для клика на кнопку Далее после второго шага
    public void clickNextSecondStep() {
        driver.findElement(finalOrderButton).click();
    }

    //Конструктор 2 шага создания заказа для кнопки сверху
    public void secondStepOrderUp(String comment){
        setDateDeliveryUp();
        setRentalPeriodUp();
        chooseColourUp();
        setComment(comment);
        clickNextSecondStep();
    }

    //Конструктор 2 шага создания заказа для кнопки снизу
    public void secondStepOrderDown(String comment){
        setDateDeliveryDown();
        setRentalPeriodDown();
        chooseColourDown();
        setComment(comment);
        clickNextSecondStep();
    }
    //Метод для подтверждения заказа

    public void approveOrder() {
        driver.findElement(orderConfirmationButton).click();
    }

}
