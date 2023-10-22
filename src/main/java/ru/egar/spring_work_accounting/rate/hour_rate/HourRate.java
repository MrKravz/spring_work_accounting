package ru.egar.spring_work_accounting.rate.hour_rate;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
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
    private Integer turnoutRate;

    @Column(name = "vacation_rate")
    private Integer vacationRate;

    @Column(name = "sick_days_rate")
    private Integer sickDaysRate;

    @Column(name = "business_trip_rate")
    private Integer businessTripRate;

    @Column(name = "absence_rate")
    private Integer absenceRate;

    @Column(name = "over_time_rate")
    private Integer overTimeRate;

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private Position position;

    @Column(name = "grade")
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "hourRate", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ToString.Exclude
    private List<Employee> employees;

}
