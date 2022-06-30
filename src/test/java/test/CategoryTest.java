package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.ToDoListPage;
import util.BrowserFactory;

public class CategoryTest {

	WebDriver driver;
	
//	@Test
	public void validateUserAbleToAddCategoryAndIsDisplayed() {
		
		driver = BrowserFactory.inIt();
		ToDoListPage toDoListPageObj = PageFactory.initElements(driver, ToDoListPage.class);
		
		
		 toDoListPageObj.insertCategory();
		 toDoListPageObj.clickAddCategoryButton();
		 toDoListPageObj.validateFirstInsertedCategory();
	}

//	@Test
	public void validateUserNotAbleToAddDuplicateCategory() {
		
		driver = BrowserFactory.inIt();
		ToDoListPage toDoListPageObj = PageFactory.initElements(driver, ToDoListPage.class);
		
		toDoListPageObj.insertCategory();
		toDoListPageObj.clickAddCategoryButton();
		toDoListPageObj.getCategoryAlreadyExistsMessage();
	}
	
//	@Test
	public void validateMonthDropdown() {
		
		driver = BrowserFactory.inIt();
		ToDoListPage toDoListPageObj = PageFactory.initElements(driver, ToDoListPage.class);
		toDoListPageObj.getAllOptionsFromMonthDropdown();
		toDoListPageObj.validateMonthDropdownHasAllMonths();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
