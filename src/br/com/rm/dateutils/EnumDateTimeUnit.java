package br.com.rm.dateutils;

public enum EnumDateTimeUnit {
	DAY("DAYS"), DAYS(null),
	HOUR("HOURS"), HOURS(null),
	SECOND("SECONDS"), SECONDS(null),
	MINUTE("MINUTES"), MINUTES(null),
	MONTH("MONTHS"), MONTHS(null),
	YEAR("YEARS"), YEARS(null),
	NOW(null);
	
	private String plural;

	private EnumDateTimeUnit(String plural) {
		this.plural = plural;
	}

	public EnumDateTimeUnit getPlural() {
		return EnumDateTimeUnit.valueOf(plural);
	}

	public void setPlural(String plural) {
		this.plural = plural;
	}
	
	public static EnumDateTimeUnit[] valuesSingular() {
		return new EnumDateTimeUnit[] {
			YEAR, MONTH, DAY, HOUR, MINUTE, SECOND
		};
	}
	
}
