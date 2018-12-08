package com.via.pom;
/*
public class BusConfirmBookingPage {

	public void fillUpInfo() {
		//Fill up guest details
	}
}
*/

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusConfirmBookingPage {
		WebDriver driver;
		WebDriverWait wait;
		Actions action;
		
		By contactMobile = By.id("contactMobile");
		By contactEmail = By.id("contactEmail");
		By termsCond = By.id("read_terms_label");
		By makePay = By.id("makePayCTA");

		public BusConfirmBookingPage(WebDriver driver) {
			this.driver=driver;
			action = new Actions(driver);
			wait=new WebDriverWait(driver, 20);
		}
		
		public void fillGuestDetails(String[] title, String[] name,String[] age, String contact, String email) {
			
			for(int i=0;i<title.length;i++) 
				driver.findElement(By.name("AdultTitle"+i)).sendKeys(title[i]);
			
			for(int i=0;i<title.length;i++) 
				driver.findElement(By.name("AdultFirstName"+i)).sendKeys(name[i]);
			
			for(int i=0;i<title.length;i++)
				driver.findElement(By.name("AdultAge"+i)).sendKeys(age[i]);				//actually a number
						
			driver.findElement(contactMobile).clear();
			driver.findElement(contactMobile).sendKeys(contact);
			driver.findElement(contactEmail).clear();
			driver.findElement(contactEmail).sendKeys(email);
			//System.out.println(driver.findElement(termsCond).isSelected());
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(termsCond));
			if(!driver.findElement(termsCond).isSelected()) {
				driver.findElement(termsCond).click();
			}
			driver.findElement(makePay).click();
		}
}

/*				List<WebElement> noOfAdult = driver.findElements(adult);
List<WebElement> noOfChild = driver.findElements(child);
List<WebElement> noOfInfant = driver.findElements(infant);

for(int i=0;i<noOfAdult.size();i++)	 {
	System.out.println("hello");
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	//JavascriptExecutor javascriptex=(JavascriptExecutor)driver;
	System.out.println(noOfAdult.get(i).getText());
	//javascriptex.executeScript("arguments[0].click();", noOfAdult.get(i));
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	driver.findElement(By.id("adult"+(i+1)+"Title")).sendKeys("Mr");
	driver.findElement(By.id("adult"+(i+1)+"FirstName")).sendKeys("Sanjay");
	driver.findElement(By.id("adult"+(i+1)+"Surname")).sendKeys("Jalona");
	if(i==noOfAdult.size()-1) {
		break;
	} 
	noOfAdult.get(i+1).click();
	//driver.findElement(By.xpath("//div[@id='paxContainer']//div[@class='paxDiv js-pax via-collapse-blk' and @data-ptype='adt']//span[@class='paxOpenClose via-collapse-control expand']")).click();
}

//---------------Shraddha
for(int i=0;i<noOfChild.size();i++) {
	System.out.println("hello");
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	//JavascriptExecutor javascriptex=(JavascriptExecutor)driver;
	System.out.println(noOfChild.get(i).getText());
	noOfChild.get(i).click();
	//javascriptex.executeScript("arguments[0].click();", noOfAdult.get(i));
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	driver.findElement(By.id("child"+(i+1)+"Title")).sendKeys("Mr");
	driver.findElement(By.id("child"+(i+1)+"FirstName")).sendKeys("Manjay");
	driver.findElement(By.id("child"+(i+1)+"Surname")).sendKeys("Jalona");
	driver.findElement(By.id("child"+(i+1)+"DOBday")).sendKeys("15");
	driver.findElement(By.id("child"+(i+1)+"DOBmonth")).sendKeys("Jan");
	driver.findElement(By.id("child"+(i+1)+"DOByear")).sendKeys("2010");
	if(i==noOfChild.size()-1) {
		break;
	} 
	noOfChild.get(i+1).click();
	//driver.findElement(By.xpath("//div[@id='paxContainer']//div[@class='paxDiv js-pax via-collapse-blk' and @data-ptype='adt']//span[@class='paxOpenClose via-collapse-control expand']")).click();
}

//--infant
for(int i=0;i<noOfInfant.size();i++) {
	System.out.println("hello");
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	//JavascriptExecutor javascriptex=(JavascriptExecutor)driver;
	System.out.println(noOfInfant.get(i).getText());
	noOfInfant.get(i).click();
	//javascriptex.executeScript("arguments[0].click();", noOfAdult.get(i));
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	driver.findElement(By.id("infant"+(i+1)+"Title")).sendKeys("Mr");
	driver.findElement(By.id("infant"+(i+1)+"FirstName")).sendKeys("Kanjay");
	driver.findElement(By.id("infant"+(i+1)+"Surname")).sendKeys("Jalona");
	driver.findElement(By.id("infant"+(i+1)+"DOBday")).sendKeys("01");
	driver.findElement(By.id("infant"+(i+1)+"DOBmonth")).sendKeys("Jan");
	driver.findElement(By.id("infant"+(i+1)+"DOByear")).sendKeys("2018");
	if(i==noOfInfant.size()-1) {
		break;
	} 
	noOfInfant.get(i+1).click();
	//driver.findElement(By.xpath("//div[@id='paxContainer']//div[@class='paxDiv js-pax via-collapse-blk' and @data-ptype='adt']//span[@class='paxOpenClose via-collapse-control expand']")).click();
}*/