package com.apitest.demo2.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;


public class ApiBasic {

    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36";
    public static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded;charset=UTF-8";
    public static final String URL_B = "http://10.20.18.166:8701"; //192.168.76.55      10.20.18.166
    public static Map<String, String> cookies;
    public static Map<String, Object> paramsMap = new HashMap();
    public static String JSESSIONID;


    public static void login() {
        String URI = "";
        String url = URL_B + URI;
        paramsMap.put("operator_code", "admin");
        paramsMap.put("password", "1");
        cookies = given().contentType(CONTENT_TYPE_FORM).params(paramsMap).when().post(url.trim(), new Object[0]).getCookies();
        paramsMap.clear();
    }


    public static void getUserAuth() {
        String URI = "";
        String url = URL_B + URI;
        Map<String, String> allCookies = post(url, 200, paramsMap).getCookies();
        System.out.println(allCookies.toString());
    }


    public static void get(String url, int statusCode) {
        given().
                header("Content_type", CONTENT_TYPE_JSON, new Object[0]).
                header("User_agent", USER_AGENT, new Object[0]).
                when().get(url.trim(), new Object[0]).
                then().log().ifError().
                assertThat().statusCode(statusCode);
    }


    public static void get(String url, int statusCode, HashMap<String, Object> paramsMap) {
        JSONObject json = new JSONObject(paramsMap);
        given().
                header("Content_type", CONTENT_TYPE_JSON, new Object[0]).
                header("User_agent", USER_AGENT, new Object[0]).
                header("cookie", JSESSIONID, new Object[0]).
                body(json).
                when().get(url.trim(), new Object[0]).
                then().log().ifError().
                assertThat().statusCode(statusCode);
        paramsMap.clear();
    }


    public static Response post(String url, int statusCode, Map<String, Object> paramsMap) {
        given().
                header("Content-Type",CONTENT_TYPE_JSON).
                header("User-Agent", USER_AGENT).body(paramsMap.toString()).
                when().post(url.trim()).
                then().log().ifError().
                assertThat().statusCode(statusCode);
        paramsMap.clear();
        return null;
    }


    public static void returnValue(String url, Map<String, Object> paramsMap, String keywordPath) {
        System.out.println(given().
                contentType(CONTENT_TYPE_JSON).body(paramsMap.toString()).
                header("User_agent", USER_AGENT).
                when().post(url.trim()).path(keywordPath).toString());
        paramsMap.clear();
    }


    public static void delete(String url, int statusCode, HashMap<String, Object> paramsMap) {
    }




}
