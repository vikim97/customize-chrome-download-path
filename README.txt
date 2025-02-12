This Project has 2 ways to customize the download folder path
- Way 1: 
+ Using CustomKeywords.'web.ck.createChromeWebDriverCustomDownload'() as a replacement of WebUI.openBrowser()
+ This keyword will download the file under the Download Files folder, you can modify the download path based on your desired one
+ The Custom Keyword will override the Chrome Desired Caps in Project Settings

- Way 2:
+ Using Chrome Desired Caps. You need to modify the value of 'download.default_directory' & 'browser.download.dir' based on your desired download folder path

