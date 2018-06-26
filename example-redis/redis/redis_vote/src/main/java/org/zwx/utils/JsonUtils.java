package org.zwx.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonUtils {

    private static final ObjectMapper om = new ObjectMapper();

    public static Map<String, Object> cvrtObj2Map(Object o) {
       return om.convertValue(o, Map.class);
    }

    public static String cvrtObj2Str(Object o) throws JsonProcessingException {
        return om.writeValueAsString(o);
    }

    public static<T> T cvrtmap2Obj(Map map, Class<T> cls) {
        return om.convertValue(map, cls);
    }


}
