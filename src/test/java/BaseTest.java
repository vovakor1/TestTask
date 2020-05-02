import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.logging.Logger;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.TestResult;
import utils.Property;

public class BaseTest {
    private static final Property PROPERTIES = new Property("/test.properties");
    final Logger log = Logger.getInstance();

    @BeforeMethod
    public void before() throws WebDriverException {
        log.info("----------------------------------------");
        log.info("============ PRECONDITIONS =============");
        getBrowser().maximize();
        getBrowser().goTo(PROPERTIES.getPropertyValue("START_URL"));
        log.info("----------------------------------------");
    }

    @AfterMethod
    public void afterMethod(ITestContext testContext, ITestResult testResult) {
        log.info("----------------------------------------");
        log.info("=== TEST '%1$s' '%2$s' ===", testContext.getName(), getStatusName(testResult.getStatus()));
        log.info("----------------------------------------");
        getBrowser().quit();
    }

    protected String getStatusName(int status){
        if(status == TestResult.SUCCESS){
            return "SUCCESS";
        }else if(status == TestResult.FAILURE){
            return "FAILURE";
        }else if(status == TestResult.SKIP){
            return "SKIP";
        }else if(status == TestResult.STARTED){
            return "STARTER";
        }else if(status == TestResult.SUCCESS_PERCENTAGE_FAILURE){
            return "SUCCESS PERCENTAGE FAILURE";
        }else {
            return "UNDEFINED STATUS ID " + status;
        }
    }

    private Browser getBrowser(){
        return AqualityServices.getBrowser();
    }
}