package br.com.rm.dateutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.rm.exceptions.DateUtilsException;

public class DateUtils {

	public static String format(Date input, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(input);
	}
	
	public static Date parse(String dateStr, String format) throws DateUtilsException {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			return simpleDateFormat.parse(dateStr);
		} catch (Exception e) {
			throw new DateUtilsException();
		}
	}
	
	public static String getDateFormat(String dateStr) {
		for(String format : DateFormats.formats) {
			try {
				parse(dateStr, format);
				return format;
			} catch (DateUtilsException e) {}
		}
		return null;
	}
	
	public static Date getDateFromString(String date) {
		String format = getDateFormat(date);
		try {
			return parse(date, format);
		} catch (DateUtilsException e) {
			return null;
		}
	}
}