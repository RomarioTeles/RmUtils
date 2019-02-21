package br.com.rm.main;

import java.util.Date;
import java.util.Locale;

import br.com.rm.dateutils.FormatUtils;
import br.com.rm.dateutils.TimeAgo;
public class Main {

	public static void main(String[] args) {
		 String dateStr = "21/12/2016 00:20:00";
		 Date date = FormatUtils.getDateFromString(dateStr);
		 System.out.println(new TimeAgo(new Locale("pt_BR")).getFormattedTimeAgo(date));
	}

}
