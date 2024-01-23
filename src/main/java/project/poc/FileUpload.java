package project.poc;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Test;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;

public class FileUpload {

	// @Test
	public void directFileImport() throws InterruptedException {
		Configuration.timeout = 30000;
		open("http://10.194.42.241:8080/D2-Smartview/ui/#d2/nodes/0c0000018001e5bc");
		$(".input-username").setValue("previewuser");
		$(".input-password").setValue("Password@1234567");
		$("select[aria-label='Select a repository']").selectOption("testenv");
		$(".login-btn.btn-submit").click();
		$("a[title='Add item']").click();
		$x("//a[normalize-space()='Upload file']").click();
		$("input[type='file']").uploadFile(new File("C:\\Documentum\\Files\\demo.docx"));
		$("otc-button[title='Continue']").click();
		Thread.sleep(5000);
	}

	//@Test
	public void robotClassFileImport() throws InterruptedException, AWTException {
		Configuration.timeout = 30000;
		open("http://10.194.42.241:8080/D2-Smartview/ui/#d2/nodes/0c0000018001e5bc");
		$(".input-username").setValue("previewuser");
		$(".input-password").setValue("Password@1234567");
		$("select[aria-label='Select a repository']").selectOption("testenv");
		$(".login-btn.btn-submit").click();
		$("a[title='Add item']").click();
		$x("//a[normalize-space()='Upload file']").click();
		uploadViaRobotClass("C:\\Documentum\\Files\\demo.docx");
		$("otc-button[title='Continue']").click();
		Thread.sleep(5000);
	}

	@Test
	public void robotClassForAddVersion() throws AWTException {
		Configuration.timeout = 30000;
		open("http://10.194.42.241:8080/D2-Smartview/ui/#d2/nodes/0b0000018002887f");
		$(".input-username").setValue("previewuser");
		$(".input-password").setValue("Password@1234567");
		$("select[aria-label='Select a repository']").selectOption("testenv");
		$(".login-btn.btn-submit").click();
		$x("//otc-tristatecheckbox[@title='Select PDFCheckout']").click(ClickOptions.usingJavaScript());
		$x("//a[normalize-space()='Add version']").click();
		uploadViaRobotClass("C:\\Documentum\\Files\\demo.docx");
	}

	private void uploadViaRobotClass(String path) throws AWTException {
		StringSelection stringSelection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		//$x("(//div[@title='Upload files'])[2]").click();
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
