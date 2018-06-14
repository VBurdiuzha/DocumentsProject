package mainPackage.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import mainPackage.interfaceFolder.ExpertiseVars;
import mainPackage.interfaceFolder.Vars;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import javax.xml.ws.Response;

import static io.restassured.RestAssured.given;


public class APIMethods {
static String id_application;

    public static void addMoneyPOSTrequest(int money)
    {
        RestAssured.baseURI ="https://stage.servicedoc.ua";
        RequestSpecification request = given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("change", money);
        request.header("Content-Type", "application/json");
        request.header("Authorization", ExpertiseVars.typeToken + authorizationGetTokenUI
                (Vars.regularUser, Vars.regularUserPassword));
        request.body(requestParams.toJSONString());

        System.out.println(requestParams.toJSONString());
        io.restassured.response.Response response = request.post("/api/v1/payment/replenishaccount");
        System.out.println("Response body: " + response.body().asString());
        System.out.println(response);
        System.out.println(request + "\n");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

                /*     http://toolsqa.com/rest-assured/post-request-using-rest-assured/    */
    }

    public static void withdrawMoneyPOSTrequest(String money)
    {
        RestAssured.baseURI ="https://stage.servicedoc.ua";
        RequestSpecification request = given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("change", money);
        requestParams.put("userId", "5af40ce5bb4c21029830830d");
        requestParams.put("forAdminPanel", 1);
        request.header("Content-Type", "application/json");
        request.header("Authorization", ExpertiseVars.typeToken + authorizationGetTokenAdmin
                (Vars.adminUser, Vars.regularUserPassword));
        request.body(requestParams.toJSONString());

        System.out.println(requestParams.toJSONString());
        io.restassured.response.Response response = request.post("/api/v1/payment/changeaccount/");
        System.out.println("Response body: " + response.body().asString());
        System.out.println(request + "\n");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

                /*     http://toolsqa.com/rest-assured/post-request-using-rest-assured/    */

    }


    public static String authorizationGetTokenUI(String Name, String Passw)
    {
        RestAssured.baseURI ="https://stage.servicedoc.ua/api/v1";
        RequestSpecification request = given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("client_id", "android");
        requestParams.put("client_secret", "SomeRandomCharsAndNumbers");
        requestParams.put("email", Name);
        requestParams.put("grant_type", "password");
        requestParams.put("password", Passw);

        requestParams.put("side", "front");

        requestParams.put("username", Name);
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());


      //  System.out.println(requestParams.toJSONString());
        io.restassured.response.Response response = request.post("/oauth/token");
      //  System.out.println("Response body: " + response.body().asString());
        java.lang.String responseSTR = response.body().asString();

        org.json.JSONObject obj = new JSONObject(responseSTR);
        String tokenUI = obj.getString("access_token");

      //  System.out.println("This is my token : " + tokenUI + "\n");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        return
                tokenUI;
    }

    public static String authorizationGetTokenAdmin(String Name, String Passw)
    {
        RestAssured.baseURI ="https://stage.servicedoc.ua/api/v1";
        RequestSpecification request = given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("client_id", "android");
        requestParams.put("client_secret", "SomeRandomCharsAndNumbers");
        requestParams.put("email", Name);
        requestParams.put("grant_type", "password");
        requestParams.put("password", Passw);
        requestParams.put("username", Name);
        requestParams.put("forAdminPanel", 1);
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());


        System.out.println(requestParams.toJSONString());
        io.restassured.response.Response response = request.post("/oauth/token");
        System.out.println("Response body: " + response.body().asString());
        java.lang.String responseSTR = response.body().asString();

        org.json.JSONObject obj = new JSONObject(responseSTR);
        String tokenAdmin = obj.getString("access_token");

        System.out.println("This is my token : " + tokenAdmin + "\n");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        return
                tokenAdmin;
    }

    public static String createApplication(){
        System.out.println("Here will be create Application \n");

        RestAssured.baseURI ="https://stage.servicedoc.ua/api/v1";
        RequestSpecification request = given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("comment", "This case i will doing with using API");
        requestParams.put("knowledge", "5aafce473a24c926d01797ba");
        requestParams.put("requisites", "NOT_SPECIFIED");
        requestParams.put("ownership", "APItest");

        request.header("Content-Type", "application/json");
        request.header("Authorization", ExpertiseVars.typeToken + authorizationGetTokenUI
                (Vars.regularUser, Vars.regularUserPassword));

        request.body(requestParams.toJSONString());
        io.restassured.response.Response response = request.post("/reviews/createNewReview");
      //  System.out.println("Response body: " + response.body().asString());
        java.lang.String responseSTR = response.body().asString();

        /* here we have object in object */

        org.json.JSONObject obj = new JSONObject(responseSTR);
        JSONObject dataObject = obj.getJSONObject("data");
        id_application = dataObject.getString("_id");
        System.out.println("This is my token of application: " + id_application + "\n");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        return
                id_application;

    }

    public static void rejectedApplication(){
        System.out.println("Here will be rejectedApplication \n");
        RestAssured.baseURI ="https://stage.servicedoc.ua/api/v1";
        RequestSpecification request = given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("_id", id_application);
        requestParams.put("statusComment", "test");

        request.header("Content-Type", "application/json");
        request.header("Authorization", ExpertiseVars.typeToken + authorizationGetTokenUI
                (Vars.doperUser, Vars.doperUserPassword));

        request.body(requestParams.toJSONString());


    //    System.out.println(requestParams.toJSONString());
        io.restassured.response.Response response = request.post("/reviews/rejectReview");

        System.out.println("rejected application success" + "\n");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }



    public static void payDoc(){                            // GET Request
        System.out.println("Here will be payDoc \n");
        RestAssured.baseURI ="https://stage.servicedoc.ua/api/v1";
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", ExpertiseVars.typeToken + authorizationGetTokenUI
                (Vars.regularUser, Vars.regularUserPassword));
        io.restassured.response.Response response = request.get("/reviews/buy/review/" + id_application);
        System.out.println("payDoc success" + "\n");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

}



