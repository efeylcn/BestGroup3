package Pages.ServerPress.API;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class user5 {


    @Test
    public void getuser5() throws IOException, URISyntaxException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")// schema or protocol
                .setHost("reqres.in")// host or domain
                .setPath("api/users/5");// path parameter
               // .setCustomQuery("5");//query parameter

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> userData = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });


        Map<String,Object> singleUser =(Map<String, Object>) userData.get("data");
        System.out.println(singleUser);

        String name = (String)singleUser.get("first_name");
        String lastName = (String)singleUser.get("last_name");
        System.out.println(name+lastName);



    }
}
