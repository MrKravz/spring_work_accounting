package ru.egar.spring_work_accounting.rate.kpi_rate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.egar.spring_work_accounting.employee.Grade;
import ru.egar.spring_work_accounting.employee.Position;

import java.util.Optional;

@Repository
public interface KpiRateRepository extends CrudRepository<KpiRate, Long> {
    Optional<KpiRate> findByPositionAndGrade(Position position, Grade grade);
}
