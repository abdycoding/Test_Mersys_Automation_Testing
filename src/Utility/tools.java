package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class tools {
    public static void bekle(int sn) {
        try {
            Thread.sleep(sn* 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
}
    public static void SuccessMessageValidation(){
        WebElement success= Basedriver.driver.findElement(By.xpath("//*[text()=' Success: Your newsletter subscription has been successfully updated!']"));

        Assert.assertTrue(success.getText().toLowerCase().contains("success"), "Error 404");

    }
}
