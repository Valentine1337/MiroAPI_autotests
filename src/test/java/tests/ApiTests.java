package tests;

import models.createAppCardItem.CreateAppCardItemRequest;
import models.createAppCardItem.CreateAppCardItemResponse;
import models.createBoard.CreateBoardRequest;
import models.createBoard.CreateBoardResponse;
import models.createBoard.requestAssociate.Policy;
import models.createTag.CreateTagRequest;
import models.createTag.CreateTagResponse;
import models.shareBoard.ShareBoardRequest;
import models.shareBoard.ShareBoardResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specs.*;

public class ApiTests {
    //Test common data
    final String testBoardID = "uXjVOwr-MbQ=";

    @Test
    @DisplayName("Создание доски с открытым доступом")
    void createBoardWithOpenPolicy() {
        //Test data for this case
        Policy boardPolicy = new Policy("open");
        String boardName = "Test API",
                boardDescription = "for testing qa_guru";

        CreateBoardRequest request = new CreateBoardRequest
                (boardName, boardPolicy, boardDescription);
        step("Отправляем запрос на создание доски");
        CreateBoardResponse response =
                given()
                        .spec(requestSpec)
                        .basePath("/boards")
                        .body(request)
                        .when()
                        .post()
                        .then()
                        .body(matchesJsonSchemaInClasspath("schemes/create_board.json"))
                        .spec(response201)
                        .extract().as(CreateBoardResponse.class);
        step("Сверяем входные данные с ответом");
        assertThat(response.getDescription()).isEqualTo(request.getDescription());
        assertThat(response.getPolicy()).isEqualTo(request.getPolicy());
    }

    @Test
    @DisplayName("Шэрим доску двум почтовым адресам")
    void shareBoardWithDefaultParams() {
        //Test data for this case
        String boardRole = "guest",
                boardMessage = "Hey there, welcome aboard!";

        ShareBoardRequest request = new ShareBoardRequest(boardRole, boardMessage);
        step("Отправляем запрос на шэринг доски");
        ShareBoardResponse response =
                given()
                        .spec(requestSpec)
                        .basePath("/boards/" + testBoardID + "/members")
                        .body(request)
                        .when()
                        .post()
                        .then()
                        .body(matchesJsonSchemaInClasspath("schemes/share_board.json"))
                        .spec(response201)
                        .extract().as(ShareBoardResponse.class);
        step("Проверяем, что массив из ответа не null");
        assertThat(response.getSuccessful().length).isNotNull();;
    }

    @Test
    @DisplayName("Создаем на доске карточку с 3 синими кругами, повернутыми на 180 градусов, фиолетового цвета")
    void createAppCardItemThreeBlueRoundWithPurpleColor() {
        CreateAppCardItemRequest request = new CreateAppCardItemRequest();
        request.makeBlueRoundsInvertedWithPurpleColor();
        step("Отправляем запрос на создание трех синих кругов, повернутых на 180 градусов с фиолетовой рамкой");
        CreateAppCardItemResponse response =
                given()
                        .spec(requestSpec)
                        .basePath("/boards/" + testBoardID + "/app_cards")
                        .body(request)
                        .when()
                        .post()
                        .then()
                        .body(matchesJsonSchemaInClasspath("schemes/create_app_card_item.json"))
                        .spec(response201)
                        .extract().as(CreateAppCardItemResponse.class);
        step("Проверяем, что геометрия, позиция и цвет совпадаеют с ответом");
        assertThat(response.getGeometry().getHeight()).isEqualTo(request.getGeometry().getHeight());
        assertThat(response.getGeometry().getWidth()).isEqualTo(request.getGeometry().getWidth());
        assertThat(response.getPosition().getX()).isEqualTo(request.getPosition().getX());
        assertThat(response.getPosition().getY()).isEqualTo(request.getPosition().getY());
        assertThat(response.getStyle().getFillColor()).isEqualTo(request.getStyle().getFillColor());
    }

    @Test
    @DisplayName("Создаем на доске карточку с 5 синими квадратами и желтой рамкой")
    void createAppCardItemBThreeBlueSquareWithYellowColor() {
        CreateAppCardItemRequest request = new CreateAppCardItemRequest();
        request.makeBlueSquaresStraightWithYellowColor();
        step("Отправляем запрос на создание 5 синих квадратов с желтой рамкой");
        CreateAppCardItemResponse response =
                given()
                        .spec(requestSpec)
                        .basePath("/boards/" + testBoardID + "/app_cards")
                        .body(request)
                        .when()
                        .post()
                        .then()
                        .body(matchesJsonSchemaInClasspath("schemes/create_app_card_item.json"))
                        .spec(response201)
                        .extract().as(CreateAppCardItemResponse.class);
        step("Проверяем, что геометрия, позиция и цвет совпадаеют с ответом");
        assertThat(response.getGeometry().getHeight()).isEqualTo(request.getGeometry().getHeight());
        assertThat(response.getGeometry().getWidth()).isEqualTo(request.getGeometry().getWidth());
        assertThat(response.getPosition().getX()).isEqualTo(request.getPosition().getX());
        assertThat(response.getPosition().getY()).isEqualTo(request.getPosition().getY());
        assertThat(response.getStyle().getFillColor()).isEqualTo(request.getStyle().getFillColor());
    }

    @Test
    @DisplayName("Создание тэга на доске")
    void createTag() {
        //Test data for this case
        String[] availableColors = {"red", "light_green", "cyan", "yellow", "magenta", "green", "blue",
                "gray", "violet", "dark_blue", "black"};
        CreateTagRequest request = new CreateTagRequest();

        step("Отправляем запросы на проверку всех цветов");
        for (int i = 0; i < availableColors.length; i++) {
            request.createTagWithCustomColorAndTitle(availableColors[i]);
            CreateTagResponse response =
                    given()
                            .spec(requestSpec)
                            .basePath("/boards/" + testBoardID + "/tags")
                            .body(request)
                            .when()
                            .post()
                            .then()
                            .spec(response201)
                            .body(matchesJsonSchemaInClasspath("schemes/create_tag.json"))
                            .extract().as(CreateTagResponse.class);
            assertThat(response.getFillColor()).isEqualTo(request.getFillColor());
            assertThat(response.getTitle()).isEqualTo(request.getTitle());
        }
        step("Сверяем входные данные с ответом");
    }
}
