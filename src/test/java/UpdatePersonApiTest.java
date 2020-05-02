import api.SessionApi;
import org.testng.annotations.Test;
import utils.JsonUtils;

public class UpdatePersonApiTest extends BaseApiTest {
    private static final String TEST_FILE_PATH = "/data/api/update_person.json";
    private static final String PERSON_ID = "Person1";

    @Test
    public void run() {
        new SessionApi().sendUpdatePersonRequest(PERSON_ID, JsonUtils.getJsonFromFile(TEST_FILE_PATH));
    }
}