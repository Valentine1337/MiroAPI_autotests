# Проект по автотестированию API [Miro](https://developers.miro.com/reference/api-reference)
[<img alt="Ozon" height="150" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_api/master/images/logo/miro.png" width="500"/>](https://miro.com/)

<a name="оглавление"></a>
# Оглавление
- [Технологии и инструменты](#computer-технологии-и-инструменты)
- [Описание проекта](Описание-проекта)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Запуск из терминала](#computer-Запуск-тестов-из-терминала)
- [Отчет в Allure report](#-отчет-в-allure-report)
- [Отчет в Telegram](#-уведомление-в-telegram-при-помощи-бота)
- [Видео пример прохождения тестов](#-видео-пример-прохождения-теста)

## :computer: Технологии и инструменты
<p align="center">
<img height="100" title="Java" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/Java.svg" width="100"/>
<img height="100" title="IntelliJ IDEA" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/Idea.svg" width="100"/>
<img height="100" title="Rest-Assured" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_api/master/images/logo/rest-assured-logo.svg" width="100"/>
<img height="100" title="Github" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/GitHub.svg" width="100"/>
<img height="100" title="JUnit 5" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/Junit5.svg" width="100"/>
<img height="100" title="Gradle" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/Gradle.svg" width="100"/>
<img height="100" title="Allure" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/Allure.svg" width="100"/>
<img height="100" title="Allure TestOps" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/Allure_EE.svg" width="100"/>
<img height="100" title="Jenkins" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/Jenkins.svg" width="100"/>
<img height="100" title="Telegram" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/Telegram.svg" width="100"/>
</p>

<a name="описание"></a>
# Описание проекта
Автоматизирована проверка 4 методов API:
- /boards - создание доски с различными параметрами приватности;
- /boards/{board_id}/members - поделиться доской с выбранными пользователями;
- /boards/{board_id}/app_cards - добавить карточку на доску различной формы, цветы, содержания;
- /boards/{board_id}/tags - добавить тэги на доску различных цветов и названий.

Используются:
- модели (Lombok),
- спецификации (RequestSpecification),
- генерация тестовых данных (Faker),
- конфигурации (Owner),
- проверки (AssertJ),
- шаблоны логирования запросов (AllureRestAssured FILTERS),
- схемы проверки JSON Schema Validator.

## Тест кейсы
>- [x] Создание на доске карточки с 3 синими кругами, повернутыми на 180 градусов, фиолетового цвета
>- [x] Создание на доске карточки с 5 синими квадратами и желтой рамкой
>- [x] Создание доски с открытым доступом
>- [x] Расшарить доску двум почтовым адресам
>- [x] Создание тэга на доске

## [Сборка в Jenkins](https://jenkins.autotests.cloud/job/011_Diplom_Miro_API/)
![](images/screenshots/jenkins.jpg)
Локальный запуск осуществляется командой:
```
gradle clean test -Dthreads=4
```
Где `threads` - количество потоков параллельного запуска тестов.

Остальные 2 параметра `token` и `testBoardId` указываются в файле .properties, пример лежит в папке **resources**.

![](images/screenshots/jenkins2.jpg)
В поле коммент можно ввести уточняющие данные, которые затем отобразятся в отчете, например дату запуска.

## Информация о тестах в [Allure report](https://jenkins.autotests.cloud/job/011_Diplom_Miro_API/allure/)

### Главное окно

![](images/screenshots/allure.jpg)
_Дашбоард_

### Окно с тест-кейсами

![](images/screenshots/allure2.jpg)

### Окно с вложениями

![](images/screenshots/request_allure.jpg)
_Пример вложения запроса_

![](images/screenshots/response_allure.jpg)
_Пример вложения ответа_


## Интеграция с [AllureTestOps](https://allure.autotests.cloud/project/1365/dashboards)

### Дашборд проекта

![](images/screenshots/allure_ee.jpg)

### Список автотестов
![](images/screenshots/allure_ee2.jpg)

## Уведомления в Telegram

После завершения тестов отчет о прохождении приходит в Telegram с помощью заранее созданного бота

### Для web тестов
![](images/screenshots/telegram_bot.jpg)