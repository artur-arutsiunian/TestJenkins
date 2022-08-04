package lib;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CoreTestCase {

    protected WebDriver driver;
    protected ChromeOptions options;
    @Before
    @Step("Run driver and session")
    public void SetUp(){
        if (Objects.equals(System.getProperty("os.name"), "Mac OS X")){
            System.setProperty("webdriver.chrome.driver","src/main/resources/mac-chromedriver");
        } else
        {
            System.setProperty("webdriver.chrome.driver","src/main/resources/linux-chromedriver");
        }


        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);

        driver.get("https://testing7.zgdev.info/auth");
        driver.manage().window().maximize();
    }

    @After
    @Step("Remove driver and session")
    public void Close(){
        driver.quit();
    }}