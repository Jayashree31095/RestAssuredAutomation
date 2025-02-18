package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class Sample1 {
    
    private static int orderId;  
    
    
    @DataProvider(name = "orderData")
    public Object[][] createOrderData() {
        return new Object[][] {
            {10, 198772, 7, "2025-02-18T09:42:10.013Z", "approved", true},  
            {11, 198773, 5, "2025-02-19T09:42:10.013Z", "shipped", false}, 
            {12, 198774, 3, "2025-02-20T09:42:10.013Z", "delivered", true}  
        };
    }

    
    @Test
    @Description("Get details of your pet")
    public void Test_get() {
        baseURI = "https://petstore3.swagger.io/api";
        Response response = given().get("/v3/pet/findByStatus?status=available");
        
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("content-type"));
        
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    
    @Test
    public void Test_post() {
        baseURI = "https://petstore3.swagger.io/api/v3";
        String petID = "10";
        
        given().post("/pet/{petId}", petID)
            .then().statusCode(400).log().all();
    }

    
    @Test
    public void Test_get2() {
        baseURI = "https://petstore3.swagger.io/api/v3";
        String petID = "10";
        
        given().get("/pet/{petId}", petID)
            .then().statusCode(200).log().all();
    }

    
    @Test(dataProvider = "orderData")
    public void Test_post2(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        JSONObject request = new JSONObject();
        request.put("id", id);
        request.put("petId", petId);
        request.put("quantity", quantity);
        request.put("shipDate", shipDate);
        request.put("status", status);
        request.put("complete", complete);

        System.out.println("Request Payload: " + request.toJSONString());
        
        baseURI = "https://petstore3.swagger.io/api/v3";
    
        Response myresponse = given().
                when().
                contentType("application/json").
                body(request.toJSONString()).
                post("/store/order").
                then().
                statusCode(200).log().all().
                extract().response();
    
        orderId = myresponse.jsonPath().getInt("id");  
    
        System.out.println("Extracted Order ID: " + orderId);
        Assert.assertNotNull(orderId, "Order ID should not be null");
    }

    
    @Test(dependsOnMethods = {"Test_post2"})
    public void Test_delete() {
        
        Assert.assertTrue(orderId > 0, "Order ID must be valid");

        Response deleteResponse = given().
                when().
                delete("/store/order/" + orderId).
                then().
                statusCode(200).log().all().
                extract().response();

        System.out.println("Delete Response: " + deleteResponse.asString());

                
    }
    
    @Test
    public void Test_put() {
baseURI = "https://petstore3.swagger.io/api/v3";

        
        JSONObject requestBody = new JSONObject();
        


        
        requestBody.put("id", 10);
        requestBody.put("name", "doggie");
        System.out.println("Request Payload: " + requestBody.toJSONString());

        Response myresponse = given().
                when().
                contentType("application/json").
                body(requestBody.toJSONString()).
                put("/pet").
                then().
                statusCode(200).log().all().
                extract().response();
        
       
        String name = myresponse.jsonPath().getString("name");
        Assert.assertEquals(name, "doggie", "Pet name should be 'doggie'");
        
    }
    
   

}
