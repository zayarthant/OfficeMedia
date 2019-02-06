package com.office.media.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtil {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static DateTimeFormatter simpleDateTimeFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static LocalDate toLocalDate(Date date) {
		return LocalDate.parse(simpleDateFormat.format(date));
	}

	public static String formatDayMonth(Date date) {
		return new SimpleDateFormat("MMMM dd").format(date);
	}

	public static String formatDayMonthYear(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	public static LocalDateTime toLocalDateTime(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static Date subtractDayFrom(Date date, long days) {
		return new Date(date.getTime() - days * 24 * 3600 * 1000);
	}

	public static LocalDate subtractDayFrom(LocalDate date, long days) {
		return date.minusDays(days);
	}

	public static Date toDate(LocalDate localDate) {
		try {
			return simpleDateFormat.parse(localDate.toString());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String toDateString(Date date) {
		return simpleDateFormat.format(date);
	}

	public static String toDateString(LocalDate localDate) {
		return simpleDateFormat.format(localDate);
	}

	public static String toDateTimeString(LocalDateTime localDateTime) {
		return localDateTime.format(simpleDateTimeFormater);
	}

	public static String timeAgoFrom(Date date) {
		return timeAgoFrom(toLocalDateTime(date));
	}

	public static String timeAgoFrom(LocalDateTime localDateTime) {
		Duration duration = Duration.between(localDateTime, LocalDateTime.now());
		long minus = duration.toMinutes();
		if (minus < 1)
			return " Just Now";
		else if (minus < 60)
			return minus + " minus ago";
		long hours = duration.toHours();
		if (hours < 24)
			return hours + " hours ago";
		long days = duration.toDays();
		if (days < 9)
			return days + " days ago";
		return toDateTimeString(localDateTime);
	}
}
