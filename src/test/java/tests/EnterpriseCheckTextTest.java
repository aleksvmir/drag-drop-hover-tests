package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class EnterpriseCheckTextTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
        // Configuration.holdBrowserOpen = true;
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }

    @Test
    void EnterpriseCheckTest() {
        // Открыть главную страницу GitHub
        open(Configuration.baseUrl);
        // Открыть раздел Enterprise через наведение на Solutions
        $("nav").$(byTagAndText("button", "Solutions")).hover();
        $("[href='/enterprise']").click();
        // Проверить наличие заголовка "The AI-powered developer platform"
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }
}
