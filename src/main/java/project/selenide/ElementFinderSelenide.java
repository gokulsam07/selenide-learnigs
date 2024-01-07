package project.selenide;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.tagName;

import org.junit.Test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class ElementFinderSelenide {

	@Test
	public void findEle() {
		open("https://amazon.in");
		 ElementsCollection collection = $$(tagName("img"));
		 for (SelenideElement selenideElement : collection) { 
			System.out.println(selenideElement);
		}
	}

}
