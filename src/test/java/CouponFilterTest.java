import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CouponFilterTest extends BaseTest {
    /*public CouponFilterTest() {
        super("http://localhost:4723/wd/hub");
    }*/

    @Test
    public void click_test() {
        appiumDriver.findElement(By.id("digit_1")).click();
        appiumDriver.findElement(By.id("op_add")).click();
        appiumDriver.findElement(By.id("digit_3")).click();
        appiumDriver.findElement(By.id("eq")).click();
        Assertions.assertEquals(appiumDriver.findElement(By.id("result")).getText(),"4");
    }
}
