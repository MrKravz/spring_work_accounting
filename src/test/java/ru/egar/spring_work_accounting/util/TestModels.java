package ru.egar.spring_work_accounting.util;

import ru.egar.spring_work_accounting.define.payment_strategy.ComputePaymentStrategy;
import ru.egar.spring_work_accounting.define.payment_strategy.ComputeTurnoutStrategy;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.kpi_rate.KpiRate;
import ru.egar.spring_work_accounting.rate.PaymentSystem;
import ru.egar.spring_work_accounting.rate.Rate;
import ru.egar.spring_work_accounting.task.Task;
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
    public final static KpiRate KPI_RATE;
    public final static TimeSheet TIME_SHEET;
    public final static Task TASK;
    public final static Total TOTAL;
    public final static ComputePaymentStrategy EXPECTED_STRATEGY;
    public final static Set<TimeSheet> TIME_SHEETS;
    public final static Set<TimeStatus> DISTINCT_TIME_STATUSES;
    public final static Set<Task> TASKS;

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
        KPI_RATE = KpiRate.builder()
                .id(KPI_RATE_ID)
                .agreedSalary(KPI_RATE_AGREED_SALARY)
                .agreedTasksPointQuantity(KPI_RATE_AGREED_TASKS_POINT_QUANTITY)
                .build();
        TIME_SHEET = TimeSheet.builder()
                .id(TIME_SHEET_ID)
                .timeSpan(EXPECTED_TIME)
                .timeStatus(TimeStatus.Turnout)
                .date(LocalDate.now())
                .build();
        TASK = Task.builder()
                .id(TASK_ID)
                .shortName(TASK_NAME)
                .description(TASK_DESCRIPTION)
                .taskPointsNumber(TASK_POINTS_NUMBER)
                .taskStatus(TASK_STATUS_FINISHED)
                .dateTimeStart(DATE_TIME_START)
                .dateTimeEnd(DATE_TIME_END)
                .build();
        TIME_SHEETS = Collections.singleton(TIME_SHEET);
        TASKS = Collections.singleton(TASK);
        EMPLOYEE = Employee.builder()
                .id(EMPLOYEE_ID)
                .name(EMPLOYEE_NAME)
                .dateOfBirthDay(DATE_OF_BIRTHDAY)
                .rate(RATE)
                .kpiRate(KPI_RATE)
                .tasks(TASKS)
                .timeSheets(TIME_SHEETS)
                .paymentSystem(PaymentSystem.KPI_Payment)
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
