package com.apitest.demo2.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;


public class HttpRequests {

    private static final String CONTENT_TYPE_JSON = "application/json; charset=UTF-8";
    private static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded; charset=UTF-8";


    /**
     * 1.post请求方法
     * 断言String类型关键字方法
     *
     * @param url           请求地址
     * @param statusCode    状态码
     * @param paramsMap     参数
     * @param assertPath    要断言的关键字路径，如：data.Item.orderId
     * @param expectedWord  预期关键字
     */
    public static void postEquals(String url, int statusCode, Map<String, Object> paramsMap, String assertPath, String expectedWord){
        given().
                contentType(CONTENT_TYPE_FORM).
                params(paramsMap).
        when().
                post(url.trim()).
        then().
                log().ifError().
                assertThat().statusCode(statusCode).
        and().
                body(assertPath , equalTo(expectedWord));

    }


    /**
     * 2.post请求方法
     * 断言int类型关键字方法
     *
     * @param url           请求地址
     * @param statusCode    状态码
     * @param paramsMap     参数
     * @param assertPath    要断言的关键字路径，如：data.Item.orderId
     * @param expectedWord  预期关键字
     */
    public static void postEquals(String url, int statusCode, Map<String, Object> paramsMap, String assertPath, int expectedWord){
        given().
                contentType(CONTENT_TYPE_FORM).
                params(paramsMap).
        when().
                post(url.trim()).
        then().
                log().ifError().
                assertThat().statusCode(statusCode).
        and().
                body(assertPath , equalTo(expectedWord));

    }


    /**
     * 3.post请求方法
     * 断言boolean类型关键字方法
     *
     * @param url           请求地址
     * @param statusCode    状态码
     * @param paramsMap     参数
     * @param assertPath    要断言的关键字路径，如：data.Item.orderId
     * @param expectedWord  预期关键字
     */
    public static void postEquals(String url, int statusCode, Map<String, Object> paramsMap, String assertPath, boolean expectedWord){
        given().
                contentType(CONTENT_TYPE_FORM).
                params(paramsMap).
        when().
                post(url.trim()).
        then().
                log().ifError().
                assertThat().statusCode(statusCode).
        and().
                body(assertPath , equalTo(expectedWord));

    }


    /**
     * 4.获取一组数据，断言包含某一特殊字段
     *
     * @param url
     * @param statusCode
     * @param paramsMap
     * @param assertPath
     * @param expectedWord
     */
    public static void postHasItems(String url, int statusCode, Map<String, Object> paramsMap, String assertPath, String expectedWord){
        given().
                contentType(CONTENT_TYPE_FORM).
                params(paramsMap).
        when().
                post(url.trim()).
        then().
                log().ifError().
                assertThat().statusCode(statusCode).
        and().
                body(assertPath , hasItems(expectedWord));

    }

    /**
     * 5.获取一组数据，断言包含某整数字段
     *
     * @param url
     * @param statusCode
     * @param paramsMap
     * @param assertPath
     * @param expectedWord
     */
    public static void postHasItems(String url, int statusCode, Map<String, Object> paramsMap, String assertPath, int expectedWord){
        given().
                contentType(CONTENT_TYPE_FORM).
                params(paramsMap).
        when().
                post(url.trim()).
        then().
                log().ifError().
                assertThat().statusCode(statusCode).
        and().
                body(assertPath , hasItems(expectedWord));

    }


    /**
     * 6.指定root路径的post方法
     *
     * @param url
     * @param paramsMap
     * @param rootPath
     * @param assertPath
     * @param expectedWord
     */
    public static void rootIsPost(String url, Map<String, Object> paramsMap, String rootPath, String assertPath, String expectedWord){
        given().
                contentType(CONTENT_TYPE_FORM).
                params(paramsMap).
        when().
                log().body().
                post(url.trim()).
        then().
                root(rootPath).
                body(assertPath, hasItems(expectedWord));
    }


    /**
     * 7.post请求方法
     * 接口请求返回值
     *
     * @param url               请求地址
     * @param paramsMap         参数
     * @param keywordpath      需要返回值的路径，如: "data.token"
     * @return keyWord
     */
    public static String returnValue(String url, Map<String, Object> paramsMap, String keywordpath){
        String keyWord = given().
                params(paramsMap).
                post(url).
                path(keywordpath).toString();
        System.out.println("所需返回值为: " + keywordpath + " ===> " + keyWord);
        return keyWord;

    }

    /**
     * 8.
     * @param url
     * @param paramsMap
     * @param index
     * @param returnKey
     * @return
     */
    public String returnItemsValue(String url, Map<String, Object> paramsMap, String dataTag, String itemsTag, int index, String returnKey){
        String returnValue = null;
        Response response = given().contentType(CONTENT_TYPE_JSON).params(paramsMap).post(url);
        String body = response.getBody().asString();
        JSONObject bodyObject = JSON.parseObject(body);
        JSONObject dataJson = bodyObject.getJSONObject(dataTag);
        String items = dataJson.get(itemsTag).toString();
        JSONArray itemsJson = JSON.parseArray(items);
        returnValue = itemsJson.getJSONObject(index).getString(returnKey);
        System.out.println("获取到的关键词为: " + returnValue);
        return returnValue;
    }

    /**
     * 9.使用path方法获取响应内容
     *
     * @param url
     * @param assertPath
     * @param expectedWord
     * @param path
     */
    public static String extractDetailsByPath(String url,Map<String, Object> paramsMap,String assertPath, int expectedWord, String path){
        String keyWord = given().
                contentType(CONTENT_TYPE_JSON).
                params(paramsMap).
                get(url).
        then().
                body(assertPath, equalTo(expectedWord)).
                extract().
                path(path);
        System.out.println(keyWord);
        return keyWord;

    }

    /**
     * 10.
     * @param url
     * @param paramsMap
     * @param assertPath
     * @return
     */
    public static String extractDetailsByPath(String url, Map<String, Object> paramsMap, String assertPath){
        String keyWord = given().
                contentType(CONTENT_TYPE_JSON).
                params(paramsMap).
                get(url).andReturn().jsonPath().getString(assertPath);
        System.out.println(keyWord);
        return keyWord;

    }


    /**
     * 11.含有cookie的post请求
     *
     * */
    public static Response cookiesPost(String contentType, String url, String cookies){
        System.out.println("Cookie = " + cookies);
        Response response = given().
                contentType(contentType).
                cookies("JSSONID",cookies).
                expect().statusCode(200).
        when().
                post(url.trim());
        return response;
    }


    /**
     * 12.打印消息返回体
     * @param url           请求地址
     * @param paramsMap     参数
     * @param headersMap    消息头
     */
    public static void print(String url, Map<String, Object> paramsMap, Map<String, Object> headersMap){
        Response response = given().contentType(CONTENT_TYPE_JSON).headers(headersMap).params(paramsMap).post(url);
        response.prettyPrint();
    }


    /**
     * 13.打印消息返回体
     * @param url
     * @param paramsMap
     */
    public static void print(String url, Map<String, Object> paramsMap){
        Response response = given().contentType(CONTENT_TYPE_JSON).params(paramsMap).post(url);
        response.prettyPrint();
    }


    /**
     * 14.
     * @param contentType
     * @param url
     * @param paramsMap
     */
    public static void print(String contentType, String url, Map<String, Object> paramsMap){
        Response response = given().contentType(contentType).params(paramsMap).post(url);
        response.prettyPrint();
    }


    /**
     * 15.
     * @param paramsMap
     */
    public static void clear(Map<String, Object> paramsMap){
        paramsMap.clear();
    }

}
