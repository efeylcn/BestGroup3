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

public class verify {

    @Test
    public void getPetByStatus() throws IOException, URISyntaxException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")// schema or protocol
                .setHost("petstore.swagger.io")// host or domain
                .setPath("v2/pet/findByStatus")// path parameter
         .setCustomQuery("status=jan");//query parameter

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });


        Map<String,Object> categoryData =(Map<String, Object>) map.get("category");
       String  categoryName= (String) categoryData.get("name");
        System.out.println("Ctegory Name"+categoryName);

        String name= (String)map.get("name");
        System.out.println("regular name"+name);
        Map<String,Object> tagsData =(Map<String, Object>) map.get("tags");

        String tagName = (String) tagsData.get("name");
        System.out.println("tag name");

//        String name = (String)singleUser.get("name");
//        String status = (String)singleUser.get("status");
//        System.out.println(name+status);

    }
}
