package Pages.ServerPress.API.postRequests;

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

public class TestUser {


    @Test
    public void createUser() throws IOException, URISyntaxException {

        User user = new User("morpheus","leader");

        ObjectMapper objectMapper = new ObjectMapper();
        //set object pretty print properly

        objectMapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);

        //serialize pet object into json
        objectMapper.writeValue(new File("src/test/java/API/postRequests/User.json"),user);

        HttpClient httpClient = HttpClientBuilder.create().build();


        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")// schema or protocol
                .setHost("reqres.in")// host or domain
                .setPath("api/users");// path parameter

        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("Accept","application/json");

        String json = objectMapper.writeValueAsString(user);



        //constructed post request body
        StringEntity entity = new StringEntity(json);

        //set post request body
        httpPost.setEntity(entity);


        HttpResponse response =  httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_CREATED,response.getStatusLine().getStatusCode());


        User createdUser =  objectMapper.readValue(response.getEntity().getContent(),User.class);

        Assert.assertEquals(user.getName(),createdUser.getName());
        Assert.assertEquals(user.getJob(),createdUser.getJob());



    }
}
