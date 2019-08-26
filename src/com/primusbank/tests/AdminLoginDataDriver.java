package com.primusbank.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.primusbank.contatns.PrimusbankConstants;
import com.primusbank.libraries.AdminHomePage;
import com.primusbank.libraries.PrimusBankHomePage;

import XLApachePOI.XLUnits;

public class AdminLoginDataDriver extends PrimusbankConstants{
	
	static int z=1;
	public static String xlfile = "D:\\PrimusBankDataDrivern\\src\\com\\primusbank\\testdata\\Sample.xlsx";
	public static String xlsheet1="AdminData";
	
	
	@Test(dataProvider="AtestData")
	public void adminLogin12(String uid,String pwd) throws IOException {
		
		PrimusBankHomePage phome= new PrimusBankHomePage();
		AdminHomePage ahome=new AdminHomePage();
		
		boolean res = phome.adminLogin(uid, pwd);
		
		if (res) {
			
			Assert.assertTrue(res);
			
		}
		
		if (res) {
			XLUnits.setCellData(xlfile, xlsheet1, z, 2, "Pass");
			XLUnits.fillGreenColor(xlfile, xlsheet1, z, 2);
		}
		
		else {
			XLUnits.setCellData(xlfile, xlsheet1, z, 2, "Fails");
			XLUnits.fillRedColor(xlfile, xlsheet1, z, 2);
		}
		
		
		if (res) {
				
			ahome.adminLogout();
			
		}
		
		z++;
		
	}
	
	@DataProvider
	public Object[][] AtestData() throws Throwable
	{
	
		int rc1= XLUnits.getRowCount(xlfile, xlsheet1);
		
		Object[][] data = new Object[rc1][2];
		
		for (int i = 1; i <= rc1; i++) 
		{
			
			data[i-1][0] = XLUnits.getCellData(xlfile, xlsheet1, i, 0);
			data[i-1][1] = XLUnits.getCellData(xlfile,xlsheet1, i, 1);
			
		}
		return data;
	}
	
}
