package com.kh.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateParse {
	
	public Date noEndDate(String noEndDate) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date date1 = null;
		
		try {
			Date date = sdf1.parse(noEndDate);
			
			long timeInMilliSeconds = date.getTime();
		    date1 = new java.sql.Date(timeInMilliSeconds);
		    
	        
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		return date1;
	}

	public java.sql.Date maEndDate(String date2) {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date date1 = null;
		
		try {
			Date date = sdf1.parse(date2);
			
			long timeInMilliSeconds = date.getTime();
		    date1 = new java.sql.Date(timeInMilliSeconds);
		    
	        
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return date1;
	}
	
}