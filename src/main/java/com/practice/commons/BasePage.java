package com.practice.commons;

import com.practice.constants.GlobalConstants;

import com.practice.driver.manager.DriverManager;
import com.practice.enums.pages.CommonBtn;
import com.practice.pageUI.pages.BasePageUI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author tuyen
 */

/**
 * @author tuyen
 */
public class BasePage {

    public static BasePage getBasePageObject() {
        return new BasePage();
    }

    public void openPageUrl(String pageUrl) {
        DriverManager.getDriver().get(pageUrl);
    }

    public String getTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public String getPageUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }

    public void goBackPreviousPage() {
        DriverManager.getDriver().navigate().back();
    }

    public String getPageSource() {
        return DriverManager.getDriver().getPageSource();
    }

    public void backToPage() {
        DriverManager.getDriver().navigate().back();
    }

    public void forwardToPage() {
        DriverManager.getDriver().navigate().forward();
    }

    public void refreshCurrentPage() {
        DriverManager.getDriver().navigate().refresh();
    }

    public Set<Cookie> getAllCookies() {
        return DriverManager.getDriver().manage().getCookies();
    }

    public void setCookies(Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            DriverManager.getDriver().manage().addCookie(cookie);
        }
        sleepInsecond(3);
    }

    public Alert waiForAlertPresence() {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        waiForAlertPresence().accept();
    }

    public void cancelAlert() {
        waiForAlertPresence().dismiss();
    }

    public String getAlertText() {
        return waiForAlertPresence().getText();
    }

    public void sendKeyToAlert(String textValue) {
        waiForAlertPresence().sendKeys(textValue);
    }

    public void switchToWindowByID(String windowID) {
        Set<String> allWindowIDs = DriverManager.getDriver().getWindowHandles();

        for (String id : allWindowIDs) {
            if (!id.equals(windowID)) {
                DriverManager.getDriver().switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWindowByTitle(String expectedPageTitle) {
        Set<String> allWindows = DriverManager.getDriver().getWindowHandles();

        for (String window : allWindows) {
            DriverManager.getDriver().switchTo().window(window);
            String actualPageTitle = DriverManager.getDriver().getTitle().trim();
            if (expectedPageTitle.equals(actualPageTitle)) {
                break;
            }
        }
    }

    public void closeWindowByID(String currentPageID) {
        Set<String> allWindows = DriverManager.getDriver().getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(currentPageID)) {
                DriverManager.getDriver().switchTo().window(window);
                DriverManager.getDriver().close();
            }
        }
        DriverManager.getDriver().switchTo().window(currentPageID);
    }

    public void clickToElementByJS(By by) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        jsExecutor.executeScript("arguments[0].click();", DriverManager.getDriver().findElement(by));
    }

    public String getElementValueByJsXpath(String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        return (String) jsExecutor.executeScript("return (document.evaluate(\"" + xpathLocator + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).value");
    }

    public void clickToElement(By by) {
        if (DriverManager.getDriver().toString().contains("internet explorer")) {
            clickToElementByJS(by);
            sleepInsecond(3);
        } else {
            DriverManager.getDriver().findElement(by).click();
        }
    }

    public void clickToElementWithWait(By by) {
        waitForElementClickable(by);
        if (DriverManager.getDriver().toString().contains("internet explorer")) {
            clickToElementByJS(by);
            sleepInsecond(3);
        } else {
            DriverManager.getDriver().findElement(by).click();
        }
    }

    public By replaceTextInXpath(String locator, String replace) {
        return By.xpath(String.format(locator, replace));
    }

    public void sendKeyToElement(By by, String textValue) {
        if (!textValue.isEmpty()) {
            WebElement element = DriverManager.getDriver().findElement(by);
            clearValueInElementByDeleteKey(by);
            element.sendKeys(textValue);
        }
    }

    public void clearValueInElementByDeleteKey(By by) {
        WebElement element = DriverManager.getDriver().findElement(by);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public static String getElementText(By by, Function<WebElement, String> textFunction) {
        return textFunction.apply(DriverManager.getDriver().findElement(by));
    }

    public static void select(By by, Consumer<Select> consumer) {
        consumer.accept(new Select(DriverManager.getDriver().findElement(by)));
    }

    public static boolean isPresentOrSelectedOrEnabled(By by, Predicate<WebElement> elementPredicate) {
        return elementPredicate.test(DriverManager.getDriver().findElement(by));
    }

    public void scrollToElement(By by) {
        WebElement element = DriverManager.getDriver().findElement(by);
        JavascriptExecutor jsExcutor = (JavascriptExecutor) DriverManager.getDriver();
        jsExcutor.executeScript("arguments[0].scrollIntoView(true);", element);
        sleepInsecond(1);
    }

    public void selectItemDropDown(By parentBy, By childBy, String expecteditem) {
        DriverManager.getDriver().findElement(parentBy).click();
        sleepInsecond(1);

        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(childBy));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expecteditem)) {
                if (item.isDisplayed()) {
                    item.click();
                } else {
                    JavascriptExecutor jsExcutor = (JavascriptExecutor) DriverManager.getDriver();
                    jsExcutor.executeScript("arguments[0].scrollIntoView(true);", item);
                    sleepInsecond(1);
                    item.click();
                }
                break;
            }
        }
    }

    public static String getAttribute(By by, Function<WebElement, String> attributeFunction) {
        return attributeFunction.apply(DriverManager.getDriver().findElement(by));
    }

    public static String getText(By by, Function<WebElement, String> textFunction) {
        return textFunction.apply(DriverManager.getDriver().findElement(by));
    }

    public void sleepInsecond(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void waitForElementVisible(By by) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForAllElementVisible(By by) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitForElementInvisible(By by) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForAllElementInvisible(By by) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(DriverManager.getDriver().findElements(by)));
    }

    public void scrollToBottomPage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void waitForElementClickable(By by) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public boolean isJSLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jsLoad);
    }

    public void uploadMultipleFiles(String... fileNames) {
        // Đường dẫn của thư mục upload File
        String filePath = GlobalConstants.getGlobalConstants().getUploadFile();

        // Đường dẫn của tất cả các file
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        DriverManager.getDriver().findElement(BasePageUI.UPLOAD_FILE).sendKeys(fullFileName);
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(999999);
    }

    public String getHeaderName() {
        waitForElementVisible(BasePageUI.HEADER_NAME);
        return getText(BasePageUI.HEADER_NAME, WebElement::getText);
    }

    public void clickToSaveBtn() {
        By locator = replaceTextInXpath(BasePageUI.COMMON_BTN, CommonBtn.SAVE.getBtnName());
        clickToElementWithWait(locator);
    }

    public void clickToSearchBtn() {
        By locator = replaceTextInXpath(BasePageUI.COMMON_BTN, CommonBtn.SEARCH.getBtnName());
        clickToElementWithWait(locator);
    }

    public void clickToAddBtn() {
        By locator = replaceTextInXpath(BasePageUI.COMMON_BTN, CommonBtn.ADD.getBtnName());
        clickToElementWithWait(locator);
    }

    private long longTimeout = GlobalConstants.getGlobalConstants().getLongTimeout();
    private long shortTimeout = GlobalConstants.getGlobalConstants().getShortTimeout();
}
