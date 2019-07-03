package ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Utility extends BasePage {
    WebDriverWait wait;
    Select options;

    Utility(WebDriver driver) {
        super(driver);
    }

    public void waitForElementExist(WebElement element, int timeInSeconds) {
        try {
            wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementsExist(List<WebElement> elements, int timeInSeconds) {
        try {
            wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isElementExist(WebElement element) {
        boolean result = true;
        try {
            if (element.isDisplayed()) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public int getDropdownSize(WebElement element) {
        List<WebElement> elements = new Select(element).getOptions();
        return elements.size();
    }

    public List<WebElement> getDropdownList(WebElement element) {
        List<WebElement> elements = new Select(element).getOptions();
        return elements;
    }

    public boolean isListConatinsNonEmptyElements(List<WebElement> elements) {
        try {
            elements.stream().allMatch(e -> !e.getText().isEmpty());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void selectDropdownByText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }
}
