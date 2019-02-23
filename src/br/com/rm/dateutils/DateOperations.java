package br.com.rm.dateutils;

import java.util.Calendar;
import java.util.Date;

public class DateOperations {

	public static Date addDays(Date input, int days) {
		return add(Calendar.DAY_OF_MONTH, input, days);
	}
	
	public static Date subtractDays(Date input, int days) {
		return add(Calendar.DAY_OF_MONTH, input, -days);
	}
	
	public static Date addMonths(Date input, int month) {
		return add(Calendar.MONTH, input, month);
	}
	
	public static Date subtractMonths(Date input, int month) {
		return add(Calendar.MONTH, input, -month);
	}
	
	public static Date addYears(Date input, int years) {
		return add(Calendar.YEAR, input, years);
	}
	
	public static Date subtractYears(Date input, int years) {
		return add(Calendar.YEAR, input, -years);
	}
	
	public static Date subtractWeeks(Date input, int weeks) {
		return add(Calendar.WEEK_OF_MONTH, input, -weeks);
	}
	
	public static Date addWeeks(Date input, int weeks) {
		return add(Calendar.WEEK_OF_MONTH, input, weeks);
	}
	
	public static Date subtractHours(Date input, int hours) {
		return add(Calendar.HOUR_OF_DAY, input, -hours);
	}
	
	public static Date addHours(Date input, int hours) {
		return add(Calendar.HOUR_OF_DAY, input, hours);
	}
	
	public static Date subtractMinutes(Date input, int min) {
		return add(Calendar.MINUTE, input, -min);
	}
	
	public static Date addMinutes(Date input, int min) {
		return add(Calendar.MINUTE, input, min);
	}
	
	public static Date removeTimeFromDate(Date input) {
		Calendar output = Calendar.getInstance();
		output.setTime(input);
		output.set(Calendar.HOUR_OF_DAY, 0);
		output.set(Calendar.MINUTE, 0);
		output.set(Calendar.SECOND, 0);
		output.set(Calendar.MILLISECOND, 0);
		return output.getTime();
	}
	
	public static Date getMin(Date date01, Date date02) {
		if(date01 == null || date02 == null) {
			return null;
		}
		
		if(date01.before(date02)) {
			return date01;
		}else {
			return date02;
		}
	}
	
	public static Date getMax(Date date01, Date date02) {
		if(date01 == null || date02 == null) {
			return null;
		}
		
		if(date01.after(date02)) {
			return date01;
		}else {
			return date02;
		}
	}
	
	private static Date add(int field, Date input, int value) {
		if(input == null) {
			return null;
		}
		Calendar output = Calendar.getInstance();
		output.setTime(input);
		output.add(field, value);
		return output.getTime();
	}
}
