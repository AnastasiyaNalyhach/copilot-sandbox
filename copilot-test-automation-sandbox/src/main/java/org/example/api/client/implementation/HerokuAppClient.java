package org.example.api.client.implementation;

import org.apache.hc.core5.http.HttpStatus;
import org.example.api.client.data.HttpRequest;
import org.example.api.client.rest.HttpRequestExecutor;

public class HerokuAppClient {
    HttpRequestExecutor httpRequestExecutor;
    String url;

    private static final String GET_ALL_USERS = "https://web-api-test1.herokuapp.com/users/all";
// TODO
    public void createSpecimens() {
//        var request = getBaseUserSearchRequest();
//        var response = httpRequestExecutor.get(request)
//                .statusCode(HttpStatus.SC_CREATED).extract()
//                .body().as(ResponseDto.class);
//        return List.of(JsonUtils.map(response, ResponseDto[].class));
    }

    private HttpRequest getBaseUserSearchRequest() {
        var request = getHttpRequestBase();
        request.setPath(GET_ALL_USERS);
        return request;
    }

    private HttpRequest getHttpRequestBase() {
        return HttpRequest.builder().url(url)
                .build();
    }
}
