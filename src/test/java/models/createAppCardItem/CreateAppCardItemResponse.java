package models.createAppCardItem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import models.createAppCardItem.requestAssociate.Geometry;
import models.createAppCardItem.requestAssociate.Position;
import models.createAppCardItem.requestAssociate.Style;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAppCardItemResponse {
    private CreateAppCardItemRequest.Data data;
    private Geometry geometry;
    private Position position;
    private Style style;
}
