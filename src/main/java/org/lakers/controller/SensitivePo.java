package org.lakers.controller;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;

/**
 * Created on 2023/3/8 11:22
 *
 * @author lakers
 */
@Data
public class SensitivePo {

    private LocalDateTime dateTime;

    private LocalDate localDate;

    private YearMonth month;

}
