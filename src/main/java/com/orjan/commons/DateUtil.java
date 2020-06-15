package com.orjan.commons;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public final class DateUtil {


	public static String getDateDiffAsToday(LocalDate l) {
		if(null == l) {
			return "";
		}

		final LocalDate now = LocalDate.now(); // gets localDate
		final Period diff = Period.between(l, now); // difference between the dates is calculated

		return diff.getYears() + " years, " + diff.getMonths() + " months, " + diff.getDays() + " days";
	}

	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
