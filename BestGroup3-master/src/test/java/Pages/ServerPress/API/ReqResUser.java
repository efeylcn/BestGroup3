package Pages.ServerPress.API;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class ReqResUser {


    @Test
    public void getUsers() throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();


        //  objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        //creating  a client (like postman)
        HttpClient httpClient = HttpClientBuilder.create().build();
        //constructing URL
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/unknown");
        //defining a GET method
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        //executing the api call
        HttpResponse response = httpClient.execute(httpGet);

        //deserialation using pojo
        UserPojo userPojo = objectMapper.readValue(response.getEntity().getContent(), UserPojo.class);
//        System.out.println(userPojo.getData().get(0).getEmail());
////        System.out.println(userPojo.getData().get(1).getEmail());
////        System.out.println(userPojo.getData().get(2).getEmail());
////        System.out.println(userPojo.getData().get(3).getEmail());
////        System.out.println(userPojo.getData().get(4).getEmail());
////        System.out.println(userPojo.getData().get(5).getEmail());
////
////
////
////
////        System.out.println(userPojo.getTotal_pages());
        System.out.println(userPojo.getData().get(1).getName());
        System.out.println(userPojo.getData().get(1).getYear());
    }


}
