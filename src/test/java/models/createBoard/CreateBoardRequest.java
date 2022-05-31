package models.createBoard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.createBoard.requestAssociate.Policy;

@Data
@Builder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBoardRequest {
    private String name;
    private Policy policy;
    private String description;

    public CreateBoardRequest(String name, Policy policy, String description) {
        setName(name);
        setPolicy(policy);
        setDescription(description);
    }
}
