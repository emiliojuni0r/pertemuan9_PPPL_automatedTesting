import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Tugas2 {
    static private WebDriver driver;

    @BeforeAll
    static void setup(){
        //step 1 & 2
        driver = new EdgeDriver();
        driver.get("https://automationexercise.com/");
    }


    @Test
    void testRegister(){
        Actions action = new Actions(driver);
        // step 3
        WebElement footer = driver.findElement(By.id("footer"));
        boolean isItVisibleFooter = footer.isDisplayed();

        Assertions.assertTrue(isItVisibleFooter);

        // step 4
        WebElement signUpLink = driver.findElement(By.className("fa-lock"));

        signUpLink.click();

        // step 5
        WebElement NewUserText = driver.findElement(By.className("signup-form")).findElement(By.tagName("h2"));
        Assertions.assertEquals("New User Signup!", NewUserText.getText());

        // step 6 enter name and email address
        WebElement formSignUP = driver.findElement(By.className("signup-form")).findElement(By.tagName("form"));
        WebElement inputName = formSignUP.findElement(By.name("name"));
        WebElement inputEmail = formSignUP.findElement(By.name("email"));

        inputName.sendKeys("cihuy");
        inputEmail.sendKeys("cihuy@mail.com");

        // step 7 click 'signup'
         WebElement buttonSignUp = formSignUP.findElement(By.tagName("button"));
         buttonSignUp.submit();

         // step 8 verify 'Enter Account information' is visible
        WebElement formAccInfo = driver.findElement(By.className("login-form"));
        WebElement titleEnterAccountInformation =  formAccInfo.findElement(By.tagName("h2"));
        Assertions.assertTrue(titleEnterAccountInformation.isDisplayed());

        // step 9 fill details: title,name, email, password, dob;
        WebElement radioMr = formAccInfo.findElement(By.id("uniform-id_gender1"));
        radioMr.click();

        WebElement inputPassword = formAccInfo.findElement(By.id("password"));
        inputPassword.sendKeys("cihuy123");

        WebElement dropDownDayOfBirth = formAccInfo.findElement(By.id("days"));
        Select selectDropdownDayOfBirth = new Select(dropDownDayOfBirth);
        selectDropdownDayOfBirth.selectByContainsVisibleText("1");

        WebElement dropDownMonthOfBirth = formAccInfo.findElement(By.id("months"));
        Select selectDropdownMonthOfBirth = new Select(dropDownMonthOfBirth);
        selectDropdownMonthOfBirth.selectByContainsVisibleText("January");

        WebElement dropDownYearOfBirth = formAccInfo.findElement(By.id("years"));
        Select selectDropdownYearOfBirth = new Select(dropDownYearOfBirth);
        selectDropdownYearOfBirth.selectByContainsVisibleText("2001");

        // step 10 Select checkbox 'Sign up for our newsletter!'
        WebElement checkBoxNewsletter = driver.findElement(By.id("newsletter"));
        checkBoxNewsletter.click();

        // step 11 Select checkbox 'Receive special offers from our partners!'
        WebElement checkBoxSpecialOffer = driver.findElement(By.id("optin"));
        checkBoxSpecialOffer.click();

        // step 12 Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement inputFirstName = formAccInfo.findElement(By.id("first_name"));
        inputFirstName.sendKeys("testfirst");

        WebElement inputLastName = formAccInfo.findElement(By.id("last_name"));
        inputLastName.sendKeys("testLast");

        WebElement inputCompany = formAccInfo.findElement(By.id("company"));
        inputCompany.sendKeys("testCompany");

        WebElement inputAddress1 = formAccInfo.findElement(By.id("address1"));
        inputAddress1.sendKeys("address1");

        WebElement inputAddress2 = formAccInfo.findElement(By.id("address2"));
        inputAddress2.sendKeys("address2");

        WebElement dropDownCountry = formAccInfo.findElement(By.id("country"));
        Select selectDropDownCountry = new Select(dropDownCountry);
        selectDropDownCountry.selectByContainsVisibleText("Canada");

        WebElement inputState = formAccInfo.findElement(By.id("state"));
        inputState.sendKeys("toronto");

        WebElement inputCity = formAccInfo.findElement(By.id("city"));
        inputCity.sendKeys("sleman");

        WebElement inputZipcode = formAccInfo.findElement(By.id("zipcode"));
        inputZipcode.sendKeys("55555");

        WebElement inputMobileNum = formAccInfo.findElement(By.id("mobile_number"));
        inputMobileNum.sendKeys("14045");


        // step 13 click create acc button
        WebElement buttonCrateAccount = formAccInfo.findElement(By.tagName("button"));
        buttonCrateAccount.submit();

        // step 14 Verify that 'ACCOUNT CREATED!' is visible
        WebElement titleAccountCreated = driver.findElement(By.className("col-sm-9")).findElement(By.tagName("h2"));
        String textAccountCreated = titleAccountCreated.getText();

        Assertions.assertEquals("ACCOUNT CREATED!", textAccountCreated);

        // step 15 Click 'Continue' button
        WebElement continueButton = driver.findElement(By.cssSelector(".row .col-sm-9 .btn"));
        continueButton.click();

        // step 16  Verify that 'Logged in as username' is visible
        WebElement loggedInText = driver.findElement(By.className("fa-user"));
        Assertions.assertTrue(loggedInText.isDisplayed());

        // step 17 delete button
        WebElement deleteAccountLink = driver.findElement(By.className("fa-trash-o"));
        deleteAccountLink.click();

        // step 18
        WebElement titleAccountDeleted = driver.findElement(By.cssSelector(".container .row .col-sm-9 .title"));
        String textAccountDeleted = titleAccountDeleted.getText();

        Assertions.assertEquals("ACCOUNT DELETED!", textAccountDeleted);

    }

//    @Test
//    void ClickLinkLogin(){
//        WebElement signUpLink = driver.findElement(By.className("fa-lock"));
//
//        signUpLink.click();
//    }
//
//    @Test
//    void VerifyNewUserSignupText() {
////         WebElement NewUserText = driver.findElement(By.cssSelector(".container .row .col-sm-4 .signup-form"));
//         WebElement NewUserText = driver.findElement(By.className("signup-form")).findElement(By.tagName("h2"));
////        WebElement NewUserText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
//            Assertions.assertEquals("New User Signup!", NewUserText.getText());
////        Assertions.assertEquals("New User Signup!",NewUserText.getText());
//
//    }


    @AfterAll
    static void cleanAll(){
        driver.quit();
        driver = null;
    }
}
