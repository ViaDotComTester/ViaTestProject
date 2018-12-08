package com.via.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.via.exceptions.NotEnoughSeatsException;

public class BusResultPage {
	private WebDriver driver;
	private Actions action;
	private WebDriverWait wait;
		
	@FindBy(xpath="//button[contains(text(),'View Seats')]")//(css=".CTA-red.h-s-btn")
	private WebElement viewFirstSeat;
	
	//button[contains(text(),'View Seats')
	
//	@FindBy(xpath="//div[@id='busSearchResultsContainer']/div/ul/li[1]/div[2]/div/div[1]/div/div/div[2]/div/i[contains(@data-original-title,'Available')]")
//	List<WebElement> seats;
	
	//@FindBy(xpath="/html/body/div[11]/div/ul/li[1]/div[2]/div/div[2]/section[1]/fieldset/select")//
	
	@FindBy(xpath="//select[@class='selectPickup selt-option']")
	private List<WebElement> selects;
	
	@FindBy(xpath="//select[@class='selectDrop selt-option']")
	private WebElement dropping;
	
	@FindBy(xpath="//button[@class='CTA-green proceed u_font14 u_fontW600']")
	private WebElement proceedBtn;
	
//	@FindBy(xpath="//button[contains(text(),'View Seats') and @data-origin='Mumbai']")//hrishi
//	private WebElement viewFirsttSeat;//hrishi
	
//	@FindBy(xpath="//button[contains(text(),'View Seats') and @data-origin='Pune']")//hrishi
//	private WebElement viewSeconddSeat;//hrishi
	
	@FindBy(xpath="//div[@class='flex direction-column-reverse item-center justify-around  bs-seat-map-layout']/div/div[2]/div/i[contains(@data-original-title,'Available For Booking')]")
	List<WebElement> seats1; //hrishi
	
	@FindBy(xpath="//div[@class='flex direction-column-reverse item-center justify-around  bs-seat-map-layout']/div/div[2]/div/i[contains(@data-original-title,'Available For Booking')]")
	List<WebElement> seats2; //hrishi
	
//	@FindBy(xpath="//div[@class='CTA-red u_bgViaRed u_clViaWhite u_no_border u_fontW600 bookBuses u_font16']")
//	private WebElement bookBuses;//hrishi
	
	public BusResultPage(WebDriver driver) {
		this.driver = driver;
		this.action = new Actions(driver);
		PageFactory.initElements(driver, this);		
	}
	
	public void viewSeats() {
		viewFirstSeat.click();
	}
	
	public void selectSeats(int nOfSeats) throws NotEnoughSeatsException{
		wait = new WebDriverWait(driver, 5);		//Fluent Wait
		//Choose seater or sleeper
		//and contains(@data-original-title,'SLEEPER') // SEATER
		
		List<WebElement> seats = driver.findElements(By.xpath("//div[@id='busSearchResultsContainer']/div/ul/li[1]/div[2]/div/div[1]/div/div/div[2]/div/i[contains(@data-original-title,'Available')]"));
		if(nOfSeats<=seats.size())
			for(int i=0;i<nOfSeats;i++)
				seats.get(i).click();
		else
			throw new NotEnoughSeatsException("Number of seats required exceeds number of available seats.");
		//seats.get(0).click();		//Selecting first available seat in lower deck
												
		//wait.until(ExpectedConditions.visibilityOf(boarding));
		Select bPoint = new Select(selects.get(2));
		bPoint.selectByIndex(1);		// Select the first location
		
		if(dropping.isDisplayed())	{
			Select dPoint = new Select(dropping);
			dPoint.selectByIndex(1);		// Select the first location
		}
		
		proceedBtn.click();
	}
	
	//-----HRISHIKESH
	public void viewSeatsForOneSideJourney() {
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("progressBar"))));//id:busPageLoaderTemplate
		driver.findElement(By.xpath("//button[contains(text(),'View Seats') and @data-origin='Mumbai']")).click();
	}
	
	public void selectSeatsForOneSideJourney(){
		wait = new WebDriverWait(driver, 5);	
		seats1.get(0).click();
		
		Select bPoint = new Select(selects.get(2));
		bPoint.selectByIndex(1);		// Select the first location
		
		if(dropping.isDisplayed())	{
			Select dPoint = new Select(dropping);
			dPoint.selectByIndex(1);
		}
		proceedBtn.click();
	}
	
	public void viewSeatsForReturnJourney() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[contains(text(),'View Seats') and @data-origin='Pune']")).click();
	}
	
	public void selectSeatsForReturnJourney(){
		wait = new WebDriverWait(driver, 5);	
		seats2.get(0).click();
		Select bPoint = new Select(selects.get(2));
		bPoint.selectByIndex(1);		// Select the first location
		
		try {
			if(dropping.isDisplayed())	{
				Select dPoint = new Select(dropping);
				dPoint.selectByIndex(1);
			}
		}
		catch(NoSuchElementException e) {
			System.out.println("Dropping location predecided");
		} 
		proceedBtn.click();
		//driver.findElement(By.xpath("//div[@class='CTA-red u_bgViaRed u_clViaWhite u_no_border u_fontW600 bookBuses u_font16']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[text()='Book Buses']")).click();
	}
}
