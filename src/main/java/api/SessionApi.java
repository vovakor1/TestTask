package api;

import enums.DataApiEnding;
import enums.SessionApiEnding;
import io.restassured.path.json.JsonPath;
import org.json.simple.parser.JSONParser;
import io.restassured.response.ResponseBody;
import org.apache.http.entity.ContentType;
import org.json.simple.parser.ParseException;
import utils.FileUtils;
import utils.HttpClient;
import utils.Property;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SessionApi {
    private static final String LOGIN_DATA_PATH = "/data/login.json";
    private static final Property PROPERTIES = new Property("/test.properties");
    private static final String API_URL = PROPERTIES.getPropertyValue("API_LINK");
    private static final String SESSION_API_ENDING = SessionApiEnding.LOGIN.getApiEnding();
    private static final String UPDATE_API_ENDING = DataApiEnding.UPDATE_PERSON.getApiEnding();

    private String getSessionToken() {
        Object data = null;

        try {
            data = new JSONParser().parse(FileUtils.getFileFromResource(LOGIN_DATA_PATH));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        Map<String, Object> headers = new HashMap();
        headers.put("Content-Type", ContentType.APPLICATION_JSON.toString());

        ResponseBody responseBody = HttpClient.sendRequest("POST", API_URL, SESSION_API_ENDING, headers, data);
        JsonPath jsonPathEvaluator = responseBody.jsonPath();
        return jsonPathEvaluator.get("Token");
    }

    private Map<String, Object> getBasicHeaders() {
        Map<String, Object> headers = new HashMap();
        headers.put("Content-Type", ContentType.APPLICATION_JSON.toString());
        headers.put("SessionToken", getSessionToken());

        return headers;
    }

    public void sendUpdatePersonRequest(String personId, Object data) {
        Map<String, Object> headers = getBasicHeaders();

        HttpClient.sendRequest("PUT", API_URL, UPDATE_API_ENDING + personId, headers, data);
    }
}