package uitests;

import pageobjects.AlertWindowHandler;

public class WindowHandleTest extends Basetest {
	
	@org.testng.annotations.Test(priority = 1)
	public void verifyWindowHandles() {
		AlertWindowHandler obj = new AlertWindowHandler(driver);
		obj.navigateToWindow();
		obj.handleBrowerWindow();
	}
	
	@org.testng.annotations.Test(priority = 2)
	public void verifyAlert() {
		AlertWindowHandler obj = new AlertWindowHandler(driver);
		obj.navigateToWindow();
		obj.alertHandle();
		obj.frameHandle();
	}
	
	@org.testng.annotations.Test(priority = 3)
	public void verifyFrames() {
		AlertWindowHandler obj = new AlertWindowHandler(driver);
		obj.navigateToWindow();
		obj.frameHandle();
	}
}
