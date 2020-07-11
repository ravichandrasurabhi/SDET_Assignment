package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPOM {

	private WebDriver driver;

	public RegisterPOM(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSignUp() {

		driver.findElement(By.xpath(("/html/body/main/section/div/div[2]/div[2]/div/div/div/ul/li[1]/a"))).click();
	}

	public void sendFirstName(String firstName) {

		driver.findElement(By.name(("firstname"))).sendKeys(firstName);
	}

	public void sendLastName(String lastName) {
		driver.findElement(By.name("lastname")).sendKeys(lastName);

	}

	public void sendemail(String email) {
		driver.findElement(By.name("email")).sendKeys(email);
	}

	public void sendUserName(String userName) {
		driver.findElement(By.id("username")).sendKeys(userName);

	}
	public void sendpassWord(String passWord) {
		driver.findElement(By.id("pass1")).sendKeys(passWord);

	}
	public void confirmPassWord(String passWord) {
		driver.findElement(By.id("pass2")).sendKeys(passWord);

	}
	public void clickRegister() {
		driver.findElement(By.id("registration_submit")).click();

	}

	public String getRegistrationStatus() {
		String registrationMessage = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/div")).getText();
		return registrationMessage;

	}

	public void clickOnProfile() {
		driver.findElement(By.xpath("//*[@id='navbar']/ul[2]/li[2]/a")).click();
	}

	public String getemailIdfromProfile() {
		String emailIdfromProfile = driver.findElement(By.xpath("//*[@id='navbar']/ul[2]/li[2]/ul/li[1]/div/p")).getText();
		return emailIdfromProfile;

	}
	public void clickOnHomePage() {
		driver.findElement(By.xpath("//*[@id='navbar']/ul[1]/li[1]/a")).click();
	}

	public void clickOnCompose() {
		driver.findElement(By.xpath("//*[@id='profileCollapse']/div/ul/li[2]/a")).click();
	}

	public void sendTo(String To) throws InterruptedException {

		driver.findElement(By.cssSelector(".select2-search__field")).sendKeys(To);	
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".select2-search__field")).sendKeys(Keys.ENTER);

	}

	public void sendSubject(String Subject) {
		driver.findElement(By.xpath("/html/body/main/section/div/div[2]/div/div/div[2]/div/div[2]/form/fieldset/div[2]/div[1]/input")).sendKeys(Subject);
	}
	public void sendMessage(String Message) throws InterruptedException {
		Thread.sleep(5000);
		WebElement a= driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(a);
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body")).sendKeys(Message);
		driver.switchTo().defaultContent();
	
	}


	public void clickOnsendMessage() {
		driver.findElement(By.id("compose_message_compose")).click();
	}


	public String getMessageSentStatus() {
		String messageSentStatus = driver.findElement(By.xpath("//*[@id='cm-content']/div/div[2]/div/div[1]")).getText();
		return messageSentStatus;

	}

}
