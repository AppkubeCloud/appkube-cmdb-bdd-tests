package com.junit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testbase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MicroServiceApiTest extends TestBase {

//    micro-serviceService os;

    static int ID = -1;

    static String ENDPOINT = "/micro-services";

    String body = "{\r\n"
            + "    \"name\": \"DEMO\" "
            + "}";

    String updateBody = "{\r\n"
            + "    \"id\": " + this.ID + ","
            + "    \"name\": \"DEMO_1\" "
            + "}";


    @Title("Add new micro-service")
    @Test
    public void test001() throws JsonMappingException, JsonProcessingException {

//        when(.save());

        Object returnData = SerenityRest.rest().given().when().contentType(ContentType.JSON).log().all().body(body)
                .post(ENDPOINT).then().log().all().statusCode(201).extract().path("");

        ObjectMapper oMapper = new ObjectMapper();
        @SuppressWarnings("unchecked")
        Map<String, Object> map = oMapper.convertValue(returnData, Map.class);
        ID = (int) map.get("id");
    }

    @Title("Update micro-service with patch")
    @Test
    public void test002() {
        SerenityRest.rest().given().when().contentType(ContentType.JSON).body(updateBody).patch(ENDPOINT + "/" + ID).then()
                .log().all().statusCode(200);
    }

    @Title("Get micro-service By id")
    @Test
    public void test003() {
        SerenityRest.rest().given().when().get(ENDPOINT + "/" + ID).then().log().all()
                .statusCode(200);
    }

    @Title("Search micro-service By params")
    @Test
    public void test0031() {
        SerenityRest.rest().given().when().get(ENDPOINT + "/search?id=" + ID).then().log().all()
                .statusCode(200);
    }


    @Title("Get all micro-service")
    @Test
    public void test004() {
        SerenityRest.rest().given().when().get(ENDPOINT).then().statusCode(200);
    }


    @Title("Delete micro-service")
    @Test
    public void test005() {
        ExtractableResponse<Response> returnData = SerenityRest.rest().given().when().contentType(ContentType.JSON)
                .log().all().delete(ENDPOINT + "/" + ID).then().log().all().extract();

        assertNotNull(returnData);
    }

}
