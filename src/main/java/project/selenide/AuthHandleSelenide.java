package project.selenide;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;
public class AuthHandleSelenide {

	@Test
	public void testAuth() throws InterruptedException {
		open("https://the-internet.herokuapp.com/basic_auth","","admin","admin"); 
		Thread.sleep(5000);
		$(byCssSelector("div[class='example'] p")).shouldBe(visible,text("Congratulations! You must have the proper credentials."));
	}
}
