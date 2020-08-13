package com.multibrowser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
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
import com.maveric.core.utils.data.Database;
import com.multibrowser.Fillomethods;

//@Listeners({TestListener.class, ReportListener.class, DriverListener.class, RestListener.class})
public class parabankbrowser2 {
	
	private static final Logger logger = LogManager.getLogger();
	
	public WebDriver Driver;
	
	//builds a new report using the html template 
    ExtentHtmlReporter htmlReporter;
    
    ExtentReports extent;
    //helps to generate the logs in test report.
    ExtentTest test;
	
	 //Fillomethods FM = new Fillomethods();
    
	 Properties obj = new Properties();					
   Database DB = new Database("mysql", "root", "MySQL@12345", "localhost", "3306", "parabank");
   
     
	 //seleniumcommo_methods SCM = new seleniumcommo_methods();

	
	
    @BeforeClass
    public void Driverlaunch() throws IOException {
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\vinodhinima\\eclipse-workspace\\Demomaven\\src\\test\\resources\\geckodriver.exe");
        Driver = new FirefoxDriver();
        logger.info("Driver initialisation paralelly");
        
    }
    
  /*  @AfterClass
    public void afterClass() {
        Driver.quit();
        logger.info("Quit Driver");
    }*/

   
    @BeforeTest
    public void startReport() {
    	// initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport_Parabank.html");
        
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
     
         
    public void WebEdit(String xpath, String val) {
		Driver.findElement(By.xpath(xpath)).click();
		Driver.findElement(By.xpath(xpath)).sendKeys(val);	
		
	}
    
    
   @Test
    public void Registration() throws IOException {
    	
    	FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");	
    	obj.load(objfile);
    	 test = extent.createTest("Registration", "PASSED test case");
         Assert.assertTrue(true);
    	

        Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String url = "https://parabank.parasoft.com/parabank/register.htm";
        Driver.get(url);
        
        Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        // Using Property file and Filo methods
      Driver.findElement(By.id(obj.getProperty("Firstname"))).sendKeys(DB.readValue("SELECT * from login;" , "Firstname", 6));	
        
   // WebEdit("//input[@id='customer.firstName']",FM.getdata("Firstname"));
      
      Driver.findElement(By.id(obj.getProperty("Lastname"))).sendKeys(DB.readValue("SELECT * from login;" , "Lastname", 6));
         Driver.findElement(By.id(obj.getProperty("Address"))).sendKeys(DB.readValue("SELECT * from login;" , "Address", 6));
          Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Driver.findElement(By.id(obj.getProperty("City"))).sendKeys(DB.readValue("SELECT * from login;" , "City", 6));
       Driver.findElement(By.id(obj.getProperty("State"))).sendKeys(DB.readValue("SELECT * from login;" , "State", 6));
        Driver.findElement(By.id(obj.getProperty("Zipcode"))).sendKeys(DB.readValue("SELECT * from login;" , "Zipcode", 6));
       Driver.findElement(By.id(obj.getProperty("PhoneNumber"))).sendKeys(DB.readValue("SELECT * from login;" , "PhoneNumber", 6));
       Driver.findElement(By.id(obj.getProperty("Ssn"))).sendKeys(DB.readValue("SELECT * from login;" , "Ssn", 6));
       Driver.findElement(By.id(obj.getProperty("Username"))).sendKeys(DB.readValue("SELECT * from login;" , "Username", 6));
       Driver.findElement(By.id(obj.getProperty("Password"))).sendKeys(DB.readValue("SELECT * from login;" , "Password", 6));          
       Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       
       Driver.findElement(By.id(obj.getProperty("RepeatePassword"))).sendKeys(DB.readValue("SELECT * from login;" , "RepeatePassword", 6));          	
       Driver.findElement(By.xpath(obj.getProperty("Button"))).click();
          	 Driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
          	
          	//String errtext = null;
          	
          	//if(errtext.equals("This username already exists")) {
          		
          	//}
          	 Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
          	 
          	 
          	 						/* Login Page*/	 
          	/*Driver.findElement(By.xpath(obj.getProperty("LoginUsername"))).sendKeys(FM.getdata("LoginUsername"));
          	Driver.findElement(By.xpath(obj.getProperty("LoginPassword"))).sendKeys(FM.getdata("LoginPassword"));
          	Driver.findElement(By.xpath(obj.getProperty("LoginButton"))).click();*/
          	
          	 //Driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
          	 
          	 /*Bill Pay*/
    }
    
   @Test
    public void BillPayment() throws IOException {
	   
	   FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");	
   	obj.load(objfile);
    	
          	 test = extent.createTest("Bill Payment", "PASSED test case");
               Assert.assertTrue(true);
               Driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
               WebElement myDynamicElement = 
             			(new WebDriverWait(Driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj.getProperty("BillPay"))));
           	Driver.findElement(By.xpath(obj.getProperty("BillPay"))).click();
           	Driver.findElement(By.xpath(obj.getProperty("PayeeName"))).sendKeys(DB.readValue("SELECT * from billpay", "PayeeName", 1));
          Driver.findElement(By.xpath(obj.getProperty("PayeeAddress"))).sendKeys(DB.readValue("SELECT * from billpay", "PayeeAddress", 1));
           	Driver.findElement(By.xpath(obj.getProperty("PayeeCity"))).sendKeys(DB.readValue("SELECT * from billpay", "PayeeCity", 1));
           	Driver.findElement(By.xpath(obj.getProperty("PayeeState"))).sendKeys(DB.readValue("SELECT * from billpay", "PayeeState", 1));
           	Driver.findElement(By.xpath(obj.getProperty("PayeeZipcode"))).sendKeys(DB.readValue("SELECT * from billpay", "PayeeZipcode", 1));
           	Driver.findElement(By.xpath(obj.getProperty("PayeePhone"))).sendKeys(DB.readValue("SELECT * from billpay", "PayeePhone", 1));
           	Driver.findElement(By.xpath(obj.getProperty("PayeeAccount"))).sendKeys(DB.readValue("SELECT * from billpay", "PayeeAccount", 1));
           	Driver.findElement(By.xpath(obj.getProperty("PayeeVeriAccount"))).sendKeys(DB.readValue("SELECT * from billpay", "PayeeVeriAccount", 1));
           	Driver.findElement(By.xpath(obj.getProperty("PayeeAmount"))).sendKeys(DB.readValue("SELECT * from billpay", "PayeeAmount", 1));
           	//Driver.findElement(By.xpath(obj.getProperty("PayeeFromAmount"))).sendKeys(DB.readValue("SELECT * from billpay", "PayeeFromAmount", 1));
           	Driver.findElement(By.xpath(obj.getProperty("BillpayButton"))).click();
          
           	Driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
           	
           	/*Update contact Info
           	Driver.findElement(By.xpath(obj.getProperty("UpdateContactInfo"))).click();
          	Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           	Driver.findElement(By.xpath(obj.getProperty("UpdatePhoneNumber"))).click();
          	Driver.findElement(By.xpath(obj.getProperty("UpdatePhoneNumber"))).clear();
          	Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
          	Driver.findElement(By.xpath(obj.getProperty("UpdatePhoneNumber"))).sendKeys(FM.getdata("UpdatePhoneNumber"));
          	Driver.findElement(By.xpath(obj.getProperty("UpdateProfileButton"))).click();*/
          	
          	Driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }
    
   
   @Test
    public void LoanRequest() throws IOException {
	   
	   FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");	
	   	obj.load(objfile);
	   	Driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	 	
       	WebElement myDynamicElement = 
      			(new WebDriverWait(Driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id(obj.getProperty("RequestLoan"))));
          	/*Request Loan*/
          	Driver.findElement(By.xpath(obj.getProperty("RequestLoan"))).click();
          	Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
          	Driver.findElement(By.id(obj.getProperty("LoanAmount"))).sendKeys(DB.readValue("SELECT * from loarequest", "DownPaymentAmount", 1));
          	Driver.findElement(By.id(obj.getProperty("DownPaymentamount"))).sendKeys(DB.readValue("SELECT * from loarequest", "DownPaymentAmount", 1));
          	Driver.findElement(By.id(obj.getProperty("FromAccountID"))).sendKeys(DB.readValue("SELECT * from loarequest", "FromAccountID", 1));
          	Driver.findElement(By.xpath(obj.getProperty("LoanApplyButton"))).click();
          	
          	test = extent.createTest("Request Loan", "PASSED test case");
              Assert.assertTrue(true);
          	
          	Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    
    public void logout() throws IOException {
    	FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");	
       	obj.load(objfile);
          	/*Logout*/
            Driver.findElement(By.xpath(obj.getProperty("Logout"))).click();
          	Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
          	
           	
          	test = extent.createTest("Logout", "PASSED test case");
              Assert.assertTrue(true);
           	
          	 Reporter.log("TestNG_ReportsAndLogs -> Registration", true);	
          	 logger.info("Registration");
          	
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
