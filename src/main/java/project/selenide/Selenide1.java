package project.selenide;
import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.Keys;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
public class Selenide1 {
	
	@Test
	public void openTest() {
		//other ways to configure is to use system.setproperty of driver loc or using binary location
		Configuration.browser="edge"; //by default chrome - if not mentioned
		Configuration.baseUrl="https://opensource-demo.orangehrmlive.com";
		Configuration.headless=false; //false by default
		Configuration.screenshots=false; //true by default - takes ss of failed TC
		Configuration.timeout=5000; //by default 4000 ms
		open("/");
		$(byName("username")).setValue("Admin");
		$(byName("password")).should(exist,Duration.ofMillis(5000)).setValue("admin123");;
		getFocusedElement().sendKeys(Keys.TAB,Keys.ENTER);
		$(byCssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module")).shouldHave(text("Dashboard"),visible);
	}
	
	@Test
	public void navigateTests() {
		open("https://opensource-demo.orangehrmlive.com");
		open("https://www.google.com");
		open("https://www.amazon.in");
		System.err.println(title());
		back();
		System.err.println(title());
		back();
		System.err.println(title());
		forward();
		System.err.println(title());
		forward();
		System.err.println(title());
	}

}
