package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactUsPage extends BasePage {

    WebElement contacUsLink = driver.findElement(By.cssSelector(".rightLinks .contact-btn:nth-of-type(3)>a"));
    WebElement lookingFieldDropdown;
    WebElement subProductDropdown;
    WebElement productDropDown;
    WebElement mobileNumberField;
    WebElement mobileFieldErrorMessage;
    WebElement submitButton;

    public Utility utility;
    HomePage homePage;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        utility = new Utility(driver);
    }

    public void goToContactPage() throws Exception {
        utility.waitForElementExist(contacUsLink, 10);
        Thread.sleep(300);
        contacUsLink.click();
        utility.waitForPageLoad();
    }

    public void clickOnSubmitButton() {
        submitButton = driver.findElement(By.id("btnSubmit"));
        utility.waitForElementExist(submitButton, 10);
        submitButton.click();
    }

    public int getLookingFieldDropdownSize() {
        lookingFieldDropdown = driver.findElement(By.name("reachoutforproduct"));
        utility.waitForElementExist(lookingFieldDropdown, 15);
        return utility.getDropdownList(lookingFieldDropdown).size();
    }

    public boolean isLookingDropdownContainsNonEmptyElements() {
        lookingFieldDropdown = driver.findElement(By.name("reachoutforproduct"));
        utility.waitForElementExist(lookingFieldDropdown, 10);
        return utility.isListConatinsNonEmptyElements(utility.getDropdownList(lookingFieldDropdown));
    }

    public boolean isSubProductDropdownEmpty() {
        subProductDropdown = driver.findElement(By.id("product"));
        utility.waitForElementExist(subProductDropdown, 10);
        return utility.isListConatinsNonEmptyElements(utility.getDropdownList(subProductDropdown));
    }

    public void selectProductDropdown() {
        productDropDown = driver.findElement(By.id("need"));
        utility.selectDropdownByText(productDropDown, "Loans");
    }

    public int getSubProductDropdownSize() {
        subProductDropdown = driver.findElement(By.id("product"));
        utility.waitForElementExist(subProductDropdown, 10);
        return utility.getDropdownList(subProductDropdown).size();
    }

    public void sendNumberInMobileField(String number) {
        mobileNumberField = driver.findElement(By.id("mobile"));
        utility.waitForElementExist(mobileNumberField, 10);
        mobileNumberField.clear();
        mobileNumberField.sendKeys(number);
    }

    public String getMobileValidationErrorMessage() throws InterruptedException {
        Thread.sleep(2000);
        mobileFieldErrorMessage = driver.findElement(By.cssSelector("#mobile + span"));
        utility.waitForElementExist(mobileFieldErrorMessage, 10);
        return mobileFieldErrorMessage.getText().trim();
    }

    public String getMobileValidationClass() {
        mobileNumberField = driver.findElement(By.id("mobile"));
        utility.waitForElementExist(mobileNumberField, 10);
        return mobileNumberField.getAttribute("class");
    }
}


