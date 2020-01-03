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

public class DeserializationINtro {

    @Test
    public void getALLUsername() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")// schema or protocol
        .setHost("reqres.in")// host or domain
                .setPath("api/users")// path parameter
        .setCustomQuery("page=2");//query parameter

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> allUsers = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
        });

        //deserialization
        List<Map<String,Object>> userDataList =(List<Map<String, Object>>) allUsers.get("data");

        System.out.println(userDataList);
        for(int i=0; i<userDataList.size(); i++){
            String firstName = (String)userDataList.get(i).get("first_name");
            System.out.println(firstName);
        }


    }
}
