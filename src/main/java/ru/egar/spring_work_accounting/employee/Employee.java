package ru.egar.spring_work_accounting.employee;

import jakarta.persistence.*;
import lombok.*;
import ru.egar.spring_work_accounting.kpi_rate.KpiRate;
import ru.egar.spring_work_accounting.hour_rate.PaymentSystem;
import ru.egar.spring_work_accounting.hour_rate.HourRate;
import ru.egar.spring_work_accounting.task.Task;
import ru.egar.spring_work_accounting.time_sheet.TimeSheet;
import ru.egar.spring_work_accounting.total.Total;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birthday")
    private LocalDate dateOfBirthDay;

    @Column(name = "date_of_birthday")
    @Enumerated(EnumType.STRING)
    private Position employeePosition;

    @Column(name = "date_of_birthday")
    @Enumerated(EnumType.STRING)
    private Grade employeeGrade;

    @Column(name = "date_of_birthday")
    @Enumerated(EnumType.STRING)
    private PaymentSystem paymentSystem;

    @OneToOne(mappedBy = "employee")
    private HourRate hourRate;

    @OneToOne(mappedBy = "employee")
    private KpiRate kpiRate;

    @OneToMany(mappedBy = "employee")
    private Set<Task> tasks;

    @OneToMany(mappedBy = "employee")
    private Set<TimeSheet> timeSheets;

    @OneToMany(mappedBy = "employee")
    private Set<Total> totals;
}
