package com.testframeworkdemo.step_definitions.api;

import static org.assertj.core.api.Assertions.assertThat;
import gherkin.deps.com.google.gson.stream.JsonReader;

import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.testframeworkdemo.services.PostsApi;
import com.testframeworkdemo.services.beans.PostsApiBean;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PostsApiSteps {
	private Response response;
	private PostsApiBean postsApiBeanJson;
    private static URL apiUrl;

	@Dado("^que eu realizo um request para a API \"(.*?)\"$")
	public void que_eu_realizo_um_request_para_a_api(String url) throws MalformedURLException {
//		apiUrl = new URL(url);

		// UrlBuilder.getBasePathURI(url);
		 RestAssured.baseURI = url;
	}

	@Quando("^eu realizo um GET request com o caminho \"(.*?)\"$")
	public void eu_realizo_um_GET_request_com_o_caminho(String endpoint) {
		 response = PostsApi.getPosts(endpoint);		 
		//
		// response = given()
		// .contentType("application/json")

		// .all()
		// .get("/posts/" + path);
	}

	@Entao("^eu recebo codigo \"(.*?)\" como resposta$")
	public void eu_recebo_codigo_como_resposta(int statusCodeExpected) {
		assertThat(response.statusCode()).isEqualTo(statusCodeExpected);
	}

	@Entao("^eu recebo a resposta:$")
	public void eu_recebo_a_resposta(List<PostsApiBean> data) {

//		PostsApi.convertResponseToJson(response);
//		
//		 JsonReader reader = new JsonReader(new
//		 StringReader(response.getBody()
//		
//		
//		
//		gson
//	     //Example with simple JsonPath
////        String id = from(response.asString()).get("id");
////        assertThat(id).isEqualTo("1");
////
////        String userId = from(response.asString()).get("userId");
////        assertThat(userId).isEqualTo("1");
//		 .asString()));
//		 reader.setLenient(true);
//		 PostsApiBean resp = gson.fromJson(reader, PostsApiBean.class);

	}
}