package com.genericUtils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtil extends BaseTest {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String CurentDateandTime() {
		DateFormat date=new SimpleDateFormat("MM_dd_yyyy");
		Date currentDate=new Date();
		return date.format(currentDate).concat(String.valueOf(date.getCalendar().getInstance().getTime())).replace(" ", "").replace(":", "");
	}


}
