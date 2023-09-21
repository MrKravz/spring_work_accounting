package ru.egar.spring_work_accounting.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.egar.spring_work_accounting.rate.Rate;
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

    @OneToOne(mappedBy = "employee")
    private Rate rate;

    @OneToMany(mappedBy = "employee")
    private Set<Task> tasks;

    @OneToMany(mappedBy = "employee")
    private Set<TimeSheet> timeSheets;

    @OneToMany(mappedBy = "employee")
    private Set<Total> totals;
}
