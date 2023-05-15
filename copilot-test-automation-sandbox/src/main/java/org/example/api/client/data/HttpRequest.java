package org.example.api.client.data;

import lombok.Data;
import lombok.Builder;

import java.util.Map;

@Data
@Builder
public class HttpRequest {

    private String body;
    private Map<String, Object> headers;
    private String url;
    private String path;
}
