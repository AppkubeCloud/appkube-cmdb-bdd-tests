package com.junit;

import com.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CloudEnvironmentApiTest extends TestBase {

    static int ID = 1;

    static String ENDPOINT = "/cloud-environments";

//    String body = "{\r\n"
//            + "    \"name\": \"DEMO\" "
//            + "}";
//
//    String updateBody = "{\r\n"
//            + "    \"id\": " + this.ID + ","
//            + "    \"name\": \"DEMO_1\" "
//            + "}";


//    @Title("Add new CloudEnvironment")
//    @Test
//    public void test001() throws JsonMappingException, JsonProcessingException {
//
//        Object returnData = SerenityRest.rest().given().when().contentType(ContentType.JSON).log().all().body(body)
//                .post(ENDPOINT).then().log().all().statusCode(201).extract().path("");
//
//        ObjectMapper oMapper = new ObjectMapper();
//        @SuppressWarnings("unchecked")
//        Map<String, Object> map = oMapper.convertValue(returnData, Map.class);
//        ID = (int) map.get("id");
//    }
//
    @Title("Get CloudEnvironment By id")
    @Test
    public void test003() {
        SerenityRest.rest().given().when().get(ENDPOINT + "/" + ID).then().log().all()
                .statusCode(200);
    }

    @Title("Search CloudEnvironment By params")
    @Test
    public void test0031() {
        SerenityRest.rest().given().when().get(ENDPOINT + "/search?id=" + ID).then().log().all()
                .statusCode(200);
    }


    @Title("Get all CloudEnvironment")
    @Test
    public void test004() {
        SerenityRest.rest().given().when().get(ENDPOINT).then().statusCode(200);
    }


//    @Title("Delete CloudEnvironment")
//    @Test
//    public void test005() {
//        ExtractableResponse<Response> returnData = SerenityRest.rest().given().when().contentType(ContentType.JSON)
//                .log().all().delete(ENDPOINT + "/" + ID).then().log().all().extract();
//
//        assertNotNull(returnData);
//    }

}
