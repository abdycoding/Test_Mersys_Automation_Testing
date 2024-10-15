import Utility.Basedriver;
import Utility.tools;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class US3 extends Basedriver {
    @Test
    public void Test(){

        TestingElements te=new TestingElements();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        String mainPage=driver.getWindowHandle();

        for (WebElement e:te.buttonsHeader){

            js.executeScript("arguments[0].click();", e);
            System.out.println(e.getText());

        }
        tools.bekle(2);

        Set<String> tabIds=driver.getWindowHandles();

        for (String id:tabIds){
            if (id.equals(mainPage)) continue; // if it is main page then pass

            driver.switchTo().window(id);

            driver.close();  // only closes the current tab
        }
        tools.bekle(2);


    }
}
