package client;
import java.net.http.HttpResponse;


public interface ApiClient {

       HttpResponse<String> createStory(String endpoint, String token, String requestBody) ;


}


