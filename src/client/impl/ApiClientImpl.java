package client.impl;

import client.ApiClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClientImpl implements ApiClient {

    @Override
    public HttpResponse<String> createStory(String endpoint, String apiKey, String requestBody) {
        try {

            HttpRequest.BodyPublisher payload = HttpRequest.BodyPublishers.ofString(requestBody);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + apiKey)
                    .POST(payload)
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

