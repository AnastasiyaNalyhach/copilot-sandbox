package org.example.api.client.implementation;

import org.apache.hc.core5.http.HttpStatus;
import org.example.api.client.data.HttpRequest;
import org.example.api.client.dto.UserInfo;
import org.example.api.client.rest.HttpRequestExecutor;
import org.example.utils.JsonUtils;

import java.util.List;

public class HerokuAppClient {
    HttpRequestExecutor httpRequestExecutor;
    String url;

    private static final String GET_ALL_USERS = "users/all";

    public HerokuAppClient() {
        this.httpRequestExecutor = new HttpRequestExecutor();
        this.url = "https://web-api-test1.herokuapp.com";
    }

    // TODO
    public List<UserInfo> getAllUsers() {
        var request = getBaseUserSearchRequest();
        var response= httpRequestExecutor.get(request)
                .statusCode(HttpStatus.SC_OK).extract()
                .body().as(UserInfo.class);


        return List.of(JsonUtils.map(response, UserInfo[].class));
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
