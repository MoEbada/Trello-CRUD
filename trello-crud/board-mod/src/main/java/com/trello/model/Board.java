package com.trello.model;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Board {
    private String name;
    private String idOrganization;
    private String url;

    public static Board fromJson(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        // because the fields in the Board class are a subset ofthe fields in the JSON response
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return objectMapper.readValue(jsonString, Board.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Board{" +
                "name='" + name + '\'' +
                ", idOrganization='" + idOrganization + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
