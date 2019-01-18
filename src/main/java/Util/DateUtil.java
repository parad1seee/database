package Util;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {

    private static final String datePatternFirst = "dd.MM.yyyy";

    private static final String datePatternSecond = "yyyy-MM-dd";

    private static final DateTimeFormatter dateFormatterFirst =
            DateTimeFormatter.ofPattern(datePatternFirst);

    private static final DateTimeFormatter dateFormatterSecond =
            DateTimeFormatter.ofPattern(datePatternSecond);


    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return dateFormatterFirst.format(date);
    }

    public static String formatSecond(LocalDate date) {
        if (date == null) {
            return null;
        }
        return dateFormatterSecond.format(date);
    }

    public static LocalDate parse(String dateString) {
        try {
            return dateFormatterFirst.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static boolean validDate(String dateString) {
        return DateUtil.parse(dateString) != null;
    }

}
