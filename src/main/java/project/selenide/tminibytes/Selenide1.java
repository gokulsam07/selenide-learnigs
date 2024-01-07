package project.selenide.tminibytes;

import static com.codeborne.selenide.CollectionCondition.anyMatch;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;

public class Selenide1 {

    @Test
    public void test1() {
    	open("https://www.google.com");
    	WebDriverRunner.getWebDriver().manage().window().maximize();
        $(byName("q")).shouldBe(visible).setValue("Testing mini bytes").pressEnter();  
        $$x("//h3").shouldHave(size(12)); 
        $$x("//h3").shouldHave(anyMatch("Find one match with Courses", e->e.getText().contains("Courses")));
        //CollectionCondition default timeout 6s  ////CollectionCondition imp for this
    }
}
