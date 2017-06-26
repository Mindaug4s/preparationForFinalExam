package tests.methods;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FirstTaskTestMethods {

	String firstName;
	String lastName;
	String emailAdress;
	String phoneNumber;
	private WebDriver driver;

	public FirstTaskTestMethods(WebDriver driver) {
		this.driver=driver;
	}

	public String getFirstName() {

		return this.firstName;
	}

	public String getLastName() {

		return this.lastName;
	}

	public String getEmail() {

		return this.emailAdress;
	}

	public String getTelephone() {

		return this.phoneNumber;
	}

	public void navigateToEditYourInformation() {
		driver.findElement(By.xpath("//a[contains(text(), 'Continue')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Edit')]")).click();
	}

	public void agreeAndInitiateContinue() {
		driver.findElement(By.name("agree")).click();

		driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
	}

	public void navigateToAccountCreationPage() {
		driver.findElement(By.partialLinkText("Account")).click();

		driver.findElement(By.linkText("Register")).click();
	}

	public WebElement getAccountSuccessElement() {
		WebElement accountHasBeenCreated = driver
				.findElement(By.xpath("//div[@id = 'content']//h1[contains (text(), 'Been Created')]"));
		return accountHasBeenCreated;
	}

	public void fillSelectFields(List<WebElement> listOfTheSelectFields) {
		for (WebElement element : listOfTheSelectFields) {

			Select selectRandomOption = new Select(element);
			selectRandomOption.selectByIndex(5);
		}
	}

	public void fillInputFields(List<WebElement> listOfTheInputFields) {
		for (WebElement inputField : listOfTheInputFields) {

			if (inputField.getAttribute("id").contains("input-postcode")) {
				inputField.sendKeys(randomNumberGenerator());
			} else if (inputField.getAttribute("id").contains("input-telephone")) {
				phoneNumber = randomNumberGenerator();
				inputField.sendKeys(phoneNumber);
			} else if (inputField.getAttribute("id").contains("input-email")) {
				emailAdress = (randomStringGenerator() + "@practice.exam");
				inputField.sendKeys(emailAdress);
			} else if ((inputField.getAttribute("id").contains("password"))
					|| (inputField.getAttribute("id")).contains("confirm")) {
				inputField.sendKeys("abcdef");
			} else if (inputField.getAttribute("id").contains("firstname")) {
				firstName = randomStringGenerator();
				inputField.sendKeys(firstName);
			} else if (inputField.getAttribute("id").contains("lastname")) {
				lastName = randomStringGenerator();
				inputField.sendKeys(lastName);

			} else {
				inputField.sendKeys(randomStringGenerator());
			}
		}

	}

	public List<WebElement> getSelectElements() {
		return driver.findElements(By.xpath("//div[(@class ='col-sm-10')]//select[contains (@id, 'input')]"));
	}

	public List<WebElement> getInputElements() {
		return driver.findElements(By.xpath("//div[(@class ='col-sm-10')]//input[contains (@id, 'input')]"));
	}

	private String randomNumberGenerator() {

		int randomNumber = (int) (Math.random() * 10000);
		String randomNumberAsString = Integer.toString(randomNumber);

		return randomNumberAsString;
	}

	private String randomStringGenerator() {

		Random randomizer = new Random();

		String randomText = ("abcdefghijklmnoprstuvz");

		char[] text = new char[5];
		for (int i = 0; i < 5; i++) {
			text[i] = randomText.charAt(randomizer.nextInt(randomText.length()));
		}
		return new String(text);

	}

}
