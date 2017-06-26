package practical.exam.Mindaug4sBinBash;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import exam.preparation.ExamPreparationProject.BaseTest;
import junit.framework.Assert;
import tests.methods.FirstTaskTestMethods;

public class FirstTaskTest extends BaseTest {

	FirstTaskTestMethods methods; 
	List<WebElement> listOfTheInputFields;
	List<WebElement> listOfTheSelectFields;



	@Test
	public void testAccountCreation() {
		methods = new FirstTaskTestMethods(driver);

		methods.navigateToAccountCreationPage();

		listOfTheInputFields = methods.getInputElements();

		listOfTheSelectFields = methods.getSelectElements();

		methods.fillSelectFields(listOfTheSelectFields);

		methods.fillInputFields(listOfTheInputFields);

		methods.agreeAndInitiateContinue();

		Assert.assertTrue("Account has not been created", methods.getAccountSuccessElement().isDisplayed());
		System.out.println("Success. Account has been created :)");

		methods.navigateToEditYourInformation();

		Assert.assertEquals("Actual and registered names do not match", methods.getFirstName(),
				driver.findElement(By.id("input-firstname")).getAttribute("value"));
		System.out.println("Actual and registered names match");

		Assert.assertEquals("Actual and registered last names do not match", methods.getLastName(),
				driver.findElement(By.id("input-lastname")).getAttribute("value"));
		System.out.println("Actual and registered last names match");

		Assert.assertEquals("Actual and registered e-mail adresses do not match", methods.getEmail(),
				driver.findElement(By.id("input-email")).getAttribute("value"));
		System.out.println("Actual and registered e-mail adresses match");

		Assert.assertEquals("Actual and registered telephone numbers do not match", methods.getTelephone(),
				driver.findElement(By.id("input-telephone")).getAttribute("value"));
		System.out.println("Actual and registered telephone numbers match");

	}

}
