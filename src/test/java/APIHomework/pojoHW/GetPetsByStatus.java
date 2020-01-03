package APIHomework.pojoHW;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class GetPetsByStatus {

    @Test
    public void getPet() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("https")// schema or protocol
                .setHost("petstore.swagger.io")// host or domain
                .setPath("v2/pet/findByStatus")
                .setCustomQuery("status=pending");// path parameter
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);
        ObjectMapper objectMapper = new ObjectMapper();

       ByStatusPojo byStatusPojo = objectMapper.readValue(response.getEntity().getContent(), ByStatusPojo.class);
      int petId = byStatusPojo.getListOfPetsByStatus().getId();
      String petName = byStatusPojo.getListOfPetsByStatus().getName();

        System.out.println(petId);
        System.out.println(petName);




    }
}
