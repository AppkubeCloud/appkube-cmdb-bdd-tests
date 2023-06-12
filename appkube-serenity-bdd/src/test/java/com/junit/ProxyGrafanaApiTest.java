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
public class ProxyGrafanaApiTest extends TestBase {

//    proxy-grafana-data-sourceService os;

    static int ID = -1;

    static String ENDPOINT1 = "/proxy-grafana-data-source";

    String body = "{\r\n"
            + "    \"name\": \"DEMO\" "
            + "}";

    String updateBody = "{\r\n"
            + "    \"id\": " + this.ID + ","
            + "    \"name\": \"DEMO_1\" "
            + "}";


    @Title("Get all proxy-grafana-data-source")
    @Test
    public void test004() {
        SerenityRest.rest().given().when().get(ENDPOINT1).then().statusCode(200);
    }

}
