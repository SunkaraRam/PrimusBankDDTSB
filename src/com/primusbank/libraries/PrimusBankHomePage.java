package com.primusbank.libraries;



import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.primusbank.contatns.PrimusbankConstants;


public class PrimusBankHomePage extends PrimusbankConstants {

	
	public  boolean adminLogin(String uid,String pwd) {
		
		driver.findElement(By.id("txtuId")).sendKeys(uid);
		
		driver.findElement(By.id("txtPword")).sendKeys(pwd);
		
		driver.findElement(By.id("login")).click();

		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			
			wait.until(ExpectedConditions.alertIsPresent());
			
			driver.switchTo().alert().accept();
			
			driver.findElement(By.id("txtuId")).clear();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		String expurl,acturl;
		
		expurl = "adminflow" ;
				
		acturl = driver.getCurrentUrl();
		
		if (acturl.toLowerCase().contains(expurl.toLowerCase())) 
		{

			return true;
			
		} 
		else
		{
			
			return false;

		}
		
		}
	                                
	public boolean bankerLogin(String brch, String uid, String pwd) 
	{
		
		String expval,actval;
		
		expval = "Bankers_flow";
		
		Select dlist = new Select(driver.findElement(By.id("drlist")));
		//dlist.selectByVisibleText(brch);
		
		try {
			
			dlist.selectByVisibleText(brch);		
			
		} catch (Exception e) {
			
			dlist.selectByVisibleText("ameerpet");
				
		
		}
	
		driver.findElement(By.id("txtuId")).sendKeys(uid);;
		
		driver.findElement(By.id("txtPword")).sendKeys(pwd);
		
		driver.findElement(By.id("login")).click();
	
	
		try
		{
			
			//WebDriverWait wait =  new WebDriverWait(driver,5);
			//wait.until(ExpectedConditions.alertIsPresent());
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			driver.findElement(By.id("txtuId")).clear();
			
		} 
	
		catch (Exception e) 
		{
			
			
		}
		
		
		
		actval = driver.getCurrentUrl();
		
		if (actval.toLowerCase().contains(expval.toLowerCase())) 
		{

			return true;
			
		} 
		else 
		{
			
			return false;

		}
		
		
	}
	
}

//if(driver.switchTo().alert().getText().contains("InCorrect")) 
//driver.switchTo().alert().accept(); 
//

/*
String msg = driver.switchTo().alert().getText();

if (msg.toLowerCase().contains("password")) {
	
	driver.switchTo().alert().accept();
	
	return false;
	
	
}

else {
	
	driver.switchTo().alert().dismiss();
	
	return true;

}


string acturl = driver.getCurrentUrl();
if (acturl.toLowerCase().contains(expurl.toLowerCase())) {
	
	return true;
	
} else {

	return false;
	
}
*/

