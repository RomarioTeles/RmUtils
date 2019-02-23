package br.com.rm.dateutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.rm.dateutils.constants.DateFormats;

public class DateFormatUtils {

	public static String format(Date input, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(input);
	}
	
	public static Date parse(String dateStr, String format) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			return simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String getDateFormat(String dateStr) {
		for(String format : DateFormats.formats) {
			try {
				Date date = parse(dateStr, format);
				String dateFormatted = format(date, format);
				if(dateStr.equals(dateFormatted)) {
					return format;
				}
			} catch (Exception e) {}
		}
		return null;
	}
	
	public static Date getDateFromString(String date) {
		String format = getDateFormat(date);
		return parse(date, format);
	}
	
}