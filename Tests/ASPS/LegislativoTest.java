
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class LegislativoTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void legislativo() {
    driver.get("http://10.2.1.110:8080/legislativo-proposta-emenda-loa/2024/gabinete");
    driver.findElement(By.cssSelector("#legislativo-menu > span > span")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".show > .dropdown-menu"));
      assert(elements.size() > 0);
    }
    assertThat(driver.findElement(By.cssSelector("#submenuEmendasLOAItem span")).getText(), is("Anos Anteriores - LOA 2020"));
    assertThat(driver.findElement(By.cssSelector("#submenuEmendasLOA2Item span")).getText(), is("Anos Anteriores - LOA 2021"));
    assertThat(driver.findElement(By.cssSelector("#submenuEmendasLOA3Item span")).getText(), is("Anos Anteriores - LOA 2022"));
    assertThat(driver.findElement(By.cssSelector("#submenuEmendasLOA4Item span")).getText(), is("Remanejamentos - LOA 2023"));
    assertThat(driver.findElement(By.cssSelector("#submenuEmendasLOA5Item span")).getText(), is("PLOA 2024"));
  }
}