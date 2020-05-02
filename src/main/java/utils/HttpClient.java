package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import java.net.HttpURLConnection;
import java.util.Map;

public class HttpClient {

    public static ResponseBody sendRequest(String method, String url, String urlEnding, Map headers, Object data) {
        RestAssured.baseURI = url;
        RequestSpecification httpRequest = RestAssured.given();

        if (headers != null) {
            httpRequest.headers(headers);
        }

        if (data != null) {
            httpRequest.body(data);
        }

        String fullUrl = new StringBuilder(url).append(urlEnding).toString();
        Response httpResponse = null;

        switch (method) {
            case "POST": httpResponse = httpRequest.post(fullUrl);
            break;
            case "PUT": httpResponse = httpRequest.put(fullUrl);
            break;
            default: throw new NullPointerException("Method not found");
        }

        httpResponse.then().assertThat().statusCode(HttpURLConnection.HTTP_OK);

        return httpResponse.getBody();
    }
}