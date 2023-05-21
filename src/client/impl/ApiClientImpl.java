package client.impl;

import java.io.IOException;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;

public class ApiClientImpl {

    public String createStory(String parameter) {

        String result = null;
        try {
            Response response = Request.get("https://api.kanye.rest/").execute();
            result = response.returnContent().asString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }
}

