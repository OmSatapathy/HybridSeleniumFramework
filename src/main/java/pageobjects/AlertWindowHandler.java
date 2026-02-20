package pageobjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertWindowHandler {

	WebDriver driver;

	public AlertWindowHandler(WebDriver driver) {
		this.driver = driver;
	}

	private By alertlink = By.xpath("//*[contains(text(),'Alerts, Frame & Windows')]");
	private By browserWindowLink = By.xpath("//*[contains(text(),'Browser Windows')]");
	private By newtab = By.id("tabButton");
	private By newWindow = By.id("windowButton");
	private By newWindowmsg = By.id("messageWindowButton");

	private By insidealertsLink = By.xpath("//span[contains(text(),'Alerts')]");
	private By singleAlert = By.id("alertButton");
	private By confirmAlert = By.id("confirmButton");
	private By promptAlert = By.id("promtButton");

	private By frameLink = By.xpath("//span[contains(text(),'Frames')]");
	private By simpleframe = By.id("sampleHeading");
	private By NestedframeLink = By.xpath("//span[contains(text(),'Nested Frames')]");
	private By parentFrame = By.xpath("//div[@id='frame1Wrapper']//iframe");

	public void navigateToWindow() {
		driver.findElement(alertlink).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(browserWindowLink));
		driver.findElement(browserWindowLink).click();

	}

	public void handleBrowerWindow() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		String parentWindow = driver.getWindowHandle();
		driver.findElement(newtab).click();
		Set<String> alltab = driver.getWindowHandles();
		Set<String> allwindow = driver.getWindowHandles();

		for (String childwindow : alltab) {
			if (childwindow != parentWindow) {
				driver.switchTo().window(childwindow);
				System.out.println(driver.getCurrentUrl());
				driver.switchTo().window(parentWindow);
			}
		}

		driver.findElement(newWindow).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		for (String singlewindow : allwindow) {
			if (singlewindow != parentWindow) {
				driver.switchTo().window(singlewindow);
				System.out.println(driver.getCurrentUrl());
				driver.switchTo().window(parentWindow);
			}
		}

	}

	public void alertHandle() {
		driver.findElement(insidealertsLink).click();
		driver.findElement(singleAlert).click();

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

		driver.findElement(confirmAlert).click();
		System.out.println(alert.getText());
		alert.dismiss();

		driver.findElement(promptAlert).click();
		System.out.println(alert.getText());
		alert.sendKeys("its ok");
		alert.accept();
		

	}

	public void frameHandle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(frameLink));
		driver.findElement(frameLink).click();

		driver.switchTo().frame(0);

		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());

		driver.findElement(NestedframeLink).click();
		driver.switchTo().frame(driver.findElement(parentFrame));

		System.out.println("framehandled done!");

	}
}
