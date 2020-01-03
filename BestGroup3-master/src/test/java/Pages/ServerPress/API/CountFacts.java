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

public class CountFacts {


    @Test
    public void countFacts() throws URISyntaxException, IOException {


        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setScheme("http")// schema or protocol
                .setHost("cat-fact.herokuapp.com")// host or domain
                .setPath("facts");// path parameter
               // .setCustomQuery("page=2");//query parameter



        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);

        // Map<String, List<Map<String, Object>>> deserObject = objectMapper.readValue(response.getEntity().getContent(),
        //

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> facts = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

        //deserialization
        List<Map<String,Object>> factList =(List<Map<String, Object>>) facts.get("all");


      //  System.out.println(factList);
        int count=0;

        for(int i=0; i<factList.size(); i++){
            String id = (String)factList.get(i).get("id");
            count ++;
            System.out.println(count);
        }



    }
}
