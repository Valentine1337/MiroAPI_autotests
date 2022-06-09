package models.createTag;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTagResponse {
    private String
            type,
            title,
            fillColor;
}