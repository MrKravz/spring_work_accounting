package ru.egar.spring_work_accounting.total;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.egar.spring_work_accounting.employee.Employee;

import java.util.Optional;

@Repository
public interface TotalRepository extends JpaRepository<Total, Long> {
    Optional<Total> findTopByEmployeeOrderByIdDesc(Employee employee);
}
