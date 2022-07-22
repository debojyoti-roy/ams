package com.drps.ams.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class DateUtils {
	
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	
	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private static final String TIME_FORMAT = "HH:mm";
	
	public static String dateToString(Date date) {		
		String strDate = null;
		if(date!=null) {
			DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
			strDate = dateFormat.format(date); 
		}
		return strDate;
	}
	
	public static String dateTimeToString(Date date) {		
		String strDate = null;
		if(date!=null) {
			DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
			strDate = dateFormat.format(date); 
		}
		return strDate;
	}
	
	public static String retunStringTiming(Date date) {		
		String strTiming = null;
		if(date!=null) {
			DateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
			strTiming = dateFormat.format(date); 
		}
		return strTiming;
	}
	
	public static Integer timeDifferrenceInHour(String datetime) {

	    Calendar date = Calendar.getInstance();
	    try {
			date.setTime(new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH).parse(datetime));
		} catch (ParseException e) {			
			e.printStackTrace();
		}
	    Calendar now = Calendar.getInstance(); // Get time now
	    long differenceInMillis = now.getTimeInMillis() - date.getTimeInMillis();
	    long differenceInHours = (differenceInMillis) / 1000L / 60L / 60L; // Divide by millis/sec, secs/min, mins/hr
	    return (int)differenceInHours;

	}	
	

	@SuppressWarnings("unlikely-arg-type")
	public static Boolean checkTollFreeDate() {
		
		Date date = new Date();
		
		String tollFreeMonth = "JUNE";
	    
		Boolean isTollFreeDate = Boolean.FALSE;		
		
		Calendar calendar = GregorianCalendar.getInstance();
	    calendar.setTime(date);	    
	    
	    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	    
	    LocalDate currentDate = LocalDate.parse(DateUtils.dateToString(new Date()));
	    
	    Month month = currentDate.getMonth();
	    
	    if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY || tollFreeMonth.equalsIgnoreCase(String.valueOf(month)))
	    {
	    	isTollFreeDate = Boolean.TRUE;
	    	
	    	//return isTollFreeDate;
	    	return Boolean.FALSE;
	    }	    
		
		return isTollFreeDate;
	}	
	
}
