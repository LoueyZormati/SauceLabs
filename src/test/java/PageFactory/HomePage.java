package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(id = "react-burger-menu-btn")
    WebElement Menu ;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement AddProductbackpack ;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement AddProductbikelight ;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement AddProductTshirt;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement Cart ;
    @FindBy(id = "logout_sidebar_link")
    WebElement Logout ;
    WebDriver driver ;
    public HomePage(WebDriver driver){
        this.driver= driver ;
        PageFactory.initElements(driver,this);

    }

    public void setMenu() {
        Menu.click();
    }
    public void setAddProductbackpack() {
        AddProductbackpack.click();
    }
    public void setAddProductbikelight() {
        AddProductbikelight.click();
    }
    public void setAddProductTshirt() {
        AddProductTshirt.click();
    }
    public void setCart() {
       Cart.click();
    }
    public void setLogout() {
       Logout.click();
    }


}
