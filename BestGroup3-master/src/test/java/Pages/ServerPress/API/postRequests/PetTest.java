package Pages.ServerPress.API.postRequests;

import API.RestAssured.pet;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PetTest {


    @Test
    public void createAPet() throws IOException, URISyntaxException {

Category category = new Category(111,"paw patrol");
List<String > photoUrls = new ArrayList<>();
photoUrls.add("www.google.com");

Tags tags = new Tags();
tags.setName("tags name");
tags.setId(999);

List<Tags> tagsList = new ArrayList<>();
tagsList.add(tags);



 //pet pet = new pet(789,"patel",photoUrls,tagsList,"sold");

        pet pet=new pet(888,category,"pupsik",photoUrls,tagsList,"avaiable");

        ObjectMapper objectMapper = new ObjectMapper();
        //set object pretty print properly

        objectMapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);

        //serialize pet object into json
        objectMapper.writeValue(new File("src/test/java/API/postRequests/pet.json"),pet);


        // http client is like Postman
        HttpClient httpClient = HttpClientBuilder.create().build();


        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")// schema or protocol
                .setHost("petstore.swagger.io")// host or domain
                .setPath("v2/pet");// path parameter

        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("Accept","application/json");


        //created an object
      //  pojoStatics pojoStatics1= new pojoStatics("jan","Kyrgyz",26,"left Winger",
       //         10000,"Arsenal",99);
      //  ObjectMapper objectMapper = new ObjectMapper();

        //serialized object to json
        String json = objectMapper.writeValueAsString(pet);



        //constructed post request body
        StringEntity entity = new StringEntity(json);

        //set post request body
        httpPost.setEntity(entity);


        HttpResponse response =  httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());


      pet createdPet =  objectMapper.readValue(response.getEntity().getContent(),pet.class);

      Assert.assertEquals(pet.getName(),createdPet.getName());
      Assert.assertEquals(pet.getId(),createdPet.getId());





    }
}
