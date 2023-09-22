package ru.egar.spring_work_accounting.rate;

import jakarta.persistence.*;
import lombok.*;
import ru.egar.spring_work_accounting.employee.Employee;

import java.util.UUID;

@Entity
@Table(name = "hour_rates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rate {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "turnout_rate")
    private float turnoutRate;

    @Column(name = "vacation_rate")
    private float vacationRate;

    @Column(name = "sick_days_rate")
    private float sickDaysRate;

    @Column(name = "business_trip_rate")
    private float businessTripRate;

    @Column(name = "absence_rate")
    private float absenceRate;

    @Column(name = "over_time_rate")
    private float overTimeRate;

    @OneToOne
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "id"
    )
    @ToString.Exclude
    private Employee employee;
}
