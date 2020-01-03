package Pages.ServerPress.API.postRequests;

import API.Serialization.pojoStatics;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class PostReqIntro {

    @Test
    public void createAPet() throws URISyntaxException, IOException {


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
        pojoStatics pojoStatics1= new pojoStatics("jan","Kyrgyz",26,"left Winger",
                10000,"Arsenal",99);
        ObjectMapper objectMapper = new ObjectMapper();

        //serialized object to json
        String json = objectMapper.writeValueAsString(pojoStatics1);



        //constructed post request body
        StringEntity entity = new StringEntity(json);

        //set post request body
        httpPost.setEntity(entity);


      HttpResponse response =  httpClient.execute(httpPost);



    }
}
