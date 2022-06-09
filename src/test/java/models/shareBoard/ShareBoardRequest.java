package models.shareBoard;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShareBoardRequest {
    private String[] emails = {"test@yandex.ru","test123@mail.ru"};
    private String
            role,
            message;

    public ShareBoardRequest (String role, String message) {
        setRole(role);
        setMessage(message);
    }
}