package org.example.api.client.rest;


import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.example.api.client.data.HttpRequest;
import org.example.api.logging.RestAssuredLogger;

@Slf4j
public class HttpRequestExecutor {

  public ValidatableResponse post(HttpRequest request) {
    return configRestRequest(request)
        .headers(request.getHeaders())
        .body(request.getBody())
        .post()
        .then();
  }

  public ValidatableResponse get(HttpRequest request, Object... params) {
    return configRestRequest(request)
        .headers(request.getHeaders())
        .when()
        .get(request.getPath(), params)
        .then();
  }

  public <T> ValidatableResponse put(HttpRequest request, Object... pathParams) {
    return configRestRequest(request)
        .headers(request.getHeaders())
        .body(request.getBody())
        .put(request.getPath(), pathParams)
        .then();
  }

  public <T> ValidatableResponse patch(HttpRequest request, Object... pathParams) {
    return configRestRequest(request)
        .headers(request.getHeaders())
        .body(request.getBody())
        .patch(request.getPath(), pathParams)
        .then();
  }

  private RequestSpecification configRestRequest(HttpRequest request) {
    return RestAssuredLogger.givenWithLogging().relaxedHTTPSValidation()
        .contentType(ContentType.JSON).accept(ContentType.JSON)
        .baseUri(request.getUrl());
  }
}