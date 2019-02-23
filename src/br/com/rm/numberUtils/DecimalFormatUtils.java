package br.com.rm.numberUtils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DecimalFormatUtils {

	public static String decimalFormat(Number value, int minFractionDigits, int maxFractionDigits) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("##,##,##,###.##", otherSymbols);
		df.setMinimumFractionDigits(minFractionDigits);
		df.setMaximumFractionDigits(maxFractionDigits);
		return df.format(value);
	}
	
	public static String decimalFormat(Number value) {
		return decimalFormat(value, 2, 2);
	}
	
	public static String decimalFormatPtBR(Number value, int minFractionDigits, int maxFractionDigits) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(new Locale("pt_br"));
		otherSymbols.setDecimalSeparator(',');
		otherSymbols.setGroupingSeparator('.'); 
		DecimalFormat df = new DecimalFormat("##,##,##,###.##", otherSymbols);
		df.setMinimumFractionDigits(minFractionDigits);
		df.setMaximumFractionDigits(maxFractionDigits);
		return df.format(value);
	}
	
	public static String decimalFormatPtBR(Number value) {
		return decimalFormatPtBR(value, 2, 2);
	}

}
