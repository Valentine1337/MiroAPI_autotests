# Проект по автотестированию API [Miro](https://developers.miro.com/reference/api-reference)
[<img alt="Ozon" height="150" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_api/master/images/logo/miro.png" width="500"/>](https://miro.com/)

<a name="оглавление"></a>
# Оглавление
1. [Технологии](#технологии)
2. [Описание проекта](#описание)
3. [Запуск тестов](#запуск_локально)
    1. [Запуск тестов локально](#запуск_локально)
    2. [Запуск тестов в Jenkins](#запуск_дженкинс)
4. [Jenkins](#дженкинс)
5. [Результаты тестов в телеграм](#телеграм)
6. [Allure TestOps](#проект)
    1. [Проект](#проект)
    2. [Интеграция с Jenkins](#интеграция)
    3. [Dashboard](#дашборд)
    
<a name="технологии"></a>   
## Технологии, используемые в данном проекте
[<img alt="Java" height="100" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/Java.svg" width="100"/>](https://www.java.com/)
[<img alt="IDEA" height="100" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/Idea.svg" width="100"/>](https://www.jetbrains.com/idea/)
[<img alt="Ozon" height="100" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_api/master/images/logo/rest-assured-logo.svg" width="100"/>](https://rest-assured.io/)
[<img alt="Github" height="100" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/GitHub.svg" width="100"/>](https://github.com/)
[<img alt="JUnit 5" height="100" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/Junit5.svg" width="100"/>](https://junit.org/junit5/)
[<img alt="Gradle" height="100" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/Gradle.svg" width="100"/>](https://gradle.org/)
[<img alt="Allure" height="100" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/Allure.svg" width="100"/>](https://github.com/allure-framework/allure2)
[<img alt="Allure_EE" height="100" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/Allure_EE.svg" width="100"/>](https://qameta.io/)
[<img alt="Jenkins" height="100" src="https://raw.githubusercontent.com/Valentine1337/qa_guru_diplom_uiAndMobile/master/images/logo/Jenkins.svg" width="100"/>](https://www.jenkins.io/)

[К оглавлению ⬆](#оглавление)
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
✓ Добавление товара в избранное

✓ Добавление товара в корзину через поиск

✓ Добавление нескольких товаров в список сравнения

✓ Добавление подарочных сертификатов с разным номиналом

✓ Функция 'Узнать о снижении цены' в разделе подарочных сертификатов

✓ Подсказки 'Поддержка производителя' у подарочного сертификата

✓ Выпадающие меню в разделе 'Помощь'

✓ Поиск новостей в разделе 'Новости'

✓ Работоспособность всех кнопок 'Начать продавать'

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