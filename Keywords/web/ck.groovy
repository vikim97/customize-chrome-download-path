package web

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.chrome.ChromeDriverUtil


public class ck {

	@Keyword
	def createChromeWebDriverCustomDownload() {

		String path = System.getProperty("user.dir");

		// Set the default download folder as Data Files folder of project folder
		String DOWNLOAD_FOLDER_PATH = path + File. separator + "Download Files";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put('download.default_directory', DOWNLOAD_FOLDER_PATH);
		chromePrefs.put('browser.download.dir', DOWNLOAD_FOLDER_PATH);
		chromePrefs.put('download.prompt_for_download', false);
		chromePrefs.put('download.directory_upgrade', true);
		chromePrefs.put('plugins.always_open_pdf_externally', true);
		chromePrefs.put('profile.default_content_settings.popups', "0");
		chromePrefs.put('profile.content_settings.exceptions.automatic_downloads.*.setting', "1");
		chromePrefs.put('browser.download.manager.showWhenStarting', false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);

		// Create WebDriver instance with Chrome options
		WebDriver driver = new ChromeDriver(options);
		DriverFactory.changeWebDriver(driver)
	}
}
