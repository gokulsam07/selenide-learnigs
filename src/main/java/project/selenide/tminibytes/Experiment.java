package project.selenide.tminibytes;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.junit.Test;

import com.codeborne.selenide.Configuration;

public class Experiment {
	
	@Test
	public void samepleTest() throws AWTException {
		open("http://10.194.42.241:8080/D2-Smartview/ui/#d2/nodes/0b0000018002887f");
		Configuration.timeout=30000;
		$(".input-username").shouldBe(visible).setValue("previewuser");
		$(".input-password").shouldBe(visible).setValue("Password@1234567");
		$("select[aria-label='Select a repository']").selectOption("testenv");
		$(".login-btn").click();
		
		StringSelection stringSelection = new StringSelection("C:\\PersonalWorkspace\\SelenideWorkspace\\selenide-automation\\src\\test\\resources\\headshot-default");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		$("li[data-csui-command='addversion']").click();
		Robot robot = new Robot();
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(5000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(5000);
	}

}
