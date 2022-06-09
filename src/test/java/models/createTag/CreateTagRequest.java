package models.createTag;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.javafaker.Faker;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTagRequest {
    private String
            fillColor,
            title;

    public void createTagWithCustomColorAndTitle(String color) {
        Faker faker = new Faker();
        setFillColor(color);
        setTitle(faker.random().hex());
    }
}
