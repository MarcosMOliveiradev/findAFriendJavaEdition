package com.marcos.findafriend.application.util;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetLocateUser {
    public String getLocate(String cep) throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI("https://viacep.com.br/ws/" + cep + "/json/");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200 ) {
            JSONObject json = new JSONObject(response.body());

            String locate = json.getString("uf");

            return locate;
        }
        return cep;
    }
}
