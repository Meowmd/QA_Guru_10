import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebTest {

public void openMainPage(){
    open("https://github.com/");
}

public void searchForRepository (String repository){
    $(".header-search-input").click();
    $(".header-search-input").setValue("eroshenkoam/allure-example");
    $(".header-search-input").submit();
}

public void openRepositoryLink(String REPOSITORY){
    $(linkText("eroshenkoam/allure-example")).click();
}

    public void openIssueTab() {
        $(partialLinkText("Issues")).click();
    }

    public void checkIssueWithName(Integer issueNumber) {
        $(withText("#" + issueNumber)).should(Condition.exist);
    }
}