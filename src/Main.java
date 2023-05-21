import client.impl.ApiClientImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpResponse;


public class Main {
    public static void main(String[] args) {
        String endpoint = "https://api.openai.com/v1/completions";
        String apiKey = "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";
        int age = 8;
        String mainCharacter = "Sofía";
        String themeOne = "hadas";
        String themeTwo = "brujas";
        String genre = "fantasia";
        String input =  "\"Crea una hermosa historia de " + genre + " para niños de " + age + " años con un protagonista llamado " +
                mainCharacter + " sobre " + themeOne + " y " + themeTwo + "\"  ";

        String requestBody = "{\n" +
                "    \"model\": \"text-davinci-003\",\n" +
                "    \"prompt\":" + input + ",\n" +
                "    \"max_tokens\": 2046,\n" +
                "    \"temperature\": 0\n" +
                "}";
        try {
            ApiClientImpl client = new ApiClientImpl();
            System.out.println(input);
            HttpResponse<String> response = client.createStory(endpoint, apiKey, requestBody);

            String responseBody = response.body();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(responseBody);

            JsonNode storyResponse = rootNode.get("choices").get(0).get("text");
            String story = storyResponse.asText();

            System.out.println(story);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}