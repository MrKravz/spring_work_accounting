package ru.egar.spring_work_accounting.task;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import ru.egar.spring_work_accounting.employee.Employee;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "description")
    private String description;

    @Column(name = "date_time_start")
    private LocalDateTime dateTimeStart;

    @Column(name = "date_time_end")
    private LocalDateTime dateTimeEnd;

    @Column(name = "task_points_number")
    private int taskPointsNumber;

    @ManyToOne
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "id"
    )
    @ToString.Exclude
    private Employee employee;
}
