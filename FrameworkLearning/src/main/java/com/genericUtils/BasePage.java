package com.genericUtils;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;


import static com.genericUtils.AutoConstants.DATE_FORMAT;
import static com.genericUtils.AutoConstants.EXPLICIT_WAIT;
import static org.testng.Assert.assertEquals;

public class BasePage extends BaseTest {
    /* captureScreenshot() return the screenshot of current page*/
    public static File captureScreenshot(WebDriver driver, String name) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) (driver);
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/Execution Status/ScreenShots/" + name + currentTime() + 100000000 + new Random().nextInt(900000000) + ".png";
        informationPrint("ScreenShot is accessible in " + path);
        File dest = new File(path);
        FileUtils.copyFile(src, dest);
        return dest;
    }
    public static void takeScreenShortAndPrintInfo( WebElement element) throws IOException {
        File Path = BasePage.captureScreenshot(driver,  "Element " + BasePage.currentDateAndTime());
        String screenshotPath = Path.getPath();
        screenshotPath = screenshotPath.replace(System.getProperty("user.dir")+"/Execution Status/ScreenShots/Element issue/", "");
        logger.log(LogStatus.WARNING, logger.addScreenCapture(screenshotPath));
        logger.log(LogStatus.WARNING, element.toString()+" is not accessible ");
    }
    public static void informationPrint(String info) {
        logger.log(LogStatus.INFO, info);
    }

    /* currentTime() will return only current time*/
    public static String currentTime() {
        DateFormat date = new SimpleDateFormat("MM_dd");
        Date currentDate = new Date();
        Date time = Calendar.getInstance().getTime();
        return date.format(currentDate).replace("_", "").concat(String.valueOf(time.getHours())).concat(String.valueOf(time.getMinutes()));
    }

    public static String currentDateAndTime() {
        DateFormat date = new SimpleDateFormat("MM_dd_yyyy");
        Date currentDate = new Date();
        return date.format(currentDate).concat(String.valueOf(date.getCalendar().getInstance().getTime())).replace(" ", "").replace(":", "");
    }

    public static String getTitle(String title) {
        String actualTitle = null;
        Boolean result = elementIsVisible("//i[@class='fas fa-home']/../../..//li[.='" + title + "']");
        if (result) {
            actualTitle = driver.findElement(By.xpath("//i[@class='fas fa-home']/../../..//li[.='" + title + "']")).getText();
        }
        return actualTitle;
    }

    public static void verifyTitle(String expectedTitle) {
        // compare Current title with expected title
        try {
            assertEquals(getTitle(expectedTitle), expectedTitle);
            logger.log(LogStatus.PASS, "Title is matching: " + expectedTitle);
        } catch (Exception e) {
            logger.log(LogStatus.WARNING, "Title is not matching; Expected title is : " + expectedTitle);
            logger.log(LogStatus.WARNING, "Actual title is: " + driver.getTitle());
            SoftAssert softAssert = new SoftAssert();
            softAssert.fail("Title not matching");
        }
    }

    public static Boolean elementIsVisible(String xpath) {
        boolean result;
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = true;
        } catch (Exception exception) {
            informationPrint(String.valueOf(exception));
            result = false;
        }
        return result;
    }
    public static boolean  getElement(WebElement element){
        boolean result;
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            result = true;
        } catch (Exception exception) {
            informationPrint(String.valueOf(exception));
            result = false;
        }
        return result;
    }

    public static void pageRefresh() {
        driver.navigate().refresh();
    }

    public static void navigateToBackPage() {
        driver.navigate().back();
    }

    public static void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(driver,(EXPLICIT_WAIT));
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
        new Actions(driver).pause(2000).build().perform();
    }
    public static void zoomInPageAndTakeScreenShort(WebElement element) throws IOException {
        pageZoomIn();
        takeScreenShortAndPrintInfo(element);
        pageZoomSetBackToNormal();
    }
    public static void elementClick(WebElement element) throws IOException {
        if(getElement(element)){
            builder.moveToElement(element).click(element).build().perform();
        }
        else {
            zoomInPageAndTakeScreenShort(element);
        }

    }
    public static void elementClear(WebElement element) throws IOException {
        if(getElement(element)){
            builder.moveToElement(element).click(element).keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .sendKeys(Keys.BACK_SPACE)
                    .build()
                    .perform();
        }
        else {
            zoomInPageAndTakeScreenShort(element);
        }
    }
    public static void enterValue(WebElement element, String value) throws IOException {
        if(getElement(element)){
            builder.click(element).sendKeys(value).build().perform();
        }
        else {
            zoomInPageAndTakeScreenShort(element);
        }
    }
    public static void scrollTillElement(WebElement element){
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public static String getValueOfElement(WebElement element) throws IOException {
        String value = null;
        if(getElement(element)){
            scrollTillElement(element);
            value=element.getText();
        }
        else {
            zoomInPageAndTakeScreenShort(element);
        }
        return  value;
    }
    public static  void pageZoomIn(){
        for(int i=0; i<4; i++){
            driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
        }
    }
    public static  void pageZoomSetBackToNormal(){
        driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
    }
    public static void selectByVisibleText(WebElement element, String text){
        try{
            Select select=new Select(element);
            select.selectByVisibleText(text);}
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Empty dropdown");
        }
    }
    public static void selectByIndex(WebElement element, int index){
        try{ Select select=new Select(element);
            select.selectByIndex(index);}
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Empty dropdown");
        }
    }
    public static void selectByValue(WebElement element, String value){
        try{ Select select=new Select(element);
            select.selectByValue(value);}
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Empty dropdown");
        }
    }
    public static void selectFromList(WebElement element, String value) throws IOException {
        Select select=new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement option:options) {
            if(option.getText().equalsIgnoreCase(value)){
                elementClick(option);
                break;
            }
        }

    }
    public static String addDaysToDate( String days) {
        DateFormat dateformat=new SimpleDateFormat(DATE_FORMAT);
        Date currentDate=new Date();
        String date = dateformat.format(currentDate);
        Calendar c = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        try {
            Date myDate = df.parse(date.trim());
            c.setTime(myDate);
            c.add(Calendar.DATE, Integer.parseInt(days));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String toDate = df.format(c.getTime());
        return toDate;
    }
    /**
     * @param days
     * @return string
     */
    public static String subtractDaysFromDate( String days) {
//        DateFormat dateformat=new SimpleDateFormat(DATE_FORMAT);
//        Date currentDate=new Date();
        String date ="2/13/2020";
//                dateformat.format(currentDate);
        Calendar c = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        try {
            Date myDate = df.parse(date.trim());
            c.setTime(myDate);
            c.add(Calendar.DATE, (Integer.parseInt(days) * -1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String toDate = df.format(c.getTime());
        return toDate;
    }
    public static WebElement givenList_shouldReturnARandomElement(List<WebElement> elements) {
        List<WebElement>givenList = new ArrayList<>(elements);
        Random rand = new Random();
        WebElement randomElement = givenList.get(rand.nextInt(givenList.size()-1));
        return randomElement;
    }
}