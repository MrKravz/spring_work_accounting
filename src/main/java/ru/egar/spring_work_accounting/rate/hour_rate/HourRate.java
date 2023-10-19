package ru.egar.spring_work_accounting.rate.hour_rate;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
    private Long id;

    @Column(name = "turnout_rate")
    private Float turnoutRate;

    @Column(name = "vacation_rate")
    private Float vacationRate;

    @Column(name = "sick_days_rate")
    private Float sickDaysRate;

    @Column(name = "business_trip_rate")
    private Float businessTripRate;

    @Column(name = "absence_rate")
    private Float absenceRate;

    @Column(name = "over_time_rate")
    private Float overTimeRate;

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private Position position;

    @Column(name = "grade")
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @OneToMany(mappedBy = "hourRate")
    @ToString.Exclude
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private List<Employee> employees;

}
