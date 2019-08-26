package com.primusbank.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.primusbank.contatns.PrimusbankConstants;
import com.primusbank.libraries.AdminHomePage;
import com.primusbank.libraries.BankerHomePage;
import com.primusbank.libraries.PrimusBankHomePage;

import XLApachePOI.XLUnits;

public class BankerLoginDataDriver extends PrimusbankConstants{
	                                     
	static int j=1;
	public static String xlfile = "D:\\PrimusBankDataDrivern\\src\\com\\primusbank\\testdata\\Sample1.xlsx";
	public static String xlsheet="LoginData";
	public static String xlsheet1="AdminData";
	
	@Test(dataProvider= "testData")
	
	public  void bankerLogin(String br,String uid, String pwd) throws IOException {
		
		PrimusBankHomePage phome = new PrimusBankHomePage();
		
		BankerHomePage bhome = new BankerHomePage();
		
		boolean res = phome.bankerLogin(br, uid, pwd);
		
		
		if (res) {
			
			Assert.assertTrue(res);
			
		} 		
		
		if (res) {
			
			XLUnits.setCellData(xlfile, xlsheet, j, 3, "Pass");
			XLUnits.fillGreenColor(xlfile, xlsheet, j, 3);
			
		} else {
			
			XLUnits.setCellData(xlfile, xlsheet, j, 3, "Fail");
			XLUnits.fillRedColor(xlfile, xlsheet, j, 3);

		}
		
		if (res) {
			
			bhome.bankerLogout();
			
		}	
			
		
		j++;
		
}
	
	@DataProvider
	public Object[][] testData() throws Throwable 
	{
		
		int rc = XLUnits.getRowCount(xlfile, xlsheet);
		
		//System.out.println(rc);
		
		Object[][] data = new Object[rc][3];
		
		for(int i = 1; i <=rc; i++) 
			{
			
				data[i-1][0] = XLUnits.getCellData(xlfile, xlsheet, i, 0);
				
				data[i-1][1] =XLUnits.getCellData(xlfile, xlsheet, i, 1);
				
				data[i-1][2] = XLUnits.getCellData(xlfile, xlsheet, i, 2);
				
			}
		return data;
	}
		


@AfterClass
public static void closeApp() 
{
	
		driver.quit();
	
}

	
}		
	
	