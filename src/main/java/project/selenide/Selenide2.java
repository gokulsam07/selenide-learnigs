package project.selenide;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.title;
import org.junit.Test;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

public class Selenide2 {
	@Test
	public void closing() {
		open("https://google.com");
		System.out.println("Is chrome: "+WebDriverRunner.isChrome());
		System.err.println(title());
		executeJavaScript("window.open()"); //opens a new window
		switchTo().window(1);
		open("https://amazon.com");
		System.err.println(title());
		closeWindow(); //only current tab
		switchTo().window(0);
		System.err.println(title());
		closeWindow();
		Configuration.browser="edge";
		open("https://amazon.com");
		System.err.println("Is Edge:"+WebDriverRunner.isEdge());
		closeWebDriver(); //driver quit
		
	}

}
