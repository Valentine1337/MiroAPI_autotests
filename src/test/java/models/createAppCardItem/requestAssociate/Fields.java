package models.createAppCardItem.requestAssociate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fields {
        private String iconShape,
                fillColor,
                iconUrl,
                textColor,
                tooltip,
                value;

        public void makeBlueRoundWithCatAndText(String tooltip, String value, String figure) {
            setIconShape(figure);
            setTooltip(tooltip);
            setValue(value);
            setTextColor("#1a1a1a");
            setFillColor("#2fa3fe");
            setIconUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Gatto_europeo4.jpg/250px-Gatto_europeo4.jpg");
        }
}
