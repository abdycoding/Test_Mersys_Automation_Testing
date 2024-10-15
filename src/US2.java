import Utility.Basedriver;
import Utility.tools;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class US2 extends Basedriver {

    @Test
    public void Test(){

        /*
        AC_H01:
             1. The user should be logged into the system as a
            student.
             2. The user should see the company logo at the top left.
             3. The user must be directed to the https://techno.study
            page when he clicks on the company logo.

         */
        TestingElements te=new TestingElements();
        te.TechnoStudyLink.click();

        tools.bekle(3);
        String originalWindow=driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();


        for (String handle:allWindowHandles){
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                System.out.println(driver.getCurrentUrl());
                Assert.assertTrue(driver.getCurrentUrl().contains("https://techno.study/"), "The webpage doesn't match");
            }

       }
    }
}
