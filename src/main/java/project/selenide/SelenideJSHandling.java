package project.selenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

import org.junit.Test;

public class SelenideJSHandling {

	@Test
	public void alerts() {
		open("https://demo.automationtesting.in/Alerts.html");
		$(byCssSelector(".btn.btn-danger")).click();
		if (switchTo().alert().getText().equals("I am an alert box!")) {
			switchTo().alert().accept();
		}
		$(byXpath("//a[normalize-space()='Alert with OK & Cancel']")).click();
		$(byCssSelector(".btn.btn-primary")).click();
		if (switchTo().alert().getText().equals("Press a Button !")) {
			switchTo().alert().dismiss();
		}
		$(byCssSelector(".analystic[href='#Textbox']")).click();
		$(byCssSelector(".btn.btn-info")).click();
		if (switchTo().alert().getText().equals("Please enter your name")) {
			switchTo().alert().sendKeys(" Gokul");
			switchTo().alert().accept();
		}
		System.err.println($(byCssSelector("#demo1")).shouldHave(visible,
				text("Hello Gokul How are you today")));

	}

}
