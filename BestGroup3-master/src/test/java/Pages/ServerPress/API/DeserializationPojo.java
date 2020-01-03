package Pages.ServerPress.API;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class DeserializationPojo {


    @Test
    public void getFactById() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder()
           .setScheme("http")// schema or protocol
                .setHost("cat-fact.herokuapp.com")// host or domain
                .setPath("facts/58e008b80aac31001185ed0d");// path parameter
        // .setCustomQuery("page=2");//query parameter


        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);
        ObjectMapper objectMapper = new ObjectMapper();
        FactPojo factPojo =  objectMapper.readValue(response.getEntity().getContent(),FactPojo.class);
        System.out.println(factPojo.getText());

        System.out.println("this is my _v " + factPojo.get__v());
        System.out.println("this is my id " + factPojo.get_id());
        System.out.println("this is my create date " + factPojo.getCreatedAt());
        System.out.println("this is my source " + factPojo.getSource());
        System.out.println("this is my type "+ factPojo.getType());
        System.out.println("this is my delete date" + factPojo.getDeleted());



    }
    @Test
    public void getAll() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("https")// schema or protocol
                .setHost("petstore.swagger.io")// host or domain
                .setPath("v2/pet/1");// path parameter
        // .setCustomQuery("page=2");//query parameter


//        HttpGet httpGet = new HttpGet(uriBuilder.build());
//        httpGet.addHeader("Accept", "application/json");
//        HttpResponse response = httpClient.execute(httpGet);
//        ObjectMapper objectMapper = new ObjectMapper();
//        PojoPet pojoPet = objectMapper.readValue(response.getEntity().getContent(),PojoPet.class);
//       // System.out.println(pojoPet);
//
//        System.out.println(pojoPet.getName());
//        System.out.println(pojoPet.getCategory().getId());
//        System.out.println(pojoPet.getCategory().getName());
//        System.out.println(pojoPet.getId());
//        System.out.println(pojoPet.getPhotoUrls());
//        System.out.println(pojoPet.getStatus());
//        System.out.println(pojoPet.getTags());
    }
}
