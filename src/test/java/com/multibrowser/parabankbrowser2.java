package com.multibrowser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SendKeysAction;
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

public class parabankbrowser2 {
	
	public WebDriver Driver;
	
	//builds a new report using the html template 
    ExtentHtmlReporter htmlReporter;
    
    ExtentReports extent;
    //helps to generate the logs in test report.
    ExtentTest test;
	
	 Fillomethods FM = new Fillomethods();
	 Properties obj = new Properties();					
   
     
	 //seleniumcommo_methods SCM = new seleniumcommo_methods();

	
	
    @BeforeClass
    public void beforeClass() throws IOException {
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\vinodhinima\\eclipse-workspace\\Demomaven\\src\\test\\resources\\geckodriver.exe");
        Driver = new FirefoxDriver();
        
        
    }
    
    @AfterClass
    public void afterClass() {
        Driver.quit();
    }

   
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
    public void registration() throws IOException {
    	
    	FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");	
    	obj.load(objfile);
    	 test = extent.createTest("Registration", "PASSED test case");
         Assert.assertTrue(true);
    	

        Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String url = FM.getdata("URL");
        Driver.get(url);
        
        Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        // Using Property file and Filo methods
      Driver.findElement(By.id(obj.getProperty("Firstname"))).sendKeys(FM.getdata("Firstname"));	
        
       // WebEdit("//input[@id='customer.firstName']",FM.getdata("Firstname"));
        
     WebEdit("//input[@id='customer.lastName']",FM.getdata("Lastname"));
        WebEdit("//input[@id='customer.address.street']",FM.getdata("Address"));
        Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       WebEdit("//input[@id='customer.address.city']",FM.getdata("City"));
       WebEdit("//input[@id='customer.address.state']",FM.getdata("State"));
       WebEdit("//input[@id='customer.address.zipCode']",FM.getdata("Zipcode"));
       WebEdit("//input[@id='customer.phoneNumber']",FM.getdata("PhoneNumber"));
        WebEdit("//input[@id='customer.ssn']",FM.getdata("Ssn"));
        WebEdit("//input[@id='customer.username']",FM.getdata("Username"));
        WebEdit("//input[@id='customer.password']",FM.getdata("Password"));
        Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebEdit("//input[@id='repeatedPassword']",FM.getdata("RepeatePassword"));
        	Driver.findElement(By.xpath(obj.getProperty("Button"))).click();
        	 Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	//String errtext = null;
        	
        	//if(errtext.equals("This username already exists")) {
        		
        	//}
        	 Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	 
        	 
        	 						/* Login Page*/	 
        	/*Driver.findElement(By.xpath(obj.getProperty("LoginUsername"))).sendKeys(FM.getdata("LoginUsername"));
        	Driver.findElement(By.xpath(obj.getProperty("LoginPassword"))).sendKeys(FM.getdata("LoginPassword"));
        	Driver.findElement(By.xpath(obj.getProperty("LoginButton"))).click();*/
        	
        	 Driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        	 
        	 /*Bill Pay*/
        	 
        	 test = extent.createTest("Bill Payment", "PASSED test case");
             Assert.assertTrue(true);
             
         	Driver.findElement(By.xpath(obj.getProperty("BillPay"))).click();
         	Driver.findElement(By.xpath(obj.getProperty("PayeeName"))).sendKeys(FM.getdata("PayeeName"));
         	Driver.findElement(By.xpath(obj.getProperty("PayeeAddress"))).sendKeys(FM.getdata("PayeeAddress"));
         	Driver.findElement(By.xpath(obj.getProperty("PayeeCity"))).sendKeys(FM.getdata("PayeeCity"));
         	Driver.findElement(By.xpath(obj.getProperty("PayeeState"))).sendKeys(FM.getdata("PayeeState"));
         	Driver.findElement(By.xpath(obj.getProperty("PayeeZipcode"))).sendKeys(FM.getdata("PayeeZipcode"));
         	Driver.findElement(By.xpath(obj.getProperty("PayeePhone"))).sendKeys(FM.getdata("PayeePhone"));
         	Driver.findElement(By.xpath(obj.getProperty("PayeeAccount"))).sendKeys(FM.getdata("PayeeAccount"));
         	Driver.findElement(By.xpath(obj.getProperty("PayeeVeriAccount"))).sendKeys(FM.getdata("PayeeVeriAccount"));
         	Driver.findElement(By.xpath(obj.getProperty("PayeeAmount"))).sendKeys(FM.getdata("PayeeAmount"));
         	//Driver.findElement(By.xpath(obj.getProperty("PayeeFromAccount"))).sendKeys(FM.getdata("PayeeFromAccount"));"
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
        	
        	/*Request Loan*/
        	Driver.findElement(By.xpath(obj.getProperty("RequestLoan"))).click();
        	Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	Driver.findElement(By.id(obj.getProperty("LoanAmount"))).sendKeys(FM.getdata("LoanAmount"));
        	Driver.findElement(By.id(obj.getProperty("DownPaymentamount"))).sendKeys(FM.getdata("DownPaymentamount"));
        	Driver.findElement(By.id(obj.getProperty("FromAccountID"))).sendKeys(FM.getdata("FromAccountID"));
        	Driver.findElement(By.xpath(obj.getProperty("LoanApplyButton"))).click();
        	
        	test = extent.createTest("Request Loan", "PASSED test case");
            Assert.assertTrue(true);
        	
        	Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	/*Logout*/
           	Driver.findElement(By.xpath(obj.getProperty("Logout"))).click();
        	Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	
         	
        	test = extent.createTest("Logout", "PASSED test case");
            Assert.assertTrue(true);
         	
        	 Reporter.log("TestNG_ReportsAndLogs -> Registration", true);	
        	
    }
    
   
    
   /* @Test
    public void BillPay() throws IOException {
    	
    	FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");	
    	obj.load(objfile);
    	
    	 Driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    	Driver.findElement(By.xpath(obj.getProperty("BillPay"))).click();
    	Driver.findElement(By.xpath(obj.getProperty("PayeeName"))).sendKeys(FM.getdata("PayeeName"));
    	Driver.findElement(By.xpath(obj.getProperty("PayeeAddress"))).sendKeys(FM.getdata("PayeeAddress"));
    	Driver.findElement(By.xpath(obj.getProperty("PayeeCity"))).sendKeys(FM.getdata("PayeeCity"));
    	Driver.findElement(By.xpath(obj.getProperty("PayeeState"))).sendKeys(FM.getdata("PayeeState"));
    	Driver.findElement(By.xpath(obj.getProperty("PayeeZipcode"))).sendKeys(FM.getdata("PayeeZipcode"));
    	Driver.findElement(By.xpath(obj.getProperty("PayeePhone"))).sendKeys(FM.getdata("PayeePhone"));
    	Driver.findElement(By.xpath(obj.getProperty("PayeeAccount"))).sendKeys(FM.getdata("PayeeAccount"));
    	Driver.findElement(By.xpath(obj.getProperty("PayeeVeriAccount"))).sendKeys(FM.getdata("PayeeVeriAccount"));
    	Driver.findElement(By.xpath(obj.getProperty("PayeeAmount"))).sendKeys(FM.getdata("PayeeAmount"));
    	Driver.findElement(By.xpath(obj.getProperty("PayeeFromAccount"))).sendKeys(FM.getdata("PayeeFromAccount"));
    	}
    	*/
    	
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
