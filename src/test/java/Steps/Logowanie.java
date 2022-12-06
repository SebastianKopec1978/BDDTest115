package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logowanie {

    WebDriver driver;

    @Given("Uzytkownik otwiera przegladarke")
   public void  uzytkownik_otwiera_przegladarke() {
         System.out.println("Krok 1 - Uzytkownik otwiera przegladarke");
         driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

        @Given("Uzytkownik wpisuje adres strony internetowej")
        public void uzytkownik_wpisuje_adres_strony_internetowej() {
             System.out.println("Krok 2 - Uzytkownik wpisuje adres strony internetowej  ");
             driver.navigate().to("https://the-internet.herokuapp.com/login");
        }
        @When("Uzytkownik wpisuje poprawny login")
        public void uzytkownik_wpisuje_poprawny_login() {
             System.out.println("Krok 3 - Uzytkownik wpisuje poprawny login ");
             driver.findElement(By.id("username")).sendKeys("tomsmith");

        }
        @When("Uzytkownik wpisuje poprawne haslo")
        public void uzytkownik_wpisuje_poprawne_haslo() {
             System.out.println("Krok 4 - Uzytkownik wpisuje poprawne haslo  ");
             driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        }
        @When("Uzytkownik klika przycisk Login")
        public void uzytkownik_klika_przycisk_login() {
             System.out.println("Krok 5 - Uzytkownik klika przycisk Login");
             driver.findElement(By.tagName("button")).click();

        }
        @Then("Uzytkownik zostaje poprawnie zalogowany do aplikacji")
        public void uzytkownik_zostaje_poprawnie_zalogowany_do_aplikacji() {
             System.out.println("Krok 6 - Uzytkownik zostaje poprawnie zalogowany do aplikacji  ");
            Assert.assertEquals("https://the-internet.herokuapp.com/secure",driver.getCurrentUrl());
            driver.close();

        }
    }

