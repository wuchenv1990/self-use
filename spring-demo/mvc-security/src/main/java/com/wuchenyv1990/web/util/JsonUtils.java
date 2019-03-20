package com.wuchenyv1990.web.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public final class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String dumps(Object o) {
        if (o == null) {
            return null;
        } else {
            try {
                return MAPPER.writeValueAsString(o);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Convert to Json failed.", e);
            }
        }
    }

    public static <T> T load(String data, Class<T> type) {
        if (data == null) {
            return null;
        } else {
            try {
                return MAPPER.readValue(data, type);
            } catch (IOException e) {
                throw new RuntimeException("Convert to Json failed.", e);
            }
        }
    }

}
