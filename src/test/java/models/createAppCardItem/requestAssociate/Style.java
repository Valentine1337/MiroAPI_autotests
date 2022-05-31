package models.createAppCardItem.requestAssociate;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Style {
    private String fillColor;

    public Style setColor(String color) {
        return setColor(color);
    }
}
