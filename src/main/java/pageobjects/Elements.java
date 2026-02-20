package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Elements {
	WebDriver driver;

	public Elements(WebDriver driver) {
		this.driver = driver;
	}

	private By elementLink = By.className("card-body");
	private By textfield = By.xpath("//*[contains(text(),'Text Box')]");
	private By full_Name= By.id("userName");
	private By email = By.id("userEmail");
	private By current_address = By.id("currentAddress");
	private By permanent_address = By.id("permanentAddress");
	private By submit_btn = By.id("submit");
	
	
	public void navigateForm() {
		driver.findElement(elementLink).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(textfield).click();
	}
	
	public void fillForm() {
		
		driver.findElement(full_Name).sendKeys("kesev");
		driver.findElement(email).sendKeys("kesev12@gmail.com");
		driver.findElement(current_address).sendKeys("12th lane, Pune");
		driver.findElement(permanent_address).sendKeys("45 link road, Hyderbad");
		driver.findElement(submit_btn).click();
	}

}
