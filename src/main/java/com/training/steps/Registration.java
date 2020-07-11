package com.training.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.beans.User;
import com.training.pom.RegisterPOM;
import com.training.util.DriverFactory;
import com.training.util.DriverNames;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Registration {

	public static WebDriver driver = DriverFactory.getDriver(DriverNames.CHROME); 
	public static RegisterPOM rPOM = new RegisterPOM(driver); 
	String url = "http://elearningm1.upskills.in"; 
	String firstName;
	String lastName;
	public static String email = null;
	String To;
	String subject;
	String Message;

	@Given("^the website is loaded$")
	public void the_website_is_loaded() throws Throwable {
		driver.get(url);
		System.out.println("Loaded Website..");
	}

	@Given("^Engilsh is selected as Language on the home page$")
	public void engilsh_is_selected_as_Language_on_the_home_page() throws Throwable {

	}

	@When("^user wants to register$")
	public void user_wants_to_register() throws Throwable {
		System.out.println("Clicking on Signup");
		rPOM.clickSignUp();

	}

	@When("^mandatory fields are populated$")
	public void mandatory_fields_are_populated(DataTable dataTable) throws Throwable {
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> temp : list) {

			User.userName = temp.get("username");
			User.password = temp.get("password");
			firstName = temp.get("firstname");
			lastName = temp.get("lastname");
			email = temp.get("email");
			System.out.println(
					"UserName: " + User.userName  + 
					"\tPassword: " + User.password 
					);

		}
		System.out.println("firstName is "+firstName);
		System.out.println("lastName is "+lastName);
		System.out.println("email is "+email);
		/*driver.findElement(By.id("login")).sendKeys(User.userName);
		driver.findElement(By.id("password")).sendKeys(User.password);
		driver.findElement(By.name("submitAuth")).click();*/
		rPOM.sendFirstName(firstName);
		rPOM.sendLastName(lastName);
		rPOM.sendemail(email);
		rPOM.sendUserName(User.userName);
		rPOM.sendpassWord(User.password);
		rPOM.confirmPassWord(User.password);


	}

	@When("^Clicking on the Register button$")
	public void clicking_on_the_Register_button() throws Throwable {

		rPOM.clickRegister();

	}

	@Then("^display the valid message if registered successfully$")
	public void display_the_valid_message_if_registered_successfully() throws Throwable {

		String registrationMessage = rPOM.getRegistrationStatus();
		System.out.println("registrationMessage is "+registrationMessage);

		if(registrationMessage.contains(firstName))
		{
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Registration is unsuccessfull");
			Assert.assertTrue(false);
		}

	}

	@Given("^user registered successfully$")
	public void user_registered_successfully() throws Throwable {

		System.out.println("Registration is successfull");
	}

	@When("^clicked on profile dropdown at top right corner$")
	public void clicked_on_profile_dropdown_at_top_right_corner() throws Throwable {

		rPOM.clickOnProfile();
	}

	@Then("^display profile details such as name and email$")
	public void display_profile_details_such_as_name_and_email() throws Throwable {

		String emailIdfromProfile = rPOM.getemailIdfromProfile();
		System.out.println("emailIdfromProfile is"+emailIdfromProfile);
		System.out.println("email is "+email);
		if(emailIdfromProfile.equals(email))
		{
			Assert.assertTrue(true);
			System.out.println("emailIdfromProfile is"+emailIdfromProfile);
		}
		else 
		{
			Assert.assertTrue(false);
		}
	}

	@Then("^validate name and email of the user\\.$")
	public void validate_name_and_email_of_the_user() throws Throwable {

		System.out.println("emailId is validated");
	}

	@Given("^user wants to send an message to other user in the system$")
	public void user_wants_to_send_an_message_to_other_user_in_the_system() throws Throwable {

		rPOM.clickOnHomePage();
	}

	@Given("^clicked on Compose option in the home page$")
	public void clicked_on_Compose_option_in_the_home_page() throws Throwable {

		rPOM.clickOnCompose();
	}

	@When("^entered details such as To, subject and Message$")
	public void entered_details_such_as_To_subject_and_Message(DataTable emaildata) throws Throwable {

		List<Map<String, String>> userlist = emaildata.asMaps(String.class, String.class);

		for (Map<String, String> temp1 : userlist) {

			To = temp1.get("To");
			subject = temp1.get("subject");
			Message = temp1.get("Message");

			System.out.println(
					"To is: " + To  + 
					"\t subject is: " + subject +
					"\t Message is: " + Message 
					);
		}


		rPOM.sendTo(To);
		rPOM.sendSubject(subject);
		rPOM.sendMessage(Message);

	}

	@When("^finally clicks on send message$")
	public void finally_clicks_on_send_message() throws Throwable {

		rPOM.clickOnsendMessage();
	}

	@Then("^acknowledgement is shown\\.$")
	public void acknowledgement_is_shown() throws Throwable {

		String messageSentStatus = rPOM.getMessageSentStatus();

		if(messageSentStatus.contains(To))
		{
			System.out.println(messageSentStatus);
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Message sending Failed");
			Assert.assertTrue(false);
		}

	}


}

