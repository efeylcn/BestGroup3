package APIHomework;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class ApIReqres1 {


    @Test
    public void  firstGetCall() throws URISyntaxException, IOException {
//https://reqres.in/api/users?page=2

        // creating a client (like Postman)
        HttpClient httpClient = HttpClientBuilder.create().build();

        // constructing URL
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/users?page=2");

        // defining a GET method
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");

        // executing the api call
        HttpResponse response = httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK,
                response.getStatusLine().getStatusCode());

    }

    }
