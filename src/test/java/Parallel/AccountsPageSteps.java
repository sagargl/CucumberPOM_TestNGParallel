package Parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.AccountsPage;
import com.qa.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	
	private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountspage;
	
	@Given("User has logged into the application")
	public void user_has_logged_into_the_application(DataTable credTable) {
		List<Map<String, String>> credList=credTable.asMaps();
		String username=credList.get(0).get("username");
		String password=credList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountspage=loginpage.doLogin(username, password);

	   	}

	
	@Given("User is on Accounts Page")
	public void user_is_on_accounts_page() {
		String title=accountspage.getAccountsPageTitle();
	   	}

	@Then("User gets the Accounts Section")
	public void user_gets_the_accounts_section(DataTable sectionsTable) {
		List<String> expAccountsSectionList=sectionsTable.asList();
		System.out.println("Expected accounts section list is : "+expAccountsSectionList);
		
		List<String>actAccountsSectionList=accountspage.getAccountsSectionList();
		System.out.println("Actual accounts section list is : "+actAccountsSectionList);
		
		Assert.assertTrue(expAccountsSectionList.containsAll(actAccountsSectionList));
		
		
	    	}

	@Then("Account Section Count Should Be {int}")
	public void account_section_count_should_be(Integer expsectioncount) {
		Assert.assertTrue(accountspage.getAccountsSectionsCount()==expsectioncount);	     	
	}
	
	



}
