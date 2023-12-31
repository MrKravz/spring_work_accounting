package ru.egar.spring_work_accounting.time_sheet;

import jakarta.persistence.*;
import lombok.*;
import ru.egar.spring_work_accounting.employee.Employee;

import java.time.LocalDate;

@Entity
@Table(name = "time_sheets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeSheet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time_span")
    private Integer timeSpan;

    @Column(name = "time_status")
    @Enumerated(EnumType.STRING)
    private TimeStatus timeStatus;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinTable(
            name = "employees_time_sheets",
            joinColumns = @JoinColumn(name = "time_sheet_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    @ToString.Exclude
    private Employee employee;

}
