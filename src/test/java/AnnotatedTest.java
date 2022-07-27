import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedTest {
    private final String REPOSITORY = "eroshenkoam/allure-example";
    private final Integer issueNumber = 1;

    @Test
    void annotatedTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebTest steps = new WebTest();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryLink(REPOSITORY);
        steps.openIssueTab();
        steps.checkIssueWithName(issueNumber);
    }
}