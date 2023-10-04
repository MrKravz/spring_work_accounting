package ru.egar.spring_work_accounting.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.egar.spring_work_accounting.rate.hour_rate.HourRate;
import ru.egar.spring_work_accounting.rate.hour_rate.PaymentSystem;
import ru.egar.spring_work_accounting.rate.kpi_rate.KpiRate;
import ru.egar.spring_work_accounting.task.Task;
import ru.egar.spring_work_accounting.time_sheet.TimeSheet;
import ru.egar.spring_work_accounting.total.Total;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birthday")
    private LocalDate dateOfBirthDay;

    @Column(name = "employee_position")
    @Enumerated(EnumType.STRING)
    private Position employeePosition;

    @Column(name = "employee_grade")
    @Enumerated(EnumType.STRING)
    private Grade employeeGrade;

    @Column(name = "payment_system")
    @Enumerated(EnumType.STRING)
    private PaymentSystem paymentSystem;

    @OneToOne(mappedBy = "employee")
    private HourRate hourRate;

    @OneToOne(mappedBy = "employee")
    private KpiRate kpiRate;

    @OneToMany(mappedBy = "employee")
    private List<Task> tasks;

    @OneToMany(mappedBy = "employee")
    private List<TimeSheet> timeSheets;

    @OneToMany(mappedBy = "employee")
    private List<Total> totals;

}
