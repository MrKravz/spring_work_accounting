package ru.egar.spring_work_accounting.util;

import ru.egar.spring_work_accounting.time_sheet.TimeStatus;

import java.time.LocalDate;
import java.util.UUID;

public class TestConstants {
    public static final UUID EMPLOYEE_ID = UUID.randomUUID();
    public static final String EMPLOYEE_NAME = "Test name";
    public static final LocalDate DATE_OF_BIRTHDAY = LocalDate.of(2003, 4, 4);
    public static final UUID TIME_SHEET_ID = UUID.randomUUID();
    public static final TimeStatus TIME_STATUS_TURNOUT = TimeStatus.Turnout;
    public static final LocalDate DATE_START = LocalDate.of(2023, 6, 1);
    public static final LocalDate DATE_END = LocalDate.of(2023, 7, 1);
    public static final UUID RATE_ID = UUID.randomUUID();
    public static final UUID TOTAL_ID = UUID.randomUUID();
    public static final int KPI_PERCENTAGE = 100;
    public static final int EXPECTED_TIME = 8;
    public static final float EXPECTED_SALARY = 840;
    public static final int TURNOUT_RATE = 105;
    public static final int VACATION_RATE = 105;
    public static final int SICK_DAYS_RATE = 105;
    public static final int BUSINESS_TRIP_RATE = 125;
    public static final int ABSENCE_RATE = 0;
    public static final int OVER_TIME_RATE = 125;
}
