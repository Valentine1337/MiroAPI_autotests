package models.createAppCardItem.requestAssociate;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {
    private Integer height, width, rotation;

    public Geometry setGeometry(Integer rotation) {
        setHeight(500);
        setWidth(500);
        setRotation(rotation);
        return this;
    }
}