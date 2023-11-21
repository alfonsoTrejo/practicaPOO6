/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.practica6;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashSet;
import org.json.JSONObject;

public class Practica6 {

    private static HashSet<String> categories = new HashSet<>();
    private static HashSet<String> created_at = new HashSet<>();
    private static HashSet<String> icon_url = new HashSet<>();
    private static HashSet<String> id = new HashSet<>();
    private static HashSet<String> updated_at = new HashSet<>();
    private static HashSet<String> url = new HashSet<>();
    private static HashSet<String> value = new HashSet<>();

    public static void main(String[] args) {
        // Create an HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // Build the request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.chucknorris.io/jokes/random"))
                .build();

        // Send the request and get the response
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(Practica6::parse)
                .join();

        // Print all jokes
        System.out.println(created_at);
        System.out.println(icon_url);
        System.out.println(id);
        System.out.println(updated_at);
        System.out.println(url);
        System.out.println(value);
    }

    // Parse and extract the joke from JSON, and add to HashSet
    public static void parse(String responseBody) {
        JSONObject joke = new JSONObject(responseBody);
      //  categories.add(joke.getString("categories"));
        created_at.add(joke.getString("created_at"));
        icon_url.add(joke.getString("icon_url"));
        id.add(joke.getString("id"));
        updated_at.add(joke.getString("updated_at"));
        url.add(joke.getString("url"));
        value.add(joke.getString("value"));
    }
}