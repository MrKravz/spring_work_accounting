package ru.egar.spring_work_accounting.rate.kpi_rate;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.employee.Grade;
import ru.egar.spring_work_accounting.employee.Position;

import java.util.List;

@Entity
@Table(name = "kpi_rates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KpiRate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "agreed_salary")
    private Float agreedSalary;

    @Column(name = "agreed_tasks_point_quantity")
    private Integer agreedTasksPointQuantity;

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private Position position;

    @Column(name = "grade")
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "kpiRate", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ToString.Exclude
    private List<Employee> employees;

}
