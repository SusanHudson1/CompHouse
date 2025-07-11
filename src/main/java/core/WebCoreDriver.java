/*
 * Author: Susan Hudson
 */

package core;

import configuration.ConfigurationService;
import configuration.WebSettings;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
//import org.openqa.selenium.remote.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.ElementNotInteractableException;
import java.time.Duration;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class WebCoreDriver extends Driver {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    public String outPath;
    public String slash;

    @Override
    public void start(Browser browser) throws IOException {
        var webSettings = ConfigurationService.get(WebSettings.class);
        switch (browser)
        {
            case CHROME:
//                WebDriverManager.chromedriver().clearDriverCache().setup();
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless");
//                options.addArguments("--disable-gpu");            	
                webDriver = new ChromeDriver();
//                webDriver.manage().timeouts().pageLoadTimeout(webSettings.getChrome().getPageLoadTimeout(), TimeUnit.SECONDS);
//                webDriver.manage().timeouts().setScriptTimeout(webSettings.getChrome().getScriptTimeout(), TimeUnit.SECONDS);
                webDriver.manage().window().maximize();
//                webDriver.navigate().to(webSettings.getBaseUrl());
                break;
            case FIREFOX:
//                WebDriverManager.firefoxdriver().setup();
//                webDriver = new FirefoxDriver();
//                webDriver.manage().timeouts().pageLoadTimeout(webSettings.getFirefox().getPageLoadTimeout(), TimeUnit.SECONDS);
//                webDriver.manage().timeouts().setScriptTimeout(webSettings.getFirefox().getScriptTimeout(), TimeUnit.SECONDS);
                break;
            case EDGE:
                //_webDriver = new EdgeDriver();
                break;
            case OPERA:
                //_webDriver = new OperaDriver();
                break;
            case SAFARI:
                //_webDriver = new SafariDriver();
                break;
            case INTERNET_EXPLORER:
                //_webDriver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException(browser.name());
        }

//        webDriverWait = new WebDriverWait(webDriver, webSettings.getElementWaitTimeout());

        Wait<WebDriver> webDriverWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(webSettings.getElementWaitTimeout()))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);

 
		slash = FileSystems.getDefault().getSeparator();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String profile = System.getenv().get("USERPROFILE");
		if(profile == null) {
			profile = String.join(slash,"C:","Users","daveh");			// This will probably need changing if USERPROFILE doesn't exist
		}

	    outPath = String.join(slash, profile , "eclipse-workspace", "test-output", "screenshots", "autorun_"+timeStamp );
//	    outPath = String.join(slash, "D:" , "Dev", "CompHouse", "test-output", "screenshots", "autorun_"+timeStamp );
//      System.out.println(outPath);
        
	    File screenShotDir = new File(outPath);
	    screenShotDir.mkdir();
	    
        
        TakesScreenshot scrShot =((TakesScreenshot)webDriver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
        FileUtils.copyFile(srcFile, new File(outPath+slash+timeStamp+"_browser_start.jpg"));	   
	    
    }

    @Override
    public void quit() throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)webDriver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
        FileUtils.copyFile(srcFile, new File(outPath+slash+timeStamp+"_quit.jpg"));	   
	    
        webDriver.quit();
    }

    @Override
    public void goToUrl(String url) throws IOException  {
        webDriver.navigate().to(url);
        TakesScreenshot scrShot =((TakesScreenshot)webDriver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
        FileUtils.copyFile(srcFile, new File(outPath+slash+timeStamp+"_to_URL.jpg"));	   
	    
    }

    @Override
    public String getUrl() throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)webDriver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
        FileUtils.copyFile(srcFile, new File(outPath+slash+timeStamp+"_get_URL.jpg"));	   
        return webDriver.getCurrentUrl();
    }

    @Override
    public Element findElement(By locator) throws IOException  {
        var nativeWebElement =
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Element element = new WebCoreElement(webDriver, nativeWebElement, locator);

        // If we use log decorator.
        Element logElement = new LogElement(element);

        TakesScreenshot scrShot =((TakesScreenshot)webDriver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
        String elementName = element.getText();
        if(elementName.length() > 30) {
        	elementName = elementName.substring(0, 30);
        }
    	if(elementName.contains("/"))elementName = elementName.replace("/", "-");
    	if(elementName.contains(":"))elementName = elementName.replace(":", "-");
    	if(elementName.contains("#"))elementName = elementName.replace("#", "-");
    	if(elementName.contains(">"))elementName = elementName.replace(">", "-");
    	if(elementName.contains("\n"))elementName = elementName.replace("\n", "");
        
        FileUtils.copyFile(srcFile, new File(outPath+slash+timeStamp+"_find_element_"+elementName+".jpg"));
  
        return logElement;
    }

    @Override
    public List<Element> findElements(By locator) throws IOException {
        List<WebElement> nativeWebElements =
                webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        var elements = new ArrayList<Element>();
        for (WebElement nativeWebElement:nativeWebElements) {
            Element element = new WebCoreElement(webDriver, nativeWebElement, locator);
            Element logElement = new LogElement(element);
            elements.add(logElement);
        }
        TakesScreenshot scrShot =((TakesScreenshot)webDriver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
        FileUtils.copyFile(srcFile, new File(outPath+slash+timeStamp+"_find_elements.jpg"));
        
        return elements;
    }

    @Override
    public void waitForAjax() throws IOException {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriverWait.until(d -> (Boolean)javascriptExecutor.executeScript("return window.jQuery != undefined && jQuery.active == 0"));
        TakesScreenshot scrShot =((TakesScreenshot)webDriver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
        FileUtils.copyFile(srcFile, new File(outPath+slash+timeStamp+"_wait_for_Ajax.jpg"));
        
    }

    @Override
    public void waitUntilPageLoadsCompletely() throws IOException {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriverWait.until(d -> javascriptExecutor.executeScript("return document.readyState").toString().equals("complete"));
        TakesScreenshot scrShot =((TakesScreenshot)webDriver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
        FileUtils.copyFile(srcFile, new File(outPath+slash+timeStamp+"_wait_for_page_load.jpg"));
    }

    @Override
    public WebDriverWait getBrowserWait() throws IOException  {
        TakesScreenshot scrShot =((TakesScreenshot)webDriver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
        FileUtils.copyFile(srcFile, new File(outPath+slash+timeStamp+"_wait.jpg"));
        return webDriverWait;
    }
    
    @Override
    public void back() throws IOException {
        webDriver.navigate().back();
        TakesScreenshot scrShot =((TakesScreenshot)webDriver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
        FileUtils.copyFile(srcFile, new File(outPath+slash+timeStamp+"_navigate_back.jpg"));
    }
}
