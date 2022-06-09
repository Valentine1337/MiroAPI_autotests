package models.createAppCardItem.requestAssociate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Position {
    private String origin;
    private double
            x,
            y;

    public void setPosition(double x, double y) {
        setOrigin("center");
        setX(x);
        setY(y);
    }
}