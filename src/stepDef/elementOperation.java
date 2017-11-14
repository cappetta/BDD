package stepDef;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.Click;

import util.sharedData;
import util.general.tools;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class elementOperation {
	@Then("^The user enters \"(.*?)\"\\.$")
	public void the_user_enters( String key ) throws Throwable
	{
		util.general.tools.getElement(key).clear();	
		util.general.tools.getElement(key).sendKeys(util.general.ExcelUtility.getValue(sharedData.envConfigurationSheetInstance, key ,sharedData.autPosition));
	}
	
	@Then("^The user inputs \"(.*?)\" as \"(.*?)\"\\.$")
	public void the_user_inputs_as(String key, String inuptString) throws Throwable {
		util.general.tools.getElement(key).sendKeys(inuptString);
	}

	
	@Then("^The user clicks on \"(.*?)\" Button\\.$")
	public void the_user_clicks_on_Button(String buttonValue ) throws Throwable {
			try {
				util.general.tools.pointTheElement("xPath", "//*[@value='"+buttonValue+"']").click();
			} catch (Exception e) {
				try {
					util.general.tools.getElement(buttonValue).click();
					} catch (Exception e2) 
					{
						e2.printStackTrace();
					}
			}
	}

	@Then("^the user clicks on \"(.*?)\" link\\.$")
	public void the_user_clicks_on_link(String linkName ) throws Throwable {
		try {
			util.general.tools.pointTheElement("linkText", linkName ).click();
		} catch (Exception e) {
			util.general.tools.getElement(linkName).click();
		}
	}
	
	@Then("^The user will reach to \"(.*?)\" Page\\.$")
	public void the_user_will_reach_to_Page(String pageName ) throws Throwable {
		if (!pageName.trim().equals(sharedData.appInstance.getTitle().trim())) 
		{
			String expectedPageTitle = util.general.ExcelUtility.getValue(sharedData.envConfigurationSheetInstance, pageName ,sharedData.autPosition);
			Assert.assertEquals("The user is expected to reach " + expectedPageTitle + " ,but reached to : " + sharedData.appInstance.getTitle() ,expectedPageTitle.trim(),sharedData.appInstance.getTitle().trim());
		}
	}
	
	//	Then The user submits the form.
	@Then("^The user submits the form\\.$")
	public void the_user_submits_the_form() throws Throwable 
	{
		sharedData.appInstance.findElement(By.tagName("head")).submit();
	}
	
	@Then("^The user enters \"(.*?)\" Key\\.$")
	public void the_user_enters_Key(String arg1) throws Throwable {
		sharedData.appInstance.findElement(By.tagName("body")).sendKeys(Keys.ENTER);

	}

	@Then("^The user scrolls to \"(.*?)\"\\.$")
	public void the_user_scrolls_to(String key) throws Throwable {
		new Actions( sharedData.appInstance ).moveToElement( util.general.tools.getElement(key)).perform();

	}
	@Then("^the user waits for the page to load\\.$")
	public void the_user_waits_for_the_page_to_load() throws Throwable {
			tools.customWait(Thread.currentThread());
	}
}
