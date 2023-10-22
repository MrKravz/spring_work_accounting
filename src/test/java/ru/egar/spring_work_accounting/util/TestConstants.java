package ru.egar.spring_work_accounting.util;

import ru.egar.spring_work_accounting.employee.Grade;
import ru.egar.spring_work_accounting.employee.Position;
import ru.egar.spring_work_accounting.rate.hour_rate.PaymentSystem;
import ru.egar.spring_work_accounting.task.TaskStatus;
import ru.egar.spring_work_accounting.time_sheet.TimeStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestConstants {
    public static final long EMPLOYEE_ID = 1;
    public static final String EMPLOYEE_NAME = "Test name";
    public static final LocalDate DATE_OF_BIRTHDAY = LocalDate.of(2003, 4, 4);
    public static final Position EMPLOYEE_POSITION_DEVELOPER = Position.DEVELOPER;
    public static final Grade EMPLOYEE_GRADE_JUNIOR = Grade.JUNIOR;
    public static final PaymentSystem PAYMENT_SYSTEM_KPI = PaymentSystem.KPI_PAYMENT;
    public static final long TIME_SHEET_ID = 1;
    public static final TimeStatus TIME_STATUS_TURNOUT = TimeStatus.Turnout;
    public static final LocalDate DATE_START = LocalDate.of(2023, 6, 1);
    public static final LocalDateTime DATE_TIME_START = LocalDateTime.of(DATE_START, LocalTime.NOON);
    public static final LocalDate DATE_END = LocalDate.of(2023, 7, 1);
    public static final LocalDateTime DATE_TIME_END = LocalDateTime.of(DATE_END, LocalTime.NOON);
    public static final long HOUR_RATE_ID = 1;
    public static final long KPI_RATE_ID = 1;
    public static final float KPI_RATE_AGREED_SALARY = 2000.0f;
    public static final int KPI_RATE_AGREED_TASKS_POINT_QUANTITY = 280;
    public static final int EXPECTED_TOTAL_KPI = 12;
    public static final float EXPECTED_TOTAL_SALARY = 600;
    public static final long TASK_ID = 1;
    public static final String TASK_NAME = "Fix bug's";
    public static final String TASK_DESCRIPTION = "Fix bug's in services";
    public static final int TASK_POINTS_NUMBER = 35;
    public static final TaskStatus TASK_STATUS_FINISHED = TaskStatus.FINISHED;
    public static final long TOTAL_ID = 1;
    public static final long BONUS_ID = 1;
    public static final float BONUS_SALARY = 4;
    public static final int KPI_PERCENTAGE = 12;
    public static final int EXPECTED_TIME = 8;
    public static final float EXPECTED_SALARY = 840;
    public static final int TURNOUT_RATE = 105;
    public static final int VACATION_RATE = 105;
    public static final int SICK_DAYS_RATE = 105;
    public static final int BUSINESS_TRIP_RATE = 125;
    public static final int ABSENCE_RATE = 0;
    public static final int OVER_TIME_RATE = 125;
    public static final boolean IS_DELETED = false;
}
