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
>- [x] Добавление товара в избранное
>- [x] Добавление товара в корзину через поиск
>- [x] Добавление нескольких товаров в список сравнения
>- [x] Добавление подарочных сертификатов с разным номиналом
>- [x] Функция 'Узнать о снижении цены' в разделе подарочных сертификатов

## [Сборка в Jenkins](https://jenkins.autotests.cloud/job/011_Diplom_UiAndMobile_valentiniam/)
    gradle clean ${TYPE_OF_UI_TESTS}
    -DstandHost=${STAND}
    -DdeviceHost=${HOST_OF_MOBILE_TESTS}
    -Dthreads=${THREADS}
![](images/screenshots/Jenkins_2.png)
В данной сборке указаны следующие параметры:

_${TYPE_OF_UI_TESTS}_ - тип тестов web или mobile (возможен запуск **web тестов** - в **selenoid**,
**mobile тестов** - в **Browserstack**, на эмуляторе в **Android Studio** c
помощью сервера **Appium**)

_standHost_ - стенд (опция пустая, добавлена ради эмуляции боевого проекта). Указывается в виде URL **https://www.ozon.ru**, **https://www.test-ozon.ru** как пример.

_deviceHost_ - хост для мобильных тестов (**Browserstack**, **emulator**)

_threads_ - количество потоков для запуска теста (от null до 4)

Остальные опции настраиваются с помощью файла .properties, пример лежит в папке **resources**.

![](images/screenshots/Jenkins_2.png)

## Информация о тестах в [Allure report](https://jenkins.autotests.cloud/job/011_Diplom_UiAndMobile_valentiniam/)

### Главное окно

![](images/screenshots/Allure_1.jpg)
_Мобильные тесты_

### Окно с тест-кейсами

![](images/screenshots/Allure_2.png)
_Веб тесты_

### Окно с графиками

![](images/screenshots/Allure_3.jpg)
_Графики веб тестов_

![](images/screenshots/Allure_4.jpg)
_Мобильные тесты_

![](images/screenshots/Allure_5.jpg)
_Графики мобильных тестов_

## Интеграция с [AllureTestOps](https://allure.autotests.cloud/project/1329/dashboards)

### Дашборд проекта

![](images/screenshots/Allure_TO.jpg)

### Список ручных и автотестов
![](images/screenshots/Allure_TO2.jpg)

## Уведомления в Telegram

После завершения тестов отчет о прохождении приходит в Telegram с помощью заранее созданного бота

### Для web тестов
![](images/screenshots/telegram-bot.jpg)