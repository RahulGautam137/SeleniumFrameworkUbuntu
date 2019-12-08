package seleniumub.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import seleniumub.utility.BrowserHelper;
import seleniumub.utility.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Properties;

public class BasePage {

        public WebDriver driver;
        public BrowserHelper browserHelper;
        public Utility util;
        public ExtentReports extentReports;
        Properties configProperties;
        Properties webElementProperties;
        FileInputStream fis;

        public BasePage(){
                try {

                        LocalDateTime ldt = LocalDateTime.now();
                        String ldtString = ldt.toString();
                        ldtString = ldtString.replace('-', '_').replace(':', '_');
                        extentReports=new ExtentReports();
                        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//src//main//resources//Reports//" + "AventReport" + ldtString + ".html");
                        extentReports.attachReporter(htmlReporter);
                        ExtentTest testLogger=extentReports.createTest("Initialize of All Objects");

                        browserHelper = new BrowserHelper();
                        util = new Utility();

                        fis = new FileInputStream(new File(System.getProperty("user.dir") + "//src//main//resources//config.properties"));
                        configProperties=new Properties();
                        configProperties.load(fis);

                        fis = new FileInputStream(new File(System.getProperty("user.dir") + "//src//main//resources//config.properties"));
                        webElementProperties = new Properties();
                        webElementProperties.load(fis);




                }catch (IOException ioExp){
                        ioExp.printStackTrace();

                }
        }

        @AfterTest
        public void reportFlush(){

                extentReports.flush();
        }
/*
        public static void main(String []args){
                LocalDateTime ldt=LocalDateTime.now();
                String ldtString=ldt.toString();

                System.out.println(ldtString);
        }


*/







}
