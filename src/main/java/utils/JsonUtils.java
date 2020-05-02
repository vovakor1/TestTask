package utils;

import aquality.selenium.core.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class JsonUtils {
    private static Logger log = Logger.getInstance();

    public static JSONObject getJsonFromFile(String pathToPayload) {
        JSONObject json = null;
        JSONParser jsonParser = new JSONParser();

        try {
            json = (JSONObject) jsonParser.parse(FileUtils.getFileFromResource(pathToPayload));
        } catch (ParseException | IOException e) {
            log.error(e.getMessage());
        }

        return json;
    }
}