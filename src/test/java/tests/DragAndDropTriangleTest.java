package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTriangleTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }

    @Test
    void dragAndDropUsingActions() {
        // Открыть базовый URL и путь для Drag & Drop
        open("/drag_and_drop");

        // Локаторы элементов, которые будем перетаскивать
        By draggableElement = By.id("column-a");
        By dropzone = By.id("column-b");

        // Исполнение Drag & Drop с использованием Selenide.actions()
        actions().dragAndDrop($(draggableElement), $(dropzone)).perform();

        // Проверка, что элементы поменялись местами
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void dragAndDropUsingDragAndDropMethod() {
        // Открыть базовый URL и путь для Drag & Drop
        open("/drag_and_drop");

        // Выполнение Drag & Drop с использованием метода dragAndDropTo()
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));

        // Проверка, что элементы поменялись местами
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
