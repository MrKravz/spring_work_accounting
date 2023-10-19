package ru.egar.spring_work_accounting.total;

import jakarta.persistence.*;
import lombok.*;
import ru.egar.spring_work_accounting.bonus.Bonus;
import ru.egar.spring_work_accounting.employee.Employee;

import java.time.LocalDate;

@Entity
@Table(name = "totals")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Total {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_worked_time")
    private Integer totalWorkedTime;

    @Column(name = "kpi_percentage")
    private Integer kpiPercentage;

    @Column(name = "total_salary")
    private Float totalSalary;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinTable(
            name = "employees_totals",
            joinColumns = @JoinColumn(name = "total_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    @ToString.Exclude
    private Employee employee;

    @OneToOne
    @JoinColumn(
            name = "bonus_id",
            referencedColumnName = "id"
    )
    private Bonus bonus;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public Total(int totalWorkedTime, int kpiPercentage, float totalSalary, LocalDate date, Employee employee) {
        this.totalWorkedTime = totalWorkedTime;
        this.kpiPercentage = kpiPercentage;
        this.totalSalary = totalSalary;
        this.date = date;
        this.employee = employee;
    }
}
