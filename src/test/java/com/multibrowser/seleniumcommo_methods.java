package com.multibrowser;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.maveric.core.driver.DriverFactory;

public class seleniumcommo_methods  {
	
	parabankbrowser2 PBM = new parabankbrowser2();
	public static WebDriver Driver;
	
	public void WebEdit(String xpath, String val) {
		PBM.Driver.findElement(By.xpath(xpath)).click();
		PBM.Driver.findElement(By.xpath(xpath)).sendKeys(val);	
		
	}
	
   public static void WindowHandlerWindows() {
		String MainWindow = Driver.getWindowHandle();		
		
        // To handle all new opened window.				
            Set<String> s1 = Driver.getWindowHandles();		
        Iterator<String> i1 = s1.iterator();		
        		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                 
                    // Switching to Child window
                    Driver.switchTo().window(ChildWindow);	                                                                                                           
                    Driver.close(); 
            }      
		
	}
        Driver.switchTo().window(MainWindow);	
		//return element;
		
	}
	

public static void getAlerts1() throws InterruptedException {
	Thread.sleep(3000);
	
	Alert simpleAlert = ((WebDriver) Driver).switchTo().alert();
	simpleAlert.accept();
	//Driver.switchTo().alert().getText();


}
public static void getAlerts2() throws InterruptedException, AWTException {
	Thread.sleep(5000);
	
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_SPACE);
	robot.keyRelease(KeyEvent.VK_SPACE);
	Thread.sleep(2000);
}

public static void  getAlerts3() throws InterruptedException {
	Driver.findElement(By.xpath("//*[@id='confirmButton']")).click();
	Thread.sleep(3000);
	
	Alert simpleAlert = ((WebDriver) Driver).switchTo().alert();
	simpleAlert.accept();
	;
}

public static void getAlerts4() throws InterruptedException {
	Thread.sleep(3000);
	
	Alert simpleAlert = ((WebDriver) Driver).switchTo().alert();
	
	Driver.switchTo().alert().sendKeys("Vino");
	simpleAlert.accept();

}
public static WebElement findElement(By by) {
	try {
		WebDriver Driver = DriverFactory.getFirefoxDriver();
		return Driver.findElement(by);
	} catch (Exception E) {
		//ExReporter.log(LogStatus.ERROR, "Element not located in the page :" + E.getMessage());
		return null;
	}
}

public static void dropdown(By by, String keysToSend) {
	try {

	WebElement t = findElement(by);
	Select sel= new Select(t);
	sel.selectByVisibleText(keysToSend);
	Thread.sleep(1500);
	//ExReporter.log(LogStatus.PASS, "Text is entered successfully :" + keysToSend);
	} catch (Exception E) {
	//ExReporter.log(LogStatus.FAIL, "Text not entered successfully");
	}
	}


}
