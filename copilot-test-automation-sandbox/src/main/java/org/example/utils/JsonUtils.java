package org.example.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public class JsonUtils {
    private static final ObjectMapper OBJECT_MAPPER;
    private static final Gson GSON;

    static {
        OBJECT_MAPPER = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true).configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
        GSON = new GsonBuilder().setPrettyPrinting().create();
    }

    @SneakyThrows
    public <T> T map(Object data, Class<T> clazz) {
        return OBJECT_MAPPER.convertValue(data, clazz);
    }

    @SneakyThrows
    public <T> T map(String data, Class<T> clazz) {
        return OBJECT_MAPPER.readValue(data, clazz);
    }

    @SneakyThrows
    public <T> T convertMapToObject(Map<String, String> map, Class<T> clazz) {
        return OBJECT_MAPPER.convertValue(map, clazz);
    }

    public String convertObjectToJsonString(Object objectToConvert) {
        return GSON.toJson(objectToConvert);
    }

    public ObjectMapper getJacksonObjectMapper() {
        return OBJECT_MAPPER;
    }
}
