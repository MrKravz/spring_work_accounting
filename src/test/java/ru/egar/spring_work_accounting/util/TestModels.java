package ru.egar.spring_work_accounting.util;

import ru.egar.spring_work_accounting.define.payment_strategy.ComputePaymentStrategy;
import ru.egar.spring_work_accounting.define.payment_strategy.ComputeTurnoutStrategy;
import ru.egar.spring_work_accounting.employee.*;
import ru.egar.spring_work_accounting.rate.hour_rate.*;
import ru.egar.spring_work_accounting.rate.kpi_rate.*;
import ru.egar.spring_work_accounting.task.*;
import ru.egar.spring_work_accounting.time_sheet.*;
import ru.egar.spring_work_accounting.total.Total;
import ru.egar.spring_work_accounting.total.TotalResponse;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static ru.egar.spring_work_accounting.util.TestConstants.*;

public class TestModels {
    public final static Employee EMPLOYEE;
    public final static EmployeeRequest EMPLOYEE_REQUEST;
    public final static EmployeeResponse EMPLOYEE_RESPONSE;
    public final static EmployeeDto EMPLOYEE_DTO;
    public final static HourRate HOUR_RATE;
    public final static HourRateRequest HOUR_RATE_REQUEST;
    public final static HourRateResponse HOUR_RATE_RESPONSE;
    public final static KpiRate KPI_RATE;
    public final static KpiRateDto KPI_RATE_DTO;
    public final static KpiRateRequest KPI_RATE_REQUEST;
    public final static KpiRateResponse KPI_RATE_RESPONSE;
    public final static TimeSheet TIME_SHEET;
    public final static TimeSheetDto TIME_SHEET_DTO;
    public final static TimeSheetRequest TIME_SHEET_REQUEST;
    public final static TimeSheetResponse TIME_SHEET_RESPONSE;
    public final static Task TASK;
    public final static TaskDto TASK_DTO;
    public final static TaskRequest TASK_REQUEST;
    public final static TaskResponse TASK_RESPONSE;
    public final static Total TOTAL;
    public final static TotalResponse TOTAL_RESPONSE;
    public final static ComputePaymentStrategy EXPECTED_STRATEGY;
    public final static List<TimeSheet> TIME_SHEET_LIST;
    public final static List<TimeStatus> TIME_STATUS_LIST;
    public final static Set<Task> TASKS_SET;
    public final static List<Task> TASKS_LIST;
    public final static List<TaskResponse> TASKS_RESPONSE_LIST;

    static {
        HOUR_RATE = HourRate.builder()
                .id(HOUR_RATE_ID)
                .turnoutRate(TURNOUT_RATE)
                .vacationRate(VACATION_RATE)
                .sickDaysRate(SICK_DAYS_RATE)
                .businessTripRate(BUSINESS_TRIP_RATE)
                .absenceRate(ABSENCE_RATE)
                .overTimeRate(OVER_TIME_RATE)
                .build();
        HOUR_RATE_REQUEST = HourRateRequest.builder()
                .turnoutRate(TURNOUT_RATE)
                .vacationRate(VACATION_RATE)
                .sickDaysRate(SICK_DAYS_RATE)
                .businessTripRate(BUSINESS_TRIP_RATE)
                .absenceRate(ABSENCE_RATE)
                .overTimeRate(OVER_TIME_RATE)
                .build();
        HOUR_RATE_RESPONSE = HourRateResponse.builder()
                .id(HOUR_RATE_ID)
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
        KPI_RATE_REQUEST = KpiRateRequest.builder()
                .agreedSalary(KPI_RATE_AGREED_SALARY)
                .agreedTasksPointQuantity(KPI_RATE_AGREED_TASKS_POINT_QUANTITY)
                .build();
        KPI_RATE_RESPONSE = KpiRateResponse.builder()
                .id(KPI_RATE_ID)
                .agreedSalary(KPI_RATE_AGREED_SALARY)
                .agreedTasksPointQuantity(KPI_RATE_AGREED_TASKS_POINT_QUANTITY)
                .build();
        KPI_RATE_DTO = KpiRateDto.builder()
                .id(KPI_RATE_ID)
                .agreedSalary(KPI_RATE_AGREED_SALARY)
                .agreedTasksPointQuantity(KPI_RATE_AGREED_TASKS_POINT_QUANTITY)
                .build();
        TIME_SHEET = TimeSheet.builder()
                .id(TIME_SHEET_ID)
                .timeSpan(EXPECTED_TIME)
                .timeStatus(TIME_STATUS_TURNOUT)
                .date(LocalDate.now())
                .build();
        TIME_SHEET_DTO = TimeSheetDto.builder()
                .id(TIME_SHEET_ID)
                .timeSpan(EXPECTED_TIME)
                .timeStatus(TIME_STATUS_TURNOUT)
                .date(LocalDate.now())
                .build();
        TIME_SHEET_REQUEST = TimeSheetRequest.builder()
                .timeSpan(EXPECTED_TIME)
                .timeStatus(TIME_STATUS_TURNOUT)
                .build();
        TIME_SHEET_RESPONSE = TimeSheetResponse.builder()
                .id(TIME_SHEET_ID)
                .timeSpan(EXPECTED_TIME)
                .timeStatus(TIME_STATUS_TURNOUT)
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
        TASK_DTO = TaskDto.builder()
                .id(TASK_ID)
                .shortName(TASK_NAME)
                .description(TASK_DESCRIPTION)
                .taskPointsNumber(TASK_POINTS_NUMBER)
                .taskStatus(TASK_STATUS_FINISHED)
                .dateTimeStart(DATE_TIME_START)
                .dateTimeEnd(DATE_TIME_END)
                .build();
        TASK_REQUEST = TaskRequest.builder()
                .shortName(TASK_NAME)
                .description(TASK_DESCRIPTION)
                .taskPointsNumber(TASK_POINTS_NUMBER)
                .dateTimeStart(DATE_TIME_START)
                .dateTimeEnd(DATE_TIME_END)
                .build();
        TASK_RESPONSE = TaskResponse.builder()
                .id(TASK_ID)
                .shortName(TASK_NAME)
                .description(TASK_DESCRIPTION)
                .taskPointsNumber(TASK_POINTS_NUMBER)
                .taskStatus(TASK_STATUS_FINISHED)
                .dateTimeStart(DATE_TIME_START)
                .dateTimeEnd(DATE_TIME_END)
                .build();
        TIME_SHEET_LIST = Collections.singletonList(TIME_SHEET);
        TASKS_SET = Collections.singleton(TASK);
        TASKS_LIST = Collections.singletonList(TASK);
        TASKS_RESPONSE_LIST = Collections.singletonList(TASK_RESPONSE);
        EMPLOYEE = Employee.builder()
                .id(EMPLOYEE_ID)
                .name(EMPLOYEE_NAME)
                .dateOfBirthDay(DATE_OF_BIRTHDAY)
                .employeePosition(EMPLOYEE_POSITION_DEVELOPER)
                .employeeGrade(EMPLOYEE_GRADE_JUNIOR)
                .paymentSystem(PAYMENT_SYSTEM_KPI)
                .hourRate(null)
                .kpiRate(KPI_RATE)
                .tasks(TASKS_LIST)
                .timeSheets(TIME_SHEET_LIST)
                .paymentSystem(PAYMENT_SYSTEM_KPI)
                .totals(Collections.emptyList())
                .build();
        EMPLOYEE_REQUEST = EmployeeRequest.builder()
                .name(EMPLOYEE_NAME)
                .dateOfBirthDay(DATE_OF_BIRTHDAY)
                .employeePosition(EMPLOYEE_POSITION_DEVELOPER)
                .employeeGrade(EMPLOYEE_GRADE_JUNIOR)
                .paymentSystem(PAYMENT_SYSTEM_KPI)
                .build();
        EMPLOYEE_RESPONSE = EmployeeResponse.builder()
                .id(EMPLOYEE_ID)
                .name(EMPLOYEE_NAME)
                .dateOfBirthDay(DATE_OF_BIRTHDAY)
                .employeePosition(EMPLOYEE_POSITION_DEVELOPER)
                .employeeGrade(EMPLOYEE_GRADE_JUNIOR)
                .paymentSystem(PAYMENT_SYSTEM_KPI)
                .build();
        EMPLOYEE_DTO = EmployeeDto.builder()
                .id(EMPLOYEE_ID)
                .name(EMPLOYEE_NAME)
                .dateOfBirthDay(DATE_OF_BIRTHDAY)
                .employeePosition(EMPLOYEE_POSITION_DEVELOPER)
                .employeeGrade(EMPLOYEE_GRADE_JUNIOR)
                .paymentSystem(PAYMENT_SYSTEM_KPI)
                .kpiRate(KPI_RATE_DTO)
                .hourRate(null)
                .build();
        EXPECTED_STRATEGY = new ComputeTurnoutStrategy();
        TIME_STATUS_LIST = Collections.singletonList(TIME_STATUS_TURNOUT);
        TOTAL = Total.builder()
                .id(TOTAL_ID)
                .totalWorkedTime(EXPECTED_TIME)
                .kpiPercentage(KPI_PERCENTAGE)
                .totalSalary(EXPECTED_SALARY)
                .date(DATE_END)
                .employee(EMPLOYEE)
                .build();
        TOTAL_RESPONSE = TotalResponse.builder()
                .id(TOTAL_ID)
                .totalWorkedTime(EXPECTED_TIME)
                .kpiPercentage(KPI_PERCENTAGE)
                .totalSalary(EXPECTED_SALARY)
                .date(DATE_END)
                .employee(EMPLOYEE_DTO)
                .build();
    }
}
