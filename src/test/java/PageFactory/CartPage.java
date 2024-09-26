package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBachPack ;
    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeBikeLight ;
    @FindBy(id = "checkout")
    WebElement checkout ;
    @FindBy(id = "continue-shopping")
    WebElement continueShopping ;
    @FindBy(id = "first-name")
    WebElement FirstName ;
    @FindBy(id = "last-name")
    WebElement LastName ;
    @FindBy(id = "postal-code")
    WebElement PostalCode ;
    @FindBy(id = "continue")
    WebElement buttonContinue ;
    @FindBy(id = "finish")
    WebElement ButtonFinish ;

    WebDriver driver ;
    public CartPage(WebDriver driver){
        this.driver= driver ;
        PageFactory.initElements(driver,this);

    }

    public void setRemoveBikeLight() {
        removeBikeLight.click();
    }
    public void setRemoveBachPack() {
        removeBachPack.click();
    }

    public void setCheckout() {
        checkout.click();
    }

    public void setContinueShopping() {
     continueShopping.click();
    }

    public void setFirstName(String firstName) {
        FirstName.sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        LastName.sendKeys(lastName);
    }
    public void setPostalCode(String postalCode) {
        PostalCode.sendKeys(postalCode);
    }

    public void setButtonFinish() {
        ButtonFinish.click();
    }

    public void setButtonContinue() {
       buttonContinue.click();
    }
}
