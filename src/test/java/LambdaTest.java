import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaTest {

    private final String REPOSITORY = "eroshenkoam/allure-example";
    private final Integer issueNumber = 2;


    @Test
    void lambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open github", () -> {
            open("https://github.com/");
        });
        step("Find repo name " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Click repo " + REPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });
        step("Click Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Check Issue number " + issueNumber, () -> {
            $(withText("#" + issueNumber)).should(Condition.exist);
        });
    }
}