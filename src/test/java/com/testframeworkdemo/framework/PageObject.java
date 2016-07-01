package com.testframeworkdemo.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.testframeworkdemo.framework.helpers.WebDriverHelper;

public abstract class PageObject {

	private static final Logger LOG = LoggerFactory.getLogger(PageObject.class);

	private static final long DRIVER_WAIT_TIME = 30;
	public static WebDriver webDriver;
	public static WebDriverWait wait;

	public PageObject(WebDriver webDriver) {
		PageObject.webDriver = WebDriverHelper.getSharedDriver();
//		this.wait = new WebDriverWait(webDriver, DRIVER_WAIT_TIME);		
	}
	
    /**
     * Change the focus of webdriver for the new Opened Page
     **/
	public static void switchToLandingPage() {
		for (String landHandle : webDriver.getWindowHandles()) {
			webDriver.switchTo().window(landHandle);
		}
	}
	
    /**
     * Returns the current Url from page
     **/
    public static String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    /**
     * Returns the current page title from page
     */
    public static String getCurrentPageTitle() {
        return webDriver.getTitle();
    }

    /**
     * An expectation for checking the title of a page.
     *
     * @param title the expected title, which must be an exact match
     * @return true when the title matches, false otherwise
     */
    public static boolean checkPageTitle(String title) {
        return new WebDriverWait(webDriver, DRIVER_WAIT_TIME).until(ExpectedConditions.titleIs(title));
    }

    /**
     * An expectation for checking that the title contains a case-sensitive
     * substring
     *
     * @param title the fragment of title expected
     * @return true when the title matches, false otherwise
     */
    public boolean checkPageTitleContains(String title) {
        return new WebDriverWait(webDriver, DRIVER_WAIT_TIME).until(ExpectedConditions.titleContains(title));
    }

    /**
     * An expectation for the URL of the current page to be a specific url.
     *
     * @param url the url that the page should be on
     * @return <code>true</code> when the URL is what it should be
     */
    public boolean checkPageUrlToBe(String url) {
        return new WebDriverWait(webDriver, DRIVER_WAIT_TIME).until(ExpectedConditions.urlToBe(url));
    }

    /**
     * An expectation for the URL of the current page to contain specific text.
     *
     * @param fraction the fraction of the url that the page should be on
     * @return <code>true</code> when the URL contains the text
     */
    public boolean checkPageUrlContains(String fraction) {
        return new WebDriverWait(webDriver, DRIVER_WAIT_TIME).until(ExpectedConditions.urlContains(fraction));
    }

    /**
     * Expectation for the URL to match a specific regular expression
     *
     * @param regex the regular expression that the URL should match
     * @return <code>true</code> if the URL matches the specified regular expression
     */

    public boolean checkPageUrlMatches(String regex) {
        return new WebDriverWait(webDriver, DRIVER_WAIT_TIME).until(ExpectedConditions.urlMatches(regex));
    }

    /**
     * Find the dynamic element wait until its visible for a specified time
     *
     * @param by                Element location found by css, xpath, id etc...
     * @param waitTimeInSeconds max time to wait until element is visible
     **/
        
    public static WebElement waitForExpectedElement(final By by) {
		try {
			WebDriverWait wait = new WebDriverWait(webDriver, DRIVER_WAIT_TIME);
			return wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (TimeoutException e) {
			LOG.info(e.getMessage());
			return null;
		}
	}

	public WebElement waitForExpectedElement(final By by, long waitTimeInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(webDriver, waitTimeInSeconds);
			return wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (NoSuchElementException e) {
			LOG.info(e.getMessage());
			return null;
		} catch (TimeoutException e) {
			LOG.info(e.getMessage());
			return null;
		}
	}

    /**
     * An expectation for checking if the given text is present in the specified element.
     *
     * @param element the WebElement
     * @param text    to be present in the element
     * @return true once the element contains the given text
     */
    public boolean textToBePresentInElement(WebElement element, String text) {
        return new WebDriverWait(webDriver, DRIVER_WAIT_TIME).until(ExpectedConditions.textToBePresentInElement(element, text));
    }


    /**
     * An expectation for checking if the given text is present in the element that matches
     * the given locator.
     *
     * @param by   used to find the element
     * @param text to be present in the element found by the locator
     * @return true once the first element located by locator contains the given text
     */
    public boolean textToBePresentInElementLocated(final By by, final String text) {
        return new WebDriverWait(webDriver, DRIVER_WAIT_TIME).until(ExpectedConditions.textToBePresentInElementLocated(by, text));
    }


    /**
     * An expectation for checking if the given text is present in the specified
     * elements value attribute.
     *
     * @param element the WebElement
     * @param text    to be present in the element's value attribute
     * @return true once the element's value attribute contains the given text
     */
    public boolean textToBePresentInElementValue(final WebElement element, final String text) {
        return new WebDriverWait(webDriver, DRIVER_WAIT_TIME).until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }


    /**
     * An expectation for checking if the given text is present in the specified
     * elements value attribute.
     *
     * @param by   used to find the element
     * @param text to be present in the value attribute of the element found by the locator
     * @return true once the value attribute of the first element located by locator contains
     * the given text
     */
    public boolean textToBePresentInElementValue(final By by, final String text) {
        return new WebDriverWait(webDriver, DRIVER_WAIT_TIME).until(ExpectedConditions.textToBePresentInElementValue(by, text));
    }


    /**
     * An expectation for checking whether the given frame is available to switch
     * to. <p> If the frame is available it switches the given driver to the
     * specified frame.
     *
     * @param frameLocator used to find the frame (id or name)
     */
    public static WebDriver frameToBeAvailableAndSwitchToIt(final String frameLocator) {
        return new WebDriverWait(webDriver, DRIVER_WAIT_TIME).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }


    /**
     * An expectation for checking whether the given frame is available to switch
     * to. <p> If the frame is available it switches the given driver to the
     * specified frame.
     *
     * @param by used to find the frame
     */
    public static WebDriver frameToBeAvailableAndSwitchToIt(final By by) {
        return new WebDriverWait(webDriver, DRIVER_WAIT_TIME).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }


    /**
     * An expectation for checking that an element is either invisible or not
     * present on the DOM.
     *
     * @param by used to find the element
     */
    public boolean invisibilityOfElementLocated(By by) {
        return (new WebDriverWait(webDriver, DRIVER_WAIT_TIME)).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    /**
     * An expectation for checking that an element with text is either invisible
     * or not present on the DOM.
     *
     * @param by   used to find the element
     * @param text of the element
     */
    public boolean invisibilityOfElementWithText(final By by, final String text) {
        return (new WebDriverWait(webDriver, DRIVER_WAIT_TIME)).until(ExpectedConditions.invisibilityOfElementWithText(by, text));
    }


    /**
     * An expectation for checking an element is visible and enabled such that you
     * can click it.
     *
     * @param by used to find the element
     * @return the WebElement once it is located and clickable (visible and enabled)
     */
    public WebElement elementToBeClickable(By by) {
        return (new WebDriverWait(webDriver, DRIVER_WAIT_TIME)).until(ExpectedConditions.elementToBeClickable(by));
    }


    /**
     * An expectation for checking an element is visible and enabled such that you
     * can click it.
     *
     * @param element the WebElement
     * @return the (same) WebElement once it is clickable (visible and enabled)
     */

    public WebElement elementToBeClickable(final WebElement element) {
        return (new WebDriverWait(webDriver, DRIVER_WAIT_TIME)).until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * Wait until an element is no longer attached to the DOM.
     *
     * @param element The element to wait for.
     * @return false is the element is still attached to the DOM, true
     * otherwise.
     */
    public boolean stalenessOf(final WebElement element) {
        return (new WebDriverWait(webDriver, DRIVER_WAIT_TIME)).until(ExpectedConditions.stalenessOf(element));
    }

    /**
     * An expectation for checking if the given element is selected.
     */
    public boolean elementToBeSelected(final By by) {
        return (new WebDriverWait(webDriver, DRIVER_WAIT_TIME)).until(ExpectedConditions.elementToBeSelected(by));
    }

    /**
     * An expectation for checking if the given element is selected.
     */
    public boolean elementToBeSelected(final WebElement element) {
        return (new WebDriverWait(webDriver, DRIVER_WAIT_TIME)).until(ExpectedConditions.elementToBeSelected(element));
    }

    /**
     * An expectation for checking if the given element is selected.
     */
    public boolean elementSelectionStateToBe(final WebElement element, final boolean selected) {
        return (new WebDriverWait(webDriver, DRIVER_WAIT_TIME)).until(ExpectedConditions.elementSelectionStateToBe(element, selected));
    }

    /**
     * An expectation for checking if the given element is selected.
     */
    public boolean elementSelectionStateToBe(final By by,
                                             final boolean selected) {
        return (new WebDriverWait(webDriver, DRIVER_WAIT_TIME)).until(ExpectedConditions.elementSelectionStateToBe(by, selected));
    }

    public void waitForAlert() {
        (new WebDriverWait(webDriver, DRIVER_WAIT_TIME)).until(ExpectedConditions.alertIsPresent());
    }

    /**
     * An expectation for checking that all elements present on the web page that
     * match the locator are visible. Visibility means that the elements are not
     * only displayed but also have a height and width that is greater than 0.
     *
     * @param by used to find the element
     * @return the list of WebElements once they are located
     */
    public List<WebElement> visibilityOfAllElementsLocatedBy(final By by) {
        return (new WebDriverWait(webDriver, DRIVER_WAIT_TIME)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }


    /**
     * An expectation for checking that all elements present on the web page that
     * match the locator are visible. Visibility means that the elements are not
     * only displayed but also have a height and width that is greater than 0.
     *
     * @param elements list of WebElements
     * @return the list of WebElements once they are located
     */
    public List<WebElement> visibilityOfAllElements(final List<WebElement> elements) {
        return (new WebDriverWait(webDriver, DRIVER_WAIT_TIME)).until(ExpectedConditions.visibilityOfAllElements(elements));
    }


    /**
     * An expectation for checking that there is at least one element present on a
     * web page.
     *
     * @param by used to find the element
     * @return the list of WebElements once they are located
     */
    public List<WebElement> presenceOfAllElementsLocatedBy(final By by) {
        return (new WebDriverWait(webDriver, DRIVER_WAIT_TIME)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    /**
     * An expectation for checking that an element, known to be present on the DOM
     * of a page, is visible. Visibility means that the element is not only
     * displayed but also has a height and width that is greater than 0.
     *
     * @param element the WebElement
     * @return the (same) WebElement once it is visible
     */

    public WebElement visibilityOf(final WebElement element) {
        return (new WebDriverWait(webDriver, DRIVER_WAIT_TIME)).until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * An expectation for checking that an element is present on the DOM of a
     * page. This does not necessarily mean that the element is visible.
     *
     * @param by used to find the element
     * @return the WebElement once it is located
     */
    public boolean isElementPresent(final By by) {
        try {
            new WebDriverWait(webDriver, DRIVER_WAIT_TIME).until(ExpectedConditions.presenceOfElementLocated(by));

        } catch (TimeoutException exception) {
            LOG.info(exception.getMessage());
            return false;
        }
        return true;
    }


    public WebDriver getBrowserByPageTitle(String pageTitle) {
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver = webDriver.switchTo().window(windowHandle);
            if (pageTitle.equalsIgnoreCase(webDriver.getTitle())) {
                return webDriver;
            }
        }
        return null;
    }


    public void navigateToPreviousPageUsingBrowserBackButton() {
        webDriver.navigate().back();
    }

    public void clickWithinElementWithXYCoordinates(WebElement webElement, int x, int y) {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(webElement, x, y);
        builder.click();
        builder.perform();
    }

    public String getElementByTagNameWithJSExecutor(String tagName) {
        return ((JavascriptExecutor) webDriver).executeScript("return window.getComputedStyle(document.getElementsByTagName('" + tagName + "')").toString();
    }

    public String getElementByQueryJSExecutor(String cssSelector) {
        return ((JavascriptExecutor) webDriver).executeScript("return window.getComputedStyle(document.querySelector('" + cssSelector + "')").toString();
    }

    /**
     * Wrapper for driver.findElement
     *
     * @param by Element location found by css, xpath, id etc...
     **/
    public WebElement element(final By by) {
        return webDriver.findElement(by);
    }

    /**
     * Wrapper for clear data and sendKeys in Input Text box
     *
     * @param by        Element location found by css, xpath, id etc...
     * @param inputText text to be entered
     **/

    public void clearEnterText(By by, String inputText) {
        element(by).clear();
        element(by).sendKeys(inputText);
    }

    /**
     * Wrapper for wait, clear data and sendKeys in Input Text box
     * <p>
     * * @param by Element location found by css, xpath, id etc...
     *
     * @param inputText text to be entered
     **/
    public void waitClearEnterText(By by, String inputText) {
        waitForExpectedElement(by).clear();
        element(by).sendKeys(inputText);

    }

}
