package org.lakers.config.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

/**
 * Created on 2023/3/7 13:36
 *
 * @author lakers
 */
@AllArgsConstructor
@Getter
public enum SensitiveStrategy {

    /**
     * 脱敏策略
     */
    MOBILE(s -> s.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2")),

    ID_CARD(s -> {
        String regex = "(\\d{3})\\d{" + (s.length() - 4) + "}(\\d{1})";
        return s.replaceAll(regex, "$1***********$2");
    }),

    EMAIL(s -> {
        int index = s.indexOf("@");
        if (index > 0) {
            return s.substring(0, 2) + "******" + s.substring(index - 1);
        } else {
            return s;
        }
    }),

    BANK_CARD(s -> {
        String regex = "(\\d{3})\\d{" + (s.length() - 6) + "}(\\d{3})";
        return s.replaceAll(regex, "$1***********$2");
    });

    private final Function<String, String> desensitize;

}
