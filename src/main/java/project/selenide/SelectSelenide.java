package project.selenide;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
public class SelectSelenide {

	@Test
	public void selectors() throws InterruptedException {
		open("https://demo.guru99.com/test/newtours/register.php");
		$(byCssSelector("select[name='country']")).selectOptionContainingText("INDIA");
		Thread.sleep(2000);

		//bootstrap dropdown
		open("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		$(byCssSelector("button[title='HTML, CSS']")).click();
		ElementsCollection col = $$x("//li/a/label");
		for (SelenideElement sl : col) {
			if(sl.getText().contains("Python")){
				sl.click();
			}
			else if(sl.ancestor("li").getAttribute("class").contains("active")) {
				sl.click();
			}
		}
		Thread.sleep(5000);
	}

}
