package ru.egar.spring_work_accounting.util;

import ru.egar.spring_work_accounting.define.payment_strategy.ComputePaymentStrategy;
import ru.egar.spring_work_accounting.define.payment_strategy.ComputeTurnoutStrategy;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.rate.Rate;
import ru.egar.spring_work_accounting.time_sheet.TimeSheet;
import ru.egar.spring_work_accounting.time_sheet.TimeStatus;
import ru.egar.spring_work_accounting.total.Total;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

import static ru.egar.spring_work_accounting.util.TestConstants.*;

public class TestModels {

    public final static Employee EMPLOYEE;
    public final static Rate RATE;
    public final static TimeSheet TIME_SHEET;
    public final static Total TOTAL;
    public final static ComputePaymentStrategy EXPECTED_STRATEGY;
    public final static Set<TimeSheet> TIME_SHEETS;
    public final static Set<TimeStatus> DISTINCT_TIME_STATUSES;


    static {
        RATE = Rate.builder()
                .id(RATE_ID)
                .turnoutRate(TURNOUT_RATE)
                .vacationRate(VACATION_RATE)
                .sickDaysRate(SICK_DAYS_RATE)
                .businessTripRate(BUSINESS_TRIP_RATE)
                .absenceRate(ABSENCE_RATE)
                .overTimeRate(OVER_TIME_RATE)
                .build();
        TIME_SHEET = TimeSheet.builder()
                .id(TIME_SHEET_ID)
                .timeSpan(EXPECTED_TIME)
                .timeStatus(TimeStatus.Turnout)
                .date(LocalDate.now())
                .build();
        TIME_SHEETS = Collections.singleton(TIME_SHEET);
        EMPLOYEE = Employee.builder()
                .id(EMPLOYEE_ID)
                .name(EMPLOYEE_NAME)
                .dateOfBirthDay(DATE_OF_BIRTHDAY)
                .rate(RATE)
                .tasks(Collections.emptySet())
                .timeSheets(TIME_SHEETS)
                .totals(Collections.emptySet())
                .build();
        EXPECTED_STRATEGY = new ComputeTurnoutStrategy();
        DISTINCT_TIME_STATUSES = Collections.singleton(TimeStatus.Turnout);
        TOTAL = Total.builder()
                .id(TOTAL_ID)
                .totalWorkedTime(EXPECTED_TIME)
                .kpiPercentage(KPI_PERCENTAGE)
                .totalSalary(EXPECTED_SALARY)
                .date(DATE_END)
                .build();
    }
}
