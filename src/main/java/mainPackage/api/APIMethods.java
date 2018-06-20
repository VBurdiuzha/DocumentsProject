package mainPackage.api;

import io.restassured.RestAssured;
import io.restassured.internal.util.IOUtils;
import io.restassured.specification.RequestSpecification;
import mainPackage.interfaceFolder.FilesVars;
import mainPackage.interfaceFolder.LogsVars;
import okhttp3.*;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;


public class APIMethods {

    static String id_application;
    static int balance;
    static String tokenUI;


    public static void addMoneyPOSTrequest(int money)
    {
        RestAssured.baseURI ="https://stage.servicedoc.ua";
        RequestSpecification request = given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("change", money);
        request.header("Content-Type", "application/json");
        request.header("Authorization", LogsVars.typeToken + authorizationGetTokenUI
                (LogsVars.regularUser, LogsVars.regularUserPassword));
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
        request.header("Authorization", LogsVars.typeToken + authorizationGetTokenAdmin
                (LogsVars.adminUser, LogsVars.regularUserPassword));
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


        io.restassured.response.Response response = request.post("/oauth/token");
        java.lang.String responseSTR = response.body().asString();

        org.json.JSONObject obj = new JSONObject(responseSTR);
        tokenUI = obj.getString("access_token");

        System.out.println("This is my token UI: " + tokenUI + "\n");

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

        System.out.println("This is my token ADMIN: " + tokenAdmin + "\n");

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
        request.header("Authorization", LogsVars.typeToken + authorizationGetTokenUI
                (LogsVars.regularUser, LogsVars.regularUserPassword));

        request.body(requestParams.toJSONString());
        io.restassured.response.Response response = request.post("/reviews/createNewReview");
      //  System.out.println("Response body: " + response.body().asString());
        java.lang.String responseSTR = response.body().asString();

        /* here we have object in object */

        org.json.JSONObject obj = new JSONObject(responseSTR);
        JSONObject dataObject = obj.getJSONObject("data");
        id_application = dataObject.getString("_id");
        System.out.println("This is my id of application: " + id_application + "\n");

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
        request.header("Authorization", LogsVars.typeToken + authorizationGetTokenUI
                (LogsVars.doperUser, LogsVars.doperUserPassword));

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
        request.header("Authorization", LogsVars.typeToken + authorizationGetTokenUI
                (LogsVars.regularUser, LogsVars.regularUserPassword));
        io.restassured.response.Response response = request.get("/reviews/buy/review/" + id_application);
        System.out.println("payDoc success" + "\n");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    public static int  getBalance(){
        System.out.println("Here will be payDoc \n");
        RestAssured.baseURI ="https://stage.servicedoc.ua/api/v1";
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", LogsVars.typeToken + authorizationGetTokenUI
                (LogsVars.regularUser, LogsVars.regularUserPassword));
        io.restassured.response.Response response = request.get("/payment/account");
        System.out.println("get balance" + "\n");
        int statusCode = response.getStatusCode();

        java.lang.String responseSTR = response.body().asString();
        org.json.JSONObject obj = new JSONObject(responseSTR);
        JSONObject dataObject = obj.getJSONObject("data");
        balance = dataObject.getInt("account");
        System.out.println(balance);

        Assert.assertEquals(statusCode, 200);

        return
                balance;

    }

    public static void  withDrawAllMoney(){
        RestAssured.baseURI ="https://stage.servicedoc.ua";
        int oops = Integer.parseInt("-"+getBalance());

        if (oops == 0) {
            Assert.assertTrue(true);
            return;
        }

        RequestSpecification request = given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("change", oops);
        requestParams.put("userId", "5af40ce5bb4c21029830830d");
        requestParams.put("forAdminPanel", 1);
        request.header("Content-Type", "application/json");
        request.header("Authorization", LogsVars.typeToken + authorizationGetTokenAdmin
                (LogsVars.adminUser, LogsVars.regularUserPassword));
        request.body(requestParams.toJSONString());

        System.out.println(requestParams.toJSONString());
        io.restassured.response.Response response = request.post("/api/v1/payment/changeaccount/");
        System.out.println("Response body: " + response.body().asString());
        System.out.println(request + "\n");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }

    public static void attachFileInToTheDoc(){
        System.out.println("Here will be sent application from Doper to Oper \n");
        RestAssured.baseURI ="https://stage.servicedoc.ua/api/v1";
        RequestSpecification request = given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("id", id_application);
        requestParams.put("flag", "");
        requestParams.put("assignedTo", "5af40db2bb4c21dfa5308313");
        requestParams.put("lawyerName", "Operator ");
        requestParams.put("operatorComment", "Виталик - чемпион");
        requestParams.put("knowledgeSubType", "5aafd1073a24c92b041797bb");


        request.header("Content-Type", "image/png");
        request.header("Authorization", LogsVars.typeToken + authorizationGetTokenUI
                (LogsVars.doperUser, LogsVars.doperUserPassword));

        request.body(requestParams.toJSONString());
        io.restassured.response.Response response = request.post("/reviews/attachFile/"+id_application);
        System.out.println("===== Application was sent to operator =====" + "\n");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);



                        /*          ===== Ned doing =====   */


    }

    public static void setDocFromDOperToOper(){
        System.out.println("Here will be sent application from Doper to Oper \n");
        RestAssured.baseURI ="https://stage.servicedoc.ua/api/v1";
        RequestSpecification request = given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("id", id_application);
        requestParams.put("flag", "");
        requestParams.put("assignedTo", "5af40db2bb4c21dfa5308313");
        requestParams.put("lawyerName", "Operator ");
        requestParams.put("operatorComment", "Виталик - чемпион");
        requestParams.put("knowledgeSubType", "5aafd1073a24c92b041797bb");


        request.header("Content-Type", "application/json");
        request.header("Authorization", LogsVars.typeToken + authorizationGetTokenUI
                (LogsVars.doperUser, LogsVars.doperUserPassword));

        request.body(requestParams.toJSONString());
        io.restassured.response.Response response = request.post("/reviews/updateReviewById");
        System.out.println("===== Application was sent to operator =====" + "\n");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

                /*   https://javatutorial.net/java-file-upload-rest-service  */



//    public static void uploadTheFile() {
//        System.out.println("=======Now i will attach the file======= ");
//        System.out.println(tokenUI);
//
//        given().
//                formParam("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundaryi1TNXqtDD8JNDHYU").
//                formParam("Authorization",FilesVars.typeToken + tokenUI).
//                multiPart("file", FilesVars.attachmentFileLocation+FilesVars.attachmentFileNamePNG).
//                multiPart("string", "body").
//                expect().
//                statusCode(200).
//                when().
//                post("https://stage.servicedoc.ua/api/v1/reviews/attachFile/"+id_application);
//        }

        public static void TEST() throws IOException {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
            RequestBody body = RequestBody.create(mediaType, "{\"files\":[{\"fileName\":\"/Users/villiburduza/IdeaProjects/ServiceDoc/qa/src/main/resources/picture/expertise.png\"}],\"reviewId\":\"5b27b8c0c9766550cef13512\",\"fileName\":\"0\"}\n");
            Request request = new Request.Builder()
                    .url("https://stage.servicedoc.ua/api/v1/reviews/attachFile/"+id_application)
                    .post(body)
                    .addHeader("authorization", "Bearer "+tokenUI)
                    .addHeader("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println(response.body());
        }

    /*   https://github.com/rest-assured/rest-assured/blob/master/examples/rest-assured-itest-java/src/test/java/io/restassured/itest/java/presentation/MultiPartITest.java*/



         public static void byteArrayUploading() throws Exception {
                // Given
              final byte[] bytes = IOUtils.toByteArray(APIMethods.class.getResourceAsStream(FilesVars.attachmentFileLocation+FilesVars.attachmentFileNamePNG));

             // When
                  given().
                    formParam("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundaryi1TNXqtDD8JNDHYU").
                    formParam("Authorization",LogsVars.typeToken + tokenUI).
                    multiPart("file", "myFile", bytes).
                    expect().
                    statusCode(200).
                    body(is(new String(bytes))).
                    when().
                    post("https://stage.servicedoc.ua/api/v1/reviews/attachFile"+id_application);
        }

    public void multiPartUploading() throws Exception {
    // Given
        final byte[] bytes;
        bytes = IOUtils.toByteArray(getClass().getResourceAsStream(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNamePNG));
        File file = new File(FilesVars.attachmentFileLocation);

        long length = file.length();
        System.out.println(length);
        Map<String, String> expectedHeaders = new HashMap<String, String>();
        expectedHeaders.put("Content-Length", ""+length);
// When
        given().
                multiPart("file", "myFile", bytes).
                headers("Authorization",LogsVars.typeToken + tokenUI).
                headers("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundaryi1TNXqtDD8JNDHYU; application/pdf").
                expect().
                statusCode(200).
                body(is(new String(bytes))).
                when().
                post("https://stage.servicedoc.ua/api/v1/reviews/attachFile"+id_application);
        }

    public static void simpleFileUploading() throws Exception {
        // When
        given().
                multiPart(new File(FilesVars.attachmentFileLocation+FilesVars.attachmentFileNamePDF)).
                headers("Authorization",LogsVars.typeToken + tokenUI).
                headers("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundaryi1TNXqtDD8JNDHYU; application/pdf").
                expect().
                statusCode(200).
                body(equalTo("I'm a test file")).
                when().
                post("https://stage.servicedoc.ua/api/v1/reviews/attachFile"+id_application);
        }
    }





