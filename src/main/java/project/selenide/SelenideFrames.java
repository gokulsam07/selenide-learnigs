package project.selenide;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

import org.junit.Test;
public class SelenideFrames {
	
	@Test
	public void frames() throws InterruptedException {
		open("https://demo.automationtesting.in/Frames.html");
		switchTo().frame($(byXpath("//iframe[@id='singleframe']")));
		$(byCssSelector("input[type='text']")).setValue("iFrame single test");
		Thread.sleep(2000);
		switchTo().defaultContent();
		$(byXpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
		
		//mulitple iFrame
		switchTo().frame($(byCssSelector("iframe[src='MultipleFrames.html']")));
		$(byXpath("//h5[normalize-space()='Nested iFrames']")).shouldHave(text("Nested iFrames"));
		switchTo().frame(0);
		$(byCssSelector("input[type='text']")).setValue("Inner frame check");
		Thread.sleep(2000);
		switchTo().parentFrame();
		$(byXpath("//h5[normalize-space()='Nested iFrames']")).shouldHave(text("Nested iFrames"));
		switchTo().defaultContent();
		$(byCssSelector("a[href='Index.html']")).shouldHave(visible, text("Home"));
	}
}
