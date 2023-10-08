package ru.egar.spring_work_accounting.rate.hour_rate;

import jakarta.persistence.*;
import lombok.*;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.employee.Grade;
import ru.egar.spring_work_accounting.employee.Position;

import java.util.List;

@Entity
@Table(name = "hour_rates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HourRate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private Position position;

    @Column(name = "grade")
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @OneToMany(mappedBy = "hourRate")
    @ToString.Exclude
    private List<Employee> employees;

}
