package StepDefinition;

import PageFactory.CartPage;
import PageFactory.HomePage;
import PageFactory.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;
import utils.ElementsUtils;

import java.util.Properties;

public class ScenarioPassant {
    private static WebDriver driver ;
    LoginPage Login ;
    HomePage Home ;
    ElementsUtils methodes ;
    CartPage cart ;
    Properties prop ;
    ConfigReader site ;




    @Given("Je me rends sur le site SwagLabs")
    public void je_me_rends_sur_le_site_swag_labs() {
        site = new ConfigReader();
        prop = site.ConfigurationManager();
        driver=new ChromeDriver();
        driver.get(site.getUrl());
        driver.manage().window().maximize();
    }
    @When("Je saisie le username")
    public void je_saisie_le_username() {
        Login=new LoginPage(driver);
        Login.setUsername(site.getusername());

    }
    @And("Je saisie le password")
    public void je_saisie_le_password() {
        Login.setPassword(site.getPassword());

    }
    @And("Je clique sur le bouton Login")
    public void je_clique_sur_le_bouton_login() {
        Login.setLoginButton();

    }
    @Then("La page des produit s affichent")
    public void la_page_des_produit_s_affichent() {
        methodes=new ElementsUtils(driver);
        methodes.confirmation("https://www.saucedemo.com/inventory.html");


    }
    @When("Je clique sur le bouton Add to cart du produit BackPack")
    public void je_clique_sur_le_bouton_add_to_cart_du_produit_back_pack() throws InterruptedException {
        Home=new HomePage(driver);
        Thread.sleep(3000);
        Home.setAddProductbackpack();

    }
    @When("Je clique sur le bouton Add to cart du produit T-Shirt")
    public void je_clique_sur_le_bouton_add_to_cart_du_produit_t_shirt() {
        Home.setAddProductTshirt();

    }
    @Then("Les produit s ajoutent dans le panier")
    public void les_produit_s_ajoutent_dans_le_panier() throws InterruptedException {
        Thread.sleep(3000);
        methodes.validation1("Remove");


    }
    @When("Je clique sur l icone panier")
    public void je_clique_sur_l_icone_panier() {
        Home=new HomePage(driver);
        Home.setCart();

    }
    @When("Je clique sur le bouton remove")
    public void je_clique_sur_le_bouton_remove() throws InterruptedException {
        cart=new CartPage(driver);
        Thread.sleep(2000);
        cart.setRemoveBachPack();

    }
    @Then("Le produit sera supprimé du panier")
    public void le_produit_sera_supprimé_du_panier() throws InterruptedException {
        methodes=new ElementsUtils(driver);
        Thread.sleep(3000);
        methodes.validation1("Sauce Labs Backpack");

    }
    @When("Je clique sur le bouton checkout")
    public void je_clique_sur_le_bouton_checkout() throws InterruptedException {
    cart=new CartPage(driver);
    methodes=new ElementsUtils(driver);
    Thread.sleep(3000);
    methodes.javaScriptscrollToBottom();
    cart.setCheckout();
    }

    @When("Je rempli le username")
    public void je_rempli_le_username() {
        cart.setFirstName("louey");

    }

    @When("Je saisie le lastname")
    public void je_saisie_le_lastname() {
        cart.setLastName("zormati");

    }

    @When("Je saisie le code postal")
    public void je_saisie_le_code_postal() {
        cart.setPostalCode("4021");

    }

    @When("je clique sur le bouton continue")
    public void je_clique_sur_le_bouton_continue() {
        cart.setButtonContinue();

    }

    @Then("une page overview s affiche")
    public void une_page_overview_s_affiche() throws InterruptedException {
        Thread.sleep(3000);
        methodes.validation1("Checkout: Overview");

    }

    @When("je clique sur le bouton finish")
    public void je_clique_sur_le_bouton_finish() {
        cart.setButtonFinish();

    }

    @Then("une page Checkout:Complete s affiche")
    public void une_page_checkout_complete_s_affiche() throws InterruptedException {
        Thread.sleep(3000);
        methodes.validation1("Checkout: Complete!");

    }
    @When("Je clique sur le menu burger")
    public void je_clique_sur_le_menu_burger() {
        Home=new HomePage(driver);
        Home.setMenu();

    }
    @When("Je clique surle bouton Logout")
    public void je_clique_surle_bouton_logout() throws InterruptedException {
        Thread.sleep(3000);
        Home.setLogout();

    }
    @Then("Je me redirige vers la page d authentification {string}")
    public void je_me_redirige_vers_la_page_d_authentification(String string) {
        methodes.confirmation("https://www.saucedemo.com/");

    }


}