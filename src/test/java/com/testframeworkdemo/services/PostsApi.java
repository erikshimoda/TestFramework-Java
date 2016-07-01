package com.testframeworkdemo.services;

import java.util.List;

import com.jayway.restassured.response.Response;
import com.testframeworkdemo.framework.helpers.ApiHelper;
import com.testframeworkdemo.services.beans.PostsApiBean;

public class PostsApi extends ApiHelper {

	public static final String PATH = "posts/";

	public static Response getPosts(String endpoint) {
		return givenConfig().when().get(endpoint);
	}

	public static Response postDetails(List<PostsApiBean> postsApiBean) {
		return givenConfig().body(gson().toJson(postsApiBean)).when()
				.post(PATH);
	}

	public static Response updateDetails(List<PostsApiBean> postsApiBean) {
		return givenConfig().body(gson().toJson(postsApiBean)).when().put(PATH);
	}

	public static Response deleteItem(String uniqueId) {
		return givenConfig().when().delete(PATH + uniqueId);
	}

//	public static PostsApiBean validarResposta(List<PostsApiBean> listResponse) {
////		List<PostsApiBean> listReponse = new List<PostsApiBean>(listResponse);
////		
////		
////		return responseJson;
//	}
}
