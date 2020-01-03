package Pages.ServerPress.API.RestAssured;


import API.postRequests.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

public class PostReq {


    @Before
    public void setup(){
        RestAssured.baseURI="https://petstore.swagger.io";
        RestAssured.basePath="v2/pet";


        given().header("Accept","application/json");
    }


    @Test
    public void createPet(){


        pet pet = new pet();
        pet.setName("love");
        pet.setStatus("sold");

        given().request().contentType(ContentType.JSON).body(pet).when().post()
                .then().statusCode(200);
    }

    public void createPetUsingMap(){


        Map<String , Object> petMap = new HashMap<>();
        petMap.put("name","love");
        petMap.put("status","sold");


//        pet pet = new pet();
//        pet.setName("love");
//        pet.setStatus("sold");

        given().request().contentType(ContentType.JSON).body(petMap).when().post()
                .then().statusCode(200);
    }


    @Test
    public void createUser(){
        User user = new User();
        user.setName("Sm");
        user.setJob("SD");

        Map<String , Object> createUser = new HashMap<>();
        createUser.put("name","Jan");
        createUser.put("job","SDET");

        with().contentType(ContentType.JSON).body(user).when().post()
                .then().statusCode(HttpStatus.SC_CREATED);
    }
    @Test
    public void createUserWithMap(){
        Map<String , Object> createUser = new HashMap<>();
        createUser.put("name","Jan");
        createUser.put("job","SDET");

       with().contentType(ContentType.JSON).body(createUser).when().post()
                .then().statusCode(HttpStatus.SC_CREATED);
    }
}
