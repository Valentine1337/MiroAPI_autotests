package models.createAppCardItem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import models.createAppCardItem.requestAssociate.Fields;
import models.createAppCardItem.requestAssociate.Geometry;
import models.createAppCardItem.requestAssociate.Position;
import models.createAppCardItem.requestAssociate.Style;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAppCardItemRequest {
    private Data data = new Data();
    private Style style = new Style();
    private Position position = new Position();
    private Geometry geometry = new Geometry();

    //Main methods for test requests
    public void makeThreeBlueRoundsInvertedWithPurpleColor() {
        data.makeBlueRoundsWithCatAndTextObject("Tooltip test",
                "Value for tooltip is here", 3, "round");
        data.setTitleAndDescription("Sample app card", "Autotest sample three blue rounds with purple");
        style.setFillColor("#b62fe3");
        position.setPosition(100.1, 105.2);
        geometry.setGeometry(180);
    }

    public void makeFiveBlueSquaresStraightWithYellowColor() {
        data.makeBlueRoundsWithCatAndTextObject("Tooltip test",
                "Value for tooltip is here", 5, "square");
        data.setTitleAndDescription("Sample app card", "Autotest sample five blue squares with yellow");
        style.setFillColor("#dde32f");
        position.setPosition(115.1, 120.2);
        geometry.setGeometry(0);
    }

    //Class for json object 'Data'
    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Data {
        private Fields[] fields;
        private String title, description;

        public void makeBlueRoundsWithCatAndTextObject(String tooltip, String value,
                                                       Integer quantity, String figure) {
            fields = new Fields[quantity];
            for (int i = 0; i < fields.length; i++) {
                fields[i] = new Fields();
                fields[i].makeBlueRoundWithCatAndText(tooltip, value,figure);
            }
        }

        public void setTitleAndDescription(String title, String description) {
            setTitle(title);
            setDescription(description);
        }
    }
}
