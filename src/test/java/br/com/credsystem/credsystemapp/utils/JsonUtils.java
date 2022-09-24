package br.com.credsystem.credsystemapp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonUtils {
    public static <T> T getObjectFromJson(String json, Class<T> clazz) {

//        ObjectMapper mapper = JsonObjectMapper.makeMapper();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> String getJsonFromObject(T obj) {

//        ObjectMapper mapper = JsonObjectMapper.makeMapper();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> getObjectListFromJson(String json, Class<T> clazz) {

//        ObjectMapper mapper = JsonObjectMapper.makeMapper();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }

//    public static class JsonObjectMapper {
//        private JsonObjectMapper() {
//        }
//
//        public static ObjectMapper makeMapper() {
//            ObjectMapper _mapper = new ObjectMapper();
//            _mapper.registerModule(new ParameterNamesModule());
//            _mapper.registerModule(new Jdk8Module());
//            _mapper.registerModule(new JavaTimeModule());
//            return _mapper;
//        }
//    }
}
