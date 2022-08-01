package lib.ui;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPageObject {

    protected WebDriver driver;

    public MainPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public WebElement waitForElementPresent(By by, String error_message)
    {
        return waitForElementPresent(by, error_message, 5);
    }

    //пример как использовать List есть в классе AddLabelToTask
    public List<WebElement> waitForElementsPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return (List<WebElement>) wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(by)
        );
    }

    public List<WebElement> waitForElementsPresent(By by, String error_message)
    {
        return waitForElementsPresent(by, error_message, 5);
    }

    //как вариант по идеи рабочий метод для получение свойства(атрибута) элемента (в chrome это properties)
    public WebElement waitForElementPresentAndAttribute(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.getAttribute(value);
        return element;
    }

    public WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    //на заметку: кликать можно только если элемент интерактивный(то же самое с поиском по координатам), если не интерактивный элемент, то нужен метод ниже:
    public WebElement waitForElementAndClickOnScreenByNotInteractableElement(By by, String error_message, long timeoutInSeconds){
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        return element;
    }

    public void scrollOnThePage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        }

    public boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public boolean waitForElementNotPresent(By by, String error_message)
    {
        return waitForElementNotPresent(by, error_message, 5);
    }

    public WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    public int getAmountOfElements(By by)
    {
        List elements = driver.findElements(by);
        return elements.size();
    }

    public WebElement assertElementHasText(By by, String expected_text, String error_message){
        WebElement titleElement = waitForElementPresent(by, error_message);
        String article_title = titleElement.getText();
        Assert.assertEquals(
                error_message,
                expected_text,
                article_title
        );
        return titleElement;
    }

    public WebElement assertElementHasAttribute(By by, String value, String expected_value, String error_message){
        WebElement attributeOfElement = waitForElementPresent(by, error_message);
        String attributeElement = attributeOfElement.getAttribute(value);
        Assert.assertEquals(
                error_message,
                expected_value,
                attributeElement
        );
        return attributeOfElement;
    }
}