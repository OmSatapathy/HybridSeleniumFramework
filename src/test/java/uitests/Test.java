package uitests;

import pageobjects.Elements;
import pageobjects.webtablehandle;

public class Test extends Basetest{
	
	@org.testng.annotations.Test
	public void navigateTourl() {
		
		Elements obj = new Elements(driver);
		obj.navigateForm();
		obj.fillForm();
	}
	
	
	@org.testng.annotations.Test
	public void verifyRegistation() {
		webtablehandle obj = new webtablehandle(driver);
		obj.navigatetoRegistaion();
		obj.fillRegistationForm();
		obj.verifyNewRecod();
	}

}
