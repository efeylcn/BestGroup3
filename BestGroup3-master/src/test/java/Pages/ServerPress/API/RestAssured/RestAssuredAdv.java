package Pages.ServerPress.API.RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RestAssuredAdv {

    @Before
    public void setup(){
        RestAssured.baseURI="http://api.football-data.org/";
        RestAssured.basePath="v2";


        given().header("Accept","application/json");
    }

    @Test
    public void getCompetitions(){
        Response  response = when().get("/competitions");
        List<String > competitionsName = response.path("competitions.findAll { it.name != null }.name");

        System.out.println(competitionsName);
    }


    @Test
    public void getIdAndCount(){
        Response  response = when().get("/competitions");
        int idSum = response.path("competitions.collect { it.id }.sum()");

        System.out.println(idSum);
    }





}
