package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BasedriverParameter {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browserType")
    public void BaslangicIslemleri(String browserType){
       // System.out.println(" Baslangic islemleri yapiliyor");
        switch (browserType.toLowerCase()){
            case "firefox": driver=new FirefoxDriver(); break;
            case "edge": driver =new EdgeDriver(); break;

            default: driver = new ChromeDriver();
        }


        // driver.manage().window().maximize(); // ekrani max yapiyor.

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühleti
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 20 sn mühlet: elementi bulma mühleti
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));

Login();
    }
    @AfterClass
    public void KapanisIslemleri(){
        System.out.println("Kapanis Islemleri yapiliyor");

        // Tools.Bekle(3);
        driver.quit();
    }

    public void Login(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        tools.bekle(2);
        WebElement username= driver.findElement(By.xpath("//input[@placeholder='E-Mail Address']"));
        username.sendKeys("hobbiton986@gmail.com");
        tools.bekle(2);
        WebElement password= driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("Mithrandir10");
        tools.bekle(2);
        WebElement login=driver.findElement(By.xpath("//input[@value='Login']"));
        login.click();
        tools.bekle(2);

        wait.until(ExpectedConditions.titleIs("My Account"));
        Assert.assertTrue(driver.getTitle().contains("Account"), "Title de Account kelimesi yok");

    }
}
