package seleniumub.utility;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

public class BrowserHelper {

    WebDriver driver;

    public WebDriver startBrowser(ExtentTest testLogger,String browserName){

        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//resources//chromedriver");
            ChromeOptions options=new ChromeOptions();
            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
            driver=new ChromeDriver();
        }

        if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//main//resources//geckodriver");

            driver=new FirefoxDriver();
        }

        return driver;

    }

}
