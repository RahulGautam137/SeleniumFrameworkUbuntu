package seleniumub.base;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

public class BaseTest extends BasePage {


    public BaseTest(){



    }



    @Test
    public void firstTesCase(){
        ExtentTest testLogger=extentReports.createTest("First test Case");
        try {

            driver = browserHelper.startBrowser(testLogger, configProperties.getProperty("browser"));
            testLogger.info("Browser is "+configProperties.getProperty("browser"));
            driver.get(configProperties.getProperty("defaulturl"));
            Thread.sleep(5000);
            util.closeBrowser(testLogger,driver);
            //"hello"
        }catch (InterruptedException ie){
            ie.printStackTrace();

        }


    }

}
