package project.selenide;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

import java.time.Duration;

import org.junit.Test;
public class SelenideTimeouts {
	
	@Test
	public void timeoutsTest() {
		//default selenide timeout is 4000 ms and for page load is 30 s
		open("https://www.hyrtutorials.com/p/waits-demo.html");
		$(byId("btn1")).shouldBe(interactable,exist).click();
		$(byId("btn1")).shouldBe(disabled,Duration.ofSeconds(3));
		$x(("//h3[normalize-space()='Show the textboxes here:']//input[@id='txt1']")).should(appear,Duration.ofSeconds(8));
		$(byId("btn2")).shouldBe(interactable,exist).click();
		$(byId("btn2")).shouldBe(disabled,Duration.ofSeconds(3));
		$x(("//h3[normalize-space()='Show the textboxes here:']//input[@id='txt2']")).should(appear,Duration.ofSeconds(15));
		
	}

}
