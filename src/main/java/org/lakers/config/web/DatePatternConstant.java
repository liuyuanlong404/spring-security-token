package org.lakers.config.web;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public interface DatePatternConstant {

    String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    String DATE_TIME_PATTERN2 = "yyyy-MM-dd HH:mm";

    String DATE_PATTERN = "yyyy-MM-dd";

    String DATE_PATTERN2 = "yyyyMMdd";

    String DATE_PATTERN3 = "yyyy年MM月dd日";

    String YEAR_PATTERN = "yyyy";

    String YEAR_MONTH_PATTERN = "yyyy-MM";

    String MONTH_DAY_PATTERN = "MM-dd";

    String TIME_PATTERN = "HH:mm:ss";

    String HOUR_MINUTE_PATTERN = "HH:mm";

    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN, Locale.CHINA);

    DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN, Locale.CHINA);

    DateTimeFormatter DATE_FORMATTER2 = DateTimeFormatter.ofPattern(DATE_PATTERN2, Locale.CHINA);

    DateTimeFormatter DATE_FORMATTER3 = DateTimeFormatter.ofPattern(DATE_PATTERN3, Locale.CHINA);

    DateTimeFormatter YEAR_FORMATTER = DateTimeFormatter.ofPattern(YEAR_PATTERN, Locale.CHINA);

    DateTimeFormatter YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern(YEAR_MONTH_PATTERN, Locale.CHINA);

    DateTimeFormatter MONTH_DAY_FORMATTER = DateTimeFormatter.ofPattern(MONTH_DAY_PATTERN, Locale.CHINA);

    DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN, Locale.CHINA);


}
