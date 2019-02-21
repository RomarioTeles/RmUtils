package br.com.rm.dateutils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import br.com.rm.dateutils.constants.TimeAgoI18n;

public class TimeAgo {
	
	private static final List<Long> times = Arrays.asList(
	        TimeUnit.DAYS.toMillis(365),
	        TimeUnit.DAYS.toMillis(30),
	        TimeUnit.DAYS.toMillis(1),
	        TimeUnit.HOURS.toMillis(1),
	        TimeUnit.MINUTES.toMillis(1),
	        TimeUnit.SECONDS.toMillis(1) );
	
	private static final List<EnumDateTimeUnit> listDateTimeUnits = Arrays.asList(EnumDateTimeUnit.valuesSingular());
	
	private Map<EnumDateTimeUnit, String> messages;

	public TimeAgo(Locale locale) {
		super();
		this.messages = TimeAgoI18n.getMessages(locale);
	}

	private String toDuration(long duration) {

	    StringBuilder res = new StringBuilder();
	    res.append(this.messages.get(EnumDateTimeUnit.NOW));
	    for(int i=0;i< TimeAgo.times.size(); i++) {
	        Long current = TimeAgo.times.get(i);
	        long temp = duration/current;
	        if(temp>0) {
	        	res = new StringBuilder();
	        	if(temp == 1) {
	        		res.append(getMessage(listDateTimeUnits.get(i), String.valueOf(temp)));
	        	}else {
	        		res.append(getMessage(listDateTimeUnits.get(i).getPlural(), String.valueOf(temp)));
	        	}
	            break;
	        }
	    }
	    return res.toString();
	}

	public String getFormattedTimeAgo(Date date) {
		if(date == null) {
			return this.messages.get(EnumDateTimeUnit.NOW);
		}else {
			Date now = new Date();
			return toDuration(now.getTime() - date.getTime());
		}
	}
	
	private String getMessage(EnumDateTimeUnit enumDateTimeUnit, String arg) {
		return this.messages.get(enumDateTimeUnit).replace(TimeAgoI18n.carac_time, arg);
	}
	
}
