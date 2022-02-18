package com.genericUtils;

class AutoConstants {
    public static final long PAGE_LOAD_TIMEOUT = 30;
    public static final long  IMPLICIT_WAIT = 30;
    public static final long  EXPLICIT_WAIT = 40;
    public static final String CHROME_DRIVER_PATH=System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe";
    public static final String CHROME_DRIVER_KEY="webdriver.chrome.driver";
    public static final String FIREFOX_DRIVER_KEY="webdriver.gecko.driver";
    public static final String FIREFOX_DRIVER_PATH=System.getProperty("user.dir") + "/src/test/resources/geckodriver.exe";
    public static final  String DATE_FORMAT="MM/dd/yyyy";
}
