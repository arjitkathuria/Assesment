import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.BaseRunner;
import ui.pages.ContactUsPage;

public class ContactUsTestCases extends BaseRunner {

    ContactUsPage contactUsPage;

    @Test
    public void testContactUsForm() throws Exception {
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.goToContactPage();
        int expectedLookingFieldSize = 5;
        Assert.assertEquals(expectedLookingFieldSize, contactUsPage.getLookingFieldDropdownSize(), "Size" +
                "mismatch of I am looking to field in contact us page");
        Assert.assertTrue(contactUsPage.isLookingDropdownContainsNonEmptyElements(), "Any one of the elemnts in " +
                "Looking fiels dropdown is empty");
        Assert.assertTrue(contactUsPage.isSubProductDropdownEmpty(), "Contact us page contains non empty dada");

    }

    @Test
    public void testContactUsFormDropdowns() throws Exception {
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.goToContactPage();
        contactUsPage.selectProductDropdown();
        int expectedSubProductSize = 7;
        Assert.assertEquals(contactUsPage.getSubProductDropdownSize(), expectedSubProductSize, "Sub Product size " +
                "mismatch");
        contactUsPage.clickOnSubmitButton();
        Assert.assertTrue(contactUsPage.getMobileValidationClass().contains("invalid"), "Error message for" +
                " mobile validation field is not displayed");
    }

    @Test
    public void testContactUsFormMobieFieldVerification() throws Exception {
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.goToContactPage();
        String sixDigitNumber = "123456";
        contactUsPage.sendNumberInMobileField(sixDigitNumber);
        Assert.assertEquals(contactUsPage.getMobileValidationErrorMessage(), "Mobile number should be 7 digit");
        Assert.assertTrue(contactUsPage.getMobileValidationClass().contains("invalid"), "Error message for" +
                " mobile validation field is not displayed");
        String sevenDigitNumber = "1234567";
        contactUsPage.sendNumberInMobileField(sevenDigitNumber);
        Assert.assertTrue(contactUsPage.getMobileValidationClass().contains("valid"), "Error message for" +
                " mobile validation field displayed");
    }

}
