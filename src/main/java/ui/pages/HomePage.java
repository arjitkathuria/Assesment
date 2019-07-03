package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    public Utility utility;

    List<WebElement> navBarLinks = driver.findElements(By.cssSelector(".leftLinks>ul>li:not([class*='selected'])"));
    WebElement mashreqNewsField = driver.findElement(By.className("newsBox"));
    WebElement contacUsLink = driver.findElement(By.cssSelector(".rightLinks .contact-btn:nth-of-type(3)>a"));

    public HomePage(WebDriver driver) {
        super(driver);
        utility = new Utility(driver);
    }

    public boolean isNavBarVisible() {
        try {
            utility.waitForElementsExist(navBarLinks, 10);
            navBarLinks.stream().allMatch(e -> e.isDisplayed());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getNavBarlinksSize() {
        return navBarLinks.size();
    }

    public boolean isMashreqNewsFielsVisible() {
        utility.waitForElementExist(mashreqNewsField, 10);
        return utility.isElementExist(mashreqNewsField);
    }

    public void clickOnContactUsLink() {
        utility.waitForElementExist(contacUsLink, 10);
        contacUsLink.click();
        utility.waitForPageLoad();
    }
}

