package test;

import base_URL.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class API_Deserialization extends JsonPlaceHolderBaseUrl {

    @Test
    public void test01(){
        specJsonPlace.pathParam("pp1",70);

        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();

        Map<String,Object> reqBodyMap = jsonPlaceHolderTestData.requestBodyMapCreate();
        //System.out.println(reqBodyMap);

        Map<String,Object> expDataMap = jsonPlaceHolderTestData.requestBodyMapCreate();

        Response response = given().
                contentType(ContentType.JSON).
                spec(specJsonPlace).
                when().
                body(reqBodyMap).
                put("{pp1}");

        assertEquals(jsonPlaceHolderTestData.successfulStatusCode,response.getStatusCode());

        Map<String,Object> respBodyMap = response.as(HashMap.class);

        assertEquals(expDataMap.get("title"),respBodyMap.get("title"));
        assertEquals(expDataMap.get("body"),respBodyMap.get("body"));
        assertEquals(expDataMap.get("userId"),respBodyMap.get("userId"));
        assertEquals(expDataMap.get("id"),respBodyMap.get("id"));
    }
}
