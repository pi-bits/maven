import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class HTMLUnitDriverDemo {
    @Test
    public void testGooglePageWithHTMLUnitDriver() throws Exception {

        WebDriver driver = new HtmlUnitDriver();
        driver.get("https://www.google.co.uk");
        Thread.sleep(1000);
        Assert.assertThat("Google", CoreMatchers.is(CoreMatchers.equalTo(driver.getTitle())));
    }
}
