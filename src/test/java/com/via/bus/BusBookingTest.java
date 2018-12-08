package com.via.bus;

import org.testng.annotations.Test;
import com.via.base.BaseTestClass;
import com.via.exceptions.NotEnoughSeatsException;
import com.via.pom.BusConfirmBookingPage;
import com.via.pom.BusHomePage;
import com.via.pom.BusResultPage;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class BusBookingTest extends BaseTestClass{
  
	  @Test
	  public void a() {	//One way trip
		  //Booking Details
		  BusHomePage busHomePage = new BusHomePage(driver);
		  busHomePage.searchOneWayTrip("Mumbai", "Pune", "15/12/2018");
		  Assert.assertEquals(driver.getTitle(), "Bus Results");
		  
		  //Seat Occupation
		  //https://in.via.com/bus/search?returnType=ONEWAY&srcId=4320&destId=4378&onwardDate=2018-12-05&adt=1&chd=0&api=JOURNEY 
		  BusResultPage busResultPage = new BusResultPage(driver);
		  busResultPage.viewSeats();
		  try {
			  busResultPage.selectSeats(3);
		  } catch (NotEnoughSeatsException e) {
			  e.printStackTrace();
			  Assert.fail();
		  }
		  //Assertion
		  
		  //Traveler Details
		  BusConfirmBookingPage busConfirmBookingPage = new BusConfirmBookingPage(driver);
		  busConfirmBookingPage.fillGuestDetails(
									  new String[]{"Mr","Mrs","Miss"},
									  new String[]{"Sanjay","Leela","Senorita"},
									  new String[]{"24","22","20"},
									  "9874563210",
									  "sanjay@email.com"
				  					);
		  //Assertion
		  
		  //Payment
		  //Assertion		  
	  }
	  
	  @Test
	  public void b() { 	//RoundTrip
		  //Booking Details
		  BusHomePage busHomePage = new BusHomePage(driver);
		  busHomePage.searchRoundTrip("Mumbai", "Pune", "15/12/2018", "15/02/2019");
		  Assert.assertEquals(driver.getTitle(), "Bus Results");
		  
		  //Seat Occupation
		  BusResultPage busResultPage = new BusResultPage(driver);
		  busResultPage.viewSeatsForOneSideJourney();
		  busResultPage.selectSeatsForOneSideJourney();
		  busResultPage.viewSeatsForReturnJourney();
		  busResultPage.selectSeatsForReturnJourney();
		  //Assert
		  
		  //Traveler Details
		  BusConfirmBookingPage busConfirmBookingPage = new BusConfirmBookingPage(driver);
		  busConfirmBookingPage.fillGuestDetails(
									  new String[]{"Mr"},
									  new String[]{"Sanjay"},
									  new String[]{"24"},
									  "9874563210",
									  "sanjay@email.com"
				  					);
		  //Assertion
		  
		  //Payment
		  //Assertion		  
	  }
	  
	  @Test
	  public void c() {	//Packages
		  //Booking Details
		  BusHomePage busHomePage = new BusHomePage(driver);
		  busHomePage.searchPackages("Mumbai", "Pune", "15/12/2018");
		  Assert.assertEquals(driver.getTitle(), "Bus Results");
		  
		  //Seat Occupation
		  BusResultPage busResultPage = new BusResultPage(driver);
		  busResultPage.viewSeats();
		  try {
			busResultPage.selectSeats(3);
		  } catch (NotEnoughSeatsException e) {
			e.printStackTrace();
			Assert.fail();
		  }
		  //Assertion
		  
		  //Traveler Details
		  BusConfirmBookingPage busConfirmBookingPage = new BusConfirmBookingPage(driver);
		  busConfirmBookingPage.fillGuestDetails(
									  new String[]{"Mr","Mrs","Miss"},
									  new String[]{"Sanjay","Leela","Senorita"},
									  new String[]{"24","22","20"},
									  "9874563210",
									  "sanjay@email.com"
				  					);
		  //Assertion
		  
		  //Payment
		  //Assertion		  
	  }
	  
	  @BeforeMethod
	  public void setHome() {
		  driver.get("https://in.via.com/bus-tickets");
		  //driver.findElement(By.xpath("//div[@id='Bus']/a")).click();
	  }
	  
	  @BeforeTest
	  public void beforeTest() {
		  //Preconditions
	  }
	
	  @AfterTest
	  public void afterTest() {
		  //PostConditions
	  }
}