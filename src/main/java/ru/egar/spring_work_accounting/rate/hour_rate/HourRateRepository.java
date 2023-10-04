package ru.egar.spring_work_accounting.rate.hour_rate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HourRateRepository extends CrudRepository<HourRate, Long> {
}
