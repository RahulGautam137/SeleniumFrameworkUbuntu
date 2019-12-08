package seleniumub.utility;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility {

    public void closeBrowser(ExtentTest testLogger, WebDriver driver){
        try {
            testLogger.info("Closing browser");
            driver.quit();

        }catch (WebDriverException wbExp){
            testLogger.fail("Exception is  "+wbExp.getMessage()+"Exception cause is "+wbExp.getStackTrace());
            wbExp.printStackTrace();
        }catch (Exception e){
            testLogger.fail(String.valueOf(e.getStackTrace()));
            e.printStackTrace();
        }
    }
}
