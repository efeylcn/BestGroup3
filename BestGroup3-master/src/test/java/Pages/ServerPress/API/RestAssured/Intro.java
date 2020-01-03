package Pages.ServerPress.API.RestAssured;

import API.FactPojo;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.mapper.TypeRef;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Intro {


    @Before
    public void setup(){
        RestAssured.baseURI="https://reqres.in";
        RestAssured.basePath="api/users";


        given().header("Accept","application/json");
    }


    @Test
    public void restGet(){
        when().get("/1").then().statusCode(200);
    }
    @Test
    public void restGetWithLogs(){

        when().get("/1").then().statusCode(200).log().all();
    }

    @Test
    public void restGetWithLogsWithCondition(){
      when().get("/1").then().statusCode(HttpStatus.SC_OK).log().ifValidationFails();
    }

    @Test
    public void restGetWithBodyVerification(){
        given().header("Accept","application/json")
                .when().get("https://reqres.in/api/users/1").then()
                .statusCode(HttpStatus.SC_OK).log().ifValidationFails()
        .and().body("data.email", Matchers.equalTo("george.bluth@reqres.in"));
    }

    @Test
    public void restGetWithBodyVerification1(){
        given().header("Accept","application/json")
                .when().get("https://reqres.in/api/users/1").then()
                .statusCode(HttpStatus.SC_OK).log().ifValidationFails()
                .and().body("data.id", Matchers.equalTo(1));
    }


    @Test
    public void restGetWithBodyVerification2(){
        given().header("Accept","application/json")
                .when().get("https://reqres.in/api/users/1").then()
                .statusCode(HttpStatus.SC_OK).log().ifValidationFails()
                .and().body("data.first_name", Matchers.equalTo("George"));
    }

    @Test
    public void restGetWithBodyVerification3(){
        given().header("Accept","application/json")
                .when().get("https://reqres.in/api/users/1").then()
                .statusCode(HttpStatus.SC_OK).log().ifValidationFails()
                .and().body("data.last_name", Matchers.equalTo("Bluth"));
    }



    @Test
    public void restGetWithBodyVerificationWithArray(){
        given().header("Accept","application/json")
                .when().get("https://reqres.in/api/users/").then()
                .statusCode(HttpStatus.SC_OK).log().ifValidationFails()
                .and().body("data[1].email", Matchers.equalTo("janet.weaver@reqres.in"));
    }
    @Test
    public void restGetWithBodyVerificationWithArray1(){
        given().header("Accept","application/json")
                .when().get("https://reqres.in/api/users/").then()
                .statusCode(HttpStatus.SC_OK).log().ifValidationFails()
                .and().body("data[3].last_name", Matchers.equalTo("Morris"));
    }


    @Test
    public void restGetWithBodyVerificationWithArray2(){
        given().header("Accept","application/json")
                .when().get("https://reqres.in/api/users/").then()
                .statusCode(HttpStatus.SC_OK).log().ifValidationFails()
                .and().body("data[4].avatar", Matchers.equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg"));
    }

    @Test
    public void restGetWithBodyVerificationWithArray3(){
        given().header("Accept","application/json")
                .when().get("https://reqres.in/api/users/").then()
                .statusCode(HttpStatus.SC_OK).log().ifValidationFails()
                .and().body("data[5].id", Matchers.equalTo(6));
    }


    @Test
    public void restGetWithBodyVerificationWithArray4(){
        given().header("Accept","application/json")
                .when().get("https://reqres.in/api/users/").then()
                .statusCode(HttpStatus.SC_OK).log().ifValidationFails()
                .and().body("data[].id", Matchers.equalTo("id"));
    }


    @Test
    public void restGetAllIds() {
        Response response = given().header("Accept", "application/json")
                .when().get("https://reqres.in/api/users/");
        // response.body("data.id");
        String first_names;
        String last_names;

        List<Integer> list = response.path("data.first_name");
        List<String > list1 = response.path("data.last_name");
        System.out.println(list+" "+list1);


//
     //   Map<String ,Object> listNames = response.path("data.first_name","data.last_name");
       // System.out.println(list);
//        Map<String, Object> integerList = response.as(new TypeRef<Map<String, Object>>() {
//        });
//        FactPojo integerListPojo = response.as(FactPojo.class);


    }


    @Test
    public void getAllNames(){
      List<String >  nameList = given().header("Accept", "application/json").log().all().when()
                .get("https://reqres.in/api/users/").path("data.first_name");

        List<String >  lastNameList = given().header("Accept", "application/json").log().all().when()
                .get("https://reqres.in/api/users/").path("data.last_name");
        String first_names = "";
        String last_names =  "";

        for(int i=0; i <nameList.size();i++){
            first_names += nameList.get(i) + " ,";
            last_names+= lastNameList.get(i) + " ,";
        }
        Map<String ,String > map = new HashMap<>();
        map.put("first_name", first_names);
        map.put("last_name", last_names);
        System.out.println(map);
    }

    @Test
    public void getPetById(){

        int petId = 1;

        when().request(Method.GET,"https://petstore.swagger.io/v2/pet/{id}",petId)
                .then().statusCode(200).assertThat().body("photoUrls",Matchers.hasItem("<string>"));
    }

}
