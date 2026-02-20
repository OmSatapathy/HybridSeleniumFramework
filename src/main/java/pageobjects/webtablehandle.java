package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webtablehandle {

	WebDriver driver;

	public webtablehandle(WebDriver driver) {
		this.driver = driver;
	}

	private By webtablelink = By.xpath("//span[contains(text(),'Web Tables')]");
	private By addBTN = By.id("addNewRecordButton");
	private By firstName = By.id("firstName");
	private By lastname = By.id("lastName");
	private By email = By.id("userEmail");
	private By age = By.id("age");
	private By salary = By.id("salary");
	private By departmet = By.id("department");
	private By submit_button = By.id("submit");
	private By newRecod = By.xpath("//tbody//tr[4]//td");



	public void navigatetoRegistaion() {
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(webtablelink).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(addBTN));
		driver.findElement(addBTN).click();
	}

	public void fillRegistationForm() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(firstName));

		driver.findElement(firstName).sendKeys("mayank");
		driver.findElement(lastname).sendKeys("Sekhar");
		driver.findElement(email).sendKeys("mayak23@gmail.com");
		driver.findElement(age).sendKeys("28");
		driver.findElement(salary).sendKeys("27000");
		driver.findElement(departmet).sendKeys("Agriculture");
		driver.findElement(submit_button).click();
	}

	public void verifyNewRecod() {
		List<WebElement> newrow = driver.findElements(newRecod);
		for(WebElement ele: newrow) {
			System.out.println(ele.getText());
			
		}
		
	}

}
