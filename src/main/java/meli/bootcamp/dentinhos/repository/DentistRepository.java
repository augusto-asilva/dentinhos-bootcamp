package meli.bootcamp.dentinhos.repository;

import meli.bootcamp.dentinhos.domain.Dentist;
import meli.bootcamp.dentinhos.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Integer> {
    @Query(value = "Select u.name from user u inner join diaries d on u.id_user = d.id_dentist Inner join turns t on d.id_diary = t.id_diary And date(d.start_time) = t.days And t.days = date(:data) Group by u.name having count(t.id_turn) >=3;", nativeQuery = true)
    List<String> dentists(@Param(value = "data") Date data);
}
