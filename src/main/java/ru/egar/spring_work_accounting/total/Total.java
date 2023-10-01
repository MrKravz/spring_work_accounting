package ru.egar.spring_work_accounting.total;

import jakarta.persistence.*;
import lombok.*;
import ru.egar.spring_work_accounting.employee.Employee;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "totals")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Total {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "total_worked_time")
    private int totalWorkedTime;

    @Column(name = "kpi_percentage")
    private int kpiPercentage;

    @Column(name = "total_salary")
    private float totalSalary;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "id"
    )
    @ToString.Exclude
    private Employee employee;

}
