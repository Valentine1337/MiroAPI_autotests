package models.createAppCardItem.requestAssociate;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Position {
    private String origin;
    private double x, y;

    public Position setPosition(double x, double y) {
        setOrigin("center");
        setX(x);
        setY(y);
        return this;
    }
}