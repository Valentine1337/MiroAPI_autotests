package models.createAppCardItem.requestAssociate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Style {
    private String fillColor;

    public Style setColor(String color) {
        return setColor(color);
    }
}
