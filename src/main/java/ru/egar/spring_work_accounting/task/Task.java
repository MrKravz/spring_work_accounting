package ru.egar.spring_work_accounting.task;

import jakarta.persistence.*;
import lombok.*;
import ru.egar.spring_work_accounting.employee.Employee;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "description")
    private String description;

    @Column(name = "date_time_start")
    private LocalDateTime dateTimeStart;

    @Column(name = "date_time_end")
    private LocalDateTime dateTimeEnd;

    @Column(name = "task_points_number")
    private Integer taskPointsNumber;

    @Column(name = "task_status")
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @ManyToOne
    @JoinTable(
            name = "employees_tasks",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    @ToString.Exclude
    private Employee employee;

}
