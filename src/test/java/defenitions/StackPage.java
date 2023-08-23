package defenitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObject.PageObjectManager;

import pageObject.StackPageObject;
import utilities.ExcelUtil;
import utilities.TestSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StackPage {
	WebDriver driver;
	List<WebElement> topicList;
	List<String> codeTest;
	String expected, actual;
	String path="src/test/resources/inputdata/DataInput.xlsx";
	
	TestSetUp setUp;
	PageObjectManager pageObjectManager;
	StackPageObject StackPage;
	
	public StackPage(TestSetUp setUp) {
		this.setUp = setUp;
		this.StackPage = setUp.pageObjectManager.StackPageObject();
	}
		
	
	@When("User click on Stack from the dropdown")
	public void user_click_on_stack_from_the_dropdown() {
	    StackPage.selectStack();
	}

	@Then("Stack page is displayed")
	public void stack_page_is_displayed() {
		
		expected = "https://dsportalapp.herokuapp.com/stack/";
		actual = StackPage.getPageUrl();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
	}

	@Then("heaader Stack is displayed")
	public void heaader_stack_is_displayed() {
		expected = "Stack";
		actual = StackPage.getPageHeader();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
	}

	@When("User click on Get Started button for Stack")
	public void user_click_on_get_started_button_for_stack() {
	    StackPage.btnClick();
	}
	
}
