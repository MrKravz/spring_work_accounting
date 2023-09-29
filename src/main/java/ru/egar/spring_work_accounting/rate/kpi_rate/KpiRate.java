package ru.egar.spring_work_accounting.rate.kpi_rate;

import jakarta.persistence.*;
import lombok.*;
import ru.egar.spring_work_accounting.employee.Employee;

import java.util.UUID;

@Entity
@Table(name = "kpi_rates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KpiRate {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "agreed_salary")
    private float agreedSalary;

    @Column(name = "agreed_tasks_point_quantity")
    private int agreedTasksPointQuantity;

    @OneToOne
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "id"
    )
    @ToString.Exclude
    private Employee employee;

}
