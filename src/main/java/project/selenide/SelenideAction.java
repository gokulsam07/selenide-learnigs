package project.selenide;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.*;
import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.chrome.ChromeOptions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
public class SelenideAction {
	
	//@Test
	public void actionsTest() throws InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        Configuration.browserCapabilities = chromeOptions;
		open("https://www.spicejet.com");
		actions().moveToElement($x("//div[contains(text(),'Add-ons')]")).build().perform();
		Thread.sleep(3000);
		$x("//div[normalize-space()='SpiceMax']").click();
		Thread.sleep(3000);
		switchTo().window(1);
		Assert.assertTrue($x("//img").getAttribute("src").contains("topbanner"));
	}
	
	//@Test
	public void draggableTest() {
		open("https://demoqa.com/droppable");
		SelenideElement drag = $("#draggable");
		SelenideElement drop = $("div[id='simpleDropContainer'] p");
		actions().clickAndHold(drag).moveToElement(drop).build().perform();
		refresh();
		actions().dragAndDrop(drag, drop).build().perform();
		Assert.assertTrue(($(byId("droppable")).getCssValue("background-color").equals("rgba(70, 130, 180, 1)")));
	}
	@Test
	public void contextClick() throws InterruptedException {
		open("https://demo.guru99.com/test/simple_context_menu.html");
		$(".context-menu-one.btn.btn-neutral").contextClick();
		$("li[class='context-menu-item context-menu-icon context-menu-icon-quit'] span").click();
		if(switchTo().alert().getText().equals("clicked: quit")) {
			switchTo().alert().accept();
		}
		Thread.sleep(3000);
		$("button[ondblclick='myFunction()']").doubleClick();
		if(switchTo().alert().getText().equals("You double clicked me.. Thank You..")) {
			switchTo().alert().accept(); 
		}
		Thread.sleep(3000);
	}

}
