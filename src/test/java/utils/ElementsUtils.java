package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ElementsUtils {
    WebDriver driver;

    public ElementsUtils(WebDriver driver) {

        this.driver = driver;


    }

    //methodes Wait
    public WebElement waitForElement(WebElement element, long durationInSeconds) {
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Throwable e) {
            System.out.println("non-clickable element ");
        }
        return webElement;
    }

    public WebElement WaitForVisibility(WebElement element, long durationInSeconds) {
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Throwable e) {
            System.out.println("non-visible element");
        }
        return webElement;
    }

    public Alert waitForalert(long durationInSeconds) {
        Alert alert = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            alert = wait.until(ExpectedConditions.alertIsPresent());
        } catch (Throwable e) {
            System.out.println("alert is not present");
        }
        return alert;

    }

    // Autres methodes
    public void ClickOnElement(WebElement element, long durationInSeconds) {
        WebElement webelement = waitForElement(element, durationInSeconds);
        webelement.click();
    }

    public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
        WebElement webElement = WaitForVisibility(element, durationInSeconds);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
    }

    //méthodes alert
    public void acceptAlert(long durationInSeconds) {
        Alert alert = waitForalert(durationInSeconds);
        alert.accept();
    }

    public void dismissAlert(long durationInSeconds) {
        Alert alert = waitForalert(durationInSeconds);
        alert.dismiss();
    }

    //Méthode select
    public void selectOptionByVisibleText(WebElement element, String dropDownOption, long durationInSeconds) {
        WebElement webElement = waitForElement(element, durationInSeconds);
        Select select = new Select(webElement);
        select.selectByVisibleText(dropDownOption);
    }

    public void selectOptionByValue(WebElement element, String dropDownOption, long durationInSeconds) {
        WebElement webElement = waitForElement(element, durationInSeconds);
        Select select = new Select(webElement);
        select.selectByValue(dropDownOption);
    }

    //window
    public void returnToParentWindow() {

        String parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();

        Iterator<String> I1 = s.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(parent);
    }

    //Méthode JavaScript
    //1-click sur un element
    public void javaScriptClick(WebElement element, long durationInSecond) {
        WebElement webElement = WaitForVisibility(element, durationInSecond);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].click();", webElement);
    }

    //2-saisir un text
    public void javaScriptType(WebElement element, long durationInSecond, String textToBeTyped) {
        WebElement webElement = WaitForVisibility(element, durationInSecond);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].value='" + textToBeTyped + "'", webElement);
    }

    //3- défiler la page jusqu'à ce que l'élément spécifié soit visible
    public void javaScriptscrollToElement(WebElement element, String textToBeTyped) {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //4-défiler la page vers le bas d'un nombre spécifié de pixels
    public void javaScriptscrollByPixels(int pixels) {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollBy(0," + pixels + ");");
    }

    //5-défiler la page jusqu'à la fin (bas) de la page.
    public void javaScriptscrollToBottom() {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //6-défiler la page jusqu'au début (haut) de la page.
    public void javaScriptscrollToElement() {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollTo(0, 0)");
    }

    //7-methodes de validation
    public void validation1(String message) {
        String pagecontent = driver.findElement(By.tagName("html")).getText();
        List<String> motrechrche = new ArrayList<>();
        motrechrche.add(message);
        for (String mot : motrechrche) {
            if (pagecontent.contains(mot)) {
                System.out.println("le mot " + mot + "  existe sur la page");
            } else {
                System.out.println("le mot " + mot + " n'existe pas sur la page");
            }

        }


    }
    //8- methode de la confirmation
    public void confirmation (String lien){
        String ExpectedURL = lien;
        String ActuallURL = driver.getCurrentUrl();
        Assert.assertEquals(ActuallURL, ExpectedURL);

    }
}


