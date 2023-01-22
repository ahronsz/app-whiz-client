package com.whiz.service.client.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class Util {

    private Util() {}

    public static Byte getYearsByLocalDate(LocalDate localDate) {
        return (byte) ChronoUnit.YEARS.between(localDate, LocalDate.now());
    }
}
