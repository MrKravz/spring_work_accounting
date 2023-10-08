package ru.egar.spring_work_accounting.rate.hour_rate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.egar.spring_work_accounting.employee.Grade;
import ru.egar.spring_work_accounting.employee.Position;

import java.util.Optional;

@Repository
public interface HourRateRepository extends CrudRepository<HourRate, Long> {
    Optional<HourRate> findByPositionAndGrade(Position position, Grade grade);
}
