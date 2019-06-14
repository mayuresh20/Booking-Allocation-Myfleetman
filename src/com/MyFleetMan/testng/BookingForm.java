package com.MyFleetMan.testng;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;


@SuppressWarnings("deprecation")
public class BookingForm extends testBase {

	
	public static String Booking(String PrefixCompany,String CompanyName,String ServingCity,String BookingMode,String FromYear,String FromMonth,
			String FromDay,String NoofGuests,String GuestName,String MobileNo, String EmailId,String Time,String PickupAddress,String PickupLocation,
			String PickupLocation1,String PickupLocation2,String DropAddress,String DropLocation,String DropLocation1,String DropLocation2,
			String VIP,String Lady,String BookingGivenBy,String BookingByContactNo,String BookingByEmailId,String CompanyRefNo,String PaymentType,
			String Security,String VehicleType,String Carrier,String PackageFor,String PackageName,String TotalVehicles,
			String PaymentMode,String Remark,String SelfOrVendor,String SearchVehicle,String SearchVendorVehicle,String Parking,String AllocationType,
			String DrierName)throws InterruptedException, IOException {
		
//------ insert Data to Booking Form -----//
//----- Select on click Textbox -----//	
		
			driver.findElement(By.id("txtCompanyName")).clear();
			driver.findElement(By.id("txtCompanyName")).click();
			driver.findElement(By.id("txtCompanyName")).sendKeys(PrefixCompany);

			driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
		List<WebElement> list = driver.findElements(By.className("ui-menu-item"));
		
		for (WebElement listview : list) {
			if(listview.getText().equalsIgnoreCase(CompanyName)) {
				Actions actions = new Actions(driver);
			    actions.moveToElement(listview);
			  Thread.sleep(1000);
			    listview.click();   
					}			
				}
		
		if(driver.getPageSource().contains(CompanyName)){
			System.out.println("company name is : " + CompanyName);
				} else{
					System.out.println("Enter Company name");
					}

			Select s2 = new Select(driver.findElement(By.id("ddlCity")));
			s2.selectByVisibleText(ServingCity);
			System.out.println("Serving City is : " + ServingCity);
		
			Select s3 = new Select(driver.findElement(By.id("ddlBookingMode")));
			s3.selectByVisibleText(BookingMode);
			System.out.println("Booking Mode is : " + BookingMode);

//---- Select Calendar Date - DD-MM-YYYY ----//	
		Thread.sleep(1000);
			driver.findElement(By.id("txtFromDate")).click();
			try{			
//---- Select Year ----//
		Thread.sleep(1000);
			Select s4 = new Select(driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-year")));
			s4.selectByVisibleText(FromYear);
//---- Select Month ----//
			Select s5 = new Select(driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month")));
			s5.selectByVisibleText(FromMonth);
//---- Select Day ----//	
		Thread.sleep(1000);
			List <WebElement> Days = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a"));
				for(WebElement d:Days){
					d.getText();
				if(d.getText().equals(FromDay)){
					d.click();
					}
					}
				} catch (Exception e){
					System.out.println("From Date : " + FromDay + "/" + FromMonth + "/" + FromYear );
				}
			
//---- Select Dropdown ----//	
	Thread.sleep(1000);				
			Select s6 = new Select(driver.findElement(By.id("ddlGuestsNo")));
			s6.selectByVisibleText(NoofGuests);
			System.out.println("No. of Guests : " + NoofGuests);
	Thread.sleep(1000);		
			driver.findElement(By.xpath("//*[@id='txtCustomerName_1']")).clear();
			driver.findElement(By.xpath("//*[@id='txtCustomerName_1']")).sendKeys(GuestName);
			System.out.println("Guest Name is : " + GuestName);
	Thread.sleep(1000);				
			driver.findElement(By.xpath("//*[@id='txtMobileNo_1']")).clear();
			driver.findElement(By.xpath("//*[@id='txtMobileNo_1']")).sendKeys(MobileNo);
			System.out.println("Mobile No. is : " + MobileNo);
	Thread.sleep(1000);		
			driver.findElement(By.xpath("//*[@id='txtEmailId_1']")).clear();
			driver.findElement(By.xpath("//*[@id='txtEmailId_1']")).sendKeys(EmailId);
			System.out.println("Email Id : " + EmailId);
	Thread.sleep(1000);		
			driver.findElement(By.id("txtReportingTime_1")).clear();
			driver.findElement(By.id("txtReportingTime_1")).sendKeys(Time);
			System.out.println("Time is : " + Time );
	Thread.sleep(1000);
			Select PA = new Select (driver.findElement(By.xpath("//*[@id='ddlPickupPlace_1']")));
			PA.selectByVisibleText(PickupAddress);
			System.out.println("Pickup Address is : " + PickupAddress);
			
		if(PickupAddress.equals("Hotel") || PickupAddress.equalsIgnoreCase("Airport")){
			driver.findElement(By.id("PickupField1_1")).clear();
			driver.findElement(By.id("PickupField1_1")).sendKeys(PickupLocation1);
			System.out.println("Pickup Location is : " + PickupLocation1);
		
			driver.findElement(By.id("PickupField2_1")).clear();
			driver.findElement(By.id("PickupField2_1")).sendKeys(PickupLocation2);
			System.out.println("Pickup Location is : " + PickupLocation2);
			} else{
				driver.findElement(By.xpath("//*[@id='txtpickuplacefrom_1']")).clear();
				driver.findElement(By.xpath("//*[@id='txtpickuplacefrom_1']")).sendKeys(PickupLocation);
				System.out.println("Pickup Location is : " + PickupLocation);
			}
	Thread.sleep(1000);
			Select DA = new Select (driver.findElement(By.id("ddlDropPlace_1")));
			DA.selectByVisibleText(DropAddress);
			System.out.println("Drop Address is : " + DropAddress);
		
		if(DropAddress.equalsIgnoreCase("Airport")|| DropAddress.equalsIgnoreCase("Hotel") ){
			driver.findElement(By.id("DropField1_1")).clear();
			driver.findElement(By.id("DropField1_1")).sendKeys(DropLocation1);
			System.out.println("Drop Location is : " + DropLocation1);
		
			driver.findElement(By.id("DropField2_1")).clear();
			driver.findElement(By.id("DropField2_1")).sendKeys(DropLocation2);
			System.out.println("Drop Location is : " + DropLocation2);
			} else{
			driver.findElement(By.xpath("//*[@id='txtpickuplaceto_1']")).clear();
			driver.findElement(By.xpath("//*[@id='txtpickuplaceto_1']")).sendKeys(DropLocation);
			System.out.println("Drop Location is : " + DropLocation);
			}	
//---- Click on Check box ----//
	Thread.sleep(1000);
		if(VIP.equalsIgnoreCase("Yes") && Lady.equalsIgnoreCase("No")) {
				WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"chkVIP_1\"]"));
				checkbox1.click();
			}else if(Lady.equalsIgnoreCase("Yes") && VIP.equalsIgnoreCase("No") ) {
				WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"chkLady_1\"]"));
			checkbox2.click();
			}
			else if(VIP.equalsIgnoreCase("Yes") && Lady.equalsIgnoreCase("Yes"))
			{
				WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"chkVIP_1\"]"));
				checkbox1.click();
				WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"chkLady_1\"]"));
				checkbox2.click();
			}
	Thread.sleep(2000);
			driver.findElement(By.id("txtBookingGivenBy")).clear();
			driver.findElement(By.id("txtBookingGivenBy")).sendKeys(BookingGivenBy);
			System.out.println("Booking Given By : " + BookingGivenBy);
	Thread.sleep(1000);				
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtBookingContactNo']")).clear();
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtBookingContactNo']")).sendKeys(BookingByContactNo);
			System.out.println("Booking By Contact No. : " + BookingByContactNo);
	Thread.sleep(1000);		
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtBoookerEmailId']")).clear();
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtBoookerEmailId']")).sendKeys(BookingByEmailId);
			System.out.println("Booking By Email Id : " + BookingByEmailId);
	Thread.sleep(1000);		
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtCmpReference']")).clear();
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtCmpReference']")).sendKeys(CompanyRefNo);
			System.out.println("Company Ref. No. : " + CompanyRefNo);
				
//----- Click on RadioButtons : Cash, BTC ----//
//----- Value assign to :- Cash = rdoCash ; BTC = rdoBTC ----//
		List<WebElement> radio = driver.findElements(By.xpath("//input[@name = 'ctl00$ContentPlaceHolder1$Direct' and @type = 'radio']"));
			for(int i=0;i<radio.size();i++){
				WebElement local_radio = radio.get(i);
				String value = local_radio.getAttribute("value");	
			if(value.equals(PaymentType)){
					local_radio.click();
				}
			}
			System.out.println("Payment type : " + PaymentType);
	Thread.sleep(1000);
			if(Security.equals("Yes")) {
				WebElement Security_box = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_chkIsSecurityNeed']"));
					Security_box.getAttribute("value3");
					Security_box.click();
					System.out.println("Security : " + Security);
				}			
	Thread.sleep(1000);
			Select VT = new Select (driver.findElement(By.id("ddlVehicalType")));
			VT.selectByVisibleText(VehicleType);
			System.out.println("Vehicle Type : " + VehicleType);
		
	Thread.sleep(1000);
		if(Carrier.equals("Yes")) {
			WebElement Carrierbox = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_chkIsCarrier']"));
				Carrierbox.getAttribute("value2");
				Carrierbox.click();
				System.out.println("Carrier : " + Carrier);
			}
	Thread.sleep(1000);
			Select PF = new Select (driver.findElement(By.id("ddlPackageFor")));
			PF.selectByVisibleText(PackageFor);
			System.out.println("Package For : " + PackageFor);
	Thread.sleep(1000);
			Select PN = new Select (driver.findElement(By.id("ddlPackageName")));
			PN.selectByVisibleText(PackageName);
			System.out.println("Package Name : " + PackageName);
	Thread.sleep(1000);
			driver.findElement(By.id("txtVehicleCount")).clear();
			driver.findElement(By.id("txtVehicleCount")).sendKeys(TotalVehicles);
			System.out.println("Total No. of Vehicles : " + TotalVehicles);
	/*Thread.sleep(1000);	
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtAdvanceAmount']")).clear();
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtAdvanceAmount']")).sendKeys(AdvanceAmt);
			System.out.println("Advance Amt. : " + AdvanceAmt);
*/	Thread.sleep(1000);
			Select PM = new Select (driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddlPaymentType']")));
			PM.selectByVisibleText(PaymentMode);
			System.out.println("Payment Mode is : " + PaymentMode);
	Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtDestination']")).clear();
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtDestination']")).sendKeys(Remark);
			System.out.println("Rermark is : " + Remark);
		
	Thread.sleep(1500);
			driver.findElement(By.id("btnSaveAllocaion")).click();

//----- Get Title of the Page -----//
	Thread.sleep(10000);
			String actual_msg = driver.switchTo().alert().getText();
			System.out.println("Alert message is : " + actual_msg );
			driver.switchTo().alert().accept();
			String expected_msg = "Booking saved successfully."; 
			Assert.assertEquals(expected_msg, actual_msg);
	  
//----- Switch to Old Window ------//
	Thread.sleep(3000);
		 	String Booking = driver.getWindowHandle();
		 	driver.switchTo().window(Booking);
		 	String PageTitle2 = driver.getTitle();
		 	System.out.println("Page title is : " + PageTitle2);

//-----Insert Data to Allocation Form --------//
//---- Select Radio Button : Self, Vendor ------//
	Thread.sleep(4000);
		List<WebElement> radio3 = driver.findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_rdBookingType']/tbody/tr/td/input"));
			for(int i=0;i<radio3.size();i++){
				WebElement local_radio3 = radio3.get(i);
				String value = local_radio3.getAttribute("value");
				if(value.equals(SelfOrVendor)){
					local_radio3.click();
				}
			}
		System.out.println("Type is : " + SelfOrVendor);
		
		if (SelfOrVendor.equalsIgnoreCase("Self")){
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch']")).clear();
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch']")).sendKeys(SearchVehicle);
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch']")).sendKeys(Keys.TAB);
			System.out.println("Vehicle number is : " + SearchVehicle);	
	
	Thread.sleep(4500);
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).clear();
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).sendKeys(DrierName);
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).sendKeys(Keys.TAB);
			System.out.println("Driver name is : " + DrierName);
		
	Thread.sleep(4000);
			Select Park = new Select (driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_ddlParkingName']")));
			Park.selectByVisibleText(Parking);
			System.out.println("Package For : " + Parking);
	
	Thread.sleep(2000);
			Select AT = new Select (driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_ddlAllocationType']")));
				AT.selectByVisibleText(AllocationType);
				System.out.println("Allocation Type : " + AllocationType);
			}
		else if(SelfOrVendor.equalsIgnoreCase("Vendor")){	
	Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch']")).clear();
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch']")).sendKeys(SearchVendorVehicle);
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtVehicleNumberSearch']")).sendKeys(Keys.TAB);
			System.out.println("Vehicle number is : " + SearchVendorVehicle);
	Thread.sleep(3000);
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).clear();
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).sendKeys(DrierName);
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucVehicleAllocation1_txtDriverNameSaswad")).sendKeys(Keys.TAB);
			System.out.println("Driver name is : " + DrierName);
	Thread.sleep(2000);
			Select AT = new Select (driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_ddlAllocationType']")));
				AT.selectByVisibleText(AllocationType);
				System.out.println("Allocation Type : " + AllocationType);	
			}
//----- Final Click on SAVE Allocation ------//		
	Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucVehicleAllocation1_btnSave']")).click();

//----- Switch to dashboard -----//
	Thread.sleep(20000);
			String Allocation = driver.getWindowHandle();
			driver.switchTo().window(Allocation);
			String PageTitle3 = driver.getTitle();
			System.out.println("Page title is : " + PageTitle3);
	Thread.sleep(5000);	
		return null;
	}
	
}
				
