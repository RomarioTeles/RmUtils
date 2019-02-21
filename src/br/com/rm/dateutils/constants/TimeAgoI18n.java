package br.com.rm.dateutils.constants;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import br.com.rm.dateutils.EnumDateTimeUnit;

public class TimeAgoI18n {
	public static final String carac_time="#TIME#";
	private static String prettyFormatPtBr = carac_time+" %s atrás.";
	private static String prettyFormatEn = carac_time+" %s ago.";
	private static String prettyFormatEs = "hace "+ carac_time+" %s.";
	
	private static final Map<Locale, Map<EnumDateTimeUnit, String>> mapI18n;
	
	static {
		Map<EnumDateTimeUnit, String> ptBr = new HashMap<EnumDateTimeUnit, String>();
		Map<EnumDateTimeUnit, String> en = new HashMap<EnumDateTimeUnit, String>();
		Map<EnumDateTimeUnit, String> es = new HashMap<EnumDateTimeUnit, String>();
		
		ptBr.put(EnumDateTimeUnit.NOW, "agora mesmo.");
		ptBr.put(EnumDateTimeUnit.SECOND, String.format(prettyFormatPtBr, "segundo"));
		ptBr.put(EnumDateTimeUnit.SECONDS, String.format(prettyFormatPtBr, "segundos"));
		ptBr.put(EnumDateTimeUnit.MINUTE, String.format(prettyFormatPtBr, "minuto"));
		ptBr.put(EnumDateTimeUnit.MINUTES, String.format(prettyFormatPtBr, "minutos"));
		ptBr.put(EnumDateTimeUnit.HOUR, String.format(prettyFormatPtBr, "hora"));
		ptBr.put(EnumDateTimeUnit.HOURS, String.format(prettyFormatPtBr, "horas"));
		ptBr.put(EnumDateTimeUnit.DAY, String.format(prettyFormatPtBr, "dia"));
		ptBr.put(EnumDateTimeUnit.DAYS, String.format(prettyFormatPtBr, "dias"));
		ptBr.put(EnumDateTimeUnit.MONTH, String.format(prettyFormatPtBr, "mês"));
		ptBr.put(EnumDateTimeUnit.MONTHS, String.format(prettyFormatPtBr, "meses"));
		ptBr.put(EnumDateTimeUnit.YEAR, String.format(prettyFormatPtBr, "ano"));
		ptBr.put(EnumDateTimeUnit.YEARS, String.format(prettyFormatPtBr, "anos"));
		
		es.put(EnumDateTimeUnit.NOW, "ahora mismo.");
		es.put(EnumDateTimeUnit.SECOND, String.format(prettyFormatEs, "segundo"));
		es.put(EnumDateTimeUnit.SECONDS, String.format(prettyFormatEs, "segundos"));
		es.put(EnumDateTimeUnit.MINUTE, String.format(prettyFormatEs, "minuto"));
		es.put(EnumDateTimeUnit.MINUTES, String.format(prettyFormatEs, "minutos"));
		es.put(EnumDateTimeUnit.HOUR, String.format(prettyFormatEs, "hora"));
		es.put(EnumDateTimeUnit.HOURS, String.format(prettyFormatEs, "horas"));
		es.put(EnumDateTimeUnit.DAY, String.format(prettyFormatEs, "día"));
		es.put(EnumDateTimeUnit.DAYS, String.format(prettyFormatEs, "días"));
		es.put(EnumDateTimeUnit.MONTH, String.format(prettyFormatEs, "mes"));
		es.put(EnumDateTimeUnit.MONTHS, String.format(prettyFormatEs, "meses"));
		es.put(EnumDateTimeUnit.YEAR, String.format(prettyFormatEs, "año"));
		es.put(EnumDateTimeUnit.YEARS, String.format(prettyFormatEs, "años"));
		
		
		en.put(EnumDateTimeUnit.NOW, "now.");
		en.put(EnumDateTimeUnit.SECOND, String.format(prettyFormatEn, "second"));
		en.put(EnumDateTimeUnit.SECONDS, String.format(prettyFormatEn, "seconds"));
		en.put(EnumDateTimeUnit.MINUTE, String.format(prettyFormatEn, "minute"));
		en.put(EnumDateTimeUnit.MINUTES, String.format(prettyFormatEn, "minutes"));
		en.put(EnumDateTimeUnit.HOUR, String.format(prettyFormatEn, "hour"));
		en.put(EnumDateTimeUnit.HOURS, String.format(prettyFormatEn, "hours"));
		en.put(EnumDateTimeUnit.DAY, String.format(prettyFormatEn, "day"));
		en.put(EnumDateTimeUnit.DAYS, String.format(prettyFormatEn, "days"));
		en.put(EnumDateTimeUnit.MONTH, String.format(prettyFormatEn, "month"));
		en.put(EnumDateTimeUnit.MONTHS, String.format(prettyFormatEn, "months"));
		en.put(EnumDateTimeUnit.YEAR, String.format(prettyFormatEn, "year"));
		en.put(EnumDateTimeUnit.YEARS, String.format(prettyFormatEn, "years"));
		
		
		mapI18n = new HashMap<Locale, Map<EnumDateTimeUnit,String>>();
		mapI18n.put(new Locale("pt_BR"), ptBr);
		mapI18n.put(new Locale("en"), en);
		mapI18n.put(new Locale("es"), es);
	}
	
	public static Map<EnumDateTimeUnit, String> getMessages(Locale locale){
		Map<EnumDateTimeUnit, String> output = mapI18n.get(locale);
		if(output == null) {
			return mapI18n.get(new Locale("en"));
		}
		return output;
	}

}
