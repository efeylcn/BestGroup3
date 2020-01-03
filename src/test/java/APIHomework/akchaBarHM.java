package APIHomework;

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
import java.util.Map;

public class akchaBarHM {

        @Test
        public void akchaBar() throws URISyntaxException, IOException {
            HttpClient httpClient = HttpClientBuilder.create().build();
            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme("http")
                    .setHost("rates.akchabar.kg")
                    .setPath("get.json");
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpGet.addHeader("Accept", "application/json");
            HttpResponse response = httpClient.execute(httpGet);
            ObjectMapper objectMapper = new ObjectMapper();
            Map< String,Object> rates  = objectMapper.readValue(response.getEntity().getContent(),
                    new TypeReference <Map<String,Object >>() {
                    });
            Map<String,Object> currency =(Map<String,Object>)rates.get("rates");
            System.out.println(currency);

        }
    }


