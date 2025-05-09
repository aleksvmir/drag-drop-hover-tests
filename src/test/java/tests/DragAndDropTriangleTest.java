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
    void dragAndDropUsingActionsTest() {
        open("/drag_and_drop");
        By draggableElement = By.id("column-a");
        By dropzone = By.id("column-b");
        actions().dragAndDrop($(draggableElement), $(dropzone)).perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void dragAndDropUsingDragAndDropMethodTest() {
        open("/drag_and_drop");
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
