package ru.egar.spring_work_accounting.rate.kpi_rate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpiRateRepository extends CrudRepository<KpiRate, Long> {
}
