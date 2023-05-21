import client.impl.ApiClientImpl;
import org.json.JSONObject;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ApiClientImpl client = new ApiClientImpl();

        String response = client.createStory("hola");

        JSONObject jsonObject = new JSONObject(response);

        System.out.println(jsonObject.get("quote"));


    }


}
