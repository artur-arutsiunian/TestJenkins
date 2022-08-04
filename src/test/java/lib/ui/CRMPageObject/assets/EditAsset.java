package lib.ui.CRMPageObject.assets;

import lib.ui.MainPageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EditAsset extends MainPageObject {

    private final static String
    MOVE_TO_CRM = "//span[text()='CRM']",
    CLICK_ON_ASSET_TAB = "//span[text()='Asset']",
    CLICK_ON_FIRST_ASSET_IN_THE_LIST = "//div[@class='scrollable-list_container__2NtNz']/div/div",
    CLICK_ON_EDIT_BUTTON = "(//span[@class='MuiIconButton-label'])[8]",
    CLEAR_INTERNAL_ADDRESS_FIELD = "//input[@placeholder='Internal address']",
    INPUT_INTERNAL_ADDRESS = "//input[@placeholder='Internal address']",
    CLICK_ON_SAVE_BUTTON = "//span[text()='Save']",
    ASSET_INTERNAL_ADDRESS_IS_CHANGED = "//input[@value='street']";

    public List<WebElement> waitForElementsAndClick(By by, String error_message, long timeoutInSeconds) {
        List<WebElement> elements = this.waitForElementsPresent(by, error_message, 5);
        elements.get(0).click();
        return elements;
    }

    public EditAsset(WebDriver driver)
    {
        super(driver);
    }

    public void editAssetMethod() throws InterruptedException {
        Thread.sleep(2000);
        this.waitForElementAndClick(
                By.xpath(MOVE_TO_CRM),
                "can't click on 'CRM'",
                5
        );
        Thread.sleep(2000);
        this.waitForElementAndClick(
                By.xpath(CLICK_ON_ASSET_TAB),
                "can't click on 'asset' tab",
                5
        );
        Thread.sleep(2000);
        this.waitForElementsAndClick(
                By.xpath(CLICK_ON_FIRST_ASSET_IN_THE_LIST),
                "can't click on first asset in the list",
                5
        );
        Thread.sleep(2000);
        this.waitForElementAndClick(
                By.xpath(CLICK_ON_EDIT_BUTTON),
                "can't click on edit button",
                5
        );
        Thread.sleep(2000);
        this.waitForElementAndClear(
                By.xpath(CLEAR_INTERNAL_ADDRESS_FIELD),
                "can't clear 'name' field",
                5
        );
        Thread.sleep(2000);
        this.waitForElementAndSendKeys(
                By.xpath(INPUT_INTERNAL_ADDRESS),
                "street",
                "can't input asset name",
                5
        );
        Thread.sleep(2000);
        this.waitForElementAndClick(
                By.xpath(CLICK_ON_SAVE_BUTTON),
                "can't click on 'save' button",
                5
        );
        Thread.sleep(2000);
        this.assertElementHasAttribute(
                By.xpath(ASSET_INTERNAL_ADDRESS_IS_CHANGED),
                "value",
                "street",
                "can't confirm that asset name is changed"
        );
    }
}
