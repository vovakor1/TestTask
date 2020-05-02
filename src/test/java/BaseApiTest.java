import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest extends BaseTest {
    @Override
    @BeforeMethod
    public void before() throws WebDriverException {
        log.info("----------------------------------------");
        log.info("============ PRECONDITIONS =============");
        log.info("----------------------------------------");
    }

    @Override
    @AfterMethod
    public void afterMethod(ITestContext testContext, ITestResult testResult) {
        log.info("----------------------------------------");
        log.info("=== TEST '%1$s' '%2$s' ===", testContext.getName(), getStatusName(testResult.getStatus()));
        log.info("----------------------------------------");
    }
}