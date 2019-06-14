package com.MyFleetMan.testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.excelRead.XlsReader;

import junit.framework.Assert;

public class testBase {
	static XlsReader reader;
	static WebDriver driver;
	static Properties prop;

	public String workingDir;
	
	HSSFWorkbook workbook;
	// Declare An Excel Work Sheet
	HSSFSheet sheet;
	// Declare A Map Object To Hold TestNG Results
	Map<String, Object[]> TestNGResults;
	public static String driverPath = "D:\\Mayuresh\\Mayuresh Data\\Workspace\\MyfleetmanTestNGFramework\\src\\";

	@Test(description = "Opens the Website for Login Test", priority = 1)
	public void LaunchWebsite() throws Exception {

		try {
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			TestNGResults.put("2", new Object[] { 1d, "Navigate to website", "Site gets opened", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("2", new Object[] { 1d, "Navigate to website", "Site gets opened", "Fail" });
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(description = "Fill the Login Details", priority = 2)
	public void FillLoginDetails() throws Exception {

		try {
			// Get the username element
			WebElement username = driver.findElement(By.xpath("//*[@id='myLogin_UserName']"));
			username.sendKeys(prop.getProperty("username"));

			// Get the password element
			WebElement password = driver.findElement(By.xpath("//*[@id='myLogin_Password']"));
			password.sendKeys(prop.getProperty("password"));

		Thread.sleep(1000);
			TestNGResults.put("3", new Object[] { 2d, "Fill Login form data (Username/Password)",
					"Login details gets filled", "Pass" });

		} catch (Exception e) {
			TestNGResults.put("3",
					new Object[] { 2d, "Fill Login form data (Username/Password)", "Login form gets filled", "Fail" });
			Assert.assertTrue(false);
		}
	}
	
	@Test(description = "Perform Login", priority = 3)
	public void DoLogin() throws Exception {

		try {
			// Click on the Login button
			WebElement login = driver.findElement(By.xpath("//*[@id='myLogin_LoginButton']"));
			login.click();

			Thread.sleep(2000);
			// Assert the user login by checking the Online user
			String PageTitle = driver.getTitle();
			System.out.println("Page Title is : " + PageTitle);
			TestNGResults.put("4", new Object[] { 3d, "Click Login and verify Dashboard", "Login success", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("4",
					new Object[] { 3d, "Click Login and verify Dashboard", "Login success", "Fail" });
			Assert.assertTrue(false);
		}
	}
	
	@Test(description = "Fill Booking & Allocation Form", priority = 4)
	public void FillBookingForm() throws Exception {
		try{
			reader = new XlsReader(prop.getProperty("xlsPath"));
						
			}catch(Exception e){
				e.printStackTrace();
				}
		int rowCount = reader.getRowCount("Booking");
		
		for(int rowNo=2; rowNo<=rowCount; rowNo++){
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("/html/body/form/div[3]/div[1]/a[2]/i"));
		Thread.sleep(2000);
			element.click();
		Thread.sleep(1500);
			Actions Action = new Actions(driver);
			WebElement element1 = driver.findElement(By.xpath("//*[@id='ctl00_rptMenu_ctl06_masters']"));
			Action.moveToElement(element1).click().build().perform();
		Thread.sleep(1500);
			Actions Action1 = new Actions(driver);
			WebElement element2 = driver.findElement(By.xpath("//*[@id='ctl00_rptMenu_ctl06_rptSubMenu_ctl01_HyperLink1']"));
			Action1.moveToElement(element2).click().build().perform();
			Thread.sleep(2000);
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnNew")).click();
		
			String PrefixCompany = reader.getCellData("Booking", "PrefixCompany", rowNo);
			String CompanyName = reader.getCellData("Booking", "CompanyName", rowNo);			
			String ServingCity = reader.getCellData("Booking", "ServingCity", rowNo);
			String BookingMode = reader.getCellData("Booking", "BookingMode", rowNo);
			String FromYear = reader.getCellData("Booking", "FromYear", rowNo);
			String FromMonth = reader.getCellData("Booking", "FromMonth", rowNo);
			String FromDay = reader.getCellData("Booking", "FromDay", rowNo);
			String NoofGuests = reader.getCellData("Booking", "NoofGuests", rowNo);
			String GuestName = reader.getCellData("Booking", "GuestName", rowNo);
			String MobileNo  = reader.getCellData("Booking", "MobileNo ", rowNo);
			String EmailId = reader.getCellData("Booking", "EmailId", rowNo);
			String Time = reader.getCellData("Booking", "Time", rowNo);
			String PickupAddress = reader.getCellData("Booking", "PickupAddress", rowNo);
			String PickupLocation = reader.getCellData("Booking", "PickupLocation", rowNo);
			String PickupLocation1 = reader.getCellData("Booking", "PickupLocation1", rowNo);
			String PickupLocation2 = reader.getCellData("Booking", "PickupLocation2", rowNo);
			String DropAddress = reader.getCellData("Booking", "DropAddress", rowNo);
			String DropLocation = reader.getCellData("Booking", "DropLocation", rowNo);
			String DropLocation1 = reader.getCellData("Booking", "DropLocation1", rowNo);
			String DropLocation2 = reader.getCellData("Booking", "DropLocation2", rowNo);
			String VIP = reader.getCellData("Booking", "VIP", rowNo);
			String Lady = reader.getCellData("Booking", "Lady", rowNo);
			String BookingGivenBy = reader.getCellData("Booking", "BookingGivenBy", rowNo);
			String BookingByContactNo = reader.getCellData("Booking", "BookingByContactNo", rowNo);
			String BookingByEmailId = reader.getCellData("Booking", "BookingByEmailId", rowNo);
			String CompanyRefNo = reader.getCellData("Booking", "CompanyRefNo", rowNo);
			String PaymentType = reader.getCellData("Booking", "PaymentType", rowNo);
			String Security = reader.getCellData("Booking", "Security", rowNo);
			String VehicleType = reader.getCellData("Booking", "VehicleType", rowNo);
			String Carrier = reader.getCellData("Booking", "Carrier", rowNo);
			String PackageFor = reader.getCellData("Booking", "PackageFor", rowNo);
			String PackageName = reader.getCellData("Booking", "PackageName", rowNo);
			String TotalVehicles = reader.getCellData("Booking", "TotalVehicles", rowNo);
			/*String AdvanceAmt = reader.getCellData("Booking", "AdvanceAmt", rowNo);*/
			String PaymentMode = reader.getCellData("Booking", "PaymentMode", rowNo);
			String Remark = reader.getCellData("Booking", "Remark", rowNo);
		//---- Sheet = Allocation ----//	
			String SelfOrVendor = reader.getCellData("Allocation", "SelfOrVendor", rowNo);
			String SearchVehicle = reader.getCellData("Allocation", "SearchVehicle", rowNo);
			String SearchVendorVehicle = reader.getCellData("Allocation", "SearchVendorVehicle", rowNo);
			String Parking = reader.getCellData("Allocation", "Parking", rowNo);
			String AllocationType = reader.getCellData("Allocation", "AllocationType", rowNo);
			String DrierName = reader.getCellData("Allocation", "DrierName", rowNo);
			
			int RowNumber = rowNo-1;
			System.out.println("         ");
			System.out.println("****Output : "+ RowNumber +"*******");
			System.out.println("         ");

			
			BookingForm.Booking(PrefixCompany, CompanyName, ServingCity, BookingMode, FromYear, FromMonth, FromDay,NoofGuests,
					GuestName, MobileNo, EmailId, Time, PickupAddress, PickupLocation, PickupLocation1, PickupLocation2, DropAddress, 
					DropLocation, DropLocation1, DropLocation2, VIP, Lady, BookingGivenBy, BookingByContactNo, BookingByEmailId, 
					CompanyRefNo, PaymentType, Security, VehicleType, Carrier, PackageFor,PackageName, TotalVehicles, 
					PaymentMode, Remark, SelfOrVendor, SearchVehicle, SearchVendorVehicle, Parking, AllocationType, DrierName);
		}
		
		try {
			
		TestNGResults.put("5", new Object[] { 4d, "Fill Details on Booking & Allocation Form", "Booking & Allocation Form Filled", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("5",
					new Object[] { 4d, "Fill Details on Booking & Allocation  Form", "Booking & Allocation Form Filled", "Fail" });
			Assert.assertTrue(false);
		}
	}
	
	@Test(description = "Logout From the Application", priority = 5)
	public void Logout() throws Exception {
		try {
	//Logout function
		WebElement logout = driver.findElement(By.id("ctl00_lblusername"));
				logout.click();
		Thread.sleep(3000);
				WebElement Logout1 = driver.findElement(By.id("ctl00_hyLogOut"));
				Logout1.click();
		Thread.sleep(4000);
			
		TestNGResults.put("6", new Object[] { 5d, "Click on Logout", "Logout Successfully", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("6",
					new Object[] { 5d, "Click on Logout", "Logout Successfully", "Fail" });
			Assert.assertTrue(false);
		}
	}
	
@BeforeClass(alwaysRun = true)
	public void suiteSetUp() {

		// create a new work book
		workbook = new HSSFWorkbook();
		// create a new work sheet
		sheet = workbook.createSheet("TestNG Result Summary");
		TestNGResults = new LinkedHashMap<String, Object[]>();
		// add test result excel file column header
		// write the header in the first row
		TestNGResults.put("1", new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output" });

		try {
			prop = new Properties();
			FileInputStream input = new FileInputStream("D:\\Mayuresh\\Mayuresh Data\\Workspace\\MyfleetmanTestNGFramework\\src\\objectRepository\\ObjectRepository.properties");
		    prop.load(input); 
		    
		    System.out.println(prop.getProperty("browser"));
		    String browserName = prop.getProperty("browser");
		
		    if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("Firefox")){
				System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxPath"));	
				driver = new FirefoxDriver(); 
			}
			else {
				System.out.println("Browser not Found");
				}
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new IllegalStateException("Can't start the Chrome Web Driver", e);
		}
	}

	@AfterClass
	public void suiteTearDown() {
		// write excel file and file name is SaveTestNGResultToExcel.xls
		Set<String> keyset = TestNGResults.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = TestNGResults.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(new File("SaveTestNGResultToExcel.xls"));
			workbook.write(out);
			out.close();
			System.out.println("Successfully saved Selenium WebDriver TestNG result to Excel File!!!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// close the browser
		driver.close();
		driver.quit();
	}
}
