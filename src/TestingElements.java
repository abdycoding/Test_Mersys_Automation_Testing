import Utility.Basedriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestingElements {

    public TestingElements() {
        PageFactory.initElements(Basedriver.driver, this);
    }

    @FindBy(xpath = "//div[@class='ng-star-inserted']/img")
    public WebElement TechnoStudyLink;

    @FindBy(css = "[page='COURSES']>button")
    public WebElement Courses;

    @FindBy(css = "[page='CALENDAR']>button")
    public WebElement Calendar;

    @FindBy(xpath = "//student-toolbar-horizontal//button")
    public List<WebElement> buttonsHeader;
}
