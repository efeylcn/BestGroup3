package Pages.ServerPress.API;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class API {


    @Test
    public void firstGetCall() throws URISyntaxException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //creating  a client (like postman)
        HttpClient httpClient = HttpClientBuilder.create().build();
        //constructing URL
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet/1");
        //defining a GET method
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        //executing the api call
        HttpResponse response = httpClient.execute(httpGet); //it basically click on send button, and executes response
        Map<String, Object> firstDeserialization = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        System.out.println(firstDeserialization.get("id"));
        System.out.println(firstDeserialization.get("status"));
        Map<String, Object> categoryMap = (Map<String, Object>) firstDeserialization.get("Category");
        String name = categoryMap.get("name").toString();
        Integer id = (Integer) categoryMap.get("id");
        System.out.println(categoryMap);
        //first thing we verify is Status code.
        Assert.assertEquals(HttpStatus.SC_NOT_FOUND,
                response.getStatusLine().getStatusCode());
    }

    @Test
    public void createPet() throws URISyntaxException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        //creating  a client (like postman)
        HttpClient httpClient = HttpClientBuilder.create().build();

        //constructing URL
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet/1");


        //defining a GET method
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");


        //executing the api call
        HttpResponse response = httpClient.execute(httpGet); //it basically click on send button, and executes response

        Map<String, Object> firstDeserialization = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
        });

        System.out.println(firstDeserialization.get("id"));
        System.out.println(firstDeserialization.get("status"));
    }
}
