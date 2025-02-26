package automation.tests;



import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class checkString extends BaseTest {

    @Test
    public void string1Search() {
        String s = "next →";
        driver.get("https://www.tpointtech.com/sql-outer-join");
        List<WebElement> texts = driver.findElements(By.xpath("//*[text()='" + s + "']"));
        if (texts.size() > 0) {
            System.out.println("String "+s+"is present");
        } else {
            System.out.println("String "+s+"is not present");
        }
        tearDown();
     }
    
}
