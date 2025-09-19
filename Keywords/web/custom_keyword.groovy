package web

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.chrome.ChromeDriverUtil
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.edge.EdgeOptions
import com.kms.katalon.core.webui.driver.DriverFactory


import org.openqa.selenium.firefox.FirefoxOptions as FirefoxOptions



public class custom_keyword {
	
	String path = System.getProperty("user.dir");
	// Set the default download folder as Download Files folder of project folder
	String DOWNLOAD_FOLDER_PATH = path + File.separator + "Data Files";
	@Keyword
	def createChromeWebDriverCustomDownload() {

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
		
		//Enable/Disable this for headless mode
		/*options.addArguments("--headless=new")*/
		options.addArguments("--window-size=1920,1080")
		options.setExperimentalOption("prefs", chromePrefs);

		WebDriver driver = new ChromeDriver(options);

		DriverFactory.changeWebDriver(driver)
	}
	@Keyword
	def createFirefoxWebDriverCustomDownload() {
		
		FirefoxOptions options = new FirefoxOptions()
		
		options.addPreference('browser.download.folderList', 2)
		options.addPreference('browser.download.dir', DOWNLOAD_FOLDER_PATH)
		
		//Enable/Disable this for headless mode
		/*		options.addArguments("--headless=new")
		 */
		options.addArguments("--window-size=1920,1080")
		
		WebDriver driver = new FirefoxDriver(options);
		
		DriverFactory.changeWebDriver(driver)
		
	}
	
	@Keyword
	def createMSEdgeWebDriverCustomDownload() {
		
		EdgeOptions options = new EdgeOptions()

    // 2. Create a Map for experimental preferences like download paths
    HashMap<String, Object> prefs = new HashMap<>()
    prefs.put("download.default_directory", DOWNLOAD_FOLDER_PATH)
    prefs.put("download.prompt_for_download", false)
    options.setExperimentalOption("prefs", prefs)

    // 3. Add arguments for headless mode and window size
	/*options.addArguments("--headless=new")*/
    options.addArguments("--window-size=1920,1080")
  //  options.addArguments("--no-sandbox") // Recommended for stability
   // options.addArguments("--disable-dev-shm-usage") // Recommended for stability

    // 4. NOW, create the driver instance, passing the fully configured options object
    WebDriver driver = new EdgeDriver(options)

    // 5. Register the new driver with the factory
    DriverFactory.changeWebDriver(driver)
	}

	
}
