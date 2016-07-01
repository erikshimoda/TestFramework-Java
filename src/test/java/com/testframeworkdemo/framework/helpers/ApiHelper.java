package com.testframeworkdemo.framework.helpers;


import static com.jayway.restassured.RestAssured.given;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import gherkin.deps.com.google.gson.stream.JsonReader;

import java.io.StringReader;
import java.util.List;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.testframeworkdemo.services.beans.PostsApiBean;

/**
 * Every Api Step definition class should extend this class
 */

public class ApiHelper {
    public static Gson gson;

//    static {
//        RestAssured.baseURI = UrlBuilder.getBasePathURI().toString();
//    }

    protected static RequestSpecification givenConfig() {
        RestAssured.useRelaxedHTTPSValidation();
        return given().
                header("Accept-Language", "en").header("Content-Type", "application/json");
    }

    //Specify all one time default Gson config
    public static Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gson(gsonBuilder);
        return gson;
    }

    //Custom Gson config to override Default Gson  configuration
    public static Gson gson(GsonBuilder gsonBuilder) {
        gson = gsonBuilder.create();
        return gson;
    }

	public static List<PostsApiBean> converJsonToObject(Class<?> clazz, Response response) {
		JsonReader reader = new JsonReader(new StringReader(response.getBody().asString()));
		reader.setLenient(true);
		List<PostsApiBean> responseJson = gson.fromJson(reader, clazz);
		return responseJson;
	}
  
  }