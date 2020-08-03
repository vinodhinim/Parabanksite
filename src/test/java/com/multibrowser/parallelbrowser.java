package com.multibrowser;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class parallelbrowser {
	
	
    private WebDriver driver;
    
  //builds a new report using the html template 
    ExtentHtmlReporter htmlReporter;
    
    ExtentReports extent;
    //helps to generate the logs in test report.
    ExtentTest test;

    @BeforeClass
    public void beforeClass() {
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\vinodhinima\\eclipse-workspace\\Demomaven\\src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

   @AfterClass
    public void afterClass() {
        driver.quit();
    }

   @BeforeTest
   public void startReport() {
   	// initialize the HtmlReporter
       htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
       
       //initialize ExtentReports and attach the HtmlReporter
       extent = new ExtentReports();
       extent.attachReporter(htmlReporter);
     //To add system or environment info by using the setSystemInfo method.
      // extent.setSystemInfo("OS", OS);
       //extent.setSystemInfo("Browser", browser);
       
       //configuration items to change the look and feel
       //add content, manage tests etc
       htmlReporter.config().setChartVisibilityOnOpen(true);
       htmlReporter.config().setDocumentTitle("Extent Report Demo");
       htmlReporter.config().setReportName("Test Report");
       htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
       htmlReporter.config().setTheme(Theme.STANDARD);
       htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
   }
    @Test
    public void verifySearchButton() {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String url = "http://www.google.com";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String search_text = "Google Search";
        WebElement search_button = driver.findElement(By.name("btnK"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String text = search_button.getAttribute("value");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertEquals(text, search_text, "Text not found!");
        test = extent.createTest("Parallel browser 1 execution", "PASSED test case");
        Assert.assertTrue(true);
    }
    
    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
     
    @AfterTest
    public void tearDown() {
    	//to write or update test information to reporter
        extent.flush();
    }
    
    
    
}
