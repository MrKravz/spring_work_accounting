package ru.egar.spring_work_accounting.bonus;

import jakarta.persistence.*;
import lombok.*;
import ru.egar.spring_work_accounting.total.Total;

@Entity
@Table(name = "bonuses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bonus {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bonus_salary")
    private Float bonusSalary;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @OneToOne(mappedBy = "bonus")
    @ToString.Exclude
    private Total total;

}
