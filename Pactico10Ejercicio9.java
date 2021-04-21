package clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Pactico10Ejercicio9 {

    private WebDriver getUrlTestDriver(String GET_ULR_TEST) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("https://www.facebook.com/");
        driver.get(GET_ULR_TEST);
        return driver;
    }

    @Test
    public void fullRegistrationTest() throws InterruptedException {
        WebDriver driver = getUrlTestDriver("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("johnsmith@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("johnsmith@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");

        setBirthdate(driver, "26", "jun", "1980");

        List<WebElement> ListaSexos = driver.findElements(By.name("sex"));

        WebElement sexMaleElement = ListaSexos.get(1);
        sexMaleElement.click();

    }

    @Test
    private void setBirthdate (WebDriver driver, String day, String month, String year) {

        WebElement dias = driver.findElement(By.name("birthday_day"));
        Select combodía = new Select(dias);
        combodía.selectByVisibleText(day);

        WebElement meses = driver.findElement(By.name("birthday_month"));
        Select comboMeses = new Select(meses);
        comboMeses.selectByVisibleText(month);

        WebElement ano = driver.findElement(By.name("birthday_year"));
        Select comboano = new Select(ano);
        comboano.selectByVisibleText(year);
    }
}
