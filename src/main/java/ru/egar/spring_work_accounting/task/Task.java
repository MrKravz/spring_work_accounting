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

    @Column()
    private String shortName;

    @Column()
    private String description;

    @Column()
    private LocalDateTime dateTimeStart;

    @Column()
    private LocalDateTime dateTimeEnd;

    @ManyToOne
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "id"
    )
    @ToString.Exclude
    private Employee employee;
}
